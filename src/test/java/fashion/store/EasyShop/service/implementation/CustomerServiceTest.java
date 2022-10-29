package fashion.store.EasyShop.service.implementation;

import fashion.store.EasyShop.dto.CustomerDto;
import fashion.store.EasyShop.entity.Customer;
import fashion.store.EasyShop.mapper.CustomerMapper;
import fashion.store.EasyShop.repository.CustomerRepository;
import javassist.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {
    @Mock
    CustomerRepository customerRepository;
    @Mock
    CustomerMapper customerMapper;

    private CustomerService customerService;
    Customer customer;
    CustomerDto customerDto;
    CustomerDto customerDtoIdNull;

    @BeforeEach
    void setUp() {
        customerService = new CustomerService( customerRepository, customerMapper);
        customer = new Customer(1L,
                "Mrdjen",
                "Simo",
                "0206970850101",
                "Yr",
                "0205",
                "Zrenjanin PU",
                "dr.sizni@gmail.com",
                "0631030260");
        customerDto = new CustomerDto(1L,
                "Mrdjen",
                "Simo",
                "0206970850101",
                "Yr",
                "0205",
                "Zrenjanin PU",
                "dr.sizni@gmail.com",
                "0631030260");
        customerDtoIdNull = new CustomerDto("Mrdjen",
                "Simo",
                "0206970850101",
                "Yr",
                "0205",
                "Zrenjanin PU",
                "dr.sizni@gmail.com",
                "0631030260");
    }

    @Test
   // @Disabled
    void shouldGetCustomerIfExist() throws NotFoundException {
        when(customerMapper.mapEntityToCustomerDto(customer)).
                thenReturn(customerDto);
        when(customerRepository.findById(1L)).
                thenReturn(Optional.ofNullable(customer));
        assertThat(customerDto).isEqualTo(customerService.getCustomer(1L));
    }
    @Test
    //@Disabled
    void shouldThrowNotFoundExWhenGetCustomerIfNotExist(){
        when(customerRepository.findById(anyLong())).
                thenReturn(Optional.empty());
        assertThatExceptionOfType(NotFoundException.class)
                .isThrownBy(() -> { customerService.getCustomer(anyLong()); })
                .withMessage("Customer not found");
    }

    @Test
    //@Disabled
    void shouldGetCustomers() {
        when(customerMapper.mapEntityToCustomerDto(customer)).thenReturn(customerDto);
        when(customerRepository.findAll()).thenReturn(List.of(customer));
        assertThat(customerService.getCustomers()).isEqualTo(List.of(customerDto));
    }

    @Test
   // @Disabled
    void shouldCreateCustomer() throws NotFoundException {
        when(customerMapper.mapEntityToCustomerDto(customer)).thenReturn(customerDto);
        when(customerMapper.mapCreateCustomerDtoToEntity(customerDtoIdNull)).thenReturn(customer);
        when(customerRepository.save(customer)).thenReturn(customer);
        when(customerRepository.findByJmbg(customer.getJmbg())).thenReturn(Optional.empty());
        assertThat(customerService.createCustomer(customerDtoIdNull)).isEqualTo(customerDto);
    }

    @Test
    //@Disabled
    void shouldUpdateCustomerWhenExist() throws NotFoundException {
        when(customerMapper.mapEditCustomerDtoToEntity(customerDto)).thenReturn(customer);
        when(customerRepository.findById(anyLong())).thenReturn(Optional.of(customer));
        when(customerRepository.save(customer)).thenReturn( customer);

        when(customerMapper.mapEntityToCustomerDto(customer)).thenReturn(customerDto);

        assertThat(customerService.updateCustomer(customerDto, anyLong())).isEqualTo(customerDto);
    }

    @Test
    //@Disabled
     void shouldThrowNotFoundExWhenUpdateCustomerIfNotExist() throws NotFoundException {
        when(customerRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertThatExceptionOfType(NotFoundException.class).
                isThrownBy(() -> {customerService.updateCustomer(customerDto,anyLong());}).
                withMessage("Customer not found");
     }


    @Test
    //@Disabled
    void shouldThrowNotFoundExWhenDeleteCustomerIfNotExist(){
        when(customerRepository.findById(1L)).thenReturn(Optional.empty());
        assertThatExceptionOfType(NotFoundException.class).
                isThrownBy(() -> {customerService.deleteCustomer(1L);}).
                withMessage("Customer not found");

    }
}