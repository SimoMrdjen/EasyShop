package fashion.store.EasyShop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;


@Entity
@Table(name = "\"purchase_contract\"")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class PurchaseContract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="customer_id",referencedColumnName = "id")
    private Customer customer;

    @Column(name = "contract_amount", nullable = false)
    private Double contractAmount;

    @Column(name = "participation", nullable = false)
    private Double participation;

    @Column(name = "contract_date", nullable = false)
    private Date contractDate;

    @JsonIgnore
    @OneToMany(mappedBy="purchaseContract", cascade= ALL)
    private List<Installment> installments;
}
