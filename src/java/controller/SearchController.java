package controller;

import Exception.ProductException;
import Interface.ApRest;
import java.util.List;
import javax.enterprise.context.RequestScoped;
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
    public void findProductByCategory() throws ProductException {
        try {
            selectedList = settings.getApiService().findProdutByCategory(search, settings.getApiKey());
        } catch (ProductException ex) {
            throw new ProductException();
        }
    }

    public void findAllProducts() throws ProductException {
        try {
            selectedList = settings.getApiService().findAllProducts(settings.getApiKey());
        } catch (ProductException ex) {
            throw new ProductException();
        }
    }

    public void findProductByDescription() throws ProductException {
        try {
            selectedList = settings.getApiService().findProductByDescription(search, settings.getApiKey());
        } catch (ProductException ex) {
            throw new ProductException();
        }
    }

    public void findProductByDesignation() throws ProductException {
        try {
            selectedList = settings.getApiService().findProductByDesignation(search, settings.getApiKey());
        } catch (ProductException ex) {
            throw new ProductException();
        }
    }

    public void findProductById() throws ProductException {
        Long id = Long.parseLong(search);
        try {
            selectedProduct = settings.getApiService().findProductById(id, settings.getApiKey());
        } catch (ProductException ex) {
//            ex.getMessage();
            //throw new NotFoundException("Product Not Found LOOOL");
            throw new ProductException();
        }
    }

    public void findReplacementDateByProduct() throws ProductException {
        Long id = Long.parseLong(search);
        result = settings.getApiService().findReplacementDateByProduct(id, settings.getApiKey());
    }

    public int findStockByProduct() throws ProductException {
        Long id = Long.parseLong(search);
        return settings.getApiService().findStockByProduct(id, settings.getApiKey());
    }

}
