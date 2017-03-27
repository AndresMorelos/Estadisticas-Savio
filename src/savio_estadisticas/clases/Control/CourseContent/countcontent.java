/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savio_estadisticas.clases.Control.CourseContent;

/**
 *
 * @author amorelos
 */
public class countcontent {

    private long Tareas;
    private long Consultas;
    private long Etiquetas;
    private long Foros;
    private long Chats;
    private long Lecciones;
    private long Wikis;
    private long Bases_de_datos;
    private long Paquetes_SCORM;
    private long Archivos;
    private long URLs;
    private long Paginas;
    private long Libros;
    private long Cuestionarios;
    private long Talleres;
    private long Laboratorios_virtuales_de_programacion;
    private long Portafolio;
    private long Glosario;
    private long paquete_ims;

    public countcontent() {
        this.Tareas = 0;
        this.Consultas = 0;
        this.Etiquetas = 0;
        this.Foros = 0;
        this.Chats = 0;
        this.Lecciones = 0;
        this.Wikis = 0;
        this.Bases_de_datos = 0;
        this.Paquetes_SCORM = 0;
        this.Archivos = 0;
        this.URLs = 0;
        this.Paginas = 0;
        this.Libros = 0;
        this.Cuestionarios = 0;
        this.Talleres = 0;
        this.Laboratorios_virtuales_de_programacion = 0;
    }

    /**
     * @return the Tareas
     */
    public long getTareas() {
        return Tareas;
    }

    /**
     * @param Tareas the Tareas to set
     */
    public void setTareas(long Tareas) {
        this.Tareas = Tareas;
    }

    /**
     * @return the Consultas
     */
    public long getConsultas() {
        return Consultas;
    }

    /**
     * @param Consultas the Consultas to set
     */
    public void setConsultas(long Consultas) {
        this.Consultas = Consultas;
    }

    /**
     * @return the Etiquetas
     */
    public long getEtiquetas() {
        return Etiquetas;
    }

    /**
     * @param Etiquetas the Etiquetas to set
     */
    public void setEtiquetas(long Etiquetas) {
        this.Etiquetas = Etiquetas;
    }

    /**
     * @return the Foros
     */
    public long getForos() {
        return Foros;
    }

    /**
     * @param Foros the Foros to set
     */
    public void setForos(long Foros) {
        this.Foros = Foros;
    }

    /**
     * @return the Chats
     */
    public long getChats() {
        return Chats;
    }

    /**
     * @param Chats the Chats to set
     */
    public void setChats(long Chats) {
        this.Chats = Chats;
    }

    /**
     * @return the Lecciones
     */
    public long getLecciones() {
        return Lecciones;
    }

    /**
     * @param Lecciones the Lecciones to set
     */
    public void setLecciones(long Lecciones) {
        this.Lecciones = Lecciones;
    }

    /**
     * @return the Wikis
     */
    public long getWikis() {
        return Wikis;
    }

    /**
     * @param Wikis the Wikis to set
     */
    public void setWikis(long Wikis) {
        this.Wikis = Wikis;
    }

    /**
     * @return the Base_de_datos
     */
    public long getBases_de_datos() {
        return Bases_de_datos;
    }

    /**
     * @param Base_de_datos the Base_de_datos to set
     */
    public void setBases_de_datos(long Base_de_datos) {
        this.Bases_de_datos = Base_de_datos;
    }

    /**
     * @return the Paquetes_SCORM
     */
    public long getPaquetes_SCORM() {
        return Paquetes_SCORM;
    }

    /**
     * @param Paquetes_SCORM the Paquetes_SCORM to set
     */
    public void setPaquetes_SCORM(long Paquetes_SCORM) {
        this.Paquetes_SCORM = Paquetes_SCORM;
    }

    public void upgradeArchivos() {
        this.setArchivos(this.getArchivos() + 1);
    }

    public void upgradeBases_de_datos() {
        this.setBases_de_datos(this.getBases_de_datos() + 1);
    }

    public void upgradeChats() {
        this.setChats(this.getChats() + 1);
    }

    public void upgradeConsultas() {
        this.setConsultas(this.getConsultas() + 1);
    }

    public void upgradeEtiquetas() {
        this.setEtiquetas(this.getEtiquetas() + 1);
    }

    public void upgradeForos() {
        this.setForos(this.getForos() + 1);
    }

    public void upgradeLecciones() {
        this.setLecciones(this.getLecciones() + 1);
    }

    public void upgradeLibros() {
        this.setLibros(this.getLibros() + 1);
    }

    public void upgradePaginas() {
        this.setPaginas(this.getPaginas() + 1);
    }

    public void upgradePaquetes_SCORM() {
        this.setPaquetes_SCORM(this.getPaquetes_SCORM() + 1);
    }

    public void upgradeTareas() {
        this.setTareas(this.getTareas() + 1);
    }

    public void upgradeURLs() {
        this.setURLs(this.getURLs() + 1);
    }

    public void upgradeWikis() {
        this.setWikis(this.getWikis() + 1);
    }

    public void upgradeCuestionarios() {
        this.setCuestionarios(this.getCuestionarios() + 1);
    }

    public void upgradeTalleres() {
        this.setTalleres(this.getTalleres() + 1);
    }

    public void upgradeLaboratorios_virtuales_de_programacion() {
        this.setLaboratorios_virtuales_de_programacion(this.getLaboratorios_virtuales_de_programacion() + 1);
    }

    public void upgradeGlosario() {
        this.setGlosario(this.getGlosario() + 1);
    }

    public void upgradePortafolio() {
        this.setPortafolio(this.getPortafolio() + 1);
    }

    public void upgradePaquete_IMS() {
        this.setPaquete_ims(this.getPaquete_ims() + 1);
    }

    /**
     * @return the Archivos
     */
    public long getArchivos() {
        return Archivos;
    }

    /**
     * @param Archivos the Archivos to set
     */
    public void setArchivos(long Archivos) {
        this.Archivos = Archivos;
    }

    /**
     * @return the URLs
     */
    public long getURLs() {
        return URLs;
    }

    /**
     * @param URLs the URLs to set
     */
    public void setURLs(long URLs) {
        this.URLs = URLs;
    }

    /**
     * @return the Paginas
     */
    public long getPaginas() {
        return Paginas;
    }

    /**
     * @param Paginas the Paginas to set
     */
    public void setPaginas(long Paginas) {
        this.Paginas = Paginas;
    }

    /**
     * @return the Libros
     */
    public long getLibros() {
        return Libros;
    }

    /**
     * @param Libros the Libros to set
     */
    public void setLibros(long Libros) {
        this.Libros = Libros;
    }

    /**
     * @return the Cuestionarios
     */
    public long getCuestionarios() {
        return Cuestionarios;
    }

    /**
     * @param Cuestionarios the Cuestionarios to set
     */
    public void setCuestionarios(long Cuestionarios) {
        this.Cuestionarios = Cuestionarios;
    }

    /**
     * @return the Talleres
     */
    public long getTalleres() {
        return Talleres;
    }

    /**
     * @param Talleres the Talleres to set
     */
    public void setTalleres(long Talleres) {
        this.Talleres = Talleres;
    }

    /**
     * @return the Laboratorios_virtuales_de_programación
     */
    public long getLaboratorios_virtuales_de_programacion() {
        return Laboratorios_virtuales_de_programacion;
    }

    /**
     * @param Laboratorios_virtuales_de_programación the
     * Laboratorios_virtuales_de_programación to set
     */
    public void setLaboratorios_virtuales_de_programacion(long Laboratorios_virtuales_de_programación) {
        this.Laboratorios_virtuales_de_programacion = Laboratorios_virtuales_de_programación;
    }

    public boolean isInnovator() {
        if ((Tareas > 0) && (Consultas > 0)) {
            return true;
        } else if ((Tareas > 0) && (Foros > 0)) {
            return true;
        } else if ((Tareas > 0) && (Chats > 0)) {
            return true;
        } else if ((Tareas > 0) && (Lecciones > 0)) {
            return true;
        } else if ((Tareas > 0) && (Wikis > 0)) {
            return true;
        } else if ((Tareas > 0) && (Bases_de_datos > 0)) {
            return true;
        } else if ((Tareas > 0) && (Paquetes_SCORM > 0)) {
            return true;
        } else if ((Tareas > 0) && (Libros > 0)) {
            return true;
        } else if ((Tareas > 0) && (Cuestionarios > 0)) {
            return true;
        } else if ((Tareas > 0) && (Talleres > 0)) {
            return true;
        } else if ((Tareas > 0) && (Laboratorios_virtuales_de_programacion > 0)) {
            return true;
        } else if ((Tareas > 0) && (Glosario > 0)) {
            return true;
        } else if ((Tareas > 0) && (Portafolio > 0)) {
            return true;
        } else if ((Consultas > 0) && (Foros > 0)) {
            return true;
        } else if ((Consultas > 0) && (Chats > 0)) {
            return true;
        } else if ((Consultas > 0) && (Lecciones > 0)) {
            return true;
        } else if ((Consultas > 0) && (Wikis > 0)) {
            return true;
        } else if ((Consultas > 0) && (Bases_de_datos > 0)) {
            return true;
        } else if ((Consultas > 0) && (Paquetes_SCORM > 0)) {
            return true;
        } else if ((Consultas > 0) && (Libros > 0)) {
            return true;
        } else if ((Consultas > 0) && (Cuestionarios > 0)) {
            return true;
        } else if ((Consultas > 0) && (Talleres > 0)) {
            return true;
        } else if ((Consultas > 0) && (Laboratorios_virtuales_de_programacion > 0)) {
            return true;
        } else if ((Consultas > 0) && (Glosario > 0)) {
            return true;
        } else if ((Consultas > 0) && (Portafolio > 0)) {
            return true;
        } else if ((Foros > 0) && (Chats > 0)) {
            return true;
        } else if ((Foros > 0) && (Lecciones > 0)) {
            return true;
        } else if ((Foros > 0) && (Wikis > 0)) {
            return true;
        } else if ((Foros > 0) && (Bases_de_datos > 0)) {
            return true;
        } else if ((Foros > 0) && (Paquetes_SCORM > 0)) {
            return true;
        } else if ((Foros > 0) && (Cuestionarios > 0)) {
            return true;
        } else if ((Foros > 0) && (Talleres > 0)) {
            return true;
        } else if ((Foros > 0) && (Laboratorios_virtuales_de_programacion > 0)) {
            return true;
        } else if ((Foros > 0) && (Glosario > 0)) {
            return true;
        } else if ((Foros > 0) && (Portafolio > 0)) {
            return true;
        } else if ((Chats > 0) && (Lecciones > 0)) {
            return true;
        } else if ((Chats > 0) && (Wikis > 0)) {
            return true;
        } else if ((Chats > 0) && (Bases_de_datos > 0)) {
            return true;
        } else if ((Chats > 0) && (Paquetes_SCORM > 0)) {
            return true;
        } else if ((Chats > 0) && (Cuestionarios > 0)) {
            return true;
        } else if ((Chats > 0) && (Talleres > 0)) {
            return true;
        } else if ((Chats > 0) && (Laboratorios_virtuales_de_programacion > 0)) {
            return true;
        } else if ((Chats > 0) && (Glosario > 0)) {
            return true;
        } else if ((Chats > 0) && (Portafolio > 0)) {
            return true;
        } else if ((Lecciones > 0) && (Wikis > 0)) {
            return true;
        } else if ((Lecciones > 0) && (Bases_de_datos > 0)) {
            return true;
        } else if ((Lecciones > 0) && (Paquetes_SCORM > 0)) {
            return true;
        } else if ((Lecciones > 0) && (Archivos > 0)) {
            return true;
        } else if ((Lecciones > 0) && (URLs > 0)) {
            return true;
        } else if ((Lecciones > 0) && (Paginas > 0)) {
            return true;
        } else if ((Lecciones > 0) && (Cuestionarios > 0)) {
            return true;
        } else if ((Lecciones > 0) && (Talleres > 0)) {
            return true;
        } else if ((Lecciones > 0) && (Laboratorios_virtuales_de_programacion > 0)) {
            return true;
        } else if ((Lecciones > 0) && (Glosario > 0)) {
            return true;
        } else if ((Lecciones > 0) && (Portafolio > 0)) {
            return true;
        } else if ((Wikis > 0) && (Bases_de_datos > 0)) {
            return true;
        } else if ((Wikis > 0) && (Paquetes_SCORM > 0)) {
            return true;
        } else if ((Wikis > 0) && (Archivos > 0)) {
            return true;
        } else if ((Wikis > 0) && (URLs > 0)) {
            return true;
        } else if ((Wikis > 0) && (Paginas > 0)) {
            return true;
        } else if ((Wikis > 0) && (Cuestionarios > 0)) {
            return true;
        } else if ((Wikis > 0) && (Talleres > 0)) {
            return true;
        } else if ((Wikis > 0) && (Laboratorios_virtuales_de_programacion > 0)) {
            return true;
        } else if ((Wikis > 0) && (Glosario > 0)) {
            return true;
        } else if ((Wikis > 0) && (Portafolio > 0)) {
            return true;
        } else if ((Bases_de_datos > 0) && (Paquetes_SCORM > 0)) {
            return true;
        } else if ((Bases_de_datos > 0) && (Cuestionarios > 0)) {
            return true;
        } else if ((Bases_de_datos > 0) && (Talleres > 0)) {
            return true;
        } else if ((Bases_de_datos > 0) && (Laboratorios_virtuales_de_programacion > 0)) {
            return true;
        } else if ((Paquetes_SCORM > 0) && (Cuestionarios > 0)) {
            return true;
        } else if ((Paquetes_SCORM > 0) && (Talleres > 0)) {
            return true;
        } else if ((Paquetes_SCORM > 0) && (Laboratorios_virtuales_de_programacion > 0)) {
            return true;
        } else if ((Paquetes_SCORM > 0) && (Glosario > 0)) {
            return true;
        } else if ((Paquetes_SCORM > 0) && (Portafolio > 0)) {
            return true;
        } else if ((Cuestionarios > 0) && (Talleres > 0)) {
            return true;
        } else if ((Cuestionarios > 0) && (Laboratorios_virtuales_de_programacion > 0)) {
            return true;
        } else if ((Cuestionarios > 0) && (Glosario > 0)) {
            return true;
        } else if ((Cuestionarios > 0) && (Portafolio > 0)) {
            return true;
        } else if ((Talleres > 0) && (Laboratorios_virtuales_de_programacion > 0)) {
            return true;
        } else if ((Talleres > 0) && (Glosario > 0)) {
            return true;
        } else if ((Talleres > 0) && (Portafolio > 0)) {
            return true;
        } else if ((Laboratorios_virtuales_de_programacion > 0) && (Glosario > 0)) {
            return true;
        } else if ((Laboratorios_virtuales_de_programacion > 0) && (Portafolio > 0)) {
            return true;
        } else if ((Glosario > 0) && (Portafolio > 0)) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * @return the Portafolio
     */
    public long getPortafolio() {
        return Portafolio;
    }

    /**
     * @param Portafolio the Portafolio to set
     */
    public void setPortafolio(long Portafolio) {
        this.Portafolio = Portafolio;
    }

    /**
     * @return the Glosario
     */
    public long getGlosario() {
        return Glosario;
    }

    /**
     * @param Glosario the Glosario to set
     */
    public void setGlosario(long Glosario) {
        this.Glosario = Glosario;
    }

    /**
     * @return the paquete_ims
     */
    public long getPaquete_ims() {
        return paquete_ims;
    }

    /**
     * @param paquete_ims the paquete_ims to set
     */
    public void setPaquete_ims(long paquete_ims) {
        this.paquete_ims = paquete_ims;
    }

}
