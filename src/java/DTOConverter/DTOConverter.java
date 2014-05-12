/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOConverter;

import java.util.ArrayList;
import java.util.List;
import pojos.Client;
import pojos.Entry;
import pojos.MakeOrder;
import pojos.OrderReceived;
import pojos.Parameter;
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
            newProduct.setId(p.getId());
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
        newProduct.setId(p.getId());
        newProduct.setBrand(p.getBrand());
        newProduct.setCategory(p.getCategory());
        newProduct.setDescription(p.getDescription());
        newProduct.setModel(p.getModel());
        newProduct.setSellPrice(p.getSellPrice());
        newProduct.setVersion(p.getVersion());
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

    public static List<Entry> convertEntryList(List<Soap.MakeOrder.Parameter.Entry> entryListSoap) {
        List<Entry> entryList = new ArrayList<>();
        for (Soap.MakeOrder.Parameter.Entry entry : entryListSoap) {
            Entry newEntry = new Entry();
            newEntry.setKey(entry.getKey());
            newEntry.setValue(entry.getValue());
            entryList.add(newEntry);
        }
        return entryList;
    }

    public static Parameter convertParameter(Soap.MakeOrder.Parameter parameter) {
        Parameter newParameter = new Parameter();
        newParameter.setEntry(convertEntryList(parameter.getEntry()));
        return newParameter;

    }

//        public static Soap.MakeOrder.Parameter convertMap(Map<Long, Integer> map) {
//        Soap.MakeOrder.Parameter newParameterSoap = new Soap.MakeOrder.Parameter();
//        newParameterSoap.s
//        return newParameter;
//
//    }
    public static MakeOrder convertMakeOrder(Soap.MakeOrder makeOrder) {
        MakeOrder newMakeOrder = new MakeOrder();
        newMakeOrder.setKey(makeOrder.getKey());
        newMakeOrder.setParameter(convertParameter(makeOrder.getParameter()));
        return newMakeOrder;
    }
}
