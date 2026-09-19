package Misc.GSON_Adapters;

// Creation Date: September 18, 2026. at 9:19 PM
// Last Modified: September 18, 2026. at  9:37 PM

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GsonAdapter_Date
        implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {

    // NOTE: This is a `TypeAdapter`.class for a Gson Object so that complicated varaibles like local date can be serialize/deserialize easily.
    DateTimeFormatter DTF = DateTimeFormatter.ofPattern("MMMM dd, yyyy");

    @Override public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.format(DTF));
    }
    @Override public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
        return LocalDate.parse(json.getAsString(), DTF);
    }
}
