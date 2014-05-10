/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Interface.ApInterface;
import Interface.ApRest;
import java.io.Serializable;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Guilherme Pereira
 */
@SessionScoped
@Stateful
public class Settings implements Serializable {

    String apiKey;
    Boolean isSoap;

    /**
     * Creates a new instance of Settings
     */
    public Settings() {
        this.apiKey = "123";

    }

    public ApInterface getApiService() {
//        if (isSoap) {
//            return new ApSoap();
//        } else {
        return new ApRest();
        //}
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

}
