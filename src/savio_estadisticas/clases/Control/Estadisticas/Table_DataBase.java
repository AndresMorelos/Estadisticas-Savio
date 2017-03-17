/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savio_estadisticas.clases.Control.Estadisticas;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import savio_estadisticas.clases.Course;
import savio_estadisticas.clases.Node;

/**
 *
 * @author amorelos
 */
public class Table_DataBase {
    private File Archivo_Ubicacion = null;

    public Table_DataBase() {
    }
    
    
    
    public void CreateSheet(String type, Node category, String FileName) {
        System.out.println("Generando Estadisticas");
        List<Course> cursos = category.getCategoryCourses();
        switch (type) {
            case "Cursos Innovadores":

                try {
                    File hojadecalculo = new File(FileName);

                    if (hojadecalculo.exists()) {
                        hojadecalculo.delete();
                    }
                    hojadecalculo.createNewFile();

                    Workbook libro = new HSSFWorkbook();

                    FileOutputStream archivo = new FileOutputStream(hojadecalculo);

                    Sheet hoja = libro.createSheet("Tabla");

                    for (int i = 0; i < cursos.size(); i++) {
                        Row fila = hoja.createRow(i);
                        for (int j = 0; j < 19; j++) {
                            Cell celda = fila.createCell(j);
                            if (i == 0) {
                                switch (j) {
                                    case 0:
                                        celda.setCellValue("SubCategoria");
                                        break;
                                    case 1:
                                        celda.setCellValue("Nombre Curso");
                                        break;
                                    case 2:
                                        celda.setCellValue("Profesor");
                                        break;
                                    case 3:
                                        celda.setCellValue("Tareas");
                                        break;
                                    case 4:
                                        celda.setCellValue("Consultas");
                                        break;

                                    case 5:
                                        celda.setCellValue("Etiquetas");
                                        break;

                                    case 6:
                                        celda.setCellValue("Foros");
                                        break;
                                    case 7:
                                        celda.setCellValue("Chats");
                                        break;
                                    case 8:
                                        celda.setCellValue("Lecciones");
                                        break;
                                    case 9:
                                        celda.setCellValue("Wikis");
                                        break;
                                    case 10:
                                        celda.setCellValue("Bases de Datos");
                                        break;
                                    case 11:
                                        celda.setCellValue("Paquetes SCORM");
                                        break;
                                    case 12:
                                        celda.setCellValue("Archivos");
                                        break;
                                    case 13:
                                        celda.setCellValue("URLs");
                                        break;
                                    case 14:
                                        celda.setCellValue("Paginas");
                                        break;
                                    case 15:
                                        celda.setCellValue("Cuestionarios");
                                        break;
                                    case 16:
                                        celda.setCellValue("Talleres");
                                        break;
                                    case 17:
                                        celda.setCellValue("VPL");
                                        break;
                                    case 18:
                                        celda.setCellValue("Innovador");
                                        break;
                                }
                            } else {
                                switch (j) {
                                    case 0:
                                        celda.setCellValue(cursos.get(i).getCategoryName());
                                        break;
                                    case 1:
                                        celda.setCellValue(cursos.get(i).getFullname());
                                        break;
                                    case 2:
                                        String Profesores = " ";
                                        List<String> profesores = cursos.get(i).getProfessor();
                                        for (String a : profesores) {
                                            Profesores = Profesores + " \n" + a;
                                        }
                                        celda.setCellValue(Profesores);
                                        break;
                                    case 3:
                                        celda.setCellValue(cursos.get(i).getCountContent().getTareas());
                                        break;
                                    case 4:
                                        celda.setCellValue(cursos.get(i).getCountContent().getConsultas());
                                        break;

                                    case 5:
                                        celda.setCellValue(cursos.get(i).getCountContent().getEtiquetas());
                                        break;

                                    case 6:
                                        celda.setCellValue(cursos.get(i).getCountContent().getForos());
                                        break;
                                    case 7:
                                        celda.setCellValue(cursos.get(i).getCountContent().getChats());
                                        break;
                                    case 8:
                                        celda.setCellValue(cursos.get(i).getCountContent().getLecciones());
                                        break;
                                    case 9:
                                        celda.setCellValue(cursos.get(i).getCountContent().getWikis());
                                        break;
                                    case 10:
                                        celda.setCellValue(cursos.get(i).getCountContent().getBases_de_datos());
                                        break;
                                    case 11:
                                        celda.setCellValue(cursos.get(i).getCountContent().getPaquetes_SCORM());
                                        break;
                                    case 12:
                                        celda.setCellValue(cursos.get(i).getCountContent().getArchivos());
                                        break;
                                    case 13:
                                        celda.setCellValue(cursos.get(i).getCountContent().getURLs());
                                        break;
                                    case 14:
                                        celda.setCellValue(cursos.get(i).getCountContent().getPaginas());
                                        break;
                                    case 15:
                                        celda.setCellValue(cursos.get(i).getCountContent().getCuestionarios());
                                        break;
                                    case 16:
                                        celda.setCellValue(cursos.get(i).getCountContent().getTalleres());
                                        break;
                                    case 17:
                                        celda.setCellValue(cursos.get(i).getCountContent().getLaboratorios_virtuales_de_programacion());
                                        break;
                                    case 18:
                                        if (cursos.get(i).getCountContent().isInnovator()) {
                                            celda.setCellValue(1);
                                        } else {
                                            celda.setCellValue(0);
                                        }
                                        break;
                                }

                            }

                        }

                    }

                    libro.write(archivo);
                    archivo.close();
                    setArchivo_Ubicacion(hojadecalculo);
                    
                } catch (Exception e) {

                    System.err.println(e.getMessage() + " " + e.getCause());

                }
                break;
            case "Cursos En Blanco":

                for (Course h : category.getCategoryCourses()) {
                    if (h.getCountContent().getTareas() == 0 && h.getCountContent().getConsultas() == 0 && h.getCountContent().getEtiquetas() == 0
                            && h.getCountContent().getForos() == 0 && h.getCountContent().getChats() == 0 && h.getCountContent().getWikis() == 0
                            && h.getCountContent().getBases_de_datos() == 0 && h.getCountContent().getPaquetes_SCORM() == 0 && h.getCountContent().getArchivos() == 0
                            && h.getCountContent().getURLs() == 0 && h.getCountContent().getPaginas() == 0 && h.getCountContent().getCuestionarios() == 0 && h.getCountContent().getTalleres() == 0
                            && h.getCountContent().getLaboratorios_virtuales_de_programacion() == 0 && h.getCountContent().getLecciones() == 0) {
                        cursos.add(h);
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

                    for (int i = 0; i < cursos.size(); i++) {
                        Row fila = hoja.createRow(i);
                        for (int j = 0; j < 18; j++) {
                            Cell celda = fila.createCell(j);
                            if (i == 0) {
                                switch (j) {
                                    case 0:
                                        celda.setCellValue("SubCategoria");
                                        break;
                                    case 1:
                                        celda.setCellValue("Nombre Curso");
                                        break;
                                    case 2:
                                        celda.setCellValue("Profesor");
                                        break;
                                    case 3:
                                        celda.setCellValue("Tareas");
                                        break;
                                    case 4:
                                        celda.setCellValue("Consultas");
                                        break;

                                    case 5:
                                        celda.setCellValue("Etiquetas");
                                        break;

                                    case 6:
                                        celda.setCellValue("Foros");
                                        break;
                                    case 7:
                                        celda.setCellValue("Chats");
                                        break;
                                    case 8:
                                        celda.setCellValue("Lecciones");
                                        break;
                                    case 9:
                                        celda.setCellValue("Wikis");
                                        break;
                                    case 10:
                                        celda.setCellValue("Bases de Datos");
                                        break;
                                    case 11:
                                        celda.setCellValue("Paquetes SCORM");
                                        break;
                                    case 12:
                                        celda.setCellValue("Archivos");
                                        break;
                                    case 13:
                                        celda.setCellValue("URLs");
                                        break;
                                    case 14:
                                        celda.setCellValue("Paginas");
                                        break;
                                    case 15:
                                        celda.setCellValue("Cuestionarios");
                                        break;
                                    case 16:
                                        celda.setCellValue("Talleres");
                                        break;
                                    case 17:
                                        celda.setCellValue("VPL");
                                        break;

                                }
                            } else {

                                switch (j) {
                                    case 0:
                                        celda.setCellValue(cursos.get(i).getCategoryName());
                                        break;
                                    case 1:
                                        celda.setCellValue(cursos.get(i).getFullname());
                                        break;
                                    case 2:
                                        String Profesores = " ";
                                        List<String> profesores = cursos.get(i).getProfessor();
                                        for (String a : profesores) {
                                            Profesores = Profesores + " \n" + a;
                                        }
                                        celda.setCellValue(Profesores);
                                        break;
                                    case 3:
                                        celda.setCellValue(cursos.get(i).getCountContent().getTareas());
                                        break;
                                    case 4:
                                        celda.setCellValue(cursos.get(i).getCountContent().getConsultas());
                                        break;

                                    case 5:
                                        celda.setCellValue(cursos.get(i).getCountContent().getEtiquetas());
                                        break;

                                    case 6:
                                        celda.setCellValue(cursos.get(i).getCountContent().getForos());
                                        break;
                                    case 7:
                                        celda.setCellValue(cursos.get(i).getCountContent().getChats());
                                        break;
                                    case 8:
                                        celda.setCellValue(cursos.get(i).getCountContent().getLecciones());
                                        break;
                                    case 9:
                                        celda.setCellValue(cursos.get(i).getCountContent().getWikis());
                                        break;
                                    case 10:
                                        celda.setCellValue(cursos.get(i).getCountContent().getBases_de_datos());
                                        break;
                                    case 11:
                                        celda.setCellValue(cursos.get(i).getCountContent().getPaquetes_SCORM());
                                        break;
                                    case 12:
                                        celda.setCellValue(cursos.get(i).getCountContent().getArchivos());
                                        break;
                                    case 13:
                                        celda.setCellValue(cursos.get(i).getCountContent().getURLs());
                                        break;
                                    case 14:
                                        celda.setCellValue(cursos.get(i).getCountContent().getPaginas());
                                        break;
                                    case 15:
                                        celda.setCellValue(cursos.get(i).getCountContent().getCuestionarios());
                                        break;
                                    case 16:
                                        celda.setCellValue(cursos.get(i).getCountContent().getTalleres());
                                        break;
                                    case 17:
                                        celda.setCellValue(cursos.get(i).getCountContent().getLaboratorios_virtuales_de_programacion());
                                        break;

                                }

                            }

                        }

                    }

                    libro.write(archivo);
                    archivo.close();
                    setArchivo_Ubicacion(hojadecalculo);
                   
                } catch (Exception e) {

                    System.err.println(e.getMessage());

                }

                System.out.println("Tipo: " + type);
                break;

        }

        System.out.println("Estadisticas generadas");

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
}
