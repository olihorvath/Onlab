
public class PDOEngine extends Engine {
	Serialization pdoser = new Serialization ();
	int a = 0;
	PDOData pdodata;
	public PDOEngine (){
		pdodata = new PDOData ();	
	}
	
	public void generateData (String[] feladat){
		pdodata.setJobCommand(feladat);
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
