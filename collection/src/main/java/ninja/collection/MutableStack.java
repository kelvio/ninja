/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninja.collection;

/**
 *
 * @author kelvio
 */
public interface MutableStack <T> extends Stack<T> {
    
    public static <T> MutableStack<T> of(T ... items) {
        return null;
    }
    
}
