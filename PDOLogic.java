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
		
		temp.add("Sz�mold ki a blokkok sz�m�t!");
		int blocknumber = blockNumber (blockingfactor);
		temp.add(Integer.toString(blocknumber));
		
		temp.add("Sz�mold ki az �tlagos megtal�l�si id�t!");
		float searchtime = ((blocknumber+1)/2) * pdodata.getBlockOperationTime();
		temp.add(Float.toString(searchtime));

		return temp;
	}
	public ArrayList heapMaxSearcTimeFunction(){
		
		ArrayList temp = new ArrayList ();
		temp.add("Add meg a Blocking Factort!");
		
		int blockingfactor = blockingFactor();
		temp.add(Integer.toString(blockingfactor));
		
		temp.add("Sz�mold ki a blokkok sz�m�t!");
		int blocknumber = blockNumber (blockingfactor);
		temp.add(Integer.toString(blocknumber));
		
		temp.add("Sz�mold ki a maxim�lis megtal�l�si id�t!");
		float searchtime = blocknumber * pdodata.getBlockOperationTime();
		temp.add(Float.toString(searchtime));

		return temp;
	}
	
public ArrayList heapxSearchTimeFunction(){
		
		ArrayList temp = new ArrayList ();
		temp.add("Add meg a Blocking Factort!");
		
		int blockingfactor = blockingFactor();
		temp.add(Integer.toString(blockingfactor));
		
		temp.add("Add meg azt a blokkot, amiben a fenti rekord tal�lhat�!");
		float blocknumber_f = pdodata.getX()/blockingfactor;
		int blocknumber = (int) blocknumber_f;
		if (blocknumber < blocknumber_f) blocknumber ++;
		temp.add(Integer.toString(blocknumber));
		
		temp.add("Sz�mold ki a blokk megtal�l�si idej�t!");
		float searchtime = blocknumber * pdodata.getBlockOperationTime();
		temp.add(Float.toString(searchtime));

		return temp;
	}
	

public ArrayList heapxDeleteTimeFunction(){
	
	ArrayList temp = new ArrayList ();
	temp.add("Add meg a Blocking Factort!");
	
	int blockingfactor = blockingFactor();
	temp.add(Integer.toString(blockingfactor));
	
	temp.add("Add meg azt a blokkot, amiben a fenti rekord tal�lhat�!");
	float blocknumber_f = pdodata.getX()/blockingfactor;
	int blocknumber = (int) blocknumber_f;
	if (blocknumber < blocknumber_f) blocknumber ++;
	temp.add(Integer.toString(blocknumber));
	
	temp.add("Sz�mold ki a blokk megtal�l�si idej�t!");
	float searchtime = blocknumber * pdodata.getBlockOperationTime();
	temp.add(Float.toString(searchtime));
	
	temp.add("Add hozz� a t�rl�s idej�t!");
	float deletetime =searchtime  + pdodata.getBlockOperationTime();
	temp.add(Float.toString(deletetime));
	

	return temp;
}
public ArrayList hashBucketCatalogSizeFunction(){
		
		ArrayList temp = new ArrayList ();
		temp.add("Add meg a Blocking Factort!");
		
		int blockingfactor = blockingFactor();
		temp.add(Integer.toString(blockingfactor));
		
		temp.add("Add meg az egy v�d�rbe betehet� rekordok sz�m�t!");
		int recordinbucket = recordNumberInBucket(blockingfactor);
		temp.add(Integer.toString(recordinbucket));
		
		temp.add("Sz�mold ki a v�dr�k sz�m�t!");
		int bucketnumber = bucketNumber (recordinbucket);
		temp.add(Integer.toString(bucketnumber));
		
		temp.add("Sz�mold ki a v�d�rkatal�gus m�ret�t!");
		float bucketcatalogsize = bucketnumber * (pdodata.getPointerSize() / 8.0f);
		temp.add(Float.toString(bucketcatalogsize));

		return temp;
	}


public ArrayList hashBucketCatalogSizeSmallerThenOperativMemoryFunction(){
	
	ArrayList temp = new ArrayList ();
	temp.add("Add meg a Blocking Factort!");
	
	int blockingfactor = blockingFactor();
	temp.add(Integer.toString(blockingfactor));
	
	temp.add("Add meg az egy v�d�rbe betehet� rekordok sz�m�t!");
	int recordinbucket = recordNumberInBucket(blockingfactor);
	temp.add(Integer.toString(recordinbucket));
	
	temp.add("Sz�mold ki a v�dr�k sz�m�t!");
	int bucketnumber = bucketNumber (recordinbucket);
	temp.add(Integer.toString(bucketnumber));
	
	temp.add("Sz�mold ki a v�d�rkatal�gus m�ret�t!");
	float bucketcatalogsize = bucketnumber * (pdodata.getPointerSize() /8.0f);
	temp.add(Float.toString(bucketcatalogsize));
	
	temp.add("Kisebb mint a v�d�rkatal�gus m�rete?");
	if (bucketcatalogsize < pdodata.getFreeMemory()){
		temp.add("igen");
	} else temp.add("nem");

	return temp;
}


public ArrayList hashRecordAverageAccesTimeFunction(){
	
	ArrayList temp = new ArrayList ();
	temp.add("Sz�mold ki, hogy maximum h�ny blokk f�r el egy v�d�rben!");
	int bucketcap = (int) (pdodata.getBucketSize() / pdodata.getBlockSize());
	
	temp.add(Integer.toString(bucketcap));
	temp.add("Sz�mold ki egy rekord �tlagos el�r�si idej�t!");
	float averageaccestime = (1+bucketcap) / 2* pdodata.getBlockOperationTime();

	temp.add(Float.toString(averageaccestime));

	return temp;
}

public ArrayList hashRecordMaxAccesTimeFunction(){
	
	ArrayList temp = new ArrayList ();
	temp.add("Sz�mold ki, hogy maximum h�ny blokk f�r el egy v�d�rben!");
	int bucketcap = (int) (pdodata.getBucketSize() / pdodata.getBlockSize());
	
	temp.add(Integer.toString(bucketcap));
	temp.add("Sz�mold ki egy rekord maxim�lis el�r�si idej�t!");
	float averageaccestime = (bucketcap) * pdodata.getBlockOperationTime();

	temp.add(Float.toString(averageaccestime));

	return temp;
}

public ArrayList hashRecordsearchTimesmallerThanXFunction(){
	
	ArrayList temp = new ArrayList ();
	temp.add("Sz�mold ki, hogy maximum h�ny blokk f�r el egy v�d�rben!");
	int bucketcap = (int) (pdodata.getBucketSize() / pdodata.getBlockSize());
	
	temp.add(Integer.toString(bucketcap));
	temp.add("Sz�mold ki egy rekord maxim�lis el�r�si idej�t!");
	float averageaccestime = (bucketcap) * pdodata.getBlockOperationTime();

	temp.add(Float.toString(averageaccestime));
	
	temp.add("Ez kevesebb id�, mint a fent megadott?");
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
	
	temp.add("Sz�mold ki a blokkok sz�m�t!");
	int blocknumber = blockNumber (blockingfactor);
	temp.add(Integer.toString(blocknumber));
	
	
	temp.add("Sz�mold ki az index�llom�ny blocking factor�t!");
	int indexblockingfactory = (int)   (pdodata.getBucketSize() / pdodata.getKeySize() + pdodata.getPointerSize()) ;
			
	temp.add(Integer.toString(indexblockingfactory));
	
	temp.add("Sz�mold ki az index�llom�ny blokkjainak sz�m�t!");
	int indexblocks =  (int) (blocknumber / indexblockingfactory);
	temp.add(Integer.toString(indexblocks));

	temp.add("Sz�mold ki a teljes strukt�ra m�ret�t!");	
	
	float totalblocksize = (blocknumber + indexblocks) * pdodata.getBlockSize();
	temp.add(Float.toString(totalblocksize));

	return temp;
}

public ArrayList sparseIndexOneBlockSearchTimeFunction(){
	
	ArrayList temp = new ArrayList ();
	temp.add("Sz�mold ki az �sszesen beolvasott blokkok sz�m�t!");
	int blocknumber = (int) (pdodata.getX() + 1);
	temp.add(Integer.toString(blocknumber));
	temp.add("Sz�mold ki az el�r�si id�t!");
	float accesstime = blocknumber * pdodata.getBlockOperationTime();

	temp.add(Float.toString(accesstime));

	return temp;
}

public ArrayList sparseIndexOneRecordReadTimeFunction(){
	
	ArrayList temp = new ArrayList ();
	
	temp.add("Add meg a t�rolt adatok Blocking Factort!");
	
	int blockingfactor = blockingFactor();
	temp.add(Integer.toString(blockingfactor));
	
	temp.add("Sz�mold ki a blokkok sz�m�t!");
	int blocknumber = blockNumber (blockingfactor);
	temp.add(Integer.toString(blocknumber));
	
	
	temp.add("Sz�mold ki az index�llom�ny blocking factor�t!");
	int indexblockingfactory = (int)   (pdodata.getBucketSize() / pdodata.getKeySize() + pdodata.getPointerSize()) ;
			
	temp.add(Integer.toString(indexblockingfactory));
	
	temp.add("Sz�mold ki az index�llom�ny blokkjainak sz�m�t!");
	float indexblocks_f = (blocknumber / indexblockingfactory);
	int indexblocks = (int) indexblocks_f;
	if (indexblocks < indexblocks_f) indexblocks++;	
	temp.add(Integer.toString(indexblocks));
	
	temp.add("Sz�mold az �sszesen beolvasott blokkok sz�m�t!");
	int totalblocknumber = indexblocks+1;
	temp.add(Integer.toString(totalblocknumber));
	temp.add("Sz�mold a rekord el�r�si idej�t!");
	float readtime = totalblocknumber * pdodata.getBlockOperationTime();
	temp.add(Float.toString(readtime));

	return temp;
}

public ArrayList sparseandfrequentIndexBlockNumberFunction(){
	
	ArrayList temp = new ArrayList ();
	
	temp.add("Add meg a t�rolt adatok Blocking Factort!");
	
	int blockingfactor = blockingFactor();
	temp.add(Integer.toString(blockingfactor));
	
	temp.add("Sz�mold ki a blokkok sz�m�t!");
	int blocknumber = blockNumber (blockingfactor);
	temp.add(Integer.toString(blocknumber));
	
	
	temp.add("Sz�mold ki az index�llom�ny blocking factor�t!");
	int indexblockingfactory = (int)   (pdodata.getBucketSize() / pdodata.getKeySize() + pdodata.getPointerSize()) ;	
	temp.add(Integer.toString(indexblockingfactory));
	
	temp.add("Sz�mold ki a s�r� index�llom�ny blokkjainak sz�m�t!");
	float frequentindexblocks_f =  (int) (blocknumber / indexblockingfactory);
	int frequentindexblocks = (int) frequentindexblocks_f;
	if (frequentindexblocks < frequentindexblocks_f) frequentindexblocks++;	
	temp.add(Integer.toString(frequentindexblocks));
	
	temp.add("Sz�mold ki a ritka indexekhez blokkjainak sz�m�t!");
	float sparseindexblocks_f = (frequentindexblocks / indexblockingfactory);
	int sparseindexblocks = (int) sparseindexblocks_f;
	if (sparseindexblocks < sparseindexblocks_f) sparseindexblocks++;
	temp.add(Integer.toString(sparseindexblocks));
	
	
	temp.add("Sz�mold az �sszesen haszn�lt blokkok sz�m�t!");
	int totalblocknumber = blocknumber + frequentindexblocks + sparseindexblocks;
	temp.add(Integer.toString(totalblocknumber));
	
	return temp;
}

public ArrayList sparseandfrequentIndexMemorySizeFunction(){
	
	ArrayList temp = new ArrayList ();
	
	temp.add("Add meg a t�rolt adatok Blocking Factort!");
	
	int blockingfactor = blockingFactor();
	temp.add(Integer.toString(blockingfactor));
	
	temp.add("Sz�mold ki a blokkok sz�m�t!");
	int blocknumber = blockNumber (blockingfactor);
	temp.add(Integer.toString(blocknumber));
	
	
	temp.add("Sz�mold ki az index�llom�ny blocking factor�t!");
	int indexblockingfactory = (int)   (pdodata.getBucketSize() / pdodata.getKeySize() + pdodata.getPointerSize()) ;	
	temp.add(Integer.toString(indexblockingfactory));
	
	temp.add("Sz�mold ki a s�r� index�llom�ny blokkjainak sz�m�t!");
	float frequentindexblocks_f =  (int) (blocknumber / indexblockingfactory);
	int frequentindexblocks = (int) frequentindexblocks_f;
	if (frequentindexblocks < frequentindexblocks_f) frequentindexblocks++;	
	temp.add(Integer.toString(frequentindexblocks));
	
	temp.add("Sz�mold ki a ritka indexekhez blokkjainak sz�m�t!");
	float sparseindexblocks_f = (frequentindexblocks / indexblockingfactory);
	int sparseindexblocks = (int) sparseindexblocks_f;
	if (sparseindexblocks < sparseindexblocks_f) sparseindexblocks++;
	temp.add(Integer.toString(sparseindexblocks));
	
	temp.add("Sz�mold az �sszesen haszn�lt blokkok sz�m�t!");
	int totalblocknumber = blocknumber + frequentindexblocks + sparseindexblocks;
	temp.add(Integer.toString(totalblocknumber));
	
	temp.add("Sz�mold a strukt�ra t�rol�s�hoz sz�ks�ges t�rter�letet!");
	float totalblocksize = totalblocknumber * pdodata.getBlockOperationTime();
	temp.add(Float.toString(totalblocksize));
	
	return temp;
}


public ArrayList bstarAccessTimeFunction (){
	
	ArrayList temp = new ArrayList ();
	
temp.add("Add meg, hogy egy blokk el�r�s�hez �tlagosan h�ny blokkm�velet sz�ks�ges!");
	
	int xx =(int) pdodata.getX() +1;
	temp.add(Integer.toString(xx));
	
	return temp;
}

public ArrayList bstarAccessTimeSmallerThenYFunction (){
	
	ArrayList temp = new ArrayList ();
	
temp.add("Add meg, hogy egy blokk el�r�s�hez �tlagosan h�ny blokkm�velet sz�ks�ges!");
	
	int xx =(int) pdodata.getX() +1;
	temp.add(Integer.toString(xx));
	
	temp.add("Sz�mold ki az el�r�si id�t!");
	float accesstime = xx*pdodata.getBlockOperationTime();
	temp.add(Float.toString(accesstime));
	
	temp.add("Ez kisebb mint a fent megadott �rt�k?");
	if (accesstime < pdodata.getY()){
		temp.add("igen");
	} else temp.add("nem");

	return temp;
}


public ArrayList bstarBlockingFactorFunction (){
	
	ArrayList temp = new ArrayList ();
	
temp.add("Add meg a t�rolt adatok Blocking Factort!");
	
	int blockingfactor = bstarblockingFactor();
	temp.add(Integer.toString(blockingfactor));
	
	return temp;
}

public ArrayList bstarHeightOfTreeFunction (){
	
	ArrayList temp = new ArrayList ();
	
	temp.add("Add meg a t�rolt adatok Blocking Factort!");
	int blockingfactor = bstarblockingFactor();
	temp.add(Integer.toString(blockingfactor));
	
	temp.add("Add meg a fa szintjeinek a sz�m�t!");
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
		if (bnumber < num) bnumber ++; // ha le kellett v�gni a num-b�l, akkor +1 a fels�eg�szr�sz miatt
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
