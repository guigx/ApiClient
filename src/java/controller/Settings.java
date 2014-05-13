/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Interface.ApInterface;
import Interface.ApRest;
import Interface.ApSoap;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Guilherme Pereira
 */
@Named

@SessionScoped
public class Settings implements Serializable {

    double apiKey;
    boolean isSoap;

    public Settings() {
        this.isSoap = true;
    }

    /**
     * Creates a new instance of Settings
     */
    public ApInterface getApiService() {
        if (isSoap) {
            return new ApSoap();
        } else {
            return new ApRest();
        }
    }

    public boolean isIsSoap() {
        return isSoap;
    }

    public void setIsSoap(boolean isSoap) {
        this.isSoap = isSoap;
    }

    public double getApiKey() {
        return apiKey;
    }

    public void setApiKey(double apiKey) {
        this.apiKey = apiKey;
    }

}
