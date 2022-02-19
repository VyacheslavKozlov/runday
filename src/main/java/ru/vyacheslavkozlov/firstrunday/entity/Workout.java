package ru.vyacheslavkozlov.firstrunday.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@Entity
@Table(name = "workouts")
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "day_run")
    private Date date;
    @Column(name = "distance_in_metres", nullable = false)
    private int distance;
    @Column(name = "time_in_seconds", nullable = false)
    private int time;
    @Column(name = "health", columnDefinition = "integer default 3")
    private int health;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "sneakers_id")
    private Sneakers sneakers;

    @Override
    public String toString() {
        return "Workout{" +
                "id=" + id +
                ", date=" + date +
                ", distance=" + distance +
                ", time=" + time +
                ", health=" + health +
                '}';
    }
}
