/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;
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
    private int itemQuantity;
    private List<DTOOrderItem> editableList;
    private static final long serialVersionUID = 1L;

    public OrderController() {
    }

    @PostConstruct
    public void init() {

        popRender = false;
        orderSelected = 0L;
        editableList = new ArrayList();
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

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public List<DTOOrderItem> getEditableList() {
        return editableList;
    }

    public void setEditableList(List<DTOOrderItem> editableList) {
        this.editableList = editableList;
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

    /**
     *
     * @return
     */
    public List<DTOOrderItem> allOrderItems() {
        popRender = true;
        totalOrderPrice = 0.0;

        List<DTOOrderItem> list = sessionBean.getApiService().findAllOrderItems(orderSelected, sessionBean.getApiKey());
        editableList = list;

        for (DTOOrderItem it : list) {

            totalOrderPrice += it.getPrice();
        }
        return list;
    }

    public void deleteOrder() {

        String s = sessionBean.getApiService().deleteOrderById(orderSelected, sessionBean.getApiKey());

        if (s.equals("Deleted")) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Order Successfuly Deleted"));
        } else {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Order NOT DELETED"));
        }

        //return "allProducts";
    }

    public void onEdit(RowEditEvent event) {
        DTOOrderItem item = (DTOOrderItem) event.getObject();
        editableList.get(editableList.indexOf(item)).setQuantity(item.getQuantity());

    }

    public void onCancel(RowEditEvent event) {
        //FacesMessage msg = new FacesMessage("Car Cancelled", ((Car) event.getObject()).getModel());

        //FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void editOrder() {

        sessionBean.getApiService().editOrder(orderSelected, editableList, sessionBean.apiKey);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Order Successfuly Edited"));
    }

}
