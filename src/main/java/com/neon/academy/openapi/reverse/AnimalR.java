package com.neon.academy.openapi.reverse;

import java.sql.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AnimalR {

  private String id;

  private String name;

  private Date birthDay;

}
