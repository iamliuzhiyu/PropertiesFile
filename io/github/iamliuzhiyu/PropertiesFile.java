package io.github.iamliuzhiyu;


import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.util.Properties;

public class PropertiesFile {

    private Properties prop;
    private File path;
    private Charset charset;

    private void init(String path, Charset charset) throws IOException {
        this.path = new File(path);
        this.charset = charset;

        this.prop = new Properties();
        this.prop.load(new FileReader(this.path, this.charset));
    }

    public PropertiesFile(String path, Charset charset) throws IOException {
        init(path, charset);
    }

    public PropertiesFile(String path) throws IOException {
        init(path, Charset.defaultCharset());
    }

    public String get(String key) {
        return this.prop.getProperty(key);
    }

    public void set(String key, String value) {
        this.prop.setProperty(key, value);
    }

    public boolean save(String description) {
        try {
            this.prop.store(new FileWriter(this.path, this.charset), description);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean save() {
        return this.save("");
    }
}

