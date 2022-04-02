/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ikaraz
 */
public class CustomTableRenderer extends DefaultTableCellRenderer{
    private static final String NA_CEKANJU = "Na Cekanju";
    private static final String ODOBREN = "Odobren";
    private static final String NEODOBREN = "Neodobren";
    private static final String EVERGREEN = "Evergreen";

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
        Component c = super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
        
        try{
            if(o.equals(NA_CEKANJU)) c.setForeground(new Color(255, 153, 0));
            else if(o.equals(ODOBREN)) c.setForeground(new Color(0, 128, 0));
            else if(o.equals(NEODOBREN)) c.setForeground(Color.red);
            else if(o.equals(EVERGREEN)) c.setForeground(new Color(0, 0, 128));
            else c.setForeground(null);
            
            if(jtable.getColumnCount() == 4){
                if(jtable.getValueAt(i, 3).equals("*")){
                    c.setFont(new Font("Tahoma", Font.BOLD, 17));
                }
            }
        }catch (Exception e){
            System.out.println("CustomTableRenderer: " + e);
        }
        
        
        return c;
    }
    
    
}
