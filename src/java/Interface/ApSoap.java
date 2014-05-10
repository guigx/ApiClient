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
public class ApSoap implements ApInterface {

    /**
     * Creates a new instance of ApSoap
     */
    public ApSoap() {
    }

    @Override
    public List<Product> findProdutByCategory(String category, String key) throws ProductException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Product> findAllProducts(String key) throws ProductException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Product> findProductByDescription(String description, String key) throws ProductException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Product> findProductByDesignation(String designation, String key) throws ProductException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product findProductById(Long id, String Key) throws ProductException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String findReplacementDateByProduct(Long id, String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int findStockByProduct(Long id, String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
