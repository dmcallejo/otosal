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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Portatil An
 */
public class HPacientes extends javax.swing.JDialog {

    DefaultTableModel modelo = new DefaultTableModel();

    static final String ControladorJDBC = "org.sqlite.JDBC";
    static final String baseDatos = "jdbc:sqlite:Otosal.sqlite";

    private Connection conexion;
    private Statement instruccion;
    String sql = new String("");

    /** Creates new form APacientes */
    public HPacientes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //Cargo la bbdd
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

        sql = "select * from Pacientes where Historico like 'Si' order by id;";
        // Inicializo la tabla lo primero y luego cargo los datos de los pacientes que estan traspasado al historico.
        CargaTabla();
        //Pongo todos los campos a editable = false para que no se puedan modificar
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
        RBHembra.setEnabled(false);
        RBVaron.setEnabled(false);
        PBuscar.setVisible(false);
        BBusqueda.setText("Busqueda");
    }

    public void CargaTabla () {
        modelo.setColumnCount(0);
	modelo.setRowCount(0);
	modelo.addColumn("Cod. Paciente");
	modelo.addColumn("Paciente");

        try {
            //Cambiar pacientes por pacientes temporal
            ResultSet rs = instruccion.executeQuery(sql);
            while (rs.next()) {
                if ( !rs.isClosed() ) {
                    Object [] fila = new Object[2];
                    fila[0]=rs.getInt(1);
                    fila[1]=rs.getString(2);
                    modelo.addRow(fila);
                }
            }
        } catch (Exception ex) {
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

        BGSexo = new javax.swing.ButtonGroup();
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
        jPanel3 = new javax.swing.JPanel();
        BRecuperar = new javax.swing.JButton();
        BBusqueda = new javax.swing.JButton();
        BSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(otosal.OtosalApp.class).getContext().getResourceMap(HPacientes.class);
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PDatos.setBackground(resourceMap.getColor("PDatos.background")); // NOI18N
        PDatos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
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
        BGSexo.add(RBVaron);
        RBVaron.setText(resourceMap.getString("RBVaron.text")); // NOI18N
        RBVaron.setName("RBVaron"); // NOI18N
        RBVaron.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBVaronActionPerformed(evt);
            }
        });

        RBHembra.setBackground(resourceMap.getColor("RBHembra.background")); // NOI18N
        BGSexo.add(RBHembra);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, Short.MAX_VALUE)
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

        TFProv.setText(resourceMap.getString("TFProv.text")); // NOI18N
        TFProv.setName("TFProv"); // NOI18N

        TFTelef.setText(resourceMap.getString("TFTelef.text")); // NOI18N
        TFTelef.setName("TFTelef"); // NOI18N

        TFTelfMov.setText(resourceMap.getString("TFTelfMov.text")); // NOI18N
        TFTelfMov.setName("TFTelfMov"); // NOI18N

        TFEmail.setText(resourceMap.getString("TFEmail.text")); // NOI18N
        TFEmail.setName("TFEmail"); // NOI18N

        TFFechNac.setText(resourceMap.getString("TFFechNac.text")); // NOI18N
        TFFechNac.setName("TFFechNac"); // NOI18N

        TFEdad.setText(resourceMap.getString("TFEdad.text")); // NOI18N
        TFEdad.setName("TFEdad"); // NOI18N

        PBuscar.setBackground(resourceMap.getColor("PBuscar.background")); // NOI18N
        PBuscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PBuscar.setName("PBuscar"); // NOI18N

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                                    .addComponent(TFFechNac, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48)
                                .addGroup(PDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PDatosLayout.createSequentialGroup()
                                        .addComponent(LEdad)
                                        .addGap(18, 18, 18)
                                        .addComponent(TFEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PDatosLayout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addComponent(LTelefMov)
                                        .addGap(18, 18, 18)
                                        .addComponent(TFTelfMov, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(PBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(TFCP, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(TFProv, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TFPob, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TFNom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                                .addComponent(TFDirec, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TFCodPac, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))
                    .addComponent(PSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel3.setBackground(resourceMap.getColor("jPanel3.background")); // NOI18N
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setName("jPanel3"); // NOI18N

        BRecuperar.setText(resourceMap.getString("BRecuperar.text")); // NOI18N
        BRecuperar.setName("BRecuperar"); // NOI18N
        BRecuperar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BRecuperarActionPerformed(evt);
            }
        });

        BBusqueda.setText(resourceMap.getString("BBusqueda.text")); // NOI18N
        BBusqueda.setName("BBusqueda"); // NOI18N
        BBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BBusquedaActionPerformed(evt);
            }
        });

        BSalir.setText(resourceMap.getString("BSalir.text")); // NOI18N
        BSalir.setName("BSalir"); // NOI18N
        BSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BRecuperar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BBusqueda)
                .addContainerGap(328, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(470, Short.MAX_VALUE)
                .addComponent(BSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BRecuperar)
                    .addComponent(BBusqueda))
                .addGap(18, 18, 18)
                .addComponent(BSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(PDatos, 0, 552, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSalirActionPerformed
        dispose();
    }//GEN-LAST:event_BSalirActionPerformed

    private void RBVaronActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBVaronActionPerformed
        
    }//GEN-LAST:event_RBVaronActionPerformed

    private void RBHembraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBHembraActionPerformed
        
    }//GEN-LAST:event_RBHembraActionPerformed

    private void TFNomBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFNomBusquedaKeyPressed
        sql="select * from Pacientes where Historico like 'Si' and nombre like '%"+ TFNomBusqueda.getText().toString().toUpperCase() +"%' order by id;";
        CargaTabla();
}//GEN-LAST:event_TFNomBusquedaKeyPressed

    private void BRestBusqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRestBusqActionPerformed
        sql="select * from Pacientes where Historico like 'Si' order by id;";
        CargaTabla();
        BBusqueda.setText("");
        PBuscar.setVisible(false);
        BBusqueda.setText("Busqueda");
}//GEN-LAST:event_BRestBusqActionPerformed

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

    private void BRecuperarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRecuperarActionPerformed
        if (!TFCodPac.getText().equals("")) {
            int n = JOptionPane.showConfirmDialog(null, "¿Quieres recuperar el Paciente?",
                        "Otoño Salud", JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION) {
                if (!TFCodPac.getText().equals("")) {
                    try {
                        instruccion.executeQuery("Update Pacientes set Historico = 'No' where id=" + TFCodPac.getText());
                    }catch (Exception e) {}
                    aNull();
                    CargaTabla();
                }
            }
        }
    }//GEN-LAST:event_BRecuperarActionPerformed

    private void TPacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TPacMouseClicked
         if (evt.getClickCount()==1) {
            int linea = TPac.getSelectedRow();
            try {
                ResultSet rs = instruccion.executeQuery("select * from Pacientes where historico='Si' and id=" + (Integer) modelo.getValueAt(linea, 0));
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

            } catch (Exception ex) {
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
    private javax.swing.JButton BBusqueda;
    private javax.swing.ButtonGroup BGSexo;
    private javax.swing.JButton BRecuperar;
    private javax.swing.JButton BRestBusq;
    private javax.swing.JButton BSalir;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
