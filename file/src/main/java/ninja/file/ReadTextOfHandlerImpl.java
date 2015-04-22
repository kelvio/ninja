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
public class ReadTextOfHandlerImpl implements ReadTextHandler {

    private final CharSequence fileName;
    
    ReadTextOfHandlerImpl(CharSequence fileName) {
        this.fileName = fileName;        
    }

    @Override
    public ReadTextInBlocksOfHandler inBlocksOf(int size) {
        return new ReadTextOfInBlocksOfHandlerImpl(size, fileName);
    }

}
