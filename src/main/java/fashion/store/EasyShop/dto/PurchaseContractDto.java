package fashion.store.EasyShop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Data
public class PurchaseContractDto {

    private Long id;
    @NotNull
    private CustomerDto customerDto;
    @NotNull
    private Double contractAmount;
    @NotNull
    private Double participation;
    @NotNull
    private LocalDate contractDate;
    private List<InstallmentDto> installments;

    public PurchaseContractDto(Long id, CustomerDto customer, Double contractAmount, Double participation, LocalDate contractDate) {
        this.id = id;
        this.customerDto = customer;
        this.contractAmount = contractAmount;
        this.participation = participation;
        this.contractDate = contractDate;
    }
}
