package fashion.store.EasyShop.service.inter;

public interface IInstallmentService {
      List<InstallmentDto> getAllInstallmentsByCustomerId(Long customerId);
    InstallmentDto updateInstallment(InstallmentDto installmentDto);
}

