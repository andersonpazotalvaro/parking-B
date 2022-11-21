package co.smart.parking.gson;

import com.google.gson.JsonSyntaxException;

public interface GsonAdaptador {

    public default String toJson(Object objeto) {
        String json = GsonBean.gson().toJson(objeto);
        if("null".equals(json))
            return null;
        return json;
    }

    public default <T> T fromJson(String json, Class<T> clazz) {
        try {
            return GsonBean.gson().fromJson(json, clazz);
        } catch(JsonSyntaxException e) {
            // Error
            return null;
        }
    }
}
