package couture;

import java.util.HashMap;
import java.util.Map;

public class AuthDB {
    private static final Map<String, String> AUTH = new HashMap<>();

    static {
        // AUTH.put("adminApiKey", "true");
        AUTH.put("app1ApiKey", "true");
    }
	
    public static boolean checkApiKey(String apiKey) {
        if(AUTH.get(apiKey)==null){

        	return false;
        }
        return true;
    }
}
