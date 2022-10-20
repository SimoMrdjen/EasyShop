package fashion.store.EasyShop.mapper;

import fashion.store.EasyShop.dto.CustomerDto;
import fashion.store.EasyShop.dto.InstallmentDto;
import fashion.store.EasyShop.dto.PurchaseContractDto;
import fashion.store.EasyShop.entity.Customer;
import fashion.store.EasyShop.entity.Installment;
import fashion.store.EasyShop.entity.InstallmentOrdinal;
import fashion.store.EasyShop.entity.PaymentMethod;
import fashion.store.EasyShop.entity.PurchaseContract;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InstallmentMapperTest {
    @Mock
    PurchaseContractMapper purchaseContractMapper;
    InstallmentMapper mapper;
    Installment entity;
    InstallmentDto dto;
    PurchaseContract purchaseContract;
    PurchaseContractDto purchaseContractDto;


    @BeforeEach
    void setUp() {
        mapper = new InstallmentMapper(purchaseContractMapper);
        purchaseContract = new PurchaseContract(1l, new Customer(), 100.00, 50.00, LocalDate.now(),
                new ArrayList<Installment>());
        purchaseContractDto = new PurchaseContractDto(1l, new CustomerDto(), 100.00, 50.00, LocalDate.now(),
                new ArrayList<InstallmentDto>());
        entity = new Installment(1L, purchaseContract, InstallmentOrdinal.FIRST, 10.00, LocalDate.now(),
                10.00, LocalDate.now(), PaymentMethod.CASH);
        dto = new InstallmentDto(1L, purchaseContractDto, InstallmentOrdinal.FIRST, 10.00, LocalDate.now(),
                10.00, LocalDate.now(), PaymentMethod.CASH);
    }

    @Test
    void shouldReturnEntityWhenMapCreateDtoToEntity() {
        when(purchaseContractMapper.mapCreateInstallmentDtoToEntity(purchaseContractDto)).
                thenReturn(purchaseContract);
        entity.setId(null);
        entity.setPaidAmount(null);
        entity.setPaymentDate(null);
        entity.setPaymentMethod(null);
        assertThat(mapper.mapCreateDtoToEntity(dto)).isEqualTo(entity);
    }

    @Test
    void shouldReturnEntityWhenMapEditDtoToEntity() {
        when(purchaseContractMapper.mapCreateInstallmentDtoToEntity(purchaseContractDto)).
                thenReturn(purchaseContract);
        assertThat(mapper.mapEditDtoToEntity(dto)).isEqualTo(entity);
    }

    @Test
    void shouldReturnDtoWhenMapGetEntityToDto() {
        when(purchaseContractMapper.mapGetEntityToDto(purchaseContract)).
                thenReturn(purchaseContractDto);
        assertThat(mapper.mapGetEntityToDto(entity)).isEqualTo(dto);
    }
}