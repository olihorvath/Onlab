
public class PDOEngine extends Engine {
	Serialization pdoser = new Serialization ();
	int a = 0;
	
	public PDOEngine (){
			
	}
	
	public void newMethod (String[] feladat){
		
	}
	//ment�s met�dus
	public void saveMethod(){
	pdoser.saveMethod();	
		
	}
	//bet�lt�s met�dus
	public void loadMethod(){
	pdoser.loadMethod();	
	}
	
}
