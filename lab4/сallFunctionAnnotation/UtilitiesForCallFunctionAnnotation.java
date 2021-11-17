package сallFunctionAnnotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UtilitiesForCallFunctionAnnotation {

    public static void callMethodsMarkedAnnotation(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
        Class<?> someClass = object.getClass();
        for (Method method : someClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(CallFunctionAnnotation.class)) {
                method.setAccessible(true);
                int count = method.getAnnotation(CallFunctionAnnotation.class).value();
                while (count != 0) {
                    try {
                        method.invoke(object);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    count--;
                }
            }
        }
    }
}
