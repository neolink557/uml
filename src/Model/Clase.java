/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Braya
 */
public class Clase {

    private String name;
    private String[] variables;//contiene cada una de las variables
    private String[] clas;//contiene cada una de las clases
    private String variables_puras;//contiene el texto del jtextfield de variables
    private String clases_puras;//contiene el texto del jtextfield de clases
    private ArrayList<String[]> variables_partidas = new ArrayList<>();//contiene cada una de las palabras escritas en variables
    private ArrayList<String[]> clases_partidas = new ArrayList<>();//contiene cada una de las palabras escritas en clases
    private ArrayList<String> clases_relaciones = new ArrayList<>();
    private ArrayList<String> clases = new ArrayList<>();
    private ArrayList<String> clases_metodos = new ArrayList<>();
    private ArrayList<Integer> numero_relaciones = new ArrayList<>();
    private ArrayList<Integer> total_var = new ArrayList<>();

    private enum tipos {
        composicion, agregacion, clase
    }
    private ArrayList<tipos> tipo = new ArrayList<>();//contiene cada una de las palabras escritas en clases

    public Clase() {

    }

    public void Run(String variables, String clas) {
        this.clases_puras = clas;
        this.variables_puras = variables;
        HacerSplit();
        Analizar_palabras_clases();
    }

    public void HacerSplit() {
        variables = variables_puras.split("\n");
        clas = clases_puras.split("\n");
        for (int i = 0; i < variables.length; i++) {
            variables_partidas.add(variables[i].split(" "));
        }
        for (int i = 0; i < clas.length; i++) {
            clases_partidas.add(clas[i].split(" "));

        }
    }

    public void Analizar_palabras_clases() {
        if (Objects.equals(clases_partidas.get(0)[0], "class") || Objects.equals(clases_partidas.get(0)[0], "interface")) {
            name = clas[0];

        } else {
            System.err.println("no declaro alguna clase");
        }

        for (int i = 1; i < clas.length; i++) {
            if (Objects.equals(clases_partidas.get(i)[1], "new")) {
                if (Objects.equals(clases_partidas.get(i)[clases_partidas.get(i).length - 1], "[]")) {
                    tipo.add(tipos.agregacion);
                } else {
                    tipo.add(tipos.composicion);
                }
            } else {
                tipo.add(tipos.clase);
            }

        }

    }

    public void hallar_clases(Clase clase) {
        for (int i = 1; i < clases_partidas.size(); i++) {
            if (tipo.get(i - 1) == tipos.clase) {
                clases_metodos.add(clas[i]);
                clases.add(clas[i]);
                System.out.println("Es una clase"); 
            } else {
                if (Objects.equals(clases_partidas.get(i)[2], clase.clases_partidas.get(0)[1])) {
                    switch (this.tipo.get(i - 1)) {
                        case composicion:

                            System.out.println("compocision de " + this.name + " con " + clase.clases_partidas.get(0)[1]);
                            clases_relaciones.add(this.name + "," + clase.name);
                            numero_relaciones.add(0);

                            break;
                        case agregacion:

                            System.out.println("agregacion de " + this.name + " con " + clase.clases_partidas.get(0)[1]);
                            clases_relaciones.add(this.name + "," + clase.name);
                            numero_relaciones.add(1);

                            break;
                        case clase:
                            System.out.println("solo clase");
                            break;
                    }
                } else {
                    System.err.println("no existe la clase " + clase.clases_partidas.get(0)[1]);
                }
            }

        }
        for (int j = 0; j < numero_relaciones.size() + variables.length + clases_metodos.size(); j++) {
            total_var.add(j);
            
        }
        System.err.println(total_var.size());

    }

    public String[] split_herencia(String g) {
        String[] herencia;
        herencia = g.split(" ");
        return herencia;
    }

    public void hallar_herencias(Clase clase, String a, String b, String type) {
        boolean es_a = false;
        boolean es_b = false;
        if (Objects.equals(clases_partidas.get(0)[1], a)) {
            es_a = true;
        }
        if (Objects.equals(clase.clases_partidas.get(0)[1], b)) {
            es_b = true;
        }

        if (Objects.equals(type, "extends")) {
            if (es_a && es_b) {
                numero_relaciones.add(2);
                clases_relaciones.add("class " + a + "," + "class " + b);
                System.out.println("class " + a + " extends " + b);
            }
        }
        if (Objects.equals(type, "implements")) {
            if (es_a && es_b) {
                numero_relaciones.add(3);
                clases_relaciones.add("class " + a + "," + "interface " + b);
                System.out.println("class " + a + " implements " + b);
            }
        }

    }

    public ArrayList<tipos> getTipo() {
        return tipo;
    }

    public ArrayList<String[]> getClases_partidas() {
        return clases_partidas;
    }

    public ArrayList<Integer> getNumero_relaciones() {
        return numero_relaciones;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getClases_relaciones() {
        return clases_relaciones;
    }

    public String[] getVariables() {
        return variables;
    }

    public ArrayList<Integer> getTotal_var() {
        return total_var;
    }

    public ArrayList<String> getClases_metodos() {
        return clases_metodos;
    }

    public ArrayList<String> getClases() {
        return clases;
    }
    
     
}
