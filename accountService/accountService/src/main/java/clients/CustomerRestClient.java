package clients;

import Model.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="CUSTOMERSERVICE")
public interface CustomerRestClient {
    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customerService",
            fallbackMethod ="getDefaultCustomer" )
    Customer findCustomerById(@PathVariable long id);
    @GetMapping("/customers" )
    @CircuitBreaker(name = "customerService",
            fallbackMethod ="allCustomers" )
    List<Customer> allCustomers();
    default Customer getDefaultCustomer(Long id,Exception exception){
        Customer customer = new Customer();
        customer.setId(id);
        customer.setFirstname("Not Vailable");
        customer.setLastname("Not Vailable");
        customer.setEmail("Not Vailable");
        return customer;

    }

    default List<Customer>allCustomers (Exception exception){
        return List.of();
    }
}
