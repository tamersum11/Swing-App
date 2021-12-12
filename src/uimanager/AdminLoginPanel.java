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

public class AdminLoginPanel extends JPanel implements ActionListener, ILoginPanel, IPanelManager {
    private JPanel adminlLoginPanel;

    private JTextField adminField;
    private JPasswordField passwordField;
    private JLabel adminIcon;
    private JLabel adminLabel;
    private JLabel passwordLabel;
    private JButton loginButton;
    
    public AdminLoginPanel() {
        adminlLoginPanel = new JPanel();
        adminlLoginPanel.setPreferredSize(new Dimension(400, 300));
        adminlLoginPanel.setLayout(new GridLayout(4, 2, 0, 0));

        setComponents();
        setLayoutComponents();
    }

    @Override
    public void setIconFrame() {
        Border border = BorderFactory.createLineBorder(new Color(278079));
        ImageIcon icon = new ImageIcon("../Swing-App/icons/turquoise-icons/gitlab.svg");
        adminIcon = new JLabel("Admin Login Panel");
        adminIcon.setForeground(new Color(278079));
        adminIcon.setBackground(Color.white);
        adminIcon.setFont(new Font("Century Gothic", Font.BOLD, 20));
        adminIcon.setIcon(icon);
        adminIcon.setHorizontalTextPosition(JLabel.CENTER);
        adminIcon.setVerticalTextPosition(JLabel.BOTTOM);
        adminIcon.setBorder(border);
        adminIcon.setVerticalAlignment(JLabel.CENTER);
        adminIcon.setHorizontalAlignment(JLabel.CENTER);
    }

    @Override
    public void setNameFrame() {
        adminLabel = new JLabel("Admin Name: ");
        adminLabel.setForeground(new Color(278079));
        adminLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));

        adminField = new JTextField();
        adminField.setFont(new Font("Century Gothic", Font.BOLD, 20));
        adminField.setForeground(new Color(278079));
        adminField.setBackground(Color.white);    
    }

    @Override
    public void setPasswordFrame() {
        passwordLabel = new JLabel("Password: ");
        passwordLabel.setForeground(new Color(278079));
        passwordLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));

        passwordField = new JPasswordField(10);
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
        
    }

    @Override
    public JPanel getPanel() {
        return this.adminlLoginPanel;
    }

    @Override
    public void setLayoutComponents() {
        adminlLoginPanel.add(new JLabel());
        adminlLoginPanel.add(adminIcon);
        adminlLoginPanel.add(adminLabel);
        adminlLoginPanel.add(adminField);
        adminlLoginPanel.add(passwordLabel);
        adminlLoginPanel.add(passwordField);
        adminlLoginPanel.add(new JLabel());
        adminlLoginPanel.add(loginButton);  
    }

    @Override
    public void setComponents() {
        setIconFrame();
        setNameFrame();
        setPasswordFrame();
        setLoginButton();
    }
}
