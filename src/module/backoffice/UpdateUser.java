/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module.backoffice;

import controller.Dispatcher;
import errorMessage.CodeError;
import interfaces.IAction;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import model.User;
import panda.prod.application.PandaProdApplication;
import view.component.PandaProdPasswordField;
import view.component.PandaProdTextField;

/**
 *
 * @author Lucas
 */
public class UpdateUser implements IAction {

    @Override
    public boolean execute(Object... object) {
        PandaProdApplication application = PandaProdApplication.getApplication();
        Dispatcher dispatcher = Dispatcher.getDispatcher();
        User user = (User) application.getParam("UserToUpdate");
        String login = ((PandaProdTextField) application.getFocusFrameJComponent("pandaProdTextFieldLoginMail")).getText();
        String password = new String(((PandaProdPasswordField) application.getFocusFrameJComponent("pandaProdPasswordFieldPasswordUser")).getPassword());
        boolean admin = ((JCheckBox) application.getFocusFrameJComponent("jCheckBoxIsAdministrator")).isSelected();
        user.setLoginAdressMail(login);
        user.setPassword(password);
        user.setAdministrator(admin);
        int error = user.update();
        if (error == CodeError.SUCESS) {
            new JOptionPane();
            JOptionPane.showMessageDialog(null, "Modification d'utilisateur effectué",
                    "Modification utilisateur", JOptionPane.INFORMATION_MESSAGE);

            return true;
        } else {
            new JOptionPane();
            JOptionPane.showMessageDialog(null, "Modification d'utilisateur impossible",
                    "Modification utilisateur", JOptionPane.ERROR_MESSAGE);

            return false;
        }
    }

}
