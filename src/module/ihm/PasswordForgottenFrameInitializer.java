/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module.ihm;

import controller.ActionName;
import controller.Dispatcher;
import interfaces.AbstractIHMAction;
import view.component.PandaProdButton;
import view.component.PandaProdFrame;

/**
 *
 * @author Yehouda
 */
public class PasswordForgottenFrameInitializer extends AbstractIHMAction{

    public PasswordForgottenFrameInitializer(PandaProdFrame csFrame) {
        super(csFrame);
    }

    @Override
    public boolean execute(Object... object) {
        Dispatcher dispatcher = Dispatcher.getDispatcher();
        PandaProdButton button = (PandaProdButton) hsJcomponent.get("pandaProdButtonSendPassword");
        button.addActionListener(dispatcher);
        button.setActionCommand(ActionName.sendMailForgottenPassword);
        return true;
    }
    
}
