import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
public class AustinSocialMediaController {

	private CounterService counterService;

	public AustinSocialMediaController() {
		
	}

	@ResponseBody
	@RequestMapping(value = "/")
	public String helloWorld() {
		return "Hello world!";
	}

	
	@ResponseBody
	@RequestMapping(value = {"/austinsocialmedia"}, method = RequestMethod.GET)
	public Object findMediaCount(
	@RequestParam Map<String,String> requestParams, ModelMap model) {
		System.out.println("IN REQUEST");
		
		Map.Entry<String,String> entry= requestParams.entrySet().iterator().next();
		String key= entry.getKey();
		String value=entry.getValue();
		if(key.toLowerCase().equals("typestats")){
			return counterService.countType(value);
		}
		else if (key.toLowerCase().equals("accountstats")){
			return  counterService.countAccount(value);
		}
		
		requestParams.clear();
		
		return null;
	}

	private String RequestParam(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@ResponseBody
	public TypeOutput findType(String type){
		System.out.println("IN findTYPE");
		return counterService.countType(type.toLowerCase());
	}
	

	@ResponseBody
	@RequestMapping("/headers")
	public String getAllHeaders(@RequestHeader HttpHeaders headers) {
		Set<String> keys = headers.keySet();
		String response = "";
		Iterator<String> i = keys.iterator();
		while (i.hasNext()) {
			String key = i.next();
			List<String> value = headers.get(key);
			response += key + " " + value;
		}
		return response;
	}

	
	public void setCounterService(CounterService counterService) {
		this.counterService = counterService;
	}
}
