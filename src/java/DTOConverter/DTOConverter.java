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
import pojos.DTOClient;
import pojos.DTOItem;
import pojos.DTOOrderItem;
import pojos.DTOOrderReceived;
import pojos.DTOProduct;

/**
 *
 * @author Guilherme Pereira
 */
public class DTOConverter {

    public static List<DTOProduct> convertProductList(List<Soap.Product> productListSoap) throws ParseException {
        List<DTOProduct> productList = new ArrayList<>();
        for (Soap.Product p : productListSoap) {
            DTOProduct newProduct = new DTOProduct();
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

    public static DTOProduct convertProduct(Soap.Product p) {
        DTOProduct newProduct = new DTOProduct();
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

    public static List<DTOOrderReceived> convertOrderList(List<Soap.OrderReceived> orderListSoap) {
        List<DTOOrderReceived> orderList = new ArrayList<>();
        for (Soap.OrderReceived order : orderListSoap) {
            DTOOrderReceived newOrder = new DTOOrderReceived();
            newOrder.setId(order.getId());
            newOrder.setClient(convertClient(order.getClient()));
            newOrder.setDeliveryDate(order.getDeliveryDate());
            newOrder.setOrderDate(order.getOrderDate());
            orderList.add(newOrder);
        }
        return orderList;
    }

    public static DTOOrderReceived convertOrder(Soap.OrderReceived order) {
        DTOOrderReceived newOrder = new DTOOrderReceived();
        newOrder.setId(order.getId());
        newOrder.setClient(convertClient(order.getClient()));
        newOrder.setDeliveryDate(order.getDeliveryDate());
        newOrder.setOrderDate(order.getOrderDate());
        return newOrder;
    }

    public static DTOClient convertClient(Soap.Client client) {
        DTOClient newClient = new DTOClient();
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

    public static List<DTOOrderItem> convertListDtoItemToSoapItems(List<Soap.OrderItems> items) {

        List<DTOOrderItem> newList = new ArrayList();

        for (Soap.OrderItems i : items) {

            DTOOrderItem newItem = new DTOOrderItem();
            newItem.setProductId(i.getProductId());
            newItem.setProductName(i.getProductName());
            newItem.setQuantity(i.getQuantity());
            newItem.setPrice(i.getPrice());
            newList.add(newItem);
        }

        return newList;
    }

    public static List<Soap.OrderItems> convertListSoapItemToDtoItems(List<DTOOrderItem> items) {

        List<Soap.OrderItems> newList = new ArrayList();

        for (DTOOrderItem i : items) {

            Soap.OrderItems newItem = new Soap.OrderItems();
            newItem.setProductId(i.getProductId());
            newItem.setProductName(i.getProductName());
            newItem.setQuantity(i.getQuantity());
            newItem.setPrice(i.getPrice());
            newList.add(newItem);
        }

        return newList;
    }

    public static List<DTOOrderReceived> findOrdersByClientId(List<Soap.OrderReceived> orders) {

        List<DTOOrderReceived> newList = new ArrayList();

        for (Soap.OrderReceived i : orders) {

            DTOClient client = new DTOClient();
            client.setApiKey(i.getClient().getApiKey());
            client.setEmail(i.getClient().getEmail());
            client.setId(i.getClient().getId());
            client.setName(i.getClient().getName());
            client.setPassword(i.getClient().getPassword());

            DTOOrderReceived newItem = new DTOOrderReceived();
            newItem.setClient(client);
            newItem.setId(i.getId());
            newItem.setOrderDate(i.getOrderDate());
            newItem.setDeliveryDate(i.getDeliveryDate());
            newList.add(newItem);
        }

        return newList;
    }
}
