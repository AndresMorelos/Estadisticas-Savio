/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savio_estadisticas.clases.Control;

import com.google.gson.Gson;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import savio_estadisticas.clases.CategoryName;
import savio_estadisticas.clases.Course;
import savio_estadisticas.clases.Node;

/**
 *
 * @author amorelos
 */
public class CategoriesControl extends Thread {

    private List<Node> NodesCategories = new ArrayList<Node>();
    private List<Course> All_Courses;
    private final int N;
    private final int L;
    private int k = 1;
    private int progress = 0;
    private JProgressBar jpbar;
    private JLabel jlLab;

    private final String URI = "http://savio.utbvirtual.edu.co/course/category/";
    private Gson gson = new Gson();
    private getCatergories GetCategories = new getCatergories();

    public CategoriesControl(List<Course> All_Courses, JProgressBar jpbar, JLabel jlLab) {
        this.All_Courses = All_Courses;
        this.N = this.All_Courses.size();
        this.L = N / 20;
        this.jpbar = jpbar;
        this.jlLab = jlLab;

    }

    public List<Node> getNodesCategories() {
        return NodesCategories;
    }

    public void setNodesCategories(List<Node> NodesCategories) {
        this.NodesCategories = NodesCategories;
    }

    public List<Course> getAll_Courses() {
        return All_Courses;
    }

    public void setAll_Courses(List<Course> All_Courses) {
        this.All_Courses = All_Courses;
    }

    @Override
    public void run() {
        super.run();
        ThreadGroup t1 = new ThreadGroup("Grupo Categorias");
        for (int i = 0; i <= N; i = i + L) {
            List<Course> part;

            if (k == 20) {
                part = this.All_Courses.subList(i, Math.min(N, i + L) + 1);
                System.out.println(Math.min(N, i + L) + 1);
            } else {
                part = this.All_Courses.subList(i, Math.min(N, i + L));
                System.out.println(Math.min(N, i + L));
            }
            k++;
            Thread myThread = new Thread(t1, new Runnable() {
                public void run() {
                    for (Course a : part) {

                        if (a.getCategoryid() == 0) {
                        } else {
                            CategoryName categoryname = GetCategories.GetCategories(Integer.toString(a.getCategoryid()));
                            if (exitsnode(categoryname.getName())) {
                                for (Node h : NodesCategories) {
                                    if (h.getNameCategory().equalsIgnoreCase(categoryname.getName())) {

                                        synchronized (NodesCategories) {
                                            h.addCourse(a);
                                            progress++;
                                            getJpbar().setValue(progress);
                                            getJlLab().setText("Filtrando Cursos Por Categoria " + progress + "/" + All_Courses.size());
                                        }

                                        break;
                                    }
                                }
                            } else {
                                System.out.println("Nodo Creado");

                                synchronized (NodesCategories) {
                                    NodesCategories.add(new Node(categoryname.getName()));
                                }

                                for (Node h : NodesCategories) {
                                    if (h.getNameCategory().equalsIgnoreCase(categoryname.getName())) {

                                        synchronized (NodesCategories) {
                                            h.addCourse(a);
                                            progress++;
                                            getJpbar().setValue(progress);
                                            getJlLab().setText("Filtrando Cursos Por Categoria " + progress + "/" + All_Courses.size());
                                        }

                                        System.out.println("Agreado");

                                        break;
                                    }
                                }
                            }
                        }

                    }
                }

            });
            myThread.start();
            myThread.setName("FeedList" + k);
        }

        while (t1.activeCount() > 0) {
            try {
                this.join(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(CategoriesControl.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        getJpbar().setVisible(false);
        getJlLab().setVisible(false);

    }

    private boolean exitsnode(String Name) {
        for (Node h : this.NodesCategories) {
            if (h.getNameCategory().equalsIgnoreCase(Name)) {
                return true;
            }
        }
        return false;
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
     * @return the jlLab
     */
    public JLabel getJlLab() {
        return jlLab;
    }

    /**
     * @param jlLab the jlLab to set
     */
    public void setJlLab(JLabel jlLab) {
        this.jlLab = jlLab;
    }

}
