/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module.backoffice;

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
public class CreateUser implements IAction {

    @Override
    public boolean execute(Object... object) {

        PandaProdApplication application = PandaProdApplication.getApplication();
        String login = ((PandaProdTextField) application.getFocusFrameJComponent("pandaProdTextFieldLoginMail")).getText();
        String password = new String(((PandaProdPasswordField) application.getFocusFrameJComponent("pandaProdPasswordFieldPasswordUser")).getPassword());
        boolean admin = ((JCheckBox) application.getFocusFrameJComponent("jCheckBoxIsAdministrator")).isEnabled();
        User user = new User(login, password, admin);
        int error = user.create();
        if (error == CodeError.SUCESS) {
            new JOptionPane();
            JOptionPane.showMessageDialog(null, "Création d'utilisateur effectué",
                    "Création utilisateur", JOptionPane.INFORMATION_MESSAGE);

            return true;
        } else {
            new JOptionPane();
            JOptionPane.showMessageDialog(null, "Création d'utilisateur impossible",
                    "Création utilisateur", JOptionPane.ERROR_MESSAGE);

            return false;
        }
    }

}
