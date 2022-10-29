package fashion.store.EasyShop.service.inter;

import fashion.store.EasyShop.dto.CustomerDto;
import fashion.store.EasyShop.exception.BadRequestException;
import javassist.NotFoundException;

import java.util.List;

public interface ICustomerService {
    CustomerDto getCustomer(Long id) throws NotFoundException;
    List<CustomerDto> getCustomers();
    List<CustomerDto> getCustomersLike(String lastNameLike);
    CustomerDto createCustomer(CustomerDto customerDto) throws BadRequestException;
    CustomerDto updateCustomer(CustomerDto customerDto, Long id) throws NotFoundException;
    void deleteCustomer(Long id) throws NotFoundException;

}
