/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import util.Encrypt;

/**
 *
 * @author Zueb LDA
 */
@Named
@RequestScoped
public class UserController {

    /**
     * Creates a new instance of UserController
     */
    public UserController() {
    }

    private String email;
    private String password;
    @Inject
    private Settings sessionBean;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Settings getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(Settings sessionBean) {
        this.sessionBean = sessionBean;
    }

    public String makeLogin() {
        String passEncripted = Encrypt.cryptWithMD5(password);
        double key = sessionBean.getApiService().login(email, passEncripted);
        sessionBean.apiKey = key;
        return "allProducts";
    }

}
