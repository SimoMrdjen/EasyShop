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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "\"rate\"")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private Contract contract;

    @Enumerated(EnumType.STRING)
    @Column(name = "rate_ordinal", nullable = false)
    private RateOrdinal rateOrdinal;

    @Column(name = "rate_amount", nullable = false)
    private Double rateAmount;

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
