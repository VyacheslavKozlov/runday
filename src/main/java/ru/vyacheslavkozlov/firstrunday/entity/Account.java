package ru.vyacheslavkozlov.firstrunday.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "account")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String password;

    @CollectionTable(name = "account_role", joinColumns = @JoinColumn(name = "account_id"))
    @Enumerated(EnumType.STRING)
    private Role role;


}
