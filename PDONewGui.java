import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;


public class PDONewGui extends JFrame implements ActionListener,
ItemListener {
	
	PDOEngine myengine;
	JList newlist;
	JList methodlist;
	String [] ret_temp  = {"1","1"};
	JButton okbutton;
	JButton randombutton;
	
	public PDONewGui(PDOEngine engine) throws IOException {
		initialize();
		myengine = engine;
		
		
	}
	
	private void initialize (){
		// új frame
		
		//visszatérési értékhez kell
		setTitle("Új feladat");
		// új ablak mérete
		setBounds(200, 100, 290, 260);
		
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
        
        okbutton = new JButton ("OK");
		randombutton = new JButton ("Random");
		okbutton.addActionListener(this);
		randombutton.addActionListener(this);
        
		selecttypepanel.add(listScrollPane);
		selecttypepanel.add(methodlistScrollPane);
		okbuttonpanel.add(okbutton);
		okbuttonpanel.add(randombutton);
		getContentPane().add(instrtext, BorderLayout.NORTH);
		getContentPane().add(selecttypepanel, BorderLayout.CENTER);
		//newgui.getContentPane().add(methodselecttypepanel, BorderLayout.EAST);
		getContentPane().add(okbuttonpanel, BorderLayout.SOUTH);
		//setsetting = false;
		//newgui.setVisible(true);
		
		//myengine.newMethod(ret_temp);
	} 

	
	public void newGui(){
		setVisible(true);
		
	}
	
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	 
	 
	 public void actionPerformed(ActionEvent arg0) {
			String com = ((JButton) arg0.getSource()).getText();
			
			if (com.equals("OK")) {
				String temp_1 = (String) newlist.getSelectedValue();
				String temp_2 = (String) methodlist.getSelectedValue();
				ret_temp[0] = temp_1;
				ret_temp[1] = temp_2;
				
				System.out.println (ret_temp[0]);
				System.out.println (ret_temp[1]);
				myengine.newMethod(ret_temp);
				
			} else if (com.equals("Random")) {
				
				System.out.println ("Random");
				
			} 
		}
}
