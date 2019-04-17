package com.dolphin422.custom;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import springfox.documentation.spring.web.json.Json;

/**
 * @author DamonJT WIN
 * @description:
 * @createDate: 2019.04.17 14:34
 */
public class SpringfoxJsonToGsonAdapter implements JsonSerializer<Json> {

    @Override
    public JsonElement serialize(Json json, Type type, JsonSerializationContext jsonSerializationContext) {
        final JsonParser parser = new JsonParser();
        return parser.parse(json.value());
    }
}
