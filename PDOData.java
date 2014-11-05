import java.util.ArrayList;
import java.util.HashMap;


public class PDOData extends Data {

	private int [] jobcommand;
	private int theme;
	private int function;
	private int subtheme;
	//inputok
	private float blocksize;
	private float recordsize;
	private float recordnumber;
	private float keysize;
	private float pointersize;
	private float bucketsize;
	private float blockoperationtime;
	private float freememory;
	private boolean simplemode = true; //eloszor simplemode
	private boolean fullmode = false; 
	private int functionnumber; // kiválasztott feladat száma
	ArrayList functionsteps;
	private int subfuncnumber = 1;  //hanyadik lépésnél járunk
	private String [] functions = {
			"1.1 Számold ki az átlagos keresési idõt!", 
			"1.2 Számold ki a maximális keresési idõt!",
			"1.3 Számold ki az x. rekord megtalálásának helyét!",  // TODO 
			"1.4 Számold ki a x. rekord törlésének helyét!", // TODO
			
			"2.1 Számold ki a vödörkatalógus méretét!", 
			"2.2 Belefér-e az operatív tárba a teljes vödörkatalógus?",
			"2.3 Számold ki a rekordok átlagos elérésének az idejét!", 
			"2.4 Számold ki a rekordok maximális elérésének az idejét!",
			"2.5 Maximum x ms alatt elérjük-e bármelyik rekordot? ", // TODO 
			
			"3.1 Számold ki a teljes struktúra eltárolásához szükséges blokkok számát!",
			"3.2 x. indexállomány blokkban van az általunk keresett rekord mutatója, mennyi idõ alatt érjük el ezt a blokkot? ", // TODO 
			"3.3 Számold ki hogy mennyi ideig tarthat legfeljebb egy rekord kiolvasása!",
			
			"4.1 Sûrû indexelt szervezésre épülõ egyszintes ritka index segítségével szeretnénk állományt tárolni. Adj értelmes alsó becslést a szükséges blokkok számára.", 
			"4.2 Sûrû indexelt szervezésre épülõ egyszintes ritka index segítségével szeretnénk állományt tárolni. Adj értelmes alsó becslést a szükséges tárterületre.",
			
			"5.1 Egy x szintes B* fában átlagosan hány blokkmûvelettel lehet elérni egy keresett elemet?",  //TODO
			"5.2 Egy x szintes B* fában legfeljebb y idõ alatt el tudom érni bármelyik keresett elemet?",  //TODO
			"5.3 A fenti paraméterekkel szeretnénk B* szervezéssel tárolni az állományunkat. Add meg a fa blocking factorát!", 
			"5.4 A fenti paraméterekkel szeretnénk B* szervezéssel tárolni az állományunkat. Add meg a fa szintjeinek számát!"
		
			
			
			
			
	};
	
	
	
	
	public PDOData(){}
	
	public void setJobCommand (int [] job){
		jobcommand = job;
		theme = job[0];
		function =job[1];
		subtheme = job[2];
		//subfuncnumber = 1;
		
	}
	
	public int[] getJobCommand (){
		return jobcommand;
	}
	
	public int getTheme (){
		return theme;
	}
	
	public int getFunction (){
		return function;
	}
	
	public int getSubTheme (){
		return subtheme;
	}
	
	public void setBlockSize (float blo){
		blocksize = blo;
	}
	
	public float getBlockSize (){
		return blocksize;
	}
	
	public void setRecordSize (float rec){
		recordsize = rec ;
	}
	
	public float getRecordSize (){
		return recordsize;
	}
	
	public void setRecordNumber (float rec ){
		recordnumber  = rec;
	}
	
	public float getRecordNumber (){
		return recordnumber;
	}
	
	public void setKeySize (float key){
		 keysize = key ;
	}
	
	public float getKeySize (){
		return keysize;
	}
	
	public void setPointerSize (float poi){
		pointersize = poi;
	}
	
	public float getPointerSize (){
		return pointersize;
	}
	
	public void setBucketSize (float buc){
		bucketsize = buc;
	}
	
	public float getBucketSize (){
		return bucketsize;
	}
	public void setBlockOperationTime (float blo){
		blockoperationtime = blo;
	}
	
	public float getBlockOperationTime (){
		return blockoperationtime;
	}
	
	public void setFreeMemory (float fre){
		freememory = fre;
	}
	
	public float getFreeMemory (){
		return freememory;
	}
	
	public void setSimpleMode (){
		simplemode = true;
		fullmode = false;
	}
	
	public boolean getSimpleMode (){
		if (simplemode == true && fullmode == false) return true;
		else return false;
	}
	
	public void setFullMode (){
		simplemode = true;
		fullmode = false;
	}
	
	public boolean getFullMode (){
		if (simplemode == false && fullmode == true) return true;
		else return false;
	}
	
	String getFunction (int index){	
	setFunctionNumber(index);
	return functions[index];
	}
	
	public void setFunctionNumber (int fre){
		functionnumber = fre;
	}
	
	public int getFunctionNumber (){
		return functionnumber;
	}
	
	public void setFunctionSteps (ArrayList steps){
		functionsteps = steps;
	}
	
	public ArrayList getFunctionSteps (){
		return functionsteps;
	}
	
	public String[] getNowFunction (){
		String[] rettemp = {"Nincs funkció", "00"};
		//if (){
			String comment = (String) functionsteps.get(subfuncnumber-1);
			String funcvalue = (String) functionsteps.get(subfuncnumber);
			rettemp[0] = comment;
			rettemp[1] = funcvalue;
		//}  
		
		return rettemp;
	}
	
	public String[] getNextFunction (){
		String[] rettemp = {"end", "end"};
		
		if (subfuncnumber < functionsteps.size()-2){
		String comment = (String) functionsteps.get(++subfuncnumber);
		String funcvalue = (String) functionsteps.get(++subfuncnumber);
		rettemp[0] = comment;
		rettemp[1] = funcvalue;
		}
		
		return rettemp;
	}
	
}
