/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninja.file;

/**
 *
 * @author kelvio
 */
public class Main {
    
    public static void main(String[] args) {
        
        /*File.readText().of("/home/kelvio/metronic_key").inBlocksOf(30).lines(lines -> {
            System.out.println(lines);
        });*/
                
        
        File.ofPath("/home/kelvio/metronic_key").readTextContents().inBlocksOf(1).line(line -> {
            
            System.out.println(line);
            
        });
        
        /*File file = File.ofPath("/home/kelvio");
        
        System.out.println(file.path().contains("kelvio"));
        
        File.readText().of("/home/kelvio/metronic_key", text -> {
            System.out.println(text);
        });*/
        
        
                
        /*
        File.readText().of("/home/kelvio/metronic_key").inBlocksOf(100).lines(System.out::print);
        
        File.readText().of("/home/kelvio/metronic_key").inBlocksOf(1).linesAsList(lines -> {
            
            lines.foreach((index, line) -> {
                System.out.println(index);
                Console.writeLine("Block {0} -> {1}", index, line);
                
            });
            
        });
        */
        /*File.readText().of("/hfjdhfjd").inBlocksOf(20).words(null);
        
        File.readText().of("/home/kelvio/index.html").inBlocksOf(10).lines(line -> {
            
            Console.writeLine(line);
            
        });*/
        
    }
    
}
