package ru.vyacheslavkozlov.firstrunday.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
//@ToString
@EqualsAndHashCode
@Entity
@Table(name = "sneakers")
public class Sneakers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Min(value = 1, message = "Limitation should be >= 1")
    @Column(name = "pair_number")
    private int pair_number;

    @Column(name = "enable")
    private boolean enable;

    @Column(name = "note")
    private String note;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "model_id")
    private ShoeModel shoeModel;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(mappedBy = "sneakers", cascade = CascadeType.ALL)
    private List<Workout> workouts;

    @Override
    public String toString() {
        return "Sneakers{" +
                "id=" + id +
                ", pair_number=" + pair_number +
                ", enable=" + enable +
                ", note='" + note + '\'' +
                '}';
    }
}


