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
	// alkamaz�smotor elindit�sa
	PDOEngine pdoengine;
	PDONewGui newgui;
	JTable inputtable;
	JPanel functionpanel;
	static int frameweight = 800; // ablak sz�less�ge
	static int frameheight = 600; // ablak magass�ga
	static int initx = 100;  
	static int inity = 75;
	static int inputweight = 600; // input labelek sz�less�ge
	static int inputheight = 10; // input labelek magass�ga
	//csak a v�geredm�nyhez
	JButton resultbutton;
	JTextField resultfield;
	JPanel simpleresults;
	// r�szletes eredm�nyekhez
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
		setTitle("Fizikai adatszervez�s");
		JPanel pdoPanel = new JPanel();
		JMenuBar pdoMenuBar = new JMenuBar();
		JMenu pdoMenu = new JMenu("Menu");
		JMenu pdoSettings = new JMenu("Be�ll�t�sok");
		JMenuItem pdoMenuItemNew = new JMenuItem ("�j");
		JMenuItem pdoMenuItemSave = new JMenuItem ("Ment�s");
		JMenuItem pdoMenuItemLoad = new JMenuItem ("Bet�lt�s");
		JMenu pdoSettingsItemMode = new JMenu ("�zemm�d");
		JMenuItem pdoSimpleMode = new JMenuItem ("Egyszer�");
		JMenuItem pdoFullMode = new JMenuItem ("R�szletes");
		
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

	
	
	// itt kezel�dik le a men�pontokra val� kattint�s esem�nye
	public void actionPerformed(ActionEvent arg0) {
		String com = ((JMenuItem) arg0.getSource()).getText();
		
		if (com.equals("�j")) {
			try {
				newgui = new PDONewGui(pdoengine);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			newgui.newGui();
			
		} else if (com.equals("Ment�s")) {
			pdoengine.saveMethod();
		} else if (com.equals("Bet�lt�s")) {
			pdoengine.loadMethod();
		} else if (com.equals("Egyszer�")) {
			pdoengine.simpleMode();
		} else if (com.equals("R�szletes")) {
			pdoengine.fullMode();
		} 
	
	}
	
	// 
	public void inputTable (float blocksize, float recsize, float recnum,float key, 
			float pointer,float bucket,float blockop,float freememo ){
		 
		
		JPanel inputpanel = new JPanel ();
		
		
		String[] columnNames = {"N�v",
                "�rt�k",
                "M�rt�kegys�g"
                };

		Object[][] data = {
				{"Blokk m�ret", (int) blocksize, "b�jt"},
				{"Rekord m�ret", (int) recsize, "b�jt"},
				{"Rekordok sz�ma", (int) recnum, "darab"},
				{"Kulcs m�rete", (int) key, "b�jt"},
				{"Pointer m�rete", (int) pointer, "bit"},
				{"V�d�r m�rete", (int) bucket, "b�jt"},
				{"Blokkm�velet ideje", (int) blockop, "ms"},
				{"Szabad mem�riater�let", (int) freememo, "b�jt"},
				
		
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
		JLabel inresult = new JLabel ("Add meg az eredm�nyt: ");
		resultfield = new JTextField (20);
		
		resultbutton = new JButton ("Ellen�riz");
		
		resultbutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
            {
				if (!resultfield.getText().equals("")){ // ha nem �res a mez�, akkor check
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
		
		// ha volt m�r a functionpanelen valami, akkor t�r�lni kell
		if (fullresults != null)
			functionpanel.remove(fullresults);
		if (simpleresults != null)
			functionpanel.remove(simpleresults);
		fullresults = new JPanel();
		fullresultfield = new JTextField (20);
		fullresultbutton = new JButton ("Tov�bb");
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
	
		resultsmodel.addColumn("L�p�s"); 
		resultsmodel.addColumn("Eredm�ny");
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
