package fashion.store.EasyShop.repository;

import fashion.store.EasyShop.entity.Customer;
import fashion.store.EasyShop.entity.Installment;
import fashion.store.EasyShop.entity.PurchaseContract;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PurchaseContractRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    PurchaseContractRepository repository;
    PurchaseContract purchaseContract;
    Customer customer;

    @BeforeEach
    void setUp() {
        customer = customerRepository.save( new Customer(null, "Mrdjen", "Simo", "0206970850101", "Yr",
                "0205", "Zrenjanin PU", "dr.sizni@gmail.com", "0631030260"));
        purchaseContract = new PurchaseContract(null, customer, 100.00, 50.00, LocalDate.now(),
                new ArrayList<Installment>());
    }

    @Test
    void findByCustomerId() {
        repository.save(purchaseContract);
        List<PurchaseContract> test = repository.findByCustomerId(1L);
        test.forEach(System.out::println);
        assertThat(test).usingElementComparatorIgnoringFields("id").isEqualTo(List.of(purchaseContract));
    }
}