/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Exception.ProductException;
import java.util.List;
import pojos.DTOItem;
import pojos.DTOOrderItem;
import pojos.DTOOrderReceived;
import pojos.DTOProduct;

/**
 *
 * @author Guilherme Pereira
 */
public interface ApInterface {

    /**
     *
     */
    public List<DTOProduct> findProdutByCategory(String category, double key) throws ProductException;

    public List<DTOProduct> findAllProducts(double key) throws ProductException;

    public List<DTOProduct> findProductByDescription(String description, double key) throws ProductException;

    public List<DTOProduct> findProductByDesignation(String designation, double key) throws ProductException;

    public DTOProduct findProductById(Long id, double key) throws ProductException;

    public String findReplacementDateByProduct(Long id, double key) throws ProductException;

    public int findStockByProduct(Long id, double key) throws ProductException;

    public double login(String email, String password);

    public String makeOrder(List<DTOItem> items, double key);

    public DTOOrderReceived findOrderById(Long id, double key);

    public String orderDeliveryDate(Long id, double key);

    public List<DTOOrderItem> findAllOrderItems(Long id, double key);

    public List<DTOOrderReceived> findOrdersByClientId(double key);

    public String deleteOrderById(Long orderId, double key);

}
