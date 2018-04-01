package com.example.anandika.anandikanuriman_1202150112_modul6;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Anandika on 01/04/2018.
 */
@IgnoreExtraProperties
public class databasepost {
    String image, judul, caption, user, key;

    public databasepost(){

    }
    public databasepost(String caption, String image, String judul, String user ){
        this.image = image;
        this.judul = judul;
        this.caption = caption;
        this.user = user;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getImage() {
        return image;
    }

    public String getJudul() {
        return judul;
    }

    public String getCaption() {
        return caption;
    }

    public String getUser() {
        return user;
    }

    public String getKey() {
        return key;
    }
}
