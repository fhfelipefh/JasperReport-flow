package com.fhfelipe.jasperreportflow.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "user")
public class ReportUser {

  @Id
  private int userId;

  @NotBlank
  private String firstName;

  @NotBlank
  private String LastName;

  @NotBlank
  private String phoneNumber;

  @NotBlank
  private String emailAddress;

  @NotBlank
  private String extra;


}
