package com.example.footballeur;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyApplication extends Application {

    private static List<Footballeur> footballeurList = new ArrayList<Footballeur>();
    private static int nextId = 10;

    public MyApplication() {
        fillFootballeurtList();
    }

    private void fillFootballeurtList() {
        Footballeur f0 = new Footballeur(0, "Edson Arantes do Nascimento (Pelé)", 1940, "https://cdn.sansimera.gr/media/photos/main/lg/Pele.jpg");
        Footballeur f1 = new Footballeur(1,"Diego Armando Maradona Franco", 1960, "https://gal.img.pmdstatic.net/fit/http.3A.2F.2Fprd2-bone-image.2Es3-website-eu-west-1.2Eamazonaws.2Ecom.2Fgal.2F2020.2F11.2F25.2F0795c520-bee7-4b7e-9f3c-e8a1c91330ca.2Ejpeg/480x480/quality/80/diego-maradona-quelles-sont-les-causes-de-sa-mort.jpg");
        Footballeur f2 = new Footballeur(2, "Ronaldo Luís Nazário de Lima", 1976, "https://en.as.com/tikitakas/imagenes/2017/12/28/portada/1514448082_557886_1514448185_noticia_normal.jpg");
        Footballeur f3 = new Footballeur(3, "Ronaldo de Assis Moreira (Ronaldinho)", 1980, "https://upload.wikimedia.org/wikipedia/commons/thumb/9/92/Ronaldinho_Kazan.jpg/250px-Ronaldinho_Kazan.jpg");
        Footballeur f4 = new Footballeur(4, "Zinédine Yazid Zidane", 1972, "https://img.fifa.com/image/upload/t_s2/lzcjramiebwogsfkxm7o.jpg");
        Footballeur f5 = new Footballeur(5, "Gianluigi Buffon", 1978, "https://upload.wikimedia.org/wikipedia/commons/thumb/5/54/Gianluigi_Buffon_%2831784615942%29_%28cropped%29.jpg/220px-Gianluigi_Buffon_%2831784615942%29_%28cropped%29.jpg");
        Footballeur f6 = new Footballeur(6, "Lionel Andrés Messi Cuccitin", 1987, "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0c/Lionel_Messi_16_June_2018.jpg/250px-Lionel_Messi_16_June_2018.jpg");
        Footballeur f7 = new Footballeur(7, "Cristiano Ronaldo dos Santos Aveiro (CR7)", 1985, "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8c/Cristiano_Ronaldo_2018.jpg/220px-Cristiano_Ronaldo_2018.jpg");
        Footballeur f8 = new Footballeur(8, "Michel Platini", 1955, "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ed/Michel_Platini_en_1978%2C_%27Argentina_78%27%2C_Panini_figurina_n%C2%B090.jpg/250px-Michel_Platini_en_1978%2C_%27Argentina_78%27%2C_Panini_figurina_n%C2%B090.jpg");
        Footballeur f9 = new Footballeur(9, "Xavier Hernández i Creus", 1980, "https://upload.wikimedia.org/wikipedia/commons/thumb/2/22/Xavi_Hernandez_%2831521652051%29.jpg/280px-Xavi_Hernandez_%2831521652051%29.jpg");

        footballeurList.addAll(Arrays.asList(new Footballeur[]{f0, f1, f2, f3, f4, f5, f6, f7, f8, f9}));

    }

    public static List<Footballeur> getFootballeurList() {
        return footballeurList;
    }

    public static void setFootballeurList(List<Footballeur> footballeurList) {
        MyApplication.footballeurList = footballeurList;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        MyApplication.nextId = nextId;
    }
}
