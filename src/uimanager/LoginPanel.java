package uimanager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPanel extends JPanel implements ActionListener, IPanelManager {
    private JPanel loginPanel;

    private JTextField userField;
    private JTextField passwordField;
    private JLabel userIcon;
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JButton loginButton;
    
    public LoginPanel() {
        loginPanel = new JPanel();
        loginPanel.setPreferredSize(new Dimension(400, 300));
        loginPanel.setLayout(new GridLayout(4, 2, 0, 0));

        setComponents();
        setLayoutComponents();
    }

    private void setIconFrame() {
        ImageIcon icon = new ImageIcon("../BankApp/icons/turquoise-icons/user.svg");
        userIcon = new JLabel();
        userIcon.setIcon(icon);
    }

    private void setUserFrame() {
        userLabel = new JLabel("User Name or Email: ");
        userLabel.setForeground(new Color(278079));
        userLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));

        userField = new JTextField();
        userField.setFont(new Font("Century Gothic", Font.BOLD, 20));
        userField.setForeground(new Color(278079));
        userField.setBackground(Color.white);
    }

    private void setPasswordFrame() {
        passwordLabel = new JLabel("Password: ");
        passwordLabel.setForeground(new Color(278079));
        passwordLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));

        passwordField = new JTextField();
        passwordField.setFont(new Font("Century Gothic", Font.BOLD, 20));
        passwordField.setForeground(new Color(278079));
        passwordField.setBackground(Color.white);
    }

    private void setLoginButton() {
        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Century Gothic", Font.BOLD, 20));
        loginButton.setBackground(new Color(278079));
        loginButton.setForeground(Color.white);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    @Override
    public JPanel getPanel() {
        return this.loginPanel;
    }

    @Override
    public void setLayoutComponents() {
        loginPanel.add(new JLabel());
        loginPanel.add(userIcon);
        loginPanel.add(userLabel);
        loginPanel.add(userField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(new JLabel());
        loginPanel.add(loginButton);  
    }

    @Override
    public void setComponents() {
        setIconFrame();
        setUserFrame();
        setPasswordFrame();
        setLoginButton();
    }
}
