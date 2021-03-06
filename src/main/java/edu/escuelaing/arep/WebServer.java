package edu.escuelaing.arep;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import edu.escuelaing.arep.annotations.Web;

/**
 * Hello world!
 *
 */
public class WebServer {

    /**
     * se encarga de guardar la ruta /ejemplo y el metodo q esta retorna
     */
    private HashMap<String, Method> rutas = new HashMap<>();

    /**
     * Inserta en el Hashmap las rutas con el tag @web
     */
    public void genRutas() {
        String className = "edu.escuelaing.arep.model.WebService";
        Class clase = null;
        try {
            clase = Class.forName(className);
            for (Method m : clase.getMethods()) {
                if (m.isAnnotationPresent(Web.class)) {
                    // System.out.println("metodo: " + m.getName());
                    // System.out.println(m.invoke(null));
                    Web ruta = m.getAnnotation(Web.class);
                    rutas.put(ruta.value(), m);
                }
            }
            // System.out.println("paso");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Error ClassNotFoundException: " + e);
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Error IllegalArgumentException: " + e);
        }
    }

    /**
     * Mira si existe la ruta en el hashmap
     * 
     * @param ruta
     * @return si existe o no
     */
    public boolean exist(String ruta) {
        return rutas.containsKey(ruta);

    }

    /**
     * Retorna el contenido de la ruta
     * 
     * @param ruta
     * @return
     */
    public String getContenido(String ruta) {
        String res = null;
        try {
            res = (String) rutas.get(ruta).invoke(null);
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("IllegalAccessException: " + e);
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("IllegalArgumentException: " + e);
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("InvocationTargetException: " + e);
        }
        return res;
    }
}
