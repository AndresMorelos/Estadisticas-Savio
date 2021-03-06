/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savio_estadisticas.clases.Control;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JToggleButton;
import javax.swing.SwingWorker;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import savio_estadisticas.clases.Control.CourseContent.Content;
import savio_estadisticas.clases.Control.CourseContent.Content_;
import savio_estadisticas.clases.Control.CourseContent.CourseContent;
import savio_estadisticas.clases.Control.CourseContent.GetCourseContent;
import savio_estadisticas.clases.Control.CourseContent.Module;
import savio_estadisticas.clases.Control.Estadisticas.Table_DataBase;
import savio_estadisticas.clases.Course;
import savio_estadisticas.clases.Node;


/**
 *
 * @author amorelos
 */
public class ProgressSheet extends SwingWorker<Integer, String> {

    private File Archivo_Ubicacion;
    private JButton openfile;
    private String DocumentType;
    private String FileName;
    private Node x;
    private JProgressBar jpbar;
    private JLabel jlb;
    private final int N;
    private final int L;
    private int k = 1;
    private boolean finished = false;
    private getCatergories GetCategories = new getCatergories();
    private Table_DataBase database = new Table_DataBase();

    private int progress = 0;

    public ProgressSheet(JButton openfile, String DocumentType, String FileName, Node x, JProgressBar jpbar, JLabel jlb) {
        this.openfile = openfile;
        this.DocumentType = DocumentType;
        this.FileName = FileName;
        this.x = x;
        this.jpbar = jpbar;
        this.jlb = jlb;
        this.N = x.getCategoryCourses().size();
        this.L = N / 20;
    }

    @Override
    protected Integer doInBackground() throws Exception {
        getJpbar().setVisible(true);
        getJlb().setVisible(true);
        getJpbar().setMaximum(getX().getCategoryCourses().size());
        getJlb().setText("Analizando Cursos" + progress + "/" + getX().getCategoryCourses().size());
        ThreadGroup t1 = new ThreadGroup("Grupo Cursos");
        for (int i = 0; i <= N; i = i + L) {
            List<Course> part;
            if (k == 20 && (getX().getCategoryCourses().size() % 2) != 0) {
                part = this.x.getCategoryCourses().subList(i, Math.min(N, i + L) + 1);    
            } else {
                part = this.x.getCategoryCourses().subList(i, Math.min(N, i + L)); 
            }
            k++;
            Thread myThread;
            myThread = new Thread(t1, new Runnable() {
                @Override
                public void run() {
                    for (Course h : part) {
                        GetCourseContent getcontent = new GetCourseContent(Integer.toString(h.getId()));
                        CourseContent coursecontent = getcontent.getConent();
                        for (Content contenido : coursecontent.getContent()) {
                            if (contenido.getVisible() == 1) {
                                for (Module mod : contenido.getModules()) {
                                    synchronized (x) {
                                        switch (mod.getModplural()) {
                                            //Actividades
                                            case "Etiquetas":
                                                h.getCountContent().upgradeEtiquetas();
                                                break;
                                            case "Tareas":
                                                h.getCountContent().upgradeTareas();
                                                break;
                                            case "Foros":
                                                h.getCountContent().upgradeForos();
                                                break;
                                            case "Chats":
                                                h.getCountContent().upgradeChats();
                                                break;
                                            case "Consultas":
                                                h.getCountContent().upgradeConsultas();
                                                break;
                                            case "Lecciones":
                                                h.getCountContent().upgradeLecciones();
                                                break;
                                            case "Wikis":
                                                h.getCountContent().upgradeWikis();
                                                break;
                                            case "Bases de datos":
                                                h.getCountContent().upgradeBases_de_datos();
                                                break;
                                            case "Paquetes SCORM":
                                                h.getCountContent().upgradePaquetes_SCORM();
                                                break;
                                            case "Laboratorios virtuales de programación":
                                                h.getCountContent().upgradeLaboratorios_virtuales_de_programacion();
                                                break;

                                            case "Talleres":
                                                h.getCountContent().upgradeTalleres();
                                                break;
                                            case "Cuestionarios":
                                                h.getCountContent().upgradeCuestionarios();
                                                break;
                                            //Recursos
                                            case "Archivos":
                                                for (Content_ fileContent : mod.getContents()) {
                                                    h.getCountContent().upgradeArchivos();
                                                }
                                                break;
                                            case "URLs":
                                                h.getCountContent().upgradeURLs();
                                                break;
                                            case "Libros":
                                                h.getCountContent().upgradeLibros();
                                                break;
                                            case "Libros (Plantilla)":
                                                h.getCountContent().upgradeLibros();
                                                break;
                                            case "Páginas":
                                                h.getCountContent().upgradePaginas();
                                                break;
                                            case "Portfolios":
                                                h.getCountContent().upgradePortafolio();
                                                break;
                                            case "Glosarios":
                                                h.getCountContent().upgradeGlosario();
                                                break;
                                            case "Paquete de contenidos IMS":
                                                h.getCountContent().upgradePaquete_IMS();
                                                break;
                                        }
                                    }
                                }

                            }
                        }
                        // Busqueda de profesor
                        GetParticipants participants = new GetParticipants(Integer.toString(h.getId()));
                        h.setProfessor(participants.getParticipants());
                        h.setCategoryName(GetCategories.GetNameCategories(Integer.toString(h.getCategoryid())));
                        progress++;
                        getJpbar().setValue(progress);
                        getJlb().setText("Analizando Cursos" + progress + "/" + getX().getCategoryCourses().size());
                    }
                }
            });
            myThread.start();
            myThread.setName("Busqueda de curos parte " + k);

        }

        while (finished == false) {
            if (t1.activeCount() <= 0) {
                System.out.println("Es verdadero");
                finished = true;
            }
        }

        database.CreateSheet(getDocumentType(), getX(), getFileName());
        if (database.getArchivo_Ubicacion() != null) {
            setArchivo_Ubicacion(database.getArchivo_Ubicacion());
            getOpenfile().setVisible(true);
        }
        //getJpbar().setVisible(false);
        return 0;
    }

    

    /**
     * @return the Archivo_Ubicacion
     */
    public File getArchivo_Ubicacion() {
        return Archivo_Ubicacion;
    }

    /**
     * @param Archivo_Ubicacion the Archivo_Ubicacion to set
     */
    public void setArchivo_Ubicacion(File Archivo_Ubicacion) {
        this.Archivo_Ubicacion = Archivo_Ubicacion;
    }

    /**
     * @return the openfile
     */
    public JButton getOpenfile() {
        return openfile;
    }

    /**
     * @param openfile the openfile to set
     */
    public void setOpenfile(JButton openfile) {
        this.openfile = openfile;
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
     * @return the DocumentType
     */
    public String getDocumentType() {
        return DocumentType;
    }

    /**
     * @param DocumentType the DocumentType to set
     */
    public void setDocumentType(String DocumentType) {
        this.DocumentType = DocumentType;
    }

    /**
     * @return the FileName
     */
    public String getFileName() {
        return FileName;
    }

    /**
     * @param FileName the FileName to set
     */
    public void setFileName(String FileName) {
        this.FileName = FileName;
    }

    /**
     * @return the x
     */
    public Node getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(Node x) {
        this.x = x;
    }

    public void analiceCourses() {

    }
}
