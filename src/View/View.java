/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Robot;
import java.awt.ScrollPane;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Braya
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.


import cotroller.Controller;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author estudiantes
 */
public class View extends JFrame {

    public JPanel vista1 = new JPanel();
    public ArrayList<JPanel> vista = new ArrayList<>();
    public ArrayList<JPanel> vista_card= new ArrayList<>();
    public ArrayList<JPanel> vista2 = new ArrayList<>();
    public ArrayList<JLabel> vista2_card = new ArrayList<>();
    public ArrayList<JLabel> vista_cardi = new ArrayList<>();
    public ArrayList<JPanel> vista3 = new ArrayList<>();
    public ArrayList<JLabel> vista3_card = new ArrayList<>();
    public ArrayList<JTextArea> clases = new ArrayList<>();
    public ArrayList<JTextArea> variables = new ArrayList<>();
    public JTextArea herencia = new JTextArea();
    public JButton enviar = new JButton("enviar");
    public JButton añadir = new JButton("añadir");
    public JButton añadirHerencia = new JButton("herencia");
    public ArrayList<JLabel> vista_a = new ArrayList<>();
    public ArrayList<ArrayList<JLabel>> vista_var_a = new ArrayList<>();
    public ArrayList<JLabel> vista_b = new ArrayList<>();
    public ArrayList<ArrayList<JLabel>> vista_var_b = new ArrayList<>();
    public ArrayList<JLabel> imagenes = new ArrayList<>();
    public ArrayList<JLabel> titutlo = new ArrayList<>();
    public ScrollPane sc = new ScrollPane();
    int ultimo ;
    int ultimo_cardinal;
    int penultimo;
    
    Color color = new Color(193, 23, 88);
    Color color_header = new Color(193, 23, 88);
    int numero;

    public View() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        vista1.setLayout(null);
        clases.add(new JTextArea());
        variables.add(new JTextArea());
        enviar.setBounds(30, 150, 100, 50);
        enviar.setBackground(color);
        enviar.setForeground(Color.WHITE);
        añadir.setBounds(150, 150, 100, 50);
        añadir.setBackground(color);
        añadir.setForeground(Color.WHITE);
        añadirHerencia.setBounds(250, 150, 100, 50);
        añadirHerencia.setBackground(color);
        añadirHerencia.setForeground(Color.WHITE);
        herencia.setBounds(470, 30, 200, 100);
        herencia.setVisible(false);
        vista1.add(enviar);
        vista1.add(herencia);
        vista1.add(añadir);
        vista1.add(añadirHerencia);

    }

    public void mostrar() {
        setSize(1500, 1000);
        sc.setBounds(0, 0, 1500, 1000);
        setLocationRelativeTo(null);
        for (int i = 0; i < clases.size(); i++) {
            variables.get(i).setBounds(250, 30 + (150 * i), 200, 100);
            clases.get(i).setBounds(30, 30 + (150 * i), 200, 100);
        }
        for (int i = 0; i < clases.size(); i++) {
            vista1.add(variables.get(i));
            vista1.add(clases.get(i));
        }

        enviar.setBounds(30, 150 + (150 * (clases.size() - 1)), 100, 50);
        añadir.setBounds(150, 150 + (150 * (clases.size() - 1)), 100, 50);
        añadirHerencia.setBounds(270, 150 + (150 * (clases.size() - 1)), 100, 50);
        setContentPane(sc);
        vista1.updateUI();
        vista1.repaint();
        
        //System.out.println(clases.size());
        setVisible(true);
    }

    public void crear(int numero) {
        this.numero = numero;
        if (numero > 0) {
            for (int i = 0; i < numero; i++) {
                vista.add(new JPanel());
                vista.get(i).setLayout(null);
                vista.get(i).setBounds(800, 220 * i, 100, 200);
                vista.get(i).setBorder(BorderFactory.createLineBorder(color,2));
                vista2.add(new JPanel());
                vista2.get(i).setLayout(null);
                vista2.get(i).setBounds(0, 21, 100, 50);
                vista2.get(i).setBorder(BorderFactory.createLineBorder(color,2));
                vista3.add(new JPanel());
                vista3.get(i).setLayout(null);
                vista3.get(i).setBounds(0, 100, 100, 50);
                vista3.get(i).setBorder(BorderFactory.createLineBorder(color,2));
                vista_a.add(new JLabel());
                vista_a.get(i).setBounds(0, 0, 100, 20);
                vista_a.get(i).setOpaque(true);
                vista_a.get(i).setBackground(color_header);
                vista_a.get(i).setForeground(Color.WHITE);
                vista_a.get(i).setBorder(BorderFactory.createLineBorder(color,2));
                vista_b.add(new JLabel());
                vista_b.get(i).setOpaque(true);
                vista_b.get(i).setBounds(0, 0, 100, 20);
                vista_b.get(i).setBackground(color_header);
                vista_b.get(i).setForeground(Color.WHITE);
                vista_b.get(i).setBorder(BorderFactory.createLineBorder(color,2));
                vista2.get(i).add(vista_a.get(i));
                vista3.get(i).add(vista_b.get(i));
                vista.get(i).add(vista2.get(i));
                vista.get(i).add(vista3.get(i));
                vista.get(i).setBounds(800, 220 * i, 100, 200);
                
                vista1.add(vista.get(i));
                sc.add(vista1);
            }
        }
    }
    public void cardinalidad()
    {
        
       if (numero > 0) {
            for (int i = 0; i < numero; i++) {
                saveImage(i);
                vista_card.add(new JPanel());
                vista_card.get(i).setLayout(null);
                ImageIcon icon1 = new ImageIcon("E:/Users/Braya/Documents/NetBeansProjects/uml1/saveb"+i+".jpeg");
                vista3_card.add(new JLabel(icon1));
                vista3_card.get(i).setBounds(200, 0, 100, icon1.getIconHeight());
                ImageIcon icon2 = new ImageIcon("E:/Users/Braya/Documents/NetBeansProjects/uml1/savea"+i+".jpeg");
                vista2_card.add(new JLabel(icon2));
                if (Objects.equals(vista_cardi.get(i).getText(), "false_bitch_jerry}_is_gay")) {
                    
                }else
                {
                    vista_cardi.get(i).setBounds(100, 0, 100, 50);
                    System.out.println("sdsddsdsdssdsdsdfww.View.cardinalidad()");
                }
                
                vista2_card.get(i).setBounds(0, 0, 100, icon2.getIconHeight());
                if(i==0)
                { 
                    vista_card.get(i).setBounds(1000, 0, 300, (Math.max(icon2.getIconHeight(), icon1.getIconHeight()-165)));
                    System.out.println("1"+icon1.getIconHeight());
                    System.out.println("2"+icon2.getIconHeight());
                    System.out.println("View.View.cardinalidad()"+Math.max(icon2.getIconHeight(), icon1.getIconHeight()));
                }else
                {
                    vista_card.get(i).setBounds(1000, ultimo_cardinal, 300, (Math.max(icon2.getIconHeight(), icon1.getIconHeight()-165)));
                    System.out.println("1"+icon1.getIconHeight());
                    System.out.println("2"+icon2.getIconHeight());
                    System.out.println("View.View.cardinalidad()"+Math.max(icon2.getIconHeight(), icon1.getIconHeight()));
                }
                ultimo_cardinal+=(Math.max(icon2.getIconHeight(), icon1.getIconHeight())+50)-165;
                vista_card.get(i).add(vista2_card.get(i));
                vista_card.get(i).add(vista3_card.get(i));
                vista_card.get(i).add(vista_cardi.get(i));
                vista1.add(vista_card.get(i));
                
                System.out.println("1"+icon1.getIconHeight());
                System.out.println("2"+icon2.getIconHeight());
                System.out.println("View.View.cardinalidad()"+Math.max(icon2.getIconHeight(), icon1.getIconHeight()));
                
            }
        }
    }
    private void saveImage(int i){
    BufferedImage imagebuf=null;
    try {
        imagebuf = new Robot().createScreenCapture(vista2.get(i).getBounds());
    } catch (AWTException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }  
     Graphics2D graphics2D = imagebuf.createGraphics();
     vista2.get(i).paint(graphics2D);
     try {
        ImageIO.write(imagebuf,"jpeg", new File("savea"+i+".jpeg"));
    } catch (Exception e) {
        // TODO Auto-generated catch block
        System.out.println("error");
    }
     
     BufferedImage imagebuf1=null;
    try {
        imagebuf1 = new Robot().createScreenCapture(vista3.get(i).getBounds());
    } catch (AWTException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }  
     Graphics2D graphics2D1 = imagebuf1.createGraphics();
     vista3.get(i).paint(graphics2D1);
     try {
        ImageIO.write(imagebuf1,"jpeg", new File("saveb"+i+".jpeg"));
    } catch (Exception e) {
        // TODO Auto-generated catch block
        System.out.println("error");
    }
    }

    public void organizar() {
        for (int i = 0; i < numero; i++) {
            titutlo.get(i).setBounds(0, 0, 100, 20);
            titutlo.get(i).setForeground(color);
            penultimo += ultimo+20;
            ultimo = 21;
            for (int j = 0; j < vista_var_a.get(i).size(); j++) {
                vista_var_a.get(i).get(j).setBounds(0, (21 * (j + 1)), 100, 20);
                vista_var_a.get(i).get(j).setBorder(BorderFactory.createLineBorder(color,2));
                vista2.get(i).add(vista_var_a.get(i).get(j));
            }
            
            ultimo += (21 * vista_var_a.get(i).size());
            vista2.get(i).setBounds(0, 21, 100, ultimo);
            imagenes.get(i).setBounds(0, ultimo+22, 100, 100);
            imagenes.get(i).setBorder(BorderFactory.createLineBorder(color,2));
            ultimo += 121;
            for (int j = 0; j < vista_var_b.get(i).size(); j++) {
                vista_var_b.get(i).get(j).setBounds(0, (21 * (j + 1)), 100, 20);
                vista_var_b.get(i).get(j).setBorder(BorderFactory.createLineBorder(color,2));
                vista3.get(i).add(vista_var_b.get(i).get(j));
            }
            
            vista3.get(i).setBounds(0, ultimo, 100, (ultimo +(21 * vista_var_b.get(i).size())));
            ultimo += (21 * vista_var_b.get(i).size())+20;
            
            if (i == 0) {
                vista.get(i).setBounds(800, 0, 100, ultimo);
            } else {
                vista.get(i).setBounds(800, penultimo, 100, ultimo);
            }
            vista.get(i).setBackground(Color.white);
            vista3.get(i).setBackground(Color.white);
            vista2.get(i).setBackground(Color.white);
            vista.get(i).add(titutlo.get(i));
            vista.get(i).add(imagenes.get(i));
        }
        

    }

    public void Listener(Controller c) {
        enviar.addActionListener((ActionListener) c);
        añadir.addActionListener((ActionListener) c);
        añadirHerencia.addActionListener(c);
    }

    public JTextArea getHerencia() {
        return herencia;
    }

    public void setVista_var_a(ArrayList<ArrayList<JLabel>> vista_var_a) {
        this.vista_var_a = vista_var_a;
    }

}

