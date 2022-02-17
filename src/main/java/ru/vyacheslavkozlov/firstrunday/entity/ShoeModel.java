package ru.vyacheslavkozlov.firstrunday.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "models")
public class ShoeModel {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name should not be empty!")
    @Size(min = 2, max = 20, message = "Name should ne between 2 and 30 characters!")
    @Column(name = "name", nullable = false)
    private String name;

    @NotEmpty(message = "Version should not be empty!")
    @Size(min = 2, max = 20, message = "Version should ne between 2 and 30 characters!")
    @Column(name = "version", nullable = false)
    private String version;

    @Min(value = 1, message = "Limitation should be > 1")
    @Column(name = "limitation", nullable = false)
    private int limitation;

    @NotEmpty(message = "Description should not be empty!")
    @Size(min = 2, max = 5000, message = "Limitation should ne between 2 and 5000 characters!")
    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "producer_id", nullable = false)
    private Producer producer;

    @OneToMany(mappedBy = "shoeModel", cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private List<Sneakers> sneakers;

}
