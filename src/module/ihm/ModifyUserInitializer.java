/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module.ihm;

import controller.ActionName;
import controller.Dispatcher;
import interfaces.AbstractIHMAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import model.Encryption;
import model.User;
import module.backoffice.UpdateUser;
import panda.prod.application.PandaProdApplication;
import view.component.PandaProdButton;
import view.component.PandaProdFrame;
import view.component.PandaProdPasswordField;
import view.component.PandaProdTextField;

/**
 *
 * @author Lucas
 */
public class ModifyUserInitializer extends AbstractIHMAction {

    public ModifyUserInitializer(PandaProdFrame csFrame) {
        super(csFrame);
    }

    @Override
    public boolean execute(Object... object) {
        PandaProdApplication application = PandaProdApplication.getApplication();
        Dispatcher dispatcher = Dispatcher.getDispatcher();
        User user = (User) application.getParam("UserToUpdate");
        System.err.println(user);
        ((PandaProdTextField) application.getFocusFrameJComponent("pandaProdTextFieldLoginMail")).setText(user.getLoginAdressMail());
        try {
            ((PandaProdPasswordField) application.getFocusFrameJComponent("pandaProdPasswordFieldPasswordUser")).setText(new Encryption().decrypt(user.getPassword()));
        } catch (Exception ex) {
            Logger.getLogger(UpdateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        ((JCheckBox) application.getFocusFrameJComponent("jCheckBoxIsAdministrator")).setSelected(user.isAdministrator());
        PandaProdButton button = (PandaProdButton) application.getFocusFrameJComponent("pandaProdButtonValidate");
        button.addActionListener(dispatcher);
        button.setActionCommand(ActionName.updateUser);
        button = (PandaProdButton) application.getFocusFrameJComponent("pandaProdButtonCancel");
        button.addActionListener(dispatcher);
        button.setActionCommand(ActionName.closeFocusFrame);

        return true;
    }

}
