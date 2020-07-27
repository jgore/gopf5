package pl.goreit.opf2.service;

import pl.goreit.opf2.model.Interchange;

import java.util.List;

public interface PaymentService {

    Interchange create(String creditor, String debtor, String json);

    List<Interchange> getAll();

}
