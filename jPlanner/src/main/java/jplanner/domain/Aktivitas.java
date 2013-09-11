/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jplanner.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

/**
 *
 * @author martinusadyh
 */
@Entity
@Table(name="aktivitas")
public class Aktivitas implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "id")
    private String id;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdDate = new Date();
    
    private String nama;
    private Integer durasi = Integer.valueOf("0");
    
    @OneToMany(mappedBy="aktivitas")
    private List<Resource> resources = new ArrayList<Resource>();
    
    @ManyToOne
    private Proyek proyek;
    
    private String predesesor;

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
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
}