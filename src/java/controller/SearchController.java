package controller;

import Exception.ProductException;
import Interface.ApRest;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import pojos.Product;

@Named
@RequestScoped
public class SearchController {

    String result;
    List<Product> selectedList;
    Product selectedProduct;

    private String search;

    @Inject
    Settings settings;
    ApRest apir;

    //Getter´s and Setter´s
    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public List<Product> getSelectedList() {
        return selectedList;
    }

    public void setSelectedList(List<Product> selectedList) {
        this.selectedList = selectedList;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    //Methods
    public void findProductByCategory() {
        try {
            selectedList = settings.getApiService().findProdutByCategory(search, settings.getApiKey());
        } catch (ProductException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Product Not Found"));
        }
    }

    public void findAllProducts() {
        try {
            selectedList = settings.getApiService().findAllProducts(settings.getApiKey());
        } catch (ProductException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Product Not Found"));
        }
    }

    public void findProductByDescription() {
        try {
            selectedList = settings.getApiService().findProductByDescription(search, settings.getApiKey());
        } catch (ProductException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Product Not Found"));
        }
    }

    public void findProductByDesignation() {
        try {
            selectedList = settings.getApiService().findProductByDesignation(search, settings.getApiKey());
        } catch (ProductException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Product Not Found"));
        }
    }

    public void findProductById() {
        Long id = Long.parseLong(search);
        try {
            selectedProduct = settings.getApiService().findProductById(id, settings.getApiKey());
        } catch (ProductException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Product Not Found"));
        }
    }

    public void findReplacementDateByProduct() {
        try {
            Long id = Long.parseLong(search);
            result = settings.getApiService().findReplacementDateByProduct(id, settings.getApiKey());
        } catch (ProductException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Product Not Found"));
        }
    }

    public int findStockByProduct() {
        try {
            Long id = Long.parseLong(search);
            return settings.getApiService().findStockByProduct(id, settings.getApiKey());
        } catch (ProductException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Product Not Found"));
            return 0;
        }
    }

}
