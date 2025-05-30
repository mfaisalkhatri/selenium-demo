package io.github.mfaisalkhatri.seleniumgridjenkins.testdata;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistrationData {

    private String email;
    private String password;
    private String securityAnswer;
    private String securityQuestion;
}
