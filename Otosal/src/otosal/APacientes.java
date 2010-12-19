/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * APacientes.java
 *
 * Created on 22-oct-2009, 19:02:00
 */

package otosal;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;


/**
 *
 * @author Portatil An
 */
public class APacientes extends javax.swing.JDialog {

    DefaultTableModel modelo = new DefaultTableModel();

    static final String ControladorJDBC = "org.sqlite.JDBC";
    static final String baseDatos = "jdbc:sqlite:Otosal.sqlite";
    String sql ="";
    private Connection conexion;
    private Statement instruccion;

    /** Creates new form APacientes */
    public APacientes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        try{
            Class.forName(ControladorJDBC);
            conexion = DriverManager.getConnection(baseDatos);
            instruccion = conexion.createStatement();
            System.out.println("Base de datos cargada");
           }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Error en la base de datos", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
           }finally{
           }
        sql="select * from TempPaci";
        CargaTabla();
        RBHembra.setSelected(true);
        BAnadir.setEnabled(false);
        BCancel.setEnabled(false);
        BVisitas.setEnabled(false);
        TFCodPac.setEditable(false);
        TFNom.setEditable(false);
        TFDirec.setEditable(false);
        TFPob.setEditable(false);
        TFCP.setEditable(false);
        TFProv.setEditable(false);
        TFTelef.setEditable(false);
        TFTelfMov.setEditable(false);
        TFEmail.setEditable(false);
        TFFechNac.setEditable(false);
        TFEdad.setEditable(false);
        PBuscar.setVisible(false);
    }

    public void CargaTabla2 () {
        //Con  este metodo lo que hago es cargar la tabla de las busquedas
        modelo.setColumnCount(0);
	modelo.setRowCount(0);
	modelo.addColumn("Cod. Paciente");
	modelo.addColumn("Paciente");
        try {
            //Cambiar pacientes por pacientes temporal
            ResultSet rs = instruccion.executeQuery(sql);
             if ( !rs.isClosed() ) {
                 Object [] fila = new Object[2];
                 while (rs.next()) {
                    fila[0]=rs.getInt(1);
                    fila[1]=rs.getString(2);
                    modelo.addRow(fila);
                 }
             }
        } catch (Exception e) {System.out.println(e);}
    }
    public void CargaTabla () {
        //Cargo primero la tabla y por ultimo compruebo si hay seleccionado algun paciente en la tabla temporal
        //si hay alguno seleccionado solo muestro el seleccionado y si no lo hay, muestro todos los pacientes que
        //no esten traspasados al historico.
        modelo.setColumnCount(0);
	modelo.setRowCount(0);
	modelo.addColumn("Cod. Paciente");
	modelo.addColumn("Paciente");
        try {
            //Cambiar pacientes por pacientes temporal
            ResultSet rs = instruccion.executeQuery(sql);
            rs.next();
            if ( !rs.isClosed() ) {
                Object [] fila = new Object[2];
                fila[0]=rs.getInt(1);
                fila[1]=rs.getString(2);
                modelo.addRow(fila);
                BSelec.setText("Cerrar Consulta");
                BBorrar.setEnabled(false);
                BNuevo.setEnabled(false);
                BBusqueda.setEnabled(false);
                BHistorial.setEnabled(true);
            } else {
                //Esto es para cuando en la tabla temporal no tengo paciente seleccionado,
                //se muestra los de la tabla pacientes
                rs = instruccion.executeQuery("select * from Pacientes where Historico like 'No' order by id;");
                if ( !rs.isClosed() ) {
                    //Activar solo el boton de visitas del panel Añadir
                    Object [] fila = new Object[2];
                    while (rs.next()) {
                        fila[0]=rs.getInt(1);
                        fila[1]=rs.getString(2);
                        modelo.addRow(fila);
                    }
                    BBorrar.setEnabled(true);
                    BNuevo.setEnabled(true);
                    BBusqueda.setEnabled(true);
                    BHistorial.setEnabled(false);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(APacientes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BGSex = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TPac = new javax.swing.JTable();
        PDatos = new javax.swing.JPanel();
        LCodPac = new javax.swing.JLabel();
        LNom = new javax.swing.JLabel();
        LDire = new javax.swing.JLabel();
        LPoblacion = new javax.swing.JLabel();
        LCP = new javax.swing.JLabel();
        LProv = new javax.swing.JLabel();
        LTelf = new javax.swing.JLabel();
        LTelefMov = new javax.swing.JLabel();
        LEmail = new javax.swing.JLabel();
        LFechNac = new javax.swing.JLabel();
        LEdad = new javax.swing.JLabel();
        PSex = new javax.swing.JPanel();
        RBVaron = new javax.swing.JRadioButton();
        RBHembra = new javax.swing.JRadioButton();
        TFCodPac = new javax.swing.JTextField();
        TFNom = new javax.swing.JTextField();
        TFDirec = new javax.swing.JTextField();
        TFPob = new javax.swing.JTextField();
        TFCP = new javax.swing.JTextField();
        TFProv = new javax.swing.JTextField();
        TFTelef = new javax.swing.JTextField();
        TFTelfMov = new javax.swing.JTextField();
        TFEmail = new javax.swing.JTextField();
        TFFechNac = new javax.swing.JTextField();
        TFEdad = new javax.swing.JTextField();
        PBuscar = new javax.swing.JPanel();
        TFNomBusqueda = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        BRestBusq = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        BNuevo = new javax.swing.JButton();
        BModif = new javax.swing.JButton();
        BBusqueda = new javax.swing.JButton();
        BSelec = new javax.swing.JButton();
        BSalir = new javax.swing.JButton();
        BBorrar = new javax.swing.JButton();
        PAnadir = new javax.swing.JPanel();
        BAnadir = new javax.swing.JButton();
        BCancel = new javax.swing.JButton();
        BVisitas = new javax.swing.JButton();
        BHistorial = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(APacientes.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setBackground(resourceMap.getColor("Form.background")); // NOI18N
        setName("Form"); // NOI18N
        setResizable(false);

        jPanel1.setBackground(resourceMap.getColor("jPanel1.background")); // NOI18N
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setName("jPanel1"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        TPac.setBackground(resourceMap.getColor("TPac.background")); // NOI18N
        TPac.setModel(modelo
        );
        TPac.setName("TPac"); // NOI18N
        TPac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TPacMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TPac);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                .addContainerGap())
        );

        PDatos.setBackground(resourceMap.getColor("PDatos.background")); // NOI18N
        PDatos.setBorder(javax.swing.BorderFactory.createEtchedBorder(resourceMap.getColor("PDatos.border.highlightColor"), null)); // NOI18N
        PDatos.setName("PDatos"); // NOI18N

        LCodPac.setText(resourceMap.getString("LCodPac.text")); // NOI18N
        LCodPac.setName("LCodPac"); // NOI18N

        LNom.setText(resourceMap.getString("LNom.text")); // NOI18N
        LNom.setName("LNom"); // NOI18N

        LDire.setText(resourceMap.getString("LDire.text")); // NOI18N
        LDire.setName("LDire"); // NOI18N

        LPoblacion.setText(resourceMap.getString("LPoblacion.text")); // NOI18N
        LPoblacion.setName("LPoblacion"); // NOI18N

        LCP.setText(resourceMap.getString("LCP.text")); // NOI18N
        LCP.setName("LCP"); // NOI18N

        LProv.setText(resourceMap.getString("LProv.text")); // NOI18N
        LProv.setName("LProv"); // NOI18N

        LTelf.setText(resourceMap.getString("LTelf.text")); // NOI18N
        LTelf.setName("LTelf"); // NOI18N

        LTelefMov.setText(resourceMap.getString("LTelefMov.text")); // NOI18N
        LTelefMov.setName("LTelefMov"); // NOI18N

        LEmail.setText(resourceMap.getString("LEmail.text")); // NOI18N
        LEmail.setName("LEmail"); // NOI18N

        LFechNac.setText(resourceMap.getString("LFechNac.text")); // NOI18N
        LFechNac.setName("LFechNac"); // NOI18N

        LEdad.setText(resourceMap.getString("LEdad.text")); // NOI18N
        LEdad.setName("LEdad"); // NOI18N

        PSex.setBackground(resourceMap.getColor("PSex.background")); // NOI18N
        PSex.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceMap.getString("PSex.border.title"))); // NOI18N
        PSex.setToolTipText(resourceMap.getString("PSex.toolTipText")); // NOI18N
        PSex.setName("PSex"); // NOI18N

        RBVaron.setBackground(resourceMap.getColor("RBVaron.background")); // NOI18N
        BGSex.add(RBVaron);
        RBVaron.setText(resourceMap.getString("RBVaron.text")); // NOI18N
        RBVaron.setName("RBVaron"); // NOI18N
        RBVaron.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBVaronActionPerformed(evt);
            }
        });

        RBHembra.setBackground(resourceMap.getColor("RBHembra.background")); // NOI18N
        BGSex.add(RBHembra);
        RBHembra.setText(resourceMap.getString("RBHembra.text")); // NOI18N
        RBHembra.setName("RBHembra"); // NOI18N
        RBHembra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBHembraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PSexLayout = new javax.swing.GroupLayout(PSex);
        PSex.setLayout(PSexLayout);
        PSexLayout.setHorizontalGroup(
            PSexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PSexLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(PSexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RBVaron)
                    .addComponent(RBHembra))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        PSexLayout.setVerticalGroup(
            PSexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PSexLayout.createSequentialGroup()
                .addComponent(RBVaron)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(RBHembra)
                .addContainerGap())
        );

        TFCodPac.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        TFCodPac.setText(resourceMap.getString("TFCodPac.text")); // NOI18N
        TFCodPac.setName("TFCodPac"); // NOI18N

        TFNom.setText(resourceMap.getString("TFNom.text")); // NOI18N
        TFNom.setName("TFNom"); // NOI18N

        TFDirec.setText(resourceMap.getString("TFDirec.text")); // NOI18N
        TFDirec.setName("TFDirec"); // NOI18N

        TFPob.setText(resourceMap.getString("TFPob.text")); // NOI18N
        TFPob.setName("TFPob"); // NOI18N

        TFCP.setText(resourceMap.getString("TFCP.text")); // NOI18N
        TFCP.setName("TFCP"); // NOI18N
        TFCP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TFCPKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TFCPKeyTyped(evt);
            }
        });

        TFProv.setText(resourceMap.getString("TFProv.text")); // NOI18N
        TFProv.setName("TFProv"); // NOI18N

        TFTelef.setColumns(9);
        TFTelef.setText(resourceMap.getString("TFTelef.text")); // NOI18N
        TFTelef.setName("TFTelef"); // NOI18N
        TFTelef.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TFTelefKeyTyped(evt);
            }
        });

        TFTelfMov.setColumns(9);
        TFTelfMov.setText(resourceMap.getString("TFTelfMov.text")); // NOI18N
        TFTelfMov.setName("TFTelfMov"); // NOI18N
        TFTelfMov.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TFTelfMovKeyTyped(evt);
            }
        });

        TFEmail.setText(resourceMap.getString("TFEmail.text")); // NOI18N
        TFEmail.setName("TFEmail"); // NOI18N
        TFEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TFEmailFocusLost(evt);
            }
        });

        TFFechNac.setText(resourceMap.getString("TFFechNac.text")); // NOI18N
        TFFechNac.setName("TFFechNac"); // NOI18N
        TFFechNac.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TFFechNacFocusLost(evt);
            }
        });

        TFEdad.setText(resourceMap.getString("TFEdad.text")); // NOI18N
        TFEdad.setName("TFEdad"); // NOI18N

        PBuscar.setBackground(resourceMap.getColor("PBuscar.background")); // NOI18N
        PBuscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PBuscar.setName("PBuscar"); // NOI18N

        TFNomBusqueda.setText(resourceMap.getString("TFNomBusqueda.text")); // NOI18N
        TFNomBusqueda.setName("TFNomBusqueda"); // NOI18N
        TFNomBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TFNomBusquedaKeyPressed(evt);
            }
        });

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        BRestBusq.setText(resourceMap.getString("BRestBusq.text")); // NOI18N
        BRestBusq.setToolTipText(resourceMap.getString("BRestBusq.toolTipText")); // NOI18N
        BRestBusq.setName("BRestBusq"); // NOI18N
        BRestBusq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BRestBusqActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PBuscarLayout = new javax.swing.GroupLayout(PBuscar);
        PBuscar.setLayout(PBuscarLayout);
        PBuscarLayout.setHorizontalGroup(
            PBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PBuscarLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(TFNomBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BRestBusq, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        PBuscarLayout.setVerticalGroup(
            PBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFNomBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(BRestBusq)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        javax.swing.GroupLayout PDatosLayout = new javax.swing.GroupLayout(PDatos);
        PDatos.setLayout(PDatosLayout);
        PDatosLayout.setHorizontalGroup(
            PDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PDatosLayout.createSequentialGroup()
                        .addGroup(PDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(LPoblacion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LDire, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LNom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LCodPac, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(LCP)
                            .addComponent(LProv)
                            .addComponent(LTelf)
                            .addComponent(LFechNac)
                            .addComponent(LEmail))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PDatosLayout.createSequentialGroup()
                                .addGroup(PDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TFTelef, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TFFechNac, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(48, 48, 48)
                                .addGroup(PDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PDatosLayout.createSequentialGroup()
                                        .addComponent(LTelefMov)
                                        .addGap(18, 18, 18)
                                        .addComponent(TFTelfMov, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PDatosLayout.createSequentialGroup()
                                        .addComponent(LEdad)
                                        .addGap(18, 18, 18)
                                        .addComponent(TFEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(TFCP, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(TFPob)
                                .addComponent(TFNom, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                                .addComponent(TFDirec)
                                .addComponent(TFCodPac, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TFProv, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                            .addComponent(TFEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)))
                    .addGroup(PDatosLayout.createSequentialGroup()
                        .addGroup(PDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                        .addComponent(PBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        PDatosLayout.setVerticalGroup(
            PDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LCodPac)
                    .addComponent(TFCodPac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LNom)
                    .addComponent(TFNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LDire)
                    .addComponent(TFDirec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LPoblacion)
                    .addComponent(TFPob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LCP)
                    .addComponent(TFCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LProv)
                    .addComponent(TFProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LTelf)
                    .addComponent(LTelefMov)
                    .addComponent(TFTelef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TFTelfMov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LEmail)
                    .addComponent(TFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LFechNac)
                    .addComponent(LEdad)
                    .addComponent(TFFechNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TFEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(1, 1, 1)
                .addGroup(PDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PDatosLayout.createSequentialGroup()
                        .addComponent(PSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addComponent(PBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel3.setBackground(resourceMap.getColor("jPanel3.background")); // NOI18N
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setName("jPanel3"); // NOI18N

        BNuevo.setText(resourceMap.getString("BNuevo.text")); // NOI18N
        BNuevo.setToolTipText(resourceMap.getString("BNuevo.toolTipText")); // NOI18N
        BNuevo.setName("BNuevo"); // NOI18N
        BNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BNuevoActionPerformed(evt);
            }
        });

        BModif.setText(resourceMap.getString("BModif.text")); // NOI18N
        BModif.setToolTipText(resourceMap.getString("BModif.toolTipText")); // NOI18N
        BModif.setName("BModif"); // NOI18N
        BModif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BModifActionPerformed(evt);
            }
        });

        BBusqueda.setText(resourceMap.getString("BBusqueda.text")); // NOI18N
        BBusqueda.setToolTipText(resourceMap.getString("BBusqueda.toolTipText")); // NOI18N
        BBusqueda.setName("BBusqueda"); // NOI18N
        BBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BBusquedaActionPerformed(evt);
            }
        });

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance().getContext().getActionMap(APacientes.class, this);
        BSelec.setAction(actionMap.get("BotonSelect")); // NOI18N
        BSelec.setText(resourceMap.getString("BSelec.text")); // NOI18N
        BSelec.setToolTipText(resourceMap.getString("BSelec.toolTipText")); // NOI18N
        BSelec.setName("BSelec"); // NOI18N
        BSelec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSelecActionPerformed(evt);
            }
        });

        BSalir.setText(resourceMap.getString("BSalir.text")); // NOI18N
        BSalir.setToolTipText(resourceMap.getString("BSalir.toolTipText")); // NOI18N
        BSalir.setName("BSalir"); // NOI18N
        BSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSalirActionPerformed(evt);
            }
        });

        BBorrar.setText(resourceMap.getString("BBorrar.text")); // NOI18N
        BBorrar.setToolTipText(resourceMap.getString("BBorrar.toolTipText")); // NOI18N
        BBorrar.setName("BBorrar"); // NOI18N
        BBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BNuevo)
                .addGap(18, 18, 18)
                .addComponent(BModif)
                .addGap(18, 18, 18)
                .addComponent(BBusqueda)
                .addGap(18, 18, 18)
                .addComponent(BSelec)
                .addGap(18, 18, 18)
                .addComponent(BBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(744, Short.MAX_VALUE)
                .addComponent(BSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BNuevo)
                    .addComponent(BModif)
                    .addComponent(BBusqueda)
                    .addComponent(BSelec)
                    .addComponent(BBorrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(BSalir)
                .addContainerGap())
        );

        PAnadir.setBackground(resourceMap.getColor("PAnadir.background")); // NOI18N
        PAnadir.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PAnadir.setName("PAnadir"); // NOI18N

        BAnadir.setText(resourceMap.getString("BAnadir.text")); // NOI18N
        BAnadir.setToolTipText(resourceMap.getString("BAnadir.toolTipText")); // NOI18N
        BAnadir.setName("BAnadir"); // NOI18N
        BAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAnadirActionPerformed(evt);
            }
        });

        BCancel.setText(resourceMap.getString("BCancel.text")); // NOI18N
        BCancel.setToolTipText(resourceMap.getString("BCancel.toolTipText")); // NOI18N
        BCancel.setName("BCancel"); // NOI18N
        BCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCancelActionPerformed(evt);
            }
        });

        BVisitas.setText(resourceMap.getString("BVisitas.text")); // NOI18N
        BVisitas.setToolTipText(resourceMap.getString("BVisitas.toolTipText")); // NOI18N
        BVisitas.setName("BVisitas"); // NOI18N

        BHistorial.setText(resourceMap.getString("BHistorial.text")); // NOI18N
        BHistorial.setName("BHistorial"); // NOI18N
        BHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BHistorialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PAnadirLayout = new javax.swing.GroupLayout(PAnadir);
        PAnadir.setLayout(PAnadirLayout);
        PAnadirLayout.setHorizontalGroup(
            PAnadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PAnadirLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PAnadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BHistorial, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(BCancel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(BAnadir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(BVisitas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
                .addContainerGap())
        );
        PAnadirLayout.setVerticalGroup(
            PAnadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PAnadirLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(BAnadir)
                .addGap(18, 18, 18)
                .addComponent(BCancel)
                .addGap(18, 18, 18)
                .addComponent(BVisitas)
                .addGap(18, 18, 18)
                .addComponent(BHistorial)
                .addContainerGap(324, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PAnadir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PAnadir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSalirActionPerformed
        /*
         * Para no bloquear la base de datos, es necesario cerrar la conexión al cerrar.
         */
        try {
            this.conexion.close();
            System.out.println("Conexión cerrada");
        } catch (Exception e){
            e.printStackTrace();
        }
        dispose();
    }//GEN-LAST:event_BSalirActionPerformed

    private void RBVaronActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBVaronActionPerformed
  
    }//GEN-LAST:event_RBVaronActionPerformed

    private void RBHembraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBHembraActionPerformed
   
    }//GEN-LAST:event_RBHembraActionPerformed

    private void BSelecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSelecActionPerformed
        //Aqui guardo en la tabla temporal los datos del paciente seleccionado
        if (BSelec.getText().equals("Seleccionar")) {
            if (!TFNom.getText().equals("")) {
                String sex =new String();
                if (RBVaron.isSelected()) {
                        sex = "Varon";
                    } else {
                        sex = "Mujer";
                    }
                try {
                    instruccion.executeUpdate("insert into TempPaci values ("+TFCodPac.getText() + ", '"+TFNom.getText()+ "', '" +TFDirec.getText()+ "', '" + TFPob.getText()+ "', '" + TFCP.getText() +
                            "', '" + TFProv.getText()+ "', '" + TFTelef.getText()+ "', '" + TFTelfMov.getText() +"', '"+ TFEmail.getText()+"', '" + TFFechNac.getText() + "', '" + sex + "', 'No')");
                    sql="select * from TempPaci";
                    CargaTabla();
                    aNull();
                    BBorrar.setEnabled(false);
                    BNuevo.setEnabled(false);
                    BBusqueda.setEnabled(false);
                    BHistorial.setEnabled(true);
                    BSelec.setText("Cerrar Consulta");

                    JOptionPane.showMessageDialog(null, "Paciente seleccionado correctamente",
                    "Otoño Salud", JOptionPane.INFORMATION_MESSAGE + JOptionPane.OK_OPTION);
                } catch (Exception e) {
                     System.out.println(e);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debes seleccionar un Paciente",
                    "Otoño Salud", JOptionPane.ERROR_MESSAGE + JOptionPane.OK_OPTION);
            }
        } else {
            try {
                instruccion.execute("DELETE FROM TempPaci");
                instruccion.close();
                instruccion = conexion.createStatement();
                sql="select * from Pacientes where Historico like 'No' order by id;";
                    CargaTabla2();
                    aNull();
                    BBorrar.setEnabled(true);
                    BNuevo.setEnabled(true);
                    BBusqueda.setEnabled(true);
                    BHistorial.setEnabled(false);
                    BSelec.setText("Seleccionar");
                    JOptionPane.showMessageDialog(null, "Consulta terminada correctamente",
                    "Otoño Salud", JOptionPane.INFORMATION_MESSAGE + JOptionPane.OK_OPTION);
            } catch( Exception e) {System.out.println(e);}
        }
    }//GEN-LAST:event_BSelecActionPerformed

    private void TPacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TPacMouseClicked
        //cuando de un click sobre la tabla muestro todos los campos de la bbdd del paciente seleccionado
        if (evt.getClickCount()==1) {
            int linea = TPac.getSelectedRow();
            try {
                ResultSet rs = instruccion.executeQuery("select * from Pacientes where historico='No' and id=" + (Integer) modelo.getValueAt(linea, 0));
                rs.next();
                Integer Cod = rs.getInt(1);
                TFCodPac.setText(Cod.toString());
                String Nom = rs.getString(2);
                TFNom.setText(Nom);
                String Direcc = rs.getString(3);
                TFDirec.setText(Direcc);
                String Poblac = rs.getString(4);
                TFPob.setText(Poblac);
                Integer cp = rs.getInt(5);
                TFCP.setText(cp.toString());
                String Prov = rs.getString(6);
                TFProv.setText(Prov);
                String Telef = rs.getString(7);
                TFTelef.setText(Telef);
                String Movil = rs.getString(8);
                TFTelfMov.setText(Movil);
                String email = rs.getString(9);
                TFEmail.setText(email);
                String fecha =  rs.getString(10);
                TFFechNac.setText(rs.getString(10));
                //Calcular la edad
                Integer edad = calcularEdad(fecha);
                TFEdad.setText(edad.toString());

                String sexo = rs.getString(11);
                if (sexo.equals("Varon")) {
                    RBVaron.setSelected(true);
                    RBHembra.setSelected(false);
                } else {
                    RBVaron.setSelected(false);
                    RBHembra.setSelected(true);
                }
                rs.close();
                instruccion.close();
            } catch (SQLException ex) {
                Logger.getLogger(APacientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_TPacMouseClicked

    public void aNull () {
        //Pongo todos los campos vacios para poder actuar con ellos si es necesario
        TFCodPac.setText("");
        TFNom.setText("");
        TFDirec.setText("");
        TFPob.setText("");
        TFCP.setText("");
        TFProv.setText("");
        TFTelef.setText("");
        TFTelfMov.setText("");
        TFEmail.setText("");
        TFFechNac.setText("");
        TFEdad.setText("");
        RBHembra.setSelected(true);
        RBVaron.setSelected(false);
    }


    private void BNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BNuevoActionPerformed
        
        int cdg = new Integer(0);
        try {
            ResultSet rs = instruccion.executeQuery("SELECT count (*) as  id FROM Pacientes");
            rs.next();
            cdg = rs.getInt(1) + 1;
            System.out.println(cdg);
        }catch(Exception e){}
        //Variable para que solo se puedan meter 25 pacientes DESCOMENTAR
        //if (cdg< 7) {
            aNull();
            TFCodPac.setText(Integer.toString(cdg));
            TFNom.setEditable(true);
            TFDirec.setEditable(true);
            TFPob.setEditable(true);
            TFCP.setEditable(true);
            TFProv.setEditable(true);
            TFTelef.setEditable(true);
            TFTelfMov.setEditable(true);
            TFEmail.setEditable(true);
            TFFechNac.setEditable(true);
            TFNom.requestFocus();
            BNuevo.setEnabled(false);
            BModif.setEnabled(false);
            BBusqueda.setEnabled(false);
            PBuscar.setVisible(false);
            BBusqueda.setText("Busqueda");
            BSelec.setEnabled(false);
            BSalir.setEnabled(false);
            BBorrar.setEnabled(false);
            BAnadir.setEnabled(true);
            BCancel.setEnabled(true);
            BVisitas.setEnabled(false);
            BHistorial.setEnabled(true);
        //Descomentar para que solo se puedan meter 25 pacientes
        /*} else {
            JOptionPane.showMessageDialog(null, "Has alcanzado el limite maximo de pacientes",
                    "Otoño Salud", JOptionPane.ERROR_MESSAGE);
        }*/
    }//GEN-LAST:event_BNuevoActionPerformed

     //metodo para validar correo electronio
    public boolean isEmail(String correo) {
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
        mat = pat.matcher(correo);
        if (mat.find()) {
            System.out.println("[" + mat.group() + "]");
            return true;
        }else{
            return false;
        }
    }



    //metodo para validar si la fecha es correcta
    public boolean isDate(String fechax) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha = formatoFecha.parse(fechax);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private void TFFechNacFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFFechNacFocusLost
        if (!TFFechNac.getText().equals("")) {
            if (!isDate(TFFechNac.getText()) ) {
                JOptionPane.showMessageDialog(null, "La fecha introducida no es correcta",
                    "Otoño Salud", JOptionPane.ERROR_MESSAGE);
            } else {
                Integer edad = calcularEdad(TFFechNac.getText());
                TFEdad.setText(edad.toString());
            }
        }
    }//GEN-LAST:event_TFFechNacFocusLost

    private void TFEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFEmailFocusLost
        if (!TFEmail.getText().equals("")) {
            if (!isEmail(TFEmail.getText())) {
                JOptionPane.showMessageDialog(null, "El E-mail introducido no es correcto",
                    "Otoño Salud", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_TFEmailFocusLost

    private void BCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCancelActionPerformed
        int n = JOptionPane.showConfirmDialog(null, "¿Quieres cancelar la introduccion de datos?",
                    "Otoño Salud", JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.YES_OPTION) {
            aNull();
            TFNom.setEditable(false);
            TFDirec.setEditable(false);
            TFPob.setEditable(false);
            TFCP.setEditable(false);
            TFProv.setEditable(false);
            TFTelef.setEditable(false);
            TFTelfMov.setEditable(false);
            TFEmail.setEditable(false);
            TFFechNac.setEditable(false);
            BNuevo.setEnabled(true);
            BModif.setEnabled(true);
            BBusqueda.setEnabled(true);
            BSelec.setEnabled(true);
            BSalir.setEnabled(true);
            BBorrar.setEnabled(true);
            BAnadir.setEnabled(false);
            BCancel.setEnabled(false);
            BVisitas.setEnabled(false);
            BHistorial.setEnabled(false);
        }
    }//GEN-LAST:event_BCancelActionPerformed

    private void BBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBorrarActionPerformed
        if (!TFCodPac.getText().equals("")) {
            int n = JOptionPane.showConfirmDialog(null, "¿Quieres borrar el Paciente?",
                        "Otoño Salud", JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION) {
                if (!TFCodPac.getText().equals("")) {
                    try {
                        instruccion.executeQuery("Update Pacientes set Historico = 'Si' where id=" + TFCodPac.getText());
                    }catch (Exception e) {}
                    aNull();
                    CargaTabla();
                }
            }
        }
    }//GEN-LAST:event_BBorrarActionPerformed

    private void BModifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BModifActionPerformed
    if (!TFNom.getText().equals("")) {
        TFNom.setEditable(true);
        TFDirec.setEditable(true);
        TFPob.setEditable(true);
        TFCP.setEditable(true);
        TFProv.setEditable(true);
        TFTelef.setEditable(true);
        TFTelfMov.setEditable(true);
        TFEmail.setEditable(true);
        TFFechNac.setEditable(true);
        TFNom.requestFocus();
        TFNom.selectAll();
        BNuevo.setEnabled(false);
        BModif.setEnabled(false);
        BBusqueda.setEnabled(false);
        BBusqueda.setText("Busqueda");
        BSelec.setEnabled(false);
        BSalir.setEnabled(false);
        BBorrar.setEnabled(false);
        BAnadir.setEnabled(true);
        PBuscar.setVisible(false);
        BAnadir.setText("Modificar");
        BCancel.setEnabled(true);
        BVisitas.setEnabled(false);
        BHistorial.setEnabled(false);
    }
    }//GEN-LAST:event_BModifActionPerformed

    private void BAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAnadirActionPerformed
      if (!TFNom.getText().equals("") && !TFFechNac.getText().equals("")) {
        int n = JOptionPane.showConfirmDialog(null, "¿Quieres guardar el Paciente?",
                    "Otoño Salud", JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.YES_OPTION) {
            String temp1 = new String(TFCodPac.getText());
            String temp2 = new String (TFNom.getText());
            String temp3 = new String ("");
            if (!TFDirec.getText().equals(""))
                temp3 = TFDirec.getText();
            String temp4 = new String ("");
            if (!TFPob.getText().equals(""))
                temp4 = TFPob.getText();
            String temp5 = new String ("");
            if (!TFCP.getText().equals(""))
                temp5 = TFCP.getText();
            else
                temp5 = "0";
            String temp6 = new String ("");
            if (!TFProv.getText().equals(""))
                temp6 = TFProv.getText();
            String temp7 = new String ("");
            if (!TFTelef.getText().equals(""))
                temp7 = TFTelef.getText();
            else
                temp7 = "0";
            String temp8 = new String ("");
            if (!TFTelfMov.getText().equals(""))
                temp8 = TFTelfMov.getText();
            else
                temp8 = "0";
            String temp9 = new String("");
            if (!TFEmail.getText().equals(""))
                temp9 = TFEmail.getText();
            String temp10 = new String ("");
            if (!TFFechNac.getText().equals(""))
                temp10 = TFFechNac.getText();
            String sexo = new String("");
                    if (RBVaron.isSelected())
                        sexo = "Varon";
                    else if (RBHembra.isSelected())
                        sexo = "Mujer";
            if (BAnadir.getText().equals("Modificar")) {
                BAnadir.setText("Añadir");
                //Inserto una sql para modificar el registro
                    try {
                        instruccion.executeUpdate("UPDATE Pacientes set Nombre = '" + temp2 +
                             "', Direccion = '" + temp3 + "', Poblacion = '" + temp4 + "', cp = "  + Integer.parseInt(temp5) +
                             ", Provincia = '" + temp6 + "', Telefono = " + Integer.parseInt(temp7) + ", Movil = " + Integer.parseInt(temp8) +
                             ", Email = '" + temp9 + "', FechNac = '" + temp10 + "', sexo = '" + sexo + "', Historico = 'No' where id = " + temp1 );
                    } catch (Exception e) {System.out.println(e);}
            } else {
                //Inserto una sql para añadir el paciente a la tabla
                try {
                    instruccion.execute("insert into TempPaci values ('" + temp1 + "', '" + temp2 +
                             "', '" + temp3 + "', '" + temp4 + "', "  + Integer.parseInt(temp5) +
                             ", '" + temp6 + "', " + Integer.parseInt(temp7) + ", " + Integer.parseInt(temp8) +
                             ", '" + temp9 + "', '" + temp10 + "', '" + sexo + "', 'No')");
                    instruccion.executeUpdate("INSERT INTO Pacientes SELECT * FROM TempPaci");
                } catch(Exception e) {System.out.println(e);}
                //Como lo guardo en la tabla temporal muestro el temporal
                sql="select * from TempPaci";
                CargaTabla();
                //Como el paciente es nuevo lo que hago es rellenar el cuestionario inicial
                cuestionario=null;
                    if (cuestionario == null) {
                        JFrame mainFrame = OtosalApp.getApplication().getMainFrame();
                        cuestionario = new Cuestionario(mainFrame, true);
                        cuestionario.setLocationRelativeTo(mainFrame);
                    }
                    OtosalApp.getApplication().show(cuestionario);
            }
            //Pongo los campo a null y a continuacion lo que hago es poner los campos a no editables y los botones a enabled para no utilizarlos
            aNull();
            TFNom.setEditable(false);
            TFDirec.setEditable(false);
            TFPob.setEditable(false);
            TFCP.setEditable(false);
            TFProv.setEditable(false);
            TFTelef.setEditable(false);
            TFTelfMov.setEditable(false);
            TFEmail.setEditable(false);
            TFFechNac.setEditable(false);
            BNuevo.setEnabled(true);
            BModif.setEnabled(true);
            BBusqueda.setEnabled(true);
            BSelec.setEnabled(true);
            BSalir.setEnabled(true);
            BBorrar.setEnabled(true);
            BAnadir.setEnabled(false);
            BCancel.setEnabled(false);
            BVisitas.setEnabled(false);
            BHistorial.setEnabled(false);
        }
      }  else {

      }
    }//GEN-LAST:event_BAnadirActionPerformed

    private void BBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBusquedaActionPerformed
        if (BBusqueda.getText().equals("Ocultar Busqueda")) {
           PBuscar.setVisible(false);
           BBusqueda.setText("Busqueda");
        } else {
           PBuscar.setVisible(true);
           TFNomBusqueda.requestFocus();
           BBusqueda.setText("Ocultar Busqueda");
        }
    }//GEN-LAST:event_BBusquedaActionPerformed

    private void TFNomBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFNomBusquedaKeyPressed
        sql="select * from Pacientes where Historico like 'No' and nombre like '%"+ TFNomBusqueda.getText().toString().toUpperCase() +"%' order by id;";
        CargaTabla2();
    }//GEN-LAST:event_TFNomBusquedaKeyPressed

    private void BRestBusqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRestBusqActionPerformed
        sql="select * from Pacientes where Historico like 'No' order by id;";
        CargaTabla2();
        BBusqueda.setText("");
        PBuscar.setVisible(false);
        BBusqueda.setText("Busqueda");
    }//GEN-LAST:event_BRestBusqActionPerformed

    private void TFCPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFCPKeyTyped
         char caracter = evt.getKeyChar();
      // Verificar si la tecla pulsada no es un digito
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != KeyEvent.VK_BACK_SPACE))
      {
         evt.consume();  // ignorar el evento de teclado
      }
      if (TFCP.getText().length()>4) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_TFCPKeyTyped

    private void TFTelefKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFTelefKeyTyped
         char caracter = evt.getKeyChar();
      // Verificar si la tecla pulsada no es un digito
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != KeyEvent.VK_BACK_SPACE))
      {
         evt.consume();  // ignorar el evento de teclado
      }
       if (TFTelef.getText().length()>11) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_TFTelefKeyTyped

    private void TFTelfMovKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFTelfMovKeyTyped
         char caracter = evt.getKeyChar();
      // Verificar si la tecla pulsada no es un digito
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != KeyEvent.VK_BACK_SPACE))
      {
         evt.consume();  // ignorar el evento de teclado
      }
      if (TFTelfMov.getText().length()>11) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_TFTelfMovKeyTyped

    private void TFCPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFCPKeyPressed
       
    }//GEN-LAST:event_TFCPKeyPressed

    private void BHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BHistorialActionPerformed
    if (!TFNom.getText().equals("")) {
        Document doc = new Document();
        try {
        Font negrita=new Font(Font.COURIER,10,Font.BOLD);
        Font normal = new Font(Font.COURIER, 10, Font.NORMAL);
        PdfWriter.getInstance(doc, new FileOutputStream("informe.pdf"));
        doc.open();
        //Añado los datos del pdf
        doc.addTitle("Informe Personal");
        doc.addSubject("Informe de Paciente");
        doc.addAuthor("Otoño Salud");
        doc.addCreator("Otoño Salud");
        //Ahora creo la hoja
        Paragraph pag = new Paragraph();
        //Primero dejo una linea en blanco
        addEmptyLine(pag, 1);
        pag.add(new Paragraph("Nombre: " + TFNom.getText() + "       Edad: " + TFEdad.getText(), negrita));
        addEmptyLine(pag, 1);
        pag.add(new Paragraph("Medidas antropométricas:", negrita));
        pag.add(new Paragraph("Altura (cm): ", normal));
        pag.add(new Paragraph("Peso Actual (kg): ", normal));
        pag.add(new Paragraph("Peso habitual (kg): ", normal));
        pag.add(new Paragraph("IMC (kg/m2): ", normal));
        pag.add(new Paragraph("Peso deseable (kg): ", normal));
        pag.add(new Paragraph("Porcentaje de Peso deseable (%): ", normal));
        pag.add(new Paragraph("Circunferencia de brazo (cm): ", normal));
        pag.add(new Paragraph("Perimetro muscular del brazo (cm): ", normal));
        pag.add(new Paragraph("Pliegue Tricipital (mm): ", normal));
        pag.add(new Paragraph("Porcentaje de grasa corporal (%): ", normal));
        addEmptyLine(pag, 1);
        pag.add(new Paragraph("Determinaciones bioquímicas:", negrita));
        pag.add(new Paragraph("Albúmina (g/dl): ", normal));
        pag.add(new Paragraph("Prealbúmina (mg/dl): ", normal));
        pag.add(new Paragraph("Transferrina (mg/dl): ", normal));
        pag.add(new Paragraph("Proteina de unión a retinol (mg/dl): ", normal));
        pag.add(new Paragraph("Linfocitos totales (cel/mm3): ", normal));
        pag.add(new Paragraph("Prueba de hiperssensibilidad cutánea: ", normal));
        pag.add(new Paragraph("Indice creatinina/altura (%): ", normal));
        pag.add(new Paragraph("Balance nutricional: ", normal));
        pag.add(new Paragraph("Colesterol total (mg/dl): ", normal));
        pag.add(new Paragraph("LDL-Colesterol (mg/dl): ", normal));
        pag.add(new Paragraph("HDL-Colesterol (mg/dl): ", normal));
        pag.add(new Paragraph("HemoglobinaA1C (%): ", normal));
        addEmptyLine(pag, 1);
        pag.add(new Paragraph("Diagnóstico nutricional:", negrita));
        pag.add(new Paragraph("Indice pronostrico nutricional (IPN): ", normal));
        pag.add(new Paragraph("DETERMINE: ", normal));
        pag.add(new Paragraph("MUST: ", normal));
        pag.add(new Paragraph("MNA: ", normal));
        pag.add(new Paragraph("Pronóstico síndrome metabólico: ", normal));
        pag.add(new Paragraph("Pronóstico riesgo cardiovascular: ", normal));
        pag.add(new Paragraph("Genetic Risk Score: ", normal));
        addEmptyLine(pag, 1);
        pag.add(new Paragraph("Cálculos energéticos:", negrita));
        pag.add(new Paragraph("Gasto energético basal (Kcal/día): ", normal));
        pag.add(new Paragraph("Gasto energético total (Kcal/día): ", normal));
        pag.add(new Paragraph("Ingesta Calórica (Kcal/día): ", normal));
        doc.add(pag);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        doc.close();
        try {
            File path = new File ("informe.pdf");
            Desktop.getDesktop().open(path);
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    } else {
        JOptionPane.showMessageDialog(null, "No has seleccionado ningún Paciente",
                    "Otoño Salud", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_BHistorialActionPerformed

    private static void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}


    public String afecha (String fecha) {
        String ano = new String();
        String mes = new String();
        String dia = new String();
        Integer sw=new Integer(0);
        for (int i=0;i<fecha.length();i++) {
            if (fecha.charAt(i)!= '-') {
                if (sw==0) {
                    ano=ano+fecha.charAt(i);
                } else if (sw==1) {
                    mes=mes +fecha.charAt(i);
                } else {
                    dia=dia +fecha.charAt(i);
                }
            } else {
                sw+=1;
            }

        }
        fecha=dia + "/" + mes + "/" + ano;
        return fecha;
    }
public static int calcularEdad(String fecha){
         String datetext = fecha;
         try {
             Calendar birth = new GregorianCalendar();
             Calendar today = new GregorianCalendar();
             int age = 0;
             int factor = 0;
             Date birthDate = new SimpleDateFormat("dd/MM/yyyy").parse(datetext);
             Date currentDate = new Date(); //current date
             birth.setTime(birthDate);
             today.setTime(currentDate);
             if(today.get(Calendar.MONTH) <= birth.get(Calendar.MONTH)){
                 if(today.get(Calendar.MONTH) == birth.get(Calendar.MONTH)){
                     if(today.get(Calendar.DATE) > birth.get(Calendar.DATE)) {
                         factor = -1; //Aun no celebra su cumpleaños
                     }
                 }else{
                     factor = -1; //Aun no celebra su cumpleaños
                 }
             }
             age =(today.get(Calendar.YEAR) - birth.get(Calendar.YEAR) )+ factor;
             return age;
         } catch (Exception e) {
             return -1;
         }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAnadir;
    private javax.swing.JButton BBorrar;
    private javax.swing.JButton BBusqueda;
    private javax.swing.JButton BCancel;
    private javax.swing.ButtonGroup BGSex;
    private javax.swing.JButton BHistorial;
    private javax.swing.JButton BModif;
    private javax.swing.JButton BNuevo;
    private javax.swing.JButton BRestBusq;
    private javax.swing.JButton BSalir;
    private javax.swing.JButton BSelec;
    private javax.swing.JButton BVisitas;
    private javax.swing.JLabel LCP;
    private javax.swing.JLabel LCodPac;
    private javax.swing.JLabel LDire;
    private javax.swing.JLabel LEdad;
    private javax.swing.JLabel LEmail;
    private javax.swing.JLabel LFechNac;
    private javax.swing.JLabel LNom;
    private javax.swing.JLabel LPoblacion;
    private javax.swing.JLabel LProv;
    private javax.swing.JLabel LTelefMov;
    private javax.swing.JLabel LTelf;
    private javax.swing.JPanel PAnadir;
    private javax.swing.JPanel PBuscar;
    private javax.swing.JPanel PDatos;
    private javax.swing.JPanel PSex;
    private javax.swing.JRadioButton RBHembra;
    private javax.swing.JRadioButton RBVaron;
    private javax.swing.JTextField TFCP;
    private javax.swing.JTextField TFCodPac;
    private javax.swing.JTextField TFDirec;
    private javax.swing.JTextField TFEdad;
    private javax.swing.JTextField TFEmail;
    private javax.swing.JTextField TFFechNac;
    private javax.swing.JTextField TFNom;
    private javax.swing.JTextField TFNomBusqueda;
    private javax.swing.JTextField TFPob;
    private javax.swing.JTextField TFProv;
    private javax.swing.JTextField TFTelef;
    private javax.swing.JTextField TFTelfMov;
    private javax.swing.JTable TPac;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JDialog cuestionario;
}
