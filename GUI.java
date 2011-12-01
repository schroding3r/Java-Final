package banking;
 
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
 
/*
Code stolen from an Oracle tutorial
 */
public class GUI extends JPanel
                        implements ActionListener {
  private static final long serialVersionUID = 1L;
	protected JButton b1, b2, b3;
 
    public GUI() {
 
        b1 = new JButton("Print Records");
        b1.setVerticalTextPosition(AbstractButton.CENTER);
        b1.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales
        b1.setMnemonic(KeyEvent.VK_D);
        b1.setActionCommand("recordprint");
 
        b2 = new JButton("Delete Records");
        b2.setVerticalTextPosition(AbstractButton.BOTTOM);
        b2.setHorizontalTextPosition(AbstractButton.CENTER);
        b2.setMnemonic(KeyEvent.VK_M);
        b2.setActionCommand("recorddel");
 
        b3 = new JButton("Do Nothing");
        //Use the default text position of CENTER, TRAILING (RIGHT).
        b3.setMnemonic(KeyEvent.VK_E);
        b3.setActionCommand("nothing");
       // b3.setEnabled(false);
 
        //Listen for actions on buttons 1 and 3.
        b1.addActionListener(this);
        b3.addActionListener(this);
 
        b1.setToolTipText("Click this button to disable the middle button.");
        b2.setToolTipText("This middle button does nothing when you click it.");
        b3.setToolTipText("Click this button to enable the middle button.");
 
        //Add Components to this container, using the default FlowLayout.
        add(b1);
        add(b2);
        add(b3);
    }
 
    public void actionPerformed(ActionEvent e) 
    {
        if ("recordprint".equals(e.getActionCommand())) 
        {
        	int r=Integer.valueOf(JOptionPane.showInputDialog("Which Record?"));
        	JOptionPane.showMessageDialog(null, Interact.getFancyString(r), "Record Info", JOptionPane.INFORMATION_MESSAGE);
        }
        else if("nothing".equals(e.getActionCommand()))
        {
        	
    
        }
        else if("test".equals(e.getActionCommand()))
        {
        	System.out.println("Hello, world!");
        };
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
 
        //Create and set up the window.
        JFrame frame = new JFrame("Banking");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        GUI newContentPane = new GUI();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    public static void main() 
    {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    };
}