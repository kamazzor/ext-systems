package edu.javaproject.cityregister.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/***
 * Config class contains methods and fields to get connection with city_register database.
 * Database config is specified in dao.properties
 */
public class Config {
    public static final String DB_URL = "db.url";
    public static final String DB_LOGIN = "db.login";
    public static final String DB_PASSWORD = "db.password";
    public static final String DB_LIMIT = "db.limit";

    private static Properties properties = new Properties();

    public static String getProperty(String name){
        if (properties.isEmpty()){
            try (InputStream is = Config.class.getClassLoader()
                    .getResourceAsStream("dao.properties")){

                properties.load(is);

            } catch (IOException e){
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return properties.getProperty(name);
    }
}