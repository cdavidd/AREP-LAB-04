package edu.escuelaing.arep;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import edu.escuelaing.arep.annotations.Web;

/**
 * Hello world!
 *
 */
public class WebServer {
    public static void main(String[] args) {
        String className = "edu.escuelaing.arep.model.WebServiceHello";
        try {
            Class clase = Class.forName(className);
            for (Method m : clase.getMethods()) {
                if (m.isAnnotationPresent(Web.class)) {
                    System.out.println("metodo: "+m.getName());
                    System.out.println(m.invoke(null));
                    m.getGenericReturnType(); 
                }
            }
            System.out.println("paso");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
