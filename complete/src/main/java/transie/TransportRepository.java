package transie;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "transport", path = "transport")
public interface TransportRepository extends
		PagingAndSortingRepository<Transport, Long> {

	List<Transport> findById(String id);
	List<Transport> findByOrigin(@Param("origin") String origin);	
	List<Transport> findAll();
	List<Transport> findByOriginAndDestination(@Param("origin") String origin, @Param("destination") String destination);

}