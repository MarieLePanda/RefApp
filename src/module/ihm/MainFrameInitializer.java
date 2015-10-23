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
        Dispatcher dispatcher = Dispatcher.getDispatcher();
        PandaProdButton button = (PandaProdButton) hsJcomponent.get("pandaProdButtonManageUser");
        button.addActionListener(dispatcher);
        button.setActionCommand(ActionName.manageUser);
        
        return false;
    }

}
