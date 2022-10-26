package fashion.store.EasyShop.service.implementation;

import fashion.store.EasyShop.dto.CustomerDto;
import fashion.store.EasyShop.dto.InstallmentDto;
import fashion.store.EasyShop.dto.PurchaseContractDto;
import fashion.store.EasyShop.entity.Customer;
import fashion.store.EasyShop.entity.Installment;
import fashion.store.EasyShop.entity.InstallmentOrdinal;
import fashion.store.EasyShop.entity.PaymentMethod;
import fashion.store.EasyShop.entity.PurchaseContract;
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
    InstallmentDto dtoUpdate;
    CustomerDto customerDto;
    PurchaseContractDto purchaseContractDto;

    @BeforeEach
    void setUp() {
        service = new InstallmentService(repo,mapper);
        customer = new Customer(1L, "Mrdjen", "Simo", "0206970850101", "Yr",
                "0205", "Zrenjanin PU", "dr.sizni@gmail.com", "0631030260");
        purchaseContract = new PurchaseContract(1L, customer, 100.00, 40.00, LocalDate.now(),
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
        dtoUpdate = new InstallmentDto(1L,purchaseContractDto, InstallmentOrdinal.FIRST,
                1.00, LocalDate.now(),1.00, LocalDate.now(),PaymentMethod.CASH);
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
        when(repo.save(installment2)).
                thenReturn(installment2);
        when(mapper.mapGetEntityToDto(installment2)).
                thenReturn(dtoUpdate);
        when(mapper.mapEditDtoToEntity(dtoUpdate)).
                thenReturn(installment2);
        assertThat(service.updateInstallment(dtoUpdate)).isEqualTo(dtoUpdate);
    }

    @Test
    void shouldReturnDtoWhenCreateInstallment() {
        when(repo.save(installment)).
                thenReturn(installment);
        when(mapper.mapGetEntityToDto(installment)).
                thenReturn(dto);
        when(mapper.mapCreateDtoToEntity(dto)).
                thenReturn(installment);
        assertThat(service.createInstallment(dto)).isEqualTo(dto);
    }

    @Test
    void createListOfInstallmentsForContract(){
        Double installAmount =(purchaseContract.getContractAmount() - purchaseContract.getParticipation()) / 3 ;
        List<Installment> installments = List.of(
                new Installment(purchaseContract, InstallmentOrdinal.FIRST, installAmount, purchaseContract.getContractDate().plusMonths(1)),
                new Installment(purchaseContract, InstallmentOrdinal.SECOND, installAmount, purchaseContract.getContractDate().plusMonths(2)),
                new Installment(purchaseContract, InstallmentOrdinal.THIRD, installAmount, purchaseContract.getContractDate().plusMonths(3))
        );
        List<Installment> installmentsTest = List.of(
                new Installment(purchaseContract, InstallmentOrdinal.FIRST, 20.00, purchaseContract.getContractDate().plusMonths(1)),
                new Installment(purchaseContract, InstallmentOrdinal.SECOND, 20.00, purchaseContract.getContractDate().plusMonths(2)),
                new Installment(purchaseContract, InstallmentOrdinal.THIRD, 20.00, purchaseContract.getContractDate().plusMonths(3))
        );
        when(repo.saveAll(installments)).thenReturn(installments);
        service.createListOfInstallmentsForContract(purchaseContract).forEach(System.out::println);
        assertThat(service.createListOfInstallmentsForContract(purchaseContract)).
                usingElementComparatorIgnoringFields("id").isEqualTo(installmentsTest);
   }
}
