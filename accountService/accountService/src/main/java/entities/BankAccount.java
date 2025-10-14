package entities;

import Model.Customer;
import enums.AccountType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class BankAccount {
    @Id
    private String accountId;
    private double balance;
    private LocalDate createAt;
    private String currency;
    @Enumerated(EnumType.STRING)// sauvgarder le type enum en string
    private AccountType type;
    @Transient //annuler cette attribue dans la base de donnee
    private Customer customer;
    private Long customerId;

}
