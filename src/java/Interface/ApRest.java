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
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import pojos.DTOItem;
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
    private WebTarget webTargetClient;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/TecnoApi/webresources";

    public ApRest() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTargetProduct = client.target(BASE_URI).path("product");
        webTargetOrder = client.target(BASE_URI).path("orderreceived");
        webTargetClient = client.target(BASE_URI).path("client");
    }

    @Override
    public List<DTOProduct> findProdutByCategory(String category, double key) throws ProductException {
        WebTarget resource = webTargetProduct;
        resource = resource.path(java.text.MessageFormat.format("category/{0}", new Object[]{category}));
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
        resource = resource.path(java.text.MessageFormat.format("description/{0}", new Object[]{description}));
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
        resource = resource.path(java.text.MessageFormat.format("designation/{0}", new Object[]{designation}));
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
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        DTOProduct p = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).header("key", key).get(DTOProduct.class);
        if (p == null) {
            throw new ProductException();
        }
        return p;
    }

    @Override
    public String findReplacementDateByProduct(Long id, double key) throws ProductException {
        WebTarget resource = webTargetProduct;
        resource = resource.path(java.text.MessageFormat.format("replacement-Date/{0}", new Object[]{id}));
        String date = resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).header("key", key).get(new GenericType<String>() {
        });
        return date;
    }

    @Override
    public int findStockByProduct(Long id, double key) throws ProductException {
        WebTarget resource = webTargetProduct;
        resource = resource.path(java.text.MessageFormat.format("stock/{0}", new Object[]{id}));
        int stock = resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).header("key", key).get(new GenericType<Integer>() {
        });
        return stock;
    }

    @Override
    public double login(String email, String password) {
        WebTarget resource = webTargetClient;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{email}));
        double key = resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).header("password", password).get(new GenericType<Double>() {
        });
        return key;
    }

    @Override
    public String orderDeliveryDate(Long id, double key) {
        WebTarget resource = webTargetOrder;
        resource = resource.path(java.text.MessageFormat.format("stock/{0}", new Object[]{id}));
        String deliveryDate = resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).header("key", key).get(new GenericType<String>() {
        });
        return deliveryDate;
    }

    @Override
    public String makeOrder(List<DTOItem> items, double Key) {
        //String json= new Gson().toJson(map);
        return webTargetOrder.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(items, javax.ws.rs.core.MediaType.APPLICATION_JSON), String.class);
    }

    @Override
    public DTOOrderReceived findOrderById(Long id, double key) {
        WebTarget resource = webTargetOrder;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        DTOOrderReceived order = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).header("key", key).get(DTOOrderReceived.class);
        return order;
    }

    @Override
    public List<DTOOrderReceived> findAllOrders(double key) {
        WebTarget resource = webTargetOrder;
        List<DTOOrderReceived> ordertList = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).header("key", key).get(new GenericType<List<DTOOrderReceived>>() {
        });
        return ordertList;

    }

    public void close() {
        client.close();
    }

    @Override
    public List<DTOItem> findAllOrderItems(Long id, double key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
