package pl.coderslab.charity.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Getter
@Setter
public abstract class CharityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cat_seq")
    @SequenceGenerator(name = "cat_seq", sequenceName = "cat_seq", initialValue = 100, allocationSize = 1)
    private Long id;
}
