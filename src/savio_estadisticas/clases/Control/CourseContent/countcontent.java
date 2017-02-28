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
    
    public void upgradeArchivos(){
        this.setArchivos(this.getArchivos() + 1);
    }
    
    public void upgradeBases_de_datos(){
        this.setBases_de_datos(this.getBases_de_datos() + 1);
    }
    
    public void upgradeChats(){
        this.setChats(this.getChats() + 1);
    }
    
    public void upgradeConsultas(){
        this.setConsultas(this.getConsultas() + 1);
    }
    
    public void upgradeEtiquetas(){
        this.setEtiquetas(this.getEtiquetas() + 1);
    }
    
    public void upgradeForos(){
        this.setForos(this.getForos() + 1);
    }
    
    public void upgradeLecciones(){
        this.setLecciones(this.getLecciones() + 1);
    }
    
    public void upgradeLibros(){
        this.setLibros(this.getLibros() + 1);
    }
    
    public void upgradePaginas(){
        this.setPaginas(this.getPaginas() + 1);
    }
    
    public void upgradePaquetes_SCORM(){
        this.setPaquetes_SCORM(this.getPaquetes_SCORM() + 1);
    }
    
    public void upgradeTareas(){
        this.setTareas(this.getTareas() + 1);
    }
    
    public void upgradeURLs(){
        this.setURLs(this.getURLs() + 1);
    }
    
    public void upgradeWikis(){
        this.setWikis(this.getWikis() + 1);
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
    
}
