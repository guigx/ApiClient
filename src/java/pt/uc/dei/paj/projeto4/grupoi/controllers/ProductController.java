/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.paj.projeto4.grupoi.controllers;

import pt.uc.dei.paj.projeto4.grupoi.exceptions.ProductException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.SelectableDataModel;
import pt.uc.dei.paj.projeto4.grupoi.pojos.DTOItem;
import pt.uc.dei.paj.projeto4.grupoi.pojos.DTOProduct;

/**
 *
 * @author Zueb LDA
 */
@Named
@ViewScoped
public class ProductController implements Serializable, SelectableDataModel<DTOProduct> {

    private static final long serialVersionUID = 1L;
    private List<DTOProduct> selectedProducts;
    private List<DTOItem> items;
    private boolean cartRendered;
    private int quantity;
    private DTOProduct productSelected;
    private DTOItem itemSelected;
    private double totalPrice;
    @Inject
    private Settings sessionBean;

    public ProductController() {
    }

    @PostConstruct
    public void init() {
        selectedProducts = new ArrayList();
        items = new ArrayList();
        cartRendered = false;
        productSelected = new DTOProduct();

    }

    //Getter´s and Setter´s
    public Settings getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(Settings sessionBean) {
        this.sessionBean = sessionBean;
    }

    public List<DTOProduct> getSelectedProducts() {
        return selectedProducts;
    }

    public void setSelectedProducts(List<DTOProduct> selectedProducts) {
        this.selectedProducts = selectedProducts;
    }

    public boolean isCartRendered() {
        return cartRendered;
    }

    public void setCartRendered(boolean cartRendered) {
        this.cartRendered = cartRendered;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<DTOItem> getItems() {
        return items;
    }

    public void setItems(List<DTOItem> items) {
        this.items = items;
    }

    public DTOProduct getProductSelected() {
        return productSelected;
    }

    public void setProductSelected(DTOProduct productSelected) {
        this.productSelected = productSelected;
    }

    public double getTotalPrice() {
        for (DTOItem i : items) {

            totalPrice += i.getPrice();
        }
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public DTOItem getItemSelected() {
        return itemSelected;
    }

    public void setItemSelected(DTOItem itemSelected) {
        this.itemSelected = itemSelected;
    }

    /**
     * Return all products in database.
     *
     * @return
     */
    public List<DTOProduct> allProducts() {
        try {
            return sessionBean.getApiService().findAllProducts(sessionBean.getApiKey());
        } catch (ProductException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }

    public void addToCart() {

        DTOItem item = new DTOItem();
        item.setProductId(productSelected.getId());
        item.setName(productSelected.getBrand() + " - " + productSelected.getModel());
        item.setQuantity(quantity);
        items.add(item);
        cartRendered = true;
    }

    public void finishOrder() {

        String s = sessionBean.getApiService().makeOrder(items, sessionBean.getApiKey());
        if (s.equalsIgnoreCase("Order not created")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Order not completed"));
        } else if (items.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Please choose some items to order"));
        } else {
            items.clear();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Order Successfuly completed"));
        }

    }

    public void clearOrder() {

        items.clear();
    }

    public void deleteFromOrder() {

        items.remove(itemSelected);
    }

    @Override
    public Object getRowKey(DTOProduct t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DTOProduct getRowData(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
