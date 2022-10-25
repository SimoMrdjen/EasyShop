package fashion.store.EasyShop.service.implementation;

import fashion.store.EasyShop.dto.InstallmentDto;
import fashion.store.EasyShop.mapper.InstallmentMapper;
import fashion.store.EasyShop.repository.InstallmentRepository;
import fashion.store.EasyShop.service.inter.IInstallmentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
public class InstallmentService implements IInstallmentService {

    @Autowired
    private InstallmentRepository installmentRepository;
    @Autowired
    InstallmentMapper installmentMapper;

    @Override
    public List<InstallmentDto> getAllInstallmentsByCustomerId(Long customerId) {
           return installmentRepository.findAllByPurchaseContract_Customer_Id(customerId).
                stream().
                filter(i -> Objects.isNull(i.getPaidAmount())).
                map(installmentMapper::mapGetEntityToDto).
                collect(Collectors.toList());
    }

    @Override
    public InstallmentDto updateInstallment(InstallmentDto installmentDto) {
        return null;
    }
}
