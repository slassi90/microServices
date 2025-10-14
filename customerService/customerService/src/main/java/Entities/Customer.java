package Entities;

import jakarta.persistence.*;
import lombok.*;
@Table(name = "customers")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Entity
public class Customer {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     private String firstname;
     private String lastname;
     private String email;
}
