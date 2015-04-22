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
public interface MutableQueue <T> extends Queue<T> {
    
    public static <T> MutableQueue<T> empty() {
        return null;
    }
    
    public static <T> MutableQueue<T> of(T ... items) {
        return null;
    }
    
}
