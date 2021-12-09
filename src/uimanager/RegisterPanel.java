package uimanager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
//import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class RegisterPanel extends JPanel implements ActionListener, IPanelManager, ILoginPanel {
    private JPanel registerPanel;

    private JLabel userIcon;
    private JLabel userNameLabel;
    private JLabel userEmailLabel;
    private JLabel userJobLabel;
    private JLabel userPasswordLabel;
    private JLabel userCommitPasswordLabel;
    private JTextField userNameField;
    private JTextField userEmailField;
    private JTextField passwordField;
    private JTextField passworCommitdField;
    private JButton registerButton;
    private JComboBox<String> jobComboBox;

    public RegisterPanel() {
        registerPanel = new JPanel();
        registerPanel.setPreferredSize(new Dimension(400, 400));
        registerPanel.setLayout(new GridLayout(8, 2, 0, 0));

        setComponents();
        setLayoutComponents();
    }

    @Override
    public void setIconFrame() {
        Border border = BorderFactory.createLineBorder(new Color(278079));
        ImageIcon icon = new ImageIcon("../BankApp/icons/turquoise-icons/user-plus.svg");
        userIcon = new JLabel("User Register Panel");
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
        userNameLabel = new JLabel("User Name: ");
        userNameLabel.setForeground(new Color(278079));
        userNameLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));

        userNameField = new JTextField();
        userNameField.setFont(new Font("Century Gothic", Font.BOLD, 20));
        userNameField.setForeground(new Color(278079));
        userNameField.setBackground(Color.white);     
    }

    public void setEmailFrame() {
        userEmailLabel = new JLabel("User Email: ");
        userEmailLabel.setForeground(new Color(278079));
        userEmailLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));

        userEmailField = new JTextField();
        userEmailField.setFont(new Font("Century Gothic", Font.BOLD, 20));
        userEmailField.setForeground(new Color(278079));
        userEmailField.setBackground(Color.white);  
    }

    public void setJobFrame() {
        userJobLabel = new JLabel("Job: ");
        userJobLabel.setForeground(new Color(278079));
        userJobLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));
        
        jobComboBox = new JComboBox<String>();
        jobComboBox.setForeground(new Color(278079));
        jobComboBox.setFont(new Font("Century Gothic", Font.BOLD, 20));
        //Set Items from the DB later
        jobComboBox.addItem("Officer");
        jobComboBox.addItem("Trader");
        jobComboBox.addItem("White-Collar");
        jobComboBox.addItem("Blue-Collar");
        jobComboBox.addItem("Student");
    }

    @Override
    public void setPasswordFrame() {
        userPasswordLabel = new JLabel("Password: ");
        userPasswordLabel.setForeground(new Color(278079));
        userPasswordLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));

        passwordField = new JTextField();
        passwordField.setFont(new Font("Century Gothic", Font.BOLD, 20));
        passwordField.setForeground(new Color(278079));
        passwordField.setBackground(Color.white);   
    }

    public void setPasswordCommitFrame() {
        userCommitPasswordLabel = new JLabel("Commit Password: ");
        userCommitPasswordLabel.setForeground(new Color(278079));
        userCommitPasswordLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));

        passworCommitdField = new JTextField();
        passworCommitdField.setFont(new Font("Century Gothic", Font.BOLD, 20));
        passworCommitdField.setForeground(new Color(278079));
        passworCommitdField.setBackground(Color.white);  
    }

    @Override
    public void setLoginButton() {
        registerButton = new JButton("Register");
        registerButton.setFont(new Font("Century Gothic", Font.BOLD, 20));
        registerButton.setBackground(new Color(278079));
        registerButton.setForeground(Color.white);
        registerButton.addActionListener(this);    
    }

    @Override
    public JPanel getPanel() {
        return registerPanel;
    }

    @Override
    public void setComponents() {
        setIconFrame();
        setNameFrame();
        setEmailFrame();
        setJobFrame();
        setPasswordFrame();
        setPasswordCommitFrame();
        setLoginButton();
    }

    @Override
    public void setLayoutComponents() {
        registerPanel.add(new JLabel());
        registerPanel.add(userIcon);
        registerPanel.add(userNameLabel);
        registerPanel.add(userNameField);
        registerPanel.add(userEmailLabel);
        registerPanel.add(userEmailField);
        registerPanel.add(userJobLabel);
        registerPanel.add(jobComboBox);
        registerPanel.add(userPasswordLabel);
        registerPanel.add(passwordField);
        registerPanel.add(userCommitPasswordLabel);
        registerPanel.add(passworCommitdField);
        registerPanel.add(new JLabel());
        registerPanel.add(registerButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
