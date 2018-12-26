package indi.viyoung.viboot.util;

import java.io.*;
import java.util.Iterator;
import java.util.Properties;

/**
 * 读取*.properties中的属性
 * @author vi
 * @since 2018/12/24 7:33 PM
 */
public class ReadPropertiesUtil {

    public static Properties getProperties(String propertiesPath){
        Properties properties = new Properties();
        try {
            InputStream inputStream = new BufferedInputStream(new FileInputStream(propertiesPath));
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
