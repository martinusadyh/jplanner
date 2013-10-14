/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jplanner.jplanner;

import java.util.Date;
import jplanner.domain.Aktivitas;
import jplanner.domain.Proyek;
import jplanner.service.JPlannerService;
import junit.framework.Test;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author adi
 */
public class AktivitasSaveNumberTest extends TestCase {
    private AbstractApplicationContext appContext;
    private JPlannerService jPlannerService;
    
    public AktivitasSaveNumberTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        appContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        jPlannerService = (JPlannerService) appContext.getBean("jplannerService");
    }
    
    @Override
    protected void tearDown() throws Exception {
        appContext.registerShutdownHook();
    }
    
    // TODO add test methods here. The name must begin with 'test'. For example:
    public void testSaveNumber() {
        Proyek p = (Proyek) jPlannerService.findAll(Proyek.class.getName()).get(0);
        
//        Aktivitas parent = null;
        Aktivitas parent = (Aktivitas) jPlannerService.findAll(Aktivitas.class.getName()).get(3);
        
        Aktivitas a = new Aktivitas();
        a.setDurasi(1);
        a.setCreatedDate(new Date());
        a.setNama("hihihi");
        a.setParent(parent);
        a.setProyek(p);
        jPlannerService.saveAktivitas(a);
        
        a = new Aktivitas();
        a.setDurasi(1);
        a.setCreatedDate(new Date());
        a.setNama("hohoho");
        a.setParent(parent);
        a.setProyek(p);
        jPlannerService.saveAktivitas(a);
    }
}
