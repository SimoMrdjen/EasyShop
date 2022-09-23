package fashion.store.EasyShop.service.inter;

import fashion.store.EasyShop.dto.CustomerDto;
import javassist.NotFoundException;
import java.util.List;

public interface ICustomerService {
    CustomerDto getCustomer(Long id) throws NotFoundException;
    List<CustomerDto> getCustomers();
    List<CustomerDto> getCustomersLike(String lastNameLike);
    CustomerDto createCustomer(CustomerDto customerDto);
    CustomerDto updateCustomer(CustomerDto customerDto) throws NotFoundException;
    void deleteCustomer(Long id) throws NotFoundException;

}
