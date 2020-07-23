package pl.goreit.opf2.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.goreit.opf2.model.Payment;
import pl.goreit.opf2.repository.PaymentRepository;
import pl.goreit.opf2.service.PaymentService;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public Payment create(@RequestParam String creditorAccountNo, @RequestParam String debtorAccountNo) {

        Payment paymentSaved = paymentService.create(creditorAccountNo, debtorAccountNo);

        return paymentSaved;
    }

    @GetMapping
    public List<Payment> getAll() {
        List<Payment> all = paymentService.getAll();
        return all;
    }

}
