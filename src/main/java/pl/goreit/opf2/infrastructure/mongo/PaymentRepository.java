package pl.goreit.opf2.infrastructure.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.goreit.opf2.model.Interchange;

@Repository
public interface PaymentRepository extends MongoRepository<Interchange, String> {
}
