
public class PDOEngine extends Engine {
	Serialization pdoser = new Serialization ();
	int a = 0;
	
	public PDOEngine (){
			
	}
	
	public void newMethod (String[] feladat){
		
	}
	//mentés metódus
	public void saveMethod(){
	pdoser.saveMethod();	
		
	}
	//betöltés metódus
	public void loadMethod(){
	pdoser.loadMethod();	
	}
	
}
