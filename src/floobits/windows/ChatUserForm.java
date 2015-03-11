package floobits.windows;

import com.intellij.ui.components.JBList;
import com.intellij.uiDesigner.core.GridConstraints;
import floobits.utilities.Colors;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ChatUserForm {
    private JList clientList;
    private JPanel gravatarContainer;
    private JPanel containerPanel;
    private JPanel subContainer;
    private DefaultListModel clientModel;
    private JMenuItem testMenuItem;
    private JPopupMenu menuPopup;



    private static class ClientCellRenderer extends JLabel implements ListCellRenderer {

        private static final long serialVersionUID = 1L;

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            setText((String) value);
            setOpaque(false);
            return this;
        }
    }

    public ChatUserForm () {
        containerPanel.setComponentPopupMenu(menuPopup);
    }

    private void createUIComponents() {
        subContainer = new JPanel();
        clientModel = new DefaultListModel();
        clientList = new JBList();
        clientList.setOpaque(false);
        clientList.setModel(clientModel);
        clientList.setCellRenderer(new ClientCellRenderer());
        testMenuItem = new JMenuItem("test");
        menuPopup = new JPopupMenu();
        menuPopup.add(testMenuItem);
        subContainer.setComponentPopupMenu(menuPopup);
        clientList.setComponentPopupMenu(menuPopup);
    }

    public void setUsername(String username) {
        TitledBorder border = (TitledBorder) containerPanel.getBorder();
        border.setTitle(username);
    }

    public void addGravatar(Image gravatar, String username) {
        JLabel iconlabel = new JLabel(new ImageIcon(gravatar));
        iconlabel.setBorder(BorderFactory.createLineBorder(Colors.getColorForUser(username), 2));
        gravatarContainer.add(iconlabel, new GridConstraints());

    }

    public void addClient(String client, String platform) {
        clientModel.addElement(String.format("<html>&middot; %s  <small><i>(%s)</html></i></small>", client, platform));
    }

    public JPanel getContainerPanel() {
        return containerPanel;
    }

}
