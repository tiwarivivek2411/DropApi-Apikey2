package couture;

import couture.App;
import couture.AccessToken;
import java.util.Optional;
import org.joda.time.DateTime;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AccessTokenDao {
	private static final Map<String, AccessToken> DB = new HashMap<>();

	public Optional<AccessToken> findAccessTokenByKey(final String apikey) {
		AccessToken accessToken = DB.get(apikey);
		if (accessToken == null) {
			return Optional.empty();
		}
		return Optional.of(accessToken);
	}
	static{
		String apikey="app1ApiKey";
		AccessToken accessToken = new AccessToken(apikey);
		DB.put(apikey,accessToken);
	}
	/*public AccessToken generateNewAccessToken(final User user, final DateTime dateTime) {
		AccessToken accessToken = new AccessToken(UUID.randomUUID(), user.getId(), dateTime);
		DB.put(accessToken.getAccessTokenId(), accessToken);
		return accessToken;
	}

	public void setLastAccessTime(final UUID accessTokenUUID, final DateTime dateTime) {
		AccessToken accessToken = DB.get(accessTokenUUID);
		AccessToken updatedAccessToken = accessToken.withLastAccessUTC(dateTime);
		DB.put(accessTokenUUID, updatedAccessToken);
	}*/
}
