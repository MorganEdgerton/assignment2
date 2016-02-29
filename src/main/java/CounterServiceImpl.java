import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class CounterServiceImpl implements CounterService {

	private static String socialMediaDataLink;
	private static String dataJson;
	private static List<AustinEntity> entities;
	//private static OutputEntity output;

	
    public CounterServiceImpl() {
        System.out.println("*** INIT ***");
        //TO PARSE URL DATA
    	socialMediaDataLink = "https://www.cs.utexas.edu/~devdatta/ej42-f7za.json";

    	try{
    		dataJson = readUrl(socialMediaDataLink);
    	} catch (Exception e) {
    		System.out.println("Datalink unavailable");
			e.printStackTrace();
		} 
    	try{
    		entities = parseURLdata();	
    	} catch (Exception e) {
    		System.out.println("Could not parse datalink.");
			e.printStackTrace();
    	}
    	System.out.println("***END INIT ***");
    }
	

	public AccountOutput countAccount(String account) {
	// iterate and count # of entites of 'account' in datalink
	int count = 0;
	String accountTitle = account;
	if(account!=null){
    	Iterator it = entities.iterator();
   	 	while(it.hasNext()) {
   	 		AustinEntity curr = (AustinEntity)it.next();
   	 		if(account.toLowerCase().equals(curr.getAccount().toLowerCase())){
   	 			System.out.println("curr.getAccount(): " + curr.getAccount());
   	 			accountTitle = curr.getAccount(); 
   	 			if(curr.getType() != "no type"){ //*I aint got no...
   	 				count++;
   	 			}
   	 		}
   	 	}
    }
		
	return new AccountOutput(accountTitle, count);
}
    
	public TypeOutput countType(String type){
	// iterate and count # of enties of 'type' in datalink
	System.out.println("in countType");
	int count = 0;
	String typeTitle = type;
	if(type!=null){
    	Iterator it = entities.iterator();
   	 	while(it.hasNext()) {
   	 		AustinEntity curr = (AustinEntity)it.next();
   	 		if(type.toLowerCase().equals(curr.getType().toLowerCase())){
   	 			count++;
   	 			typeTitle = curr.getType();
   	 		}
   	 	}
    }
	
	return new TypeOutput(typeTitle, count);
}    
    
	
	public String readUrl(String urlString) throws Exception {
	    BufferedReader reader = null;
	    try {
	        URL url = new URL(socialMediaDataLink);
	        reader = new BufferedReader(new InputStreamReader(url.openStream()));
	        StringBuffer buffer = new StringBuffer();
	        int read;
	        char[] chars = new char[1024];
	        while ((read = reader.read(chars)) != -1)
	            buffer.append(chars, 0, read); 
	        return buffer.toString();
	    } finally {
	        if (reader != null)
	            reader.close();
	    }
	    
	}
	
	public static List<AustinEntity> parseURLdata(){
		Gson gson = new Gson();
	    final Type AustinEntityListType = new TypeToken<List<AustinEntity>>(){}.getType();
	    final List<AustinEntity> entityListing = gson.fromJson(dataJson, AustinEntityListType);
		return entityListing;
	}
	
}
