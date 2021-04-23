/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.entity;

import java.sql.Date;

/**
 *
 * @author Akram
 */
public class Mission {

    private int id;
    private int societeId;
    private String nom;
    private String description;
    private Date date;
    private int nombreHeures;
    private float prixHeure;

    public Mission(int id, int societeId, String nom, String description, Date date, int nombreHeures, float prixHeure) {
        this.id = id;
        this.societeId = societeId;
        this.nom = nom;
        this.description = description;
        this.date = date;
        this.nombreHeures = nombreHeures;
        this.prixHeure = prixHeure;
    }

    public Mission(int societeId, String nom, String description, Date date, int nombreHeures, float prixHeure) {
        this.societeId = societeId;
        this.nom = nom;
        this.description = description;
        this.date = date;
        this.nombreHeures = nombreHeures;
        this.prixHeure = prixHeure;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSocieteId() {
        return societeId;
    }

    public void setSocieteId(int societeId) {
        this.societeId = societeId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNombreHeures() {
        return nombreHeures;
    }

    public void setNombreHeures(int nombreHeures) {
        this.nombreHeures = nombreHeures;
    }

    public float getPrixHeure() {
        return prixHeure;
    }

    public void setPrixHeure(float prixHeure) {
        this.prixHeure = prixHeure;
    }

}
