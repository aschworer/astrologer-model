package aschworer.astrologer.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.google.gson.*;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SignsAdapter extends StdSerializer<Sign[]> implements JsonDeserializer<Sign[]>, JsonSerializer<Sign[]> {

    public SignsAdapter() {
        this(null);
    }

    private SignsAdapter(Class<Sign[]> t) {
        super(t);
    }

    public Sign[] deserialize(JsonElement elem, Type interfaceType, JsonDeserializationContext context) throws JsonParseException {
        return signsFromString(elem.getAsString());
    }

    private static Sign[] signsFromString(String asString) {
        List<Sign> signs = new ArrayList<>();
        if (asString.contains("-")) {
            for (String signStr : asString.split("-")) {
                signs.add(Sign.getByString(signStr));
            }
        } else {
            signs = Collections.singletonList(Sign.getByString(asString));
        }
        return signs.toArray(new Sign[0]);
    }

    @Override
    public JsonElement serialize(Sign[] signs, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(signToString(signs));
    }

    @Override
    public void serialize(Sign[] signs, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeString(signToString(signs));
        jsonGenerator.writeEndObject();
    }

    private String signToString(Sign[] signs) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (Sign sign : signs) {
            if (i != 0) stringBuilder.append("-");
            stringBuilder.append(sign);
            i++;
        }
        return stringBuilder.toString();
    }

    public final static class SignsDeserializer extends StdDeserializer<Sign[]> {

        public SignsDeserializer() {
            this(null);
        }

        private SignsDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public Sign[] deserialize(com.fasterxml.jackson.core.JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            JsonNode node = jsonParser.getCodec().readTree(jsonParser);
            return signsFromString(node.asText());
        }

    }
}

