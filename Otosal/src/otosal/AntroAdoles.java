/*
 * To change this template, choose Tools | Templates
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
import javax.swing.JDialog;
import javax.swing.JFrame;
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
public class AntroAdoles extends javax.swing.JDialog {

    static final String ControladorJDBC = "org.sqlite.JDBC";
    static final String baseDatos = "jdbc:sqlite:./Otosal.sqlite";
    private Connection conexion;
    private Statement instruccion;
    Double edadMes;
     Integer edad;
    int cod = new Integer(0);

    /** Creates new form AntroAdoles */
    public AntroAdoles() {
        //Constructor para poder llamarlo desde otro formulario
    }

    public AntroAdoles(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();

         try{
            Class.forName(ControladorJDBC);
            conexion = DriverManager.getConnection(baseDatos);
            instruccion = conexion.createStatement();
            System.out.println("Base de datos cargada");
            ResultSet rs = instruccion.executeQuery("Select id, Nombre, FechNac, sexo  from TempPaci");
            rs.next();
            TFCod.setText(rs.getString(1));
            TFNombre.setText(rs.getString(2));
            TFFechNac.setText(rs.getString(3));
            edad = calcularEdad(TFFechNac.getText());
            edadMes = calcularMeses(TFFechNac.getText());
            TFEdad.setText(edad.toString());
            if (rs.getString(4).equals("Varon"))
                RBVaron.setSelected(true);
            else if (rs.getString(4).equals("Mujer"))
                RBHembra.setSelected(true);
            rs.close();
            instruccion.close();
            conexion.close();
            //Pongo a editable false para que no se pueda modificar
            TFCod.setEditable(false);
            TFNombre.setEditable(false);
            TFFechNac.setEditable(false);
            TFEdad.setEditable(false);
            RBVaron.setEnabled(false);
            RBHembra.setEnabled(false);
            LTE.setEnabled(false);
            LPE.setEnabled(false);
            LPBE.setEnabled(false);
            LIE.setEnabled(false);
            TFLEP.setEditable(false);
            TFLEP50.setEditable(false);
            TFPPE.setEditable(false);
            TFPEP50.setEditable(false);
            TFPBEP.setEditable(false);
            TFPBEP50.setEditable(false);
            TFIEP.setEditable(false);
            TFIEP50.setEditable(false);
            TFPBEP.setEditable(false);
            TFPBEP50.setEditable(false);
            RBTE.setEnabled(false);
            RBPE.setEnabled(false);
            RBPBE.setEnabled(false);
            RBIE.setEnabled(false);
            LPTE.setEnabled(false);
            TFPTEP.setEditable(false);
            TFPTEP50.setEditable(false);
            TFLongitud.requestFocus();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conexion.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public Integer edad() {
        edad = 0;
        try{
            Class.forName(ControladorJDBC);
            conexion = DriverManager.getConnection(baseDatos);
            instruccion = conexion.createStatement();
            System.out.println("Base de datos cargada");
            ResultSet rs = instruccion.executeQuery("Select FechNac  from TempPaci");
            rs.next();
            edad = calcularEdad(TFFechNac.getText());
            rs.close();
            instruccion.close();
            conexion.close();
        } catch(Exception e) {}
        return edad;
    }
    public String sexo () {
        String sex = "";
        try{
            Class.forName(ControladorJDBC);
            conexion = DriverManager.getConnection(baseDatos);
            instruccion = conexion.createStatement();
            System.out.println("Base de datos cargada");
            ResultSet rs = instruccion.executeQuery("Select sexo from TempPaci");
            rs.next();
            sex = rs.getString(1);
            rs.close();
            instruccion.close();
            conexion.close();
        } catch(Exception e) {}
        return sex;
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
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TFCod = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TFNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TFFechNac = new javax.swing.JTextField();
        TFEdad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        RBVaron = new javax.swing.JRadioButton();
        RBHembra = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        TFLongitud = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TFPeso = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TFIMC = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        TFPerBra = new javax.swing.JTextField();
        TFPliTri = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        BGraCorp = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        RBOrbegozo = new javax.swing.JRadioButton();
        RBWho = new javax.swing.JRadioButton();
        RBCDC = new javax.swing.JRadioButton();
        RBCarrascosa = new javax.swing.JRadioButton();
        jPanel9 = new javax.swing.JPanel();
        LINPBE = new javax.swing.JLabel();
        LINIE = new javax.swing.JLabel();
        LINLE = new javax.swing.JLabel();
        LINPE = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        TFLEP50 = new javax.swing.JTextField();
        TFPEP50 = new javax.swing.JTextField();
        TFPBEP50 = new javax.swing.JTextField();
        TFIEP50 = new javax.swing.JTextField();
        TFIEP = new javax.swing.JTextField();
        TFPBEP = new javax.swing.JTextField();
        TFPPE = new javax.swing.JTextField();
        TFLEP = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        LTE = new javax.swing.JLabel();
        LPE = new javax.swing.JLabel();
        LPBE = new javax.swing.JLabel();
        LIE = new javax.swing.JLabel();
        LINPTE = new javax.swing.JLabel();
        LPTE = new javax.swing.JLabel();
        TFPTEP = new javax.swing.JTextField();
        TFPTEP50 = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        RBTE = new javax.swing.JRadioButton();
        RBPBE = new javax.swing.JRadioButton();
        RBIE = new javax.swing.JRadioButton();
        RBPE = new javax.swing.JRadioButton();
        DPImagen = new javax.swing.JDesktopPane();
        jPanel3 = new javax.swing.JPanel();
        BGuardar2 = new javax.swing.JButton();
        BCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("AntopometríaInfancia y Adolescencia (2 - 18 años)");

        jPanel1.setName("jPanel1"); // NOI18N

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

        jLabel3.setText("Fecha Nacimiento");
        jLabel3.setName("jLabel3"); // NOI18N

        TFFechNac.setName("TFFechNac"); // NOI18N

        TFEdad.setName("TFEdad"); // NOI18N

        jLabel4.setText("Edad");
        jLabel4.setName("jLabel4"); // NOI18N

        jPanel6.setBackground(new java.awt.Color(229, 184, 183));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Sexo"));
        jPanel6.setToolTipText("Sexo");
        jPanel6.setName("jPanel6"); // NOI18N

        RBVaron.setBackground(new java.awt.Color(229, 184, 183));
        RBVaron.setText("Varon");
        RBVaron.setName("RBVaron"); // NOI18N

        RBHembra.setBackground(new java.awt.Color(229, 184, 183));
        RBHembra.setText("Mujer");
        RBHembra.setName("RBHembra"); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(RBVaron)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RBHembra)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RBVaron)
                    .addComponent(RBHembra))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TFCod, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TFFechNac, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TFEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TFFechNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(TFCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TFEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addComponent(jLabel4))))
                .addGap(56, 56, 56))
        );

        jPanel5.setBackground(new java.awt.Color(229, 184, 183));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setName("jPanel5"); // NOI18N

        TFLongitud.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TFLongitud.setName("TFLongitud"); // NOI18N
        TFLongitud.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TFLongitudFocusLost(evt);
            }
        });

        jLabel5.setText("Talla (cm)");
        jLabel5.setName("jLabel5"); // NOI18N

        TFPeso.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TFPeso.setName("TFPeso"); // NOI18N
        TFPeso.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TFPesoFocusLost(evt);
            }
        });

        jLabel6.setText("Peso (Kg)");
        jLabel6.setName("jLabel6"); // NOI18N

        jLabel8.setText("I.M.C.");
        jLabel8.setName("jLabel8"); // NOI18N

        TFIMC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TFIMC.setName("TFIMC"); // NOI18N

        jLabel7.setText("Perimetro braquial (cm)");
        jLabel7.setName("jLabel7"); // NOI18N

        TFPerBra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TFPerBra.setName("TFPerBra"); // NOI18N

        TFPliTri.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TFPliTri.setName("TFPliTri"); // NOI18N

        jLabel9.setText("Pliegue Tricipital (mm)");
        jLabel9.setName("jLabel9"); // NOI18N

        jPanel11.setBackground(new java.awt.Color(229, 184, 183));
        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel11.setName("jPanel11"); // NOI18N

        jLabel10.setText("% Grasa Corporal");
        jLabel10.setName("jLabel10"); // NOI18N

        jLabel12.setText("% Grasa Magra");
        jLabel12.setName("jLabel12"); // NOI18N

        jLabel13.setText("% de Agua corporal Total");
        jLabel13.setName("jLabel13"); // NOI18N

        BGraCorp.setText("jButton1");
        BGraCorp.setName("BGraCorp"); // NOI18N
        BGraCorp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BGraCorpActionPerformed(evt);
            }
        });

        jTextField1.setName("jTextField1"); // NOI18N

        jButton2.setText("jButton1");
        jButton2.setName("jButton2"); // NOI18N

        jTextField2.setName("jTextField2"); // NOI18N

        jTextField3.setName("jTextField3"); // NOI18N

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(BGraCorp, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)))
                .addGap(31, 31, 31))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(BGraCorp, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(TFIMC, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(TFLongitud, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(TFPerBra, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TFPeso)
                    .addComponent(TFPliTri, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(TFPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TFPliTri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(TFLongitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(TFIMC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(TFPerBra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(229, 184, 183));
        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel7.setName("jPanel7"); // NOI18N
        jPanel7.setPreferredSize(new java.awt.Dimension(720, 361));

        jPanel8.setBackground(new java.awt.Color(229, 184, 183));
        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel8.setName("jPanel8"); // NOI18N

        RBOrbegozo.setBackground(new java.awt.Color(229, 184, 183));
        BGPaper.add(RBOrbegozo);
        RBOrbegozo.setText("Fundación Faustino Orbegozo Eizaguirre 2004");
        RBOrbegozo.setName("RBOrbegozo"); // NOI18N
        RBOrbegozo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBOrbegozoActionPerformed(evt);
            }
        });

        RBWho.setBackground(new java.awt.Color(229, 184, 183));
        BGPaper.add(RBWho);
        RBWho.setText("World Health Organization (WHO) 2006");
        RBWho.setName("RBWho"); // NOI18N
        RBWho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBWhoActionPerformed(evt);
            }
        });

        RBCDC.setBackground(new java.awt.Color(229, 184, 183));
        BGPaper.add(RBCDC);
        RBCDC.setText("Centre for Disease Control (CDC) 2000");
        RBCDC.setName("RBCDC"); // NOI18N
        RBCDC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBCDCActionPerformed(evt);
            }
        });

        RBCarrascosa.setBackground(new java.awt.Color(229, 184, 183));
        BGPaper.add(RBCarrascosa);
        RBCarrascosa.setText("Estudios Españoles de Crecimiento 2008 Carrascosa");
        RBCarrascosa.setName("RBCarrascosa"); // NOI18N
        RBCarrascosa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBCarrascosaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RBOrbegozo)
                    .addComponent(RBCarrascosa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RBCDC)
                    .addComponent(RBWho))
                .addGap(77, 77, 77))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(RBOrbegozo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RBCarrascosa))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(RBCDC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RBWho)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(229, 184, 183));
        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel9.setName("jPanel9"); // NOI18N

        LINPBE.setFont(new java.awt.Font("Tahoma", 1, 12));
        LINPBE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LINPBE.setName("LINPBE"); // NOI18N

        LINIE.setFont(new java.awt.Font("Tahoma", 1, 12));
        LINIE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LINIE.setName("LINIE"); // NOI18N

        LINLE.setFont(new java.awt.Font("Tahoma", 1, 12));
        LINLE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LINLE.setName("LINLE"); // NOI18N

        LINPE.setFont(new java.awt.Font("Tahoma", 1, 12));
        LINPE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LINPE.setName("LINPE"); // NOI18N

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Percentil 50");
        jLabel21.setName("jLabel21"); // NOI18N

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Indice Nutricional");
        jLabel11.setName("jLabel11"); // NOI18N

        TFLEP50.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TFLEP50.setName("TFLEP50"); // NOI18N

        TFPEP50.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TFPEP50.setName("TFPEP50"); // NOI18N

        TFPBEP50.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TFPBEP50.setName("TFPBEP50"); // NOI18N

        TFIEP50.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TFIEP50.setName("TFIEP50"); // NOI18N

        TFIEP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TFIEP.setName("TFIEP"); // NOI18N

        TFPBEP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TFPBEP.setName("TFPBEP"); // NOI18N

        TFPPE.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TFPPE.setName("TFPPE"); // NOI18N

        TFLEP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TFLEP.setName("TFLEP"); // NOI18N

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Percentiles");
        jLabel18.setMinimumSize(new java.awt.Dimension(75, 17));
        jLabel18.setName("jLabel18"); // NOI18N

        LTE.setText("Talla / Edad");
        LTE.setName("LTE"); // NOI18N

        LPE.setText("Peso / Edad");
        LPE.setName("LPE"); // NOI18N

        LPBE.setText("Perímetro braquial / Edad");
        LPBE.setName("LPBE"); // NOI18N

        LIE.setText("I.M.C. / Edad");
        LIE.setName("LIE"); // NOI18N

        LINPTE.setFont(new java.awt.Font("Tahoma", 1, 12));
        LINPTE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LINPTE.setName("LINPTE"); // NOI18N

        LPTE.setText("Pliegue tricipitall / Edad");
        LPTE.setName("LPTE"); // NOI18N

        TFPTEP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TFPTEP.setName("TFPTEP"); // NOI18N

        TFPTEP50.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TFPTEP50.setName("TFPTEP50"); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(LTE)
                                .addGap(93, 93, 93)
                                .addComponent(TFLEP, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LPBE)
                                    .addComponent(LPE)
                                    .addComponent(LIE)
                                    .addComponent(LPTE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TFPPE, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                                    .addComponent(TFPBEP, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                                    .addComponent(TFPTEP, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                                    .addComponent(TFIEP, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))))
                        .addGap(68, 68, 68)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TFPEP50, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(TFPBEP50, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(TFPTEP50, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(TFIEP50, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(TFLEP50, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LINPE, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(LINLE, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                        .addComponent(LINPBE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LINPTE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LINIE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(171, 171, 171))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LTE)
                            .addComponent(TFLEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TFPPE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LPE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LPBE)
                            .addComponent(TFPBEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TFPTEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LPTE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LIE)
                            .addComponent(TFIEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LINLE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TFLEP50))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(LINPE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LINPBE, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(TFPEP50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TFPBEP50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TFPTEP50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LINPTE, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TFIEP50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LINIE, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(229, 184, 183));
        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel10.setName("jPanel10"); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma 14 Negrita cursiva", 3, 14));
        jLabel15.setText("Graficas");
        jLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel15.setName("jLabel15"); // NOI18N

        RBTE.setBackground(new java.awt.Color(229, 184, 183));
        BGGrafica.add(RBTE);
        RBTE.setText("Talla / Edad");
        RBTE.setName("RBTE"); // NOI18N
        RBTE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBTEActionPerformed(evt);
            }
        });

        RBPBE.setBackground(new java.awt.Color(229, 184, 183));
        BGGrafica.add(RBPBE);
        RBPBE.setText("Perimetro braquial / Edad");
        RBPBE.setName("RBPBE"); // NOI18N
        RBPBE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBPBEActionPerformed(evt);
            }
        });

        RBIE.setBackground(new java.awt.Color(229, 184, 183));
        BGGrafica.add(RBIE);
        RBIE.setText("I.M.C. / Edad");
        RBIE.setName("RBIE"); // NOI18N
        RBIE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBIEActionPerformed(evt);
            }
        });

        RBPE.setBackground(new java.awt.Color(229, 184, 183));
        BGGrafica.add(RBPE);
        RBPE.setText("Peso / Edad");
        RBPE.setName("RBPE"); // NOI18N
        RBPE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBPEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RBTE)
                    .addComponent(RBPBE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RBPE)
                    .addComponent(RBIE))
                .addGap(38, 38, 38))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(jLabel15)
                .addContainerGap(148, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(RBTE)
                        .addGap(18, 18, 18)
                        .addComponent(RBPBE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(RBIE))
                    .addComponent(RBPE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        DPImagen.setBackground(new java.awt.Color(229, 184, 183));
        DPImagen.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        DPImagen.setName("DPImagen"); // NOI18N

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DPImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DPImagen))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1181, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BGuardar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BGuardar2ActionPerformed

}//GEN-LAST:event_BGuardar2ActionPerformed

    private void BCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCerrarActionPerformed
        try{
            conexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        dispose();
}//GEN-LAST:event_BCerrarActionPerformed

    private void TFLongitudFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFLongitudFocusLost
        //Compruebo que el campo longitud y peso tenga valor y si lo tiene calculo el imc
        if (!TFLongitud.getText().equals("") && !TFPeso.getText().equals("")) {
            Double imc;
            imc= (Double.valueOf(TFPeso.getText().trim()).doubleValue() / ((Double.valueOf(TFLongitud.getText().trim()).doubleValue()/100)*(Double.valueOf(TFLongitud.getText().trim()).doubleValue()/100)) );
            int numero = (int) (imc * 100);
            System.out.println(numero);
            imc =  numero / 100. ;
            System.out.println(imc);
            TFIMC.setText(Double.toString(imc));
            TFIMC.setEditable(false);
        }
}//GEN-LAST:event_TFLongitudFocusLost

    private void TFPesoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TFPesoFocusLost
        //Compruebo que el campo longitud y peso tenga valor y si lo tiene calculo el imc
        if (!TFLongitud.getText().equals("") && !TFPeso.getText().equals("")) {
            Double imc;
            imc= (Double.valueOf(TFPeso.getText().trim()).doubleValue() / ((Double.valueOf(TFLongitud.getText().trim()).doubleValue()/100)*(Double.valueOf(TFLongitud.getText().trim()).doubleValue()/100)) );
            int numero = (int) (imc * 100);
            System.out.println(numero);
            imc =  numero / 100. ;
            System.out.println(imc);
            TFIMC.setText(Double.toString(imc));
            TFIMC.setEditable(false);
        }
}//GEN-LAST:event_TFPesoFocusLost

    private void RBOrbegozoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBOrbegozoActionPerformed
        try {
            if (RBOrbegozo.isSelected()) {
                LIE.setEnabled(true);
                LTE.setEnabled(true);
                LPE.setEnabled(true);
                LPBE.setEnabled(true);
                LPTE.setEnabled(true);
                RBTE.setEnabled(true);
                RBPE.setEnabled(true);
                RBPBE.setEnabled(true);
                RBIE.setEnabled(true);
            if (!TFPeso.getText().equals("") && !TFLongitud.getText().equals("")) {

                    edadMes=calcularMeses(TFFechNac.getText());

                    conexion = DriverManager.getConnection(baseDatos);
                    instruccion = conexion.createStatement();
                    ResultSet rs = instruccion.executeQuery("select id, edad from AdolesOrbegozoV");
                    while(rs.next()){
                        if (rs.getDouble(2) > edadMes) {
                            cod=rs.getInt(1);
                            break;
                        } else if (rs.getDouble(2) == edadMes) {
                            cod=rs.getInt(1);
                            break;
                        }
                    }
                    rs.close();
                    if (RBVaron.isSelected())
                        rs = instruccion.executeQuery("Select * from AdolesOrbegozoV where id = " + cod );
                    else if (RBHembra.isSelected())
                        rs = instruccion.executeQuery("Select * from AdolesOrbegozoM where id = " + cod );
                    rs.next();
                    TFLEP50.setText(rs.getString(4));
                    TFPEP50.setText(rs.getString(7));
                    TFIEP50.setText(rs.getString(10));
                    TFPBEP50.setText(rs.getString(17));
                    TFPTEP50.setText(rs.getString(22));
                    Double Lon = Double.valueOf(TFLongitud.getText().trim()).doubleValue();
                    if ( Lon < rs.getDouble(3)) {
                        LINLE.setForeground(Color.red);
                        LINLE.setText("Desnutrición");
                        TFLEP.setText("< P3");
                    }
                    if (rs.getDouble(3) == Lon ) {
                        LINLE.setForeground(Color.black);
                        LINLE.setText("Normal");
                        TFLEP.setText("P3");
                    }
                    if (rs.getDouble(4) > Lon  && Lon > rs.getDouble(3)) {
                        LINLE.setForeground(Color.black);
                        LINLE.setText("Normal");
                        TFLEP.setText("P3 - P50");
                    }
                    if (rs.getDouble(4) == Lon ) {
                        LINLE.setForeground(Color.black);
                        LINLE.setText("Normal");
                        TFLEP.setText("P50");
                    }
                    if (rs.getDouble(5) > Lon  && Lon > rs.getDouble(4)) {
                        LINLE.setForeground(Color.black);
                        LINLE.setText("Normal");
                        TFLEP.setText("P50 - P97");
                    }
                    if (rs.getDouble(5) == Lon ) {
                        LINLE.setForeground(Color.black);
                        LINLE.setText("Normal");
                        TFLEP.setText("P97");
                    }
                    if (rs.getDouble(5) < Lon) {
                        LINLE.setForeground(Color.red);
                        LINLE.setText("Alto");
                        TFLEP.setText("> P97");
                    }
                    Double Peso = Double.valueOf(TFPeso.getText().trim()).doubleValue();
                     if ( Peso < rs.getDouble(6)) {
                         LINPE.setForeground(Color.red);
                        LINPE.setText("Desnutrición");
                        TFPPE.setText("< P3");
                    }
                    if (rs.getDouble(6) == Peso ) {
                        LINPE.setForeground(Color.black);
                        LINPE.setText("Normal");
                        TFPPE.setText("P3");
                    }
                    if (rs.getDouble(7) > Peso  && Peso > rs.getDouble(6)) {
                        LINPE.setForeground(Color.black);
                        LINPE.setText("Normal");
                        TFPPE.setText("P3 - P50");
                    }
                    if (rs.getDouble(7) == Peso ) {
                        LINPE.setForeground(Color.black);
                        LINPE.setText("Normal");
                        TFPPE.setText("P50");
                    }
                    if (rs.getDouble(8) > Peso && Peso > rs.getDouble(7)) {
                        LINPE.setForeground(Color.black);
                        LINPE.setText("Normal");
                        TFPPE.setText("P50 - P97");
                    }
                    if (rs.getDouble(8) == Peso ) {
                        LINPE.setForeground(Color.black);
                        LINPE.setText("Normal");
                        TFPPE.setText("P97");
                    }
                    if (rs.getDouble(8) < Peso) {
                        LINPE.setForeground(Color.red);
                        LINPE.setText("Obesidad");
                        TFPPE.setText("> P97");
                    }
                    Double IMC = Double.valueOf(TFIMC.getText().trim()).doubleValue();
                    if ( IMC < rs.getDouble(9)) {
                        LINIE.setForeground(Color.red);
                        LINIE.setText("Desnutrición");
                        TFIEP.setText("< P3");
                    }
                    if (rs.getDouble(9) == IMC ) {
                        LINIE.setForeground(Color.black);
                        LINIE.setText("Normal");
                        TFIEP.setText("P3");
                    }
                    if (rs.getDouble(10) > IMC  && IMC > rs.getDouble(9)) {
                        LINIE.setForeground(Color.black);
                        LINIE.setText("Normal");
                        TFIEP.setText("P3 - P50");
                    }
                    if (rs.getDouble(10) == IMC ) {
                        LINIE.setForeground(Color.black);
                        LINIE.setText("Normal");
                        TFIEP.setText("P50");
                    }
                    if (rs.getDouble(11) > IMC && IMC > rs.getDouble(10)) {
                        LINIE.setForeground(Color.black);
                        LINIE.setText("Normal");
                        TFIEP.setText("P50 - P85");
                    }
                    if (rs.getDouble(11) == IMC ) {
                        LINIE.setForeground(Color.black);
                        LINIE.setText("Normal");
                        TFIEP.setText("P85");
                    }
                    if (rs.getDouble(12) > IMC && IMC > rs.getDouble(11)) {
                        LINIE.setForeground(Color.YELLOW);
                        LINIE.setText("Sobrepeso");
                        TFIEP.setText("P85 - P95");
                    }
                    if (rs.getDouble(12) == IMC ) {
                        LINIE.setForeground(Color.yellow);
                        LINIE.setText("Sobrepeso");
                        TFIEP.setText("P95");
                    }
                    if (rs.getDouble(13) > IMC && IMC > rs.getDouble(12)) {
                        LINIE.setForeground(Color.red);
                        LINIE.setText("Obesidad");
                        TFIEP.setText("P95 - P97");
                    }
                    if (rs.getDouble(13) == IMC ) {
                        LINIE.setForeground(Color.red);
                        LINIE.setText("Obesidad");
                        TFIEP.setText("P97");
                    }
                    if (rs.getDouble(13) < IMC) {
                        LINIE.setForeground(Color.red);
                        LINIE.setText("Obesidad");
                        TFIEP.setText("> P97");
                    }
                    Double PBraE = Double.valueOf(TFPerBra.getText().trim()).doubleValue();
                    if ( PBraE < rs.getDouble(14)) {
                        LINPBE.setForeground(Color.red);
                        LINPBE.setText("Desnutrición");
                        TFPBEP.setText("< P3");
                    }
                    if (rs.getDouble(14) == PBraE ) {
                        LINPBE.setForeground(Color.black);
                        LINPBE.setText("Normal");
                        TFPBEP.setText("P3");
                    }
                    if (rs.getDouble(15) > PBraE  && PBraE > rs.getDouble(14)) {
                        LINPBE.setForeground(Color.black);
                        LINPBE.setText("Normal");
                        TFPBEP.setText("P3 - P10");
                    }
                    if (rs.getDouble(15) == PBraE ) {
                        LINPBE.setForeground(Color.black);
                        LINPBE.setText("Normal");
                        TFPBEP.setText("P10");
                    }
                    if (rs.getDouble(16) > PBraE  && PBraE > rs.getDouble(15)) {
                        LINPBE.setForeground(Color.black);
                        LINPBE.setText("Normal");
                        TFPBEP.setText("P10 - P25");
                    }
                    if (rs.getDouble(16) == PBraE ) {
                        LINPBE.setForeground(Color.black);
                        LINPBE.setText("Normal");
                        TFPBEP.setText("P25");
                    }
                    if (rs.getDouble(17) > PBraE && PBraE > rs.getDouble(16)) {
                        LINPBE.setForeground(Color.black);
                        LINPBE.setText("Normal");
                        TFPBEP.setText("P25 - P50");
                    }
                    if (rs.getDouble(17) == PBraE ) {
                        LINPBE.setForeground(Color.black);
                        LINPBE.setText("Normal");
                        TFPBEP.setText("P50");
                    }
                    if (rs.getDouble(18) > PBraE && PBraE > rs.getDouble(17)) {
                        LINPBE.setForeground(Color.black);
                        LINPBE.setText("Normal");
                        TFPBEP.setText("P50 - P75");
                    }
                    if (rs.getDouble(18) == PBraE ) {
                        LINPBE.setForeground(Color.black);
                        LINPBE.setText("Normal");
                        TFPBEP.setText("P75");
                    }
                    if (rs.getDouble(19) > PBraE && PBraE > rs.getDouble(18)) {
                        LINPBE.setForeground(Color.black);
                        LINPBE.setText("Normal");
                        TFPBEP.setText("P75 - P90");
                    }
                    if (rs.getDouble(19) == PBraE ) {
                        LINPBE.setForeground(Color.black);
                        LINPBE.setText("Normal");
                        TFPBEP.setText("P90");
                    }
                    if (rs.getDouble(20) > PBraE && PBraE > rs.getDouble(19)) {
                        LINPBE.setForeground(Color.black);
                        LINPBE.setText("Normal");
                        TFPBEP.setText("P90 - P97");
                    }
                    if (rs.getDouble(20) == PBraE ) {
                        LINPBE.setForeground(Color.black);
                        LINPBE.setText("Alto");
                        TFPBEP.setText("P97");
                    }
                    if (rs.getDouble(20) < PBraE) {
                        LINPBE.setForeground(Color.red);
                        LINPBE.setText("Obesidad");
                        TFPBEP.setText("> P97");
                    }
                    Double PTriE = Double.valueOf(TFPliTri.getText().trim()).doubleValue();
                    if ( PTriE < rs.getDouble(21)) {
                        LINPTE.setForeground(Color.RED);
                        LINPTE.setText("Desnutrición");
                        TFPTEP.setText("< P3");
                    }
                    if (rs.getDouble(21) == PTriE ) {
                        LINPTE.setForeground(Color.BLACK);
                        LINPTE.setText("Normal");
                        TFPTEP.setText("P3");
                    }
                    if (rs.getDouble(22) > PTriE  && PTriE > rs.getDouble(21)) {
                        LINPTE.setForeground(Color.BLACK);
                        LINPTE.setText("Normal");
                        TFPTEP.setText("P3 - P50");
                    }
                    if (rs.getDouble(22) == PTriE ) {
                        LINPTE.setForeground(Color.BLACK);
                        LINPTE.setText("Normal");
                        TFPTEP.setText("P50");
                    }
                    if (rs.getDouble(23) > PTriE  && PTriE > rs.getDouble(22)) {
                        LINPTE.setForeground(Color.BLACK);
                        LINPTE.setText("Normal");
                        TFPTEP.setText("P50 - P97");
                    }
                    if (rs.getDouble(23) == PTriE ) {
                        LINPTE.setForeground(Color.BLACK);
                        LINPTE.setText("Normal");
                        TFPTEP.setText("P97");
                    }
                    if (rs.getDouble(23) < PTriE) {
                        LINPTE.setForeground(Color.red);
                        LINPTE.setText("Obesidad");
                        TFPTEP.setText("> P97");
                    }
                    rs.close();
                    instruccion.close();
                    conexion.close();
                } else {
                    JOptionPane.showMessageDialog(null, "Tienes que rellenar los campos Talla y Peso",
                    "Otoño Salud", JOptionPane.ERROR_MESSAGE);
                    LIE.setEnabled(false);
                    LTE.setEnabled(false);
                    LPE.setEnabled(false);
                    LPBE.setEnabled(false);
                    LPTE.setEnabled(false);
                    RBTE.setEnabled(false);
                    RBPE.setEnabled(false);
                    RBPBE.setEnabled(false);
                    RBIE.setEnabled(false);
                    TFLongitud.requestFocus();
                    TFLongitud.selectAll();
                }
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_RBOrbegozoActionPerformed

    private void RBCarrascosaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBCarrascosaActionPerformed
        try {
            if (RBCarrascosa.isSelected()) {
                LIE.setEnabled(true);
                LTE.setEnabled(true);
                LPE.setEnabled(true);
                LPBE.setEnabled(false);
                TFPBEP50.setText("");
                TFPTEP50.setText("");
                LPTE.setEnabled(false);
                RBTE.setEnabled(true);
                RBPE.setEnabled(true);
                RBPBE.setEnabled(false);
                RBIE.setEnabled(true);

                if (!TFPeso.getText().equals("") && !TFLongitud.getText().equals("")) {

                    edadMes=calcularMeses(TFFechNac.getText());

                    conexion = DriverManager.getConnection(baseDatos);
                    instruccion = conexion.createStatement();
                    ResultSet rs = instruccion.executeQuery("select id, edad from AdolesCarrasV");
                    while(rs.next()){
                        if (rs.getDouble(2) > edadMes) {
                            cod=rs.getInt(1);
                            break;
                        } else if (rs.getDouble(2) == edadMes) {
                            cod=rs.getInt(1);
                            break;
                        }
                    }
                    rs.close();
                    if (RBVaron.isSelected())
                        rs = instruccion.executeQuery("Select * from AdolesCarrasV where id = " + cod );
                    else if (RBHembra.isSelected())
                        rs = instruccion.executeQuery("Select * from AdolesCarrasM where id = " + cod );
                    rs.next();
                    TFLEP50.setText(rs.getString(6));
                    TFPEP50.setText(rs.getString(13));
                    TFIEP50.setText(rs.getString(20));
                    Double Lon = Double.valueOf(TFLongitud.getText().trim()).doubleValue();
                    if ( Lon < rs.getDouble(3)) {
                        LINLE.setForeground(Color.red);
                        LINLE.setText("Desnutrición");
                        TFLEP.setText("< P3");
                    }
                    if (rs.getDouble(3) == Lon ) {
                        LINLE.setForeground(Color.black);
                        LINLE.setText("Normal");
                        TFLEP.setText("P3");
                    }
                    if (rs.getDouble(4) > Lon  && Lon > rs.getDouble(3)) {
                        LINLE.setForeground(Color.black);
                        LINLE.setText("Normal");
                        TFLEP.setText("P3 - P10");
                    }
                    if (rs.getDouble(4) == Lon ) {
                        LINLE.setForeground(Color.black);
                        LINLE.setText("Normal");
                        TFLEP.setText("P10");
                    }
                    if (rs.getDouble(5) > Lon  && Lon > rs.getDouble(4)) {
                        LINLE.setForeground(Color.black);
                        LINLE.setText("Normal");
                        TFLEP.setText("P10 - P25");
                    }
                    if (rs.getDouble(5) == Lon ) {
                        LINLE.setForeground(Color.black);
                        LINLE.setText("Normal");
                        TFLEP.setText("P25");
                    }
                    if (rs.getDouble(6) > Lon && Lon > rs.getDouble(5)) {
                        LINLE.setForeground(Color.black);
                        LINLE.setText("Normal");
                        TFLEP.setText("P25 - P50");
                    }
                    if (rs.getDouble(6) == Lon ) {
                        LINLE.setForeground(Color.black);
                        LINLE.setText("Normal");
                        TFLEP.setText("P50");
                    }
                    if (rs.getDouble(7) > Lon && Lon > rs.getDouble(6)) {
                        LINLE.setForeground(Color.black);
                        LINLE.setText("Normal");
                        TFLEP.setText("P50 - P75");
                    }
                    if (rs.getDouble(7) == Lon ) {
                        LINLE.setForeground(Color.black);
                        LINLE.setText("Normal");
                        TFLEP.setText("P75");
                    }
                    if (rs.getDouble(8) > Lon && Lon > rs.getDouble(7)) {
                        LINLE.setForeground(Color.black);
                        LINLE.setText("Normal");
                        TFLEP.setText("P75 - P90");
                    }
                    if (rs.getDouble(8) == Lon ) {
                        LINLE.setForeground(Color.black);
                        LINLE.setText("Normal");
                        TFLEP.setText("P90");
                    }
                    if (rs.getDouble(9) > Lon && Lon > rs.getDouble(8)) {
                        LINLE.setForeground(Color.black);
                        LINLE.setText("Normal");
                        TFLEP.setText("P90 - P97");
                    }
                    if (rs.getDouble(9) == Lon ) {
                        LINLE.setForeground(Color.red);
                        LINLE.setText("Alto");
                        TFLEP.setText("P97");
                    }
                    if (rs.getDouble(9) < Lon) {
                        LINLE.setForeground(Color.red);
                        LINLE.setText("Alto");
                        TFLEP.setText("> P97");
                    }
                    Double Peso = Double.valueOf(TFPeso.getText().trim()).doubleValue();
                     if ( Peso < rs.getDouble(10)) {
                        LINPE.setForeground(Color.red);
                        LINPE.setText("Desnutrición");
                        TFPPE.setText("< P3");
                    }
                    if (rs.getDouble(10) == Peso ) {
                        LINPE.setForeground(Color.black);
                        LINPE.setText("Normal");
                        TFPPE.setText("P3");
                    }
                    if (rs.getDouble(11) > Peso  && Peso > rs.getDouble(10)) {
                        LINPE.setForeground(Color.black);
                        LINPE.setText("Normal");
                        TFPPE.setText("P3 - P10");
                    }
                    if (rs.getDouble(11) == Peso ) {
                        LINPE.setForeground(Color.black);
                        LINPE.setText("Normal");
                        TFPPE.setText("P10");
                    }
                    if (rs.getDouble(12) > Peso && Peso > rs.getDouble(11)) {
                        LINPE.setForeground(Color.black);
                        LINPE.setText("Normal");
                        TFPPE.setText("P10 - P25");
                    }
                    if (rs.getDouble(12) == Peso ) {
                        LINPE.setForeground(Color.black);
                        LINPE.setText("Normal");
                        TFPPE.setText("P25");
                    }
                    if (rs.getDouble(13) > Peso && Peso > rs.getDouble(12)) {
                        LINPE.setForeground(Color.black);
                        LINPE.setText("Normal");
                        TFPPE.setText("P25 - P50");
                    }
                    if (rs.getDouble(13) == Peso ) {
                        LINPE.setForeground(Color.black);
                        LINPE.setText("Normal");
                        TFPPE.setText("P50");
                    }
                    if (rs.getDouble(14) > Peso && Peso > rs.getDouble(13)) {
                        LINPE.setForeground(Color.black);
                        LINPE.setText("Normal");
                        TFPPE.setText("P50 - P75");
                    }
                    if (rs.getDouble(14) == Peso ) {
                        LINPE.setForeground(Color.black);
                        LINPE.setText("Normal");
                        TFPPE.setText("P75");
                    }
                    if (rs.getDouble(15) > Peso && Peso > rs.getDouble(14)) {
                        LINPE.setForeground(Color.yellow);
                        LINPE.setText("Sobrepeso");
                        TFPPE.setText("P75 - P90");
                    }
                    if (rs.getDouble(15) == Peso ) {
                        LINPE.setForeground(Color.yellow);
                        LINPE.setText("Sobrepeso");
                        TFPPE.setText("P90");
                    }
                    if (rs.getDouble(16) > Peso && Peso > rs.getDouble(15)) {
                        LINPE.setForeground(Color.yellow);
                        LINPE.setText("Sobrepeso");
                        TFPPE.setText("P90 - P97");
                    }
                    if (rs.getDouble(16) == Peso ) {
                        LINPE.setForeground(Color.red);
                        LINPE.setText("Obesidad");
                        TFPPE.setText("P97");
                    }
                    if (rs.getDouble(16) < Peso) {
                        LINPE.setForeground(Color.red);
                        LINPE.setText("Obesidad");
                        TFPPE.setText("> P97");
                    }
                    Double IMC = Double.valueOf(TFIMC.getText().trim()).doubleValue();
                    if ( IMC < rs.getDouble(17)) {
                        LINIE.setForeground(Color.red);
                        LINIE.setText("Desnutrición");
                        TFIEP.setText("< P3");
                    }
                    if (rs.getDouble(17) == IMC ) {
                        LINIE.setForeground(Color.black);
                        LINIE.setText("Normal");
                        TFIEP.setText("P3");
                    }
                    if (rs.getDouble(18) > IMC  && IMC > rs.getDouble(17)) {
                        LINIE.setForeground(Color.black);
                        LINIE.setText("Normal");
                        TFIEP.setText("P3 - P10");
                    }
                    if (rs.getDouble(18) == IMC ) {
                        LINIE.setForeground(Color.black);
                        LINIE.setText("Normal");
                        TFIEP.setText("P10");
                    }
                    if (rs.getDouble(19) > IMC && IMC > rs.getDouble(18)) {
                        LINIE.setForeground(Color.black);
                        LINIE.setText("Normal");
                        TFIEP.setText("P10 - P25");
                    }
                    if (rs.getDouble(19) == IMC ) {
                        LINIE.setForeground(Color.black);
                        LINIE.setText("Normal");
                        TFIEP.setText("P25");
                    }
                    if (rs.getDouble(20) > IMC && IMC > rs.getDouble(19)) {
                        LINIE.setForeground(Color.black);
                        LINIE.setText("Normal");
                        TFIEP.setText("P25 - P50");
                    }
                    if (rs.getDouble(20) == IMC ) {
                        LINIE.setForeground(Color.black);
                        LINIE.setText("Normal");
                        TFIEP.setText("P50");
                    }
                    if (rs.getDouble(21) > IMC && IMC > rs.getDouble(20)) {
                        LINIE.setForeground(Color.black);
                        LINIE.setText("Normal");
                        TFIEP.setText("P50 - P75");
                    }
                    if (rs.getDouble(21) == IMC ) {
                        LINIE.setForeground(Color.black);
                        LINIE.setText("Normal");
                        TFIEP.setText("P75");
                    }
                    if (rs.getDouble(22) > IMC && IMC > rs.getDouble(21)) {
                        LINIE.setForeground(Color.yellow);
                        LINIE.setText("Sobrepeso");
                        TFIEP.setText("P75 - P90");
                    }
                    if (rs.getDouble(22) == IMC ) {
                        LINIE.setForeground(Color.yellow);
                        LINIE.setText("Sobrepeso");
                        TFIEP.setText("P90");
                    }
                    if (rs.getDouble(23) > IMC && IMC > rs.getDouble(22)) {
                        LINIE.setForeground(Color.yellow);
                        LINIE.setText("Sobrepeso");
                        TFIEP.setText("P90 - P97");
                    }
                    if (rs.getDouble(23) == IMC ) {
                        LINIE.setForeground(Color.red);
                        LINIE.setText("Obesidad");
                        TFIEP.setText("P97");
                    }
                    if (rs.getDouble(23) < IMC) {
                        LINIE.setForeground(Color.red);
                        LINIE.setText("Obesidad");
                        TFIEP.setText("> P97");
                    }
                    rs.close();
                    instruccion.close();
                    conexion.close();
                } else {
                    JOptionPane.showMessageDialog(null, "Tienes que rellenar los campos Talla y Peso",
                    "Otoño Salud", JOptionPane.ERROR_MESSAGE);
                    LIE.setEnabled(false);
                    LTE.setEnabled(false);
                    LPE.setEnabled(false);
                    LPBE.setEnabled(false);
                    LPTE.setEnabled(false);
                    RBTE.setEnabled(false);
                    RBPE.setEnabled(false);
                    RBPBE.setEnabled(false);
                    RBIE.setEnabled(false);
                    TFLongitud.requestFocus();
                    TFLongitud.selectAll();
                }
            }
        } catch (Exception e) {}
    }//GEN-LAST:event_RBCarrascosaActionPerformed

    private void RBCDCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBCDCActionPerformed
       try {
            if (RBCDC.isSelected()) {
                LIE.setEnabled(true);
                LTE.setEnabled(true);
                LPE.setEnabled(true);
                LPBE.setEnabled(false);
                TFPBEP50.setText("");
                TFPTEP50.setText("");
                LPTE.setEnabled(false);
                RBTE.setEnabled(true);
                RBPE.setEnabled(true);
                RBPBE.setEnabled(false);
                RBIE.setEnabled(true);

                if (!TFPeso.getText().equals("") && !TFLongitud.getText().equals("")) {

                    edadMes=calcularMesesCDC(TFFechNac.getText());

                    conexion = DriverManager.getConnection(baseDatos);
                    instruccion = conexion.createStatement();
                    ResultSet rs = instruccion.executeQuery("select id, edad from AdolesCDCV");
                    while(rs.next()){
                        if (rs.getDouble(2) > edadMes) {
                            cod=rs.getInt(1);
                            break;
                        } else if (rs.getDouble(2) == edadMes) {
                            cod=rs.getInt(1);
                            break;
                        }
                    }
                    rs.close();
                    if (RBVaron.isSelected())
                        rs = instruccion.executeQuery("Select * from AdolesCDCV where id = " + cod );
                    else if (RBHembra.isSelected())
                        rs = instruccion.executeQuery("Select * from AdolesCDCM where id = " + cod );
                    rs.next();
                    TFLEP50.setText(rs.getString(7));
                    TFPEP50.setText(rs.getString(16));
                    TFIEP50.setText(rs.getString(25));
                    Double Lon = Double.valueOf(TFLongitud.getText().trim()).doubleValue();
                    if ( Lon < rs.getDouble(3)) {
                        LINLE.setForeground(Color.red);
                        LINLE.setText("Desnutrición");
                        TFLEP.setText("< P3");
                    }
                    if (rs.getDouble(3) == Lon ) {
                        LINLE.setForeground(Color.black);
                        LINLE.setText("Normal");
                        TFLEP.setText("P3");
                    }
                    if (rs.getDouble(4) > Lon  && Lon > rs.getDouble(3)) {
                        LINLE.setForeground(Color.black);
                        LINLE.setText("Normal");
                        TFLEP.setText("P3 - P5");
                    }
                    if (rs.getDouble(4) == Lon ) {
                        LINLE.setForeground(Color.black);
                        LINLE.setText("Normal");
                        TFLEP.setText("P5");
                    }
                    if (rs.getDouble(5) > Lon  && Lon > rs.getDouble(4)) {
                        LINLE.setForeground(Color.black);
                        LINLE.setText("Normal");
                        TFLEP.setText("P5 - P10");
                    }
                    if (rs.getDouble(5) == Lon ) {
                        LINLE.setForeground(Color.black);
                        LINLE.setText("Normal");
                        TFLEP.setText("P10");
                    }
                    if (rs.getDouble(6) > Lon && Lon > rs.getDouble(5)) {
                        LINLE.setForeground(Color.black);
                        LINLE.setText("Normal");
                        TFLEP.setText("P10 - P25");
                    }
                    if (rs.getDouble(6) == Lon ) {
                        LINLE.setForeground(Color.black);
                        LINLE.setText("Normal");
                        TFLEP.setText("P25");
                    }
                    if (rs.getDouble(7) > Lon && Lon > rs.getDouble(6)) {
                        LINLE.setForeground(Color.black);
                        LINLE.setText("Normal");
                        TFLEP.setText("P25 - P50");
                    }
                    if (rs.getDouble(7) == Lon ) {
                        LINLE.setForeground(Color.black);
                        LINLE.setText("Normal");
                        TFLEP.setText("P50");
                    }
                    if (rs.getDouble(8) > Lon && Lon > rs.getDouble(7)) {
                        LINLE.setForeground(Color.black);
                        LINLE.setText("Normal");
                        TFLEP.setText("P50 - P75");
                    }
                    if (rs.getDouble(8) == Lon ) {
                        LINLE.setForeground(Color.black);
                        LINLE.setText("Normal");
                        TFLEP.setText("P75");
                    }
                    if (rs.getDouble(9) > Lon && Lon > rs.getDouble(8)) {
                        LINLE.setForeground(Color.black);
                        LINLE.setText("Normal");
                        TFLEP.setText("P75 - P90");
                    }
                    if (rs.getDouble(9) == Lon ) {
                        LINLE.setForeground(Color.black);
                        LINLE.setText("Normal");
                        TFLEP.setText("P90");
                    }
                    if (rs.getDouble(10) > Lon && Lon > rs.getDouble(9)) {
                        LINLE.setForeground(Color.black);
                        LINLE.setText("Normal");
                        TFLEP.setText("P90 - P95");
                    }
                    if (rs.getDouble(10) == Lon) {
                        LINLE.setForeground(Color.red);
                        LINLE.setText("Alto");
                        TFLEP.setText("P95");
                    }
                    if (rs.getDouble(11) > Lon && Lon > rs.getDouble(10)) {
                        LINLE.setForeground(Color.red);
                        LINLE.setText("Alto");
                        TFLEP.setText("P95 - P97");
                    }
                    if (rs.getDouble(11) == Lon) {
                        LINLE.setForeground(Color.red);
                        LINLE.setText("Alto");
                        TFLEP.setText("P97");
                    }
                    if (rs.getDouble(11) < Lon) {
                        LINLE.setForeground(Color.red);
                        LINLE.setText("Alto");
                        TFLEP.setText("> P97");
                    }
                    Double Peso = Double.valueOf(TFPeso.getText().trim()).doubleValue();
                     if ( Peso < rs.getDouble(12)) {
                         LINPE.setForeground(Color.red);
                        LINPE.setText("Desnutrición");
                        TFPPE.setText("< P3");
                    }
                    if (rs.getDouble(12) == Peso ) {
                        LINPE.setForeground(Color.black);
                        LINPE.setText("Normal");
                        TFPPE.setText("P3");
                    }
                    if (rs.getDouble(13) > Peso  && Peso > rs.getDouble(12)) {
                        LINPE.setForeground(Color.black);
                        LINPE.setText("Normal");
                        TFPPE.setText("P3 - P5");
                    }
                    if (rs.getDouble(13) == Peso ) {
                        LINPE.setForeground(Color.black);
                        LINPE.setText("Normal");
                        TFPPE.setText("P5");
                    }
                    if (rs.getDouble(14) > Peso && Peso > rs.getDouble(13)) {
                        LINPE.setForeground(Color.black);
                        LINPE.setText("Normal");
                        TFPPE.setText("P5 - P10");
                    }
                    if (rs.getDouble(14) == Peso ) {
                        LINPE.setForeground(Color.black);
                        LINPE.setText("Normal");
                        TFPPE.setText("P10");
                    }
                    if (rs.getDouble(15) > Peso && Peso > rs.getDouble(14)) {
                        LINPE.setForeground(Color.black);
                        LINPE.setText("Normal");
                        TFPPE.setText("P10 - P25");
                    }
                    if (rs.getDouble(15) == Peso ) {
                        LINPE.setForeground(Color.black);
                        LINPE.setText("Normal");
                        TFPPE.setText("P25");
                    }
                    if (rs.getDouble(16) > Peso && Peso > rs.getDouble(15)) {
                        LINPE.setForeground(Color.black);
                        LINPE.setText("Normal");
                        TFPPE.setText("P25 - P50");
                    }
                    if (rs.getDouble(16) == Peso ) {
                        LINPE.setForeground(Color.black);
                        LINPE.setText("Normal");
                        TFPPE.setText("P50");
                    }
                    if (rs.getDouble(17) > Peso && Peso > rs.getDouble(16)) {
                        LINPE.setForeground(Color.black);
                        LINPE.setText("Normal");
                        TFPPE.setText("P50 - P75");
                    }
                    if (rs.getDouble(17) == Peso ) {
                        LINPE.setForeground(Color.black);
                        LINPE.setText("Normal");
                        TFPPE.setText("P75");
                    }
                    if (rs.getDouble(18) > Peso && Peso > rs.getDouble(17)) {
                        LINPE.setForeground(Color.black);
                        LINPE.setText("Normal");
                        TFPPE.setText("P75 - P90");
                    }
                    if (rs.getDouble(18) == Peso ) {
                        LINPE.setForeground(Color.yellow);
                        LINPE.setText("Sobrepeso");
                        TFPPE.setText("P90");
                    }
                     if (rs.getDouble(19) > Peso && Peso > rs.getDouble(18)) {
                        LINPE.setForeground(Color.yellow);
                        LINPE.setText("Sobrepeso");
                        TFPPE.setText("P90 - P95");
                    }
                    if (rs.getDouble(19) == Peso ) {
                        LINPE.setForeground(Color.yellow);
                        LINPE.setText("Sobrepeso");
                        TFPPE.setText("P95");
                    }
                     if (rs.getDouble(20) > Peso && Peso > rs.getDouble(19)) {
                        LINPE.setForeground(Color.red);
                        LINPE.setText("Obesidad");
                        TFPPE.setText("P95 - P97");
                    }
                    if (rs.getDouble(20) == Peso ) {
                        LINPE.setForeground(Color.red);
                        LINPE.setText("Obesidad");
                        TFPPE.setText("P97");
                    }
                    if (rs.getDouble(20) < Peso) {
                        LINPE.setForeground(Color.red);
                        LINPE.setText("Obesidad");
                        TFPPE.setText("> P97");
                    }
                    Double IMC = Double.valueOf(TFIMC.getText().trim()).doubleValue();
                    if ( IMC < rs.getDouble(21)) {
                        LINIE.setForeground(Color.red);
                        LINIE.setText("Desnutrición");
                        TFIEP.setText("< P3");
                    }
                    if (rs.getDouble(21) == IMC ) {
                        LINIE.setForeground(Color.black);
                        LINIE.setText("Normal");
                        TFIEP.setText("P3");
                    }
                    if (rs.getDouble(22) > IMC  && IMC > rs.getDouble(21)) {
                        LINIE.setForeground(Color.black);
                        LINIE.setText("Normal");
                        TFIEP.setText("P3 - P5");
                    }
                    if (rs.getDouble(22) == IMC ) {
                        LINIE.setForeground(Color.black);
                        LINIE.setText("Normal");
                        TFIEP.setText("P5");
                    }
                    if (rs.getDouble(23) > IMC && IMC > rs.getDouble(22)) {
                        LINIE.setForeground(Color.black);
                        LINIE.setText("Normal");
                        TFIEP.setText("P5 - P10");
                    }
                    if (rs.getDouble(23) == IMC ) {
                        LINIE.setForeground(Color.black);
                        LINIE.setText("Normal");
                        TFIEP.setText("P10");
                    }
                    if (rs.getDouble(24) > IMC && IMC > rs.getDouble(23)) {
                        LINIE.setForeground(Color.black);
                        LINIE.setText("Normal");
                        TFIEP.setText("P10 - P25");
                    }
                    if (rs.getDouble(24) == IMC ) {
                        LINIE.setForeground(Color.black);
                        LINIE.setText("Normal");
                        TFIEP.setText("P25");
                    }
                    if (rs.getDouble(25) > IMC && IMC > rs.getDouble(24)) {
                        LINIE.setForeground(Color.black);
                        LINIE.setText("Normal");
                        TFIEP.setText("P25 - P50");
                    }
                    if (rs.getDouble(25) == IMC ) {
                        LINIE.setForeground(Color.black);
                        LINIE.setText("Normal");
                        TFIEP.setText("P50");
                    }
                    if (rs.getDouble(26) > IMC && IMC > rs.getDouble(25)) {
                        LINIE.setForeground(Color.black);
                        LINIE.setText("Normal");
                        TFIEP.setText("P50 - P75");
                    }
                    if (rs.getDouble(26) == IMC ) {
                        LINIE.setForeground(Color.black);
                        LINIE.setText("Normal");
                        TFIEP.setText("P75");
                    }
                    if (rs.getDouble(27) > IMC && IMC > rs.getDouble(26)) {
                        LINIE.setForeground(Color.black);
                        LINIE.setText("Normal");
                        TFIEP.setText("P75 - P85");
                    }
                    if (rs.getDouble(27) == IMC ) {
                        LINIE.setForeground(Color.black);
                        LINIE.setText("Normal");
                        TFIEP.setText("P85");
                    }
                    if (rs.getDouble(28) > IMC && IMC > rs.getDouble(27)) {
                        LINIE.setForeground(Color.black);
                        LINIE.setText("Normal");
                        TFIEP.setText("P85 - P90");
                    }
                    if (rs.getDouble(28) == IMC ) {
                        LINIE.setForeground(Color.black);
                        LINIE.setText("Normal");
                        TFIEP.setText("P90");
                    }
                    if (rs.getDouble(29) > IMC && IMC > rs.getDouble(28)) {
                        LINIE.setForeground(Color.yellow);
                        LINIE.setText("Sobrepeso");
                        TFIEP.setText("P90 - P95");
                    }
                    if (rs.getDouble(29) == IMC ) {
                        LINIE.setForeground(Color.yellow);
                        LINIE.setText("Sobrepeso");
                        TFIEP.setText("P95");
                    }
                    if (rs.getDouble(30) > IMC && IMC > rs.getDouble(29)) {
                        LINIE.setForeground(Color.yellow);
                        LINIE.setText("Sobrepeso");
                        TFIEP.setText("P95 - P97");
                    }
                    if (rs.getDouble(30) == IMC ) {
                        LINIE.setForeground(Color.red);
                        LINIE.setText("Obesidad");
                        TFIEP.setText("P97");
                    }
                    if (rs.getDouble(30) < IMC) {
                        LINIE.setForeground(Color.red);
                        LINIE.setText("Obesidad");
                        TFIEP.setText("> P97");
                    }
                    rs.close();
                    instruccion.close();
                    conexion.close();
                } else {
                    JOptionPane.showMessageDialog(null, "Tienes que rellenar los campos Talla y Peso",
                    "Otoño Salud", JOptionPane.ERROR_MESSAGE);
                    LIE.setEnabled(false);
                    LTE.setEnabled(false);
                    LPE.setEnabled(false);
                    LPBE.setEnabled(false);
                    LPTE.setEnabled(false);
                    RBTE.setEnabled(false);
                    RBPE.setEnabled(false);
                    RBPBE.setEnabled(false);
                    RBIE.setEnabled(false);
                    TFLongitud.requestFocus();
                    TFLongitud.selectAll();
                }
            }
        } catch (Exception e) {}
    }//GEN-LAST:event_RBCDCActionPerformed

    private void RBWhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBWhoActionPerformed
         try {
            if (RBWho.isSelected()) {
                LIE.setEnabled(true);
                LTE.setEnabled(true);
                LPE.setEnabled(true);
                LPBE.setEnabled(false);
                TFPBEP50.setText("");
                TFPTEP50.setText("");
                LPTE.setEnabled(false);
                RBTE.setEnabled(true);
                RBPE.setEnabled(true);
                RBPBE.setEnabled(false);
                RBIE.setEnabled(true);


                if (!TFPeso.getText().equals("") && !TFLongitud.getText().equals("")) {

                    edadMes=calcularMesesCDC(TFFechNac.getText());

                    conexion = DriverManager.getConnection(baseDatos);
                    instruccion = conexion.createStatement();
                    ResultSet rs = instruccion.executeQuery("select id, edad from AdolesWHOV");
                    while(rs.next()){
                        if (rs.getDouble(2) > edadMes) {
                            cod=rs.getInt(1);
                            break;
                        } else if (rs.getDouble(2) == edadMes) {
                            cod=rs.getInt(1);
                            break;
                        }
                    }
                    rs.close();
                    if (RBVaron.isSelected())
                        rs = instruccion.executeQuery("Select * from AdolesWHOV where id = " + cod );
                    else if (RBHembra.isSelected())
                        rs = instruccion.executeQuery("Select * from AdolesWHOM where id = " + cod );
                    rs.next();
                    TFLEP50.setText(rs.getString(8));
                    TFPEP50.setText(rs.getString(19));
                    TFIEP50.setText(rs.getString(30));
                    Double Lon = Double.valueOf(TFLongitud.getText().trim()).doubleValue();
                    if ( Lon < rs.getDouble(3)) {
                        LINLE.setForeground(Color.red);
                        LINLE.setText("Desnutrición");
                        TFLEP.setText("< P1");
                    }
                    if (rs.getDouble(3) == Lon ) {
                        LINLE.setForeground(Color.red);
                        LINLE.setText("Desnutrición");
                        TFLEP.setText("P1");
                    }
                    if (rs.getDouble(4) > Lon  && Lon > rs.getDouble(3)) {
                        LINLE.setForeground(Color.red);
                        LINLE.setText("Desnutrición");
                        TFLEP.setText("P1 - P3");
                    }
                    if (rs.getDouble(4) == Lon ) {
                        LINLE.setForeground(Color.yellow);
                        LINLE.setText("Peligro Desnutrición");
                        TFLEP.setText("P3");
                    }
                    if (rs.getDouble(5) > Lon  && Lon > rs.getDouble(4)) {
                        LINLE.setForeground(Color.yellow);
                        LINLE.setText("Peligro Desnutrición");
                        TFLEP.setText("P3 - P5");
                    }
                    if (rs.getDouble(5) == Lon ) {
                        LINLE.setForeground(Color.yellow);
                        LINLE.setText("Peligro Desnutrición");
                        TFLEP.setText("P5");
                    }
                    if (rs.getDouble(6) > Lon && Lon > rs.getDouble(5)) {
                        LINLE.setForeground(Color.yellow);
                        LINLE.setText("Peligro Desnutrición");
                        TFLEP.setText("P5 - P15");
                    }
                    if (rs.getDouble(6) == Lon ) {
                        LINLE.setForeground(Color.black);
                        LINLE.setText("Normal");
                        TFLEP.setText("P15");
                    }
                    if (rs.getDouble(7) > Lon && Lon > rs.getDouble(6)) {
                        LINLE.setForeground(Color.black);
                        LINLE.setText("Normal");
                        TFLEP.setText("P15 - P25");
                    }
                    if (rs.getDouble(7) == Lon ) {
                        LINLE.setForeground(Color.black);
                        LINLE.setText("Normal");
                        TFLEP.setText("P25");
                    }
                    if (rs.getDouble(8) > Lon && Lon > rs.getDouble(7)) {
                        LINLE.setForeground(Color.black);
                        LINLE.setText("Normal");
                        TFLEP.setText("P25 - P50");
                    }
                    if (rs.getDouble(8) == Lon ) {
                        LINLE.setForeground(Color.black);
                        LINLE.setText("Normal");
                        TFLEP.setText("P50");
                    }
                    if (rs.getDouble(9) > Lon && Lon > rs.getDouble(8)) {
                        LINLE.setForeground(Color.black);
                        LINLE.setText("Normal");
                        TFLEP.setText("P50 - P75");
                    }
                    if (rs.getDouble(9) == Lon ) {
                        LINLE.setForeground(Color.black);
                        LINLE.setText("Normal");
                        TFLEP.setText("P75");
                    }
                    if (rs.getDouble(10) > Lon && Lon > rs.getDouble(9)) {
                        LINLE.setForeground(Color.black);
                        LINLE.setText("Normal");
                        TFLEP.setText("P75 - P85");
                    }
                    if (rs.getDouble(10) == Lon ) {
                        LINLE.setForeground(Color.black);
                        LINLE.setText("Normal");
                        TFLEP.setText("P85");
                    }
                    if (rs.getDouble(11) > Lon && Lon > rs.getDouble(10)) {
                        LINLE.setForeground(Color.black);
                        LINLE.setText("Normal");
                        TFLEP.setText("P85 - P95");
                    }
                    if (rs.getDouble(11) == Lon) {
                        LINLE.setForeground(Color.black);
                        LINLE.setText("Normal");
                        TFLEP.setText("P95");
                    }
                    if (rs.getDouble(12) > Lon && Lon > rs.getDouble(11)) {
                        LINLE.setForeground(Color.black);
                        LINLE.setText("Normal");
                        TFLEP.setText("P95 - P97");
                    }
                    if (rs.getDouble(12) == Lon) {
                        LINLE.setForeground(Color.red);
                        LINLE.setText("Alto");
                        TFLEP.setText("P97");
                    }
                    if (rs.getDouble(13) > Lon && Lon > rs.getDouble(12)) {
                        LINLE.setForeground(Color.black);
                        LINLE.setText("Normal");
                        TFLEP.setText("P97 - P99");
                    }
                    if (rs.getDouble(13) == Lon ) {
                        LINLE.setForeground(Color.black);
                        LINLE.setText("Normal");
                        TFLEP.setText("P99");
                    }
                    if (rs.getDouble(13) < Lon) {
                        LINLE.setForeground(Color.red);
                        LINLE.setText("Alto");
                        TFLEP.setText("> P99");
                    }
                    Double Peso = Double.valueOf(TFPeso.getText().trim()).doubleValue();
                     if ( Peso < rs.getDouble(14)) {
                        LINPE.setForeground(Color.red);
                        LINPE.setText("Desnutrición");
                        TFPPE.setText("< P1");
                    }
                    if (rs.getDouble(14) == Peso ) {
                        LINPE.setForeground(Color.red);
                        LINPE.setText("Desnutrición");
                        TFPPE.setText("P1");
                    }
                    if (rs.getDouble(15) > Peso  && Peso > rs.getDouble(14)) {
                        LINPE.setForeground(Color.red);
                        LINPE.setText("Desnutrición");
                        TFPPE.setText("P1 - P3");
                    }
                    if (rs.getDouble(15) == Peso ) {
                        LINPE.setForeground(Color.yellow);
                        LINPE.setText("Peligro Desnutrución");
                        TFPPE.setText("P3");
                    }
                    if (rs.getDouble(16) > Peso && Peso > rs.getDouble(15)) {
                        LINPE.setForeground(Color.yellow);
                        LINPE.setText("Peligro Desnutrición");
                        TFPPE.setText("P3 - P5");
                    }
                    if (rs.getDouble(16) == Peso ) {
                        LINPE.setForeground(Color.yellow);
                        LINPE.setText("Peligro Desnutrición");
                        TFPPE.setText("P5");
                    }
                    if (rs.getDouble(17) > Peso && Peso > rs.getDouble(16)) {
                        LINPE.setForeground(Color.yellow);
                        LINPE.setText("Peligro Desnutrición");
                        TFPPE.setText("P5 - P15");
                    }
                    if (rs.getDouble(17) == Peso ) {
                        LINPE.setForeground(Color.black);
                        LINPE.setText("Normal");
                        TFPPE.setText("P15");
                    }
                    if (rs.getDouble(18) > Peso && Peso > rs.getDouble(17)) {
                        LINPE.setForeground(Color.black);
                        LINPE.setText("Normal");
                        TFPPE.setText("P15 - P25");
                    }
                    if (rs.getDouble(18) == Peso ) {
                        LINPE.setForeground(Color.black);
                        LINPE.setText("Normal");
                        TFPPE.setText("P25");
                    }
                    if (rs.getDouble(19) > Peso && Peso > rs.getDouble(18)) {
                        LINPE.setForeground(Color.black);
                        LINPE.setText("Normal");
                        TFPPE.setText("P25 - P50");
                    }
                    if (rs.getDouble(19) == Peso ) {
                        LINPE.setForeground(Color.black);
                        LINPE.setText("Normal");
                        TFPPE.setText("P50");
                    }
                    if (rs.getDouble(20) > Peso && Peso > rs.getDouble(19)) {
                        LINPE.setForeground(Color.black);
                        LINPE.setText("Normal");
                        TFPPE.setText("P50 - P75");
                    }
                    if (rs.getDouble(20) == Peso ) {
                        LINPE.setForeground(Color.black);
                        LINPE.setText("Normal");
                        TFPPE.setText("P75");
                    }
                    if (rs.getDouble(21) > Peso && Peso > rs.getDouble(20)) {
                        LINPE.setForeground(Color.black);
                        LINPE.setText("Normal");
                        TFPPE.setText("P75 - P85");
                    }
                    if (rs.getDouble(21) == Peso ) {
                        LINPE.setForeground(Color.black);
                        LINPE.setText("Normal");
                        TFPPE.setText("P85");
                    }
                    if (rs.getDouble(22) > Peso && Peso > rs.getDouble(21)) {
                        LINPE.setForeground(Color.yellow);
                        LINPE.setText("Sobrepeso");
                        TFPPE.setText("P85 - P95");
                    }
                    if (rs.getDouble(22) == Peso ) {
                        LINPE.setForeground(Color.yellow);
                        LINPE.setText("Sobrepeso");
                        TFPPE.setText("P95");
                    }
                    if (rs.getDouble(23) > Peso && Peso > rs.getDouble(22)) {
                        LINPE.setForeground(Color.yellow);
                        LINPE.setText("Sobrepeso");
                        TFPPE.setText("P95 - P97");
                    }
                    if (rs.getDouble(23) == Peso ) {
                        LINPE.setForeground(Color.yellow);
                        LINPE.setText("Sobrepeso");
                        TFPPE.setText("P97");
                    }
                    if (rs.getDouble(24) > Peso && Peso > rs.getDouble(23)) {
                        LINPE.setForeground(Color.red);
                        LINPE.setText("Obesidad");
                        TFPPE.setText("P97 - P99");
                    }
                    if (rs.getDouble(24) == Peso ) {
                        LINPE.setForeground(Color.red);
                        LINPE.setText("Obesidad");
                        TFPPE.setText("P99");
                    }
                    if (rs.getDouble(24) < Peso) {
                        LINPE.setForeground(Color.red);
                        LINPE.setText("Obesidad");
                        TFPPE.setText("> P99");
                    }
                    Double IMC = Double.valueOf(TFIMC.getText().trim()).doubleValue();
                    if ( IMC < rs.getDouble(25)) {
                        LINIE.setForeground(Color.red);
                        LINIE.setText("Desnutrición");
                        TFIEP.setText("< P1");
                    }
                    if (rs.getDouble(25) == IMC ) {
                        LINIE.setForeground(Color.red);
                        LINIE.setText("Desnutrición");
                        TFIEP.setText("P1");
                    }
                    if (rs.getDouble(26) > IMC  && IMC > rs.getDouble(25)) {
                        LINIE.setForeground(Color.red);
                        LINIE.setText("Desnutrición");
                        TFIEP.setText("P1 - P3");
                    }
                    if (rs.getDouble(26) == IMC ) {
                        LINIE.setForeground(Color.yellow);
                        LINIE.setText("Peligro Desnutrición");
                        TFIEP.setText("P3");
                    }
                    if (rs.getDouble(27) > IMC && IMC > rs.getDouble(26)) {
                        LINIE.setForeground(Color.yellow);
                        LINIE.setText("Peligro Desnutrición");
                        TFIEP.setText("P3 - P5");
                    }
                    if (rs.getDouble(27) == IMC ) {
                        LINIE.setForeground(Color.yellow);
                        LINIE.setText("Peligro Desnutrición");
                        TFIEP.setText("P5");
                    }
                    if (rs.getDouble(28) > IMC && IMC > rs.getDouble(27)) {
                        LINIE.setForeground(Color.yellow);
                        LINIE.setText("Peligro Desnutrición");
                        TFIEP.setText("P5 - P15");
                    }
                    if (rs.getDouble(28) == IMC ) {
                        LINIE.setForeground(Color.black);
                        LINIE.setText("Normal");
                        TFIEP.setText("P15");
                    }
                    if (rs.getDouble(29) > IMC && IMC > rs.getDouble(28)) {
                        LINIE.setForeground(Color.black);
                        LINIE.setText("Normal");
                        TFIEP.setText("P15 - P25");
                    }
                    if (rs.getDouble(29) == IMC ) {
                        LINIE.setForeground(Color.black);
                        LINIE.setText("Normal");
                        TFIEP.setText("P25");
                    }
                    if (rs.getDouble(30) > IMC && IMC > rs.getDouble(29)) {
                        LINIE.setForeground(Color.black);
                        LINIE.setText("Normal");
                        TFIEP.setText("P25 - P50");
                    }
                    if (rs.getDouble(30) == IMC ) {
                        LINIE.setForeground(Color.black);
                        LINIE.setText("Normal");
                        TFIEP.setText("P50");
                    }
                    if (rs.getDouble(31) > IMC && IMC > rs.getDouble(30)) {
                        LINIE.setForeground(Color.black);
                        LINIE.setText("Normal");
                        TFIEP.setText("P50 - P75");
                    }
                    if (rs.getDouble(31) == IMC ) {
                        LINIE.setForeground(Color.black);
                        LINIE.setText("Normal");
                        TFIEP.setText("P75");
                    }
                    if (rs.getDouble(32) > IMC && IMC > rs.getDouble(31)) {
                        LINIE.setForeground(Color.black);
                        LINIE.setText("Normal");
                        TFIEP.setText("P75 - P85");
                    }
                    if (rs.getDouble(32) == IMC ) {
                        LINIE.setForeground(Color.black);
                        LINIE.setText("Normal");
                        TFIEP.setText("P85");
                    }
                    if (rs.getDouble(33) > IMC && IMC > rs.getDouble(32)) {
                        LINIE.setForeground(Color.yellow);
                        LINIE.setText("Sobrepeso");
                        TFIEP.setText("P85 - P95");
                    }
                    if (rs.getDouble(33) == IMC ) {
                        LINIE.setForeground(Color.yellow);
                        LINIE.setText("Sobrepeso");
                        TFIEP.setText("P95");
                    }
                    if (rs.getDouble(34) > IMC && IMC > rs.getDouble(33)) {
                        LINIE.setForeground(Color.yellow);
                        LINIE.setText("Sobrepeso");
                        TFIEP.setText("P95 - P97");
                    }
                    if (rs.getDouble(34) == IMC ) {
                        LINIE.setForeground(Color.yellow);
                        LINIE.setText("Sobrepeso");
                        TFIEP.setText("P97");
                    }
                    if (rs.getDouble(35) > IMC && IMC > rs.getDouble(34)) {
                        LINIE.setForeground(Color.red);
                        LINIE.setText("Obesidad");
                        TFIEP.setText("P97 - P99");
                    }
                    if (rs.getDouble(35) == IMC ) {
                        LINIE.setForeground(Color.red);
                        LINIE.setText("Obesidad");
                        TFIEP.setText("P99");
                    }
                    if (rs.getDouble(35) < IMC) {
                        LINIE.setForeground(Color.red);
                        LINIE.setText("Obesidad");
                        TFIEP.setText("> P99");
                    }
                    rs.close();
                    instruccion.close();
                    conexion.close();
                } else {
                    JOptionPane.showMessageDialog(null, "Tienes que rellenar los campos Talla y Peso",
                    "Otoño Salud", JOptionPane.ERROR_MESSAGE);
                    LIE.setEnabled(false);
                    LTE.setEnabled(false);
                    LPE.setEnabled(false);
                    LPBE.setEnabled(false);
                    LPTE.setEnabled(false);
                    RBTE.setEnabled(false);
                    RBPE.setEnabled(false);
                    RBPBE.setEnabled(false);
                    RBIE.setEnabled(false);
                    TFLongitud.requestFocus();
                    TFLongitud.selectAll();
                }
            }
        } catch (Exception e) {}
    }//GEN-LAST:event_RBWhoActionPerformed

    private void RBTEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBTEActionPerformed
        if (RBCarrascosa.isSelected()) {
            try {
                conexion = DriverManager.getConnection(baseDatos);
                instruccion = conexion.createStatement();
                ResultSet rs=null;
                if (RBVaron.isSelected())
                    rs = instruccion.executeQuery("Select * from AdolesCarrasV");
                else if (RBHembra.isSelected())
                    rs = instruccion.executeQuery("Select * from AdolesCarrasM");
                XYSeries seriep3 = new XYSeries("P3");
                XYSeries seriep10 = new XYSeries("P10");
                XYSeries seriep25 = new XYSeries("P25");
                XYSeries seriep50 = new XYSeries("P50");
                XYSeries seriep75 = new XYSeries("P75");
                XYSeries seriep90 = new XYSeries("P90");
                XYSeries seriep97 = new XYSeries("P97");
                XYSeries serieInt = new XYSeries("Perc");
                while (rs.next()) {
                    seriep3.add(rs.getDouble(2), rs.getDouble(3));
                    seriep10.add(rs.getDouble(2), rs.getDouble(4));
                    seriep25.add(rs.getDouble(2), rs.getDouble(5));
                    seriep50.add(rs.getDouble(2), rs.getDouble(6));
                    seriep75.add(rs.getDouble(2), rs.getDouble(7));
                    seriep90.add(rs.getDouble(2), rs.getDouble(8));
                    seriep97.add(rs.getDouble(2), rs.getDouble(9));
                }
                rs.close();
                instruccion.close();
                conexion.close();
                XYSeriesCollection juegoDatos= new XYSeriesCollection();
                juegoDatos.addSeries(seriep3);
                juegoDatos.addSeries(seriep10);
                juegoDatos.addSeries(seriep25);
                juegoDatos.addSeries(seriep50);
                juegoDatos.addSeries(seriep75);
                juegoDatos.addSeries(seriep90);
                juegoDatos.addSeries(seriep97);
                serieInt.add(Double.parseDouble(calcularMeses(TFFechNac.getText()).toString()), Double.parseDouble(TFLongitud.getText().trim()));
                juegoDatos.addSeries(serieInt);

                JFreeChart chart = ChartFactory.createXYLineChart ("Longitud / Edad",
                        "Edad","Longitud",juegoDatos,PlotOrientation.VERTICAL,
                        true,
                        true,
                        true                // Show legend
                        );

                XYPlot plot =  (XYPlot) chart.getPlot();
                XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
                //Puntos en las líneas o no
                renderer.setSeriesShapesVisible(0, false);
                renderer.setSeriesShapesVisible(1, false);
                renderer.setSeriesShapesVisible(2, false);
                renderer.setSeriesShapesVisible(3, false);
                renderer.setSeriesShapesVisible(4, false);
                renderer.setSeriesShapesVisible(5, false);
                renderer.setSeriesShapesVisible(6, false);
                renderer.setSeriesShapesVisible(7, true);

                try {
                    ChartUtilities.saveChartAsJPEG(new File("grafico.jpg"), chart, 300, 300);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                File nombreFich = new File("grafico.jpg");

                cargarImagen(DPImagen, nombreFich);


            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (RBCDC.isSelected()) {
            try {
                conexion = DriverManager.getConnection(baseDatos);
                instruccion = conexion.createStatement();
                ResultSet rs=null;
                if (RBVaron.isSelected())
                    rs = instruccion.executeQuery("Select * from AdolesCDCV");
                else if (RBHembra.isSelected())
                    rs = instruccion.executeQuery("Select * from AdolesCDCM");
                XYSeries seriep3 = new XYSeries("P3");
                XYSeries seriep5 = new XYSeries("P5");
                XYSeries seriep10 = new XYSeries("P10");
                XYSeries seriep25 = new XYSeries("P25");
                XYSeries seriep50 = new XYSeries("P50");
                XYSeries seriep75 = new XYSeries("P75");
                XYSeries seriep90 = new XYSeries("P90");
                XYSeries seriep95 = new XYSeries("P95");
                XYSeries seriep97 = new XYSeries("P97");
                XYSeries serieInt = new XYSeries("Perc");
                while (rs.next()) {
                    seriep3.add(rs.getDouble(2)/12, rs.getDouble(3));
                    seriep5.add(rs.getDouble(2)/12, rs.getDouble(4));
                    seriep10.add(rs.getDouble(2)/12, rs.getDouble(5));
                    seriep25.add(rs.getDouble(2)/12, rs.getDouble(6));
                    seriep50.add(rs.getDouble(2)/12, rs.getDouble(7));
                    seriep75.add(rs.getDouble(2)/12, rs.getDouble(8));
                    seriep90.add(rs.getDouble(2)/12, rs.getDouble(9));
                    seriep95.add(rs.getDouble(2)/12, rs.getDouble(10));
                    seriep97.add(rs.getDouble(2)/12, rs.getDouble(11));
                }
                rs.close();
                instruccion.close();
                conexion.close();
                XYSeriesCollection juegoDatos= new XYSeriesCollection();
                juegoDatos.addSeries(seriep3);
                juegoDatos.addSeries(seriep5);
                juegoDatos.addSeries(seriep10);
                juegoDatos.addSeries(seriep25);
                juegoDatos.addSeries(seriep50);
                juegoDatos.addSeries(seriep75);
                juegoDatos.addSeries(seriep90);
                juegoDatos.addSeries(seriep95);
                juegoDatos.addSeries(seriep97);
                serieInt.add(Double.parseDouble(calcularMeses(TFFechNac.getText()).toString()), Double.parseDouble(TFLongitud.getText().trim()));
                juegoDatos.addSeries(serieInt);

                JFreeChart chart = ChartFactory.createXYLineChart ("Longitud / Edad",
                        "Edad","Longitud",juegoDatos,PlotOrientation.VERTICAL,
                        true,
                        true,
                        true                // Show legend
                        );

                XYPlot plot =  (XYPlot) chart.getPlot();
                XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
                //Puntos en las líneas o no
                renderer.setSeriesShapesVisible(0, false);
                renderer.setSeriesShapesVisible(1, false);
                renderer.setSeriesShapesVisible(2, false);
                renderer.setSeriesShapesVisible(3, false);
                renderer.setSeriesShapesVisible(4, false);
                renderer.setSeriesShapesVisible(5, false);
                renderer.setSeriesShapesVisible(6, false);
                renderer.setSeriesShapesVisible(7, false);
                renderer.setSeriesShapesVisible(8, false);
                renderer.setSeriesShapesVisible(9, true);

                try {
                    ChartUtilities.saveChartAsJPEG(new File("grafico.jpg"), chart, 300, 300);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                File nombreFich = new File("grafico.jpg");

                cargarImagen(DPImagen, nombreFich);


            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (RBOrbegozo.isSelected()) {
            try {
                conexion = DriverManager.getConnection(baseDatos);
                instruccion = conexion.createStatement();
                ResultSet rs=null;
                if (RBVaron.isSelected())
                    rs = instruccion.executeQuery("Select * from AdolesOrbegozoV");
                else if (RBHembra.isSelected())
                    rs = instruccion.executeQuery("Select * from AdolesOrbegozoM");
                XYSeries seriep3 = new XYSeries("P3");
                XYSeries seriep50 = new XYSeries("P50");
                XYSeries seriep97 = new XYSeries("P97");
                XYSeries serieInt = new XYSeries("Perc");
                while (rs.next()) {
                    seriep3.add(rs.getDouble(2), rs.getDouble(3));
                    seriep50.add(rs.getDouble(2), rs.getDouble(4));
                    seriep97.add(rs.getDouble(2), rs.getDouble(5));
                }
                rs.close();
                instruccion.close();
                conexion.close();
                XYSeriesCollection juegoDatos= new XYSeriesCollection();
                juegoDatos.addSeries(seriep3);
                juegoDatos.addSeries(seriep50);
                juegoDatos.addSeries(seriep97);
                serieInt.add(Double.parseDouble(calcularMeses(TFFechNac.getText()).toString()), Double.parseDouble(TFLongitud.getText().trim()));
                juegoDatos.addSeries(serieInt);

                JFreeChart chart = ChartFactory.createXYLineChart ("Longitud / Edad",
                        "Edad","Longitud",juegoDatos,PlotOrientation.VERTICAL,
                        true,
                        true,
                        true                // Show legend
                        );

                XYPlot plot =  (XYPlot) chart.getPlot();
                XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
                //Puntos en las líneas o no
                renderer.setSeriesShapesVisible(0, false);
                renderer.setSeriesShapesVisible(1, false);
                renderer.setSeriesShapesVisible(2, false);
                renderer.setSeriesShapesVisible(3, true);
                
                try {
                    ChartUtilities.saveChartAsJPEG(new File("grafico.jpg"), chart, 300, 300);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                File nombreFich = new File("grafico.jpg");

                cargarImagen(DPImagen, nombreFich);


            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (RBWho.isSelected()) {
            try {
                conexion = DriverManager.getConnection(baseDatos);
                instruccion = conexion.createStatement();
                ResultSet rs=null;
                if (RBVaron.isSelected())
                    rs = instruccion.executeQuery("Select * from AdolesWhoV");
                else if (RBHembra.isSelected())
                    rs = instruccion.executeQuery("Select * from AdolesWhoM");
                XYSeries seriep1 = new XYSeries("P1");
                XYSeries seriep3 = new XYSeries("P3");
                XYSeries seriep5 = new XYSeries("P5");
                XYSeries seriep15 = new XYSeries("P15");
                XYSeries seriep25 = new XYSeries("P25");
                XYSeries seriep50 = new XYSeries("P50");
                XYSeries seriep75 = new XYSeries("P75");
                XYSeries seriep85 = new XYSeries("P85");
                XYSeries seriep95 = new XYSeries("P95");
                XYSeries seriep97 = new XYSeries("P97");
                XYSeries seriep99 = new XYSeries("P99");
                XYSeries serieInt = new XYSeries("Perc");
                while (rs.next()) {
                    seriep1.add(rs.getDouble(2)/12, rs.getDouble(3));
                    seriep3.add(rs.getDouble(2)/12, rs.getDouble(4));
                    seriep5.add(rs.getDouble(2)/12, rs.getDouble(5));
                    seriep15.add(rs.getDouble(2)/12, rs.getDouble(6));
                    seriep25.add(rs.getDouble(2)/12, rs.getDouble(7));
                    seriep50.add(rs.getDouble(2)/12, rs.getDouble(8));
                    seriep75.add(rs.getDouble(2)/12, rs.getDouble(9));
                    seriep85.add(rs.getDouble(2)/12, rs.getDouble(10));
                    seriep95.add(rs.getDouble(2)/12, rs.getDouble(11));
                    seriep97.add(rs.getDouble(2)/12, rs.getDouble(12));
                    seriep99.add(rs.getDouble(2)/12, rs.getDouble(13));
                }
                rs.close();
                instruccion.close();
                conexion.close();
                XYSeriesCollection juegoDatos= new XYSeriesCollection();
                juegoDatos.addSeries(seriep1);
                juegoDatos.addSeries(seriep3);
                juegoDatos.addSeries(seriep5);
                juegoDatos.addSeries(seriep15);
                juegoDatos.addSeries(seriep25);
                juegoDatos.addSeries(seriep50);
                juegoDatos.addSeries(seriep75);
                juegoDatos.addSeries(seriep85);
                juegoDatos.addSeries(seriep95);
                juegoDatos.addSeries(seriep97);
                juegoDatos.addSeries(seriep99);
                serieInt.add(Double.parseDouble(calcularMeses(TFFechNac.getText()).toString()), Double.parseDouble(TFLongitud.getText().trim()));
                juegoDatos.addSeries(serieInt);

                JFreeChart chart = ChartFactory.createXYLineChart ("Longitud / Edad",
                        "Edad","Longitud",juegoDatos,PlotOrientation.VERTICAL,
                        true,
                        true,
                        true                // Show legend
                        );

                XYPlot plot =  (XYPlot) chart.getPlot();
                XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
                //Puntos en las líneas o no
                renderer.setSeriesShapesVisible(0, false);
                renderer.setSeriesShapesVisible(1, false);
                renderer.setSeriesShapesVisible(2, false);
                renderer.setSeriesShapesVisible(3, false);
                renderer.setSeriesShapesVisible(4, false);
                renderer.setSeriesShapesVisible(5, false);
                renderer.setSeriesShapesVisible(6, false);
                renderer.setSeriesShapesVisible(7, false);
                renderer.setSeriesShapesVisible(8, false);
                renderer.setSeriesShapesVisible(9, false);
                renderer.setSeriesShapesVisible(10, false);
                renderer.setSeriesShapesVisible(11, true);

                try {
                    ChartUtilities.saveChartAsJPEG(new File("grafico.jpg"), chart, 300, 300);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                File nombreFich = new File("grafico.jpg");

                cargarImagen(DPImagen, nombreFich);


            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_RBTEActionPerformed

    private void RBPEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBPEActionPerformed
        if (RBCarrascosa.isSelected()) {
            try {
                conexion = DriverManager.getConnection(baseDatos);
                instruccion = conexion.createStatement();
                ResultSet rs=null;
                if (RBVaron.isSelected())
                    rs = instruccion.executeQuery("Select * from AdolesCarrasV");
                else if (RBHembra.isSelected())
                    rs = instruccion.executeQuery("Select * from AdolesCarrasM");
                XYSeries seriep3 = new XYSeries("P3");
                XYSeries seriep10 = new XYSeries("P10");
                XYSeries seriep25 = new XYSeries("P25");
                XYSeries seriep50 = new XYSeries("P50");
                XYSeries seriep75 = new XYSeries("P75");
                XYSeries seriep90 = new XYSeries("P90");
                XYSeries seriep97 = new XYSeries("P97");
                XYSeries serieInt = new XYSeries("Perc");
                while (rs.next()) {
                    seriep3.add(rs.getDouble(2), rs.getDouble(10));
                    seriep10.add(rs.getDouble(2), rs.getDouble(11));
                    seriep25.add(rs.getDouble(2), rs.getDouble(12));
                    seriep50.add(rs.getDouble(2), rs.getDouble(13));
                    seriep75.add(rs.getDouble(2), rs.getDouble(14));
                    seriep90.add(rs.getDouble(2), rs.getDouble(15));
                    seriep97.add(rs.getDouble(2), rs.getDouble(16));
                }
                rs.close();
                instruccion.close();
                conexion.close();
                XYSeriesCollection juegoDatos= new XYSeriesCollection();
                juegoDatos.addSeries(seriep3);
                juegoDatos.addSeries(seriep10);
                juegoDatos.addSeries(seriep25);
                juegoDatos.addSeries(seriep50);
                juegoDatos.addSeries(seriep75);
                juegoDatos.addSeries(seriep90);
                juegoDatos.addSeries(seriep97);
                serieInt.add(Double.parseDouble(calcularMeses(TFFechNac.getText()).toString()), Double.parseDouble(TFPeso.getText().trim()));
                juegoDatos.addSeries(serieInt);

                JFreeChart chart = ChartFactory.createXYLineChart ("Peso / Edad",
                        "Edad","Peso",juegoDatos,PlotOrientation.VERTICAL,
                        true,
                        true,
                        true                // Show legend
                        );

                XYPlot plot =  (XYPlot) chart.getPlot();
                XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
                //Puntos en las líneas o no
                renderer.setSeriesShapesVisible(0, false);
                renderer.setSeriesShapesVisible(1, false);
                renderer.setSeriesShapesVisible(2, false);
                renderer.setSeriesShapesVisible(3, false);
                renderer.setSeriesShapesVisible(4, false);
                renderer.setSeriesShapesVisible(5, false);
                renderer.setSeriesShapesVisible(6, false);
                renderer.setSeriesShapesVisible(7, true);

                try {
                    ChartUtilities.saveChartAsJPEG(new File("grafico.jpg"), chart, 300, 300);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                File nombreFich = new File("grafico.jpg");

                cargarImagen(DPImagen, nombreFich);


            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (RBCDC.isSelected()) {
            try {
                conexion = DriverManager.getConnection(baseDatos);
                instruccion = conexion.createStatement();
                ResultSet rs=null;
                if (RBVaron.isSelected())
                    rs = instruccion.executeQuery("Select * from AdolesCDCV");
                else if (RBHembra.isSelected())
                    rs = instruccion.executeQuery("Select * from AdolesCDCM");
                XYSeries seriep3 = new XYSeries("P3");
                XYSeries seriep5 = new XYSeries("P5");
                XYSeries seriep10 = new XYSeries("P10");
                XYSeries seriep25 = new XYSeries("P25");
                XYSeries seriep50 = new XYSeries("P50");
                XYSeries seriep75 = new XYSeries("P75");
                XYSeries seriep90 = new XYSeries("P90");
                XYSeries seriep95 = new XYSeries("P95");
                XYSeries seriep97 = new XYSeries("P97");
                XYSeries serieInt = new XYSeries("Perc");
                while (rs.next()) {
                    seriep3.add(rs.getDouble(2)/12, rs.getDouble(12));
                    seriep5.add(rs.getDouble(2)/12, rs.getDouble(13));
                    seriep10.add(rs.getDouble(2)/12, rs.getDouble(14));
                    seriep25.add(rs.getDouble(2)/12, rs.getDouble(15));
                    seriep50.add(rs.getDouble(2)/12, rs.getDouble(16));
                    seriep75.add(rs.getDouble(2)/12, rs.getDouble(17));
                    seriep90.add(rs.getDouble(2)/12, rs.getDouble(18));
                    seriep95.add(rs.getDouble(2)/12, rs.getDouble(19));
                    seriep97.add(rs.getDouble(2)/12, rs.getDouble(20));
                }
                rs.close();
                instruccion.close();
                conexion.close();
                XYSeriesCollection juegoDatos= new XYSeriesCollection();
                juegoDatos.addSeries(seriep3);
                juegoDatos.addSeries(seriep5);
                juegoDatos.addSeries(seriep10);
                juegoDatos.addSeries(seriep25);
                juegoDatos.addSeries(seriep50);
                juegoDatos.addSeries(seriep75);
                juegoDatos.addSeries(seriep90);
                juegoDatos.addSeries(seriep95);
                juegoDatos.addSeries(seriep97);
                serieInt.add(Double.parseDouble(calcularMeses(TFFechNac.getText()).toString()), Double.parseDouble(TFPeso.getText().trim()));
                juegoDatos.addSeries(serieInt);

                JFreeChart chart = ChartFactory.createXYLineChart ("Peso / Edad",
                        "Edad","Peso",juegoDatos,PlotOrientation.VERTICAL,
                        true,
                        true,
                        true                // Show legend
                        );

                XYPlot plot =  (XYPlot) chart.getPlot();
                XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
                //Puntos en las líneas o no
                renderer.setSeriesShapesVisible(0, false);
                renderer.setSeriesShapesVisible(1, false);
                renderer.setSeriesShapesVisible(2, false);
                renderer.setSeriesShapesVisible(3, false);
                renderer.setSeriesShapesVisible(4, false);
                renderer.setSeriesShapesVisible(5, false);
                renderer.setSeriesShapesVisible(6, false);
                renderer.setSeriesShapesVisible(7, false);
                renderer.setSeriesShapesVisible(8, false);
                renderer.setSeriesShapesVisible(9, true);

                try {
                    ChartUtilities.saveChartAsJPEG(new File("grafico.jpg"), chart, 300, 300);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                File nombreFich = new File("grafico.jpg");

                cargarImagen(DPImagen, nombreFich);


            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (RBOrbegozo.isSelected()) {
            try {
                conexion = DriverManager.getConnection(baseDatos);
                instruccion = conexion.createStatement();
                ResultSet rs=null;
                if (RBVaron.isSelected())
                    rs = instruccion.executeQuery("Select * from AdolesOrbegozoV");
                else if (RBHembra.isSelected())
                    rs = instruccion.executeQuery("Select * from AdolesOrbegozoM");
                XYSeries seriep3 = new XYSeries("P3");
                XYSeries seriep50 = new XYSeries("P50");
                XYSeries seriep97 = new XYSeries("P97");
                XYSeries serieInt = new XYSeries("Perc");
                while (rs.next()) {
                    seriep3.add(rs.getDouble(2), rs.getDouble(6));
                    seriep50.add(rs.getDouble(2), rs.getDouble(7));
                    seriep97.add(rs.getDouble(2), rs.getDouble(8));
                }
                rs.close();
                instruccion.close();
                conexion.close();
                XYSeriesCollection juegoDatos= new XYSeriesCollection();
                juegoDatos.addSeries(seriep3);
                juegoDatos.addSeries(seriep50);
                juegoDatos.addSeries(seriep97);
                serieInt.add(Double.parseDouble(calcularMeses(TFFechNac.getText()).toString()), Double.parseDouble(TFPeso.getText().trim()));
                juegoDatos.addSeries(serieInt);

                JFreeChart chart = ChartFactory.createXYLineChart ("Peso / Edad",
                        "Edad","Peso",juegoDatos,PlotOrientation.VERTICAL,
                        true,
                        true,
                        true                // Show legend
                        );

                XYPlot plot =  (XYPlot) chart.getPlot();
                XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
                //Puntos en las líneas o no
                renderer.setSeriesShapesVisible(0, false);
                renderer.setSeriesShapesVisible(1, false);
                renderer.setSeriesShapesVisible(2, false);
                renderer.setSeriesShapesVisible(3, true);
                
                try {
                    ChartUtilities.saveChartAsJPEG(new File("grafico.jpg"), chart, 300, 300);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                File nombreFich = new File("grafico.jpg");

                cargarImagen(DPImagen, nombreFich);


            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (RBWho.isSelected()) {
            try {
                conexion = DriverManager.getConnection(baseDatos);
                instruccion = conexion.createStatement();
                ResultSet rs=null;
                if (RBVaron.isSelected())
                    rs = instruccion.executeQuery("Select * from AdolesWhoV");
                else if (RBHembra.isSelected())
                    rs = instruccion.executeQuery("Select * from AdolesWhoM");
                XYSeries seriep1 = new XYSeries("P1");
                XYSeries seriep3 = new XYSeries("P3");
                XYSeries seriep5 = new XYSeries("P5");
                XYSeries seriep15 = new XYSeries("P15");
                XYSeries seriep25 = new XYSeries("P25");
                XYSeries seriep50 = new XYSeries("P50");
                XYSeries seriep75 = new XYSeries("P75");
                XYSeries seriep85 = new XYSeries("P85");
                XYSeries seriep95 = new XYSeries("P95");
                XYSeries seriep97 = new XYSeries("P97");
                XYSeries seriep99 = new XYSeries("P99");
                XYSeries serieInt = new XYSeries("Perc");
                while (rs.next()) {
                    if (!(rs.getDouble(14) == 0.0)) {
                        seriep1.add(rs.getDouble(2)/12, rs.getDouble(14));
                        seriep3.add(rs.getDouble(2)/12, rs.getDouble(15));
                        seriep5.add(rs.getDouble(2)/12, rs.getDouble(16));
                        seriep15.add(rs.getDouble(2)/12, rs.getDouble(17));
                        seriep25.add(rs.getDouble(2)/12, rs.getDouble(18));
                        seriep50.add(rs.getDouble(2)/12, rs.getDouble(19));
                        seriep75.add(rs.getDouble(2)/12, rs.getDouble(20));
                        seriep85.add(rs.getDouble(2)/12, rs.getDouble(21));
                        seriep95.add(rs.getDouble(2)/12, rs.getDouble(22));
                        seriep97.add(rs.getDouble(2)/12, rs.getDouble(23));
                        seriep99.add(rs.getDouble(2)/12, rs.getDouble(24));
                    }
                }
                rs.close();
                instruccion.close();
                conexion.close();
                XYSeriesCollection juegoDatos= new XYSeriesCollection();
                juegoDatos.addSeries(seriep1);
                juegoDatos.addSeries(seriep3);
                juegoDatos.addSeries(seriep5);
                juegoDatos.addSeries(seriep15);
                juegoDatos.addSeries(seriep25);
                juegoDatos.addSeries(seriep50);
                juegoDatos.addSeries(seriep75);
                juegoDatos.addSeries(seriep85);
                juegoDatos.addSeries(seriep95);
                juegoDatos.addSeries(seriep97);
                juegoDatos.addSeries(seriep99);
                serieInt.add(Double.parseDouble(calcularMeses(TFFechNac.getText()).toString()), Double.parseDouble(TFPeso.getText().trim()));
                juegoDatos.addSeries(serieInt);

                JFreeChart chart = ChartFactory.createXYLineChart ("Peso / Edad",
                        "Edad","Peso",juegoDatos,PlotOrientation.VERTICAL,
                        true,
                        true,
                        true                // Show legend
                        );

                XYPlot plot =  (XYPlot) chart.getPlot();
                XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
                //Puntos en las líneas o no
                renderer.setSeriesShapesVisible(0, false);
                renderer.setSeriesShapesVisible(1, false);
                renderer.setSeriesShapesVisible(2, false);
                renderer.setSeriesShapesVisible(3, false);
                renderer.setSeriesShapesVisible(4, false);
                renderer.setSeriesShapesVisible(5, false);
                renderer.setSeriesShapesVisible(6, false);
                renderer.setSeriesShapesVisible(7, false);
                renderer.setSeriesShapesVisible(8, false);
                renderer.setSeriesShapesVisible(9, false);
                renderer.setSeriesShapesVisible(10, false);
                renderer.setSeriesShapesVisible(11, true);

                try {
                    ChartUtilities.saveChartAsJPEG(new File("grafico.jpg"), chart, 300, 300);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                File nombreFich = new File("grafico.jpg");

                cargarImagen(DPImagen, nombreFich);


            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_RBPEActionPerformed

    private void RBIEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBIEActionPerformed
        if (RBCarrascosa.isSelected()) {
            try {
                conexion = DriverManager.getConnection(baseDatos);
                instruccion = conexion.createStatement();
                ResultSet rs=null;
                if (RBVaron.isSelected())
                    rs = instruccion.executeQuery("Select * from AdolesCarrasV");
                else if (RBHembra.isSelected())
                    rs = instruccion.executeQuery("Select * from AdolesCarrasM");
                XYSeries seriep3 = new XYSeries("P3");
                XYSeries seriep10 = new XYSeries("P10");
                XYSeries seriep25 = new XYSeries("P25");
                XYSeries seriep50 = new XYSeries("P50");
                XYSeries seriep75 = new XYSeries("P75");
                XYSeries seriep90 = new XYSeries("P90");
                XYSeries seriep97 = new XYSeries("P97");
                XYSeries serieInt = new XYSeries("Perc");
                while (rs.next()) {
                    seriep3.add(rs.getDouble(2), rs.getDouble(17));
                    seriep10.add(rs.getDouble(2), rs.getDouble(18));
                    seriep25.add(rs.getDouble(2), rs.getDouble(19));
                    seriep50.add(rs.getDouble(2), rs.getDouble(20));
                    seriep75.add(rs.getDouble(2), rs.getDouble(21));
                    seriep90.add(rs.getDouble(2), rs.getDouble(22));
                    seriep97.add(rs.getDouble(2), rs.getDouble(23));
                }
                rs.close();
                instruccion.close();
                conexion.close();
                XYSeriesCollection juegoDatos= new XYSeriesCollection();
                juegoDatos.addSeries(seriep3);
                juegoDatos.addSeries(seriep10);
                juegoDatos.addSeries(seriep25);
                juegoDatos.addSeries(seriep50);
                juegoDatos.addSeries(seriep75);
                juegoDatos.addSeries(seriep90);
                juegoDatos.addSeries(seriep97);
                serieInt.add(Double.parseDouble(calcularMeses(TFFechNac.getText()).toString()), Double.parseDouble(TFIMC.getText().trim()));
                juegoDatos.addSeries(serieInt);

                JFreeChart chart = ChartFactory.createXYLineChart ("I.M.C. / Edad",
                        "Edad","I.M.C.",juegoDatos,PlotOrientation.VERTICAL,
                        true,
                        true,
                        true                // Show legend
                        );

                XYPlot plot =  (XYPlot) chart.getPlot();
                XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
                //Puntos en las líneas o no
                renderer.setSeriesShapesVisible(0, false);
                renderer.setSeriesShapesVisible(1, false);
                renderer.setSeriesShapesVisible(2, false);
                renderer.setSeriesShapesVisible(3, false);
                renderer.setSeriesShapesVisible(4, false);
                renderer.setSeriesShapesVisible(5, false);
                renderer.setSeriesShapesVisible(6, false);
                renderer.setSeriesShapesVisible(7, true);

                try {
                    ChartUtilities.saveChartAsJPEG(new File("grafico.jpg"), chart, 300, 300);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                File nombreFich = new File("grafico.jpg");

                cargarImagen(DPImagen, nombreFich);


            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (RBCDC.isSelected()) {
            try {
                conexion = DriverManager.getConnection(baseDatos);
                instruccion = conexion.createStatement();
                ResultSet rs=null;
                if (RBVaron.isSelected())
                    rs = instruccion.executeQuery("Select * from AdolesCDCV");
                else if (RBHembra.isSelected())
                    rs = instruccion.executeQuery("Select * from AdolesCDCM");
                XYSeries seriep3 = new XYSeries("P3");
                XYSeries seriep5 = new XYSeries("P5");
                XYSeries seriep10 = new XYSeries("P10");
                XYSeries seriep25 = new XYSeries("P25");
                XYSeries seriep50 = new XYSeries("P50");
                XYSeries seriep75 = new XYSeries("P75");
                XYSeries seriep85 = new XYSeries("P85");
                XYSeries seriep90 = new XYSeries("P90");
                XYSeries seriep95 = new XYSeries("P95");
                XYSeries seriep97 = new XYSeries("P97");
                XYSeries serieInt = new XYSeries("Perc");
                while (rs.next()) {
                    seriep3.add(rs.getDouble(2)/12, rs.getDouble(21));
                    seriep5.add(rs.getDouble(2)/12, rs.getDouble(22));
                    seriep10.add(rs.getDouble(2)/12, rs.getDouble(23));
                    seriep25.add(rs.getDouble(2)/12, rs.getDouble(24));
                    seriep50.add(rs.getDouble(2)/12, rs.getDouble(25));
                    seriep75.add(rs.getDouble(2)/12, rs.getDouble(26));
                    seriep85.add(rs.getDouble(2)/12, rs.getDouble(27));
                    seriep90.add(rs.getDouble(2)/12, rs.getDouble(28));
                    seriep95.add(rs.getDouble(2)/12, rs.getDouble(29));
                    seriep97.add(rs.getDouble(2)/12, rs.getDouble(30));
                }
                rs.close();
                instruccion.close();
                conexion.close();
                XYSeriesCollection juegoDatos= new XYSeriesCollection();
                juegoDatos.addSeries(seriep3);
                juegoDatos.addSeries(seriep5);
                juegoDatos.addSeries(seriep10);
                juegoDatos.addSeries(seriep25);
                juegoDatos.addSeries(seriep50);
                juegoDatos.addSeries(seriep75);
                juegoDatos.addSeries(seriep85);
                juegoDatos.addSeries(seriep90);
                juegoDatos.addSeries(seriep95);
                juegoDatos.addSeries(seriep97);
                serieInt.add(Double.parseDouble(calcularMeses(TFFechNac.getText()).toString()), Double.parseDouble(TFIMC.getText().trim()));
                juegoDatos.addSeries(serieInt);

                JFreeChart chart = ChartFactory.createXYLineChart ("I.M.C. / Edad",
                        "Edad","I.M.C.",juegoDatos,PlotOrientation.VERTICAL,
                        true,
                        true,
                        true                // Show legend
                        );

                XYPlot plot =  (XYPlot) chart.getPlot();
                XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
                //Puntos en las líneas o no
                renderer.setSeriesShapesVisible(0, false);
                renderer.setSeriesShapesVisible(1, false);
                renderer.setSeriesShapesVisible(2, false);
                renderer.setSeriesShapesVisible(3, false);
                renderer.setSeriesShapesVisible(4, false);
                renderer.setSeriesShapesVisible(5, false);
                renderer.setSeriesShapesVisible(6, false);
                renderer.setSeriesShapesVisible(7, false);
                renderer.setSeriesShapesVisible(8, false);
                renderer.setSeriesShapesVisible(9, false);
                renderer.setSeriesShapesVisible(10, true);

                try {
                    ChartUtilities.saveChartAsJPEG(new File("grafico.jpg"), chart, 300, 300);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                File nombreFich = new File("grafico.jpg");

                cargarImagen(DPImagen, nombreFich);


            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (RBOrbegozo.isSelected()) {
            try {
                conexion = DriverManager.getConnection(baseDatos);
                instruccion = conexion.createStatement();
                ResultSet rs=null;
                if (RBVaron.isSelected())
                    rs = instruccion.executeQuery("Select * from AdolesOrbegozoV");
                else if (RBHembra.isSelected())
                    rs = instruccion.executeQuery("Select * from AdolesOrbegozoM");
                XYSeries seriep3 = new XYSeries("P3");
                XYSeries seriep50 = new XYSeries("P50");
                XYSeries seriep85 = new XYSeries("P85");
                XYSeries seriep90 = new XYSeries("P95");
                XYSeries seriep97 = new XYSeries("P97");
                XYSeries serieInt = new XYSeries("Perc");
                while (rs.next()) {
                    seriep3.add(rs.getDouble(2), rs.getDouble(17));
                    seriep50.add(rs.getDouble(2), rs.getDouble(20));
                    seriep85.add(rs.getDouble(2), rs.getDouble(21));
                    seriep90.add(rs.getDouble(2), rs.getDouble(22));
                    seriep97.add(rs.getDouble(2), rs.getDouble(23));
                }
                rs.close();
                instruccion.close();
                conexion.close();
                XYSeriesCollection juegoDatos= new XYSeriesCollection();
                juegoDatos.addSeries(seriep3);
                juegoDatos.addSeries(seriep50);
                juegoDatos.addSeries(seriep85);
                juegoDatos.addSeries(seriep90);
                juegoDatos.addSeries(seriep97);
                serieInt.add(Double.parseDouble(calcularMeses(TFFechNac.getText()).toString()), Double.parseDouble(TFIMC.getText().trim()));
                juegoDatos.addSeries(serieInt);

                JFreeChart chart = ChartFactory.createXYLineChart ("I.M.C. / Edad",
                        "Edad","I.M.C.",juegoDatos,PlotOrientation.VERTICAL,
                        true,
                        true,
                        true                // Show legend
                        );

                XYPlot plot =  (XYPlot) chart.getPlot();
                XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
                //Puntos en las líneas o no
                renderer.setSeriesShapesVisible(0, false);
                renderer.setSeriesShapesVisible(1, false);
                renderer.setSeriesShapesVisible(2, false);
                renderer.setSeriesShapesVisible(3, false);
                renderer.setSeriesShapesVisible(4, false);
                renderer.setSeriesShapesVisible(5, true);

                try {
                    ChartUtilities.saveChartAsJPEG(new File("grafico.jpg"), chart, 300, 300);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                File nombreFich = new File("grafico.jpg");

                cargarImagen(DPImagen, nombreFich);


            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (RBWho.isSelected()) {
            try {
                conexion = DriverManager.getConnection(baseDatos);
                instruccion = conexion.createStatement();
                ResultSet rs=null;
                if (RBVaron.isSelected())
                    rs = instruccion.executeQuery("Select * from AdolesWhoV");
                else if (RBHembra.isSelected())
                    rs = instruccion.executeQuery("Select * from AdolesWhoM");
                XYSeries seriep1 = new XYSeries("P1");
                XYSeries seriep3 = new XYSeries("P3");
                XYSeries seriep5 = new XYSeries("P5");
                XYSeries seriep15 = new XYSeries("P15");
                XYSeries seriep25 = new XYSeries("P25");
                XYSeries seriep50 = new XYSeries("P50");
                XYSeries seriep75 = new XYSeries("P75");
                XYSeries seriep85 = new XYSeries("P85");
                XYSeries seriep95 = new XYSeries("P95");
                XYSeries seriep97 = new XYSeries("P97");
                XYSeries seriep99 = new XYSeries("P99");
                XYSeries serieInt = new XYSeries("Perc");
                while (rs.next()) {
                    seriep1.add(rs.getDouble(2)/12, rs.getDouble(25));
                    seriep3.add(rs.getDouble(2)/12, rs.getDouble(26));
                    seriep5.add(rs.getDouble(2)/12, rs.getDouble(27));
                    seriep15.add(rs.getDouble(2)/12, rs.getDouble(28));
                    seriep25.add(rs.getDouble(2)/12, rs.getDouble(29));
                    seriep50.add(rs.getDouble(2)/12, rs.getDouble(30));
                    seriep75.add(rs.getDouble(2)/12, rs.getDouble(31));
                    seriep85.add(rs.getDouble(2)/12, rs.getDouble(32));
                    seriep95.add(rs.getDouble(2)/12, rs.getDouble(33));
                    seriep97.add(rs.getDouble(2)/12, rs.getDouble(34));
                    seriep99.add(rs.getDouble(2)/12, rs.getDouble(35));
                }
                rs.close();
                instruccion.close();
                conexion.close();
                XYSeriesCollection juegoDatos= new XYSeriesCollection();
                juegoDatos.addSeries(seriep1);
                juegoDatos.addSeries(seriep3);
                juegoDatos.addSeries(seriep5);
                juegoDatos.addSeries(seriep15);
                juegoDatos.addSeries(seriep25);
                juegoDatos.addSeries(seriep50);
                juegoDatos.addSeries(seriep75);
                juegoDatos.addSeries(seriep85);
                juegoDatos.addSeries(seriep95);
                juegoDatos.addSeries(seriep97);
                juegoDatos.addSeries(seriep99);
                serieInt.add(Double.parseDouble(calcularMeses(TFFechNac.getText()).toString()), Double.parseDouble(TFIMC.getText().trim()));
                juegoDatos.addSeries(serieInt);

                JFreeChart chart = ChartFactory.createXYLineChart ("I.M.C. / Edad",
                        "Edad","I.M.C.",juegoDatos,PlotOrientation.VERTICAL,
                        true,
                        true,
                        true                // Show legend
                        );

                XYPlot plot =  (XYPlot) chart.getPlot();
                XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
                //Puntos en las líneas o no
                renderer.setSeriesShapesVisible(0, false);
                renderer.setSeriesShapesVisible(1, false);
                renderer.setSeriesShapesVisible(2, false);
                renderer.setSeriesShapesVisible(3, false);
                renderer.setSeriesShapesVisible(4, false);
                renderer.setSeriesShapesVisible(5, false);
                renderer.setSeriesShapesVisible(6, false);
                renderer.setSeriesShapesVisible(7, false);
                renderer.setSeriesShapesVisible(8, false);
                renderer.setSeriesShapesVisible(9, false);
                renderer.setSeriesShapesVisible(10, false);
                renderer.setSeriesShapesVisible(11, true);

                try {
                    ChartUtilities.saveChartAsJPEG(new File("grafico.jpg"), chart, 300, 300);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                File nombreFich = new File("grafico.jpg");

                cargarImagen(DPImagen, nombreFich);


            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_RBIEActionPerformed

    private void RBPBEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBPBEActionPerformed
       if (RBOrbegozo.isSelected()) {
            try {
                conexion = DriverManager.getConnection(baseDatos);
                instruccion = conexion.createStatement();
                ResultSet rs=null;
                if (RBVaron.isSelected())
                    rs = instruccion.executeQuery("Select * from AdolesOrbegozoV");
                else if (RBHembra.isSelected())
                    rs = instruccion.executeQuery("Select * from AdolesOrbegozoM");
                XYSeries seriep3 = new XYSeries("P3");
                XYSeries seriep10 = new XYSeries("P10");
                XYSeries seriep25 = new XYSeries("P25");
                XYSeries seriep50 = new XYSeries("P50");
                XYSeries seriep75 = new XYSeries("P75");
                XYSeries seriep90 = new XYSeries("P90");
                XYSeries seriep97 = new XYSeries("P97");
                XYSeries serieInt = new XYSeries("Perc");
                while (rs.next()) {
                    seriep3.add(rs.getDouble(2), rs.getDouble(14));
                    seriep10.add(rs.getDouble(2), rs.getDouble(15));
                    seriep25.add(rs.getDouble(2), rs.getDouble(16));
                    seriep50.add(rs.getDouble(2), rs.getDouble(17));
                    seriep75.add(rs.getDouble(2), rs.getDouble(18));
                    seriep90.add(rs.getDouble(2), rs.getDouble(19));
                    seriep97.add(rs.getDouble(2), rs.getDouble(20));
                }
                rs.close();
                instruccion.close();
                conexion.close();
                XYSeriesCollection juegoDatos= new XYSeriesCollection();
                juegoDatos.addSeries(seriep3);
                juegoDatos.addSeries(seriep10);
                juegoDatos.addSeries(seriep25);
                juegoDatos.addSeries(seriep50);
                juegoDatos.addSeries(seriep75);
                juegoDatos.addSeries(seriep90);
                juegoDatos.addSeries(seriep97);
                serieInt.add(Double.parseDouble(calcularMeses(TFFechNac.getText()).toString()), Double.parseDouble(TFPeso.getText().trim()));
                juegoDatos.addSeries(serieInt);

                JFreeChart chart = ChartFactory.createXYLineChart ("Peso / Edad",
                        "Edad","Peso",juegoDatos,PlotOrientation.VERTICAL,
                        true,
                        true,
                        true                // Show legend
                        );

                XYPlot plot =  (XYPlot) chart.getPlot();
                XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
                //Puntos en las líneas o no
                renderer.setSeriesShapesVisible(0, false);
                renderer.setSeriesShapesVisible(1, false);
                renderer.setSeriesShapesVisible(2, false);
                renderer.setSeriesShapesVisible(3, false);
                renderer.setSeriesShapesVisible(4, false);
                renderer.setSeriesShapesVisible(5, false);
                renderer.setSeriesShapesVisible(6, false);
                renderer.setSeriesShapesVisible(7, true);

                try {
                    ChartUtilities.saveChartAsJPEG(new File("grafico.jpg"), chart, 300, 300);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                File nombreFich = new File("grafico.jpg");

                cargarImagen(DPImagen, nombreFich);


            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_RBPBEActionPerformed

    private void BGraCorpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BGraCorpActionPerformed
        grasaCorp = null;
        if (grasaCorp == null) {
            grasaCorp = new GraCorp(new JFrame() ,true);
            grasaCorp.setVisible(true);
        }
    }//GEN-LAST:event_BGraCorpActionPerformed

    public  void cargarImagen(javax.swing.JDesktopPane jDeskp,File fileImagen)
    {
        try{
            BufferedImage image = ImageIO.read(fileImagen);
              jDeskp.setBorder(new PintaImagen(image)); }
        catch (Exception e){   System.out.println("No cargo imagen, sorry");   }
    }

    public static Double calcularMeses (String fecha) throws ParseException {
        Double edad = new Double(1);
        String datetext = fecha;
        Calendar birth = new GregorianCalendar();
        Calendar today = new GregorianCalendar();
        int meses = 0;
        Date birthDate = new SimpleDateFormat("dd/MM/yyyy").parse(datetext);
        Date currentDate = new Date(); //current date
        birth.setTime(birthDate);
        today.setTime(currentDate);
        meses = (today.get(Calendar.YEAR) - birth.get(Calendar.YEAR) ) *12;
        meses = meses + (today.get(Calendar.MONTH) - birth.get(Calendar.MONTH));
        edad =  meses / 12.0;
        return edad;
    }

    public static Double calcularMesesCDC (String fecha) throws ParseException {
        Double edad = new Double(1);
        String datetext = fecha;
        Calendar birth = new GregorianCalendar();
        Calendar today = new GregorianCalendar();
        int meses = 0;
        Date birthDate = new SimpleDateFormat("dd/MM/yyyy").parse(datetext);
        Date currentDate = new Date(); //current date
        birth.setTime(birthDate);
        today.setTime(currentDate);
        meses = (today.get(Calendar.YEAR) - birth.get(Calendar.YEAR) ) *12;
        meses = meses + (today.get(Calendar.MONTH) - birth.get(Calendar.MONTH));
        edad =  (double)meses;
        return edad;
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
    private javax.swing.JButton BCerrar;
    private javax.swing.ButtonGroup BGGrafica;
    private javax.swing.ButtonGroup BGPaper;
    private javax.swing.JButton BGraCorp;
    private javax.swing.JButton BGuardar2;
    private javax.swing.JDesktopPane DPImagen;
    private javax.swing.JLabel LIE;
    private javax.swing.JLabel LINIE;
    private javax.swing.JLabel LINLE;
    private javax.swing.JLabel LINPBE;
    private javax.swing.JLabel LINPE;
    private javax.swing.JLabel LINPTE;
    private javax.swing.JLabel LPBE;
    private javax.swing.JLabel LPE;
    private javax.swing.JLabel LPTE;
    private javax.swing.JLabel LTE;
    private javax.swing.JRadioButton RBCDC;
    private javax.swing.JRadioButton RBCarrascosa;
    private javax.swing.JRadioButton RBHembra;
    private javax.swing.JRadioButton RBIE;
    private javax.swing.JRadioButton RBOrbegozo;
    private javax.swing.JRadioButton RBPBE;
    private javax.swing.JRadioButton RBPE;
    private javax.swing.JRadioButton RBTE;
    private javax.swing.JRadioButton RBVaron;
    private javax.swing.JRadioButton RBWho;
    private javax.swing.JTextField TFCod;
    private javax.swing.JTextField TFEdad;
    private javax.swing.JTextField TFFechNac;
    private javax.swing.JTextField TFIEP;
    private javax.swing.JTextField TFIEP50;
    private javax.swing.JTextField TFIMC;
    private javax.swing.JTextField TFLEP;
    private javax.swing.JTextField TFLEP50;
    private javax.swing.JTextField TFLongitud;
    private javax.swing.JTextField TFNombre;
    private javax.swing.JTextField TFPBEP;
    private javax.swing.JTextField TFPBEP50;
    private javax.swing.JTextField TFPEP50;
    private javax.swing.JTextField TFPPE;
    private javax.swing.JTextField TFPTEP;
    private javax.swing.JTextField TFPTEP50;
    private javax.swing.JTextField TFPerBra;
    private javax.swing.JTextField TFPeso;
    private javax.swing.JTextField TFPliTri;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables

    private JDialog grasaCorp;
}
