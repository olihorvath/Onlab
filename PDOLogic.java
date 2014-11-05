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
		float bucketcatalogsize = bucketnumber * pdodata.getPointerSize();
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
	float bucketcatalogsize = bucketnumber * pdodata.getPointerSize();
	temp.add(Float.toString(bucketcatalogsize));
	
	temp.add("Kisebb mint a v�d�rkatal�gus m�rete?");
	if (bucketcatalogsize < pdodata.getFreeMemory()){
		temp.add("Igen.");
	} else temp.add("Nem.");

	return temp;
}


public ArrayList Function(){
	
	ArrayList temp = new ArrayList ();
	temp.add("Add meg a Blocking Factort!");
	
	int blockingfactor = blockingFactor();
	temp.add(Integer.toString(blockingfactor));
	
	temp.add("Add meg az egy v�d�rbe betehet� rekordok sz�m�t!");
	int recordinbucket = recordNumberInBucket(blockingfactor);
	temp.add(Integer.toString(recordinbucket));
	
	
	

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
