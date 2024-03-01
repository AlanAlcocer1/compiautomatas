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
    String lexemasCodigo;
    ArrayList<String> TIN = new ArrayList<String>(); //entero
    ArrayList<String> FOAT = new ArrayList<String>(); //real
    ArrayList<String> LOB = new ArrayList<String>(); //cadena
    DefaultTableModel tabla = new DefaultTableModel();
    ArrayList<String> palabras = new ArrayList<>();
    
    
    public interfaz() {
        initComponents();
    }
    
    
    
    public void tablaLexema(String lexemasCodigo) {
    System.out.println("Entre a la funcion TL");
    char caracter;
    // Inicia una variable tipo String llamada lexem que se usará para construir los lexemas a partir del texto
    String lexem = "";
    // Verifica si lista palabras no está vacía.
    if (!palabras.isEmpty()) {
        // Recorre todos los elementos de la lista palabras
        for (int fila = 0; fila < palabras.size(); fila++) {
            // Limpia el contenido de la celda correspondiente al lexema en la tabla
            tablaDatos.setValueAt("", fila, 0); //lexema
            // Limpia el contenido de la celda correspondiente al tipo de dato del lexema en la tabla
            tablaDatos.setValueAt("", fila, 1); //tipo
        }
    }
    palabras.clear();
    for (int i = 0; i < lexemasCodigo.length(); i++) {
        // Obtiene el caracter actual en la posición i
        caracter = lexemasCodigo.charAt(i);
        
        // Verifica si el caracter actual no es un espacio en blanco ni un salto de linea
        if (caracter != ' ' && caracter != '\n') {
            // Si no es espacio ni salto de linea, lo añade al lexema actual que se está construyendo
            lexem += caracter;
        } else {
            // Si es un espacio o salto de linea, significa que se ha terminado de construir un lexema
            // Verifica si el lexema construido no está ya en la lista palabras
            if (!palabras.contains(lexem) && !lexem.isEmpty()) {
                // Si no está en la lista y no está vacío, lo añade a la lista
                palabras.add(lexem);
            }
            // Resetea exem para empezar a construir el siguiente lexema
            lexem = "";
        }
    }
    if (!lexem.isEmpty() && !palabras.contains(lexem)) {
        // Añade el ultimo lexema construido a la lista 'palabras' si no está ya incluido
        palabras.add(lexem);
    }
}

    
    public void columnaLexema() {
    System.out.println("Entre a la funcion CL");

    // Inicia un bucle for que recorre cada elemento de la lista palabras
    for (int fila = 0; fila < palabras.size(); fila++) {
        // Para cada elemento de la lista, se actualiza la tabla grafica tablaDatos
        // Se asigna el valor del elemento (lexema) en la lista a la celda correspondiente en la tabla
        // fila se utiliza como indice de la fila en la tabla, 0 indica la columna de los lexemas,
        // y palabras.get(fila) obtiene el lexema en la posición actual del bucle
        tablaDatos.setValueAt(palabras.get(fila), fila, 0);
    }
    // El bucle asegura que cada lexema en la lista palabras se coloque en una nueva fila de la columna 0 (primera columna) de la tabla
}

    
    //llenado de la columna tipo
    public void columnaTipo() {
    System.out.println("Entre a la funcion Ct");

    // Inicia el primer bucle for para recorrer todos los elementos en la lista TIN
    for (int fila = 0; fila < TIN.size(); fila++) {
        // Verifica si el lexema actual en la lista TIN existe en la lista palabras
        if (palabras.contains(TIN.get(fila))) {
            // Si el lexema existe, actualiza la tabla gráfica tablaDatos, asignando el tipo TIN
            // a la celda correspondiente. El índice de la fila se obtiene con 'palabras.indexOf(TIN.get(fila))'
            // indicando la posicion del lexema en la lista palabras y el 1 indica la columna de tipos en la tabla
            tablaDatos.setValueAt("TIN", palabras.indexOf(TIN.get(fila)), 1);
        }
    }

    // Inicia el segundo bucle for para recorrer todos los elementos en la lista FOAT
    for (int fila = 0; fila < FOAT.size(); fila++) {
        // Verifica si el lexema actual en la lista 'FOAT' existe en la lista palabras
        if (palabras.contains(FOAT.get(fila))) {
            // Si el lexema existe, actualiza la tabla gráfica tablaDatos, asignando el tipo "FOAT"
            // a la celda correspondiente, similar al caso anterior
            tablaDatos.setValueAt("FOAT", palabras.indexOf(FOAT.get(fila)), 1);
        }
    }

    // Inicia el tercer bucle for para recorrer todos los elementos en la lista LOB
    for (int fila = 0; fila < LOB.size(); fila++) {
        // Verifica si el lexema actual en la lista LOB existe en la lista palabras
        if (palabras.contains(LOB.get(fila))) {
            // Si el lexema existe, actualiza la tabla gráfica tablaDatos, asignando el tipo "LOB"
            // a la celda correspondiente, similar a los casos anteriores
            tablaDatos.setValueAt("LOB", palabras.indexOf(LOB.get(fila)), 1);
        }
    }
}

    
     //identifica las expresiones regulares para los diferentes tipos de variables
    public void expresionRegular(String tipoDato, String lexem) {
         System.out.println("Entre a la funcion ER");
        if (lexem.matches("^[A-Z0-9]{2}[0-9a-z]{4}$")) { //expresion regular para identificador
            if (tipoDato.equals("TIN")) {
                TIN.add(lexem);
            }
            if (tipoDato.equals("FOAT")) {
                FOAT.add(lexem);
            }
            if (tipoDato.equals("LOB")) {
                LOB.add(lexem);}
            }
        
        if (lexem.matches("^[0-9]+$")) { //expresion regular para numeros enteros
            for (int fila = 0; fila < palabras.size(); fila++) {
                if (tipoDato.equals(palabras.get(fila)) || lexem.equals(palabras.get(fila))) {
                    tablaDatos.setValueAt("TIN", fila, 1);
                }
            }
        }
        if (lexem.matches("^[0-9]+\\.[0-9]+$")) { //expresion regular para numeros reales
            for (int fila = 0; fila < palabras.size(); fila++) {
                
                if (tipoDato.equals(palabras.get(fila)) || lexem.equals(palabras.get(fila))) {
                    tablaDatos.setValueAt("FOAT", fila, 1);
                }
            }
        }
        if (lexem.matches("^\\\"[^\\\"]*\\\"$")) { //expresion regular para cadena
            for (int fila = 0; fila < palabras.size(); fila++) {
                if (tipoDato.equals(palabras.get(fila)) || lexem.equals(palabras.get(fila))) {
                    tablaDatos.setValueAt("LOB", fila, 1);           
                }
            }
        }   
    }
    public void identificarLexema(String lexemasCodigo) {
        System.out.println("Entre a la funcion IL");
        char caracter;
        String tipoDeDato = "";
        String lexema = "";
        for (int i = 0; i < lexemasCodigo.length(); i++) {
            caracter = lexemasCodigo.charAt(i);
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
        }
    }
    public void identificarErrores(String lexemasCodigo) {
        String lexemaAsignacion = "", token = "14ERSem", tipoError = "", tipoDato = "", tipoAsignacion = "";
        int contadorERSem = 0, contadorLinea = 1, filaErrores = 0, fila = 0;
        char caracter;
        boolean asignacion = false;
        for (int i = 0; i < jTablaError.getRowCount(); i++) {
            jTablaError.setValueAt("", i, 0);//aca va Token
            jTablaError.setValueAt("", i, 1);//aca va lexema
            jTablaError.setValueAt("", i, 2);//aca va linea
            jTablaError.setValueAt("", i, 3);//aca va descripcion
        }
        for (int i = 0; i < lexemasCodigo.length(); i++) {
            caracter = lexemasCodigo.charAt(i);
            if (caracter != ' ' && caracter != '\n') {
                lexemaAsignacion = lexemaAsignacion + caracter;
            } else if (caracter == '\n') {
                contadorLinea++;
                lexemaAsignacion = "";
            } else if (palabras.contains(lexemaAsignacion)) {
                fila = palabras.indexOf(lexemaAsignacion);
                tipoDato = (String) tablaDatos.getValueAt(fila, 1);
               
                if (lexemaAsignacion.matches("^[A-Z0-9]{2}[0-9a-z]{4}$") && asignacion == false) {
                    tipoAsignacion = tipoDato;
                }
                if (!lexemaAsignacion.equals("TIN")
                        && !lexemaAsignacion.equals("FOAT")
                        && !lexemaAsignacion.equals("LOB")
                        && !lexemaAsignacion.matches("<=")
                        && !lexemaAsignacion.matches(">=")
                        && !lexemaAsignacion.matches(">")
                        && !lexemaAsignacion.matches("<")
                        && !lexemaAsignacion.matches("==")
                        && !lexemaAsignacion.matches("!=")
                        && !lexemaAsignacion.matches("!")
                        && !lexemaAsignacion.matches("!:")
                        && !lexemaAsignacion.matches("::")
                        && !lexemaAsignacion.matches("<:")
                        && !lexemaAsignacion.matches(">:")
                        && !lexemaAsignacion.matches("\\|\\|")
                        && !lexemaAsignacion.matches("^[(|)|{|}|,|;]$")
                        && !lexemaAsignacion.matches("^[-|+|*|/|%|=]$")
                        && !lexemaAsignacion.matches("&&")
                        && !lexemaAsignacion.matches("&")
                        ) {
                    // si hay un identificador no declarado
                    String identificador = (String) tablaDatos.getValueAt(palabras.indexOf(lexemaAsignacion), 1);
                    if (identificador == null) {
                        contadorERSem++;
                        tipoError = "Variable no declarada";
                        TablaErrores(lexemaAsignacion, token, tipoError, contadorERSem, filaErrores,
                                contadorLinea);
                        filaErrores++;
                    } else if (asignacion && tipoAsignacion != null) {
                        //reglas de TIN
                        if (tipoAsignacion.equals("TIN") && !tipoDato.equals("TIN")) {
                            contadorERSem++;
                            tipoError = "Incompatibilidad de tipos >TIN";
                            TablaErrores(lexemaAsignacion, token, tipoError, contadorERSem, filaErrores,
                                    contadorLinea);
                            filaErrores++;
                        } //reglas de FOAT
                        else if (tipoAsignacion.equals("FOAT")
                                && !(tipoDato.equals("FOAT") || tipoDato.equals("TIN"))) {
                            contadorERSem++;
                            tipoError = "Incompatibilidad de tipos >FOAT";
                            TablaErrores(lexemaAsignacion, token, tipoError, contadorERSem, filaErrores,
                                    contadorLinea);
                            filaErrores++;
                            
                        } //reglas de LOB
                        else if (tipoAsignacion.equals("LOB") && !(tipoDato.equals("LOB"))) {
                            contadorERSem++;
                            tipoError = "Incompatibilidad de tipos >LOB";
                            TablaErrores(lexemaAsignacion, token, tipoError, contadorERSem, filaErrores,
                                    contadorLinea);
                            filaErrores++;
                        }
                        asignacion = false;
                    }
                }
                //asignacion para la comparacion de tipos o asignacion
                if (lexemaAsignacion.equals("=")) {
                    asignacion = true;
                }
                if (lexemaAsignacion.equals("+")) {
                    asignacion = true;
                }
                if (lexemaAsignacion.equals("-")) {
                    asignacion = true;
                }
                if (lexemaAsignacion.equals("*")) {
                    asignacion = true;
                }
                if (lexemaAsignacion.equals("/")) {
                    asignacion = true;
                }
                lexemaAsignacion = "";
            }
        }
    }

    public void TablaErrores(String lexem, String error, String tipoError, int contadorErrores,
            int contadorFilaTablaErrores, int contadorLinea) {
        jTablaError.setValueAt(error + contadorErrores, contadorFilaTablaErrores, 0);// llena el token
        jTablaError.setValueAt(lexem, contadorFilaTablaErrores, 1);//llena el lexema
        jTablaError.setValueAt(contadorLinea, contadorFilaTablaErrores, 2);// llena la linea
        jTablaError.setValueAt(tipoError, contadorFilaTablaErrores, 3);// llena la descripcion
    }


    
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
        jScrollPane3 = new javax.swing.JScrollPane();
        jTablaError = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("ANALIZAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        areaTexto.setColumns(20);
        areaTexto.setRows(5);
        areaTexto.setAutoscrolls(false);
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
        tablaDatos.setSelectionBackground(new java.awt.Color(255, 153, 0));
        jScrollPane2.setViewportView(tablaDatos);

        jLabel1.setText("ESCRIBE ACA TU CODIGO: ");

        jButton2.setText("TEXTO DE PRUEBA");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTablaError.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Token error", "Lexema", "Renglon", "Descripcion"
            }
        ));
        jTablaError.setSelectionBackground(new java.awt.Color(255, 153, 0));
        jScrollPane3.setViewportView(jTablaError);

        jLabel2.setText("COMPILADOR EQUIPO14 7SB");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButton1)
                                    .addGap(56, 56, 56))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jButton2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(305, 305, 305))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    lexemasCodigo = areaTexto.getText();
    System.out.println(lexemasCodigo);
    tablaLexema(lexemasCodigo);
    columnaLexema();
    identificarLexema(lexemasCodigo);
    columnaTipo();
    identificarErrores(lexemasCodigo);
    System.out.println(lexemasCodigo);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        areaTexto.setText("""
                          TIN VM2904 , DN2401 , AAalan , 20as12 ; 
                          FOAT PAmama , MApapa , 20bs10 ; 
                          LOB AAbaba , MP2040 , MR1999 ; 
                          DN2401 = 20as12 - AAalan ; 
                          PAmama = 20 + 20as12 ; 
                          20as12 = 30 ;
                          AAalan = 80 ;
                          VM2904 = 150 ;
                          20bs10 = 125.36 ;
                          MApapa = PAmama / 2 ;
                          AAbaba = "Hola" ; 
                          """);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTablaError;
    private javax.swing.JTable tablaDatos;
    // End of variables declaration//GEN-END:variables
}
