/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninja.file;

import java.io.FileNotFoundException;
import java.util.Scanner;
import ninja.collection.List;
import ninja.collection.MutableList;
import ninja.consumer.Consumer;
import ninja.text.Text;

/**
 *
 * @author kelvio
 */
public class ReadTextOfInBlocksOfHandlerImpl implements ReadTextInBlocksOfHandler {
    
    private final int size;
    
    private final CharSequence fileName;

    public ReadTextOfInBlocksOfHandlerImpl(int size, CharSequence fileName) {
        this.size = size;
        this.fileName = fileName;
    }

    @Override
    public void word(Consumer<Text> consumer) {
        
        if (size != 1) {
            throw new IllegalArgumentException("The number of words must be 1. Please use words instead.");
        }
        
        try (Scanner sc = new Scanner(new java.io.File(fileName.toString()))) {
            
            while (sc.hasNext()) {
                consumer.consume(Text.of(sc.next()));
            }
            
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
                
    }

    @Override
    public void words(Consumer<Text> consumer) {
        if (size < 1) {
            throw new IllegalArgumentException("The number of words must be >= 1.");
        }
        
        try (Scanner sc = new Scanner(new java.io.File(fileName.toString()))) {
            
            while (sc.hasNext()) {
                            
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < size && sc.hasNext(); i++) {
                    sb.append(sc.next()).append(" ");                    
                }
                consumer.consume(Text.of(sb));                
            }
            
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void line(Consumer<Text> consumer) {
        if (size != 1) {
            throw new IllegalArgumentException("The number of lines must be 1. Please use lines instead.");
        }
        
        try (Scanner sc = new Scanner(new java.io.File(fileName.toString()))) {
            
            while (sc.hasNextLine()) {
                consumer.consume(Text.of(sc.nextLine()));
            }
            
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void linesAsList(Consumer<List<Text>> consumer) {
        if (size < 1) {
            throw new IllegalArgumentException("The number of lines must be >= 1.");
        }
        
        try (Scanner sc = new Scanner(new java.io.File(fileName.toString()))) {
            
            while (sc.hasNextLine()) {
                            
                MutableList<Text> l = MutableList.newEmptyList();
                for (int i = 0; i < size && sc.hasNextLine(); i++) {
                    l.add(Text.of(sc.nextLine()));
                }
                consumer.consume(List.of(l));
                
            }
            
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void lines(Consumer<Text> consumer) {
        if (size < 1) {
            throw new IllegalArgumentException("The number of lines must be >= 1.");
        }
        
        try (Scanner sc = new Scanner(new java.io.File(fileName.toString()))) {
            
            while (sc.hasNextLine()) {
                            
                Text data = Text.empty();
                for (int i = 0; i < size && sc.hasNextLine(); i++) {
                    data = data.append(sc.nextLine()).append("\n");
                }
                consumer.consume(data);
                
            }
            
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
    
}
