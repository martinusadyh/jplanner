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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author martinusadyh
 */
@Entity
@Table(name="grup_resource")
public class GrupResource implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdDate = new Date();
    
    private String nama;
    
    @OneToMany(mappedBy="grupResource", fetch= FetchType.EAGER)
    private List<Resource> resources = new ArrayList<Resource>();

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    @Override
    public String toString() {
        return this.getNama();
    }
}
