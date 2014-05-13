/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pojos.DTOOrderItem;
import pojos.DTOOrderReceived;

/**
 *
 * @author Zueb LDA
 */
@Named
@ViewScoped
public class OrderController implements Serializable {

    @Inject
    private Settings sessionBean;
    private Long orderSelected;
    private double totalOrderPrice;
    private boolean popRender;

    public OrderController() {
    }

    @PostConstruct
    public void init() {

        popRender = false;
        orderSelected = 0L;
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

    public double getTotalOrderPrice() {
        return totalOrderPrice;
    }

    public void setTotalOrderPrice(double totalOrderPrice) {
        this.totalOrderPrice = totalOrderPrice;
    }

    public boolean isPopRender() {
        return popRender;
    }

    public void setPopRender(boolean popRender) {
        this.popRender = popRender;
    }

    //Methods
    /**
     * Return order history
     *
     * @return List<DTOOrderREceived>
     */
    public List<DTOOrderReceived> allOrders() {

        return sessionBean.getApiService().findOrdersByClientId(sessionBean.getApiKey());
    }

    public List<DTOOrderItem> allOrderItems() {
        popRender = true;

        List<DTOOrderItem> list = sessionBean.getApiService().findAllOrderItems(orderSelected, sessionBean.getApiKey());

        for (DTOOrderItem it : list) {

            totalOrderPrice += it.getPrice();
        }
        return list;
    }

}
