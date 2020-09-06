package couture;
// import couture.AccessToken;
import couture.App;
import couture.AuthDB;
// import couture.AccessTokenDao;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.joda.time.DateTime;
import org.joda.time.Period;
import java.io.*;
import java.util.UUID;
import java.util.Base64;
//@AllArgsConstructor
public class ApiKeyAuthenticator implements Authenticator<String, App> {
	// public static final int ACCESS_TOKEN_EXPIRE_TIME_MIN = 2;
	// private final AccessTokenDao accessTokenDAO;
	// // private final AppDao appDAO;
	// public ApiKeyAuthenticator(AccessTokenDao atd){
	// 	this.accessTokenDAO=atd;
	// 	// this.appDAO=ad;
	// }
	@Override
	public Optional<App> authenticate(String apikey) throws AuthenticationException {
		


		// Optional<AccessToken> accessToken = accessTokenDAO.findAccessTokenByKey(apikey);
		if (!AuthDB.checkApiKey(apikey)) {
			boolean var=false;
			return Optional.empty();
		}


		return Optional.of(new App(apikey));
	}
}
