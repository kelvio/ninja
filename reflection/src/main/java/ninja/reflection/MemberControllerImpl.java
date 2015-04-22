/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ninja.reflection;

/**
 *
 * @author kelvio
 */
public class MemberControllerImpl implements MemberController {
    
    private final net.vidageek.mirror.dsl.MemberController memberController;

    public MemberControllerImpl(net.vidageek.mirror.dsl.MemberController memberController) {
        this.memberController = memberController;
        
    }

    @Override
    public MemberHandler reflect() {
        return new MemberHandlerImpl(memberController.reflect());
    }

   
}
