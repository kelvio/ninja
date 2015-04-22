/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninja.file;

import ninja.consumer.Consumer;
import ninja.text.Text;

/**
 *
 * @author kelvio
 */
public interface File extends Resource {
    
    public static File ofPath(CharSequence path) {
        return new FileImpl(path);
    }
    
    public static File ofPath(Text path) {
        return new FileImpl(path.toString());
    }
    
    public static ReadTextWithNoPreviousSourceHandler readText() {
        return new ReadTextHandlerImpl();
    }
    
    File createIfNotExists();
    
    File createIfNotExists(Consumer<Exception> consumer);
    
    ReadTextHandler readTextContents();
        
    
}
