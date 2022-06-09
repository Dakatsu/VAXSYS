package com.vaxsys.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="vaccination")
public class Vaccination {
    @Id
    private Integer id;

}
