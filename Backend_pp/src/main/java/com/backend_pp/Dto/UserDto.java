package com.backend_pp.Dto;

import com.backend_pp.utils.constants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Long id;
    @NotBlank(message = constants.USER_BLANK)
    private String name;
    @Size(min = 6,max=10,message = constants.PASSWORD_BLANK)
    private String password;

    @Pattern(regexp = constants.EMAIL_PATTERN, message = constants.EMAIL_INVALID)
    private String email;

}
