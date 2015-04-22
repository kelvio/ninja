/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninja.reflection;

import java.lang.annotation.Annotation;
import java.util.List;

/**
 *
 * @author kelvio
 */
public interface AllAnnotationsHandler {
    
    public List<Annotation> atClass();

    public List<Annotation> atField(String string);

    public AllMethodAnnotationsHandler atMethod(String string);
    
}
