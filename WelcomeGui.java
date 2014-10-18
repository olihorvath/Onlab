import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class WelcomeGui extends JFrame implements ActionListener,
ItemListener {
	
	Serialization Test = new Serialization ();
	public WelcomeGui() throws IOException {
		initialize();
	}
	
	
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	private void initialize() throws IOException {
		//felveszem a WelcomeGui reszeit
		
		JPanel wgPanel = new JPanel();
		JMenuBar wgMenuBar = new JMenuBar();
		JMenu wgMenu = new JMenu("Menu");
		JMenuItem wgMenuItemSave = new JMenuItem ("Ment�s");
		JMenuItem wgMenuItemLoad = new JMenuItem ("Bet�lt�s");
		wgMenuItemSave.addActionListener(this);
		wgMenuItemLoad.addActionListener(this);
		ImageIcon dblogo = new ImageIcon("logo.png");
		JButton nfButton = new JButton ("Norm�lform�kra bont�s", dblogo);
		JButton fsButton = new JButton ("Fizikai adatszervez�s", dblogo);
		
		// Buttonok beallitasa
		nfButton.setPreferredSize(new Dimension (270,200));
		fsButton.setPreferredSize(new Dimension (270,200));
		fsButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
            {
                PDOGui pdogui;
				try {
					pdogui = new PDOGui();
					pdogui.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                
                
            }
			
		});
		
		//a komponenseket itt rakom ossze
		wgPanel.add(nfButton);
		wgPanel.add(fsButton);
		
		wgMenu.add(wgMenuItemSave);
		wgMenu.add(wgMenuItemLoad);
		
		wgMenuBar.add(wgMenu);
		
		setJMenuBar(wgMenuBar);
		
		getContentPane().add(wgPanel, BorderLayout.CENTER);
		setBounds(200, 100, 600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	public void actionPerformed(ActionEvent arg0) {
		String com = ((JMenuItem) arg0.getSource()).getText();
		if (com.equals("Ment�s")) {
			Test.SaveMethod();
		} else if (com.equals("Bet�lt�s")) {
			Test.LoadMethod();
			
			
		} 
		
	}
	

}
