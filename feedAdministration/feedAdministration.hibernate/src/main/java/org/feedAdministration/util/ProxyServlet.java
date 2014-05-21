package org.feedAdministration.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class ProxyServlet
 */
public class ProxyServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * Logger Log4J.
     */
    static private Logger staticLogger = Logger.getLogger(ProxyServlet.class);

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProxyServlet() {

	super();
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	URL url = null;
	boolean isVega = true;

	String urlParameter = request.getParameter("url");
	if (urlParameter != null) {
	    url = new URL(urlParameter);
	} else {
	    String queryString = request.getQueryString();
	    String path = request.getPathInfo();
	    String serverPath = null;
	    for (Enumeration e = getInitParameterNames(); e.hasMoreElements();) {
		String paramName = e.nextElement().toString();
		if (path.startsWith(paramName)) {
		    isVega = paramName.equals("/VEGA");
		    serverPath = path.replace(paramName, getInitParameter(paramName));
		}
	    }

	    url = new URL(serverPath + "?" + queryString);
	}

	HttpURLConnection con = null;
	boolean foundRedirect = false;
	do {

	    con = (HttpURLConnection) url.openConnection();
	    con.setRequestMethod("GET");
	    con.setDoOutput(true);
	    con.setDoInput(true);
	    con.setUseCaches(false);
	    con.setInstanceFollowRedirects(false);
	    con.setAllowUserInteraction(false);
	    for (Enumeration e = request.getHeaderNames(); e.hasMoreElements();) {
		String headerName = e.nextElement().toString();
		con.setRequestProperty(headerName, request.getHeader(headerName));
	    }

	    // Hack! Set the password...
	    if (isVega) {
		String passwdstring = "vega:w4CqiJcw";
		String encoding = DatatypeConverter.printBase64Binary(passwdstring.getBytes());
		con.setRequestProperty("Authorization", "Basic " + encoding);
	    }

	    con.connect();

	    int statusCode = con.getResponseCode();

	    if (statusCode == 302) {
		// follow redirects
		String location = con.getHeaderField("Location");
		url = new URL(location);
		foundRedirect = true;
	    } else {
		response.setStatus(statusCode);
		foundRedirect = false;
	    }
	}
	while (foundRedirect);

	for (Iterator i = con.getHeaderFields().entrySet().iterator(); i.hasNext();) {
	    Map.Entry mapEntry = (Map.Entry) i.next();
	    if (mapEntry.getKey() != null) {
		String key = mapEntry.getKey().toString();

		// Need to ignore Transfer-encoding, don't know why but it is
		// needed to work on the server
		if (!key.equalsIgnoreCase("Transfer-Encoding")) {
		    List entries = (List) mapEntry.getValue();
		    for (int n = 0; n < entries.size(); n++)
			response.addHeader(key, entries.get(n).toString());
		}
	    }
	}

	byte[] bytes = new byte[1024];
	int result = 0;
	InputStream webToProxyStream = con.getInputStream();
	OutputStream proxyToClientStream = response.getOutputStream();
	while (result >= 0) {
	    result = webToProxyStream.read(bytes);
	    if (result >= 0)
		proxyToClientStream.write(bytes, 0, result);
	}
	proxyToClientStream.flush();
	proxyToClientStream.close();
	webToProxyStream.close();
	con.disconnect();
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	// TODO Auto-generated method stub
    }

}
