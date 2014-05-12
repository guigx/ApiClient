/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOConverter;

import java.util.ArrayList;
import java.util.List;
import pojos.Product;

/**
 *
 * @author Guilherme Pereira
 */
public class DTOConverter {

    public static List<Product> convertProductList(List<Soap.Product> productListSoap) {
        List<Product> productList = new ArrayList<>();
        for (Soap.Product p : productListSoap) {
            Product newProduct = new Product();
            newProduct.setBrand(p.getBrand());
            newProduct.setCategory(p.getCategory());
            newProduct.setDescription(p.getDescription());
            newProduct.setModel(p.getModel());
            newProduct.setSellPrice(p.getSellPrice());
            newProduct.setVersion(p.getVersion());
            newProduct.setStockQtt(p.getStockQtt());
            productList.add(newProduct);
        }
        return productList;
    }

    public static Product convertProduct(Soap.Product p) {
        Product newProduct = new Product();
        newProduct.setBrand(p.getBrand());
        newProduct.setCategory(p.getCategory());
        newProduct.setDescription(p.getDescription());
        newProduct.setModel(p.getModel());
        newProduct.setSellPrice(p.getSellPrice());
        newProduct.setVersion(p.getVersion());
        newProduct.setStockQtt(p.getStockQtt());
        return newProduct;
    }
}
