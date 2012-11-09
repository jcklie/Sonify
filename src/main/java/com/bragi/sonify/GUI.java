
/*******************************************************************************
 * Copyright (c) 2012 BragiSoft, Inc.
 * This source is subject to the BragiSoft Permissive License.
 * Please see the License.txt file for more information.
 * All other rights reserved.
 * 
 * THIS CODE AND INFORMATION ARE PROVIDED "AS IS" WITHOUT WARRANTY OF ANY 
 * KIND, EITHER EXPRESSED OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND/OR FITNESS FOR A
 * PARTICULAR PURPOSE.
 * 
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * Contributors:
 * Dominik Künne - Everything
 * 
 *******************************************************************************/
package com.bragi.sonify;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Dominik
 */
public class GUI {
    
    public GUI(String title) {
        initComponents();
    }

    
    /**
     * @param component the name of the component you want to add
     * @param container a Container in which all elements are grouped together
     * @param x x-coordinate of the component
     * @param y y-coordinate of the component
     * @param width width of the the component
     * @param height height the component
     * 
     */
    static void addComponent(Component component, Container container, int x, int y, int width, int height) {
        component.setBounds( x, y, width, height );
        container.setLayout( null );
        container.add(component);
       
    }
    
    
    
    public static void initComponents() {
        
        File inputFile;
        File outputFile;
        
        //initialising the Strings roman, sachbuch, lyrik, kinderbuch, drama, filename
        String roman = new String("Roman");
        String sachbuch = new String("Sachbuch");
        String lyrik = new String("Lyrik");
        String kinderbuch = new String("Kinderbuch");
        String drama = new String("Drama");
        String filename = new String("");
        
        // creating the JFrame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //creating the JButtons
        JButton input_button = new JButton("Input auswählen");
        JButton start_button = new JButton("Audifikation starten");
        JButton output_button = new JButton("Outputpfad wählen");
        
        //creating the JLabel and the JTextField
        JLabel ueberschrift_label = new JLabel("Audifikator");
        ueberschrift_label.setFont(new Font("Arial", Font.PLAIN, 22));
        final JTextField input_textfield = new JTextField("");
        final JTextField output_textfield = new JTextField("");
        JComboBox combo_genre = new JComboBox(new Object[] { roman, sachbuch, lyrik, kinderbuch, drama});
        Container c = frame.getContentPane();
        
        //adding components to GUI
        Container container = frame.getContentPane();
        addComponent(ueberschrift_label, container, 300, 15, 200, 20);
        addComponent(input_textfield, container, 40, 60, 350, 30);
        addComponent(output_textfield, container, 40, 110, 350, 30);
        addComponent(input_button, container, 410, 60, 200, 30);
        addComponent(output_button, container, 410, 110, 200, 30);
        addComponent(start_button, container, 410, 180, 200, 65);
        addComponent(combo_genre, container, 40, 180, 280, 30);
        
       //creating the frame
        frame.setSize(650, 350);
        frame.setResizable(false);
        frame.setVisible(true);
        
        
        
        input_button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_buttonActionPerformed(evt);
            }
            
           //opens a Filechooser and prints the path of the file into the varaible input_textfield 
            private void input_buttonActionPerformed(ActionEvent evt) {
                JFileChooser input_chooser = new JFileChooser();
                input_chooser.showDialog(input_chooser, "Datei auswählen");
                input_textfield.setText(input_chooser.getSelectedFile().getPath());
        
                 }
        });
        
        output_button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                output_buttonActionPerformed(evt);
            }

            //opens a Filechooser and prints the path of the Ordner into the varaible output_textfield
            private void output_buttonActionPerformed(ActionEvent evt) {
                JFileChooser output_chooser = new JFileChooser();
                output_chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                output_chooser.showDialog(output_chooser, "Speicherort wählen");
                output_textfield.setText(output_chooser.getSelectedFile().getPath());
        
                 }
        });
        
        
        
        start_button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                start_buttonActionPerformed(evt);
            }
            //here the audification should start
            private void start_buttonActionPerformed(ActionEvent evt) {
                JOptionPane.showMessageDialog(null, "Audifikation erfolgreich beendet!");
                
         

            
       
        
                 }
        });
        
    }
    
    public static void main(String[] args) {
        
        new GUI("Bragisoft-GUI");
    }

    
    
}
