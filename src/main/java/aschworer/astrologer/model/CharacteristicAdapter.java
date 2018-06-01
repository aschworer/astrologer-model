package aschworer.astrologer.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.TextNode;
import com.google.gson.*;

import java.io.IOException;
import java.lang.reflect.Type;

public final class CharacteristicAdapter<T> extends StdDeserializer<T> implements JsonDeserializer<T> {

    public CharacteristicAdapter() {
        super(Characteristic.class);
    }

    public CharacteristicAdapter(Class<?> vc) {
        super(vc);
    }

    public CharacteristicAdapter(JavaType valueType) {
        super(valueType);
    }

    public CharacteristicAdapter(StdDeserializer<?> src) {
        super(src);
    }

    public T deserialize(JsonElement elem, Type interfaceType, JsonDeserializationContext context) throws JsonParseException {
        final JsonPrimitive wrapper = (JsonPrimitive) elem;
        Type actualType = Planet.class;
        String asString = elem.getAsString();
        if (Planet.getByString(asString) == null) {
            actualType = House.class;
        }
        try {
            return context.deserialize(wrapper, actualType);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public T deserialize(com.fasterxml.jackson.core.JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        ObjectMapper mapper = (ObjectMapper) jsonParser.getCodec();
        TextNode node = mapper.readTree(jsonParser);

        String asString = node.asText();
        Type actualType = Planet.class;
        if (Planet.getByString(asString) == null) {
            actualType = House.class;
        }
        try {
            return mapper.treeToValue(node, (Class<T>) actualType);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}