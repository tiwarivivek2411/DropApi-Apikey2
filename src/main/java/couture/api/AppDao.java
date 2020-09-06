package couture;
import couture.App;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AppDao {
	private static final Map<String, App> DB = new HashMap<>();

	public AppDao() {
		DB.put("app1ApiKey", new App("App1"));
	}

	

	public Optional<App> findAppByApiKey(final String apikey) {
		if (DB.containsKey(apikey)) {
			return Optional.of(DB.get(apikey));
		} else {
			return Optional.empty();
		}
	}
	
}
