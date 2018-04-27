package aschworer.astrologer.model;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SignDeserializer implements JsonDeserializer<Sign[]> {
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
}