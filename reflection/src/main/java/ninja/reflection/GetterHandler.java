/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninja.reflection;

import java.lang.reflect.Field;

/**
 *
 * @author kelvio
 */
public interface GetterHandler {
    
    Object field(Field field);
    
    Object field(String field);
    
}
