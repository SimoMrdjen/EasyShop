package fashion.store.EasyShop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
import java.util.Date;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "\"installment\"")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Installment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="purchaseContract_id", referencedColumnName = "id")
    private PurchaseContract purchaseContract;

    @Enumerated(EnumType.STRING)
    @Column(name = "installment_ordinal", nullable = false)
    private InstallmentOrdinal installmentOrdinal;

    @Column(name = "installment_amount", nullable = false)
    private Double installmentAmount;

    @Column(name = "maturity_date", nullable = false)
    private Date maturityDate;

    @Column(name = "paid_amount", nullable = false)
    private Double paidAmount;

    @Column(name = "payment_date")
    private Date paymentDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method")
    private PaymentMethod paymentMethod;

}
