/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jplanner.service;

import java.util.List;
import jplanner.domain.Aktivitas;
import jplanner.domain.Proyek;
import jplanner.domain.Resource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author martinusadyh
 */
@Service("jplannerService")
@Transactional(readOnly=true)
public class JPlannerServiceImpl implements JPlannerService {
    
    @Autowired private SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly=false)
    public void save(Object obj) {
        sessionFactory.getCurrentSession().saveOrUpdate(obj);
    }
    
    @Override
    @Transactional(readOnly=false, rollbackFor= Exception.class)
    public void saveAktivitas(Aktivitas obj) {
        sessionFactory.getCurrentSession().saveOrUpdate(obj);
        
        // update resource dulu
        List<Resource> resources = obj.getResources();
        for (Resource r : resources) {
            r.setIsUsed(Boolean.TRUE);
            r.setAktivitas(obj);
            
            sessionFactory.getCurrentSession().saveOrUpdate(r);
        }
    }

    @Override
    public List findAll(String className) {
        StringBuilder sb = new StringBuilder();
        sb.append("from ").append(className).append(" obj ");
        sb.append("order by obj.createdDate desc");
        return sessionFactory.getCurrentSession()
                .createQuery("from " + className)
                .list();
    }

    @Override
    public List<Resource> findAvailableResource(String name) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Resource r where r.isUsed = false")
                .list();
    }

    @Override
    public List<Aktivitas> findAllAktivitasByProject(Proyek proyek) {
        return sessionFactory.getCurrentSession()
                .createQuery("from Aktivitas a where a.proyek.id = :prmProyekSID")
                .setParameter("prmProyekSID", proyek.getId())
                .list();
    }

    @Override
    public Integer findAktivitasByProject(Proyek p) {
        Integer durasi = (Integer) sessionFactory.getCurrentSession()
                .createQuery("select obj.durasi from Aktivitas obj where obj.proyek.id = :prmIDProyek order by obj.durasi desc")
                .setParameter("prmIDProyek", p.getId())
                .setMaxResults(1)
                .uniqueResult();
        
        if (durasi == null) {
            durasi = 0;
        }
        
        return durasi;
    }

    @Override
    public List<Aktivitas> findAllAktivitas() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Aktivitas a")
                .list();
    }
}
