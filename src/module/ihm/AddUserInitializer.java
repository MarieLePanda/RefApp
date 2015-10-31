/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module.ihm;

import controller.ActionName;
import controller.Dispatcher;
import interfaces.AbstractIHMAction;
import panda.prod.application.PandaProdApplication;
import view.component.PandaProdButton;
import view.component.PandaProdFrame;

/**
 *
 * @author Lucas
 */
public class AddUserInitializer extends AbstractIHMAction{

    public AddUserInitializer(PandaProdFrame csFrame) {
        super(csFrame);
    }

    @Override
    public boolean execute(Object... object) {
        PandaProdApplication application = PandaProdApplication.getApplication();
        Dispatcher dispatcher = Dispatcher.getDispatcher();
        PandaProdButton button = (PandaProdButton) application.getFocusFrameJComponent("pandaProdButtonValidate");
        button.addActionListener(dispatcher);
        button.setActionCommand(ActionName.createUser);
        button = (PandaProdButton) application.getFocusFrameJComponent("pandaProdButtonCancel");
        button.addActionListener(dispatcher);
        button.setActionCommand(ActionName.closeFocusFrame);
        
        
        return true;
    }
    
}
