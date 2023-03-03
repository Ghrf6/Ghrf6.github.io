package com.netcetera.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Person model.
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Person {

  private Long id;
  private String name;
  private String surname;
  private String city;
  private String nickname;
  private String gender;
  private String address;
  private Integer postalCode;
  private String nationality;
  private String birthplace;
  private LocalDate date;
  private Hobby hobby=new Hobby();
  private Person father;
  private Person mother;
  private Long motherId;
  private Long fatherId;
  private boolean isParent;

}
