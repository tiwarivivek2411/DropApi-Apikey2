package couture;
import java.security.Principal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Data
@AllArgsConstructor
public class App implements Principal {
	private String name;

	public String getName() {
		return name;
	}

	
}
