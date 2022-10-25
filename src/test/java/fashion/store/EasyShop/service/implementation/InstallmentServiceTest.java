package fashion.store.EasyShop.service.implementation;

import fashion.store.EasyShop.dto.CustomerDto;
import fashion.store.EasyShop.dto.InstallmentDto;
import fashion.store.EasyShop.dto.PurchaseContractDto;
import fashion.store.EasyShop.entity.*;
import fashion.store.EasyShop.mapper.InstallmentMapper;
import fashion.store.EasyShop.repository.InstallmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InstallmentServiceTest {

    @Mock
    InstallmentRepository repo;
    @Mock
    InstallmentMapper mapper;

    private InstallmentService service;
    Installment installment;
    Installment installment2;
    PurchaseContract purchaseContract;
    PurchaseContract purchaseContract1;
    Customer customer;
    InstallmentDto dto;
    CustomerDto customerDto;
    PurchaseContractDto purchaseContractDto;

    @BeforeEach
    void setUp() {
        service = new InstallmentService(repo,mapper);
        customer = new Customer(1L, "Mrdjen", "Simo", "0206970850101", "Yr",
                "0205", "Zrenjanin PU", "dr.sizni@gmail.com", "0631030260");
        purchaseContract = new PurchaseContract(1L, customer, 100.00, 50.00, LocalDate.now(),
                new ArrayList<Installment>());
        purchaseContract1 = new PurchaseContract(2L, customer, 5.00, 2.00, LocalDate.now(),
                new ArrayList<Installment>());
        installment = new Installment(1L,purchaseContract, InstallmentOrdinal.FIRST,
                20.00, LocalDate.now().plusMonths(1),null,null,null);
        installment2 = new Installment(2L,purchaseContract1, InstallmentOrdinal.FIRST,
                1.00, LocalDate.now(),2.00, LocalDate.now(), PaymentMethod.CASH);
        customerDto = new CustomerDto(1L, "Mrdjen", "Simo", "0206970850101", "Yr",
                "0205", "Zrenjanin PU", "dr.sizni@gmail.com", "0631030260");
        purchaseContractDto = new PurchaseContractDto(1L, customerDto, 100.00, 50.00, LocalDate.now(),
                new ArrayList<InstallmentDto>());
        dto = new InstallmentDto(1L,purchaseContractDto, InstallmentOrdinal.FIRST,
                20.00, LocalDate.now().plusMonths(1),null,null,null);
    }

   @Test
    void shouldReturnListDtosWhenGetAllInstallmentsByCustomerId() {
        when(repo.findAllByPurchaseContract_Customer_Id(1L)).
                thenReturn(List.of(installment,installment2));
        when(mapper.mapGetEntityToDto(installment)).
                thenReturn(dto);

        assertThat(service.getAllInstallmentsByCustomerId(1L)).
                usingDefaultElementComparator().isEqualTo(List.of(dto));
    }

    @Test
    void shouldReturnDtoWhenUpdateInstallment() {
    }
}
