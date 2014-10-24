
public class PDOData extends Data {

	private String [] jobcommand;
	private String theme;
	private String function;
	private String subtheme;
	
	
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
	
	
}
