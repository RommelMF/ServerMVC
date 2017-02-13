package avito;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * класс который читает из файла properties
 */
public class Settings {
    private static final Settings INSTANCE = new Settings();

    private final Properties properties = new Properties();

    private Settings() {
        try {
            properties.load(new FileInputStream(this.getClass().getClassLoader().getResource("postgresql.properties").getFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Settings getINSTANCE() {
        return INSTANCE;
    }

    public String value(String key) {
        return this.properties.getProperty(key);
    }
}
