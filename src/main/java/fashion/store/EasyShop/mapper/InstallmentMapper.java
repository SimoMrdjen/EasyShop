package fashion.store.EasyShop.mapper;

import fashion.store.EasyShop.dto.InstallmentDto;
import fashion.store.EasyShop.entity.Installment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InstallmentMapper {

    @Autowired
    private PurchaseContractMapper mapper;

    public Installment mapCreateDtoToEntity(InstallmentDto dto) {
        return new Installment(
                mapper.mapCreateInstallmentDtoToEntity(dto.getPurchaseContractDto()),
                dto.getInstallmentOrdinal(),
                dto.getInstallmentAmount(),
                dto.getMaturityDate()
        );
    }

    public Installment mapEditDtoToEntity(InstallmentDto dto) {
        return new Installment(
                dto.getId(),
                mapper.mapCreateInstallmentDtoToEntity(dto.getPurchaseContractDto()),
                dto.getInstallmentOrdinal(),
                dto.getInstallmentAmount(),
                dto.getMaturityDate(),
                dto.getPaidAmount(),
                dto.getPaymentDate(),
                dto.getPaymentMethod()
        );
    }

    public InstallmentDto mapGetEntityToDto(Installment installment) {
        return new InstallmentDto(
                installment.getId(),
                mapper.mapGetEntityToDto(installment.getPurchaseContract()),
                installment.getInstallmentOrdinal(),
                installment.getInstallmentAmount(),
                installment.getMaturityDate(),
                installment.getPaidAmount(),
                installment.getPaymentDate(),
                installment.getPaymentMethod());
    }
}
