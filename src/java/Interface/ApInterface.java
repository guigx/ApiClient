/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Exception.ProductException;
import java.util.List;
import pojos.Product;

/**
 *
 * @author Guilherme Pereira
 */
public interface ApInterface {

    /**
     *
     */
    public List<Product> findProdutByCategory(String category, double key) throws ProductException;

    public List<Product> findAllProducts(double key) throws ProductException;

    public List<Product> findProductByDescription(String description, double key) throws ProductException;

    public List<Product> findProductByDesignation(String designation, double key) throws ProductException;

    public Product findProductById(Long id, double Key) throws ProductException;

    public String findReplacementDateByProduct(Long id, double key) throws ProductException;

    public int findStockByProduct(Long id, double key) throws ProductException;

}
