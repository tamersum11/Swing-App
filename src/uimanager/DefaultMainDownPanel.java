package uimanager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DefaultMainDownPanel extends JPanel implements IPanelManager{
    private JPanel mainDownPanel;
    private JLabel label;
    
    public DefaultMainDownPanel() {
        mainDownPanel = new JPanel();
        mainDownPanel.setPreferredSize(new Dimension(100, 50));
        mainDownPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        setComponents();
        setLayoutComponents();
    }

    @Override
    public JPanel getPanel() {
        return this.mainDownPanel;
    }

    @Override
    public void setLayoutComponents() {
        mainDownPanel.add(label);  
    }

    @Override
    public void setComponents() {
        label = new JLabel("Desktop Bank Application v1.0");
        label.setFont(new Font("Century Gothic", Font.BOLD, 20));
        label.setForeground(new Color(278079));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        
    }
}
