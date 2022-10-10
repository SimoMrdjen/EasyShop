package fashion.store.EasyShop.repository;

import fashion.store.EasyShop.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository customerRepository;
    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer(
                "Mrdjen",
                "Simo",
                "0206970850101",
                "Yr",
                "0205",
                "Zrenjanin PU",
                "dr.sizni@gmail.com",
                "0631030260");
        customerRepository.save(customer);
    }

    @Test
    void findByLastNameContainingIgnoreCase() {

    }

    @Test
    void shouldReturnCustomerWhenFindByJmbgIfExists() {
        Optional<Customer> fetchedCustomer = customerRepository.findByJmbg(customer.getJmbg());
        assertThat(fetchedCustomer.get().getJmbg()).isEqualTo(customer.getJmbg());
    }
}