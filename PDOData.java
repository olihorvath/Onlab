
public class PDOData extends Data {

	private String [] jobcommand;
	private String theme;
	private String function;
	private String subtheme;
	//inputok
	private float blocksize;
	private float recordsize;
	private float recordnumber;
	private float keysize;
	private float pointersize;
	private float bucketsize;
	private float blockoperationtime;
	private float freememory;
	
	public PDOData(){}
	
	public void setJobCommand (String [] job){
		jobcommand = job;
		theme = job[0];
		function =job[1];
		subtheme = job[2];
		
	}
	
	public String[] getJobCommand (){
		return jobcommand;
	}
	
	public String getTheme (){
		return theme;
	}
	
	public String getFunction (){
		return function;
	}
	
	public String getSubTheme (){
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
	
	
	
}
