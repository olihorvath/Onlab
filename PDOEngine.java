import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class PDOEngine extends Engine {
	Serialization pdoser;
	PDOData pdodata;
	PDOGui pdogui;
	PDOLogic pdologic;
	
	public PDOEngine (PDOGui gui){
		pdodata = new PDOData ();
		pdoser = new Serialization();
		pdologic = new PDOLogic(pdodata);
		pdogui = gui;
	}
	
	public void generateData (int[] feladat){
		pdodata.setJobCommand(feladat);
		
		Random myrandom = new Random();
		float randomfloat =(float) myrandom.nextInt(9000)+1000;
		//System.out.println(randomfloat);
		pdodata.setBlockSize(randomfloat);
		
		int recordnumtemp = myrandom.nextInt(9)+1;
		
		float randomrecordfloat =(float) myrandom.nextInt((int) randomfloat/recordnumtemp - 100)+100;
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
			
		} else if (newfunc[1] == 0){ 
			if (newfunc[0] == 0){
				
				thefunction = pdodata.getFunction(newfunc[2]);
			} else if (newfunc[0] == 1){
				//System.out.println(newfunc[2]+4);
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
		//pdodata.setFunctionNumber(randomfunction);
		//Itt lekérem a lépéseket TODO még át kell tenni
		//getFunction ();
		simpleMode();
	}
	
	public void simpleResultsCheck(String result){
		
	
	}
	
	
	//egyszerû mód
	public void simpleMode (){
		pdogui.simpleSolution ();
	}	
	
	//részletes mód
	public void fullMode (){
		getFunction();
		String [] nowfunc = pdodata.getNowFunction();
		pdogui.fullSolutionInit (nowfunc[0]);
		//fullSolutionAddRow ("alma","béta");
	}
	
	public void getFunction (){
		ArrayList funcdetails;
		System.out.println (pdodata.getFunctionNumber());
        switch (pdodata.getFunctionNumber()) {
        	case 0:  funcdetails = pdologic.heapAverageSearcTimeFunction();
        			 break;
            case 1:  funcdetails = pdologic.heapAverageSearcTimeFunction();
                     break;
            case 2:  funcdetails = pdologic.dummyFunction();
                     break;
            case 3:  funcdetails = pdologic.dummyFunction();
                     break;
            case 4:  funcdetails = pdologic.hashBucketCatalogSizeFunction();
                     break;
            case 5:  funcdetails = pdologic.hashBucketCatalogSizeSmallerThenOperativMemoryFunction();
                     break;
            case 6:  funcdetails = pdologic.hashRecordAverageAccesTimeFunction();
                     break;
            case 7:  funcdetails = pdologic.hashRecordMaxAccesTimeFunction();
                     break;
            case 8:  funcdetails = pdologic.dummyFunction();
                     break;
            case 9:  funcdetails = pdologic.sparseIndexStructureStorageFunction();
                     break;
            case 10: funcdetails = pdologic.dummyFunction();
                     break;
            case 11: funcdetails = pdologic.sparseIndexOneRecordReadTimeFunction();
                     break;
            case 12: funcdetails = pdologic.dummyFunction();
                     break;
            case 13: funcdetails = pdologic.dummyFunction();
            		break;
            case 14: funcdetails = pdologic.dummyFunction();
            		break;
            case 15: funcdetails = pdologic.dummyFunction();
            		break;
            case 16: funcdetails = pdologic.dummyFunction();
            		break;
            case 17: funcdetails = pdologic.dummyFunction();
            		break;         
                
            default: funcdetails = pdologic.dummyFunction();
            System.out.println (" meghivodok");
                     break;
        }
		
		pdodata.setFunctionSteps(funcdetails);
		//System.out.println (" lépések feltöltve");
		
		
	}
	
	public void nextStep(){
		String [] nowfunc = pdodata.getNowFunction();
		String [] nextfunc = pdodata.getNextFunction();
		if (nextfunc[0].equals("end") && nextfunc[1].equals("end")) {
			pdogui.fullSolutionAddRow(nowfunc[0], nowfunc[1]);
			pdogui.fullSolutionnext("Vége");
			return;
		}
		
		pdogui.fullSolutionAddRow(nowfunc[0], nowfunc[1]);
		pdogui.fullSolutionnext(nextfunc[0]);
		
	}
}
