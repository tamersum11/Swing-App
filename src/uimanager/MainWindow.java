package uimanager;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;

public final class MainWindow extends JFrame {
    private static MainWindow mainWindow;

    private JFrame mainFrame;
    private ImageIcon frameIcon;
    private JPanel mainUpPanel;
    private JPanel mainDownPanel;
    private JPanel mainCenterPanel;
    private JPanel frameHolderEast;
    private JPanel frameHolderWest;

    private MainWindow() {
        mainFrame = new JFrame();
        frameIcon = new ImageIcon("../BankApp/icons/turquoise-icons/trello.svg");

        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainFrame.setSize(600, 450);
        mainFrame.setLayout(new BorderLayout(50, 100));
        mainFrame.setTitle("Desktop BankApp");

        DefaultMainUpPanel panelUp = new DefaultMainUpPanel();
        LoginPanel panelCenter = new LoginPanel();
        DefaultMainDownPanel panelDown = new DefaultMainDownPanel();

        setMainUpPanel(panelUp.getPanel());
        setMainCenterPanel(panelCenter.getPanel());
        setMainDownPanel(panelDown.getPanel());
        setFrameHolderPanels(0, 0);
    }

    public void setMainUpPanel(JPanel panelUp) {
        mainUpPanel = panelUp;
    }

    public void setMainCenterPanel(JPanel panelCenter) {
        mainCenterPanel = panelCenter;
    }

    public void setMainDownPanel(JPanel panelDown) {
        mainDownPanel = panelDown;
    }

    public void setFrameHolderPanels(int width, int height) {
        frameHolderEast = new JPanel();
        frameHolderEast.setPreferredSize(new Dimension(width, height));

        frameHolderWest = new JPanel();
        frameHolderWest.setPreferredSize(new Dimension(width, height));
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
        mainFrame.add(mainUpPanel, BorderLayout.NORTH);
        mainFrame.add(mainCenterPanel, BorderLayout.CENTER);
        mainFrame.add(mainDownPanel, BorderLayout.SOUTH);
        mainFrame.add(frameHolderEast, BorderLayout.EAST);
        mainFrame.add(frameHolderWest, BorderLayout.WEST);
    }
}
