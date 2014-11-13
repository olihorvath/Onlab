import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;



public class PDOLogic extends Logic {
	PDOData pdodata;
	PDOLogic (PDOData data){
		pdodata = data;
		
		
	}

	public ArrayList dummyFunction(){
		ArrayList temp = new ArrayList ();
		temp.add("probalogic1");
		temp.add("111");
		temp.add("probalogic2");
		temp.add("112");
		temp.add("probalogic3");
		temp.add("113");
		temp.add("probalogic4");
		temp.add("114");
		
		return temp;
	}
	
	
	
	public ArrayList heapAverageSearcTimeFunction(){
		
		ArrayList temp = new ArrayList ();
		temp.add("Add meg a Blocking Factort!");
		
		int blockingfactor = blockingFactor();
		temp.add(Integer.toString(blockingfactor));
		
		temp.add("Számold ki a blokkok számát!");
		int blocknumber = blockNumber (blockingfactor);
		temp.add(Integer.toString(blocknumber));
		
		temp.add("Számold ki az átlagos megtalálási idõt!");
		float searchtime = ((blocknumber+1)/2) * pdodata.getBlockOperationTime();
		temp.add(Float.toString(searchtime));

		return temp;
	}
	public ArrayList heapMaxSearcTimeFunction(){
		
		ArrayList temp = new ArrayList ();
		temp.add("Add meg a Blocking Factort!");
		
		int blockingfactor = blockingFactor();
		temp.add(Integer.toString(blockingfactor));
		
		temp.add("Számold ki a blokkok számát!");
		int blocknumber = blockNumber (blockingfactor);
		temp.add(Integer.toString(blocknumber));
		
		temp.add("Számold ki a maximális megtalálási idõt!");
		float searchtime = blocknumber * pdodata.getBlockOperationTime();
		temp.add(Float.toString(searchtime));

		return temp;
	}
	
public ArrayList heapxSearchTimeFunction(){
		
		ArrayList temp = new ArrayList ();
		temp.add("Add meg a Blocking Factort!");
		
		int blockingfactor = blockingFactor();
		temp.add(Integer.toString(blockingfactor));
		
		temp.add("Add meg azt a blokkot, amiben a fenti rekord található!");
		float blocknumber_f = pdodata.getX()/blockingfactor;
		int blocknumber = (int) blocknumber_f;
		if (blocknumber < blocknumber_f) blocknumber ++;
		temp.add(Integer.toString(blocknumber));
		
		temp.add("Számold ki a blokk megtalálási idejét!");
		float searchtime = blocknumber * pdodata.getBlockOperationTime();
		temp.add(Float.toString(searchtime));

		return temp;
	}
	

public ArrayList heapxDeleteTimeFunction(){
	
	ArrayList temp = new ArrayList ();
	temp.add("Add meg a Blocking Factort!");
	
	int blockingfactor = blockingFactor();
	temp.add(Integer.toString(blockingfactor));
	
	temp.add("Add meg azt a blokkot, amiben a fenti rekord található!");
	float blocknumber_f = pdodata.getX()/blockingfactor;
	int blocknumber = (int) blocknumber_f;
	if (blocknumber < blocknumber_f) blocknumber ++;
	temp.add(Integer.toString(blocknumber));
	
	temp.add("Számold ki a blokk megtalálási idejét!");
	float searchtime = blocknumber * pdodata.getBlockOperationTime();
	temp.add(Float.toString(searchtime));
	
	temp.add("Add hozzá a törlés idejét!");
	float deletetime =searchtime  + pdodata.getBlockOperationTime();
	temp.add(Float.toString(deletetime));
	

	return temp;
}
public ArrayList hashBucketCatalogSizeFunction(){
		
		ArrayList temp = new ArrayList ();
		temp.add("Add meg a Blocking Factort!");
		
		int blockingfactor = blockingFactor();
		temp.add(Integer.toString(blockingfactor));
		
		temp.add("Add meg az egy vödörbe betehetõ rekordok számát!");
		int recordinbucket = recordNumberInBucket(blockingfactor);
		temp.add(Integer.toString(recordinbucket));
		
		temp.add("Számold ki a vödrök számát!");
		int bucketnumber = bucketNumber (recordinbucket);
		temp.add(Integer.toString(bucketnumber));
		
		temp.add("Számold ki a vödörkatalógus méretét!");
		float bucketcatalogsize = bucketnumber * (pdodata.getPointerSize() / 8.0f);
		temp.add(Float.toString(bucketcatalogsize));

		return temp;
	}


public ArrayList hashBucketCatalogSizeSmallerThenOperativMemoryFunction(){
	
	ArrayList temp = new ArrayList ();
	temp.add("Add meg a Blocking Factort!");
	
	int blockingfactor = blockingFactor();
	temp.add(Integer.toString(blockingfactor));
	
	temp.add("Add meg az egy vödörbe betehetõ rekordok számát!");
	int recordinbucket = recordNumberInBucket(blockingfactor);
	temp.add(Integer.toString(recordinbucket));
	
	temp.add("Számold ki a vödrök számát!");
	int bucketnumber = bucketNumber (recordinbucket);
	temp.add(Integer.toString(bucketnumber));
	
	temp.add("Számold ki a vödörkatalógus méretét!");
	float bucketcatalogsize = bucketnumber * (pdodata.getPointerSize() /8.0f);
	temp.add(Float.toString(bucketcatalogsize));
	
	temp.add("Kisebb mint a vödörkatalógus mérete?");
	if (bucketcatalogsize < pdodata.getFreeMemory()){
		temp.add("igen");
	} else temp.add("nem");

	return temp;
}


public ArrayList hashRecordAverageAccesTimeFunction(){
	
	ArrayList temp = new ArrayList ();
	temp.add("Számold ki, hogy maximum hány blokk fér el egy vödörben!");
	int bucketcap = (int) (pdodata.getBucketSize() / pdodata.getBlockSize());
	
	temp.add(Integer.toString(bucketcap));
	temp.add("Számold ki egy rekord átlagos elérési idejét!");
	float averageaccestime = (1+bucketcap) / 2* pdodata.getBlockOperationTime();

	temp.add(Float.toString(averageaccestime));

	return temp;
}

public ArrayList hashRecordMaxAccesTimeFunction(){
	
	ArrayList temp = new ArrayList ();
	temp.add("Számold ki, hogy maximum hány blokk fér el egy vödörben!");
	int bucketcap = (int) (pdodata.getBucketSize() / pdodata.getBlockSize());
	
	temp.add(Integer.toString(bucketcap));
	temp.add("Számold ki egy rekord maximális elérési idejét!");
	float averageaccestime = (bucketcap) * pdodata.getBlockOperationTime();

	temp.add(Float.toString(averageaccestime));

	return temp;
}

public ArrayList hashRecordsearchTimesmallerThanXFunction(){
	
	ArrayList temp = new ArrayList ();
	temp.add("Számold ki, hogy maximum hány blokk fér el egy vödörben!");
	int bucketcap = (int) (pdodata.getBucketSize() / pdodata.getBlockSize());
	
	temp.add(Integer.toString(bucketcap));
	temp.add("Számold ki egy rekord maximális elérési idejét!");
	float averageaccestime = (bucketcap) * pdodata.getBlockOperationTime();

	temp.add(Float.toString(averageaccestime));
	
	temp.add("Ez kevesebb idõ, mint a fent megadott?");
	String yesorno = "nem";
	if (averageaccestime <= pdodata.getX()) yesorno = "igen";
	
	temp.add(yesorno);
	
	

	return temp;
}
	
public ArrayList sparseIndexStructureStorageFunction(){
	
	ArrayList temp = new ArrayList ();
	
	temp.add("Add meg a Blocking Factort!");
	
	int blockingfactor = blockingFactor();
	temp.add(Integer.toString(blockingfactor));
	
	temp.add("Számold ki a blokkok számát!");
	int blocknumber = blockNumber (blockingfactor);
	temp.add(Integer.toString(blocknumber));
	
	
	temp.add("Számold ki az indexállomány blocking factorát!");
	int indexblockingfactory = (int)   (pdodata.getBucketSize() / pdodata.getKeySize() + pdodata.getPointerSize()) ;
			
	temp.add(Integer.toString(indexblockingfactory));
	
	temp.add("Számold ki az indexállomány blokkjainak számát!");
	int indexblocks =  (int) (blocknumber / indexblockingfactory);
	temp.add(Integer.toString(indexblocks));

	temp.add("Számold ki a teljes struktúra méretét!");	
	
	float totalblocksize = (blocknumber + indexblocks) * pdodata.getBlockSize();
	temp.add(Float.toString(totalblocksize));

	return temp;
}

public ArrayList sparseIndexOneBlockSearchTimeFunction(){
	
	ArrayList temp = new ArrayList ();
	temp.add("Számold ki az összesen beolvasott blokkok számát!");
	int blocknumber = (int) (pdodata.getX() + 1);
	temp.add(Integer.toString(blocknumber));
	temp.add("Számold ki az elérési idõt!");
	float accesstime = blocknumber * pdodata.getBlockOperationTime();

	temp.add(Float.toString(accesstime));

	return temp;
}

public ArrayList sparseIndexOneRecordReadTimeFunction(){
	
	ArrayList temp = new ArrayList ();
	
	temp.add("Add meg a tárolt adatok Blocking Factort!");
	
	int blockingfactor = blockingFactor();
	temp.add(Integer.toString(blockingfactor));
	
	temp.add("Számold ki a blokkok számát!");
	int blocknumber = blockNumber (blockingfactor);
	temp.add(Integer.toString(blocknumber));
	
	
	temp.add("Számold ki az indexállomány blocking factorát!");
	int indexblockingfactory = (int)   (pdodata.getBucketSize() / pdodata.getKeySize() + pdodata.getPointerSize()) ;
			
	temp.add(Integer.toString(indexblockingfactory));
	
	temp.add("Számold ki az indexállomány blokkjainak számát!");
	float indexblocks_f = (blocknumber / indexblockingfactory);
	int indexblocks = (int) indexblocks_f;
	if (indexblocks < indexblocks_f) indexblocks++;	
	temp.add(Integer.toString(indexblocks));
	
	temp.add("Számold az összesen beolvasott blokkok számát!");
	int totalblocknumber = indexblocks+1;
	temp.add(Integer.toString(totalblocknumber));
	temp.add("Számold a rekord elérési idejét!");
	float readtime = totalblocknumber * pdodata.getBlockOperationTime();
	temp.add(Float.toString(readtime));

	return temp;
}

public ArrayList sparseandfrequentIndexBlockNumberFunction(){
	
	ArrayList temp = new ArrayList ();
	
	temp.add("Add meg a tárolt adatok Blocking Factort!");
	
	int blockingfactor = blockingFactor();
	temp.add(Integer.toString(blockingfactor));
	
	temp.add("Számold ki a blokkok számát!");
	int blocknumber = blockNumber (blockingfactor);
	temp.add(Integer.toString(blocknumber));
	
	
	temp.add("Számold ki az indexállomány blocking factorát!");
	int indexblockingfactory = (int)   (pdodata.getBucketSize() / pdodata.getKeySize() + pdodata.getPointerSize()) ;	
	temp.add(Integer.toString(indexblockingfactory));
	
	temp.add("Számold ki a sûrû indexállomány blokkjainak számát!");
	float frequentindexblocks_f =  (int) (blocknumber / indexblockingfactory);
	int frequentindexblocks = (int) frequentindexblocks_f;
	if (frequentindexblocks < frequentindexblocks_f) frequentindexblocks++;	
	temp.add(Integer.toString(frequentindexblocks));
	
	temp.add("Számold ki a ritka indexekhez blokkjainak számát!");
	float sparseindexblocks_f = (frequentindexblocks / indexblockingfactory);
	int sparseindexblocks = (int) sparseindexblocks_f;
	if (sparseindexblocks < sparseindexblocks_f) sparseindexblocks++;
	temp.add(Integer.toString(sparseindexblocks));
	
	
	temp.add("Számold az összesen használt blokkok számát!");
	int totalblocknumber = blocknumber + frequentindexblocks + sparseindexblocks;
	temp.add(Integer.toString(totalblocknumber));
	
	return temp;
}

public ArrayList sparseandfrequentIndexMemorySizeFunction(){
	
	ArrayList temp = new ArrayList ();
	
	temp.add("Add meg a tárolt adatok Blocking Factort!");
	
	int blockingfactor = blockingFactor();
	temp.add(Integer.toString(blockingfactor));
	
	temp.add("Számold ki a blokkok számát!");
	int blocknumber = blockNumber (blockingfactor);
	temp.add(Integer.toString(blocknumber));
	
	
	temp.add("Számold ki az indexállomány blocking factorát!");
	int indexblockingfactory = (int)   (pdodata.getBucketSize() / pdodata.getKeySize() + pdodata.getPointerSize()) ;	
	temp.add(Integer.toString(indexblockingfactory));
	
	temp.add("Számold ki a sûrû indexállomány blokkjainak számát!");
	float frequentindexblocks_f =  (int) (blocknumber / indexblockingfactory);
	int frequentindexblocks = (int) frequentindexblocks_f;
	if (frequentindexblocks < frequentindexblocks_f) frequentindexblocks++;	
	temp.add(Integer.toString(frequentindexblocks));
	
	temp.add("Számold ki a ritka indexekhez blokkjainak számát!");
	float sparseindexblocks_f = (frequentindexblocks / indexblockingfactory);
	int sparseindexblocks = (int) sparseindexblocks_f;
	if (sparseindexblocks < sparseindexblocks_f) sparseindexblocks++;
	temp.add(Integer.toString(sparseindexblocks));
	
	temp.add("Számold az összesen használt blokkok számát!");
	int totalblocknumber = blocknumber + frequentindexblocks + sparseindexblocks;
	temp.add(Integer.toString(totalblocknumber));
	
	temp.add("Számold a struktúra tárolásához szükséges tárterületet!");
	float totalblocksize = totalblocknumber * pdodata.getBlockOperationTime();
	temp.add(Float.toString(totalblocksize));
	
	return temp;
}


public ArrayList bstarAccessTimeFunction (){
	
	ArrayList temp = new ArrayList ();
	
temp.add("Add meg, hogy egy blokk eléréséhez átlagosan hány blokkmûvelet szükséges!");
	
	int xx =(int) pdodata.getX() +1;
	temp.add(Integer.toString(xx));
	
	return temp;
}

public ArrayList bstarAccessTimeSmallerThenYFunction (){
	
	ArrayList temp = new ArrayList ();
	
temp.add("Add meg, hogy egy blokk eléréséhez átlagosan hány blokkmûvelet szükséges!");
	
	int xx =(int) pdodata.getX() +1;
	temp.add(Integer.toString(xx));
	
	temp.add("Számold ki az elérési idõt!");
	float accesstime = xx*pdodata.getBlockOperationTime();
	temp.add(Float.toString(accesstime));
	
	temp.add("Ez kisebb mint a fent megadott érték?");
	if (accesstime < pdodata.getY()){
		temp.add("igen");
	} else temp.add("nem");

	return temp;
}


public ArrayList bstarBlockingFactorFunction (){
	
	ArrayList temp = new ArrayList ();
	
temp.add("Add meg a tárolt adatok Blocking Factort!");
	
	int blockingfactor = bstarblockingFactor();
	temp.add(Integer.toString(blockingfactor));
	
	return temp;
}

public ArrayList bstarHeightOfTreeFunction (){
	
	ArrayList temp = new ArrayList ();
	
	temp.add("Add meg a tárolt adatok Blocking Factort!");
	int blockingfactor = bstarblockingFactor();
	temp.add(Integer.toString(blockingfactor));
	
	temp.add("Add meg a fa szintjeinek a számát!");
	double br = pdodata.getBlockSize();
	double fi = blockingfactor;
	
	double ht_d = Math.log(br) / Math.log(fi);
	int ht = (int) ht_d;
	if (ht < ht_d) ht++;
	temp.add(Integer.toString(ht));
	
	
	return temp;
}


	
	
	int blockingFactor (){
		int bfactor = 0;
		float blocksize = pdodata.getBlockSize();
		float recordsize = pdodata.getRecordSize();
		float factor = blocksize/recordsize;
		bfactor = (int) factor;
		
		return  bfactor;
	}
	
	int bstarblockingFactor (){
		int bfactor = 0;
		float key = pdodata.getKeySize();
		float blocksize = pdodata.getBlockSize();
		float pointer = pdodata.getPointerSize();
		float factor = (blocksize+key)/(key+pointer);
		bfactor = (int) factor;
		
		return  bfactor;
	}
	
	
	int blockNumber (int blockingfactor){
		int bnumber;
		float num = pdodata.getRecordNumber() / blockingfactor;
		bnumber = (int) num;
		if (bnumber < num) bnumber ++; // ha le kellett vágni a num-ból, akkor +1 a felsõegészrész miatt
		return bnumber;
	}
	
	int recordNumberInBucket (int bfactor){
		int bucketinrecord = 0;
		float binr = pdodata.getBucketSize() / pdodata.getBlockSize();
		int ibinr = (int) binr;
		bucketinrecord= ibinr * bfactor;
		
		return bucketinrecord;
	}
	
	int bucketNumber(int recordnumberinbucket){
		int bucketnumber = 0;
		float bnum = pdodata.getRecordNumber() / recordnumberinbucket;
		bucketnumber = (int) bnum;
		if (bucketnumber < bnum) bucketnumber ++;
		return bucketnumber;
	}
	
	
	
}
