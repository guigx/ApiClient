/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.paj.projeto4.grupoi.pojos;

/**
 *
 * @author Zueb LDA
 */
public class DTOOrderItem {

    private Long productId;
    private Long orderReceivedId;
    private String productName;
    private int quantity;
    private double price;

    public DTOOrderItem() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getOrderReceivedId() {
        return orderReceivedId;
    }

    public void setOrderReceivedId(Long orderReceivedId) {
        this.orderReceivedId = orderReceivedId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
