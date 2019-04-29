/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uml;

import Controller.Controller;
import Model.Clase;
import View.View;

/**
 *
 * @author Braya
 */
public class Uml {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        View view = new View();
        view.mostrar();
        Clase clases = new Clase();
        Controller c = new Controller(clases,view);
        view.Listener(c);
        
       
    }
    
}
