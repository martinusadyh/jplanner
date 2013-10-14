/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jplanner.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author martinusadyh
 */
@Entity
@Table(name="resource")
public class Resource implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdDate = new Date();
    
    private String nama;
    private String type;
    private BigDecimal biaya = BigDecimal.ZERO;
    
    @ManyToOne
    private GrupResource grupResource;
    
    @ManyToOne
    private Aktivitas aktivitas;
    
    @Column(name="is_used")
    private Boolean isUsed = Boolean.FALSE;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getBiaya() {
        return biaya;
    }

    public void setBiaya(BigDecimal biaya) {
        this.biaya = biaya;
    }

    public GrupResource getGrupResource() {
        return grupResource;
    }

    public void setGrupResource(GrupResource grupResource) {
        this.grupResource = grupResource;
    }

    public Aktivitas getAktivitas() {
        return aktivitas;
    }

    public void setAktivitas(Aktivitas aktivitas) {
        this.aktivitas = aktivitas;
    }

    public Boolean getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(Boolean isUsed) {
        this.isUsed = isUsed;
    }

    @Override
    public String toString() {
        return "Nama Resource=[" + nama + "], Type=[" + type + "], Biaya=[" + biaya + ']';
    }
}
