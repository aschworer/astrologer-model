package aschworer.astrologer.model;

import com.google.gson.*;

import java.lang.reflect.Type;

public final class InterfaceAdapter<T> implements JsonDeserializer<T> {
    public T deserialize(JsonElement elem, Type interfaceType, JsonDeserializationContext context) throws JsonParseException {

        String asString = elem.getAsString();
        final JsonPrimitive wrapper = (JsonPrimitive) elem;
        Type actualType = Planet.class;
        if (Planet.getByString(asString) == null) {
            actualType = House.class;
        }
        try {
            return context.deserialize(wrapper, actualType);
        } catch (Exception e) {
            System.err.println(e);//todo
        }
        return null;
    }
}