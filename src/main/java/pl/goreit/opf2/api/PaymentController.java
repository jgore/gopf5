package pl.goreit.opf2.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.goreit.generated.InterchangeModel;
import pl.goreit.opf2.infrastructure.rabbitmq.Sender;
import pl.goreit.opf2.model.Interchange;
import pl.goreit.opf2.service.FileStorageService;
import pl.goreit.opf2.service.PaymentService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private Sender sender;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping
    public Interchange create(@RequestParam String creditorAccountNo, @RequestParam String debtorAccountNo, @RequestParam("file") MultipartFile file) throws IOException {

        String jsonXml = convertXmlToJson(file);

        Interchange interchangeSaved = paymentService.create(creditorAccountNo, debtorAccountNo, jsonXml);

        InterchangeModel interchangeModel = convertToInerchangeModel(interchangeSaved);
        String json = objectMapper.writeValueAsString(interchangeModel);

        sender.send(json);

        return interchangeSaved;
    }


    @GetMapping
    public List<Interchange> getAll() {
        List<Interchange> all = paymentService.getAll();
        return all;
    }

    private InterchangeModel convertToInerchangeModel(Interchange savedInterchange) {
        InterchangeModel interchangeModel = new InterchangeModel();
        interchangeModel.setCreditorAccount(savedInterchange.getCreditorAccountNo());
        interchangeModel.setDebtorAccount(savedInterchange.getDebtorAccountNo());
        interchangeModel.setAmount(500);
        interchangeModel.setXml(savedInterchange.getXml());
        return interchangeModel;
    }

    public String convertXmlToJson(MultipartFile file) throws IOException {
        String fileName = fileStorageService.storeFile(file);

        XmlMapper xmlMapper = new XmlMapper();
        JsonNode node = xmlMapper.readTree(file.getBytes());

        return this.objectMapper.writeValueAsString(node);
    }

}
