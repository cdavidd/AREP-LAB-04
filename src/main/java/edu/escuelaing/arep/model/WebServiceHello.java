package edu.escuelaing.arep.model;

import edu.escuelaing.arep.annotations.Web;

public class WebServiceHello{
    @Web
    public static String hello(){
        return "<html><body> hello </body></html>";
    }

}