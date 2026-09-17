package GSON_Adapters;

// Creation Date: September 17, 2026. at 3:34 PM
// Last Modified: September 17, 2026. at  3:42 PM

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime_GSONAdapter
        implements JsonSerializer<LocalDateTime>, JsonDeserializer<LocalDateTime> {
    private static DateTimeFormatter DTF = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");

    // LESSON LEARNED: `DateTimeFormatter` in this case is what will be saved in the JSON file.
    // LESSON LEARNED: "MM/dd/yyyy hh:mm a` will be 12/05/2006 7:30 PM in the JSON file.

    //=======VARIABLES=======//

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    @Override public JsonElement serialize(LocalDateTime src, Type typeOfSrc, JsonSerializationContext context) { // this changes the
        return new JsonPrimitive(src.format(DTF));
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    @Override public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
        return LocalDateTime.parse(json.getAsString(), DTF);
    }

    // LESSON LEARNED: `@Override` in this scenario is just `implementing`.
    // LESSON LEARNED: `@Override` has two different ways which Is
    // LESSON LEARNED: first, the overriding (changes the method),
    // LESSON LEARNED: second, the implementation (implements the method).


    // ================================================== OTHER CLASSES ================================================== \\
}

// LESSON LEARNED: We will be using this adapter when instantiating a GsonBuilder/Gson object.

