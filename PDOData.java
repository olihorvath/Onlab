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
	private int functionnumber; // kiv�lasztott feladat sz�ma
	ArrayList functionsteps;
	private int subfuncnumber = 1;  //hanyadik l�p�sn�l j�runk
	private float thex;
	private float they;
	
	
	
	
	
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
	
	public void setX (float x){
		thex = x;
		//System.out.println (thex);
	}
	
	public float getX (){
		return thex;
	}
	
	public void setY (float y){
		they = y;
		//System.out.println (they);
	}
	
	public float getY (){
		return they;
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
		String [] functions = {
				"1.1 Sz�mold ki az �tlagos keres�si id�t!", 
				"1.2 Sz�mold ki a maxim�lis keres�si id�t!",
				"1.3 Sz�mold ki a(z) "+(int)thex+ ". rekord megtal�l�s�nak hely�t!",  
				"1.4 Sz�mold ki a(z) "+(int)thex+ ". rekord t�rl�s�nek hely�t!", 
				
				"2.1 Sz�mold ki a v�d�rkatal�gus m�ret�t!", 
				"2.2 Belef�r-e az operat�v t�rba a teljes v�d�rkatal�gus?",
				"2.3 Sz�mold ki a rekordok �tlagos el�r�s�nek az idej�t!", 
				"2.4 Sz�mold ki a rekordok maxim�lis el�r�s�nek az idej�t!",
				"2.5 Maximum "+thex+"ms alatt el�rj�k-e b�rmelyik rekordot? ", 
				
				"3.1 Sz�mold ki a teljes strukt�ra elt�rol�s�hoz sz�ks�ges blokkok sz�m�t!",
				"3.2 "+(int)thex+ ". index�llom�ny blokkban van az �ltalunk keresett rekord mutat�ja, mennyi id� alatt �rj�k el ezt a blokkot? ", 
				"3.3 Sz�mold ki hogy mennyi ideig tarthat legfeljebb egy rekord kiolvas�sa!",
				
				"4.1 S�r� indexelt szervez�sre �p�l� egyszintes ritka index seg�ts�g�vel szeretn�nk �llom�nyt t�rolni. Adj �rtelmes als� becsl�st a sz�ks�ges blokkok sz�m�ra.", 
				"4.2 S�r� indexelt szervez�sre �p�l� egyszintes ritka index seg�ts�g�vel szeretn�nk �llom�nyt t�rolni. Adj �rtelmes als� becsl�st a sz�ks�ges t�rter�letre.",
				
				"5.1 Egy "+(int)thex+ " szintes B* f�ban �tlagosan h�ny blokkm�velettel lehet el�rni egy keresett elemet?", 
				"5.2 Egy "+(int)thex+ " szintes B* f�ban legfeljebb "+they+ " ms alatt el tudom �rni b�rmelyik keresett elemet?", 
				"5.3 A fenti param�terekkel szeretn�nk B* szervez�ssel t�rolni az �llom�nyunkat. Add meg a fa blocking factor�t!", 
				"5.4 A fenti param�terekkel szeretn�nk B* szervez�ssel t�rolni az �llom�nyunkat. Add meg a fa szintjeinek sz�m�t!"
			
		};	
		
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
		String[] rettemp = {"Nincs funkci�", "00"};
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
