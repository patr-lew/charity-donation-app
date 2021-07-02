package pl.coderslab.charity.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Donation extends CharityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "don_seq")
    @SequenceGenerator(name = "don_seq", sequenceName = "don_seq", initialValue = 100, allocationSize = 1)
    private Long id;

    @Positive(message = "{validation.donation.quantity.positive}")
    @NotNull(message = "{validation.donation.quantity.not-null}")
    private Integer quantity;

    @ManyToMany
    @Size(min = 1, message = "{validation.donation.categories.empty}")
    @JoinTable(name = "donation_category",
            inverseJoinColumns = @JoinColumn(name = "donation_id"),
            joinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    @NotNull(message = "{validation.donation.institution.not-null}")
    @ManyToOne
    @JoinColumn(name = "institution_id")
    private Institution institution;

    @NotBlank(message = "{validation.donation.street.not-null}")
    @NotNull(message = "{validation.donation.street.not-null}")
    private String street;

    @NotNull(message = "{validation.donation.city.not-null}")
    @NotBlank(message = "{validation.donation.city.not-null}")
    private String city;

    @NotNull(message = "{validation.donation.zip-code.not-null}")
    @NotBlank(message = "{validation.donation.zip-code.not-null}")
    @Column(name = "zip_code")
    private String zipCode;

    @NotNull(message = "{validation.donation.phone-number.not-null}")
    @Pattern(regexp = "^\\+?[0-9 ]+$", message = "{validation.donation.phone-number.wrong-pattern}")
    @Column(name = "phone_number")
    private String phoneNumber;

    @NotNull(message = "{validation.donation.pickup-date.not-null}")
    @Future(message = "{validation.donation.pickup-date.future}")
    @Column(name = "pickup_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;


    @NotNull(message = "{validation.donation.pickup-time.not-null}")
    @Column(name = "pickup_time")
    private LocalTime pickUpTime;

    @Column(name = "pickup_comment")
    private String pickUpComment;

    public boolean containsCategoryId(int id) {
        for (Category category : categories) {
            if (category.getId() == id) {
                return true;
            }
        }

        return false;
    }
}
