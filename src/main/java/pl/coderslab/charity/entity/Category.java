package pl.coderslab.charity.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cat_seq")
    @SequenceGenerator(name = "cat_seq", sequenceName = "cat_seq", initialValue = 100, allocationSize = 1)
    private Long id;
    private String name;
}