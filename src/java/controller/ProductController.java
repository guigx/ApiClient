/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Exception.ProductException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.SelectableDataModel;
import pojos.Product;

/**
 *
 * @author Zueb LDA
 */
@Named
@ViewScoped
public class ProductController implements Serializable, SelectableDataModel<Product> {

    private static final long serialVersionUID = 1L;
    private List<Product> selectedProducts;
    private List<Product> cart;
    private List<Integer> qtts;
    private boolean cartRendered;
    private int quantity;
    @Inject
    private Settings sessionBean;

    public ProductController() {
    }

    @PostConstruct
    public void init() {
        selectedProducts = new ArrayList();
        cart = new ArrayList();
        qtts = new ArrayList();
        cartRendered = false;

    }

    //Getter´s and Setter´s
    public Settings getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(Settings sessionBean) {
        this.sessionBean = sessionBean;
    }

    public List<Product> getSelectedProducts() {
        return selectedProducts;
    }

    public void setSelectedProducts(List<Product> selectedProducts) {
        this.selectedProducts = selectedProducts;
    }

    public List<Product> getCart() {
        return cart;
    }

    public void setCart(List<Product> cart) {
        this.cart = cart;
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

    public List<Integer> getQtts() {
        return qtts;
    }

    public void setQtts(List<Integer> qtts) {
        this.qtts = qtts;
    }

    /**
     * Return all products in database.
     *
     * @return
     */
    public List<Product> allProducts() {
        try {
            return sessionBean.getApiService().findAllProducts(sessionBean.getApiKey());
        } catch (ProductException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }

    public void addToCart(Product p) {

        cart.add(p);
        qtts.add(quantity);
        cartRendered = true;
    }

    public void finishOrder() {

        Map<Long, Integer> m = new HashMap();

        for (int i = 0; i < cart.size(); i++) {

            m.put(cart.get(i).getId(), qtts.get(i));
        }

        sessionBean.getApiService().makeOrder(m, sessionBean.getApiKey());
    }

    @Override
    public Object getRowKey(Product t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product getRowData(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
