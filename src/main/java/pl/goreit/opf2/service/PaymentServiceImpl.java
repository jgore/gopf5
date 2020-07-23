package pl.goreit.opf2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.goreit.opf2.model.Payment;
import pl.goreit.opf2.repository.PaymentRepository;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment create(String creditor, String debtor) {
        Payment payment = new Payment(creditor, debtor);
        Payment save = paymentRepository.save(payment);
        return save;
    }

    @Override
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }


}
