/*
 *To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AntroAdoles.java
 *
 * Created on 20-may-2010, 20:11:01
 */
package otosal;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.imageio.ImageIO;

/**
 *
 * @author Antonio
 */
public class Anamnesis extends javax.swing.JDialog {

    static final String ControladorJDBC = "org.sqlite.JDBC";
    static final String baseDatos = "jdbc:sqlite:Otosal.sqlite";
    private Connection conexion;
    private Statement instruccion;
    Double edadMes;
    int cod = new Integer(0);
    boolean mujer;

    /** Creates new form AntroAdoles */
    public Anamnesis(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();
        /*
         * Inicialización con los datos de la BBDD
         */
        try {
            Class.forName(ControladorJDBC);
            conexion = DriverManager.getConnection(baseDatos);
            instruccion = conexion.createStatement();
            System.out.println("Base de datos cargada");
            ResultSet rs = instruccion.executeQuery("Select id, Nombre, FechNac, sexo  from TempPaci");
            rs.next();
            TFCod.setText(rs.getString(1));
            TFNombre.setText(rs.getString(2));
            //Nombre de laventana fully customized
            this.setTitle("Antecedentes Personales (" + rs.getString(2) + ")");
            String fechaNac = rs.getString(3);
            Integer edad = calcularEdad(fechaNac);
            edadMes = calcularMeses(fechaNac);
            TFEdad.setText(edad.toString());
            //No se ponían del color de fondo manualmente, así que, lo fuerzo.
            /*jCheckBox1.setBackground(jPanel4.getBackground());
            jCheckBox2.setBackground(jPanel4.getBackground());
            jCheckBox3.setBackground(jPanel4.getBackground());
            jCheckBox4.setBackground(jPanel4.getBackground());
            jCheckBox5.setBackground(jPanel4.getBackground());
            jCheckBox6.setBackground(jPanel4.getBackground());
            jCheckBox7.setBackground(jPanel4.getBackground());
            jCheckBox8.setBackground(jPanel4.getBackground());
            jCheckBox9.setBackground(jPanel4.getBackground());
            jCheckBox10.setBackground(jPanel4.getBackground());
            jCheckBox11.setBackground(jPanel4.getBackground());
            jCheckBox12.setBackground(jPanel4.getBackground());
            jCheckBox13.setBackground(jPanel4.getBackground());
            jCheckBox14.setBackground(jPanel4.getBackground());
            jCheckBox15.setBackground(jPanel4.getBackground());
            jCheckBox16.setBackground(jPanel4.getBackground());
            jCheckBox17.setBackground(jPanel4.getBackground());
            jCheckBox18.setBackground(jPanel4.getBackground());
            jCheckBox19.setBackground(jPanel4.getBackground());
            jCheckBox20.setBackground(jPanel4.getBackground());
            jCheckBox21.setBackground(jPanel4.getBackground());
            jCheckBox22.setBackground(jPanel4.getBackground());
            jCheckBox23.setBackground(jPanel4.getBackground());
            jCheckBox24.setBackground(jPanel4.getBackground());
            jCheckBox25.setBackground(jPanel4.getBackground());
            jCheckBox26.setBackground(jPanel4.getBackground());
            jCheckBox27.setBackground(jPanel4.getBackground());
            jCheckBox28.setBackground(jPanel4.getBackground());
            jCheckBox29.setBackground(jPanel4.getBackground());
            jCheckBox30.setBackground(jPanel4.getBackground());
            jCheckBox31.setBackground(jPanel4.getBackground());
            jCheckBox32.setBackground(jPanel4.getBackground());
            jCheckBox33.setBackground(jPanel4.getBackground());
            jCheckBox34.setBackground(jPanel4.getBackground());
            jCheckBox35.setBackground(jPanel4.getBackground());
            jCheckBox36.setBackground(jPanel4.getBackground());
            jCheckBox37.setBackground(jPanel4.getBackground());
            jCheckBox38.setBackground(jPanel4.getBackground());
            jCheckBox39.setBackground(jPanel4.getBackground());
            jCheckBox40.setBackground(jPanel4.getBackground());
            jCheckBox41.setBackground(jPanel4.getBackground());
            jCheckBox42.setBackground(jPanel4.getBackground());
            jCheckBox43.setBackground(jPanel4.getBackground());
            jCheckBox44.setBackground(jPanel4.getBackground());
            jCheckBox45.setBackground(jPanel4.getBackground());
            jCheckBox46.setBackground(jPanel4.getBackground());
            jCheckBox47.setBackground(jPanel4.getBackground());
            jCheckBox48.setBackground(jPanel4.getBackground());
            jCheckBox49.setBackground(jPanel4.getBackground());
            jCheckBox50.setBackground(jPanel4.getBackground());
            jCheckBox51.setBackground(jPanel4.getBackground());
            jCheckBox52.setBackground(jPanel4.getBackground());
            jCheckBox53.setBackground(jPanel4.getBackground());
            jCheckBox54.setBackground(jPanel4.getBackground());
            jCheckBox55.setBackground(jPanel4.getBackground());
            jCheckBox56.setBackground(jPanel4.getBackground());
            jCheckBox57.setBackground(jPanel4.getBackground());
            jCheckBox58.setBackground(jPanel4.getBackground());
            jCheckBox59.setBackground(jPanel4.getBackground());
            jCheckBox60.setBackground(jPanel4.getBackground());
            jCheckBox61.setBackground(jPanel4.getBackground());
            jCheckBox62.setBackground(jPanel4.getBackground());
            jCheckBox63.setBackground(jPanel4.getBackground());
            jCheckBox64.setBackground(jPanel4.getBackground());
            jCheckBox65.setBackground(jPanel4.getBackground());
            jCheckBox66.setBackground(jPanel4.getBackground());
            jCheckBox67.setBackground(jPanel4.getBackground());
            jCheckBox68.setBackground(jPanel4.getBackground());
            jCheckBox69.setBackground(jPanel4.getBackground());
            jCheckBox70.setBackground(jPanel4.getBackground());
            jCheckBox71.setBackground(jPanel4.getBackground());
            jCheckBox72.setBackground(jPanel4.getBackground());
            jCheckBox73.setBackground(jPanel4.getBackground());
            jCheckBox74.setBackground(jPanel4.getBackground());
            jCheckBox75.setBackground(jPanel4.getBackground());
            jCheckBox76.setBackground(jPanel4.getBackground());
            jCheckBox77.setBackground(jPanel4.getBackground());
            jCheckBox78.setBackground(jPanel4.getBackground());
            jCheckBox79.setBackground(jPanel4.getBackground());
            jCheckBox80.setBackground(jPanel4.getBackground());
            jCheckBox81.setBackground(jPanel4.getBackground());
            jCheckBox82.setBackground(jPanel4.getBackground());
            jCheckBox83.setBackground(jPanel4.getBackground());
            jCheckBox84.setBackground(jPanel4.getBackground());
            jCheckBox85.setBackground(jPanel4.getBackground());
            jCheckBox86.setBackground(jPanel4.getBackground());
            jCheckBox87.setBackground(jPanel4.getBackground());
            jCheckBox88.setBackground(jPanel4.getBackground());
            jCheckBox89.setBackground(jPanel4.getBackground());
            jCheckBox90.setBackground(jPanel4.getBackground());
            jCheckBox91.setBackground(jPanel4.getBackground());
            jCheckBox92.setBackground(jPanel4.getBackground());
            jCheckBox93.setBackground(jPanel4.getBackground());
            jCheckBox94.setBackground(jPanel4.getBackground());
            jCheckBox95.setBackground(jPanel4.getBackground());
            jCheckBox96.setBackground(jPanel4.getBackground());
            jCheckBox97.setBackground(jPanel4.getBackground());
            jCheckBox98.setBackground(jPanel4.getBackground());
            jCheckBox99.setBackground(jPanel4.getBackground());
            jCheckBox100.setBackground(jPanel4.getBackground());
            jCheckBox101.setBackground(jPanel4.getBackground());
            jCheckBox102.setBackground(jPanel4.getBackground());
            jCheckBox103.setBackground(jPanel4.getBackground());
            jCheckBox104.setBackground(jPanel4.getBackground());
            jCheckBox105.setBackground(jPanel4.getBackground());
            jCheckBox106.setBackground(jPanel4.getBackground());
            jCheckBox107.setBackground(jPanel4.getBackground());
            jCheckBox108.setBackground(jPanel4.getBackground());
            jCheckBox109.setBackground(jPanel4.getBackground());
            jCheckBox110.setBackground(jPanel4.getBackground());
            jCheckBox111.setBackground(jPanel4.getBackground());
            if (rs.getString(4).equals("Varon")) {
                mujer = false;
                //Los hombres no tienen vagina, ¿no?
                jCheckBox1.setEnabled((false));
                jCheckBox2.setEnabled((false));
                jCheckBox3.setEnabled((false));
                jCheckBox4.setEnabled((false));
                jTextField4.setEnabled(false);
                jTextField5.setEnabled(false);
                jTextField6.setEnabled(false);
                jTextField7.setEnabled(false);
                jTextField8.setEnabled(false);
                jTextField4.setBackground(Color.LIGHT_GRAY);
                jTextField5.setBackground(Color.LIGHT_GRAY);
                jTextField6.setBackground(Color.LIGHT_GRAY);
                jTextField7.setBackground(Color.LIGHT_GRAY);
                jTextField8.setBackground(Color.LIGHT_GRAY);
            } else if (rs.getString(4).equals("Mujer")) {
                mujer = true;
            }*/
            //Pongo a editable false para que no se pueda modificar
            TFCod.setEditable(false);
            TFNombre.setEditable(false);
            TFEdad.setEditable(false);
            TFLongitud.requestFocus();
            conexion.close();
            jTabbedPane1.setSelectedIndex(0);
        } catch (Exception e) {
            e.printStackTrace();
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

        BGPaper = new javax.swing.ButtonGroup();
        BGGrafica = new javax.swing.ButtonGroup();
        jLabel85 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        BGuardar2 = new javax.swing.JButton();
        BCerrar = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel8 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TFCod = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TFNombre = new javax.swing.JTextField();
        TFEdad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TFLongitud = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TFPeso = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();

        jLabel85.setText("jLabel85");
        jLabel85.setName("jLabel85"); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Antecedentes Clínicos");
        setResizable(false);

        jPanel1.setName("jPanel1"); // NOI18N

        jPanel3.setBackground(new java.awt.Color(229, 184, 183));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setName("jPanel3"); // NOI18N

        BGuardar2.setText("Guardar");
        BGuardar2.setName("BGuardar2"); // NOI18N
        BGuardar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BGuardar2ActionPerformed(evt);
            }
        });

        BCerrar.setText("Cerrar");
        BCerrar.setName("BCerrar"); // NOI18N
        BCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BGuardar2)
                .addGap(18, 18, 18)
                .addComponent(BCerrar)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BCerrar)
                    .addComponent(BGuardar2))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(229, 184, 183));
        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel7.setName("jPanel7"); // NOI18N
        jPanel7.setPreferredSize(new java.awt.Dimension(720, 361));

        jTabbedPane1.setBackground(jPanel2.getBackground());
        jTabbedPane1.setName("jTabbedPane1"); // NOI18N

        jPanel5.setBackground(new java.awt.Color(229, 184, 183));
        jPanel5.setName("jPanel5"); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 706, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Aparato Digestivo", jPanel5);

        jPanel6.setBackground(new java.awt.Color(229, 184, 183));
        jPanel6.setName("jPanel6"); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 706, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Aparato Circulatorio", jPanel6);

        jPanel9.setBackground(new java.awt.Color(229, 184, 183));
        jPanel9.setName("jPanel9"); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 706, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Aparato Respiratorio", jPanel9);

        jPanel10.setBackground(new java.awt.Color(229, 184, 183));
        jPanel10.setName("jPanel10"); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 706, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Aparato Genito-Urinario", jPanel10);

        jPanel11.setBackground(new java.awt.Color(229, 184, 183));
        jPanel11.setName("jPanel11"); // NOI18N

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 706, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Aparato Hematológico", jPanel11);

        jPanel12.setBackground(new java.awt.Color(229, 184, 183));
        jPanel12.setName("jPanel12"); // NOI18N

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 706, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Aparato Endocrino", jPanel12);

        jPanel13.setBackground(new java.awt.Color(229, 184, 183));
        jPanel13.setName("jPanel13"); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 706, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Aparato Locomotor", jPanel13);

        jPanel14.setBackground(new java.awt.Color(229, 184, 183));
        jPanel14.setName("jPanel14"); // NOI18N

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 706, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Sistema Sensorial", jPanel14);

        jPanel15.setBackground(new java.awt.Color(229, 184, 183));
        jPanel15.setName("jPanel15"); // NOI18N

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 706, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Piel", jPanel15);

        jPanel16.setBackground(new java.awt.Color(229, 184, 183));
        jPanel16.setName("jPanel16"); // NOI18N

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 706, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Sistema Nervioso", jPanel16);

        jScrollPane2.setBackground(new java.awt.Color(229, 184, 183));
        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jPanel8.setBackground(new java.awt.Color(229, 184, 183));
        jPanel8.setAutoscrolls(true);
        jPanel8.setName("jPanel8"); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1014, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 365, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel8);

        jTabbedPane1.addTab("Psicosomático", jScrollPane2);

        jTabbedPane1.setSelectedComponent(jPanel5);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(229, 184, 183));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setName("jPanel2"); // NOI18N

        jPanel4.setBackground(new java.awt.Color(229, 184, 183));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setName("jPanel4"); // NOI18N

        jLabel1.setText("Cod. Paciente");
        jLabel1.setName("jLabel1"); // NOI18N

        TFCod.setName("TFCod"); // NOI18N

        jLabel2.setText("Nombre");
        jLabel2.setName("jLabel2"); // NOI18N

        TFNombre.setName("TFNombre"); // NOI18N

        TFEdad.setName("TFEdad"); // NOI18N

        jLabel4.setText("Edad");
        jLabel4.setName("jLabel4"); // NOI18N

        jLabel5.setText("Talla (cm)");
        jLabel5.setName("jLabel5"); // NOI18N

        TFLongitud.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TFLongitud.setName("TFLongitud"); // NOI18N
        TFLongitud.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TFLongitudFocusLost(evt);
            }
        });

        jLabel6.setText("Peso (Kg.)");
        jLabel6.setName("jLabel6"); // NOI18N

        TFPeso.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TFPeso.setName("TFPeso"); // NOI18N
        TFPeso.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TFPesoFocusLost(evt);
            }
        });

        jLabel3.setText("Presión Arterial");
        jLabel3.setName("jLabel3"); // NOI18N

        jTextField1.setName("jTextField1"); // NOI18N

        jLabel9.setText("Temperatura");
        jLabel9.setName("jLabel9"); // NOI18N

        jTextField2.setName("jTextField2"); // NOI18N

        jLabel10.setText("Alergias");
        jLabel10.setName("jLabel10"); // NOI18N

        jTextField3.setName("jTextField3"); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel10)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TFCod)
                            .addComponent(TFLongitud, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(TFPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1))
                            .addComponent(TFNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TFEdad)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)))
                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(TFCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(TFEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFLongitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(TFPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BGuardar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BGuardar2ActionPerformed
}//GEN-LAST:event_BGuardar2ActionPerformed

    private void BCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCerrarActionPerformed
        dispose();
}//GEN-LAST:event_BCerrarActionPerformed

    private void TFLongitudFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFLongitudFocusLost
}//GEN-LAST:event_TFLongitudFocusLost

    private void TFPesoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFPesoFocusLost
}//GEN-LAST:event_TFPesoFocusLost

    public void cargarImagen(javax.swing.JDesktopPane jDeskp, File fileImagen) {
        try {
            BufferedImage image = ImageIO.read(fileImagen);
            jDeskp.setBorder(new PintaImagen(image));
        } catch (Exception e) {
            System.out.println("No cargo imagen, sorry");
        }
    }

    public static Double calcularMeses(String fecha) throws ParseException {
        Double edad = new Double(1);
        String datetext = fecha;
        Calendar birth = new GregorianCalendar();
        Calendar today = new GregorianCalendar();
        int meses = 0;
        Date birthDate = new SimpleDateFormat("dd/MM/yyyy").parse(datetext);
        Date currentDate = new Date(); //current date
        birth.setTime(birthDate);
        today.setTime(currentDate);
        meses = (today.get(Calendar.YEAR) - birth.get(Calendar.YEAR)) * 12;
        meses = meses + (today.get(Calendar.MONTH) - birth.get(Calendar.MONTH));
        edad = meses / 12.0;
        return edad;
    }

    public static Double calcularMesesCDC(String fecha) throws ParseException {
        Double edad = new Double(1);
        String datetext = fecha;
        Calendar birth = new GregorianCalendar();
        Calendar today = new GregorianCalendar();
        int meses = 0;
        Date birthDate = new SimpleDateFormat("dd/MM/yyyy").parse(datetext);
        Date currentDate = new Date(); //current date
        birth.setTime(birthDate);
        today.setTime(currentDate);
        meses = (today.get(Calendar.YEAR) - birth.get(Calendar.YEAR)) * 12;
        meses = meses + (today.get(Calendar.MONTH) - birth.get(Calendar.MONTH));
        edad = (double) meses;
        return edad;
    }

    public static int calcularEdad(String fecha) {
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
            if (today.get(Calendar.MONTH) <= birth.get(Calendar.MONTH)) {
                if (today.get(Calendar.MONTH) == birth.get(Calendar.MONTH)) {
                    if (today.get(Calendar.DATE) > birth.get(Calendar.DATE)) {
                        factor = -1; //Aun no celebra su cumpleaños
                    }
                } else {
                    factor = -1; //Aun no celebra su cumpleaños
                }
            }
            age = (today.get(Calendar.YEAR) - birth.get(Calendar.YEAR)) + factor;
            return age;
        } catch (Exception e) {
            return -1;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCerrar;
    private javax.swing.ButtonGroup BGGrafica;
    private javax.swing.ButtonGroup BGPaper;
    private javax.swing.JButton BGuardar2;
    private javax.swing.JTextField TFCod;
    private javax.swing.JTextField TFEdad;
    private javax.swing.JTextField TFLongitud;
    private javax.swing.JTextField TFNombre;
    private javax.swing.JTextField TFPeso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
