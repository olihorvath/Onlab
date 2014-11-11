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
		temp.add("Igen.");
	} else temp.add("Nem.");

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

public ArrayList sparseIndexOneRecordReadTimeFunction(){
	
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
	temp.add("Sz�mold az �sszesen beolvasott blokkok sz�m�t!");
	
	int totalblocknumber = indexblocks+1;
	temp.add(Integer.toString(totalblocknumber));
	temp.add("Sz�mold a rekord el�r�si idej�t!");
	float readtime = totalblocknumber * pdodata.getBlockOperationTime();
	temp.add(Float.toString(readtime));

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
