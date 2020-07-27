package pl.goreit.opf2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.goreit.opf2.model.Interchange;
import pl.goreit.opf2.infrastructure.mongo.PaymentRepository;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Interchange create(String creditor, String debtor, String xml) {
        Interchange interchange = new Interchange(creditor, debtor, xml);
        Interchange save = paymentRepository.save(interchange);
        return save;
    }

    @Override
    public List<Interchange> getAll() {
        return paymentRepository.findAll();
    }


}
