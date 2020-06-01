package com.salon.entity;

import java.util.List;
import java.util.Set;
import javax.persistence.*;

import lombok.*;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "salons")
public class Salon {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "salon_id", unique = true, nullable = false)
  private Integer id;

  @Column(name = "address")
  @Length(min = 5, max = 40)
  private String address;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private Set<User> masters;
}
