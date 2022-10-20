package fashion.store.EasyShop.mapper;

import fashion.store.EasyShop.dto.CustomerDto;
import fashion.store.EasyShop.dto.InstallmentDto;
import fashion.store.EasyShop.dto.PurchaseContractDto;
import fashion.store.EasyShop.entity.Customer;
import fashion.store.EasyShop.entity.Installment;
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
class PurchaseContractMapperTest {

    PurchaseContractMapper mapper;
    PurchaseContract entity;
    PurchaseContractDto dto;
    Customer customer;
    CustomerDto customerDto;
    @Mock
    CustomerMapper customerMapper;
    
    @BeforeEach
    void setUp() {
        mapper = new PurchaseContractMapper(customerMapper);
        customer = new Customer(1L, "Mrdjen", "Simo", "0206970850101", "Yr",
                "0205", "Zrenjanin PU", "dr.sizni@gmail.com", "0631030260");
        customerDto = new CustomerDto(1L, "Mrdjen", "Simo", "0206970850101",
                "Yr", "0205", "Zrenjanin PU", "dr.sizni@gmail.com", "0631030260");
        entity = new PurchaseContract(1l, customer, 100.00, 50.00, LocalDate.now(),
                new ArrayList<Installment>());
        dto = new PurchaseContractDto(1l, customerDto, 100.00, 50.00, LocalDate.now(),
                new ArrayList<InstallmentDto>());
    }

    @Test
    void shouldReturnEntityWhenMapCreateDtoToEntity() {
        when(customerMapper.mapEditCustomerDtoToEntity(customerDto)).
                thenReturn(customer);
        entity.setId(null);
        entity.setInstallments(null);
        assertThat(mapper.mapCreateDtoToEntity(dto)).
                isEqualTo(entity);
    }

    @Test
    void shouldReturnEntityWhenMapCreateInstallmentDtoToEntity() {
        when(customerMapper.mapEditCustomerDtoToEntity(customerDto)).
                thenReturn(customer);
        entity.setInstallments(null);
        assertThat( mapper.mapCreateInstallmentDtoToEntity(dto)).
                isEqualTo(entity);
    }

    @Test
    void shouldReturnDtoWhenMapGetEntityToDto() {
        when(customerMapper.mapEntityToCustomerDto(customer)).
                thenReturn(customerDto);
        assertThat(mapper.mapGetEntityToDto(entity)).
                isEqualTo(dto);
    }
}
