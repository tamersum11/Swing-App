package uimanager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class RegisterPanel extends JPanel implements IPanelManager {
    private JPanel registerPanel;

    private JLabel userNameLabel;

    public RegisterPanel() {
        registerPanel = new JPanel();
        registerPanel.setPreferredSize(new Dimension(400, 300));
        registerPanel.setLayout(new GridLayout(4, 2, 0, 0));

        setComponents();
        setLayoutComponents();

    }

    private void setUserNameFrame() {
        userNameLabel = new JLabel("User Name: ");
        userNameLabel.setForeground(new Color(278079));
        userNameLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));
    }

    @Override
    public JPanel getPanel() {
        return registerPanel;
    }

    @Override
    public void setComponents() {
        setUserNameFrame();
        //setPasswordFrame();
    }

    @Override
    public void setLayoutComponents() {
        registerPanel.add(userNameLabel);
    }
    
}
