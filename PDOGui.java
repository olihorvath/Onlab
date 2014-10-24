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
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import java.util.logging.Logger;


public class PDOGui extends JFrame  implements ActionListener,
ItemListener {
	// alkamazásmotor elinditása
	PDOEngine pdoengine;
	PDONewGui newgui;
	JTable inputtable;
	static int frameweight = 800; // ablak szélessége
	static int frameheight = 600; // ablak magassága
	static int initx = 100;  
	static int inity = 75;
	static int inputweight = 600; // input labelek szélessége
	static int inputheight = 10; // input labelek magassága
	
	public PDOGui() throws IOException {
		initialize();
		pdoengine = new PDOEngine(this);
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
		setBounds(initx, inity, frameweight, frameheight);
		
		
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
	
	// 
	public void inputTable (float blocksize, float recsize, float recnum,float key, 
			float pointer,float bucket,float blockop,float freememo ){
		 
		
		JPanel inputpanel = new JPanel ();
		JLabel inputlabel = new JLabel("Inputok:");
		JLabel blocksizelabel = new JLabel ("Blokk méret: " + (int) blocksize+" bájt");
		JLabel recordsizelabel = new JLabel ("Rekord méret: " +(int) recsize+" bájt");
		JLabel recordnumberlabel = new JLabel ("Rekordok száma: " + (int) recnum+" darab");
		JLabel keylabel = new JLabel ("Kulcs mérete: " + (int)key +" bájt");
		JLabel pointerlabel = new JLabel ("Pointer mérete: " + (int) pointer +" bit");
		JLabel bucketlabel = new JLabel ("Vödör mérete: " + (int) bucket +" bájt");
		JLabel blockoplabel = new JLabel ("Blokkmûvelet ideje: " + (int) blockop +" ms");
		JLabel freememolabel = new JLabel ("Szabad memóriaterület: " + (int) freememo + " bájt");
		inputlabel.setSize (inputweight, inputheight);
		blocksizelabel.setSize (inputweight, inputheight);
		recordsizelabel.setSize (inputweight, inputheight);
		recordnumberlabel.setSize (inputweight, inputheight);
		keylabel.setSize (inputweight, inputheight);
		pointerlabel.setSize (inputweight, inputheight);
		bucketlabel.setSize (inputweight, inputheight);
		blockoplabel.setSize (inputweight, inputheight);
		freememolabel.setSize (inputweight, inputheight);
		
		
		inputpanel.add(inputlabel);
		inputpanel.add(blocksizelabel);
		inputpanel.add(recordsizelabel);
		inputpanel.add(recordnumberlabel);
		inputpanel.add(keylabel);
		inputpanel.add(pointerlabel);
		inputpanel.add(bucketlabel);
		inputpanel.add(blockoplabel);
		inputpanel.add(freememolabel);
		
		getContentPane().add(inputpanel, BorderLayout.NORTH);
		
		setVisible(true);
		
	}
	
	
	
}
