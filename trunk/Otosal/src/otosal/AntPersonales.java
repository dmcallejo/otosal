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
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Antonio
 */
public class AntPersonales extends javax.swing.JDialog {

    static final String ControladorJDBC = "org.sqlite.JDBC";
    static final String baseDatos = "jdbc:sqlite:Otosal.sqlite";
    private Connection conexion;
    private Statement instruccion;
    Double edadMes;
    int cod = new Integer(0);
    boolean mujer;

    /** Creates new form AntroAdoles */
    public AntPersonales(java.awt.Frame parent, boolean modal) {
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
            jCheckBox1.setBackground(jPanel4.getBackground());
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
            }
            //Pongo a editable false para que no se pueda modificar
            TFCod.setEditable(false);
            TFNombre.setEditable(false);
            TFEdad.setEditable(false);
            TFLongitud.requestFocus();
            conexion.close();
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
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jCheckBox5 = new javax.swing.JCheckBox();
        jLabel19 = new javax.swing.JLabel();
        jCheckBox6 = new javax.swing.JCheckBox();
        jLabel20 = new javax.swing.JLabel();
        jCheckBox7 = new javax.swing.JCheckBox();
        jLabel21 = new javax.swing.JLabel();
        jCheckBox8 = new javax.swing.JCheckBox();
        jLabel22 = new javax.swing.JLabel();
        jCheckBox9 = new javax.swing.JCheckBox();
        jLabel23 = new javax.swing.JLabel();
        jCheckBox10 = new javax.swing.JCheckBox();
        jLabel24 = new javax.swing.JLabel();
        jCheckBox11 = new javax.swing.JCheckBox();
        jLabel25 = new javax.swing.JLabel();
        jCheckBox12 = new javax.swing.JCheckBox();
        jLabel26 = new javax.swing.JLabel();
        jCheckBox13 = new javax.swing.JCheckBox();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jCheckBox14 = new javax.swing.JCheckBox();
        jCheckBox15 = new javax.swing.JCheckBox();
        jCheckBox16 = new javax.swing.JCheckBox();
        jCheckBox17 = new javax.swing.JCheckBox();
        jCheckBox18 = new javax.swing.JCheckBox();
        jPanel21 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jCheckBox19 = new javax.swing.JCheckBox();
        jLabel34 = new javax.swing.JLabel();
        jCheckBox20 = new javax.swing.JCheckBox();
        jLabel35 = new javax.swing.JLabel();
        jCheckBox21 = new javax.swing.JCheckBox();
        jLabel36 = new javax.swing.JLabel();
        jCheckBox22 = new javax.swing.JCheckBox();
        jLabel37 = new javax.swing.JLabel();
        jCheckBox23 = new javax.swing.JCheckBox();
        jPanel9 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jCheckBox24 = new javax.swing.JCheckBox();
        jPanel10 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jCheckBox25 = new javax.swing.JCheckBox();
        jCheckBox26 = new javax.swing.JCheckBox();
        jLabel40 = new javax.swing.JLabel();
        jCheckBox27 = new javax.swing.JCheckBox();
        jLabel41 = new javax.swing.JLabel();
        jCheckBox28 = new javax.swing.JCheckBox();
        jLabel42 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jCheckBox29 = new javax.swing.JCheckBox();
        jCheckBox30 = new javax.swing.JCheckBox();
        jLabel44 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jCheckBox31 = new javax.swing.JCheckBox();
        jCheckBox32 = new javax.swing.JCheckBox();
        jLabel46 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jCheckBox33 = new javax.swing.JCheckBox();
        jCheckBox34 = new javax.swing.JCheckBox();
        jLabel48 = new javax.swing.JLabel();
        jCheckBox35 = new javax.swing.JCheckBox();
        jLabel49 = new javax.swing.JLabel();
        jCheckBox36 = new javax.swing.JCheckBox();
        jLabel50 = new javax.swing.JLabel();
        jCheckBox37 = new javax.swing.JCheckBox();
        jLabel51 = new javax.swing.JLabel();
        jCheckBox38 = new javax.swing.JCheckBox();
        jLabel52 = new javax.swing.JLabel();
        jCheckBox39 = new javax.swing.JCheckBox();
        jLabel53 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jCheckBox40 = new javax.swing.JCheckBox();
        jCheckBox41 = new javax.swing.JCheckBox();
        jLabel55 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        jCheckBox42 = new javax.swing.JCheckBox();
        jCheckBox43 = new javax.swing.JCheckBox();
        jCheckBox44 = new javax.swing.JCheckBox();
        jCheckBox45 = new javax.swing.JCheckBox();
        jCheckBox46 = new javax.swing.JCheckBox();
        jCheckBox47 = new javax.swing.JCheckBox();
        jCheckBox48 = new javax.swing.JCheckBox();
        jCheckBox49 = new javax.swing.JCheckBox();
        jCheckBox50 = new javax.swing.JCheckBox();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        jCheckBox51 = new javax.swing.JCheckBox();
        jCheckBox52 = new javax.swing.JCheckBox();
        jCheckBox53 = new javax.swing.JCheckBox();
        jCheckBox54 = new javax.swing.JCheckBox();
        jCheckBox55 = new javax.swing.JCheckBox();
        jCheckBox56 = new javax.swing.JCheckBox();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel8 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jCheckBox57 = new javax.swing.JCheckBox();
        jCheckBox58 = new javax.swing.JCheckBox();
        jCheckBox59 = new javax.swing.JCheckBox();
        jCheckBox60 = new javax.swing.JCheckBox();
        jCheckBox61 = new javax.swing.JCheckBox();
        jCheckBox62 = new javax.swing.JCheckBox();
        jCheckBox63 = new javax.swing.JCheckBox();
        jCheckBox64 = new javax.swing.JCheckBox();
        jCheckBox65 = new javax.swing.JCheckBox();
        jCheckBox66 = new javax.swing.JCheckBox();
        jCheckBox67 = new javax.swing.JCheckBox();
        jCheckBox68 = new javax.swing.JCheckBox();
        jCheckBox69 = new javax.swing.JCheckBox();
        jCheckBox70 = new javax.swing.JCheckBox();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jCheckBox71 = new javax.swing.JCheckBox();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jCheckBox72 = new javax.swing.JCheckBox();
        jCheckBox73 = new javax.swing.JCheckBox();
        jCheckBox74 = new javax.swing.JCheckBox();
        jCheckBox75 = new javax.swing.JCheckBox();
        jCheckBox76 = new javax.swing.JCheckBox();
        jCheckBox77 = new javax.swing.JCheckBox();
        jCheckBox78 = new javax.swing.JCheckBox();
        jCheckBox79 = new javax.swing.JCheckBox();
        jCheckBox80 = new javax.swing.JCheckBox();
        jCheckBox81 = new javax.swing.JCheckBox();
        jCheckBox82 = new javax.swing.JCheckBox();
        jCheckBox83 = new javax.swing.JCheckBox();
        jCheckBox84 = new javax.swing.JCheckBox();
        jCheckBox85 = new javax.swing.JCheckBox();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel101 = new javax.swing.JLabel();
        jCheckBox86 = new javax.swing.JCheckBox();
        jCheckBox87 = new javax.swing.JCheckBox();
        jCheckBox88 = new javax.swing.JCheckBox();
        jCheckBox89 = new javax.swing.JCheckBox();
        jCheckBox90 = new javax.swing.JCheckBox();
        jCheckBox91 = new javax.swing.JCheckBox();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel107 = new javax.swing.JLabel();
        jCheckBox92 = new javax.swing.JCheckBox();
        jCheckBox93 = new javax.swing.JCheckBox();
        jCheckBox94 = new javax.swing.JCheckBox();
        jCheckBox95 = new javax.swing.JCheckBox();
        jCheckBox96 = new javax.swing.JCheckBox();
        jCheckBox97 = new javax.swing.JCheckBox();
        jCheckBox98 = new javax.swing.JCheckBox();
        jCheckBox99 = new javax.swing.JCheckBox();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jCheckBox100 = new javax.swing.JCheckBox();
        jCheckBox101 = new javax.swing.JCheckBox();
        jCheckBox102 = new javax.swing.JCheckBox();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jCheckBox103 = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jPanel20 = new javax.swing.JPanel();
        jLabel119 = new javax.swing.JLabel();
        jCheckBox104 = new javax.swing.JCheckBox();
        jCheckBox105 = new javax.swing.JCheckBox();
        jCheckBox106 = new javax.swing.JCheckBox();
        jCheckBox107 = new javax.swing.JCheckBox();
        jCheckBox108 = new javax.swing.JCheckBox();
        jCheckBox109 = new javax.swing.JCheckBox();
        jCheckBox110 = new javax.swing.JCheckBox();
        jCheckBox111 = new javax.swing.JCheckBox();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
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

        jLabel7.setText("Edad del primer ciclo menstrual");
        jLabel7.setName("jLabel7"); // NOI18N

        jLabel8.setText("Ritmo menstrual (días)");
        jLabel8.setName("jLabel8"); // NOI18N

        jLabel11.setText("Uso de medicamentos anticonceptivos");
        jLabel11.setName("jLabel11"); // NOI18N

        jLabel12.setText("Número de embarazos");
        jLabel12.setName("jLabel12"); // NOI18N

        jLabel13.setText("Número de embarazos múltiples");
        jLabel13.setName("jLabel13"); // NOI18N

        jLabel14.setText("Número de abortos");
        jLabel14.setName("jLabel14"); // NOI18N

        jLabel15.setText("Diabetes gestacional");
        jLabel15.setName("jLabel15"); // NOI18N

        jLabel16.setText("Edad de inicio de la menopausia");
        jLabel16.setName("jLabel16"); // NOI18N

        jLabel17.setText("Sangrado vaginal post-menopáusico");
        jLabel17.setName("jLabel17"); // NOI18N

        jTextField4.setName("jTextField4"); // NOI18N

        jTextField5.setName("jTextField5"); // NOI18N

        jTextField6.setName("jTextField6"); // NOI18N

        jTextField7.setName("jTextField7"); // NOI18N

        jTextField8.setName("jTextField8"); // NOI18N

        jCheckBox1.setBackground(jPanel4.getBackground());
        jCheckBox1.setName("jCheckBox1"); // NOI18N

        jCheckBox2.setBackground(jPanel4.getBackground());
        jCheckBox2.setName("jCheckBox2"); // NOI18N

        jCheckBox3.setBackground(jPanel4.getBackground());
        jCheckBox3.setName("jCheckBox3"); // NOI18N

        jCheckBox4.setBackground(jPanel4.getBackground());
        jCheckBox4.setName("jCheckBox4"); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField8)
                    .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                    .addComponent(jTextField5)
                    .addComponent(jTextField4)
                    .addComponent(jTextField7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel16)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox4)
                    .addComponent(jCheckBox3)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox1))
                .addContainerGap(218, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel14)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel15)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel16)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel17)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(166, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ginecológicos-Obstétricos", jPanel5);

        jPanel6.setBackground(new java.awt.Color(229, 184, 183));
        jPanel6.setName("jPanel6"); // NOI18N

        jLabel18.setText("Dolor o presión en el pecho");
        jLabel18.setName("jLabel18"); // NOI18N

        jCheckBox5.setName("jCheckBox5"); // NOI18N

        jLabel19.setText("Triglicéridos altos");
        jLabel19.setName("jLabel19"); // NOI18N

        jCheckBox6.setName("jCheckBox6"); // NOI18N

        jLabel20.setText("Infarto de miocardio");
        jLabel20.setName("jLabel20"); // NOI18N

        jCheckBox7.setName("jCheckBox7"); // NOI18N

        jLabel21.setText("Angina de pecho");
        jLabel21.setName("jLabel21"); // NOI18N

        jCheckBox8.setName("jCheckBox8"); // NOI18N

        jLabel22.setText("Cirugía coronaria (by-pass)");
        jLabel22.setName("jLabel22"); // NOI18N

        jCheckBox9.setName("jCheckBox9"); // NOI18N

        jLabel23.setText("Angioplastia coronaria");
        jLabel23.setName("jLabel23"); // NOI18N

        jCheckBox10.setName("jCheckBox10"); // NOI18N

        jLabel24.setText("Accidente cerebro-vascular");
        jLabel24.setToolTipText("trombósis-embolia-hemorragia cerebral");
        jLabel24.setName("jLabel24"); // NOI18N

        jCheckBox11.setName("jCheckBox11"); // NOI18N

        jLabel25.setText("Taquicardia paroxística");
        jLabel25.setName("jLabel25"); // NOI18N

        jCheckBox12.setName("jCheckBox12"); // NOI18N

        jLabel26.setText("Fibrilación auricular");
        jLabel26.setName("jLabel26"); // NOI18N

        jCheckBox13.setName("jCheckBox13"); // NOI18N

        jLabel27.setText("Aneurismo de aorta");
        jLabel27.setName("jLabel27"); // NOI18N

        jLabel28.setText("Insuficiencia cardiaca");
        jLabel28.setName("jLabel28"); // NOI18N

        jLabel29.setText("Embolia pulmonar");
        jLabel29.setName("jLabel29"); // NOI18N

        jLabel30.setText("Trombósis venosa periférica");
        jLabel30.setName("jLabel30"); // NOI18N

        jLabel31.setText("Claudicación intermitente");
        jLabel31.setName("jLabel31"); // NOI18N

        jCheckBox14.setName("jCheckBox14"); // NOI18N

        jCheckBox15.setName("jCheckBox15"); // NOI18N

        jCheckBox16.setName("jCheckBox16"); // NOI18N

        jCheckBox17.setName("jCheckBox17"); // NOI18N

        jCheckBox18.setName("jCheckBox18"); // NOI18N

        jPanel21.setBackground(new java.awt.Color(229, 184, 183));
        jPanel21.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel21.setAutoscrolls(true);
        jPanel21.setName("jPanel21"); // NOI18N

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel32.setText("· Factores de riesgo cardiovascular:");
        jLabel32.setName("jLabel32"); // NOI18N

        jLabel33.setText("Tensión alta o hipertensión en los últimos 12 meses");
        jLabel33.setName("jLabel33"); // NOI18N

        jCheckBox19.setName("jCheckBox19"); // NOI18N

        jLabel34.setText("Colesterol alto");
        jLabel34.setName("jLabel34"); // NOI18N

        jCheckBox20.setName("jCheckBox20"); // NOI18N

        jLabel35.setText("Diabetes");
        jLabel35.setName("jLabel35"); // NOI18N

        jCheckBox21.setName("jCheckBox21"); // NOI18N

        jLabel36.setText("Sobrepeso/Obesidad");
        jLabel36.setName("jLabel36"); // NOI18N

        jCheckBox22.setName("jCheckBox22"); // NOI18N

        jLabel37.setText("Tabaco");
        jLabel37.setName("jLabel37"); // NOI18N

        jCheckBox23.setName("jCheckBox23"); // NOI18N

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addContainerGap(98, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33)
                            .addComponent(jLabel34)
                            .addComponent(jLabel35)
                            .addComponent(jLabel36)
                            .addComponent(jLabel37))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCheckBox19)
                            .addComponent(jCheckBox20)
                            .addComponent(jCheckBox21)
                            .addComponent(jCheckBox22)
                            .addComponent(jCheckBox23))
                        .addGap(169, 169, 169))))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jCheckBox19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox23))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel37)))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel18)
                                .addComponent(jLabel19)
                                .addComponent(jLabel20)
                                .addComponent(jLabel21))
                            .addGap(33, 33, 33)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jCheckBox6)
                                .addComponent(jCheckBox5)
                                .addComponent(jCheckBox7)
                                .addComponent(jCheckBox8)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel22)
                                .addComponent(jLabel23))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jCheckBox10)
                                .addComponent(jCheckBox9)
                                .addComponent(jCheckBox11)
                                .addComponent(jCheckBox12)
                                .addComponent(jCheckBox13))))
                    .addComponent(jLabel25)
                    .addComponent(jLabel26)
                    .addComponent(jLabel24))
                .addGap(276, 276, 276)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel31)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCheckBox18))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel30)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCheckBox17))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel29)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCheckBox16))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel28)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCheckBox15))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel27)
                            .addGap(100, 100, 100)
                            .addComponent(jCheckBox14)))
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jCheckBox5)
                    .addComponent(jLabel27)
                    .addComponent(jCheckBox14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jCheckBox6)
                    .addComponent(jLabel28)
                    .addComponent(jCheckBox15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jCheckBox7)
                    .addComponent(jLabel29)
                    .addComponent(jCheckBox16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jCheckBox8)
                    .addComponent(jLabel30)
                    .addComponent(jCheckBox17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jCheckBox9)
                    .addComponent(jLabel31)
                    .addComponent(jCheckBox18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox10)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox11)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jCheckBox12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(jCheckBox13)))
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Enfermedad Cardiovascular", jPanel6);

        jPanel9.setBackground(new java.awt.Color(229, 184, 183));
        jPanel9.setName("jPanel9"); // NOI18N

        jLabel38.setText("Nivel de glucosa en sangre alto en los últimos 12 meses");
        jLabel38.setName("jLabel38"); // NOI18N

        jCheckBox24.setName("jCheckBox24"); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel38)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox24)
                .addContainerGap(619, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox24)
                    .addComponent(jLabel38))
                .addContainerGap(273, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Diabetes", jPanel9);

        jPanel10.setBackground(new java.awt.Color(229, 184, 183));
        jPanel10.setName("jPanel10"); // NOI18N

        jLabel39.setText("Disminución de la visión");
        jLabel39.setName("jLabel39"); // NOI18N

        jCheckBox25.setName("jCheckBox25"); // NOI18N

        jCheckBox26.setName("jCheckBox26"); // NOI18N

        jLabel40.setText("Visión doble");
        jLabel40.setName("jLabel40"); // NOI18N

        jCheckBox27.setName("jCheckBox27"); // NOI18N

        jLabel41.setText("Glaucoma");
        jLabel41.setName("jLabel41"); // NOI18N

        jCheckBox28.setName("jCheckBox28"); // NOI18N

        jLabel42.setText("Cataratas");
        jLabel42.setName("jLabel42"); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40)
                    .addComponent(jLabel41)
                    .addComponent(jLabel42))
                .addGap(143, 143, 143)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox28)
                    .addComponent(jCheckBox27)
                    .addComponent(jCheckBox26)
                    .addComponent(jCheckBox25))
                .addContainerGap(647, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jCheckBox25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox28))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel39)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel42)))
                .addContainerGap(206, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Patologicos de la visión", jPanel10);

        jPanel11.setBackground(new java.awt.Color(229, 184, 183));
        jPanel11.setName("jPanel11"); // NOI18N

        jLabel43.setText("Asma bronquial");
        jLabel43.setName("jLabel43"); // NOI18N

        jCheckBox29.setName("jCheckBox29"); // NOI18N

        jCheckBox30.setName("jCheckBox30"); // NOI18N

        jLabel44.setText("Bronquitis crónica-enfisema");
        jLabel44.setName("jLabel44"); // NOI18N

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox30))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel43)
                        .addGap(126, 126, 126)
                        .addComponent(jCheckBox29)))
                .addContainerGap(702, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jCheckBox29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox30)
                    .addComponent(jLabel44))
                .addContainerGap(246, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Patologicos pulmonares", jPanel11);

        jPanel12.setBackground(new java.awt.Color(229, 184, 183));
        jPanel12.setName("jPanel12"); // NOI18N

        jLabel45.setText("Hipotiroidismo");
        jLabel45.setName("jLabel45"); // NOI18N

        jCheckBox31.setName("jCheckBox31"); // NOI18N

        jCheckBox32.setName("jCheckBox32"); // NOI18N

        jLabel46.setText("Hipertiroidismo");
        jLabel46.setName("jLabel46"); // NOI18N

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel45)
                    .addComponent(jLabel46))
                .addGap(130, 130, 130)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox32)
                    .addComponent(jCheckBox31))
                .addContainerGap(701, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(jCheckBox31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox32)
                    .addComponent(jLabel46))
                .addContainerGap(246, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Endocrinos", jPanel12);

        jPanel13.setBackground(new java.awt.Color(229, 184, 183));
        jPanel13.setName("jPanel13"); // NOI18N

        jLabel47.setText("Accidente de tráfico con fractura u hospitalización (> 24 horas)");
        jLabel47.setName("jLabel47"); // NOI18N

        jCheckBox33.setName("jCheckBox33"); // NOI18N

        jCheckBox34.setName("jCheckBox34"); // NOI18N

        jLabel48.setText("Fractura de cadera");
        jLabel48.setName("jLabel48"); // NOI18N

        jCheckBox35.setName("jCheckBox35"); // NOI18N

        jLabel49.setText("Dolor crónico en los huesos y en las articulaciones");
        jLabel49.setName("jLabel49"); // NOI18N

        jCheckBox36.setName("jCheckBox36"); // NOI18N

        jLabel50.setText("Dolor en la parte baja de la espalda");
        jLabel50.setName("jLabel50"); // NOI18N

        jCheckBox37.setName("jCheckBox37"); // NOI18N

        jLabel51.setText("Articulaciones hinchadas o rígidas");
        jLabel51.setName("jLabel51"); // NOI18N

        jCheckBox38.setName("jCheckBox38"); // NOI18N

        jLabel52.setText("Artritis reumatoide");
        jLabel52.setName("jLabel52"); // NOI18N

        jCheckBox39.setName("jCheckBox39"); // NOI18N

        jLabel53.setText("Gota");
        jLabel53.setName("jLabel53"); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel47)
                    .addComponent(jLabel48)
                    .addComponent(jLabel49)
                    .addComponent(jLabel50)
                    .addComponent(jLabel51)
                    .addComponent(jLabel52)
                    .addComponent(jLabel53))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox39)
                    .addComponent(jCheckBox38)
                    .addComponent(jCheckBox37)
                    .addComponent(jCheckBox36)
                    .addComponent(jCheckBox35)
                    .addComponent(jCheckBox34)
                    .addComponent(jCheckBox33))
                .addContainerGap(580, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(jCheckBox33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox34)
                    .addComponent(jLabel48))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox35)
                    .addComponent(jLabel49))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox36)
                    .addComponent(jLabel50))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox37)
                    .addComponent(jLabel51))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox38)
                    .addComponent(jLabel52))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox39)
                    .addComponent(jLabel53))
                .addContainerGap(131, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Patologicos de los huesos y cartílago", jPanel13);

        jPanel14.setBackground(new java.awt.Color(229, 184, 183));
        jPanel14.setName("jPanel14"); // NOI18N

        jLabel54.setText("Anemia");
        jLabel54.setName("jLabel54"); // NOI18N

        jCheckBox40.setName("jCheckBox40"); // NOI18N

        jCheckBox41.setName("jCheckBox41"); // NOI18N

        jLabel55.setText("Trastornos hemorrágicos");
        jLabel55.setName("jLabel55"); // NOI18N

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel54)
                    .addComponent(jLabel55))
                .addGap(157, 157, 157)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox41)
                    .addComponent(jCheckBox40))
                .addContainerGap(625, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(jCheckBox40))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox41)
                    .addComponent(jLabel55))
                .addContainerGap(246, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Hematológicos", jPanel14);

        jPanel15.setBackground(new java.awt.Color(229, 184, 183));
        jPanel15.setName("jPanel15"); // NOI18N

        jLabel56.setText("Perdida de consciencia");
        jLabel56.setName("jLabel56"); // NOI18N

        jCheckBox42.setName("jCheckBox42"); // NOI18N

        jCheckBox43.setName("jCheckBox43"); // NOI18N

        jCheckBox44.setName("jCheckBox44"); // NOI18N

        jCheckBox45.setName("jCheckBox45"); // NOI18N

        jCheckBox46.setName("jCheckBox46"); // NOI18N

        jCheckBox47.setName("jCheckBox47"); // NOI18N

        jCheckBox48.setName("jCheckBox48"); // NOI18N

        jCheckBox49.setName("jCheckBox49"); // NOI18N

        jCheckBox50.setName("jCheckBox50"); // NOI18N

        jLabel57.setText("Vértigo");
        jLabel57.setName("jLabel57"); // NOI18N

        jLabel58.setText("Apnea del sueño");
        jLabel58.setName("jLabel58"); // NOI18N

        jLabel59.setText("Problemas de memoria");
        jLabel59.setName("jLabel59"); // NOI18N

        jLabel60.setText("Frecuentes dolores de cabeza");
        jLabel60.setName("jLabel60"); // NOI18N

        jLabel61.setText("Dificulad para dormir");
        jLabel61.setName("jLabel61"); // NOI18N

        jLabel62.setText("Depresión");
        jLabel62.setName("jLabel62"); // NOI18N

        jLabel63.setText("Ansiedad");
        jLabel63.setName("jLabel63"); // NOI18N

        jLabel64.setText("Visita a un psicólogo o psiquiatra");
        jLabel64.setName("jLabel64"); // NOI18N

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel56)
                    .addComponent(jLabel57)
                    .addComponent(jLabel58)
                    .addComponent(jLabel59)
                    .addComponent(jLabel60)
                    .addComponent(jLabel61)
                    .addComponent(jLabel62)
                    .addComponent(jLabel63)
                    .addComponent(jLabel64))
                .addGap(147, 147, 147)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox50)
                    .addComponent(jCheckBox49)
                    .addComponent(jCheckBox48)
                    .addComponent(jCheckBox47)
                    .addComponent(jCheckBox46)
                    .addComponent(jCheckBox45)
                    .addComponent(jCheckBox44)
                    .addComponent(jCheckBox43)
                    .addComponent(jCheckBox42))
                .addContainerGap(599, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(jCheckBox42))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox43)
                    .addComponent(jLabel57))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox44)
                    .addComponent(jLabel58))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox45)
                    .addComponent(jLabel59))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox46)
                    .addComponent(jLabel60))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox47)
                    .addComponent(jLabel61))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox48)
                    .addComponent(jLabel62))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox49)
                    .addComponent(jLabel63))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox50)
                    .addComponent(jLabel64))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Neuro-psoquiátricos", jPanel15);

        jPanel16.setBackground(new java.awt.Color(229, 184, 183));
        jPanel16.setName("jPanel16"); // NOI18N

        jLabel65.setText("Erupciones cutáneas");
        jLabel65.setName("jLabel65"); // NOI18N

        jCheckBox51.setName("jCheckBox51"); // NOI18N

        jCheckBox52.setName("jCheckBox52"); // NOI18N

        jCheckBox53.setName("jCheckBox53"); // NOI18N

        jCheckBox54.setName("jCheckBox54"); // NOI18N

        jCheckBox55.setName("jCheckBox55"); // NOI18N

        jCheckBox56.setName("jCheckBox56"); // NOI18N
        jCheckBox56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox56ActionPerformed(evt);
            }
        });

        jLabel66.setText("Llagas cutáneas que no llegan a curar");
        jLabel66.setName("jLabel66"); // NOI18N

        jLabel67.setText("Llagas en la boca que no llegan a curar");
        jLabel67.setName("jLabel67"); // NOI18N

        jLabel68.setText("Hongos en la piel y en las uñas de los pies");
        jLabel68.setName("jLabel68"); // NOI18N

        jLabel69.setText("Psoriasis");
        jLabel69.setName("jLabel69"); // NOI18N

        jLabel70.setText("Otros:");
        jLabel70.setName("jLabel70"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setEnabled(false);
        jTextArea1.setName("jTextArea1"); // NOI18N
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel65)
                            .addComponent(jLabel66)
                            .addComponent(jLabel67)
                            .addComponent(jLabel68)
                            .addComponent(jLabel69)
                            .addComponent(jLabel70))
                        .addGap(152, 152, 152)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox56)
                            .addComponent(jCheckBox55)
                            .addComponent(jCheckBox54)
                            .addComponent(jCheckBox53)
                            .addComponent(jCheckBox52)
                            .addComponent(jCheckBox51))))
                .addContainerGap(549, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65)
                    .addComponent(jCheckBox51))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox52)
                    .addComponent(jLabel66))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox53)
                    .addComponent(jLabel67))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox54)
                    .addComponent(jLabel68))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox55)
                    .addComponent(jLabel69))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox56)
                    .addComponent(jLabel70))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dermatológicos", jPanel16);

        jScrollPane2.setBackground(new java.awt.Color(229, 184, 183));
        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jPanel8.setBackground(new java.awt.Color(229, 184, 183));
        jPanel8.setAutoscrolls(true);
        jPanel8.setName("jPanel8"); // NOI18N

        jLabel71.setText("Esofaguitis por reflujo");
        jLabel71.setName("jLabel71"); // NOI18N

        jCheckBox57.setName("jCheckBox57"); // NOI18N

        jCheckBox58.setName("jCheckBox58"); // NOI18N

        jCheckBox59.setName("jCheckBox59"); // NOI18N

        jCheckBox60.setName("jCheckBox60"); // NOI18N

        jCheckBox61.setName("jCheckBox61"); // NOI18N

        jCheckBox62.setName("jCheckBox62"); // NOI18N

        jCheckBox63.setName("jCheckBox63"); // NOI18N

        jCheckBox64.setName("jCheckBox64"); // NOI18N

        jCheckBox65.setName("jCheckBox65"); // NOI18N

        jCheckBox66.setName("jCheckBox66"); // NOI18N

        jCheckBox67.setName("jCheckBox67"); // NOI18N

        jCheckBox68.setName("jCheckBox68"); // NOI18N

        jCheckBox69.setName("jCheckBox69"); // NOI18N

        jCheckBox70.setName("jCheckBox70"); // NOI18N

        jLabel72.setText("Úlcera gástrica o duodenal");
        jLabel72.setName("jLabel72"); // NOI18N

        jLabel73.setText("Hernia hiato");
        jLabel73.setName("jLabel73"); // NOI18N

        jLabel74.setText("Gastritis crónica");
        jLabel74.setName("jLabel74"); // NOI18N

        jLabel75.setText("Diarrea no específica");
        jLabel75.setName("jLabel75"); // NOI18N

        jLabel76.setText("Enfermedades inflamatorias intestinales");
        jLabel76.setName("jLabel76"); // NOI18N

        jLabel77.setText("Enfermedad de Crohn");
        jLabel77.setName("jLabel77"); // NOI18N

        jLabel78.setText("Colitis ulcerosa");
        jLabel78.setName("jLabel78"); // NOI18N

        jLabel79.setText("Colon irritable");
        jLabel79.setName("jLabel79"); // NOI18N

        jLabel80.setText("Póliops en colon o recto");
        jLabel80.setName("jLabel80"); // NOI18N

        jLabel81.setText("Litiasis biliar");
        jLabel81.setName("jLabel81"); // NOI18N

        jLabel82.setText("Cálculos renales o cólico nefrítico");
        jLabel82.setName("jLabel82"); // NOI18N

        jLabel83.setText("Enfermedad celiaca");
        jLabel83.setName("jLabel83"); // NOI18N

        jLabel84.setText("Hepatopatías compensadas");
        jLabel84.setName("jLabel84"); // NOI18N

        jCheckBox71.setName("jCheckBox71"); // NOI18N

        jLabel86.setText("Cirrosis");
        jLabel86.setName("jLabel86"); // NOI18N

        jLabel87.setText("Hepatitis");
        jLabel87.setName("jLabel87"); // NOI18N

        jCheckBox72.setName("jCheckBox72"); // NOI18N

        jCheckBox73.setName("jCheckBox73"); // NOI18N

        jCheckBox74.setName("jCheckBox74"); // NOI18N

        jCheckBox75.setName("jCheckBox75"); // NOI18N

        jCheckBox76.setName("jCheckBox76"); // NOI18N

        jCheckBox77.setName("jCheckBox77"); // NOI18N

        jCheckBox78.setName("jCheckBox78"); // NOI18N

        jCheckBox79.setName("jCheckBox79"); // NOI18N

        jCheckBox80.setName("jCheckBox80"); // NOI18N

        jCheckBox81.setName("jCheckBox81"); // NOI18N

        jCheckBox82.setName("jCheckBox82"); // NOI18N

        jCheckBox83.setName("jCheckBox83"); // NOI18N

        jCheckBox84.setName("jCheckBox84"); // NOI18N

        jCheckBox85.setName("jCheckBox85"); // NOI18N

        jLabel88.setText("Pancreatitis aguda");
        jLabel88.setName("jLabel88"); // NOI18N

        jLabel89.setText("Pancreatitis crónica");
        jLabel89.setName("jLabel89"); // NOI18N

        jLabel90.setText("Resistencia a insulina");
        jLabel90.setName("jLabel90"); // NOI18N

        jLabel91.setText("Síndrome metabólico");
        jLabel91.setName("jLabel91"); // NOI18N

        jLabel92.setText("Dislipemias");
        jLabel92.setName("jLabel92"); // NOI18N

        jLabel93.setText("Hiperuricemia");
        jLabel93.setName("jLabel93"); // NOI18N

        jLabel94.setText("Obesidad");
        jLabel94.setName("jLabel94"); // NOI18N

        jLabel95.setText("Anorexia");
        jLabel95.setName("jLabel95"); // NOI18N

        jLabel96.setText("Bulimia");
        jLabel96.setName("jLabel96"); // NOI18N

        jLabel97.setText("Intervenciones quirúrgicas");
        jLabel97.setName("jLabel97"); // NOI18N

        jLabel98.setText("Tratamientos hormonales");
        jLabel98.setName("jLabel98"); // NOI18N

        jLabel99.setText("Alergias e intolerancias conocidas");
        jLabel99.setName("jLabel99"); // NOI18N

        jLabel100.setText("Hiponutrición intraútero");
        jLabel100.setName("jLabel100"); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel71)
                    .addComponent(jLabel72)
                    .addComponent(jLabel73)
                    .addComponent(jLabel74)
                    .addComponent(jLabel75)
                    .addComponent(jLabel76)
                    .addComponent(jLabel77)
                    .addComponent(jLabel78)
                    .addComponent(jLabel79)
                    .addComponent(jLabel80)
                    .addComponent(jLabel81)
                    .addComponent(jLabel82)
                    .addComponent(jLabel83)
                    .addComponent(jLabel84)
                    .addComponent(jLabel86))
                .addGap(154, 154, 154)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox71)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox57)
                            .addComponent(jCheckBox58)
                            .addComponent(jCheckBox59)
                            .addComponent(jCheckBox60)
                            .addComponent(jCheckBox61)
                            .addComponent(jCheckBox62)
                            .addComponent(jCheckBox63)
                            .addComponent(jCheckBox64)
                            .addComponent(jCheckBox65)
                            .addComponent(jCheckBox66)
                            .addComponent(jCheckBox67)
                            .addComponent(jCheckBox68)
                            .addComponent(jCheckBox69)
                            .addComponent(jCheckBox70))
                        .addGap(85, 85, 85)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel87)
                            .addComponent(jLabel88)
                            .addComponent(jLabel89)
                            .addComponent(jLabel90)
                            .addComponent(jLabel91)
                            .addComponent(jLabel92)
                            .addComponent(jLabel93)
                            .addComponent(jLabel94)
                            .addComponent(jLabel95)
                            .addComponent(jLabel96)
                            .addComponent(jLabel97)
                            .addComponent(jLabel98)
                            .addComponent(jLabel99)
                            .addComponent(jLabel100))
                        .addGap(198, 198, 198)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCheckBox72)
                            .addComponent(jCheckBox73)
                            .addComponent(jCheckBox74)
                            .addComponent(jCheckBox75)
                            .addComponent(jCheckBox76)
                            .addComponent(jCheckBox77)
                            .addComponent(jCheckBox78)
                            .addComponent(jCheckBox79)
                            .addComponent(jCheckBox80)
                            .addComponent(jCheckBox81)
                            .addComponent(jCheckBox82)
                            .addComponent(jCheckBox83)
                            .addComponent(jCheckBox84)
                            .addComponent(jCheckBox85))))
                .addContainerGap(175, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel87)
                            .addComponent(jCheckBox72))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel88)
                            .addComponent(jCheckBox73))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel89)
                            .addComponent(jCheckBox74))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel90)
                            .addComponent(jCheckBox75))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel91)
                            .addComponent(jCheckBox76))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel92)
                            .addComponent(jCheckBox77))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel93)
                            .addComponent(jCheckBox78))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel94)
                            .addComponent(jCheckBox79))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel95)
                            .addComponent(jCheckBox80))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel96)
                            .addComponent(jCheckBox81))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel97)
                            .addComponent(jCheckBox82))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel98)
                            .addComponent(jCheckBox83))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel99)
                            .addComponent(jCheckBox84))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel100)
                            .addComponent(jCheckBox85)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel71)
                            .addComponent(jCheckBox57))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel72)
                            .addComponent(jCheckBox58))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel73)
                            .addComponent(jCheckBox59))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel74)
                            .addComponent(jCheckBox60))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel75)
                            .addComponent(jCheckBox61))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel76)
                            .addComponent(jCheckBox62))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel77)
                            .addComponent(jCheckBox63))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel78)
                            .addComponent(jCheckBox64))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel79)
                            .addComponent(jCheckBox65))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel80)
                            .addComponent(jCheckBox66))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel81)
                            .addComponent(jCheckBox67))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel82)
                            .addComponent(jCheckBox68))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel83)
                            .addComponent(jCheckBox69))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel84)
                            .addComponent(jCheckBox70))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox71)
                            .addComponent(jLabel86))))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel8);

        jTabbedPane1.addTab("Patológicos relacionados con la ingesta y/o absorción de nutrientes", jScrollPane2);

        jPanel18.setBackground(new java.awt.Color(229, 184, 183));
        jPanel18.setName("jPanel18"); // NOI18N

        jLabel101.setText("Estreñimiento");
        jLabel101.setName("jLabel101"); // NOI18N

        jCheckBox86.setName("jCheckBox86"); // NOI18N

        jCheckBox87.setName("jCheckBox87"); // NOI18N

        jCheckBox88.setName("jCheckBox88"); // NOI18N

        jCheckBox89.setName("jCheckBox89"); // NOI18N

        jCheckBox90.setName("jCheckBox90"); // NOI18N

        jCheckBox91.setName("jCheckBox91"); // NOI18N

        jLabel102.setText("Diarrea");
        jLabel102.setName("jLabel102"); // NOI18N

        jLabel103.setText("Hemorroides");
        jLabel103.setName("jLabel103"); // NOI18N

        jLabel104.setText("Incontinencia");
        jLabel104.setName("jLabel104"); // NOI18N

        jLabel105.setText("Poliuria");
        jLabel105.setName("jLabel105"); // NOI18N

        jLabel106.setText("Dolor urinario");
        jLabel106.setName("jLabel106"); // NOI18N

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel106)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 251, Short.MAX_VALUE)
                        .addComponent(jCheckBox91))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel105)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 281, Short.MAX_VALUE)
                        .addComponent(jCheckBox90))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel104)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 251, Short.MAX_VALUE)
                        .addComponent(jCheckBox89))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel103)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 255, Short.MAX_VALUE)
                        .addComponent(jCheckBox88))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel102)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 280, Short.MAX_VALUE)
                        .addComponent(jCheckBox87))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel101)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 250, Short.MAX_VALUE)
                        .addComponent(jCheckBox86)))
                .addContainerGap(586, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox86)
                    .addComponent(jLabel101))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox87)
                    .addComponent(jLabel102))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox88)
                    .addComponent(jLabel103))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox89)
                    .addComponent(jLabel104))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox90)
                    .addComponent(jLabel105))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox91)
                    .addComponent(jLabel106))
                .addContainerGap(154, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Patológicos relacionados con la eliminación", jPanel18);

        jPanel19.setBackground(new java.awt.Color(229, 184, 183));
        jPanel19.setName("jPanel19"); // NOI18N

        jLabel107.setText("Cáncer de mama");
        jLabel107.setName("jLabel107"); // NOI18N

        jCheckBox92.setName("jCheckBox92"); // NOI18N

        jCheckBox93.setName("jCheckBox93"); // NOI18N

        jCheckBox94.setName("jCheckBox94"); // NOI18N

        jCheckBox95.setName("jCheckBox95"); // NOI18N

        jCheckBox96.setName("jCheckBox96"); // NOI18N

        jCheckBox97.setName("jCheckBox97"); // NOI18N

        jCheckBox98.setName("jCheckBox98"); // NOI18N

        jCheckBox99.setName("jCheckBox99"); // NOI18N

        jLabel108.setText("Melanoma");
        jLabel108.setName("jLabel108"); // NOI18N

        jLabel109.setText("Cáncer de pulmón");
        jLabel109.setName("jLabel109"); // NOI18N

        jLabel110.setText("Cáncer de colon o recto");
        jLabel110.setName("jLabel110"); // NOI18N

        jLabel111.setText("Cáncer de páncreas");
        jLabel111.setName("jLabel111"); // NOI18N

        jLabel112.setText("Cáncer de próstata");
        jLabel112.setName("jLabel112"); // NOI18N

        jLabel113.setText("Cáncer de estómago");
        jLabel113.setName("jLabel113"); // NOI18N

        jLabel114.setText("Cáncer de endometrio");
        jLabel114.setName("jLabel114"); // NOI18N

        jLabel115.setText("Cáncer uterino");
        jLabel115.setName("jLabel115"); // NOI18N

        jCheckBox100.setName("jCheckBox100"); // NOI18N

        jCheckBox101.setName("jCheckBox101"); // NOI18N

        jCheckBox102.setName("jCheckBox102"); // NOI18N

        jLabel116.setText("Cáncer de riñón");
        jLabel116.setName("jLabel116"); // NOI18N

        jLabel117.setText("Linfoma no Hodgkin");
        jLabel117.setName("jLabel117"); // NOI18N

        jLabel118.setText("Otros");
        jLabel118.setName("jLabel118"); // NOI18N

        jCheckBox103.setName("jCheckBox103"); // NOI18N
        jCheckBox103.setNextFocusableComponent(jTextArea2);
        jCheckBox103.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox103ActionPerformed(evt);
            }
        });

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setEnabled(false);
        jTextArea2.setName("jTextArea2"); // NOI18N
        jScrollPane3.setViewportView(jTextArea2);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel109)
                            .addComponent(jLabel107)
                            .addComponent(jLabel110)
                            .addComponent(jLabel111)
                            .addComponent(jLabel112)
                            .addComponent(jLabel113)
                            .addComponent(jLabel114))
                        .addGap(163, 163, 163)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox92)
                            .addComponent(jCheckBox93)
                            .addComponent(jCheckBox94)
                            .addComponent(jCheckBox95)
                            .addComponent(jCheckBox99)
                            .addComponent(jCheckBox98)
                            .addComponent(jCheckBox97)
                            .addComponent(jCheckBox96))
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGap(185, 185, 185)
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel115)
                                    .addComponent(jLabel116)
                                    .addComponent(jLabel117)
                                    .addComponent(jLabel118))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox102)
                                    .addComponent(jCheckBox101)
                                    .addComponent(jCheckBox100)
                                    .addComponent(jCheckBox103)))
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(176, 176, 176))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel108)
                        .addContainerGap(874, Short.MAX_VALUE))))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel107)
                            .addComponent(jCheckBox92))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel108)
                            .addComponent(jCheckBox93))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel109)
                            .addComponent(jCheckBox94))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel110)
                            .addComponent(jCheckBox95))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel111)
                            .addComponent(jCheckBox96))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel112)
                            .addComponent(jCheckBox97))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel113)
                            .addComponent(jCheckBox98))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel114)
                            .addComponent(jCheckBox99)))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel115)
                            .addComponent(jCheckBox100))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel116)
                            .addComponent(jCheckBox101))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel117)
                            .addComponent(jCheckBox102))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel118)
                            .addComponent(jCheckBox103))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(102, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cáncer", jPanel19);

        jPanel20.setBackground(new java.awt.Color(229, 184, 183));
        jPanel20.setName("jPanel20"); // NOI18N

        jLabel119.setText("Enfermedades infecciosas de la infancia");
        jLabel119.setName("jLabel119"); // NOI18N

        jCheckBox104.setName("jCheckBox104"); // NOI18N
        jCheckBox104.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox104ActionPerformed(evt);
            }
        });

        jCheckBox105.setName("jCheckBox105"); // NOI18N
        jCheckBox105.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox105ActionPerformed(evt);
            }
        });

        jCheckBox106.setName("jCheckBox106"); // NOI18N
        jCheckBox106.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox106ActionPerformed(evt);
            }
        });

        jCheckBox107.setName("jCheckBox107"); // NOI18N

        jCheckBox108.setName("jCheckBox108"); // NOI18N
        jCheckBox108.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox108ActionPerformed(evt);
            }
        });

        jCheckBox109.setName("jCheckBox109"); // NOI18N
        jCheckBox109.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox109ActionPerformed(evt);
            }
        });

        jCheckBox110.setName("jCheckBox110"); // NOI18N

        jCheckBox111.setName("jCheckBox111"); // NOI18N
        jCheckBox111.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox111ActionPerformed(evt);
            }
        });

        jLabel120.setText("Intervenciones quirúrgicas");
        jLabel120.setName("jLabel120"); // NOI18N

        jLabel121.setText("Traumatismos");
        jLabel121.setName("jLabel121"); // NOI18N

        jLabel122.setText("Perdidas de conocimiento");
        jLabel122.setName("jLabel122"); // NOI18N

        jLabel123.setText("Intolerancia a medicamentos/alimentos");
        jLabel123.setName("jLabel123"); // NOI18N

        jLabel124.setText("Alergias conocidas");
        jLabel124.setName("jLabel124"); // NOI18N

        jLabel125.setText("Transfusiones");
        jLabel125.setName("jLabel125"); // NOI18N

        jLabel126.setText("Otros");
        jLabel126.setName("jLabel126"); // NOI18N

        jScrollPane4.setName("jScrollPane4"); // NOI18N

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jTextArea3.setEnabled(false);
        jTextArea3.setName("jTextArea3"); // NOI18N
        jScrollPane4.setViewportView(jTextArea3);

        jTextField9.setEnabled(false);
        jTextField9.setName("jTextField9"); // NOI18N

        jTextField10.setEnabled(false);
        jTextField10.setName("jTextField10"); // NOI18N

        jTextField11.setEnabled(false);
        jTextField11.setName("jTextField11"); // NOI18N

        jTextField12.setEnabled(false);
        jTextField12.setName("jTextField12"); // NOI18N

        jTextField13.setEnabled(false);
        jTextField13.setName("jTextField13"); // NOI18N

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel20Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane4))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel20Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel119)
                            .addComponent(jLabel120)
                            .addComponent(jLabel121)
                            .addComponent(jLabel122)
                            .addComponent(jLabel124)
                            .addComponent(jLabel125)
                            .addComponent(jLabel126)
                            .addComponent(jLabel123))
                        .addGap(87, 87, 87)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox111)
                            .addComponent(jCheckBox110)
                            .addComponent(jCheckBox109)
                            .addComponent(jCheckBox108)
                            .addComponent(jCheckBox107)
                            .addComponent(jCheckBox106)
                            .addComponent(jCheckBox105)
                            .addComponent(jCheckBox104))))
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField11, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
                    .addComponent(jTextField12, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
                    .addComponent(jTextField13, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel119)
                            .addComponent(jCheckBox104))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox105)
                            .addComponent(jLabel120))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox106)
                            .addComponent(jLabel121))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox107)
                            .addComponent(jLabel122))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox108)
                            .addComponent(jLabel123))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox109)
                            .addComponent(jLabel124))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox110)
                            .addComponent(jLabel125))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox111)
                            .addComponent(jLabel126))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Otros", jPanel20);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 937, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))
                            .addComponent(TFNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TFEdad)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)))
                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 846, Short.MAX_VALUE))
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
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 965, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(799, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jCheckBox56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox56ActionPerformed
        if (jTextArea1.isEnabled()) {
            jTextArea1.setEnabled(false);
        } else {
            jTextArea1.setEnabled(true);
            if (jTextArea1.getText().equals("")) {
                jTextArea1.setText("Especificar...");
                jTextArea1.selectAll();
            }
            jCheckBox56.transferFocus();
        }
    }//GEN-LAST:event_jCheckBox56ActionPerformed

    private void jCheckBox103ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox103ActionPerformed
        if (jTextArea2.isEnabled()) {
            jTextArea2.setEnabled(false);
        } else {
            jTextArea2.setEnabled(true);
            jCheckBox103.transferFocus();
            if (jTextArea2.getText().equals("")) {
                jTextArea2.setText("Especificar...");
                jTextArea2.selectAll();
            }
        }
    }//GEN-LAST:event_jCheckBox103ActionPerformed

    private void jCheckBox111ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox111ActionPerformed
        if (jTextArea3.isEnabled()) {
            jTextArea3.setEnabled(false);
        } else {
            jTextArea3.setEnabled(true);
            jCheckBox111.transferFocus();
            if (jTextArea3.getText().equals("")) {
                jTextArea3.setText("Especificar...");
                jTextArea3.selectAll();
            }
        }
    }//GEN-LAST:event_jCheckBox111ActionPerformed

    private void jCheckBox104ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox104ActionPerformed
        if (jTextField13.isEnabled()) {
            jTextField13.setEnabled(false);
        } else {
            jTextField13.setEnabled(true);
            jCheckBox104.transferFocus();
            if (jTextField13.getText().equals("")) {
                jTextField13.setText("Especificar...");
                jTextField13.selectAll();
            }
        }
    }//GEN-LAST:event_jCheckBox104ActionPerformed

    private void jCheckBox105ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox105ActionPerformed
        if (jTextField12.isEnabled()) {
            jTextField12.setEnabled(false);
        } else {
            jTextField12.setEnabled(true);
            jCheckBox105.transferFocus();
            if (jTextField12.getText().equals("")) {
                jTextField12.setText("Especificar...");
                jTextField12.selectAll();
            }
        }
    }//GEN-LAST:event_jCheckBox105ActionPerformed

    private void jCheckBox106ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox106ActionPerformed
        if (jTextField11.isEnabled()) {
            jTextField11.setEnabled(false);
        } else {
            jTextField11.setEnabled(true);
            jCheckBox106.transferFocus();
            if (jTextField11.getText().equals("")) {
                jTextField11.setText("Especificar...");
                jTextField11.selectAll();
            }
        }
    }//GEN-LAST:event_jCheckBox106ActionPerformed

    private void jCheckBox108ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox108ActionPerformed
        if (jTextField10.isEnabled()) {
            jTextField10.setEnabled(false);
        } else {
            jTextField10.setEnabled(true);
            jCheckBox108.transferFocus();
            if (jTextField10.getText().equals("")) {
                jTextField10.setText("Especificar...");
                jTextField10.selectAll();
            }
        }
    }//GEN-LAST:event_jCheckBox108ActionPerformed

    private void jCheckBox109ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox109ActionPerformed
        if (jTextField9.isEnabled()) {
            jTextField9.setEnabled(false);
        } else {
            jTextField9.setEnabled(true);
            jCheckBox109.transferFocus();
            if (jTextField9.getText().equals("")) {
                jTextField9.setText("Especificar...");
                jTextField9.selectAll();
            }
        }
    }//GEN-LAST:event_jCheckBox109ActionPerformed

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
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox100;
    private javax.swing.JCheckBox jCheckBox101;
    private javax.swing.JCheckBox jCheckBox102;
    private javax.swing.JCheckBox jCheckBox103;
    private javax.swing.JCheckBox jCheckBox104;
    private javax.swing.JCheckBox jCheckBox105;
    private javax.swing.JCheckBox jCheckBox106;
    private javax.swing.JCheckBox jCheckBox107;
    private javax.swing.JCheckBox jCheckBox108;
    private javax.swing.JCheckBox jCheckBox109;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox110;
    private javax.swing.JCheckBox jCheckBox111;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox16;
    private javax.swing.JCheckBox jCheckBox17;
    private javax.swing.JCheckBox jCheckBox18;
    private javax.swing.JCheckBox jCheckBox19;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox20;
    private javax.swing.JCheckBox jCheckBox21;
    private javax.swing.JCheckBox jCheckBox22;
    private javax.swing.JCheckBox jCheckBox23;
    private javax.swing.JCheckBox jCheckBox24;
    private javax.swing.JCheckBox jCheckBox25;
    private javax.swing.JCheckBox jCheckBox26;
    private javax.swing.JCheckBox jCheckBox27;
    private javax.swing.JCheckBox jCheckBox28;
    private javax.swing.JCheckBox jCheckBox29;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox30;
    private javax.swing.JCheckBox jCheckBox31;
    private javax.swing.JCheckBox jCheckBox32;
    private javax.swing.JCheckBox jCheckBox33;
    private javax.swing.JCheckBox jCheckBox34;
    private javax.swing.JCheckBox jCheckBox35;
    private javax.swing.JCheckBox jCheckBox36;
    private javax.swing.JCheckBox jCheckBox37;
    private javax.swing.JCheckBox jCheckBox38;
    private javax.swing.JCheckBox jCheckBox39;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox40;
    private javax.swing.JCheckBox jCheckBox41;
    private javax.swing.JCheckBox jCheckBox42;
    private javax.swing.JCheckBox jCheckBox43;
    private javax.swing.JCheckBox jCheckBox44;
    private javax.swing.JCheckBox jCheckBox45;
    private javax.swing.JCheckBox jCheckBox46;
    private javax.swing.JCheckBox jCheckBox47;
    private javax.swing.JCheckBox jCheckBox48;
    private javax.swing.JCheckBox jCheckBox49;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox50;
    private javax.swing.JCheckBox jCheckBox51;
    private javax.swing.JCheckBox jCheckBox52;
    private javax.swing.JCheckBox jCheckBox53;
    private javax.swing.JCheckBox jCheckBox54;
    private javax.swing.JCheckBox jCheckBox55;
    private javax.swing.JCheckBox jCheckBox56;
    private javax.swing.JCheckBox jCheckBox57;
    private javax.swing.JCheckBox jCheckBox58;
    private javax.swing.JCheckBox jCheckBox59;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox60;
    private javax.swing.JCheckBox jCheckBox61;
    private javax.swing.JCheckBox jCheckBox62;
    private javax.swing.JCheckBox jCheckBox63;
    private javax.swing.JCheckBox jCheckBox64;
    private javax.swing.JCheckBox jCheckBox65;
    private javax.swing.JCheckBox jCheckBox66;
    private javax.swing.JCheckBox jCheckBox67;
    private javax.swing.JCheckBox jCheckBox68;
    private javax.swing.JCheckBox jCheckBox69;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox70;
    private javax.swing.JCheckBox jCheckBox71;
    private javax.swing.JCheckBox jCheckBox72;
    private javax.swing.JCheckBox jCheckBox73;
    private javax.swing.JCheckBox jCheckBox74;
    private javax.swing.JCheckBox jCheckBox75;
    private javax.swing.JCheckBox jCheckBox76;
    private javax.swing.JCheckBox jCheckBox77;
    private javax.swing.JCheckBox jCheckBox78;
    private javax.swing.JCheckBox jCheckBox79;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox80;
    private javax.swing.JCheckBox jCheckBox81;
    private javax.swing.JCheckBox jCheckBox82;
    private javax.swing.JCheckBox jCheckBox83;
    private javax.swing.JCheckBox jCheckBox84;
    private javax.swing.JCheckBox jCheckBox85;
    private javax.swing.JCheckBox jCheckBox86;
    private javax.swing.JCheckBox jCheckBox87;
    private javax.swing.JCheckBox jCheckBox88;
    private javax.swing.JCheckBox jCheckBox89;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JCheckBox jCheckBox90;
    private javax.swing.JCheckBox jCheckBox91;
    private javax.swing.JCheckBox jCheckBox92;
    private javax.swing.JCheckBox jCheckBox93;
    private javax.swing.JCheckBox jCheckBox94;
    private javax.swing.JCheckBox jCheckBox95;
    private javax.swing.JCheckBox jCheckBox96;
    private javax.swing.JCheckBox jCheckBox97;
    private javax.swing.JCheckBox jCheckBox98;
    private javax.swing.JCheckBox jCheckBox99;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
