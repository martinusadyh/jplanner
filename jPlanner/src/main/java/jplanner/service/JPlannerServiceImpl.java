/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jplanner.service;

import java.util.List;
import jplanner.domain.Proyek;
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
    public List findAll(String className) {
        StringBuilder sb = new StringBuilder();
        sb.append("from ").append(className).append(" obj ");
        sb.append("order by obj.createdDate desc");
        return sessionFactory.getCurrentSession()
                .createQuery("from " + className)
                .list();
    }
}
