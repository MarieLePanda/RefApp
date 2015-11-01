/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module.ihm;

import controller.ActionName;
import controller.Dispatcher;
import interfaces.AbstractIHMAction;
import model.User;
import panda.prod.application.PandaProdApplication;
import view.component.PandaProdButton;
import view.component.PandaProdFrame;

/**
 *
 * @author Lucas
 */
public class MainFrameInitializer extends AbstractIHMAction {

    private static MainFrameInitializer INSTANCE;

    private MainFrameInitializer(PandaProdFrame ppFrame) {
        super(ppFrame);
    }

    public static MainFrameInitializer getInstance(PandaProdFrame ppFrame) {
        if (INSTANCE == null) {
            INSTANCE = new MainFrameInitializer(ppFrame);
        }

        return INSTANCE;
    }

    @Override
    public boolean execute(Object... object) {
        PandaProdApplication application = PandaProdApplication.getApplication();
        Dispatcher dispatcher = Dispatcher.getDispatcher();
        User user = application.getUser();
        PandaProdButton button = (PandaProdButton) application.getMainFrameJComponent("pandaProdButtonManageUser");
        button.addActionListener(dispatcher);
        button.setActionCommand(ActionName.manageUser);
        if(!user.isAdministrator()){
            button.setVisible(false);
        }
        
        return false;
    }

}
