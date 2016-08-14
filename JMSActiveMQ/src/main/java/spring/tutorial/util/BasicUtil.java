package spring.tutorial.util;

import java.util.UUID;

/**
 * Created by thangnguyen-imac on 8/14/16.
 */
public class BasicUtil {

    public static String getUniqueID(){
        return UUID.randomUUID().toString();
    }
}
