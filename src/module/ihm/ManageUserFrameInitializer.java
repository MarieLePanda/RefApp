/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module.ihm;

import controller.ActionName;
import controller.Dispatcher;
import interfaces.AbstractIHMAction;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import model.User;
import panda.prod.application.PandaProdApplication;
import view.component.PandaProdButton;
import view.component.PandaProdFrame;

/**
 *
 * @author Lucas
 */
public class ManageUserFrameInitializer extends AbstractIHMAction{

    public ManageUserFrameInitializer(PandaProdFrame csFrame) {
        super(csFrame);
    }

    @Override
    public boolean execute(Object... object) {

        PandaProdApplication application = PandaProdApplication.getApplication();
        Dispatcher dispatcher = Dispatcher.getDispatcher();
        PandaProdButton button = (PandaProdButton) application.getFocusFrameJComponent("pandaProdButtonAddUser");
        button.addActionListener(dispatcher);
        button.setActionCommand(ActionName.addUser);
        button = (PandaProdButton) application.getFocusFrameJComponent("pandaProdButtonDeleteUser");
        button.addActionListener(dispatcher);
        button.setActionCommand(ActionName.deleteUser);
        button = (PandaProdButton) application.getFocusFrameJComponent("pandaProdButtonModifyUser");
        button.addActionListener(dispatcher);
        button.setActionCommand(ActionName.modifyUser);
        JList jlist = (JList) application.getFocusFrameJComponent("jListUser");
        jlist.setCellRenderer(new ListCellRenderer() {

            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel renderer = (JLabel) new DefaultListCellRenderer().getListCellRendererComponent(list, value, index,
                        isSelected, cellHasFocus);
                User user = (User) value;
                renderer.setText(user.getLoginAdressMail());
                return renderer;
            }
        });
        DefaultListModel model = new DefaultListModel();
        for(User u : User.getListUser()){
            model.addElement(u);
        }
        jlist.setModel(model);        
        return true;
    }
    
}
