import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;


public class Serialization {

	
	public void saveMethod(PDOData data) {
		JFileChooser chooser1 = new JFileChooser(System.getProperty("user.dir"));
		if (chooser1.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			if (chooser1.getSelectedFile() != null) {
				ObjectOutput output;
				try {
					output = new ObjectOutputStream(new FileOutputStream(
							chooser1.getSelectedFile()));
					output.writeObject(data);
					output.close();
				} catch (NotSerializableException e) {
					
				} catch (IOException e) {
					//e.printStackTrace();
				}
			}
		}
	}
	
	
	public PDOData loadMethod() {
		final JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
		int temp = fc.showOpenDialog(null);
		PDOData dat = null;
		if (temp == JFileChooser.APPROVE_OPTION) {
			File openedFile = fc.getSelectedFile();
			if (openedFile.exists()) {
				try {
					ObjectInput input = new ObjectInputStream(
							new FileInputStream(openedFile));
					try { 
					dat = (PDOData) input.readObject();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					input.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} 
			}
		} else {
			// CANCELED
		}
		
		return dat;
	}
	
	
	
	
}
