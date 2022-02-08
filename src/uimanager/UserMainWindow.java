package uimanager;

import java.awt.BorderLayout;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class UserMainWindow extends JFrame{
    private static UserMainWindow userMainWindow;

    private JFrame userMainFrame;
    private ImageIcon userFrameIcon;
    private JPanel userMainDownPanel;
    private ResultSet userInfo;

    private UserMainWindow() {
        userMainFrame = new JFrame();
        userFrameIcon = new ImageIcon("../Swing-App/icons/turquoise-icons/trello.svg");

        userMainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        userMainFrame.setSize(800, 800);
        userMainFrame.setTitle("Desktop BankApp User Panel");
        userMainFrame.setLayout(new BorderLayout(0, 0));

        DefaultMainDownPanel panelDown = new DefaultMainDownPanel();
        userMainDownPanel = panelDown.getPanel();
    }

    public void setUserInfo(ResultSet userInfo) {
        this.userInfo = userInfo;
    }

    public ResultSet getUserInfo() {
        return userInfo;
    }

    public static UserMainWindow getWindow() {
        if(userMainWindow == null)
        {
            userMainWindow = new UserMainWindow();
        }
        return userMainWindow;
    }

    public void show() {
        userMainFrame.setVisible(true);
        userMainFrame.setIconImage(userFrameIcon.getImage());
        userMainFrame.add(userMainDownPanel, BorderLayout.SOUTH);
    }
}
