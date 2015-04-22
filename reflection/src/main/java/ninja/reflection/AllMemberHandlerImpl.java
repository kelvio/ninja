/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninja.reflection;

import java.lang.annotation.Annotation;
import net.vidageek.mirror.list.dsl.MirrorList;

/**
 *
 * @author kelvio
 */
class AllMemberHandlerImpl implements AllMemberHandler {

    private net.vidageek.mirror.reflect.dsl.AllMemberHandler allMemberHandler;

    public AllMemberHandlerImpl(net.vidageek.mirror.reflect.dsl.AllMemberHandler allMemberHandler) {
        this.allMemberHandler = allMemberHandler;
    }
    
    
    @Override
    public MirrorList<Annotation> annotations() {        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
