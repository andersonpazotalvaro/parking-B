package co.smart.parking.gson;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class GsonBean {

    public static final String FORMATO_FECHA_HORA = "dd-MM-yyyy HH:mm:ss";

    public static Gson gson() {
        return new GsonBuilder()
                .disableHtmlEscaping()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setDateFormat(FORMATO_FECHA_HORA)
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdaptador().nullSafe())
                .registerTypeAdapter(LocalDate.class, new LocalDateAdaptador().nullSafe())
                .registerTypeAdapter(LocalTime.class, new LocalTimeAdaptador().nullSafe())
                .create();
    }
}
