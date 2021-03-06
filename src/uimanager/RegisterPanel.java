package uimanager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import appmanager.UserRegisterManager;
import appmanager.UserRegisterManager.UserBuilder;
import dbmanager.IDBManager;
import dbmanager.QueryFactory;

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
    private JPasswordField passwordField;
    private JPasswordField passworCommitdField;
    private JButton registerButton;
    private JComboBox<String> jobComboBox;
    private JFrame messageBox;

    public RegisterPanel() {
        registerPanel = new JPanel();
        registerPanel.setPreferredSize(new Dimension(400, 400));
        registerPanel.setLayout(new GridLayout(8, 2, 0, 0));

        messageBox = new JFrame();
        setComponents();
        setLayoutComponents();
    }

    @Override
    public void setIconFrame() {
        Border border = BorderFactory.createLineBorder(new Color(278079));
        ImageIcon icon = new ImageIcon("../Swing-App/icons/turquoise-icons/user-plus.svg");
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

    private void setJobComboBoxItems() {
        IDBManager selectJobs = QueryFactory.getQuery("selectall");
        selectJobs.setTable("Jobs");
        selectJobs.setQuery();
        ResultSet jobs = selectJobs.getResult();
        try {
            while(jobs.next()){
                jobComboBox.addItem(jobs.getString("Job"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(messageBox, e.getMessage() + ". Jobs Couldn't Load From Database!!!", "Database Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void setJobFrame() {
        userJobLabel = new JLabel("Job: ");
        userJobLabel.setForeground(new Color(278079));
        userJobLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));
        
        jobComboBox = new JComboBox<String>();
        jobComboBox.setForeground(new Color(278079));
        jobComboBox.setFont(new Font("Century Gothic", Font.BOLD, 20));
        
        setJobComboBoxItems();
    }

    @Override
    public void setPasswordFrame() {
        userPasswordLabel = new JLabel("Password: ");
        userPasswordLabel.setForeground(new Color(278079));
        userPasswordLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Century Gothic", Font.BOLD, 20));
        passwordField.setForeground(new Color(278079));
        passwordField.setBackground(Color.white);   
    }

    public void setPasswordCommitFrame() {
        userCommitPasswordLabel = new JLabel("Commit Password: ");
        userCommitPasswordLabel.setForeground(new Color(278079));
        userCommitPasswordLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));

        passworCommitdField = new JPasswordField();
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
        UserRegisterManager registerManager = new UserBuilder(userEmailField.getText(), (passwordField.getPassword() == null) ? "" : (String)passwordField.getText(), 
                                                             (passworCommitdField.getPassword() == null) ? "" : (String)passworCommitdField.getText())
                                                             .name(userNameField.getText())
                                                             .job(jobComboBox.getSelectedItem().toString())
                                                             .build();
        if(registerManager != null) {
            registerManager.register();
        } else {
            JOptionPane.showMessageDialog(messageBox, "Failed to register!!!", "Registration Error", JOptionPane.WARNING_MESSAGE);
        }
    }
}
