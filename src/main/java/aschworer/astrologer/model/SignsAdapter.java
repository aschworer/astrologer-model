package aschworer.astrologer.model;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SignsAdapter implements JsonDeserializer<Sign[]>, JsonSerializer<Sign[]> {
    public Sign[] deserialize(JsonElement elem, Type interfaceType, JsonDeserializationContext context) throws JsonParseException {
        List<Sign> signs = new ArrayList<>();
        if (elem.getAsString().contains("-")) {
            for (String signStr : elem.getAsString().split("-")) {
                signs.add(Sign.getByString(signStr));
            }
        } else {
            signs = Collections.singletonList(Sign.getByString(elem.getAsString()));
        }
        Sign[] signsArray = signs.toArray(new Sign[signs.size()]);
        try {
            return signsArray;
        } catch (Exception e) {
            System.err.println(e);//todo
        }
        return null;
    }

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