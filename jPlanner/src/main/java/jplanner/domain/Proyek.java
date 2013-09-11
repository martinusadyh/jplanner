/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jplanner.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author martinusadyh
 */
@Entity
@Table(name="proyek")
public class Proyek implements Serializable {
    
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "id")
    private String id;
    
    @Column(name="nama_proyek")
    private String namaProyek;
    
    @Column(name="batas_hari")
    private Integer batasHari;
    
    @Column(name="jml_org")
    private Integer jmlOrg;
    
    @Column(name="batas_biaya")
    private BigDecimal batasBiaya;
    
    @Column(name="budget")
    private BigDecimal budget;
    
    @Column(name="min_profit")
    private BigDecimal minProfit;
    
    @OneToMany(mappedBy="proyek")
    private List<Aktivitas> aktivitases = new ArrayList<Aktivitas>();

    public List<Aktivitas> getAktivitases() {
        return aktivitases;
    }

    public void setAktivitases(List<Aktivitas> aktivitases) {
        this.aktivitases = aktivitases;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaProyek() {
        return namaProyek;
    }

    public void setNamaProyek(String namaProyek) {
        this.namaProyek = namaProyek;
    }

    public Integer getBatasHari() {
        return batasHari;
    }

    public void setBatasHari(Integer batasHari) {
        this.batasHari = batasHari;
    }

    public Integer getJmlOrg() {
        return jmlOrg;
    }

    public void setJmlOrg(Integer jmlOrg) {
        this.jmlOrg = jmlOrg;
    }

    public BigDecimal getBatasBiaya() {
        return batasBiaya;
    }

    public void setBatasBiaya(BigDecimal batasBiaya) {
        this.batasBiaya = batasBiaya;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public BigDecimal getMinProfit() {
        return minProfit;
    }

    public void setMinProfit(BigDecimal minProfit) {
        this.minProfit = minProfit;
    }
}
