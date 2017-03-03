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
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import savio_estadisticas.clases.Control.CourseContent.Content;
import savio_estadisticas.clases.Control.CourseContent.Content_;
import savio_estadisticas.clases.Control.CourseContent.CourseContent;
import savio_estadisticas.clases.Control.CourseContent.GetCourseContent;
import savio_estadisticas.clases.Control.CourseContent.Module;
import savio_estadisticas.clases.Course;
import savio_estadisticas.clases.Node;

/**
 *
 * @author amorelos
 */
public class ProgressSheet extends SwingWorker<Integer, String> {

    private File Archivo_Ubicacion;
    private JToggleButton openfile;
    private String DocumentType;
    private String FileName;
    private Node x;
    private JProgressBar jpbar;
    private JLabel jlb;
    private final int N;
    private final int L;
    private int k = 1;

    private int progress = 0;

    public ProgressSheet(JToggleButton openfile, String DocumentType, String FileName, Node x, JProgressBar jpbar, JLabel jlb) {
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
        getJpbar().setMaximum(getX().getCategoryCourses().size());
        getJlb().setText("Analizando Cursos" + progress + "/" + getX().getCategoryCourses().size());
        ThreadGroup t1 = new ThreadGroup("Grupo Cursos");

        for (int i = 0; i <= N; i = i + L) {
            List<Course> part;

            if (k == 20) {
                part = this.x.getCategoryCourses().subList(i, Math.min(N, i + L) + 1);
                System.out.println(Math.min(N, i + L) + 1);
            } else {
                part = this.x.getCategoryCourses().subList(i, Math.min(N, i + L));
                System.out.println(Math.min(N, i + L));
            }
            k++;
            for (Course h : part) {
                Thread myThread;
                myThread = new Thread(t1, new Runnable() {
                    @Override
                    public void run() {
                        try {
                            GetCourseContent getcontent = new GetCourseContent(Integer.toString(h.getId()));
                            getcontent.start();
                            getcontent.join();
                            CourseContent coursecontent = getcontent.getCoursecontent();

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
                                            }
                                        }
                                    }
                                    progress++;
                                    getJlb().setText("Analizando Cursos" + progress + "/" + getX().getCategoryCourses().size());
                                }
                            }

                        } catch (InterruptedException ex) {

                        }
                    }

                });
                myThread.start();
                myThread.join();
            }
        }

        CreateSheet(getDocumentType(), getX(), getFileName());
        getJpbar().setVisible(false);
        return 0;
    }

    public void CreateSheet(String type, Node category, String FileName) {
        switch (type) {
            case "Cursos Innovadores":
                System.out.println("Tipo: " + type);
                break;
            case "Cursos En Blanco":
                List<Course> cursosvacios = new ArrayList<Course>();

                for (Course h : category.getCategoryCourses()) {
                    if (h.getCountContent().getTareas() == 0 && h.getCountContent().getConsultas() == 0 && h.getCountContent().getEtiquetas() == 0
                            && h.getCountContent().getForos() == 0 && h.getCountContent().getChats() == 0 && h.getCountContent().getWikis() == 0
                            && h.getCountContent().getBases_de_datos() == 0 && h.getCountContent().getPaquetes_SCORM() == 0 && h.getCountContent().getArchivos() == 0
                            && h.getCountContent().getURLs() == 0 && h.getCountContent().getPaginas() == 0 && h.getCountContent().getCuestionarios() == 0 && h.getCountContent().getTalleres() == 0
                            && h.getCountContent().getLaboratorios_virtuales_de_programacion() == 0) {
                        cursosvacios.add(h);
                    }

                }

                try {
                    File hojadecalculo = new File(FileName);

                    if (hojadecalculo.exists()) {
                        hojadecalculo.delete();
                    }
                    hojadecalculo.createNewFile();

                    Workbook libro = new HSSFWorkbook();

                    FileOutputStream archivo = new FileOutputStream(hojadecalculo);

                    Sheet hoja = libro.createSheet("Tabla");

                    for (int i = 0; i < cursosvacios.size(); i++) {
                        Row fila = hoja.createRow(i);
                        for (int j = 0; j < 17; j++) {
                            Cell celda = fila.createCell(j);
                            if (i == 0) {
                                switch (j) {
                                    case 0:
                                        celda.setCellValue("Nombre Curso");
                                        break;
                                    case 1:
                                        celda.setCellValue("Tareas");
                                        break;
                                    case 2:
                                        celda.setCellValue("Consultas");
                                        break;

                                    case 3:
                                        celda.setCellValue("Etiquetas");
                                        break;

                                    case 4:
                                        celda.setCellValue("Foros");
                                        break;
                                    case 5:
                                        celda.setCellValue("Chats");
                                        break;
                                    case 6:
                                        celda.setCellValue("Lecciones");
                                        break;
                                    case 7:
                                        celda.setCellValue("Wikis");
                                        break;
                                    case 8:
                                        celda.setCellValue("Bases de Datos");
                                        break;
                                    case 9:
                                        celda.setCellValue("Paquetes SCORM");
                                        break;
                                    case 10:
                                        celda.setCellValue("Archivos");
                                        break;
                                    case 11:
                                        celda.setCellValue("URLs");
                                        break;
                                    case 12:
                                        celda.setCellValue("Paginas");
                                        break;
                                    case 13:
                                        celda.setCellValue("Cuestionarios");
                                        break;
                                    case 14:
                                        celda.setCellValue("Talleres");
                                        break;
                                    case 15:
                                        celda.setCellValue("VPL");
                                        break;
                                    case 16:
                                        celda.setCellValue("Profesor");
                                        break;

                                }
                            } else {

                                switch (j) {
                                    case 0:
                                        celda.setCellValue(cursosvacios.get(i).getFullname());
                                        break;
                                    case 1:
                                        celda.setCellValue(cursosvacios.get(i).getCountContent().getTareas());
                                        break;
                                    case 2:
                                        celda.setCellValue(cursosvacios.get(i).getCountContent().getConsultas());
                                        break;

                                    case 3:
                                        celda.setCellValue(cursosvacios.get(i).getCountContent().getEtiquetas());
                                        break;

                                    case 4:
                                        celda.setCellValue(cursosvacios.get(i).getCountContent().getForos());
                                        break;
                                    case 5:
                                        celda.setCellValue(cursosvacios.get(i).getCountContent().getChats());
                                        break;
                                    case 6:
                                        celda.setCellValue(cursosvacios.get(i).getCountContent().getLecciones());
                                        break;
                                    case 7:
                                        celda.setCellValue(cursosvacios.get(i).getCountContent().getWikis());
                                        break;
                                    case 8:
                                        celda.setCellValue(cursosvacios.get(i).getCountContent().getBases_de_datos());
                                        break;
                                    case 9:
                                        celda.setCellValue(cursosvacios.get(i).getCountContent().getPaquetes_SCORM());
                                        break;
                                    case 10:
                                        celda.setCellValue(cursosvacios.get(i).getCountContent().getArchivos());
                                        break;
                                    case 11:
                                        celda.setCellValue(cursosvacios.get(i).getCountContent().getURLs());
                                        break;
                                    case 12:
                                        celda.setCellValue(cursosvacios.get(i).getCountContent().getPaginas());
                                        break;
                                    case 13:
                                        celda.setCellValue(cursosvacios.get(i).getCountContent().getCuestionarios());
                                        break;
                                    case 14:
                                        celda.setCellValue(cursosvacios.get(i).getCountContent().getTalleres());
                                        break;
                                    case 15:
                                        celda.setCellValue(cursosvacios.get(i).getCountContent().getLaboratorios_virtuales_de_programacion());
                                        break;
                                    case 16:
                                        celda.setCellValue("Nombre Profesor");
                                        break;

                                }

                            }

                        }

                    }

                    libro.write(archivo);
                    archivo.close();
                    setArchivo_Ubicacion(hojadecalculo);
                    getOpenfile().setVisible(true);
                } catch (Exception e) {

                    System.err.println(e.getMessage());

                }

                System.out.println("Tipo: " + type);
                break;

        }

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
    public JToggleButton getOpenfile() {
        return openfile;
    }

    /**
     * @param openfile the openfile to set
     */
    public void setOpenfile(JToggleButton openfile) {
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
