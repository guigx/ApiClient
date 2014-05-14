/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import DTOConverter.DTOConverter;
import Exception.ProductException;
import Soap.ClientNotFoundException_Exception;
import Soap.ItemNotFoundException_Exception;
import Soap.LoginInvalidateException_Exception;
import Soap.OrderNotCreatedException_Exception;
import Soap.OrderNotFoundException_Exception;
import Soap.ProductNotFoundException_Exception;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import pojos.DTOItem;
import pojos.DTOOrderItem;
import pojos.DTOOrderReceived;
import pojos.DTOProduct;

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
    public List<DTOProduct> findProdutByCategory(String category, double key) throws ProductException {
        try {
            Soap.SoapWebService_Service service = new Soap.SoapWebService_Service();
            Soap.SoapWebService port = service.getSoapWebServicePort();
            return DTOConverter.convertProductList(port.findProductsByCategory(category, key));
        } catch (ProductNotFoundException_Exception | ParseException ex) {
            Logger.getLogger(ApSoap.class.getName()).log(Level.SEVERE, null, ex);
            throw new ProductException();
        }
    }

    @Override
    public List<DTOProduct> findAllProducts(double key) throws ProductException {
        try {
            Soap.SoapWebService_Service service = new Soap.SoapWebService_Service();
            Soap.SoapWebService port = service.getSoapWebServicePort();
            return DTOConverter.convertProductList(port.findAllProducts(key));
        } catch (ProductNotFoundException_Exception | ParseException ex) {
            Logger.getLogger(ApSoap.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList();
        }
    }

    @Override
    public List<DTOProduct> findProductByDescription(String description, double key) throws ProductException {
        try {
            Soap.SoapWebService_Service service = new Soap.SoapWebService_Service();
            Soap.SoapWebService port = service.getSoapWebServicePort();
            return DTOConverter.convertProductList(port.findProductsByDescription(description, key));
        } catch (ProductNotFoundException_Exception | ParseException ex) {
            Logger.getLogger(ApSoap.class.getName()).log(Level.SEVERE, null, ex);
            throw new ProductException();
        }
    }

    @Override
    public List<DTOProduct> findProductByDesignation(String designation, double key) throws ProductException {
        try {
            Soap.SoapWebService_Service service = new Soap.SoapWebService_Service();
            Soap.SoapWebService port = service.getSoapWebServicePort();
            return DTOConverter.convertProductList(port.findProductByDesignation(designation, key));
        } catch (ProductNotFoundException_Exception | ParseException ex) {
            Logger.getLogger(ApSoap.class.getName()).log(Level.SEVERE, null, ex);
            throw new ProductException();
        }
    }

    @Override
    public DTOProduct findProductById(Long id, double key) throws ProductException {
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
            return "Product not found";
        } catch (ClientNotFoundException_Exception ex) {
            Logger.getLogger(ApSoap.class.getName()).log(Level.SEVERE, null, ex);
            return "Client not found";

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
            double result = port.login(email, password);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Order Successfuly completed"));
            return result;
        } catch (LoginInvalidateException_Exception ex) {
            Logger.getLogger(ApSoap.class.getName()).log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Order not completed"));
            return -1.0;
        }
    }

    @Override
    public String makeOrder(List<DTOItem> items, double key) {

        Soap.SoapWebService_Service service = new Soap.SoapWebService_Service();
        Soap.SoapWebService port = service.getSoapWebServicePort();
        try {
            //DTOConverter.convertListItemSoap(items);
            return port.makeOrder(DTOConverter.convertListItemSoap(items), key);
        } catch (OrderNotCreatedException_Exception ex) {
            Logger.getLogger(ApSoap.class.getName()).log(Level.SEVERE, null, ex);
            return "Order not created";
        }
    }

    @Override
    public DTOOrderReceived findOrderById(Long id, double key) {
        try {
            Soap.SoapWebService_Service service = new Soap.SoapWebService_Service();
            Soap.SoapWebService port = service.getSoapWebServicePort();
            return DTOConverter.convertOrder(port.findOrder(id, key));
        } catch (ClientNotFoundException_Exception | OrderNotFoundException_Exception ex) {
            Logger.getLogger(ApSoap.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public String orderDeliveryDate(Long id, double key) {
        Soap.SoapWebService_Service service = new Soap.SoapWebService_Service();
        Soap.SoapWebService port = service.getSoapWebServicePort();
        try {
            return port.orderDeliveryDate(id, key);
        } catch (ClientNotFoundException_Exception | OrderNotFoundException_Exception ex) {
            Logger.getLogger(ApSoap.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<DTOOrderReceived> findAllOrders(double key) {
        Soap.SoapWebService_Service service = new Soap.SoapWebService_Service();
        Soap.SoapWebService port = service.getSoapWebServicePort();
        try {
            return DTOConverter.convertOrderList(port.findAllOrders(key));
        } catch (ClientNotFoundException_Exception | OrderNotFoundException_Exception ex) {
            Logger.getLogger(ApSoap.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList();
        }
    }

    @Override
    public List<DTOOrderItem> findAllOrderItems(Long id, double key) {
        Soap.SoapWebService_Service service = new Soap.SoapWebService_Service();
        Soap.SoapWebService port = service.getSoapWebServicePort();
        try {
            //return null;
            return DTOConverter.convertListDtoItemToSoapItems(port.findOrderItems(id, key));
        } catch (ClientNotFoundException_Exception | ItemNotFoundException_Exception ex) {
            Logger.getLogger(ApSoap.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList();
        }
    }

    @Override
    public List<DTOOrderReceived> findOrdersByClientId(double key) {
        Soap.SoapWebService_Service service = new Soap.SoapWebService_Service();
        Soap.SoapWebService port = service.getSoapWebServicePort();
        try {
            return DTOConverter.findOrdersByClientId(port.findOrderByClienId(key));
        } catch (ClientNotFoundException_Exception | OrderNotFoundException_Exception ex) {
            Logger.getLogger(ApSoap.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList();
        }
    }

    @Override
    public String deleteOrderById(Long orderId, double key) {
        Soap.SoapWebService_Service service = new Soap.SoapWebService_Service();
        Soap.SoapWebService port = service.getSoapWebServicePort();
        try {
            return port.deleteOrderById(orderId, key);
        } catch (ClientNotFoundException_Exception | OrderNotFoundException_Exception ex) {
            Logger.getLogger(ApSoap.class.getName()).log(Level.SEVERE, null, ex);
            return "not deleted";
        }
    }

    @Override
    public void editOrder(Long orderId, List<DTOOrderItem> newList, double key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
