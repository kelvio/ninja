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
public interface ReadTextWithNoPreviousSourceHandler {

    ReadTextHandler of(CharSequence fileName);
    
    void of(CharSequence fileName, Consumer<Text> consumer);
    
    void of(CharSequence fileName, Consumer<Text> consumer, Consumer<Exception> exceptionConsumer);
    
    default ReadTextHandler of(Text fileName) {
        return of(fileName.toString());
    }
    
    default void of(Text fileName, Consumer<Text> consumer) {
        of(fileName.toString(), consumer);
    }
    
    default void of(Text fileName, Consumer<Text> consumer, Consumer<Exception> exceptionConsumer) {
        of(fileName.toString(), consumer, exceptionConsumer);
    }
    
    default ReadTextHandler of(File file) {
        return of(file.path());
    }
    
    default void of(File file, Consumer<Text> consumer) {
        of(file.path(), consumer);
    }
    
    default void of(File file, Consumer<Text> consumer, Consumer<Exception> exceptionConsumer) {
        of(file.path(), consumer, exceptionConsumer);
    }
}
