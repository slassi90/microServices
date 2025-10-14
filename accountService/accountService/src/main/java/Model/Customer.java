package Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@ToString
public class Customer {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
}
