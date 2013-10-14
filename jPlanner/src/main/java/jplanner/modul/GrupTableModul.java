/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jplanner.modul;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import jplanner.domain.GrupResource;
import jplanner.domain.Resource;

/**
 *
 * @author martinusadyh
 */
public class GrupTableModul extends AbstractTableModel {
    
    private List<GrupResource> grups = new ArrayList<GrupResource>();
    private String[] header = new String[] { "Nama", "Jml. Barang", "Jml. Orang", 
        "Tot. Resource", "Tot. Available" };

    public GrupTableModul(List<GrupResource> grupResources) {
        this.grups = grupResources;
    }
    
    @Override
    public int getRowCount() {
        return grups.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }
    
    private Integer getAvailableResource(GrupResource gr) {
        int counter = 0;
        for (Resource r : gr.getResources()) {
            if (!r.getIsUsed()) {
                counter++;
            }
        }
        return counter;
    }
    
    private Integer getBarang(GrupResource p) {
        int jmlBrg = 0;
        for (Resource r : p.getResources()) {
            if (r.getType().equalsIgnoreCase("BARANG")) {
                jmlBrg++;
            }
        }
        return jmlBrg;
    }
    
    private Integer getOrang(GrupResource p) {
        int jmlOrg = 0;
        for (Resource r : p.getResources()) {
            if (r.getType().equalsIgnoreCase("ORANG")) {
                jmlOrg++;
            }
        }
        return jmlOrg;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        GrupResource p = grups.get(rowIndex);
        switch (columnIndex) {
            case 0 : return p.getNama();
            case 1 : return getBarang(p);
            case 2 : return getOrang(p);
            case 3 : return p.getResources().size();
            case 4 : return getAvailableResource(p);
            default: return new Object();
        }
    }
}
