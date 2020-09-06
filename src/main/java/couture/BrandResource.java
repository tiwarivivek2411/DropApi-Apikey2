package couture;
import couture.Brand;
import couture.BrandRepository;
import couture.App;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;
import io.dropwizard.auth.Auth;
@Path("/brands")
@Produces(MediaType.APPLICATION_JSON)
public class BrandResource {
	private final int defaultSize;
	private final BrandRepository brandRepository;
 
    public BrandResource(int defaultSize, BrandRepository brandRepository) {
        this.defaultSize = defaultSize;
        this.brandRepository = brandRepository;
    }


    @GET
    public List<Brand> getBrands(@Auth App app,@QueryParam("size") Optional<Integer> size) {
        return brandRepository.findAll(size.orElse(defaultSize));
    }


    @GET
    @Path("/id")
    public List<Brand> getBr(@Auth App app,@QueryParam("size") Optional<Integer> size) {
        return brandRepository.findAll(size.orElse(defaultSize));
    }


    @GET
    @Path("/{id}")
    public Brand getById(@Auth App app,@PathParam("id") Long id) {
        return brandRepository
          .findById(id)
          .orElseThrow(RuntimeException::new);
    }
}
