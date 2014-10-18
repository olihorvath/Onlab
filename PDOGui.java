import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class PDOGui extends JFrame  implements ActionListener,
ItemListener {
	
	public PDOGui() throws IOException {
		initialize();
	}
	
	
	
	private void initialize() throws IOException {
		//felveszem a WelcomeGui reszeit
		
		JPanel pdoPanel = new JPanel();
		JMenuBar pdoMenuBar = new JMenuBar();
		JMenu pdoMenu = new JMenu("Menu");
		JMenuItem pdoMenuItemNew = new JMenuItem ("�j");
		JMenuItem pdoMenuItemSave = new JMenuItem ("Ment�s");
		JMenuItem pdoMenuItemLoad = new JMenuItem ("Bet�lt�s");
		pdoMenuItemSave.addActionListener(this);
		pdoMenuItemLoad.addActionListener(this);
		ImageIcon dblogo = new ImageIcon("logo.png");
		//JButton nfButton = new JButton ("Norm�lform�kra bont�s", dblogo);
		//JButton fsButton = new JButton ("Fizikai adatszervez�s", dblogo);
		
		// Buttonok beallitasa
		//nfButton.setPreferredSize(new Dimension (270,200));
		//fsButton.setPreferredSize(new Dimension (270,200));
		
		
		//a komponenseket itt rakom ossze
		//wgPanel.add(nfButton);
		//wgPanel.add(fsButton);
		
		pdoMenu.add(pdoMenuItemSave);
		pdoMenu.add(pdoMenuItemLoad);
		
		pdoMenuBar.add(pdoMenu);
		
		setJMenuBar(pdoMenuBar);
		
		getContentPane().add(pdoPanel, BorderLayout.CENTER);
		setBounds(200, 100, 600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	
	
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	public void actionPerformed(ActionEvent arg0) {
		String com = ((JMenuItem) arg0.getSource()).getText();
		if (com.equals("Ment�s")) {
			//Test.SaveMethod();
		} else if (com.equals("Bet�lt�s")) {
			//Test.LoadMethod();
		} 
	
	}
	
	
}
