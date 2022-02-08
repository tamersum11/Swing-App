package uimanager;

import java.awt.BorderLayout;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AdminMainWindow extends JFrame{
    private static AdminMainWindow adminMainWindow;

    private JFrame adminMainFrame;
    private ImageIcon adminFrameIcon;
    private JPanel adminMainDownPanel;
    private ResultSet adminInfo;

    private AdminMainWindow() {
        adminMainFrame = new JFrame();
        adminFrameIcon = new ImageIcon("../Swing-App/icons/turquoise-icons/trello.svg");

        adminMainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        adminMainFrame.setSize(800, 800);
        adminMainFrame.setTitle("Desktop BankApp Admin Panel");
        adminMainFrame.setLayout(new BorderLayout(0, 0));

        DefaultMainDownPanel panelDown = new DefaultMainDownPanel();
        adminMainDownPanel = panelDown.getPanel();
    }

    public void setAdminInfo(ResultSet adminInfo) {
        this.adminInfo = adminInfo;
    }

    public ResultSet getAdminInfo() {
        return adminInfo;
    }
    
    public static AdminMainWindow getWindow() {
        if(adminMainWindow == null)
        {
            adminMainWindow = new AdminMainWindow();
        }
        return adminMainWindow;
    }

    public void show() {
        adminMainFrame.setVisible(true);
        adminMainFrame.setIconImage(adminFrameIcon.getImage());
        adminMainFrame.add(adminMainDownPanel, BorderLayout.SOUTH);
    }
}
