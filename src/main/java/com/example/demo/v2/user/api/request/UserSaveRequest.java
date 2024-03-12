package com.example.demo.v2.user.api.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class UserSaveRequest {

    @NotBlank
    @Length(min = 1, max = 20)
    private String name;

    @Range(min = 1, max = 150)
    private int age;
}
