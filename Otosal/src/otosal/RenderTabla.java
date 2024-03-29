package otosal;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Antonio
 */
import java.awt.Component;
import java.awt.Color;
import javax.swing.table.TableCellRenderer;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.Icon;

/**
 */
public class RenderTabla extends JLabel implements TableCellRenderer
 {
     /**
      * Constructor por defecto.
      */
     public RenderTabla()
    {

     }

     /**  Returns the component used for drawing the cell.  This method is
      *  used to configure the renderer appropriately before drawing.
      *
      * @param	table		the <code>JTable</code> that is asking the
      * 				renderer to draw; can be <code>null</code>
      * @param	value		the value of the cell to be rendered.  It is
      * 				up to the specific renderer to interpret
      * 				and draw the value.  For example, if
      * 				<code>value</code>
      * 				is the string "true", it could be rendered as a
      * 				string or it could be rendered as a check
      * 				box that is checked.  <code>null</code> is a
      * 				valid value
      * @param	isSelected	true if the cell is to be rendered with the
      * 				selection highlighted; otherwise false
      * @param	hasFocus	if true, render cell appropriately.  For
      * 				example, put a special border on the cell, if
      * 				the cell can be edited, render in the color used
      * 				to indicate editing
      * @param	row	        the row index of the cell being drawn.  When
      * 				drawing the header, the value of
      * 				<code>row</code> is -1
      * @param	column	        the column index of the cell being drawn
      *
      */
     public Component getTableCellRendererComponent(JTable table, Object value,
        boolean isSelected, boolean hasFocus, int row, int column)
     {
         JLabel etiqueta = new JLabel();
         if (column == 0) 
             etiqueta.setOpaque(true);
         if (column == 1) {
                 etiqueta.setHorizontalAlignment(CENTER);
             if (value instanceof String)
             {
                 etiqueta.setOpaque(false);
                 etiqueta.setText((String)value);
             }
         }
         return etiqueta;
     }
}

