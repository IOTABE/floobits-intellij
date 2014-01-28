package floobits;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CreateAccountDialog extends DialogWrapper {
    private JPanel jPanel;


    private class CreateAccountAction extends DialogWrapper.DialogWrapperAction {

        protected CreateAccountAction() {
            super("Create a Floobits account");
        }

        @Override
        protected void doAction(ActionEvent e) {
            Flog.info("Creating account from button press");
        }
    }


    private class LinkAccountAction extends DialogWrapper.DialogWrapperAction {

        protected LinkAccountAction() {
            super("I already have an account");
        }

        @Override
        protected void doAction(ActionEvent e) {
            Flog.info("Linking account from button press");
        }
    }


    protected CreateAccountDialog(@Nullable Project project) {
        super(project, true);
        jPanel = new JPanel();
        init();
        this.setTitle("No Floobits account detected");
        JLabel label = new JLabel("You need a Floobits account! If you don't have one we will create one for you.");
        jPanel.add(label);

    }

    @Override
    public void createDefaultActions () {
        super.createDefaultActions();
        myOKAction = new CreateAccountAction();
        myCancelAction = new LinkAccountAction();
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        return jPanel;
    }
}

