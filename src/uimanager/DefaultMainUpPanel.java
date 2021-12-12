package uimanager;

import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class DefaultMainUpPanel extends JPanel implements IPanelManager {
    private JPanel mainUpPanel;

    private JTabbedPane mainUpTabbedPane;

    public DefaultMainUpPanel() {
        mainUpPanel = new JPanel();
        mainUpPanel.setBackground(new Color(278079));
        //mainUpPanel.setPreferredSize(new Dimension(100, 50));
        mainUpPanel.setLayout(new BorderLayout(0, 0));

        setComponents();
        setLayoutComponents();
    }

    private void setMainUpTabbedPane() {
        mainUpTabbedPane = new JTabbedPane();
        mainUpTabbedPane.setForeground(new Color(278079));
        mainUpTabbedPane.setFont(new Font("Century Gothic", Font.BOLD, 20));

        ImageIcon iconAdmin = new ImageIcon("../Swing-App/icons/turquoise-icons/gitlab.svg");
        ImageIcon iconLogin = new ImageIcon("../Swing-App/icons/turquoise-icons/user.svg");
        ImageIcon iconRegister = new ImageIcon("../Swing-App/icons/turquoise-icons/user-plus.svg");

        AdminLoginPanel admin = new AdminLoginPanel();
        LoginPanel login = new LoginPanel();
        RegisterPanel register = new RegisterPanel();

        mainUpTabbedPane.addTab("Login", iconLogin, login.getPanel());
        mainUpTabbedPane.addTab("Register", iconRegister, register.getPanel());
        mainUpTabbedPane.addTab("Admin", iconAdmin, admin.getPanel());
    }

    @Override
    public JPanel getPanel() {
        return this.mainUpPanel;
    }

    @Override
    public void setLayoutComponents() {
        mainUpPanel.add(mainUpTabbedPane);
    }

    @Override
    public void setComponents() {
        setMainUpTabbedPane();
    }
    
}
