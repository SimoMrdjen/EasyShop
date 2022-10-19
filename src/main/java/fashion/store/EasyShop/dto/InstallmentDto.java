package fashion.store.EasyShop.dto;

import fashion.store.EasyShop.entity.InstallmentOrdinal;
import fashion.store.EasyShop.entity.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Data
public class InstallmentDto {

    private Long id;

    @NotNull
    private PurchaseContractDto purchaseContractDto;

    @NotNull
    private InstallmentOrdinal installmentOrdinal;

    @NotNull
    private Double installmentAmount;

    @NotNull
    private LocalDate maturityDate;

    private Double paidAmount;

    private LocalDate paymentDate;

    private PaymentMethod paymentMethod;
}
