/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninja.reflection;

import java.lang.annotation.Annotation;

/**
 *
 * @author kelvio
 */
public interface MemberHandler {
    
    <T extends Annotation> T annotation(Class<T> type);
    
}
