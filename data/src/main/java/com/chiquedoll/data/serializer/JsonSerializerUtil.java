package com.chiquedoll.data.serializer;

import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by super-zuo on 17-2-9.
 */
@Singleton
public class JsonSerializerUtil {

    private final Gson gson = new Gson();

    @Inject
    JsonSerializerUtil(){}

    /**
     * Serialize an object to Json.
     *
     * @param object to serialize.
     */
    public String serialize(Object object, Class clazz) {
        return gson.toJson(object, clazz);
    }

    /**
     * Deserialize a json representation of an object.
     *
     * @param string A json string to deserialize.
     */
    public <T> T deserializeToObject(String string, Class<T> clazz) {
        return gson.fromJson(string, clazz);
    }

    /**
     * Deserialize a json to a arrayList
     *
     */
    public <T> ArrayList<T>  deserializeToList(String json,Class<T> clazz){
        Type type = new ListParameterizedType(clazz);
        return gson.fromJson(json, type);
    }

}
