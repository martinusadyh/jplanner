package jplanner;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import jplanner.service.JPlannerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author martinusadyh
 */
public class JPlanner {
    
    private static ApplicationContext appContext;
    private static JPlannerService jPlannerService;

    public static JPlannerService getjPlannerService() {
        return jPlannerService;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        appContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        jPlannerService = (JPlannerService) appContext.getBean("jplannerService");
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JPlanner.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        new MainForm().setVisible(true);
    }
}
