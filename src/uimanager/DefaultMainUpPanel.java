package uimanager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class DefaultMainUpPanel extends JPanel implements ActionListener, IPanelManager {
    private JPanel mainUpPanel;
    private JButton buttonLogin;
    private JButton buttonRegister;

    public DefaultMainUpPanel() {
        mainUpPanel = new JPanel();
        mainUpPanel.setBackground(new Color(278079));
        mainUpPanel.setPreferredSize(new Dimension(100, 50));
        mainUpPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        setComponents();
        setLayoutComponents();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainWindow window = MainWindow.getWindow();

        if(e.getSource() == buttonLogin) {
            LoginPanel login = new LoginPanel();
            window.setMainCenterPanel(login.getPanel());
        }
        if(e.getSource() == buttonRegister) {
            RegisterPanel register = new RegisterPanel();
            window.setMainCenterPanel(register.getPanel());
        }

        window.show();
    }

    @Override
    public JPanel getPanel() {
        return this.mainUpPanel;
    }

    @Override
    public void setLayoutComponents() {
        mainUpPanel.add(buttonLogin);
        mainUpPanel.add(buttonRegister);
    }

    @Override
    public void setComponents() {
        buttonLogin = new JButton("Login");
        buttonLogin.setFont(new Font("Century Gothic", Font.BOLD, 20));
        buttonLogin.setBackground(Color.white);
        buttonLogin.setForeground(new Color(278079));
        buttonLogin.addActionListener(this);

        buttonRegister = new JButton("Register");
        buttonRegister.setFont(new Font("Century Gothic", Font.BOLD, 20));
        buttonRegister.setBackground(Color.white);
        buttonRegister.setForeground(new Color(278079));
        buttonRegister.addActionListener(this);
    }
    
}
