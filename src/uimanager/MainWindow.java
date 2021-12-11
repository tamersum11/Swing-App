package uimanager;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

public final class MainWindow extends JFrame {
    private static MainWindow mainWindow;

    private JFrame mainFrame;
    private ImageIcon frameIcon;
    private JPanel mainUpPanel;
    private JPanel mainDownPanel;

    private MainWindow() {
        mainFrame = new JFrame();
        frameIcon = new ImageIcon("../BankApp/icons/turquoise-icons/trello.svg");

        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainFrame.setSize(500, 350);
        mainFrame.setTitle("Desktop BankApp");
        mainFrame.setLayout(new BorderLayout(0, 0));

        DefaultMainUpPanel panelUp = new DefaultMainUpPanel();
        DefaultMainDownPanel panelDown = new DefaultMainDownPanel();

        setMainUpPanel(panelUp.getPanel());
        setMainDownPanel(panelDown.getPanel());
    }

    public void setMainUpPanel(JPanel panelUp) {
        mainUpPanel = panelUp;
    }

    public void setMainDownPanel(JPanel panelDown) {
        mainDownPanel = panelDown;
    }

    public static MainWindow getWindow() {
        if(mainWindow == null)
        {
            mainWindow = new MainWindow();
        }
        return mainWindow;
    }

    public void show() {
        mainFrame.setVisible(true);
        mainFrame.setIconImage(frameIcon.getImage());
        mainFrame.add(mainUpPanel, BorderLayout.CENTER);
        mainFrame.add(mainDownPanel, BorderLayout.SOUTH);
    }
}
