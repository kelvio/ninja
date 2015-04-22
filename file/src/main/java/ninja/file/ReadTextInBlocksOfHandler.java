/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninja.file;

import ninja.collection.List;
import ninja.consumer.Consumer;
import ninja.text.Text;

/**
 *
 * @author kelvio
 */
public interface ReadTextInBlocksOfHandler {
    
    void word(Consumer<Text> consumer);
    
    void words(Consumer<Text> consumer);
    
    void line(Consumer<Text> consumer);
    
    void linesAsList(Consumer<List<Text>> consumer);
    
    void lines(Consumer<Text> consumer);
        
    
}
