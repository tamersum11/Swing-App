package uimanager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import appmanager.UserLoginManager;

public class LoginPanel extends JPanel implements ActionListener, IPanelManager, ILoginPanel {
    private JPanel loginPanel;

    private JTextField userField;
    private JPasswordField passwordField;
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

    @Override
    public void setIconFrame() {
        Border border = BorderFactory.createLineBorder(new Color(278079));
        ImageIcon icon = new ImageIcon("../Swing-App/icons/turquoise-icons/user.svg");
        userIcon = new JLabel("User Login Panel");
        userIcon.setForeground(new Color(278079));
        userIcon.setBackground(Color.white);
        userIcon.setFont(new Font("Century Gothic", Font.BOLD, 20));
        userIcon.setIcon(icon);
        userIcon.setHorizontalTextPosition(JLabel.CENTER);
        userIcon.setVerticalTextPosition(JLabel.BOTTOM);
        userIcon.setBorder(border);
        userIcon.setVerticalAlignment(JLabel.CENTER);
        userIcon.setHorizontalAlignment(JLabel.CENTER);
    }

    @Override
    public void setNameFrame() {
        userLabel = new JLabel("Email: ");
        userLabel.setForeground(new Color(278079));
        userLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));

        userField = new JTextField();
        userField.setFont(new Font("Century Gothic", Font.BOLD, 20));
        userField.setForeground(new Color(278079));
        userField.setBackground(Color.white);    
    }

    @Override
    public void setPasswordFrame() {
        passwordLabel = new JLabel("Password: ");
        passwordLabel.setForeground(new Color(278079));
        passwordLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Century Gothic", Font.BOLD, 20));
        passwordField.setForeground(new Color(278079));
        passwordField.setBackground(Color.white);  
    }

    @Override
    public void setLoginButton() {
        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Century Gothic", Font.BOLD, 20));
        loginButton.setBackground(new Color(278079));
        loginButton.setForeground(Color.white);
        loginButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        UserLoginManager manager = new UserLoginManager(userField.getText(), (passwordField.getPassword() == null) ? "" : (String)passwordField.getText());
        manager.setLoginManager();
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
        setNameFrame();
        setPasswordFrame();
        setLoginButton();
    }
}
