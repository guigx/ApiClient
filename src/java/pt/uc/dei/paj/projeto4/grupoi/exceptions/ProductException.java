/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.paj.projeto4.grupoi.exceptions;

import javax.ws.rs.core.Response;

/**
 *
 * @author Guilherme Pereira
 */
public class ProductException extends Exception {

    public ProductException() {
        super("Product Not Found");
    }

    public ProductException(Response.Status status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
