/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Interface.ApInterface;
import Interface.ApSoap;
import java.io.Serializable;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Guilherme Pereira
 */
@Stateful
@SessionScoped
public class Settings implements Serializable {

    double apiKey;
    Boolean isSoap;

    /**
     * Creates a new instance of Settings
     */
    public Settings() {

    }

    public ApInterface getApiService() {
//        if (isSoap) {
        return new ApSoap();
//        } else {
//        return new ApRest();
//        }
    }

    public double getApiKey() {
        return apiKey;
    }

    public void setApiKey(double apiKey) {
        this.apiKey = apiKey;
    }

}
