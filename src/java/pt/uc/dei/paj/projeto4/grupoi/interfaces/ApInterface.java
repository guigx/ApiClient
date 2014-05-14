/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.paj.projeto4.grupoi.interfaces;

import pt.uc.dei.paj.projeto4.grupoi.exceptions.ProductException;
import java.util.List;
import pt.uc.dei.paj.projeto4.grupoi.pojos.DTOItem;
import pt.uc.dei.paj.projeto4.grupoi.pojos.DTOOrderItem;
import pt.uc.dei.paj.projeto4.grupoi.pojos.DTOOrderReceived;
import pt.uc.dei.paj.projeto4.grupoi.pojos.DTOProduct;

/**
 *
 * @author Guilherme Pereira
 */
public interface ApInterface {

    /**
     *
     */
    /**
     * Find product by category
     *
     * @param category
     * @param key
     * @return List<DTOProduct>
     * @throws ProductException
     */
    public List<DTOProduct> findProdutByCategory(String category, double key) throws ProductException;

    /**
     * find all products.
     *
     * @param key
     * @return List<DTOProduct>
     * @throws ProductException
     */
    public List<DTOProduct> findAllProducts(double key) throws ProductException;

    /**
     * Find products with a matching description
     *
     * @param description
     * @param key
     * @return List<DTOProduct>
     * @throws ProductException
     */
    public List<DTOProduct> findProductByDescription(String description, double key) throws ProductException;

    /**
     * Find products by designation
     *
     * @param designation
     * @param key
     * @return List<DTOProduct>
     * @throws ProductException
     */
    public List<DTOProduct> findProductByDesignation(String designation, double key) throws ProductException;

    /**
     * Find Product By ID
     *
     * @param id
     * @param key
     * @return DTOProduct
     * @throws ProductException
     */
    public DTOProduct findProductById(Long id, double key) throws ProductException;

    /**
     * Find replacement date by product
     *
     * @param id
     * @param key
     * @return String
     * @throws ProductException
     */
    public String findReplacementDateByProduct(Long id, double key) throws ProductException;

    /**
     * Find Stock by product
     *
     * @param id
     * @param key
     * @return int
     * @throws ProductException
     */
    public int findStockByProduct(Long id, double key) throws ProductException;

    /**
     * Performs login
     *
     * @param email
     * @param password
     * @return
     */
    public double login(String email, String password);

    /**
     * Finish the order
     *
     * @param items
     * @param key
     * @return
     */
    public String makeOrder(List<DTOItem> items, double key);

    /**
     * Find order by ID
     *
     * @param id
     * @param key
     * @return
     */
    public DTOOrderReceived findOrderById(Long id, double key);

    /**
     * REturns order delivery date
     *
     * @param id
     * @param key
     * @return
     */
    public String orderDeliveryDate(Long id, double key);

    /**
     * Find all order items
     *
     * @param id
     * @param key
     * @return
     */
    public List<DTOOrderItem> findAllOrderItems(Long id, double key);

    /**
     * Find orders by client ID
     *
     * @param key
     * @return
     */
    public List<DTOOrderReceived> findOrdersByClientId(double key);

    /**
     * Delete Order by ID
     *
     * @param orderId
     * @param key
     * @return
     */
    public String deleteOrderById(Long orderId, double key);

    /**
     * Delete order by ID
     *
     * @param orderId
     * @param newList
     * @param key
     */
    public void editOrder(Long orderId, List<DTOOrderItem> newList, double key);

}
