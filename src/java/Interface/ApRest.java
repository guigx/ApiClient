/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Exception.ProductException;
import controller.Settings;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.GenericType;
import pojos.DTOItem;
import pojos.DTOOrderItem;
import pojos.DTOOrderReceived;
import pojos.DTOProduct;

/**
 * Jersey REST client generated for REST resource:DTOProductFacadeREST
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

    Settings settings;
    private WebTarget webTargetProduct;
    private WebTarget webTargetOrder;
    private WebTarget webTargetOrderItem;
    private WebTarget webTargetClient;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/TecnoApi/webresources";

    public ApRest() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTargetProduct = client.target(BASE_URI).path("product");
        webTargetOrder = client.target(BASE_URI).path("orderreceived");
        webTargetClient = client.target(BASE_URI).path("client");
        webTargetOrderItem = client.target(BASE_URI).path("orderitems");
    }

    @Override
    public List<DTOProduct> findProdutByCategory(String category, double key) throws ProductException {
        WebTarget resource = webTargetProduct;
        resource = resource.queryParam("category", category);
        List<DTOProduct> productList = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).header("key", key).get(new GenericType<List<DTOProduct>>() {
        });
        if (productList.isEmpty()) {
            throw new ProductException();
        }
        return productList;

    }

    @Override
    public List<DTOProduct> findAllProducts(double key) throws ProductException {
        WebTarget resource = webTargetProduct;
        List<DTOProduct> productList = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).header("key", key).get(new GenericType<List<DTOProduct>>() {
        });
        if (productList.isEmpty()) {
            throw new ProductException();
        }
        return productList;

    }

    @Override
    public List<DTOProduct> findProductByDescription(String description, double key) throws ProductException {
        WebTarget resource = webTargetProduct;
        resource = resource.queryParam("description", description);
        List<DTOProduct> productList = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).header("key", key).get(new GenericType<List<DTOProduct>>() {
        });
        if (productList.isEmpty()) {
            throw new ProductException();
        }
        return productList;
    }

    @Override
    public List<DTOProduct> findProductByDesignation(String designation, double key) throws ProductException {
        WebTarget resource = webTargetProduct;
        resource = resource.queryParam("designation", designation);
        List<DTOProduct> productList = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).header("key", key).get(new GenericType<List<DTOProduct>>() {
        });
        if (productList.isEmpty()) {
            throw new ProductException();
        }
        return productList;
    }

    @Override
    public DTOProduct findProductById(Long id, double key) throws ProductException {
        WebTarget resource = webTargetProduct;
        resource = resource.path(java.text.MessageFormat.format("{0}", id.toString()));
        DTOProduct p = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).header("key", key).get(DTOProduct.class);
        if (p == null) {
            throw new ProductException();
        }
        return p;
    }

    @Override
    public String findReplacementDateByProduct(Long id, double key) throws ProductException {
        WebTarget resource = webTargetProduct;
        resource = resource.path(java.text.MessageFormat.format("replacement-Date/{0}", id.toString()));
        String date = resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).header("key", key).get(new GenericType<String>() {
        });
        return date;
    }

    @Override
    public int findStockByProduct(Long id, double key) throws ProductException {
        WebTarget resource = webTargetProduct;
        resource = resource.path(java.text.MessageFormat.format("stock/{0}", id.toString()));
        int stock = resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).header("key", key).get(new GenericType<Integer>() {
        });
        return stock;
    }

    @Override
    public double login(String email, String password) {
        WebTarget resource = webTargetClient;
        double key = resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).header("password", password).header("email", email).get(new GenericType<Double>() {
        });
        return key;
    }

    @Override
    public String orderDeliveryDate(Long id, double key) {
        WebTarget resource = webTargetOrder;
        resource = resource.path(java.text.MessageFormat.format("stock/{0}", id.toString()));
        String deliveryDate = resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).header("key", key).get(new GenericType<String>() {
        });
        return deliveryDate;
    }

    @Override
    public String makeOrder(List<DTOItem> items, double key) {
        GenericEntity<List<DTOItem>> entity = new GenericEntity<List<DTOItem>>(items) {
        };
        return webTargetOrder.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).header("key", key)
                .post(Entity.entity(entity, javax.ws.rs.core.MediaType.APPLICATION_JSON), String.class);
    }

    @Override
    public void editOrder(Long orderId, List<DTOOrderItem> newList, double key) {
        GenericEntity<List<DTOOrderItem>> entity = new GenericEntity<List<DTOOrderItem>>(newList) {
        };
        WebTarget resource = webTargetOrderItem;
        resource = resource.path(java.text.MessageFormat.format("{0}", orderId.toString()));
        resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).header("key", key)
                .put(Entity.entity(entity, javax.ws.rs.core.MediaType.APPLICATION_JSON), String.class);
    }

    @Override
    public DTOOrderReceived findOrderById(Long id, double key) {
        WebTarget resource = webTargetOrder;
        resource = resource.path(java.text.MessageFormat.format("{0}", id.toString()));
        DTOOrderReceived order = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).header("key", key).get(DTOOrderReceived.class);
        return order;
    }

    public void close() {
        client.close();
    }

    @Override
    public List<DTOOrderItem> findAllOrderItems(Long id, double key) {
        WebTarget resource = webTargetOrderItem;
        resource = resource.path(java.text.MessageFormat.format("{0}", id.toString()));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).header("key", key).get(new GenericType<List<DTOOrderItem>>() {
        });
    }

    @Override
    public List<DTOOrderReceived> findOrdersByClientId(double key) {
        WebTarget resource = webTargetOrder;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).header("key", key).get(new GenericType<List<DTOOrderReceived>>() {
        });
    }

    @Override
    public String deleteOrderById(Long orderId, double key) {
        WebTarget resource = webTargetOrder;
        return resource.path(java.text.MessageFormat.format("{0}", orderId.toString())).request().header("key", key).delete(String.class);
    }

}
