/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninja.reflection;

/**
 *
 * @author kelvio
 */
public interface ConstructorHandler <T> {

    T bypasser();

    T withArgs(Object ... args);
    
    T withoutArgs();
    
}
