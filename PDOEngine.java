import java.util.Random;


public class PDOEngine extends Engine {
	Serialization pdoser;
	PDOData pdodata;
	PDOGui pdogui;
	
	public PDOEngine (PDOGui gui){
		pdodata = new PDOData ();
		pdoser = new Serialization();
		pdogui = gui;
	}
	
	public void generateData (int[] feladat){
		pdodata.setJobCommand(feladat);
		
		Random myrandom = new Random();
		float randomfloat =(float) myrandom.nextInt(9000)+1000;
		//System.out.println(randomfloat);
		pdodata.setBlockSize(randomfloat);
		
		
		float randomrecordfloat =(float) myrandom.nextInt((int) randomfloat- 100)+100;
		//System.out.println(randomrecordfloat);
		pdodata.setRecordSize(randomrecordfloat);
		
		float randomrecordnumberfloat =(float) myrandom.nextInt(999999)+1;
		//System.out.println(randomrecordnumberfloat);
		pdodata.setRecordNumber(randomrecordnumberfloat);
		
		float randomkeyfloat =(float) myrandom.nextInt(480)+20;
		//System.out.println(randomkeyfloat);
		pdodata.setKeySize(randomkeyfloat);
		
		float randompointerfloat =(float) myrandom.nextInt(1016)+8;
		//System.out.println(randompointerfloat);
		pdodata.setPointerSize(randompointerfloat);
		
		float randombucketfloat =(float) (myrandom.nextInt(50)*randomrecordfloat) + myrandom.nextInt((int)randomrecordfloat);
		//System.out.println(randombucketfloat);
		pdodata.setBucketSize(randombucketfloat);
		
		float randomblockopfloat =(float) myrandom.nextInt(49)+1;
		//System.out.println(randomblockopfloat);
		pdodata.setBlockOperationTime (randomblockopfloat);
		
		float randomfreememoryfloat =(float) myrandom.nextInt((int) randomrecordfloat) + randomrecordfloat;
		//System.out.println(randomfreememoryfloat);
		pdodata.setFreeMemory (randomfreememoryfloat);
		
		pdogui.inputTable(
				pdodata.getBlockSize(), 
				pdodata.getRecordSize(), 
				pdodata.getRecordNumber(),
				pdodata.getKeySize(), 
				pdodata.getPointerSize(), 
				pdodata.getBucketSize(),
				pdodata.getBlockOperationTime(), 
				pdodata.getFreeMemory()
				);
		
	
	}
	
	public void setSimpleMode (){
		pdodata.setSimpleMode();
		
	}	

	public void setFullMode (){
		pdodata.setFullMode();
	
	}

	//mentés metódus
	public void saveMethod(){
	pdoser.saveMethod();	
		
	}
	//betöltés metódus
	public void loadMethod(){
	pdoser.loadMethod();	
	}
	
	public void newFunction () {
		int [] newfunc = pdodata.getJobCommand();
		Random newrandom = new Random();
		String thefunction = "Sajnos nincs feladat";
		int randomfunction = 0;
		if (newfunc[0] == -1 && newfunc[1] == -1 && newfunc[2] == -1 ){
			randomfunction = newrandom.nextInt(18);	
			thefunction = pdodata.getFunction(randomfunction);
			
		} else if (newfunc[1] == 0){ // ha feladaton belül kell random keresni
			if (newfunc[0] == 0){
				
				thefunction = pdodata.getFunction(newfunc[2]);
			} else if (newfunc[0] == 1){
				
				thefunction = pdodata.getFunction(newfunc[2]+4);
			} else if (newfunc[0] == 2){
				
				thefunction = pdodata.getFunction(newfunc[2]+9);
			}else if (newfunc[0] == 3){
				
				thefunction = pdodata.getFunction(newfunc[2]+12);
			}else if (newfunc[0] == 4){
				
				thefunction = pdodata.getFunction(newfunc[2]+14);
			}
			
			
		} else if (newfunc[1] == 1){ // ha feladaton belül kell random keresni
			if (newfunc[0] == 0){
				randomfunction = newrandom.nextInt(4);
				thefunction = pdodata.getFunction(randomfunction);
			} else if (newfunc[0] == 1){
				randomfunction = newrandom.nextInt(5)+4;
				thefunction = pdodata.getFunction(randomfunction);
			} else if (newfunc[0] == 2){
				randomfunction = newrandom.nextInt(3)+9;
				thefunction = pdodata.getFunction(randomfunction);
			}else if (newfunc[0] == 3){
				randomfunction = newrandom.nextInt(2)+12;
				thefunction = pdodata.getFunction(randomfunction);
			}else if (newfunc[0] == 4){
				randomfunction = newrandom.nextInt(4)+14;
				thefunction = pdodata.getFunction(randomfunction);
			}
			
			
		} 
		
		pdogui.onFunction(thefunction);
		pdodata.setFunctionNumber(randomfunction);
	}
	
	public void simpleResultsCheck(String result){
		
	
	}
	
	
	//egyszerû mód
	public void simpleMode (){
		pdogui.simpleSolution ();
	}	
	
	//részletes mód
	public void fullMode (){
		pdogui.fullSolutionInit ("proba");
		//fullSolutionAddRow ("alma","béta");
	}

}
