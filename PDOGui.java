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
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.util.HashMap;
import java.util.logging.Logger;


public class PDOGui extends JFrame  implements ActionListener,
ItemListener {
	// alkamazásmotor elinditása
	PDOEngine pdoengine;
	PDONewGui newgui;
	JTable inputtable;
	JPanel functionpanel;
	static int frameweight = 800; // ablak szélessége
	static int frameheight = 600; // ablak magassága
	static int initx = 100;  
	static int inity = 75;
	static int inputweight = 600; // input labelek szélessége
	static int inputheight = 10; // input labelek magassága
	//csak a végeredményhez
	JButton resultbutton;
	JTextField resultfield;
	JPanel simpleresults;
	// részletes eredményekhez
	JButton fullresultbutton;
	JTextField fullresultfield;
	JPanel fullresults;
	JPanel fullresultsdetails;
	JTable resultstable;
	DefaultTableModel resultsmodel;
	
	
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
		functionpanel = new JPanel();
		functionpanel.setLayout(new BorderLayout());
		add(functionpanel, BorderLayout.CENTER);
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
			pdoengine.simpleMode();
		} else if (com.equals("Részletes")) {
			pdoengine.fullMode();
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
		
		inputtable.enable(false);
		inputpanel.setLayout(new BorderLayout());
		inputpanel.add(inputlabel, BorderLayout.NORTH);
		inputpanel.add(inputtable.getTableHeader(), BorderLayout.CENTER);
		inputpanel.add(inputtable, BorderLayout.SOUTH);
		
		add(inputpanel, BorderLayout.NORTH);
		pdoengine.newFunction();
		
		
		setVisible(true);
		
	}
	
	public void onFunction(String function){
		JLabel functionlabel = new JLabel (function);
		functionpanel.removeAll();
		functionpanel.add(functionlabel, BorderLayout.NORTH);
		
	}
	
	public void simpleSolution (){
		if (fullresults != null)
			functionpanel.remove(fullresults);
		if (simpleresults != null)
			functionpanel.remove(simpleresults);
		
		
		simpleresults = new JPanel();
		//simpleresults.setLayout(new BorderLayout());
		JLabel inresult = new JLabel ("Add meg az eredményt: ");
		resultfield = new JTextField (20);
		
		resultbutton = new JButton ("Ellenõriz");
		
		resultbutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
            {
				if (!resultfield.getText().equals("")){ // ha nem üres a mezõ, akkor check
               pdoengine.simpleResultsCheck(resultfield.getText()); 
            
				}
            }
			
		});
		
		
		simpleresults.add(inresult);
		simpleresults.add(resultfield);
		simpleresults.add(resultbutton);
		functionpanel.add(simpleresults, BorderLayout.CENTER);
		setVisible(true);
	
	}
	
	public void fullSolutionInit (String subfunc){
		
		//pdoengine.getFunction();
		
		// ha volt már a functionpanelen valami, akkor törölni kell
		if (fullresults != null)
			functionpanel.remove(fullresults);
		if (simpleresults != null)
			functionpanel.remove(simpleresults);
		fullresults = new JPanel();
		fullresultfield = new JTextField (20);
		fullresultbutton = new JButton ("Tovább");
		JLabel fullresultlabel = new JLabel (subfunc);
		fullresults.removeAll();
		fullresults.add(fullresultlabel);
		fullresultbutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
            {
				pdoengine.nextStep();
            }
			
		});
		
		
		fullresults.add(fullresultfield);
		fullresults.add(fullresultbutton);
		functionpanel.add(fullresults, BorderLayout.CENTER);
		
		resultsmodel = new DefaultTableModel ();
		resultstable = new JTable(resultsmodel);
		
		fullresultsdetails = new JPanel();
		fullresultsdetails.setLayout(new BorderLayout());
		
		fullresultsdetails.add(resultstable.getTableHeader(), BorderLayout.NORTH);
		fullresultsdetails.add(resultstable, BorderLayout.CENTER);
		fullresultsdetails.setPreferredSize(new Dimension( 300, 300) );
		functionpanel.add(fullresultsdetails, BorderLayout.SOUTH);
	
		resultsmodel.addColumn("Lépés"); 
		resultsmodel.addColumn("Eredmény");
		resultsmodel.addRow(new Object[]{"Dummy", "Dummy"});
		
		setVisible(true);
		
	}
	
	public void fullSolutionnext (String subfunc){
		functionpanel.remove(fullresults);
		JLabel fullresultlabel = new JLabel (subfunc);
		fullresults.removeAll();
		fullresults.add(fullresultlabel);
		fullresults.add(fullresultfield);
		fullresults.add(fullresultbutton);
		//
		functionpanel.add(fullresults, BorderLayout.CENTER);
		
	}
	
	
	public void fullSolutionAddRow (String comment, String results){
		int index= resultsmodel.getRowCount()-1;
		//System.out.println (index);
		Object lastres = resultsmodel.getValueAt(index,0);
		if (lastres != (Object) comment)
		resultsmodel.addRow(new Object[]{comment, results});
	}
	
	
}
