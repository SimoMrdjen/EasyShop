package fashion.store.EasyShop.repository;

import fashion.store.EasyShop.entity.Customer;
import fashion.store.EasyShop.entity.Installment;
import fashion.store.EasyShop.entity.InstallmentOrdinal;
import fashion.store.EasyShop.entity.PurchaseContract;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@DataJpaTest
class InstallmentRepositoryTest {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    PurchaseContractRepository contractRepository;
    @Autowired
    InstallmentRepository repository;
    Installment installment;
    Installment installment2;
    PurchaseContract purchaseContract;
    PurchaseContract purchaseContract1;
    Customer customer;


    @BeforeEach
    void setUp() {

        customer = customerRepository.save( new Customer(null, "Mrdjen", "Simo", "0206970850101", "Yr",
                "0205", "Zrenjanin PU", "dr.sizni@gmail.com", "0631030260"));
        purchaseContract = new PurchaseContract(null, customer, 100.00, 50.00, LocalDate.now(),
                new ArrayList<Installment>());
        purchaseContract1 = new PurchaseContract(null, customer, 5.00, 2.00, LocalDate.now(),
                new ArrayList<Installment>());
        installment = repository.save(new Installment(purchaseContract, InstallmentOrdinal.FIRST, 20.00, LocalDate.now().plusMonths(1)));

        installment2 = repository.save(new Installment(purchaseContract1, InstallmentOrdinal.FIRST, 1.00, LocalDate.now().plusMonths(1)));
    }

    @Test
    void findAllByCustomerId() {
      List<Installment> insts = repository.findAllByPurchaseContract_Customer_Id(1L);
        System.out.println();
        insts.forEach(System.out::println);
        //System.out.println(installment);

        System.out.println();

    }
}