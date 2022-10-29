package fashion.store.EasyShop.service.inter;

import fashion.store.EasyShop.dto.InstallmentDto;
import fashion.store.EasyShop.entity.PurchaseContract;
import javassist.NotFoundException;

import java.util.List;

public interface IInstallmentService {
      List<InstallmentDto> getAllInstallmentsByCustomerId(Long customerId);
    InstallmentDto updateInstallment(InstallmentDto installmentDto, Long id) throws NotFoundException;
    InstallmentDto createInstallment(InstallmentDto installmentDto);
    List<InstallmentDto> createListOfInstallmentsForContract(PurchaseContract purchaseContract);

    InstallmentDto getInstallment(Long id) throws NotFoundException;
}

