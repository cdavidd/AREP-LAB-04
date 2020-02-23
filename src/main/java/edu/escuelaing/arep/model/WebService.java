package edu.escuelaing.arep.model;

import edu.escuelaing.arep.annotations.Web;

public class WebService {
    @Web("/hello")
    public static String hello() {
        return "<html><body> hello </body></html>";
    }

    @Web("/lobo")
    public static String lobo() {
        return "<html><body> <img src=\"/lobo.jpg\"> </body></html>";
    }

    @Web("/leon")
    public static String leon() {
        return "<html><body> <img src=\"/leon.jpg\"> </body></html>";
    }

    @Web("/alert")
    public static String alert() {
        String res = "<html><head><script src=\"/alert.js\"></script></head><body>"
                + "<p>Click the button to display an alert box.</p> " + "<button onclick='myFunction()'>Try it</button>"
                + "</body></html>";
        return res;
    }

    @Web("/prueba")
    public static String pruebaJs() {
        String res = "<html><head><script src=\"/prueba.js\"></script></head><body>" + "</body></html>";
        return res;
    }

}