package ru.vyacheslavkozlov.firstrunday.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "producers")
public class Producer implements Serializable {
//    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @NotEmpty(message = "Name should not be empty!")
//    @Size(min = 2, max = 20, message = "Name should ne between 2 and 30 characters!")
//    @Column(name = "name", nullable = false, unique = true)
    private String name;


//    @JsonIgnore
    @JsonBackReference
    @OneToMany(mappedBy = "producer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ShoeModel> shoeModels;

}
