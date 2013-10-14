/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jplanner.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author martinusadyh
 */
@Entity
@Table(name="aktivitas")
public class Aktivitas implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdDate = new Date();
    
    private String nama;
    private Integer durasi = Integer.valueOf("0");
    
    @ManyToOne
    private Resource resource;
    
    @ManyToOne
    private Proyek proyek;
    
    private String predesesor;
    
    @ManyToOne
    @JoinColumn(name="id_parent", referencedColumnName="id")
    private Aktivitas parent;

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

    public Integer getDurasi() {
        return durasi;
    }

    public void setDurasi(Integer durasi) {
        this.durasi = durasi;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public Proyek getProyek() {
        return proyek;
    }

    public void setProyek(Proyek proyek) {
        this.proyek = proyek;
    }

    public String getPredesesor() {
        return predesesor;
    }

    public void setPredesesor(String predesesor) {
        this.predesesor = predesesor;
    }

    public Aktivitas getParent() {
        return parent;
    }

    public void setParent(Aktivitas parent) {
        this.parent = parent;
    }
    
    @Override
    public String toString() {
        return "Nama Aktivitas=[" + nama + ']';
    }
}