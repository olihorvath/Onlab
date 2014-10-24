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
	
	public void generateData (String[] feladat){
		pdodata.setJobCommand(feladat);
		
		Random myrandom = new Random();
		float randomfloat =(float) myrandom.nextInt(9000)+1000;
		System.out.println(randomfloat);
		pdodata.setBlockSize(randomfloat);
		
		
		float randomrecordfloat =(float) myrandom.nextInt((int) randomfloat- 100)+100;
		System.out.println(randomrecordfloat);
		pdodata.setRecordSize(randomrecordfloat);
		
		float randomrecordnumberfloat =(float) myrandom.nextInt(999999)+1;
		System.out.println(randomrecordnumberfloat);
		pdodata.setRecordNumber(randomrecordnumberfloat);
		
		float randomkeyfloat =(float) myrandom.nextInt(480)+20;
		System.out.println(randomkeyfloat);
		pdodata.setKeySize(randomkeyfloat);
		
		float randompointerfloat =(float) myrandom.nextInt(1016)+8;
		System.out.println(randompointerfloat);
		pdodata.setPointerSize(randompointerfloat);
		
		float randombucketfloat =(float) (myrandom.nextInt(50)*randomrecordfloat) + myrandom.nextInt((int)randomrecordfloat);
		System.out.println(randombucketfloat);
		pdodata.setBucketSize(randombucketfloat);
		
		float randomblockopfloat =(float) myrandom.nextInt(49)+1;
		System.out.println(randomblockopfloat);
		pdodata.setBlockOperationTime (randomblockopfloat);
		
		float randomfreememoryfloat =(float) myrandom.nextInt((int) randomrecordfloat) + randomrecordfloat;
		System.out.println(randomfreememoryfloat);
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
	//mentés metódus
	public void saveMethod(){
	pdoser.saveMethod();	
		
	}
	//betöltés metódus
	public void loadMethod(){
	pdoser.loadMethod();	
	}
	
}
