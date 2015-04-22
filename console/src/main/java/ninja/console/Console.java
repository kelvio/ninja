/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninja.console;

import java.text.MessageFormat;

/**
 *
 * @author kelvio
 */
public interface Console {
        
    
    public static void writeLine(Object format, Object ... args) {
        
        System.out.println(new MessageFormat(String.valueOf(format)).format(args));
        
        
    }
    
}
