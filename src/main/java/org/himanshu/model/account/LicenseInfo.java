package org.himanshu.model.account;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class LicenseInfo {
    private String licenseNumber;
    private LocalDateTime issueDate;
    private LocalDateTime expiryDate;
    private String issuedAtPlace;
    private String issuedAtState;
    private String issuedInCountry;
    private LicenseType licenseType;

}
