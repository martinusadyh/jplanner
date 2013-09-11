/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jplanner.modul;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import jplanner.domain.Resource;

/**
 *
 * @author martinusadyh
 */
public class ResourceTableModel extends AbstractTableModel {
    
    private List<Resource> resources = new ArrayList<Resource>();
    private String[] header = new String[] { "Nama Grup", "Tipe", 
        "Nama", "Biaya" };

    public ResourceTableModel(List<Resource> rsc) {
        this.resources = rsc;
    }
    
    @Override
    public int getRowCount() {
        return resources.size();
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
        Resource p = resources.get(rowIndex);
        switch (columnIndex) {
            case 0 : return p.getGrupResource().getNama();
            case 1 : return p.getType();
            case 2 : return p.getNama();
            case 3 : return p.getBiaya();
            default: return new Object();
        }
    }
}
