
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
	//ment�s met�dus
	public void saveMethod(){
	pdoser.saveMethod();	
		
	}
	//bet�lt�s met�dus
	public void loadMethod(){
	pdoser.loadMethod();	
	}
	
}
