package pl.goreit.opf2.service;

import pl.goreit.opf2.model.Payment;

import java.util.List;

public interface PaymentService {

    Payment create(String creditor, String debtor);

    List<Payment> getAll();

}
