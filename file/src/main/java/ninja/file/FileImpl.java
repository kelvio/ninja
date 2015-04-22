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
class FileImpl implements File {

    private Text path;
    
    public FileImpl(CharSequence path) {
        this.path = Text.of(path);
    }

    @Override
    public Text path() {
        return path;
    }

    @Override
    public File createIfNotExists() {
        return createIfNotExists(e -> {
            //TODO: Notificar
        });
    }

    @Override
    public File createIfNotExists(Consumer<Exception> consumer) {
        try {
            java.io.File f = new java.io.File(this.path.toString());
            if (!f.exists()) {
                f.createNewFile();
            }
        } catch (Exception e) {
            consumer.consume(e);
        }
        return this;
    }

    @Override
    public ReadTextHandler readTextContents() {
        return new ReadTextOfHandlerImpl(this.path.toString());        
    }
    
}
