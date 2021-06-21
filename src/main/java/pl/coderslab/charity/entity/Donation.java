package pl.coderslab.charity.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "donation")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Integer quantity;

    @ManyToMany
    @JoinTable(name = "donation_category",
    inverseJoinColumns = @JoinColumn(name = "donation_id"),
    joinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;

    @ManyToOne
    @JoinColumn(name = "institution_id")
    private Institution institution;

    private String street;
    private String city;
    @Column(name = "zip_code")
    private String zipCode;
    @Column(name = "pickup_date")
    private LocalDate pickUpDate;
    @Column(name = "pickup_time")
    private LocalTime pickUpTime;
    @Column(name = "pickup_comment")
    private String pickUpComment;
}
