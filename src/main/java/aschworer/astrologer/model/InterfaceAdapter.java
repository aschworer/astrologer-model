package aschworer.astrologer.model;

import com.google.gson.*;

import java.lang.reflect.Type;

public final class InterfaceAdapter<T> implements JsonDeserializer<T> {
    public T deserialize(JsonElement elem, Type interfaceType, JsonDeserializationContext context) throws JsonParseException {

        String asString = elem.getAsString();
        final JsonPrimitive wrapper = (JsonPrimitive) elem;
        Characteristic characteristic;
        Planet planet = Planet.getByString(asString);
        if (planet != null) {
            characteristic = planet;
        } else {
//            characteristic = House.getByString(elem.getAsString());//beware of a bug here
            characteristic = House.X;
        }
        try {
            final Type actualType = characteristic.getClass();
            return context.deserialize(wrapper, actualType);
        } catch (Exception e) {
            System.err.println(e);//todo
        }
        return null;
    }
}