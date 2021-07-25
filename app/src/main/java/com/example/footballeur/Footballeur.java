package com.example.footballeur;

import java.util.Comparator;

public class Footballeur{

    private int id;
    private String nom;
    private int dateNaissance;
    private String imageURl;


    public Footballeur(int id, String nom, int dateNaissance, String imageURl) {
        this.id = id;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.imageURl = imageURl;
    }

    public static Comparator<Footballeur> presidentNameAZComparator = new Comparator<Footballeur>() {
        @Override
        public int compare(Footballeur f1, Footballeur f2) {
            return f1.getNom().compareTo(f2.getNom());
        }
    };

    public static Comparator<Footballeur> presidentNameZAComparator = new Comparator<Footballeur>() {
        @Override
        public int compare(Footballeur f1, Footballeur f2) {
            return f2.getNom().compareTo(f1.getNom());
        }
    };

    public static Comparator<Footballeur> presidentNameAscendingComparator = new Comparator<Footballeur>() {
        @Override
        public int compare(Footballeur f1, Footballeur f2) {
            return f1.getDateNaissance() - f2.getDateNaissance();
        }
    };

    public static Comparator<Footballeur> presidentNamedescendingComparator = new Comparator<Footballeur>() {
        @Override
        public int compare(Footballeur f1, Footballeur f2) {
            return f2.getDateNaissance() - f1.getDateNaissance();
        }
    };

    @Override
    public String toString() {
        return "Footballeur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", imageURl='" + imageURl + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(int dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getImageURl() {
        return imageURl;
    }

    public void setImageURl(String imageURl) {
        this.imageURl = imageURl;
    }
}
