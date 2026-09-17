package GSON_Adapters;// Creation Date: September 17, 2026. at 2:06 PM
// Last Modified: September 17, 2026. at  3:42 PM

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Date_GSONAdapter
        implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {
    private static DateTimeFormatter DTF = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    // LESSON LEARNED: `DateTimeFormatter` in this case is what will be saved in the JSON file.
    // LESSON LEARNED: "MM/dd/yyyy` will be 12/05/2006 in the JSON file.

    //=======VARIABLES=======//

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    @Override public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) { // this changes the
        return new JsonPrimitive(src.format(DTF));
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    @Override public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
        return LocalDate.parse(json.getAsString(), DTF);
    }

    // LESSON LEARNED: `@Override` in this scenario is just `implementing`.
    // LESSON LEARNED: `@Override` has two different ways which Is
    // LESSON LEARNED: first, the overriding (changes the method),
    // LESSON LEARNED: second, the implementation (implements the method).


    // ================================================== OTHER CLASSES ================================================== \\
}

// LESSON LEARNED: We will be using this adapter when instantiating a GsonBuilder/Gson object.
