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
import javax.swing.table.TableColumn;

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
		JMenu pdoSettings = new JMenu("Beállítások");
		JMenuItem pdoMenuItemNew = new JMenuItem ("Új");
		JMenuItem pdoMenuItemSave = new JMenuItem ("Mentés");
		JMenuItem pdoMenuItemLoad = new JMenuItem ("Betöltés");
		JMenu pdoSettingsItemMode = new JMenu ("Üzemmód");
		JMenuItem pdoSimpleMode = new JMenuItem ("Egyszerû");
		JMenuItem pdoFullMode = new JMenuItem ("Részletes");
		
		pdoMenuItemNew.addActionListener(this);
		pdoMenuItemSave.addActionListener(this);
		pdoMenuItemLoad.addActionListener(this);
		
		pdoSimpleMode.addActionListener(this);
		pdoFullMode.addActionListener(this);
		
		ImageIcon dblogo = new ImageIcon("logo.png");
		pdoMenu.add(pdoMenuItemNew);
		pdoMenu.add(pdoMenuItemSave);
		pdoMenu.add(pdoMenuItemLoad);
		pdoSettingsItemMode.add(pdoSimpleMode);
		pdoSettingsItemMode.add(pdoFullMode);
		pdoSettings.add(pdoSettingsItemMode);
		
		pdoMenuBar.add(pdoMenu);
		pdoMenuBar.add(pdoSettings);
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
		} else if (com.equals("Egyszerû")) {
			//pdoengine.loadMethod();
		} else if (com.equals("Részletes")) {
			//pdoengine.loadMethod();
		} 
	
	}
	
	// 
	public void inputTable (float blocksize, float recsize, float recnum,float key, 
			float pointer,float bucket,float blockop,float freememo ){
		 
		
		JPanel inputpanel = new JPanel ();
		
		
		String[] columnNames = {"Név",
                "Érték",
                "Mértékegység"
                };

		Object[][] data = {
				{"Blokk méret", (int) blocksize, "bájt"},
				{"Rekord méret", (int) recsize, "bájt"},
				{"Rekordok száma", (int) recnum, "darab"},
				{"Kulcs mérete", (int) key, "bájt"},
				{"Pointer mérete", (int) pointer, "bit"},
				{"Vödör mérete", (int) bucket, "bájt"},
				{"Blokkmûvelet ideje", (int) blockop, "ms"},
				{"Szabad memóriaterület", (int) freememo, "bájt"},
				
		
		};
		
		JLabel inputlabel = new JLabel ("Inputok:");
		JTable inputtable = new JTable(data, columnNames);
		//inputtable.setSize(new Dimension(300, 300));
		//inputtable.setPreferredScrollableViewportSize(new Dimension(300, 70));
		//JScrollPane scrollPane = new JScrollPane(inputtable);
		//TableColumn column = inputtable.getColumnModel().getColumn(0);
		//column.setPreferredWidth(150);
		
		//inputpanel.setSize(new Dimension(300, 300));
		inputtable.enable(false);
		inputpanel.setLayout(new BorderLayout());
		inputpanel.add(inputlabel, BorderLayout.NORTH);
		inputpanel.add(inputtable.getTableHeader(), BorderLayout.CENTER);
		inputpanel.add(inputtable, BorderLayout.SOUTH);
		//inputtable.setAutoResizeMode(AUTO_RESIZE_OFF);
		//inputpanel.setPreferredSize(new Dimension(300, 200));
		
		//inputpanel.add(inputtable);
		
		//getContentPane().
		add(inputpanel, BorderLayout.NORTH);
		
		setVisible(true);
		
	}
	
	
	
	
	
}
