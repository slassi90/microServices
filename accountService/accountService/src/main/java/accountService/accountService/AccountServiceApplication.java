package accountService.accountService;

import clients.CustomerRestClient;
import entities.BankAccount;
import enums.AccountType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repository.BankAccountRepository;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication(
		scanBasePackages = { "web", "repository", "entities","enums" } // ← tes packages
)
@EnableJpaRepositories(basePackages = "repository")        // ← crée le bean du repo
@EntityScan(basePackages = "entities")
@EnableFeignClients(basePackages = "clients")
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandlineRunner(BankAccountRepository accountRepository, CustomerRestClient customerRestClient){
	return args ->{
		customerRestClient.allCustomers().forEach(c->{
			BankAccount bankAccount1 = BankAccount.builder()
					.accountId(UUID.randomUUID().toString())
					.currency("MAD")
					.balance(Math.random()*90000)
					.createAt(LocalDate.now())
					.type(AccountType.CUURENT_ACCOUNT)
					.customerId(c.getId())
					.build();
			BankAccount bankAccount2 = BankAccount.builder()
					.accountId(UUID.randomUUID().toString())
					.currency("MAD")
					.balance(Math.random()*90000)
					.createAt(LocalDate.now())
					.type(AccountType.CUURENT_ACCOUNT)
					.customerId(c.getId())
					.build();
			accountRepository.save(bankAccount1);
			accountRepository.save(bankAccount2);
		});


	};

	}

}
