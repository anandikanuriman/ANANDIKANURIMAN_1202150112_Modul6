package com.example.anandika.anandikanuriman_1202150112_modul6;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Anandika on 01/04/2018.
 */
@IgnoreExtraProperties
public class databasecomment {
    String sikomen, komen, fotokomen;

    public databasecomment(){

    }
    public databasecomment(String sikomen, String komen, String fotokomen){
        this.sikomen = sikomen;
        this.komen = komen;
        this.fotokomen = fotokomen;
    }

    public String getSikomen() {
        return sikomen;
    }

    public String getKomen() {
        return komen;
    }

    public String getFotokomen() {
        return fotokomen;
    }
}
