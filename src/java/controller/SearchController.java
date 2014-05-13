package controller;

import Exception.ProductException;
import Interface.ApRest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pojos.DTOProduct;

@Named
@ViewScoped
public class SearchController implements Serializable {

    String result;
    List<DTOProduct> selectedList;
    DTOProduct selectedProduct;

    private String search;
    private int choice;

    @Inject
    Settings settings;
    ApRest apir;

    //Getter´s and Setter´s
    public DTOProduct getSelectedProduct() {
        return selectedProduct;
    }

    @PostConstruct
    public void init() {

        selectedList = new ArrayList();
    }

    public void setSelectedProduct(DTOProduct selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public List<DTOProduct> getSelectedList() {
        return selectedList;
    }

    public void setSelectedList(List<DTOProduct> selectedList) {
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

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
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
        try {
            Long id = Long.parseLong(search);
            selectedProduct = settings.getApiService().findProductById(id, settings.getApiKey());

            selectedList.clear();

            selectedList.add(selectedProduct);

        } catch (ProductException ex) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Product Not Found"));
        } catch (NumberFormatException e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Just numbers please"));
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

    /**
     *
     */
    public void searchMethod() {

        try {
            switch (choice) {

                case 1:
                    findProductByDesignation();
                    break;
                case 2:
                    findProductByDescription();
                    break;
                case 3:
                    findProductByCategory();
                    break;
                case 4:
                    findProductById();
                    break;
            }
        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Just numbers please"));
        }

    }

}
