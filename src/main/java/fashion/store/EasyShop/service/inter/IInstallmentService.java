package fashion.store.EasyShop.service.inter;

import fashion.store.EasyShop.dto.InstallmentDto;
import fashion.store.EasyShop.entity.Installment;
import fashion.store.EasyShop.entity.PurchaseContract;

import java.util.List;

public interface IInstallmentService {
      List<InstallmentDto> getAllInstallmentsByCustomerId(Long customerId);
    InstallmentDto updateInstallment(InstallmentDto installmentDto);
    InstallmentDto createInstallment(InstallmentDto installmentDto);
    List<Installment> createListOfInstallmentsForContract(PurchaseContract purchaseContract);
}

