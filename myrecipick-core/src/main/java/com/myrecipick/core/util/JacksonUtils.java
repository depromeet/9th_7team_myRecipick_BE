package com.myrecipick.core.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.Map;
import java.util.Optional;

public class JacksonUtils {

    private static final ObjectMapper mapper;
    static {
        mapper = new ObjectMapper();
    }

    private JacksonUtils() {
    }

    public static ObjectMapper getMapper() {
        return mapper;
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        return readValue(json, clazz);
    }

    public static <T> T fromJson(String json, TypeReference<T> typeReference) {
        return readValue(json, typeReference);
    }

    public static <T> T fromMap(Map<String, Object> map, Class<T> clazz) {
        return mapper.convertValue(map, clazz);
    }

    private static <T> T readValue(String json, TypeReference<T> typeReference) {
        try {
            return mapper.readValue(json, typeReference);
        } catch (IOException e) {
            Class<T> clazz = converter(typeReference);
            try {
                return clazz.getDeclaredConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e1) {
                return null;
            }
        }
    }

    public static <T> Class<T> converter(TypeReference<T> typeReference) {
        return (Class<T>) ((ParameterizedType) typeReference.getType()).getRawType();
    }

    private static <T> T readValue(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (IOException e) {
            try {
                return clazz.getDeclaredConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e1) {
                e1.printStackTrace();
                return null;
            }
        }
    }

    public static String toJson(Object vo) {
        try {
            return mapper.writeValueAsString(vo);
        } catch (JsonProcessingException e) {
            return "{}";
        }
    }

    public static boolean equals(String json1, String json2) {
        try {
            return mapper.readTree(json1).equals(mapper.readTree(json2));
        } catch (Exception e) {
            return false;
        }
    }

    public static String getValueAsString(String key, String source) {
        try {
            JsonNode root = mapper.readTree(source);
            return Optional.ofNullable(root.get(key))
                .map(JsonNode::asText)
                .orElse("");
        } catch (IOException e) {
            return "";
        }
    }
}
