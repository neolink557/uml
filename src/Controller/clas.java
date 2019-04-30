/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Clase;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Braya
 */
public interface clas {

    public void Run(String variables, String clas);

    public void HacerSplit();

    public void Analizar_palabras_clases();

    public void hallar_clases(Clase clase);

    public String[] split_herencia(String g);

    public void hallar_herencias(Clase clase, String a, String b, String type);

    public ArrayList<String[]> getClases_partidas();

    public ArrayList<Integer> getNumero_relaciones();

    public String getName();

    public ArrayList<String> getClases_relaciones();

    public String[] getVariables();

    public ArrayList<Integer> getTotal_var();

    public ArrayList<String> getClases_metodos();

    public ArrayList<String> getClases();

}
