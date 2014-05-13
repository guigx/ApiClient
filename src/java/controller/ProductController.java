/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Exception.ProductException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.SelectableDataModel;
import pojos.DTOItem;
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
    private List<DTOItem> items;
    private boolean cartRendered;
    private int quantity;
    private Product productSelected;
    @Inject
    private Settings sessionBean;

    public ProductController() {
    }

    @PostConstruct
    public void init() {
        selectedProducts = new ArrayList();
        items = new ArrayList();
        cartRendered = false;
        productSelected = new Product();

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

    public Product getProductSelected() {
        return productSelected;
    }

    public void setProductSelected(Product productSelected) {
        this.productSelected = productSelected;
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

    public void addToCart() {

        DTOItem item = new DTOItem();
        item.setProductId(productSelected.getId());
        item.setName(productSelected.getBrand() + " - " + productSelected.getModel());
        item.setQuantity(quantity);
        items.add(item);
        cartRendered = true;
    }

    public void finishOrder() {

        sessionBean.getApiService().makeOrder(items, sessionBean.getApiKey());
        items.clear();
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
