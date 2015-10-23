/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module.backoffice;

import errorMessage.CodeError;
import interfaces.IAction;
import javax.swing.JOptionPane;
import model.User;
import utils.Util;

/**
 *
 * @author Yehouda
 */
public class CreateAccountAction implements IAction {

    @Override
    public boolean execute(Object... object) {
        String login = (String) object[0];
        String password = (String) object[1];
        boolean administrator = (boolean) object[2];

        if (!Util.isWellFormedMail(login)) {
            JOptionPane.showMessageDialog(null, "Votre mail est mal écrit",
                    "Création à REFAPP", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        User u = new User(login, password, administrator);
        int code = u.create();
        JOptionPane jOptionPane = new JOptionPane();
        if (code == CodeError.SUCESS) {
            JOptionPane.showMessageDialog(null, "La création du compte à été effectué",
                    "Création à REFAPP", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            if (code == CodeError.STATEMENT_INTEGRITY_CONSTRAINT_VIOLATION) {
                JOptionPane.showMessageDialog(null, "Cette adresse mail est déjà utilisé\nCode erreur : " + code,
                        "Création à REFAPP", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "La création du compte a échoué\nCode erreur : " + code,
                        "Création à REFAPP", JOptionPane.ERROR_MESSAGE);
            }
            return false;
        }
    }

}
