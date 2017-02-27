/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savio_estadisticas.clases.Control;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JToggleButton;
import javax.swing.SwingWorker;
import savio_estadisticas.SAVIO_ESTADISTICAS;
import savio_estadisticas.clases.Course;
import savio_estadisticas.clases.Courses;
import savio_estadisticas.clases.Node;

/**
 *
 * @author amorelos
 */
public class Progress extends SwingWorker<Integer,String> {
    private JProgressBar jpbar;
    private JLabel jlb;
    private JComboBox jComboBox1;
    private JToggleButton jbtn;
    private List<Node> nodos_finales;

    

    public Progress(JProgressBar jpbar, JLabel jlb,JComboBox jComboBox1,JToggleButton jbtn) {
        this.jpbar = jpbar;
        this.jlb = jlb;
        this.jComboBox1 = jComboBox1;
        this.jbtn = jbtn;
    }

    

    
    
    
    @Override
    protected Integer doInBackground() throws Exception {
        
            
        ChargeAll();
        
        
        
        return 0;
    }

    /**
     * @return the jpbar
     */
    public JProgressBar getJpbar() {
        return jpbar;
    }

    /**
     * @param jpbar the jpbar to set
     */
    public void setJpbar(JProgressBar jpbar) {
        this.jpbar = jpbar;
    }
    
    public void ChargeAll(){
    try {
           Courses cursos;
            getJpbar().setIndeterminate(true);
            getJlb().setText("Cargando Cursos");
            GetAllCourses getall = new GetAllCourses();
            getall.start();
            getall.setName("Get Courses");
            getall.join();
            getJpbar().setIndeterminate(false);
            System.out.println("Alimentando Variable Principal");
            cursos = getall.getCursos();
            System.out.println("Obteniendo Cursos");
            
            getJpbar().setMaximum(cursos.getCourse().size());
            
            List<Course> courses = cursos.getCourse();
            
            CategoriesControl categoriescontrol = new CategoriesControl(courses, getJpbar(),getJlb());
            categoriescontrol.start();
            categoriescontrol.setName("categoriescontrol");
            categoriescontrol.join();
            
            nodos_finales = categoriescontrol.getNodesCategories();
            
            //Creando Lista de Nombres de las categorias
            
            ArrayList<String> categorias = new ArrayList<String>();
            
            for(Node n: nodos_finales){
                categorias.add(n.getNameCategory());
            }
            
            DefaultComboBoxModel model = (DefaultComboBoxModel) getjComboBox1().getModel();
            model.removeAllElements();
            
            for(String name : categorias){
                model.addElement(name);
            }
            
            getjComboBox1().setModel(model);
            
            getjComboBox1().setVisible(true);
            getJbtn().setVisible(true);
            
            
            
        } catch (InterruptedException ex) {
            Logger.getLogger(SAVIO_ESTADISTICAS.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}

    /**
     * @return the jlb
     */
    public JLabel getJlb() {
        return jlb;
    }

    /**
     * @param jlb the jlb to set
     */
    public void setJlb(JLabel jlb) {
        this.jlb = jlb;
    }

    /**
     * @return the jComboBox1
     */
    public JComboBox getjComboBox1() {
        return jComboBox1;
    }

    /**
     * @param jComboBox1 the jComboBox1 to set
     */
    public void setjComboBox1(JComboBox jComboBox1) {
        this.jComboBox1 = jComboBox1;
    }

    /**
     * @return the jbtn
     */
    public JToggleButton getJbtn() {
        return jbtn;
    }

    /**
     * @param jbtn the jbtn to set
     */
    public void setJbtn(JToggleButton jbtn) {
        this.jbtn = jbtn;
    }
    
    public List<Node> getNodos_finales() {
        return nodos_finales;
    }

    public void setNodos_finales(List<Node> nodos_finales) {
        this.nodos_finales = nodos_finales;
    }
    
}
