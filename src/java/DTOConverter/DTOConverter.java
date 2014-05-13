/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import pojos.Client;
import pojos.DTOItem;
import pojos.OrderReceived;
import pojos.Product;

/**
 *
 * @author Guilherme Pereira
 */
public class DTOConverter {

    public static List<Product> convertProductList(List<Soap.Product> productListSoap) throws ParseException {
        List<Product> productList = new ArrayList<>();
        for (Soap.Product p : productListSoap) {
            Product newProduct = new Product();
            newProduct.setId(p.getId());
            newProduct.setBrand(p.getBrand());
            newProduct.setCategory(p.getCategory());
            newProduct.setDescription(p.getDescription());
            newProduct.setModel(p.getModel());
            newProduct.setSellPrice(p.getSellPrice());
            newProduct.setVersion(p.getVersion());
            newProduct.setStockQtt(p.getStockQtt());

            SimpleDateFormat dt1 = new SimpleDateFormat("dd-MM-yyyy");

            newProduct.setRepoDate(dt1.format(p.getRepoDate().toGregorianCalendar().getTime()));
            productList.add(newProduct);
        }
        return productList;
    }

    public static Product convertProduct(Soap.Product p) {
        Product newProduct = new Product();
        newProduct.setId(p.getId());
        newProduct.setBrand(p.getBrand());
        newProduct.setCategory(p.getCategory());
        newProduct.setDescription(p.getDescription());
        newProduct.setModel(p.getModel());
        newProduct.setSellPrice(p.getSellPrice());
        newProduct.setVersion(p.getVersion());
        SimpleDateFormat dt1 = new SimpleDateFormat("dd-MM-yyyy");
        newProduct.setRepoDate(dt1.format(p.getRepoDate().toGregorianCalendar().getTime()));
        newProduct.setStockQtt(p.getStockQtt());
        return newProduct;
    }

    public static List<OrderReceived> convertOrderList(List<Soap.OrderReceived> orderListSoap) {
        List<OrderReceived> orderList = new ArrayList<>();
        for (Soap.OrderReceived order : orderListSoap) {
            OrderReceived newOrder = new OrderReceived();
            newOrder.setId(order.getId());
            newOrder.setClient(convertClient(order.getClient()));
            newOrder.setDeliveryDate(order.getDeliveryDate());
            newOrder.setOrderDate(order.getOrderDate());
            orderList.add(newOrder);
        }
        return orderList;
    }

    public static OrderReceived convertOrder(Soap.OrderReceived order) {
        OrderReceived newOrder = new OrderReceived();
        newOrder.setId(order.getId());
        newOrder.setClient(convertClient(order.getClient()));
        newOrder.setDeliveryDate(order.getDeliveryDate());
        newOrder.setOrderDate(order.getOrderDate());
        return newOrder;
    }

    public static Client convertClient(Soap.Client client) {
        Client newClient = new Client();
        newClient.setId(client.getId());
        newClient.setApiKey(client.getApiKey());
        newClient.setEmail(client.getEmail());
        newClient.setName(client.getName());
        newClient.setPassword(client.getPassword());
        return newClient;
    }

    public static DTOItem convertItem(Soap.Item item) {
        DTOItem newItem = new DTOItem();
        newItem.setProductId(item.getProductId());
        newItem.setName(item.getName());
        newItem.setQuantity(item.getQuantity());
        newItem.setPrice(item.getQuantity() * item.getPrice());
        return newItem;

    }

    public static Soap.Item convertItemSoap(DTOItem item) {
        Soap.Item newItem = new Soap.Item();
        newItem.setProductId(item.getProductId());
        newItem.setName(item.getName());
        newItem.setQuantity(item.getQuantity());
        newItem.setPrice(item.getQuantity() * item.getPrice());
        return newItem;

    }

    public static List<Soap.Item> convertListItemSoap(List<DTOItem> items) {

        List<Soap.Item> newList = new ArrayList();

        for (DTOItem i : items) {

            Soap.Item newItem = new Soap.Item();
            newItem.setProductId(i.getProductId());
            newItem.setName(i.getName());
            newItem.setQuantity(i.getQuantity());
            newItem.setPrice((i.getPrice() * i.getQuantity()));
            newList.add(newItem);
        }

        return newList;
    }
}
