import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


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
	pdoser.saveMethod(pdodata);	
		
	}
	//betöltés metódus
	public void loadMethod(){
	pdodata = pdoser.loadMethod();	
	}
	
	public void newFunction () {
		int [] newfunc = pdodata.getJobCommand();
		Random newrandom = new Random();
		String thefunction = "Sajnos nincs feladat";
		int randomfunction = 0;
		if (newfunc[0] == -1 && newfunc[1] == -1 && newfunc[2] == -1 ){
			randomfunction = newrandom.nextInt(18);	
			thefunction = functionEngine(randomfunction);
			
		} else if (newfunc[1] == 0){ 
			if (newfunc[0] == 0){
				
				thefunction = functionEngine(newfunc[2]);
			} else if (newfunc[0] == 1){
				//System.out.println(newfunc[2]+4);
				thefunction = functionEngine(newfunc[2]+4);
			} else if (newfunc[0] == 2){
				
				thefunction = functionEngine(newfunc[2]+9);
			}else if (newfunc[0] == 3){
				
				thefunction = functionEngine(newfunc[2]+12);
			}else if (newfunc[0] == 4){
				
				thefunction = functionEngine(newfunc[2]+14);
			}
			
			
		} else if (newfunc[1] == 1){ // ha feladaton belül kell random keresni
			if (newfunc[0] == 0){
				randomfunction = newrandom.nextInt(4);
				thefunction = functionEngine(randomfunction);
			} else if (newfunc[0] == 1){
				randomfunction = newrandom.nextInt(5)+4;
				thefunction = functionEngine(randomfunction);
			} else if (newfunc[0] == 2){
				randomfunction = newrandom.nextInt(3)+9;
				thefunction = functionEngine(randomfunction);
			}else if (newfunc[0] == 3){
				randomfunction = newrandom.nextInt(2)+12;
				thefunction = functionEngine(randomfunction);
			}else if (newfunc[0] == 4){
				randomfunction = newrandom.nextInt(4)+14;
				thefunction = functionEngine(randomfunction);
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
            case 2:  funcdetails = pdologic.heapxSearchTimeFunction();
                     break;
            case 3:  funcdetails = pdologic.heapxDeleteTimeFunction();
                     break;
            case 4:  funcdetails = pdologic.hashBucketCatalogSizeFunction();
                     break;
            case 5:  funcdetails = pdologic.hashBucketCatalogSizeSmallerThenOperativMemoryFunction();
                     break;
            case 6:  funcdetails = pdologic.hashRecordAverageAccesTimeFunction();
                     break;
            case 7:  funcdetails = pdologic.hashRecordMaxAccesTimeFunction();
                     break;
            case 8:  funcdetails = pdologic.hashRecordsearchTimesmallerThanXFunction();
                     break;
            case 9:  funcdetails = pdologic.sparseIndexStructureStorageFunction();
                     break;
            case 10: funcdetails = pdologic.sparseIndexOneBlockSearchTimeFunction();
                     break;
            case 11: funcdetails = pdologic.sparseIndexOneRecordReadTimeFunction();
                     break;
            case 12: funcdetails = pdologic.sparseandfrequentIndexBlockNumberFunction();
                     break;
            case 13: funcdetails = pdologic.sparseandfrequentIndexMemorySizeFunction();
            		break;
            case 14: funcdetails = pdologic.bstarAccessTimeFunction();
            		break;
            case 15: funcdetails = pdologic.bstarAccessTimeSmallerThenYFunction();
            		break;
            case 16: funcdetails = pdologic.bstarBlockingFactorFunction();
            		break;
            case 17: funcdetails = pdologic.bstarHeightOfTreeFunction();
            		break;         
                
            default: funcdetails = pdologic.dummyFunction();
            System.out.println (" meghivodok");
                     break;
        }
		
		pdodata.setFunctionSteps(funcdetails);
		//System.out.println (" lépések feltöltve");
		
		
	}
	
	public void nextStep(String results){
		String [] nowfunc = pdodata.getNowFunction();
		String [] nextfunc = pdodata.getNextFunction();
		check (results, nowfunc[1]);
		
		if (nextfunc[0].equals("end") && nextfunc[1].equals("end")) {
			pdogui.fullSolutionAddRow(nowfunc[0], nowfunc[1]);
			pdogui.fullSolutionnext("Vége");
			return;
		}
		
		pdogui.fullSolutionAddRow(nowfunc[0], nowfunc[1]);
		pdogui.fullSolutionnext(nextfunc[0]);
		
	}
	
	
	public String functionEngine (int ind){
		String ret = null;
		Random xrandom = new Random();
		float xx;
		switch (ind){
		
		case 2:
			 pdodata.setX((float) xrandom.nextInt((int)pdodata.getRecordNumber()));
			break;
		
		case 3:  
			pdodata.setX((float) xrandom.nextInt((int)pdodata.getRecordNumber()));
			 break;
		
		case 8:
			pdodata.setX((float) xrandom.nextInt(200));
			 break;
		
		case 10:
			pdodata.setX((float) xrandom.nextInt(1000));
			 break;
		
		case 14:  
			pdodata.setX((float) xrandom.nextInt(1000));
			 break;
		
		case 15: 
			pdodata.setX((float) xrandom.nextInt(1000));
			pdodata.setY((float) xrandom.nextInt(1000));
			
			//System.out.println (pdodata.getX());
			 break;
			 
		 default:
			
             break;
		
		}
		
	//	try {
		//	Thread.sleep(100);
	//	} catch (InterruptedException e) {
			// TODO Auto-generated catch block
	//		e.printStackTrace();
	//	}
		 ret = pdodata.getFunction(ind);
		return ret;
	}
	
	public void check (String a, String b){
		
		JFrame frame = new JFrame();
		if (a.equalsIgnoreCase(b))
			JOptionPane.showMessageDialog(frame,"Helyes a megoldás.");
		else 
			JOptionPane.showMessageDialog(frame,"Helytelen a megoldás.");
		
	}
}
