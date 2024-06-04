package org.example.ecommerce.register;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
public class UserCreateRequestDto {
    @NotBlank(message="NAME_IS_MANDATORY")
    private String name;
    @NotBlank(message="PASSWORD_IS_MANDATORY")
    private String password;
    @Email(message = "NOT_VALID_EMAIL")
    private String email;

    public User toEntity(){
        return User.builder()
                .user_name(name)
                .email(email)
                .password(password).build();}}