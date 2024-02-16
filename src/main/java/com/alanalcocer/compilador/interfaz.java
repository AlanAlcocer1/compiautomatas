/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.alanalcocer.compilador;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alan
 */
public class interfaz extends javax.swing.JFrame {
    //Inicializacion de variables
    ArrayList<String> TIN = new ArrayList<String>(); //entero
    ArrayList<String> FOAT = new ArrayList<String>(); //real
    ArrayList<String> LOB = new ArrayList<String>(); //cadena
    DefaultTableModel tabla = new DefaultTableModel();
    ArrayList<String> palabras = new ArrayList<>();
    String lexemasCod;
    
    public interfaz() {
        initComponents();
      
        
    }
    
    
    
    public void tablaLexema(String lexemasCod) {
        
        System.out.println("Entre a la funcion TL");// TODO add your handling code here
        char caracter;
        String lexem = "";
        if (!palabras.isEmpty()) {  // Verificar si la lista no está vacía
        for (int fila = 0; fila < palabras.size(); fila++) {
            tablaDatos.setValueAt("", fila, 0);//lexema
            tablaDatos.setValueAt("", fila, 1);//tipo
        }}
        palabras.clear();
        for (int i = 0; i < lexemasCod.length(); i++) {
            caracter = lexemasCod.charAt(i);
            if (caracter != ' ' && caracter != '\n') {
                lexem = lexem + caracter;
            } else {
                if (!palabras.contains(lexem)) {
                    palabras.add(lexem);
                }
                lexem = "";
            }
        }
    }

    //llenar la columna lexema
    public void columnaLexema() {
        System.out.println("Entre a la funcion CL");// TODO add your handling code here
        for (int fila = 0; fila < palabras.size(); fila++) {
            tablaDatos.setValueAt(palabras.get(fila), fila, 0);
        }
    }
    
    //llenar la columna tipo
    public void columnaTipo() {
         System.out.println("Entre a la funcion Ct");// TODO add your handling code here
        for (int fila = 0; fila < TIN.size(); fila++) {
            if (palabras.contains(TIN.get(fila))) {
                tablaDatos.setValueAt("TIN", palabras.indexOf(TIN.get(fila)), 1);
            }
        }
        for (int fila = 0; fila < FOAT.size(); fila++) {
            if (palabras.contains(FOAT.get(fila))) {
                tablaDatos.setValueAt("FOAT", palabras.indexOf(FOAT.get(fila)), 1);
            }
        }
        for (int fila = 0; fila < LOB.size(); fila++) {
            if (palabras.contains(LOB.get(fila))) {
                tablaDatos.setValueAt("LOB", palabras.indexOf(LOB.get(fila)), 1);
            }
        }

    }
    
     //identifica las expresiones regulares para los diferentes tipos de variables
    public void expresionRegular(String tipoDato, String lexem) {
         System.out.println("Entre a la funcion ER");// TODO add your handling code here
        if (lexem.matches("^[A-Z0-9]{2}[0-9a-z]{4}$")) { //expresion regular para identificador , sin ello no existe identificador
            if (tipoDato.equals("TIN")) {
                TIN.add(lexem);
            }
            if (tipoDato.equals("FOAT")) {
                FOAT.add(lexem);
            }
            if (tipoDato.equals("LOB")) {
                LOB.add(lexem);}
            }
        
        if (lexem.matches("^[A-ZA-Z0-9]{2}[0-9a-z]{4}$")) { //expresion regular para numeros enteros
            for (int fila = 0; fila < palabras.size(); fila++) {
                if (tipoDato.equals(palabras.get(fila)) || lexem.equals(palabras.get(fila))) {
                    tablaDatos.setValueAt("", fila, 1);
                }
            }
        }
        if (lexem.matches("^[A-ZA-Z0-9]{2}[0-9a-z]{4}$")) { //expresion regular para numeros reales
            for (int fila = 0; fila < palabras.size(); fila++) {
                //CHECAR PARA QUITAR EL TIN, FOAT Y LOB
                if (tipoDato.equals(palabras.get(fila)) || lexem.equals(palabras.get(fila))) {
                    tablaDatos.setValueAt("", fila, 1);
                }
            }
        }
        if (lexem.matches("^[A-Z0-9]{2}[0-9a-z]{4}$")) { //expresion regular para cadena
            for (int fila = 0; fila < palabras.size(); fila++) {
                if (tipoDato.equals(palabras.get(fila)) || lexem.equals(palabras.get(fila))) {
                    tablaDatos.setValueAt("", fila, 1);
                    
                }
            }
        }
        
    }

    //identifica los lexemas escritos
    public void identificarLexema(String lexemasCod) {
        System.out.println("Entre a la funcion IL");// TODO add your handling code here
        char caracter;
        String tipoDeDato = "";
        String lexema = "";
        for (int i = 0; i < lexemasCod.length(); i++) {
            caracter = lexemasCod.charAt(i);
            if (caracter != ' ' && caracter != '\n') {
                lexema = lexema + caracter;
            } else {
                if (lexema.equals("TIN") || lexema.equals("FOAT") || lexema.equals("LOB")) {
                    tipoDeDato = lexema;
                }
                expresionRegular(tipoDeDato, lexema);
                if (lexema.equals(";") || caracter == '\n') {
                    tipoDeDato = "";
                }
                lexema = "";
            }
        } //COMENTARIO
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaTexto = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDatos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("ANALIZAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        areaTexto.setColumns(20);
        areaTexto.setRows(5);
        jScrollPane1.setViewportView(areaTexto);

        tablaDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Lexema", "Tipo"
            }
        ));
        tablaDatos.setPreferredSize(new java.awt.Dimension(170, 480));
        jScrollPane2.setViewportView(tablaDatos);

        jLabel1.setText("ESCRIBE ACA TU CODIGO: ");

        jButton2.setText("TEXTO DE PRUEBA");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jButton1))))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(69, 69, 69))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    lexemasCod = areaTexto.getText();
    System.out.println(lexemasCod);
    tablaLexema(lexemasCod);
    columnaLexema();
    identificarLexema(lexemasCod);
    columnaTipo();
    System.out.println(lexemasCod);// TODO add your handling code here:
    //agregarPalabrasATabla();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        areaTexto.setText("""
                          TIN VM2904 , DN2401 , AAalan , 20as12 ; 
                          FOAT PAmama , MApapa , 20bs10 ; 
                          LOB AAbaba , MP2040 , MR1999 ; 
                          DN2401 = AAbaba - MP2040 ; 
                          MR1999 = MApapa - PAmama ; 
                          20as12 = AAbaba / DN2401 
                          aa20AS ; """);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaTexto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaDatos;
    // End of variables declaration//GEN-END:variables
}
