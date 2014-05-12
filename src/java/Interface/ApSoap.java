/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import DTOConverter.DTOConverter;
import Exception.ProductException;
import Soap.LoginInvalidateException_Exception;
import Soap.ProductNotFoundException_Exception;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public List<Product> findProdutByCategory(String category, double key) throws ProductException {
        try {
            Soap.SoapWebService_Service service = new Soap.SoapWebService_Service();
            Soap.SoapWebService port = service.getSoapWebServicePort();
            return DTOConverter.convertProductList(port.findProductsByCategory(category, key));
        } catch (ProductNotFoundException_Exception ex) {
            Logger.getLogger(ApSoap.class.getName()).log(Level.SEVERE, null, ex);
            throw new ProductException();
        }
    }

    @Override
    public List<Product> findAllProducts(double key) throws ProductException {
        try {
            Soap.SoapWebService_Service service = new Soap.SoapWebService_Service();
            Soap.SoapWebService port = service.getSoapWebServicePort();
            return DTOConverter.convertProductList(port.findAllProducts(key));
        } catch (ProductNotFoundException_Exception ex) {
            Logger.getLogger(ApSoap.class.getName()).log(Level.SEVERE, null, ex);
            throw new ProductException();
        }
    }

    @Override
    public List<Product> findProductByDescription(String description, double key) throws ProductException {
        try {
            Soap.SoapWebService_Service service = new Soap.SoapWebService_Service();
            Soap.SoapWebService port = service.getSoapWebServicePort();
            return DTOConverter.convertProductList(port.findProductsByDescription(description, key));
        } catch (ProductNotFoundException_Exception ex) {
            Logger.getLogger(ApSoap.class.getName()).log(Level.SEVERE, null, ex);
            throw new ProductException();
        }
    }

    @Override
    public List<Product> findProductByDesignation(String designation, double key) throws ProductException {
        try {
            Soap.SoapWebService_Service service = new Soap.SoapWebService_Service();
            Soap.SoapWebService port = service.getSoapWebServicePort();
            return DTOConverter.convertProductList(port.findProductByDesignation(designation, key));
        } catch (ProductNotFoundException_Exception ex) {
            Logger.getLogger(ApSoap.class.getName()).log(Level.SEVERE, null, ex);
            throw new ProductException();
        }
    }

    @Override
    public Product findProductById(Long id, double key) throws ProductException {
        try {
            Soap.SoapWebService_Service service = new Soap.SoapWebService_Service();
            Soap.SoapWebService port = service.getSoapWebServicePort();
            return DTOConverter.convertProduct(port.findProductById(id, key));
        } catch (ProductNotFoundException_Exception ex) {
            Logger.getLogger(ApSoap.class.getName()).log(Level.SEVERE, null, ex);
            throw new ProductException();
        }
    }

    @Override
    public String findReplacementDateByProduct(Long id, double key) throws ProductException {
        try {
            Soap.SoapWebService_Service service = new Soap.SoapWebService_Service();
            Soap.SoapWebService port = service.getSoapWebServicePort();
            return port.replacementDateByProduct(id, key);
        } catch (ProductNotFoundException_Exception ex) {
            Logger.getLogger(ApSoap.class.getName()).log(Level.SEVERE, null, ex);
            throw new ProductException();
        }
    }

    @Override
    public int findStockByProduct(Long id, double key) throws ProductException {
        try {
            Soap.SoapWebService_Service service = new Soap.SoapWebService_Service();
            Soap.SoapWebService port = service.getSoapWebServicePort();
            return port.findStockByProduct(id, key);
        } catch (ProductNotFoundException_Exception ex) {
            Logger.getLogger(ApSoap.class.getName()).log(Level.SEVERE, null, ex);
            throw new ProductException();
        }
    }

    @Override
    public double login(String email, String password) {

        Soap.SoapWebService_Service service = new Soap.SoapWebService_Service();
        Soap.SoapWebService port = service.getSoapWebServicePort();
        try {
            return port.login(email, password);
        } catch (LoginInvalidateException_Exception ex) {
            Logger.getLogger(ApSoap.class.getName()).log(Level.SEVERE, null, ex);
            return -1.0;
        }
    }

}
