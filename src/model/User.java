/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.mysql.MySQLQuery;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utilisateur de l'application Cookie Swipe Peut être un singleton ?
 *
 * @author Mary
 */
public class User {

    //Variable membre
    private int id;
    private String loginAdressMail, password;
    private boolean administrator;

    //Constrcuteur
    /**
     * Constructeur par defaut
     */
    public User() {

    }

    /**
     * Constructeur à utiliser lors de la connexion à un compte ou sa création.
     *
     * @param loginAdressMail login de connexion du compte
     * @param password mot de passe de connexion du compte
     * @param administrator Status de l'utilisateur
     */
    public User(String loginAdressMail, String password, boolean administrator) {
        this.loginAdressMail = loginAdressMail;
        this.administrator = administrator;
        try {
            this.password = new Encryption().encrypt(password);
        } catch (Exception ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            this.password = "";
        }

    }

    //Fonction membre publique
    /**
     * Sert à créer un utilisateur dans le registre CS
     *
     * @return l'utilisateur créé
     */
    public int create() {
        return MySQLQuery.createUser(this);
    }

    /**
     * Sert à connecter un utilisateur à l'application CS
     *
     * @return Utilisateur connecté
     */
    public int connect() {
        return MySQLQuery.connectUser(this);
    }

    /**
     * Renvoie toutes les données de l'utilisateur
     *
     * @return table de hash contenant toutes les données utilisateur
     */
    public HashMap<String, Object> getData() {
        return null;
    }

    /**
     * Change les informations utilisateur (A mettre en hashmap)
     *
     * @param data table de hash contenant toute les données utilisateur
     * @return Si la mise à jour des données à été correct
     */
    public boolean updateData(HashMap<String, Object> data) {
        return false;
    }

    /**
     * *
     * Ajoute un compte courriel au préférence de l'utilisateur
     *
     * @param newMailAccount compte courriel à ajouter
     * @return Si le compte courriel à bien été ajouté
     */
    //Getter & setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginAdressMail() {
        return loginAdressMail;
    }

    public void setLoginAdressMail(String loginAdressMail) {
        this.loginAdressMail = loginAdressMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        try {
            this.password = new Encryption().encrypt(password);
        } catch (Exception ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setAdministrator(boolean administrator){
        this.administrator = administrator;
    }
    
    public boolean isAdministrator(){
        return administrator;
    }

    //equals & hashcode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", loginAdressMail=" + loginAdressMail + ", password=" + password + ", administrator=" + administrator;
    }

}
