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
	JList newlist;
	JList methodlist;
	public PDOGui() throws IOException {
		initialize();
		pdoengine = new PDOEngine();
		
	}
	
	
	
	private void initialize() throws IOException {
		//felveszem a WelcomeGui reszeit
		
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
			newGui();
			
		} else if (com.equals("Mentés")) {
			pdoengine.saveMethod();
		} else if (com.equals("Betöltés")) {
			pdoengine.loadMethod();
		} 
	
	}
	
	// új feladat ablakát itt hozom létre
	
	public void newGui (){
		// új frame
		JFrame newgui = new JFrame ("Új feladat");
		//visszatérési értékhez kell
		String [] ret_temp = {"1","1"};
		
		// új ablak mérete
		newgui.setBounds(200, 100, 290, 260);
		
		// új listamodell feltöltve az elemekkel
		DefaultListModel listmodell = new DefaultListModel();
        listmodell.addElement("Heap");
        listmodell.addElement("Hash");
        listmodell.addElement("Ritka index szervezés");
        listmodell.addElement("Többszintû indexek");
        listmodell.addElement("B* fák");
        newlist = new JList(listmodell);
        newlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        newlist.setSelectedIndex(0);
        JScrollPane listScrollPane = new JScrollPane(newlist);
        
        DefaultListModel metmodel = new DefaultListModel();
        metmodel.addElement("Véletlenszerû feladat");
        metmodel.addElement("Összes feladat");
        methodlist = new JList (metmodel);
        
        methodlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        methodlist.setSelectedIndex(0);
        JScrollPane methodlistScrollPane = new JScrollPane(methodlist);
        
        JTextPane instrtext = new JTextPane ();
        instrtext.setText("Add meg a választott témakört, feladatot");
        instrtext.enable(false);
        
        
        JPanel selecttypepanel = new JPanel();
        //JPanel methodselecttypepanel = new JPanel();
        JPanel okbuttonpanel = new JPanel();
        
        JButton okbutton = new JButton ("OK");
		JButton randombutton = new JButton ("Random");
		//okbutton actionlistener
        okbutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
            {
				String temp_2 = (String) newlist.getSelectedValue();
				System.out.println (temp_2);
            }	
		});
        //randombutton actionlistener
        randombutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
            {
				System.out.println ("Random");
            }
		});
        
		selecttypepanel.add(listScrollPane);
		selecttypepanel.add(methodlistScrollPane);
		okbuttonpanel.add(okbutton);
		okbuttonpanel.add(randombutton);
		newgui.getContentPane().add(instrtext, BorderLayout.NORTH);
		newgui.getContentPane().add(selecttypepanel, BorderLayout.CENTER);
		//newgui.getContentPane().add(methodselecttypepanel, BorderLayout.EAST);
		newgui.getContentPane().add(okbuttonpanel, BorderLayout.SOUTH);
		//setsetting = false;
		newgui.setVisible(true);
		
		pdoengine.newMethod(ret_temp);
	} 
	
	
}
