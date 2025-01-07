package org.BBC.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import java.io.File;
/**
 * Utility class for JSON serialization and deserialization.
 */
public class JsonUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Converts an object to a JSON string.
     *
     * @param object the object to be serialized
     * @return the JSON string representation of the object
     */
    @SneakyThrows
    public static String toJson(Object object) {
        return objectMapper.writeValueAsString(object);
    }

    /**
     * Converts a JSON string to an object of the specified type.
     *
     * @param json  the JSON string to be deserialized
     * @param clazz the target class type
     * @param <T>   the type of the object
     * @return an object of the specified type
     */
    @SneakyThrows
    public static <T> T fromJson(String json, Class<T> clazz) {
        return objectMapper.readValue(json, clazz);
    }

    /**
     * Retrieves a mock response from a JSON file as a JSON string.
     *
     * @param clazz    the target class type
     * @param response the name of the mock JSON file (without extension)
     * @param <T>      the type of the object
     * @return the JSON string representation of the mock response
     */
    @SneakyThrows
    public static <T> Object getMockResponse(Class<T> clazz, String response) {
        File jsonFile = new File("src/main/resources/mock-responses/" + response + ".json");
        return toJson(objectMapper.readValue(jsonFile, clazz));
    }
}
