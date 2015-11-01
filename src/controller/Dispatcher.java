/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import panda.prod.application.PandaProdApplication;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import model.User;
import module.backoffice.ConnectAccountAction;
import module.backoffice.CreateAccountAction;
import module.backoffice.CreateUser;
import module.backoffice.DeleteUser;
import module.backoffice.UpdateUser;
import module.ihm.AddUserInitializer;
import module.ihm.InscriptionFrameInitializer;
import module.ihm.MainFrameInitializer;
import module.ihm.ManageUserFrameInitializer;
import module.ihm.ModifyUserInitializer;
import view.InscriptionPPFrame;
import view.MainPPFrame;
import view.ManageUserPPFrame;
import view.UserPPFrame;
import view.component.PandaProdPasswordField;
import view.component.PandaProdTextField;

public class Dispatcher implements ActionListener {

    private static Dispatcher INSTANCE;
    private final PandaProdApplication application = PandaProdApplication.getApplication();

    private Dispatcher() {

    }

    public static Dispatcher getDispatcher() {
        if (INSTANCE == null) {
            INSTANCE = new Dispatcher();
        }

        return INSTANCE;
    }

    /**
     * Distribue les actions de l'utilsiateur à des traitements
     *
     * @param e Evénement décrivant l'action à réaliser
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String actionName = e.getActionCommand() + "Action";
        try {
            Method actionToPerform = Dispatcher.class.getDeclaredMethod(actionName);
            actionToPerform.invoke(this);
        } catch (InvocationTargetException | IllegalArgumentException | IllegalAccessException | NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(Dispatcher.class.getName()).log(Level.SEVERE, "Unknown action: " + actionName, ex);
        }
    }

    public void logAccountAction() {
        System.err.println("log");
        boolean connect = new ConnectAccountAction().execute();
        if (connect) {
            application.getMainFrame().dispose();
            application.setMainFrame(new MainPPFrame());
            MainFrameInitializer.getInstance(application.getMainFrame()).execute();
        }
    }

    public void createAccountAction() { // compte cookie swipe a créé
        System.err.println("create");
        String login = ((PandaProdTextField) application.getFocusFrameJComponent("pandaProdTextFieldLoginAdressMail")).getText();
        String pwd = new String(((PandaProdPasswordField) application.getFocusFrameJComponent("pandaProdPasswordFieldPassword")).getPassword());
        String backup = ((PandaProdTextField) application.getFocusFrameJComponent("pandaProdTextFieldBackupMail")).getText();
        boolean created = new CreateAccountAction().execute(login, backup, pwd);
        if (created) {
            application.getFocusFrame().dispose();
        }
    }

    public void inscriptionAction() {
        System.err.println("Inscription");
        application.setFocusFrame(new InscriptionPPFrame());
        new InscriptionFrameInitializer(application.getFocusFrame()).execute();

    }

    public void manageUserAction() {
        System.err.println("Manage user");
        application.setFocusFrame(new ManageUserPPFrame());
        new ManageUserFrameInitializer(application.getFocusFrame()).execute();
    }

    public void addUserAction() {
        System.err.println("Add user");
        application.setFocusFrame(new UserPPFrame());
        new AddUserInitializer(application.getFocusFrame()).execute();
    }

    public void createUserAction() {
        System.err.println("Create user");
        if (new CreateUser().execute()) {
            application.getFocusFrame().dispose();
        }
    }

    public void modifyUserAction() {
        System.err.println("Modify user");
        JList jlist = (JList) application.getFocusFrameJComponent("jListUser");
        User user = (User) jlist.getSelectedValue();
        application.setParam("UserToUpdate", user);
        application.setFocusFrame(new UserPPFrame());
        new ModifyUserInitializer(application.getFocusFrame()).execute();
    }

    public void updateUserAction() {
        System.err.println("Update User");
        if (new UpdateUser().execute()) {
            application.getFocusFrame().dispose();
        }
    }

    public void removeUserAction() {
        System.err.println("Remove user");
        new DeleteUser().execute();
    }

    public void closeFocusFrameAction() {
        System.err.println("Close focus frame");
        application.getFocusFrame().dispose();
    }
}
