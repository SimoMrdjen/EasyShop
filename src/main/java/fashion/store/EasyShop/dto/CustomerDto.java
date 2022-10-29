package fashion.store.EasyShop.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Data
public class CustomerDto {
    private Long id;
    @NotBlank
    private String lastName;
    private String firstName;
    @Length(max = 13, min = 13)
    private String jmbg;
    private String address;
    private String brLK;
    private String pu;
    @Email
    private String email;
    private String phoneNumber;

    public CustomerDto(String lastName,
                       String firstName,
                       String jmbg,
                       String address,
                       String brLK,
                       String pu,
                       String email,
                       String phoneNumber)
    {
        this.lastName = lastName;
        this.firstName = firstName;
        this.jmbg = jmbg;
        this.address = address;
        this.brLK = brLK;
        this.pu = pu;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
