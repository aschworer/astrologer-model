package aschworer.astrologer.model;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public final class SignSerializer implements JsonSerializer<Sign[]> {

    @Override
    public JsonElement serialize(Sign[] signs, Type type, JsonSerializationContext jsonSerializationContext) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (Sign sign : signs) {
            if (i != 0) stringBuilder.append("-");
            stringBuilder.append(sign);
            i++;
        }
        return new JsonPrimitive(stringBuilder.toString());
    }
}