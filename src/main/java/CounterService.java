import java.util.List;

import javax.servlet.ServletConfig;

//import com.google.gson.Gson;

public interface CounterService {
	
	public AccountOutput countAccount(String account);
	
	public TypeOutput countType(String type);
	
	public String readUrl(String urlString) throws Exception;
	
	public static List<AustinEntity> parseURLdata() {
		return null;
	}

}
