package customerService.customerService;

import Entities.Customer; import Repository.CustomerRepository;
import Web.CustomerRestController;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;


@SpringBootApplication(
		scanBasePackages = { "Web", "Repository", "Entities" } // ← tes packages
)
@EnableJpaRepositories(basePackages = "Repository")        // ← crée le bean du repo
@EntityScan(basePackages = "Entities")
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
		return args -> {
			List<Customer> customerList = List.of(
					Customer.builder()
							.firstname("achraf")
							.lastname("slassi")
							.email("slassi@gmail.com")
							.build(),
					Customer.builder()
							.firstname("amine")
							.lastname("elaouni")
							.email("elaouni")
							.build()
			);
			customerRepository.saveAll(customerList);
		};
	}
}
