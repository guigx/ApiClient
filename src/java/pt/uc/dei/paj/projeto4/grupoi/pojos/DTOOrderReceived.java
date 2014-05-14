/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.paj.projeto4.grupoi.pojos;

public class DTOOrderReceived {

    private Long id;

    private String orderDate;

    private String deliveryDate;

    private DTOClient client;

    public DTOOrderReceived() {
    }

    public DTOOrderReceived(Long id, String orderDate, String deliveryDate, DTOClient client) {
        this.id = id;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public DTOClient getClient() {
        return client;
    }

    public void setClient(DTOClient client) {
        this.client = client;
    }

}
