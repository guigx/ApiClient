/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Exception.ProductException;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import pojos.Product;

/**
 * Jersey REST client generated for REST resource:ProductFacadeREST
 * [/product]<br>
 * USAGE:
 * <pre>
 *        ApRest client = new ApRest();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Guilherme Pereira
 */
public class ApRest implements ApInterface {

    private WebTarget webTargetProduct;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/TecnoApi/webresources";

    public ApRest() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTargetProduct = client.target(BASE_URI).path("product");
    }

    @Override
    public List<Product> findProdutByCategory(String category) throws ProductException {
        WebTarget resource = webTargetProduct;
        resource = resource.path(java.text.MessageFormat.format("category/{0}", new Object[]{category}));
        List<Product> productList = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<Product>>() {
        });
        if (productList.isEmpty()) {
            throw new ProductException();
        }
        return productList;

    }

    @Override
    public List<Product> findAllProducts() throws ProductException {
        WebTarget resource = webTargetProduct;
        List<Product> productList = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<Product>>() {
        });
        if (productList.isEmpty()) {
            throw new ProductException();
        }
        return productList;

    }

    @Override
    public List<Product> findProductByDescription(String description) throws ProductException {
        WebTarget resource = webTargetProduct;
        resource = resource.path(java.text.MessageFormat.format("description/{0}", new Object[]{description}));
        List<Product> productList = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<Product>>() {
        });
        if (productList.isEmpty()) {
            throw new ProductException();
        }
        return productList;
    }

    @Override
    public List<Product> findProductByDesignation(String designation) throws ProductException {
        WebTarget resource = webTargetProduct;
        resource = resource.path(java.text.MessageFormat.format("designation/{0}", new Object[]{designation}));
        List<Product> productList = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<Product>>() {
        });
        if (productList.isEmpty()) {
            throw new ProductException();
        }
        return productList;
    }

    @Override
    public Product findProductById(Long id) throws ProductException {
        WebTarget resource = webTargetProduct;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        Product p = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(Product.class);
        if (p == null) {
            throw new ProductException();
        }
        return p;
    }

    @Override
    public String findReplacementDateByProduct(Long id) {
        WebTarget resource = webTargetProduct;
        resource = resource.path(java.text.MessageFormat.format("replacement-Date/{0}", new Object[]{id}));
        String date = resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(new GenericType<String>() {
        });
        return date;
    }

    @Override
    public int findStockByProduct(Long id) {
        WebTarget resource = webTargetProduct;
        resource = resource.path(java.text.MessageFormat.format("stock/{0}", new Object[]{id}));
        int stock = resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(new GenericType<Integer>() {
        });
        return stock;
    }

    public void close() {
        client.close();
    }
}
