package pl.goreit.opf2.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.goreit.generated.InterchangeModel;
import pl.goreit.opf2.infrastructure.rabbitmq.Sender;
import pl.goreit.opf2.model.Interchange;
import pl.goreit.opf2.service.PaymentService;

import java.util.UUID;

@RestController
@RequestMapping("/test/payment")
public class TestPaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private Sender sender;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping
    public boolean create(@RequestParam Integer amount) throws InterruptedException, JsonProcessingException {


        for (int i = 0; i < amount; i++) {
            Interchange interchangeSaved = paymentService.create(UUID.randomUUID().toString(), UUID.randomUUID().toString(), null);


            InterchangeModel interchangeModel = new InterchangeModel();
            interchangeModel.setCreditorAccount(interchangeSaved.getCreditorAccountNo());
            interchangeModel.setDebtorAccount(interchangeSaved.getDebtorAccountNo());
            interchangeModel.setAmount(500);

            String json = objectMapper.writeValueAsString(interchangeModel);

            sender.send(json);
        }

        return true;
    }
}

