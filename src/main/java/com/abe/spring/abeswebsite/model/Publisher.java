package com.abe.spring.abeswebsite.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Publisher{

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  String name;
  String address;

  public Publisher(String name, String address) {
    this.name = name;
    this.address = address;
  }
}
