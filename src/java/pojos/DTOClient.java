/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import java.util.List;

/**
 *
 * @author Zueb LDA
 */
public class DTOClient {

    private Long id;

    private String name;

    private String email;

    private String password;

    private double apiKey;

    private List<DTOOrderReceived> orders;

    public DTOClient() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getApiKey() {
        return apiKey;
    }

    public void setApiKey(double apiKey) {
        this.apiKey = apiKey;
    }

    public List<DTOOrderReceived> getOrders() {
        return orders;
    }

    public void setOrders(List<DTOOrderReceived> orders) {
        this.orders = orders;
    }

}
