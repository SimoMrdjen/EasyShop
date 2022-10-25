package fashion.store.EasyShop.service.inter;

import fashion.store.EasyShop.dto.InstallmentDto;

import java.util.List;

public interface IInstallmentService {
      List<InstallmentDto> getAllInstallmentsByCustomerId(Long customerId);
    InstallmentDto updateInstallment(InstallmentDto installmentDto);
    InstallmentDto createInstallment(InstallmentDto installmentDto);
}

