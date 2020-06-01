package com.salon.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "procedures")
public class Procedure {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "procedure_id", unique = true, nullable = false)
  private Integer id;

  @Column(name = "name")
  @Length(min = 3, max = 35)
  private String name;

  @Column(name = "description", columnDefinition = "TEXT")
  @Length(min = 30, max = 1000)
  private String description;

  @Column(name = "duration_hours")
  private int durationHours;
}
