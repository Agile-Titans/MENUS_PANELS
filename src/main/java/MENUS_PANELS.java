import javax.swing.*;
import java.awt.*;

public class MENUS_PANELS {
    JFrame frame;
    JPanel leftPanel;
    JPanel rightPanel;
    JMenuBar menuBar;
    JMenu fileMenu, viewMenu, helpMenu;

    public MENUS_PANELS() {
        this.createJFrame();
    }

    public void createJFrame() {
        frame = new JFrame("Menus and Panels");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new GridLayout(1, 2));
        createMenus();
        frame.setJMenuBar(menuBar);
        createLeftPanel();
        createRightPanel();
        frame.add(leftPanel);
        frame.add(rightPanel);
        frame.setVisible(true);
    }

    private void createMenus() {
        menuBar = new JMenuBar();
        createFileMenu();
        createViewMenu();
        createHelpMenu();
        menuBar.add(fileMenu);
        menuBar.add(viewMenu);
        menuBar.add(helpMenu);
    }
    public void createFileMenu(){
        fileMenu = new JMenu("File");
        JMenuItem newItem = new JMenuItem("New Project");
        JMenuItem openItem = new JMenuItem("Open Project");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);
    }
    public void createViewMenu(){
        viewMenu = new JMenu("View");
    }
    public void createHelpMenu(){
        helpMenu = new JMenu("Help");
    }

    public void createLeftPanel() {
        leftPanel = new JPanel();
        leftPanel.setBackground(Color.gray);
        JLabel navLabel = new JLabel("Navigation", SwingConstants.CENTER);
        navLabel.setFont(new Font("Arial", Font.BOLD, 22));
        leftPanel.add(navLabel);
    }
    public void createRightPanel() {
        rightPanel = new JPanel();
        rightPanel.setBackground(Color.WHITE);
        JLabel contentLabel = new JLabel("The Main Workspace", SwingConstants.CENTER);
        contentLabel.setFont(new Font("Arial", Font.BOLD, 24));
        rightPanel.add(contentLabel);
    }
}
