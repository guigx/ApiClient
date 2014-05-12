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

    public ProductController() {
    }

    @Inject
    private Settings sessionBean;

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

    @Override
    public Object getRowKey(Product t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product getRowData(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
