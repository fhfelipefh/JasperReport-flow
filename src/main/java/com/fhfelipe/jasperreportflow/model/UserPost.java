package com.fhfelipe.jasperreportflow.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
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
@Entity(name = "user_post")
public class UserPost {

  @Id
  private int id;

  private int userId;

  @NotBlank
  private String title;

  @NotBlank
  private String body;


}
