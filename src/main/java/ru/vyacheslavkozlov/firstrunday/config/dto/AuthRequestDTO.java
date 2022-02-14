package ru.vyacheslavkozlov.firstrunday.config.dto;

import lombok.Data;

@Data
public class AuthRequestDTO {
    private String email;
    private String password;
}
