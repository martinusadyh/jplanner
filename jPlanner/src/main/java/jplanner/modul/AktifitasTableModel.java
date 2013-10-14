/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jplanner.modul;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import jplanner.domain.Aktivitas;

/**
 *
 * @author martinusadyh
 */
public class AktifitasTableModel extends AbstractTableModel {
    
    private List<Aktivitas> aktivitases;
    private String[] header = new String[] { "Proyek", "Aktivitas", "Resource", "Tipe", "Predesesor" };

    public AktifitasTableModel(List<Aktivitas> aktivitases) {
        this.aktivitases = aktivitases;
    }

    public List<Aktivitas> getAktivitases() {
        return aktivitases;
    }

    @Override
    public int getRowCount() {
        return aktivitases.size();
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
        Aktivitas a = aktivitases.get(rowIndex);
        switch (columnIndex) {
            case 0 : return a.getProyek().getNamaProyek();
            case 1 : return a.getNama();
            case 2 : return a.getResource().getNama();
            case 3 : return a.getResource().getType();
            case 4 : return a.getPredesesor();
            default: return new Object();
        }
    }
}
