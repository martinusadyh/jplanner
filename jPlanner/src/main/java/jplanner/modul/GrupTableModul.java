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
    private String[] header = new String[] { "Nama", "Jml. Resource", "Tot. Available" };

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

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        GrupResource p = grups.get(rowIndex);
        switch (columnIndex) {
            case 0 : return p.getNama();
            case 1 : return p.getResources().size();
            case 2 : return getAvailableResource(p);
            default: return new Object();
        }
    }
}
