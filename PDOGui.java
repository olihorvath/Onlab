import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;

import java.util.logging.Logger;


public class PDOGui extends JFrame  implements ActionListener,
ItemListener {
	// alkamazásmotor elinditása
	PDOEngine pdoengine;
	PDONewGui newgui;
	public PDOGui() throws IOException {
		initialize();
		pdoengine = new PDOEngine();
		//newgui = new PDONewGui(pdoengine);
		
	}
	
	
	
	private void initialize() throws IOException {
		//felveszem a WelcomeGui reszeit
		setTitle("Fizikai adatszervezés");
		JPanel pdoPanel = new JPanel();
		JMenuBar pdoMenuBar = new JMenuBar();
		JMenu pdoMenu = new JMenu("Menu");
		JMenuItem pdoMenuItemNew = new JMenuItem ("Új");
		JMenuItem pdoMenuItemSave = new JMenuItem ("Mentés");
		JMenuItem pdoMenuItemLoad = new JMenuItem ("Betöltés");
		pdoMenuItemNew.addActionListener(this);
		pdoMenuItemSave.addActionListener(this);
		pdoMenuItemLoad.addActionListener(this);
		
		ImageIcon dblogo = new ImageIcon("logo.png");
		pdoMenu.add(pdoMenuItemNew);
		pdoMenu.add(pdoMenuItemSave);
		pdoMenu.add(pdoMenuItemLoad);
		pdoMenuBar.add(pdoMenu);
		setJMenuBar(pdoMenuBar);
	
		getContentPane().add(pdoPanel, BorderLayout.CENTER);
		setBounds(100, 75, 800, 600);
		
		
	}
	
	
	
	
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
	// itt kezelõdik le a menüpontokra való kattintás eseménye
	public void actionPerformed(ActionEvent arg0) {
		String com = ((JMenuItem) arg0.getSource()).getText();
		
		if (com.equals("Új")) {
			try {
				newgui = new PDONewGui(pdoengine);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			newgui.newGui();
			
		} else if (com.equals("Mentés")) {
			pdoengine.saveMethod();
		} else if (com.equals("Betöltés")) {
			pdoengine.loadMethod();
		} 
	
	}
	
	// új feladat ablakát itt hozom létre
	
	
	
	
}
