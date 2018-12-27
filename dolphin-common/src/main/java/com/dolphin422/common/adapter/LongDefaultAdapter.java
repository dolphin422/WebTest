package com.dolphin422.common.adapter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonSyntaxException;
import java.lang.reflect.Type;

/**
 * @Description: JSON转换中 int 默认转为0
 * @author: DamonJT WIN
 * @createDate: 2018.12.27 16:48
 */
public class LongDefaultAdapter implements JsonSerializer<Long>, JsonDeserializer<Long> {

    @Override
    public Long deserialize(JsonElement jsonElement, Type type,
        JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        try {
            if (jsonElement.getAsString().equals("") || jsonElement.getAsString().equals("null")) {
                return 0L;
            }
        } catch (Exception ignore) {
            //ignore
        }
        try {
            return jsonElement.getAsLong();
        } catch (NumberFormatException e) {
            throw new JsonSyntaxException(e);
        }
    }

    @Override
    public JsonElement serialize(Long lg, Type type,
        JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(lg);
    }
}
