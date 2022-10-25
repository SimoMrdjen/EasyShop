package fashion.store.EasyShop.service.implementation;

import fashion.store.EasyShop.mapper.PurchaseContractMapper;
import fashion.store.EasyShop.repository.InstallmentRepository;
import fashion.store.EasyShop.repository.PurchaseContractRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PurchaseContractServiceTest {

    @Mock
    PurchaseContractRepository purchaseContractRepository;
    @Mock
    InstallmentRepository installmentRepository;
    @Mock
    PurchaseContractMapper mapper;


    @BeforeEach
    void setUp() {

    }

    @Test
    void getPurchaseContracts() {
    }

    @Test
    void getPurchaseContractsOfCustomer() {
    }

    @Test
    void getPurchaseContract() {
    }

    @Test
    void createPurchaseContract() {
    }
}