import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;

public class PDONewGui extends JFrame implements ActionListener, ItemListener {

	PDOEngine myengine;
	JList newlist;
	JList methodlist;
	JList detailList;
	String[] ret_temp = { "1", "1", "1" };
	JButton okbutton;
	JButton randombutton;
	DefaultListModel detmodel;
	JPanel selecttypepanel;
	JScrollPane methodlistScrollPane;
	JScrollPane listScrollPane;

	public PDONewGui(PDOEngine engine) throws IOException {
		initialize();
		myengine = engine;

	}

	private void initialize() {
		// új frame

		// visszatérési értékhez kell
		setTitle("Új feladat");
		// új ablak mérete
		setBounds(200, 100, 600, 350);

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
		listScrollPane = new JScrollPane(newlist);
		listScrollPane.setPreferredSize(new Dimension(150, 150));
		DefaultListModel metmodel = new DefaultListModel();
		metmodel.addElement("Kiválasztott feladat");
		metmodel.addElement("Véletlenszerû feladat");
		metmodel.addElement("Összes feladat");
		methodlist = new JList(metmodel);

		methodlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		methodlist.setSelectedIndex(0);
		methodlistScrollPane = new JScrollPane(methodlist);
		methodlistScrollPane.setPreferredSize(new Dimension(150, 150));

		JLabel instrtext = new JLabel();
		instrtext.setText("Add meg a választott témakört, feladatot");
		instrtext.enable(false);
		//JTextPane instrtext = new JTextPane();
		//instrtext.setText("Add meg a választott témakört, feladatot");
		//instrtext.enable(false);

		selecttypepanel = new JPanel();
		// JPanel methodselecttypepanel = new JPanel();
		JPanel okbuttonpanel = new JPanel();

		okbutton = new JButton("OK");
		randombutton = new JButton("Random");
		okbutton.addActionListener(this);
		randombutton.addActionListener(this);

		selecttypepanel.add(listScrollPane);
		selecttypepanel.add(methodlistScrollPane);
		jobDetail("Heap");
		okbuttonpanel.add(okbutton);
		okbuttonpanel.add(randombutton);
		getContentPane().add(instrtext, BorderLayout.NORTH);
		getContentPane().add(selecttypepanel, BorderLayout.CENTER);
		// newgui.getContentPane().add(methodselecttypepanel,
		// BorderLayout.EAST);
		getContentPane().add(okbuttonpanel, BorderLayout.SOUTH);
		// setsetting = false;
		// newgui.setVisible(true);
		newlist.addMouseListener(mouseListener);
		// myengine.newMethod(ret_temp);
	}

	public void newGui() {
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
			String temp_3 = (String) detailList.getSelectedValue();
			ret_temp[0] = temp_1;
			ret_temp[1] = temp_2;
			ret_temp[2] = temp_3;

			System.out.println(ret_temp[0]);
			System.out.println(ret_temp[1]);
			System.out.println(ret_temp[2]);
			myengine.newMethod(ret_temp);
			setVisible(false);

		} else if (com.equals("Random")) {

			System.out.println("Random");
			setVisible(false);
		}
	}

	MouseListener mouseListener = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 1) {
				String selectedItem = (String) newlist.getSelectedValue();
				jobDetail(selectedItem);

			}
		}
	};

	public void jobDetail(String item) {

		detmodel = new DefaultListModel();
		switch (item) {
		case "Heap":
			detmodel.addElement("1.1 Átlagos keresési idõ");
			detmodel.addElement("1.2 Maximális keresési idõ");
			detmodel.addElement("1.3 Egy rekord megtalálási ideje");
			detmodel.addElement("1.4 Egy rekord törlési ideje");
			toNewGui(detmodel);

			break;

		case "Hash":
			detmodel.addElement("2.1 Vödörkatalódus mérete");
			detmodel.addElement("2.2 Katalógus operatív tárba");
			detmodel.addElement("2.3 Rekord elérésének átlagos ideje");
			detmodel.addElement("2.4 Rekord elérésének maximális ideje");
			detmodel.addElement("2.4 Rekord elérése bizonyos idõ alatt");
			toNewGui(detmodel);
			break;

		case "Ritka index szervezés":
			detmodel.addElement("3.1 Teljes struktúra tárolásához szükséges blokkok");
			detmodel.addElement("3.2 Rekord elérési ideje");
			detmodel.addElement("3.3 Rekord kiolvasásának ideje");
			
			toNewGui(detmodel);
			break;

		case "Többszintû indexek":
			detmodel.addElement("4.1 Állomány tárolásához szükséges blokkok száma");
			detmodel.addElement("4.2 Állomány tárolásához szükséges tárterület");
			toNewGui(detmodel);
			break;

		case "B* fák":
			detmodel.addElement("5.1 Elem eléréséhez szükséges blokkmûvletek");
			detmodel.addElement("5.2 Állomány tárolásához szükséges idõ");
			detmodel.addElement("5.3 B* fa blocking factorának kiszámolása");
			detmodel.addElement("5.4 B* fa blocking szintjeinek számának kiszámolása");
			detmodel.addElement("5.4 Rekord elérése bizonyos idõ alatt");
			toNewGui(detmodel);
			break;

		}

	}

	public void toNewGui(DefaultListModel model) {
		selecttypepanel.removeAll();
		selecttypepanel.add(listScrollPane);
		selecttypepanel.add(methodlistScrollPane);
		setVisible(true);
		detailList = new JList(model);
		detailList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		detailList.setSelectedIndex(0);
		JScrollPane detScrollPane = new JScrollPane(detailList);
		detScrollPane.setPreferredSize(new Dimension(200, 150));
		selecttypepanel.add(detScrollPane);
		setVisible(true);
	}

}
