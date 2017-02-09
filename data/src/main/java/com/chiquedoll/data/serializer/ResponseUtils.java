package com.chiquedoll.data.serializer;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by super-zuo on 17-2-9.
 */

public class ResponseUtils {
    private Gson gson = new Gson();
    private JsonObject jsonObject;

    public ResponseUtils(String jsonStr) {
        String trimJsonStr = "";
        if (jsonStr != null) {
            trimJsonStr = jsonStr.trim();
        }
        JsonReader reader = new JsonReader(new StringReader(trimJsonStr));
        reader.setLenient(true);
        try {
            jsonObject = gson.fromJson(reader, JsonObject.class);
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject = null;
        }
    }

    public boolean isSuccess() {
        if (jsonObject == null || jsonObject.get("success") == null) {
            return false;
        }
        return jsonObject.get("success").getAsBoolean();
    }

    public boolean isExipired() {
        if (jsonObject == null || jsonObject.get("code") == null) {
            return true;
        }
        return jsonObject.get("code").getAsInt() == 600;
    }

    /**
     * Deserialize a json to a arrayList
     */
    public <T> ArrayList<T> deserializeToList(Class<T> clazz) {
        if (jsonObject == null || jsonObject.get("result") == null) {
            return null;
        }
        JsonReader reader = new JsonReader(new StringReader(jsonObject.get("result").toString()));
        reader.setLenient(true);
        try {
            Type type = new ListParameterizedType(clazz);
            return gson.fromJson(reader, type);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("JsonFormatError", jsonObject.get("result").toString());
            return null;
        }
    }

    /**
     * Deserialize a json to a object
     */
    public <T> T deserializeToObject(Class<T> clazz) {
        if (jsonObject == null || jsonObject.get("result") == null) {
            return null;
        }
        JsonReader reader = new JsonReader(new StringReader(jsonObject.get("result").toString()));
        reader.setLenient(true);
        try {
            return gson.fromJson(reader, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
