/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Clase;
import View.View;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author Braya
 */
public class Controller implements ActionListener {

    Clase clase;
    View vista;
    int corrimiento = 10;
    boolean is_visible = false;
    ArrayList<Clase> clases = new ArrayList<>();
    ArrayList<Integer> numero_var = new ArrayList<>();
    ArrayList<String> relaciones = new ArrayList<>();
    ArrayList<Integer> relaciones_num = new ArrayList<>();
    int total;

    public Controller(Clase clase, View vista) {
        this.clase = clase;
        this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == vista.enviar) {
            for (int i = 0; i < vista.clases.size(); i++) {
                clases.add(new Clase());
                clases.get(i).Run(vista.variables.get(i).getText(), vista.clases.get(i).getText());

            }
            for (int i = 0; i < clases.size(); i++) {
                for (int j = 0; j < clases.size(); j++) {
                    if (i == j) {

                    } else {
                        clases.get(i).hallar_clases(clases.get(j));
                    }

                }

            }

            if (vista.getHerencia().isVisible()) {
                if (vista.getHerencia().getText().isEmpty()) {
                    System.out.println("llene la herencia o remuevala");
                } else {
                    for (int i = 0; i < clases.size(); i++) {
                        for (int j = 0; j < clases.size(); j++) {
                            if (i == j) {

                            } else {
                                clases.get(i).hallar_herencias(clases.get(j), vista.herencia.getText().split(" ")[1], vista.herencia.getText().split(" ")[3], vista.herencia.getText().split(" ")[2]);
                            }

                        }

                    }
                }
            }
            for (int i = 0; i < clases.size(); i++) {
            }
            for (int i = 0; i < clases.size(); i++) {
                total += clases.get(i).getNumero_relaciones().size();
                for (int j = 0; j < clases.get(i).getNumero_relaciones().size(); j++) {
                    relaciones_num.add(clases.get(i).getNumero_relaciones().get(j));
                }

            }

            //System.out.println(clases.size());
            vista.crear(total);

            //guardar todas las relaciones
            for (int i = 0; i < clases.size(); i++) {
                if (clases.get(i).getNumero_relaciones().size() > 0) {
                    for (int j = 0; j < clases.get(i).getNumero_relaciones().size(); j++) {
                        relaciones.add(clases.get(i).getClases_relaciones().get(j));
                    }
                }
            }

            //poner los titulos de a basados en las relaciones
            for (int i = 0; i < total; i++) {
                vista.vista_a.get(i).setText(relaciones.get(i).split(",")[0]);
                vista.vista_var_a.add(new ArrayList<>());
                for (int j = 0; j < clases.size(); j++) {
                    if (Objects.equals(relaciones.get(i).split(",")[0], clases.get(j).getName())) {
                        
                        for (int k = 0; k < clases.get(j).getVariables().length; k++) {
                            vista.vista_var_a.get(i).add(new JLabel());
                            vista.vista_var_a.get(i).get(k).setText(clases.get(j).getVariables()[k]);
                        }
                        for (int k = 0; k < clases.get(j).getNumero_relaciones().size(); k++) {
                            vista.vista_var_a.get(i).add(new JLabel());
                            vista.vista_var_a.get(i).get(k+clases.get(j).getVariables().length).setText("new "+clases.get(j).getClases_relaciones().get(k).split(",")[1].split(" ")[1]);
                            vista.vista_var_a.get(i).get(k+clases.get(j).getVariables().length).setForeground(Color.BLUE);
                        }
                        for (int k = 0; k < clases.get(j).getClases_metodos().size(); k++) {
                            vista.vista_var_a.get(i).add(new JLabel());
                            vista.vista_var_a.get(i).get(k+clases.get(j).getVariables().length +clases.get(j).getNumero_relaciones().size())
                            .setText(clases.get(j).getClases().get(k).split(" ")[1]+" "+clases.get(j).getClases().get(k).split(" ")[2]+" "+clases.get(j).getClases().get(k).split(" ")[3]);
                            vista.vista_var_a.get(i).get(k+clases.get(j).getVariables().length + clases.get(j).getNumero_relaciones().size()).setForeground(Color.RED);
                        }

                    }

                }
            }

            //poner los titulos de b basados en las relaciones
            for (int i = 0; i < total; i++) {

                vista.vista_b.get(i).setText(relaciones.get(i).split(",")[1]);
                vista.vista_var_b.add(new ArrayList<>());
                for (int j = 0; j < clases.size(); j++) {
                    if (Objects.equals(relaciones.get(i).split(",")[1], clases.get(j).getName())) {

                        for (int k = 0; k < clases.get(j).getVariables().length; k++) {
                            vista.vista_var_b.get(i).add(new JLabel());
                            vista.vista_var_b.get(i).get(k).setText(clases.get(j).getVariables()[k]);
                        }
                        for (int k = 0; k < clases.get(j).getNumero_relaciones().size(); k++) {
                            vista.vista_var_b.get(i).add(new JLabel());
                            vista.vista_var_b.get(i).get(k+clases.get(j).getVariables().length).setText("new "+clases.get(j).getClases_relaciones().get(k).split(",")[1].split(" ")[1]);
                            vista.vista_var_b.get(i).get(k+clases.get(j).getVariables().length).setForeground(Color.BLUE);
                        }
                        for (int k = 0; k < clases.get(j).getClases_metodos().size(); k++) {
                            vista.vista_var_b.get(i).add(new JLabel());
                            vista.vista_var_b.get(i).get(k+clases.get(j).getVariables().length +clases.get(j).getNumero_relaciones().size())
                            .setText(clases.get(j).getClases().get(k).split(" ")[1]+" "+clases.get(j).getClases().get(k).split(" ")[2]+" "+clases.get(j).getClases().get(k).split(" ")[3]);
                            vista.vista_var_b.get(i).get(k+clases.get(j).getVariables().length + clases.get(j).getNumero_relaciones().size()).setForeground(Color.RED);

                        }
                    }

                }

            }
            //hora de las imagenes
            for (int i = 0; i < total; i++) {
                switch (relaciones_num.get(i)) {
                    case 1:
                        ImageIcon icon1 = new ImageIcon("E:/Users/Braya/Documents/NetBeansProjects/uml 1/Uml/build/classes/resources/agregacion.png");
                        Image scaleImage1 = icon1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
                        icon1.setImage(scaleImage1);
                        vista.titutlo.add(new JLabel("     Agregacion"));
                        vista.imagenes.add(new JLabel(icon1));
                        break;
                    case 2:
                        ImageIcon icon2 = new ImageIcon("E:/Users/Braya/Documents/NetBeansProjects/uml 1/Uml/build/classes/resources/herencia.png");
                        Image scaleImage2 = icon2.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
                        icon2.setImage(scaleImage2);
                        vista.titutlo.add(new JLabel("     Herencia"));
                        vista.imagenes.add(new JLabel(icon2));
                        break;
                    case 3:
                        ImageIcon icon3 = new ImageIcon("E:/Users/Braya/Documents/NetBeansProjects/uml 1/Uml/build/classes/resources/implementacion.png");
                        Image scaleImage3 = icon3.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
                        icon3.setImage(scaleImage3);
                        vista.titutlo.add(new JLabel(" Implementacion"));
                        vista.imagenes.add(new JLabel(icon3));
                        break;
                    case 0:
                        ImageIcon icon = new ImageIcon("E:/Users/Braya/Documents/NetBeansProjects/uml 1/Uml/build/classes/resources/compocision.png");
                        Image scaleImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
                        icon.setImage(scaleImage);
                        vista.titutlo.add(new JLabel("   Compocision"));
                        vista.imagenes.add(new JLabel(icon));
                        break;
                }

            }
            vista.organizar();
            vista.cardinalidad();
            vista.mostrar();
        }

        if (ae.getSource() == vista.añadir) {
            vista.clases.add(new JTextArea());
            vista.variables.add(new JTextArea());
            vista.mostrar();

        }
        if (ae.getSource() == vista.añadirHerencia) {
            vista.getHerencia().setVisible(is_visible);
            if (is_visible) {
                is_visible = false;
            } else {
                is_visible = true;
            }
        }

    }

}
