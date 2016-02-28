public class TypeOutput {

	private String type;
	private int num_of_accounts;

	
	 public TypeOutput(final String type, final int type_num) {
	        this.type = type;
	        this.num_of_accounts = type_num;  
	 }
	

	 public String getType(){
		 return this.type;
	 }
	 
	 public int getNum_of_accounts(){
		 return this.num_of_accounts;
	 }
	    
	
     @Override
     public String toString() {
    	 String finalOutput = "type: " + type + " num_of_accounts " + num_of_accounts;
		 return finalOutput;
     }
	    
}
