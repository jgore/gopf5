package pl.goreit.opf2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Payment {

    @Id
    private String id;

    private String creditorAccountNo;

    private String debtorAccountNo;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Payment(String creditorAccountNo, String debtorAccountNo) {
        this.creditorAccountNo = creditorAccountNo;
        this.debtorAccountNo = debtorAccountNo;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
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
}
