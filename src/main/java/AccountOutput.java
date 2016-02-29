public class AccountOutput {

	private String account;
	private int num_of_types;

	
	 public AccountOutput(final String account, final int account_num) {
	        this.account = account;
	        this.num_of_types = account_num;  
	 }
	

	 public String getAccount(){
		 return this.account;
	 }
	 
	 public int getNum_of_types(){
		 return this.num_of_types;
	 }
	    
	
     @Override
     public String toString() {
    	 String finalOutput = "account: " + account + " num_of_types: " + num_of_types;
		 return finalOutput;
     }
	    
}
