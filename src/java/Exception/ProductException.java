/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

/**
 *
 * @author Guilherme Pereira
 */
public class ProductException extends Exception {

    public ProductException() {
        super("Product Not Found");
    }
}
