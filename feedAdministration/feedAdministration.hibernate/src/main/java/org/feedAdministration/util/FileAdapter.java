package org.feedAdministration.util;

import java.lang.reflect.Type;

import org.feedAdministration.hibernate.domain.File;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class FileAdapter implements JsonSerializer<File> {

    @Override
    public JsonElement serialize(File file, Type type, JsonSerializationContext jsc) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", file.getId());
        jsonObject.addProperty("name", file.getName());
        jsonObject.addProperty("status", file.getStatus());
        jsonObject.addProperty("message", file.getMessage());
        jsonObject.addProperty("date", file.getDate().toString());
        return jsonObject;      
    }
}