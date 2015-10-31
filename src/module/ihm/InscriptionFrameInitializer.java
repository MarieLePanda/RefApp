/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module.ihm;

import controller.ActionName;
import controller.Dispatcher;
import interfaces.AbstractIHMAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import panda.prod.application.PandaProdApplication;
import view.component.PandaProdButton;
import view.component.PandaProdFrame;

/**
 *
 * @author Yehouda
 */
public class InscriptionFrameInitializer extends AbstractIHMAction {

    private final PandaProdFrame frame;

    public InscriptionFrameInitializer(PandaProdFrame csFrame) {
        super(csFrame);
        frame = csFrame;
    }

    @Override
    public boolean execute(Object... object) {
        PandaProdApplication application = PandaProdApplication.getApplication();
        Dispatcher dispatcher = Dispatcher.getDispatcher();
        PandaProdButton validate = (PandaProdButton) application.getMainFrameJComponent("pandaProdButtonValidate");
        validate.addActionListener(dispatcher);
        validate.setActionCommand(ActionName.createAccount);

        PandaProdButton cancel = (PandaProdButton) application.getMainFrameJComponent("pandaProdButtonCancel");
        cancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        return true;
    }
}
