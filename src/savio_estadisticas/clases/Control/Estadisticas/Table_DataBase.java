/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savio_estadisticas.clases.Control.Estadisticas;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
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
        System.out.println("Generando Estadisticas " + type);
        List<Course> cursos = category.getCategoryCourses();
        List<Course> cursosblancos = new ArrayList<Course>();
        List<Course> CursosBlancosSheet = new ArrayList<Course>();
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
                        for (int j = 0; j < 22; j++) {
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
                                        celda.setCellValue("Libros");
                                        break;
                                    case 19:
                                        celda.setCellValue("Portafolio");
                                        break;
                                    case 20:
                                        celda.setCellValue("Glosario");
                                        break;
                                    case 21:
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
                                        celda.setCellValue(cursos.get(i).getCountContent().getLibros());
                                        break;
                                    case 19:
                                        celda.setCellValue(cursos.get(i).getCountContent().getPortafolio());
                                        break;
                                    case 20:
                                        celda.setCellValue(cursos.get(i).getCountContent().getGlosario());
                                        break;
                                    case 21:
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
                    for (Course h : category.getCategoryCourses()) {
                        if (h.getCountContent().getTareas() == 0 && h.getCountContent().getConsultas() == 0 && h.getCountContent().getEtiquetas() == 0
                                && h.getCountContent().getForos() == 0 && h.getCountContent().getChats() == 0 && h.getCountContent().getWikis() == 0
                                && h.getCountContent().getBases_de_datos() == 0 && h.getCountContent().getPaquetes_SCORM() == 0 && h.getCountContent().getArchivos() == 0
                                && h.getCountContent().getURLs() == 0 && h.getCountContent().getPaginas() == 0 && h.getCountContent().getCuestionarios() == 0 && h.getCountContent().getTalleres() == 0
                                && h.getCountContent().getLaboratorios_virtuales_de_programacion() == 0 && h.getCountContent().getLecciones() == 0 && h.getCountContent().getGlosario() == 0
                                && h.getCountContent().getPortafolio() == 0 && h.getCountContent().getLibros() == 0) {
                            cursosblancos.add(h);
                        }

                    }
                    GenerateStatistis(libro, cursos.size(), cursosblancos.size());
                    libro.write(archivo);
                    archivo.close();
                    setArchivo_Ubicacion(hojadecalculo);

                } catch (Exception e) {

                    System.err.println(e.getMessage() + " " + e.getCause());

                }
                break;
            case "Cursos En Blanco":
                List<Node> cursos_blancos_subcategoria = new ArrayList<Node>();

                for (Course h : category.getCategoryCourses()) {

                    if (h.getCountContent().getTareas() == 0 && h.getCountContent().getConsultas() == 0 && h.getCountContent().getEtiquetas() == 0
                            && h.getCountContent().getForos() == 0 && h.getCountContent().getChats() == 0 && h.getCountContent().getWikis() == 0
                            && h.getCountContent().getBases_de_datos() == 0 && h.getCountContent().getPaquetes_SCORM() == 0 && h.getCountContent().getArchivos() == 0
                            && h.getCountContent().getURLs() == 0 && h.getCountContent().getPaginas() == 0 && h.getCountContent().getCuestionarios() == 0 && h.getCountContent().getTalleres() == 0
                            && h.getCountContent().getLaboratorios_virtuales_de_programacion() == 0 && h.getCountContent().getLecciones() == 0 && h.getCountContent().getGlosario() == 0
                            && h.getCountContent().getPortafolio() == 0 && h.getCountContent().getLibros() == 0) {
                        CursosBlancosSheet.add(h);
                    }

                }

                for (Course j : CursosBlancosSheet) {
                    if (cursos_blancos_subcategoria.size() > 0) {
                        for (Node l : cursos_blancos_subcategoria) {
                            if (l.getNameCategory().equalsIgnoreCase(j.getCategoryName())) {
                                l.addCourse(j);
                            } else {
                                Node aux = new Node(j.getCategoryName());
                                aux.addCourse(j);
                                cursos_blancos_subcategoria.add(aux);
                            }
                        }
                    } else {
                        Node aux = new Node(j.getCategoryName());
                        aux.addCourse(j);
                        cursos_blancos_subcategoria.add(aux);
                    }
                }

                try {
                    System.out.println("Generando Hoja de Calculo");
                    File hojadecalculo = new File(FileName);

                    if (hojadecalculo.exists()) {
                        hojadecalculo.delete();
                    }
                    hojadecalculo.createNewFile();

                    Workbook libro = new HSSFWorkbook();

                    FileOutputStream archivo = new FileOutputStream(hojadecalculo);

                    for (Node k : cursos_blancos_subcategoria) {
                        Sheet hoja = libro.createSheet(k.getNameCategory());

                        for (int i = 0; i < k.getCategoryCourses().size(); i++) {
                            Row fila = hoja.createRow(i);
                            for (int j = 0; j < 3; j++) {
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
                                    }
                                } else {

                                    switch (j) {
                                        case 0:
                                            celda.setCellValue(k.getCategoryCourses().get(i).getCategoryName());
                                            break;
                                        case 1:
                                            celda.setCellValue(k.getCategoryCourses().get(i).getFullname());
                                            break;
                                        case 2:
                                            String Profesores = " ";
                                            List<String> profesores = k.getCategoryCourses().get(i).getProfessor();
                                            for (String a : profesores) {
                                                Profesores = Profesores + " \n" + a;
                                            }
                                            celda.setCellValue(Profesores);
                                            break;
                                    }

                                }

                            }

                        }
                    }

                    libro.write(archivo);
                    archivo.close();
                    setArchivo_Ubicacion(hojadecalculo);

                } catch (Exception e) {

                    System.err.println(e.getMessage() + "  " + e.getCause());

                }

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

    public void GenerateStatistis(Workbook libro, int total, int Ninguno) {
        Sheet estadisticas = libro.createSheet("Estadisticas");

        for (int i = 0; i < 22; i++) {
            Row fila_esta = estadisticas.createRow(i);
            for (int j = 0; j < 4; j++) {
                Cell celda_esta = fila_esta.createCell(j);
                switch (i) {
                    case 0:
                        switch (j) {
                            case 0:
                                celda_esta.setCellValue("Recurso");
                                break;
                            case 1:
                                celda_esta.setCellValue("Cursos");
                                break;
                            case 2:
                                celda_esta.setCellValue("Promedio (%)");
                                break;
                            case 3:
                                celda_esta.setCellValue("Total Cursos");
                                break;
                        }
                        break;
                    case 1:
                        switch (j) {
                            case 0:
                                celda_esta.setCellValue("Tareas");
                                break;
                            case 1:
                                celda_esta.setCellFormula("COUNTIF(Tabla!D:D,\">0\")");
                                break;
                            case 2:
                                celda_esta.setCellFormula("B" + (i + 1) + "/D2");
                                CellStyle style = libro.createCellStyle();
                                style.setDataFormat(libro.createDataFormat().getFormat("0.0%"));
                                celda_esta.setCellStyle(style);
                                break;
                            case 3:
                                celda_esta.setCellValue(total);
                                break;
                        }
                        break;
                    case 2:
                        switch (j) {
                            case 0:
                                celda_esta.setCellValue("Consultas");
                                break;
                            case 1:
                                celda_esta.setCellFormula("COUNTIF(Tabla!E:E,\">0\")");
                                break;
                            case 2:
                                celda_esta.setCellFormula("B" + (i + 1) + "/D2");
                                CellStyle style = libro.createCellStyle();
                                style.setDataFormat(libro.createDataFormat().getFormat("0.0%"));
                                celda_esta.setCellStyle(style);
                                break;
                            case 3:
                                celda_esta.setCellValue(total);
                                break;
                        }
                        break;
                    case 3:
                        switch (j) {
                            case 0:
                                celda_esta.setCellValue("Etiquetas");
                                break;
                            case 1:
                                celda_esta.setCellFormula("COUNTIF(Tabla!F:F,\">0\")");
                                break;
                            case 2:
                                celda_esta.setCellFormula("B" + (i + 1) + "/D2");
                                CellStyle style = libro.createCellStyle();
                                style.setDataFormat(libro.createDataFormat().getFormat("0.0%"));
                                celda_esta.setCellStyle(style);
                                break;
                            case 3:
                                celda_esta.setCellValue(total);
                                break;
                        }
                        break;
                    case 4:
                        switch (j) {
                            case 0:
                                celda_esta.setCellValue("Foros");
                                break;
                            case 1:
                                celda_esta.setCellFormula("COUNTIF(Tabla!G:G,\">0\")");
                                break;
                            case 2:
                                celda_esta.setCellFormula("B" + (i + 1) + "/D2");
                                CellStyle style = libro.createCellStyle();
                                style.setDataFormat(libro.createDataFormat().getFormat("0.0%"));
                                celda_esta.setCellStyle(style);
                                break;
                            case 3:
                                celda_esta.setCellValue(total);
                                break;
                        }
                        break;
                    case 5:
                        switch (j) {
                            case 0:
                                celda_esta.setCellValue("Chats");
                                break;
                            case 1:
                                celda_esta.setCellFormula("COUNTIF(Tabla!H:H,\">0\")");
                                break;
                            case 2:
                                celda_esta.setCellFormula("B" + (i + 1) + "/D2");
                                CellStyle style = libro.createCellStyle();
                                style.setDataFormat(libro.createDataFormat().getFormat("0.0%"));
                                celda_esta.setCellStyle(style);
                                break;
                            case 3:
                                celda_esta.setCellValue(total);
                                break;
                        }
                        break;
                    case 6:
                        switch (j) {
                            case 0:
                                celda_esta.setCellValue("Lecciones");
                                break;
                            case 1:
                                celda_esta.setCellFormula("COUNTIF(Tabla!I:I,\">0\")");
                                break;
                            case 2:
                                celda_esta.setCellFormula("B" + (i + 1) + "/D2");
                                CellStyle style = libro.createCellStyle();
                                style.setDataFormat(libro.createDataFormat().getFormat("0.0%"));
                                celda_esta.setCellStyle(style);
                                break;
                            case 3:
                                celda_esta.setCellValue(total);
                                break;
                        }
                        break;
                    case 7:
                        switch (j) {
                            case 0:
                                celda_esta.setCellValue("Wikis");
                                break;
                            case 1:
                                celda_esta.setCellFormula("COUNTIF(Tabla!J:J,\">0\")");
                                break;
                            case 2:
                                celda_esta.setCellFormula("B" + (i + 1) + "/D2");
                                CellStyle style = libro.createCellStyle();
                                style.setDataFormat(libro.createDataFormat().getFormat("0.0%"));
                                celda_esta.setCellStyle(style);
                                break;
                            case 3:
                                celda_esta.setCellValue(total);
                                break;
                        }
                        break;
                    case 8:
                        switch (j) {
                            case 0:
                                celda_esta.setCellValue("Bases de Datos");
                                break;
                            case 1:
                                celda_esta.setCellFormula("COUNTIF(Tabla!K:K,\">0\")");
                                break;
                            case 2:
                                celda_esta.setCellFormula("B" + (i + 1) + "/D2");
                                CellStyle style = libro.createCellStyle();
                                style.setDataFormat(libro.createDataFormat().getFormat("0.0%"));
                                celda_esta.setCellStyle(style);
                                break;
                            case 3:
                                celda_esta.setCellValue(total);
                                break;
                        }
                        break;
                    case 9:
                        switch (j) {
                            case 0:
                                celda_esta.setCellValue("Paquetes SCORM");
                                break;
                            case 1:
                                celda_esta.setCellFormula("COUNTIF(Tabla!L:L,\">0\")");
                                break;
                            case 2:
                                celda_esta.setCellFormula("B" + (i + 1) + "/D2");
                                CellStyle style = libro.createCellStyle();
                                style.setDataFormat(libro.createDataFormat().getFormat("0.0%"));
                                celda_esta.setCellStyle(style);
                                break;
                            case 3:
                                celda_esta.setCellValue(total);
                                break;
                        }
                        break;
                    case 10:
                        switch (j) {
                            case 0:
                                celda_esta.setCellValue("Archivos");
                                break;
                            case 1:
                                celda_esta.setCellFormula("COUNTIF(Tabla!M:M,\">0\")");
                                break;
                            case 2:
                                celda_esta.setCellFormula("B" + (i + 1) + "/D2");
                                CellStyle style = libro.createCellStyle();
                                style.setDataFormat(libro.createDataFormat().getFormat("0.0%"));
                                celda_esta.setCellStyle(style);
                                break;
                            case 3:
                                celda_esta.setCellValue(total);
                                break;
                        }
                        break;
                    case 11:
                        switch (j) {
                            case 0:
                                celda_esta.setCellValue("URLs");
                                break;
                            case 1:
                                celda_esta.setCellFormula("COUNTIF(Tabla!N:N,\">0\")");
                                break;
                            case 2:
                                celda_esta.setCellFormula("B" + (i + 1) + "/D2");
                                CellStyle style = libro.createCellStyle();
                                style.setDataFormat(libro.createDataFormat().getFormat("0.0%"));
                                celda_esta.setCellStyle(style);
                                break;
                            case 3:
                                celda_esta.setCellValue(total);
                                break;
                        }
                        break;
                    case 12:
                        switch (j) {
                            case 0:
                                celda_esta.setCellValue("Paginas");
                                break;
                            case 1:
                                celda_esta.setCellFormula("COUNTIF(Tabla!O:O,\">0\")");
                                break;
                            case 2:
                                celda_esta.setCellFormula("B" + (i + 1) + "/D2");
                                CellStyle style = libro.createCellStyle();
                                style.setDataFormat(libro.createDataFormat().getFormat("0.0%"));
                                celda_esta.setCellStyle(style);
                                break;
                            case 3:
                                celda_esta.setCellValue(total);
                                break;
                        }
                        break;
                    case 13:
                        switch (j) {
                            case 0:
                                celda_esta.setCellValue("Cuestionarios");
                                break;
                            case 1:
                                celda_esta.setCellFormula("COUNTIF(Tabla!P:P,\">0\")");
                                break;
                            case 2:
                                celda_esta.setCellFormula("B" + (i + 1) + "/D2");
                                CellStyle style = libro.createCellStyle();
                                style.setDataFormat(libro.createDataFormat().getFormat("0.0%"));
                                celda_esta.setCellStyle(style);
                                break;
                            case 3:
                                celda_esta.setCellValue(total);
                                break;
                        }
                        break;
                    case 14:
                        switch (j) {
                            case 0:
                                celda_esta.setCellValue("Talleres");
                                break;
                            case 1:
                                celda_esta.setCellFormula("COUNTIF(Tabla!Q:Q,\">0\")");
                                break;
                            case 2:
                                celda_esta.setCellFormula("B" + (i + 1) + "/D2");
                                CellStyle style = libro.createCellStyle();
                                style.setDataFormat(libro.createDataFormat().getFormat("0.0%"));
                                celda_esta.setCellStyle(style);
                                break;
                            case 3:
                                celda_esta.setCellValue(total);
                                break;
                        }
                        break;
                    case 15:
                        switch (j) {
                            case 0:
                                celda_esta.setCellValue("VPL");
                                break;
                            case 1:
                                celda_esta.setCellFormula("COUNTIF(Tabla!R:R,\">0\")");
                                break;
                            case 2:
                                celda_esta.setCellFormula("B" + (i + 1) + "/D2");
                                CellStyle style = libro.createCellStyle();
                                style.setDataFormat(libro.createDataFormat().getFormat("0.0%"));
                                celda_esta.setCellStyle(style);
                                break;
                            case 3:
                                celda_esta.setCellValue(total);
                                break;
                        }
                        break;
                    case 16:
                        switch (j) {
                            case 0:
                                celda_esta.setCellValue("Libros");
                                break;
                            case 1:
                                celda_esta.setCellFormula("COUNTIF(Tabla!S:S,\">0\")");
                                break;
                            case 2:
                                celda_esta.setCellFormula("B" + (i + 1) + "/D2");
                                CellStyle style = libro.createCellStyle();
                                style.setDataFormat(libro.createDataFormat().getFormat("0.0%"));
                                celda_esta.setCellStyle(style);
                                break;
                            case 3:
                                celda_esta.setCellValue(total);
                                break;
                        }
                        break;
                    case 17:
                        switch (j) {
                            case 0:
                                celda_esta.setCellValue("Glosario");
                                break;
                            case 1:
                                celda_esta.setCellFormula("COUNTIF(Tabla!T:T,\">0\")");
                                break;
                            case 2:
                                celda_esta.setCellFormula("B" + (i + 1) + "/D2");
                                CellStyle style = libro.createCellStyle();
                                style.setDataFormat(libro.createDataFormat().getFormat("0.0%"));
                                celda_esta.setCellStyle(style);
                                break;
                            case 3:
                                celda_esta.setCellValue(total);
                                break;
                        }
                        break;
                    case 18:
                        switch (j) {
                            case 0:
                                celda_esta.setCellValue("Portafolio");
                                break;
                            case 1:
                                celda_esta.setCellFormula("COUNTIF(Tabla!U:U,\">0\")");
                                break;
                            case 2:
                                celda_esta.setCellFormula("B" + (i + 1) + "/D2");
                                CellStyle style = libro.createCellStyle();
                                style.setDataFormat(libro.createDataFormat().getFormat("0.0%"));
                                celda_esta.setCellStyle(style);
                                break;
                            case 3:
                                celda_esta.setCellValue(total);
                                break;
                        }
                        break;
                    case 19:
                        switch (j) {
                            case 0:
                                celda_esta.setCellValue("Innovadores");
                                break;
                            case 1:
                                celda_esta.setCellFormula("COUNTIF(Tabla!V:V,\">0\")");
                                break;
                            case 2:
                                celda_esta.setCellFormula("B" + (i + 1) + "/D2");
                                CellStyle style = libro.createCellStyle();
                                style.setDataFormat(libro.createDataFormat().getFormat("0.0%"));
                                celda_esta.setCellStyle(style);
                                break;
                            case 3:
                                celda_esta.setCellValue(total);
                                break;
                        }
                        break;
                    case 20:
                        switch (j) {
                            case 0:
                                celda_esta.setCellValue("Ninguno");
                                break;
                            case 1:
                                celda_esta.setCellValue(Ninguno);
                                break;
                            case 2:
                                celda_esta.setCellFormula("B" + (i + 1) + "/D2");
                                CellStyle style = libro.createCellStyle();
                                style.setDataFormat(libro.createDataFormat().getFormat("0.0%"));
                                celda_esta.setCellStyle(style);
                                break;
                            case 3:
                                celda_esta.setCellValue(total);
                                break;
                        }
                        break;
                }
            }
        }

        //celda_esta.setCellFormula("COUNTIF(Tabla!S:S,\">0\")");
    }
}
