/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jplanner.service;

import java.util.List;
import jplanner.domain.Proyek;

/**
 *
 * @author martinusadyh
 */
public interface JPlannerService {
    
    void save(Object obj);
    
    List findAll(String className);
}
