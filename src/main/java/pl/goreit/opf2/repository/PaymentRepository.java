package pl.goreit.opf2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.goreit.opf2.model.Payment;

@Repository
public interface PaymentRepository extends MongoRepository<Payment, String> {
}
