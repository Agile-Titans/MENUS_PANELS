import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class MENUS_PANELSTest {
    MENUS_PANELS app;
    @BeforeEach
    void setUp() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            app = new MENUS_PANELS();
        });
    }

    @AfterEach
    void tearDown() {
        if (app.frame != null) {
            app.frame.dispose(); // close the window after test
        }
    }

    @Test
    void createJFrame() {

        JFrame frame = app.frame;

        assertNotNull(frame);
        assertEquals("Menus and Panels", frame.getTitle());
        assertEquals(800, frame.getWidth());
        assertEquals(600, frame.getHeight());
        LayoutManager layout = app.frame.getContentPane().getLayout();

        assertNotNull(layout);
        assertInstanceOf(GridLayout.class, layout);

        GridLayout grid = (GridLayout) layout;
        assertEquals(1, grid.getRows());
        assertEquals(2, grid.getColumns());
    }

    @Test
    void createFileMenu() {
        JMenu fileMenu = app.fileMenu;

        assertNotNull(fileMenu);
        assertEquals("File", fileMenu.getText());
        assertEquals(4, fileMenu.getItemCount());
    }

    @Test
    void createViewMenu() {
        JMenu viewMenu = app.viewMenu;

        assertNotNull(viewMenu);
        assertEquals("View", viewMenu.getText());
    }

    @Test
    void createHelpMenu() {
        JMenu helpMenu = app.helpMenu;

        assertNotNull(helpMenu);
        assertEquals("Help", helpMenu.getText());
    }

    @Test
    void createLeftPanel() {
        JPanel left = app.leftPanel;

        assertNotNull(left);
        assertEquals(Color.gray, left.getBackground());
        assertEquals(1, left.getComponentCount());

        Component comp = left.getComponent(0);
        assertTrue(comp instanceof JLabel);

        JLabel label = (JLabel) comp;
        assertEquals("Navigation", label.getText());
    }

    @Test
    void createRightPanel() {
        JPanel right = app.rightPanel;

        assertNotNull(right);
        assertEquals(Color.WHITE, right.getBackground());
        assertEquals(1, right.getComponentCount());

        Component comp = right.getComponent(0);
        assertTrue(comp instanceof JLabel);

        JLabel label = (JLabel) comp;
        assertEquals("The Main Workspace", label.getText());
    }
}