package pl.coderslab.charity.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "institution")
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inst_seq")
    @SequenceGenerator(name = "inst_seq", sequenceName = "inst_seq", initialValue = 100)
    private Long id;
    private String name;
    private String description;
}
