package fashion.store.EasyShop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "\"installment\"")
@Data
@AllArgsConstructor
@NoArgsConstructor
//@ToString
//@EqualsAndHashCode
//@RequiredArgsConstructor
public class Installment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY, cascade = MERGE)
    @JoinColumn(name="purchase_contract_id", referencedColumnName = "id")
    private PurchaseContract purchaseContract;

    @Enumerated(EnumType.STRING)
    @Column(name = "installment_ordinal", nullable = false)
    private InstallmentOrdinal installmentOrdinal;

    @Column(name = "installment_amount", nullable = false)
    private Double installmentAmount;

    @Column(name = "maturity_date", nullable = false)
    private LocalDate maturityDate;

    @Column(name = "paid_amount")
    private Double paidAmount;

    @Column(name = "payment_date")
    private LocalDate paymentDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method")
    private PaymentMethod paymentMethod;

    public Installment(PurchaseContract purchaseContract,
                       InstallmentOrdinal installmentOrdinal,
                       Double installmentAmount,
                       LocalDate maturityDate,
                       Double paidAmount,
                       LocalDate paymentDate,
                       PaymentMethod paymentMethod) {
        this.purchaseContract = purchaseContract;
        this.installmentOrdinal = installmentOrdinal;
        this.installmentAmount = installmentAmount;
        this.maturityDate = maturityDate;
        this.paidAmount = paidAmount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
    }

    public Installment(PurchaseContract purchaseContract,
                       InstallmentOrdinal installmentOrdinal,
                       Double installmentAmount,
                       LocalDate maturityDate
                     ) {
        this.purchaseContract = purchaseContract;
        this.installmentOrdinal = installmentOrdinal;
        this.installmentAmount = installmentAmount;
        this.maturityDate = maturityDate;
    }
}
