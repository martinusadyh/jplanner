/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jplanner.modul;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import jplanner.domain.Proyek;

/**
 *
 * @author martinusadyh
 */
public class ProyekTableModel extends AbstractTableModel {
    
    private List<Proyek> proyeks = new ArrayList<Proyek>();
    private String[] header = new String[] { "Nama Proyek", "Batas Hari", 
        "Jml. Orang", "Batas Biaya", "Budget", "Min. Profit" };

    public ProyekTableModel(List<Proyek> proyeks) {
        this.proyeks = proyeks;
    }
    
    @Override
    public int getRowCount() {
        return proyeks.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Proyek p = proyeks.get(rowIndex);
        switch (columnIndex) {
            case 0 : return p.getNamaProyek();
            case 1 : return p.getBatasHari();
            case 2 : return p.getJmlOrg();
            case 3 : return p.getBatasBiaya();
            case 4 : return p.getBudget();
            case 5 : return p.getMinProfit();
            default: return new Object();
        }
    }
}
