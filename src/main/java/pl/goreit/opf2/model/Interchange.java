package pl.goreit.opf2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Interchange {

    @Id
    private String id;

    private String creditorAccountNo;

    private String debtorAccountNo;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String xml;

    private Status status;

    public Interchange(String creditorAccountNo, String debtorAccountNo, String xml) {
        this.creditorAccountNo = creditorAccountNo;
        this.debtorAccountNo = debtorAccountNo;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.xml = xml;
    }

    public String getId() {
        return id;
    }

    public String getCreditorAccountNo() {
        return creditorAccountNo;
    }

    public String getDebtorAccountNo() {
        return debtorAccountNo;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public String getXml() {
        return xml;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id='" + id + '\'' +
                ", creditorAccountNo='" + creditorAccountNo + '\'' +
                ", debtorAccountNo='" + debtorAccountNo + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public enum Status {
        DELIVERED, REJECTED, ACCEPTED
    }
}
