/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module.backoffice;

import errorMessage.CodeError;
import interfaces.IAction;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import model.User;
import panda.prod.application.PandaProdApplication;

/**
 *
 * @author Lucas
 */
public class DeleteUser implements IAction {

    @Override
    public boolean execute(Object... object) {
        PandaProdApplication application = PandaProdApplication.getApplication();
        JList jlist = (JList) application.getFocusFrameJComponent("jListUser");
        User user = (User) jlist.getSelectedValue();
        int error = user.delete();
        if (error == CodeError.SUCESS) {
            DefaultListModel model = (DefaultListModel) jlist.getModel();
            model.removeElement(user);
            jlist.setModel(model);
            new JOptionPane();
            JOptionPane.showMessageDialog(null, "Suppression d'utilisateur effectué",
                    "Suppression utilisateur", JOptionPane.INFORMATION_MESSAGE);

            return true;
        } else {
            new JOptionPane();
            JOptionPane.showMessageDialog(null, "Suppression d'utilisateur impossible",
                    "Suppression utilisateur", JOptionPane.ERROR_MESSAGE);

            return false;
        }
    }

}
