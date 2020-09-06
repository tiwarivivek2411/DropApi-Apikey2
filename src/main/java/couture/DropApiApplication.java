package couture;
import couture.ApplicationHealthCheck;
import couture.DropApiConfiguration;
import couture.Brand;
import couture.BrandRepository;
import couture.BrandResource;
// import couture.SimpleAuthenticator;
import io.dropwizard.Application;
// import couture.AppAuthorizer;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import java.util.ArrayList;
import java.util.List;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.oauth.OAuthCredentialAuthFilter;
import io.dropwizard.auth.AuthDynamicFeature;
// import couture.SimpleAuthenticator;
// import couture.ApplicationUser;
import couture.ApiKeyAuthenticator;
import couture.App;
import couture.AccessTokenDao;
// import couture.OAuth2Resource;
// import org.joda.time.DateTimeZone;
import java.util.*;
// import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
public class DropApiApplication extends Application<DropApiConfiguration> {
    public static void main(final String[] args) throws Exception {
        new DropApiApplication().run("server","config.yml");
    }

    @Override
    public String getName() {
        return "DropApi";
    }
	
    @Override
    public void initialize(final Bootstrap<DropApiConfiguration> bootstrap) {
        // TODO: application initialization
		bootstrap.setConfigurationSourceProvider(new ResourceConfigurationSourceProvider());
	        super.initialize(bootstrap);

	    // DateTimeZone.setDefault(DateTimeZone.UTC);

    }

    @Override
    public void run(final DropApiConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
		final int defaultSize = configuration.getDefaultSize();
	    final BrandRepository brandRepository = new BrandRepository(initBrands());
	    final BrandResource brandResource = new BrandResource(defaultSize, brandRepository);
	    // System.out.println("hi2");
	 	// AccessTokenDao atd=new AccessTokenDao();

	    environment
	      .jersey()
	      .register(brandResource);
		// environment.jersey().register(new OAuth2Resource(atd,ud));
        final ApplicationHealthCheck healthCheck = new ApplicationHealthCheck();
        environment
          .healthChecks()
          .register("application", healthCheck);
		environment.jersey().register(new AuthDynamicFeature(new OAuthCredentialAuthFilter.Builder<App>()
                .setAuthenticator(new ApiKeyAuthenticator())
                .setPrefix("Apikey")
                .buildAuthFilter()));
	// environment.jersey().register(RolesAllowedDynamicFeature.class);
	environment.jersey().register(new AuthValueFactoryProvider.Binder<>(App.class));

    }
 private List<Brand> initBrands() {
        final List<Brand> brands = new ArrayList<>();
        brands.add(new Brand(1L, "Brand1"));
        brands.add(new Brand(2L, "Brand2"));
        brands.add(new Brand(3L, "Brand3"));

        return brands;
    }

}
