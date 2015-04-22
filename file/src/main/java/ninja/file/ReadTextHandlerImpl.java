/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninja.file;

import java.io.FileNotFoundException;
import java.util.Scanner;
import ninja.console.Console;
import ninja.consumer.Consumer;
import ninja.text.Text;

/**
 *
 * @author kelvio
 */
public class ReadTextHandlerImpl implements ReadTextWithNoPreviousSourceHandler {

    @Override
    public ReadTextHandler of(CharSequence fileName) {
        return new ReadTextOfHandlerImpl(fileName);
    }

    @Override
    public void of(CharSequence fileName, Consumer<Text> consumer) {
        of(fileName, consumer, e -> {
            
            Console.writeLine("Exception while reading file {0}: {1}", fileName, e);
            
        });
    }

    @Override
    public void of(CharSequence fileName, Consumer<Text> consumer, Consumer<Exception> exceptionConsumer) {
        StringBuilder sb = new StringBuilder();
        try (Scanner sc = new Scanner(new java.io.File(fileName.toString()))) {            
            while (sc.hasNextLine()) {                
                sb.append(sc.nextLine()).append("\n");
            }
            consumer.consume(Text.of(sb));
        } catch (FileNotFoundException ex) {
            exceptionConsumer.consume(ex);            
        }
        
    }
    
}
