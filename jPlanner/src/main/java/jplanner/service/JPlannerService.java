/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jplanner.service;

import java.util.List;
import jplanner.domain.Aktivitas;
import jplanner.domain.Proyek;
import jplanner.domain.Resource;

/**
 *
 * @author martinusadyh
 */
public interface JPlannerService {
    
    void save(Object obj);
    void saveAktivitas(Aktivitas obj);
    
    List findAll(String className);

    List<Resource> findAvailableResource(String name);

    List<Aktivitas> findAllAktivitasByProject(Proyek proyek);

    public Integer findAktivitasByProject(Proyek p);
}
