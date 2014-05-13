/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pojos.DTOOrderReceived;

/**
 *
 * @author Zueb LDA
 */
@Named
@ViewScoped
public class OrderController {

    @Inject
    private Settings sessionBean;
    private Long orderSelected;

    public OrderController() {
    }

    //Getter´s and Setter´s
    public Settings getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(Settings sessionBean) {
        this.sessionBean = sessionBean;
    }

    public Long getOrderSelected() {
        return orderSelected;
    }

    public void setOrderSelected(Long orderSelected) {
        this.orderSelected = orderSelected;
    }

    //Methods
    /**
     * Return order history
     *
     * @return List<DTOOrderREceived>
     */
    public List<DTOOrderReceived> allOrders() {

        return sessionBean.getApiService().findAllOrders(sessionBean.getApiKey());
    }
}
