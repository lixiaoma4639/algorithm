package test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class test {
    public static void main(String[] args) {
        System.out.println(isConnected());
    }

    public static Object isConnected(){
        try {
            Class<?> aClass = Class.forName("test.reflect.F3CardManager");
            Method logEvents = aClass.getMethod("isConnected");
            return logEvents.invoke(null);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException |
                InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
