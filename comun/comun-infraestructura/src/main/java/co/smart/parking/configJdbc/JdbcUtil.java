package co.smart.parking.configJdbc;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Parameter;
import java.util.Arrays;

public class JdbcUtil {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public JdbcUtil(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private MapSqlParameterSource createEntity(Object objeto){
        MapSqlParameterSource entity = new MapSqlParameterSource();

        Field[] parametros= objeto.getClass().getDeclaredFields();
        for (Field parametro:parametros) {
            try {

            }catch (){

            }
        }
    }
}
