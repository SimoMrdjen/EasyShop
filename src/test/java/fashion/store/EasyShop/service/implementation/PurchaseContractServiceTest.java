package fashion.store.EasyShop.service.implementation;

import fashion.store.EasyShop.dto.CustomerDto;
import fashion.store.EasyShop.dto.InstallmentDto;
import fashion.store.EasyShop.dto.PurchaseContractDto;
import fashion.store.EasyShop.entity.*;
import fashion.store.EasyShop.mapper.PurchaseContractMapper;
import fashion.store.EasyShop.repository.InstallmentRepository;
import fashion.store.EasyShop.repository.PurchaseContractRepository;
import javassist.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PurchaseContractServiceTest {

    @Mock
    PurchaseContractRepository purchaseContractRepository;
    @Mock
    InstallmentRepository installmentRepository;
    @Mock
    PurchaseContractMapper mapper;
    PurchaseContractService service;

    Installment installment;
//    Installment installment2;
    PurchaseContract purchaseContract;
//    PurchaseContract purchaseContract1;
    Customer customer;
    InstallmentDto installmentDto;
//    InstallmentDto dtoUpdate;
    CustomerDto customerDto;
    PurchaseContractDto purchaseContractDto;


    @BeforeEach
    void setUp() {
        service = new PurchaseContractService(purchaseContractRepository,installmentRepository,mapper);
        customer = new Customer(1L, "Mrdjen", "Simo", "0206970850101", "Yr",
                "0205", "Zrenjanin PU", "dr.sizni@gmail.com", "0631030260");
        customerDto = new CustomerDto(1L, "Mrdjen", "Simo", "0206970850101", "Yr",
                "0205", "Zrenjanin PU", "dr.sizni@gmail.com", "0631030260");

        purchaseContract = new PurchaseContract(1L, customer, 100.00, 50.00, LocalDate.now(),
                new ArrayList<Installment>());
        purchaseContractDto = new PurchaseContractDto(1L, customerDto, 100.00, 50.00, LocalDate.now(),
               null);

//        purchaseContract1 = new PurchaseContract(2L, customer, 5.00, 2.00, LocalDate.now(),
//                new ArrayList<Installment>());
        installment = new Installment(1L,purchaseContract, InstallmentOrdinal.FIRST,
                20.00, LocalDate.now().plusMonths(1),null,null,null);
//        installment2 = new Installment(2L,purchaseContract1, InstallmentOrdinal.FIRST,
//                1.00, LocalDate.now(),2.00, LocalDate.now(), PaymentMethod.CASH);

//        purchaseContractDto = new PurchaseContractDto(1L, customerDto, 100.00, 50.00, LocalDate.now(),
//                new ArrayList<InstallmentDto>());
        installmentDto = new InstallmentDto(1L,purchaseContractDto, InstallmentOrdinal.FIRST,
                20.00, LocalDate.now().plusMonths(1),null,null,null);
//        dtoUpdate = new InstallmentDto(1L,purchaseContractDto, InstallmentOrdinal.FIRST,
//                1.00, LocalDate.now(),1.00, LocalDate.now(),PaymentMethod.CASH);
        purchaseContract.getInstallments().add(installment);
        purchaseContractDto.setInstallments(List.of(installmentDto));


    }

    @Test
    void shouldReturnDtosWhenGetPurchaseContracts() {
        when(purchaseContractRepository.findAll()).thenReturn(List.of(purchaseContract));
        when(mapper.mapGetEntityToDto(purchaseContract)).thenReturn(purchaseContractDto);
        assertThat(service.getPurchaseContracts()).isEqualTo(List.of(purchaseContractDto));
    }

    @Test
    void shouldReturnDtosWhenGetPurchaseContractsOfCustomer() {
        when(purchaseContractRepository.findByCustomerId(1L)).thenReturn(List.of(purchaseContract));
        when(mapper.mapGetEntityToDto(purchaseContract)).thenReturn(purchaseContractDto);
        assertThat(service.getPurchaseContractsOfCustomer(1L)).isEqualTo(List.of(purchaseContractDto));


    }

    @Test
    void shouldReturnDtosWhenGetPurchaseContract() throws NotFoundException {
//        PurchaseContract purchaseContract =
//                repository.findById(id).orElseThrow(() -> new NotFoundException(CONTRACT_NOT_FOUND));
//        return mapper.mapGetEntityToDto(purchaseContract);
        when(purchaseContractRepository.findById(1L)).thenReturn(Optional.ofNullable(purchaseContract));
        when(mapper.mapGetEntityToDto(purchaseContract)).thenReturn(purchaseContractDto);
        assertThat(service.getPurchaseContract(1L)).isEqualTo(purchaseContractDto);
    }

    @Test
    void createPurchaseContract() {
    }
}
