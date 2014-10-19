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
	// alkamaz�smotor elindit�sa
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
		JMenuItem pdoMenuItemNew = new JMenuItem ("�j");
		JMenuItem pdoMenuItemSave = new JMenuItem ("Ment�s");
		JMenuItem pdoMenuItemLoad = new JMenuItem ("Bet�lt�s");
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

	
	
	// itt kezel�dik le a men�pontokra val� kattint�s esem�nye
	public void actionPerformed(ActionEvent arg0) {
		String com = ((JMenuItem) arg0.getSource()).getText();
		
		if (com.equals("�j")) {
			newGui();
			
		} else if (com.equals("Ment�s")) {
			pdoengine.saveMethod();
		} else if (com.equals("Bet�lt�s")) {
			pdoengine.loadMethod();
		} 
	
	}
	
	// �j feladat ablak�t itt hozom l�tre
	
	public void newGui (){
		// �j frame
		JFrame newgui = new JFrame ("�j feladat");
		//visszat�r�si �rt�khez kell
		String [] ret_temp = {"1","1"};
		
		// �j ablak m�rete
		newgui.setBounds(200, 100, 290, 260);
		
		// �j listamodell felt�ltve az elemekkel
		DefaultListModel listmodell = new DefaultListModel();
        listmodell.addElement("Heap");
        listmodell.addElement("Hash");
        listmodell.addElement("Ritka index szervez�s");
        listmodell.addElement("T�bbszint� indexek");
        listmodell.addElement("B* f�k");
        newlist = new JList(listmodell);
        newlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        newlist.setSelectedIndex(0);
        JScrollPane listScrollPane = new JScrollPane(newlist);
        
        DefaultListModel metmodel = new DefaultListModel();
        metmodel.addElement("V�letlenszer� feladat");
        metmodel.addElement("�sszes feladat");
        methodlist = new JList (metmodel);
        
        methodlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        methodlist.setSelectedIndex(0);
        JScrollPane methodlistScrollPane = new JScrollPane(methodlist);
        
        JTextPane instrtext = new JTextPane ();
        instrtext.setText("Add meg a v�lasztott t�mak�rt, feladatot");
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
