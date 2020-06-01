package com.salon.entity;

import java.util.Date;
import javax.persistence.*;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "reservations")
public class Reservation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "reservation_id", unique = true, nullable = false)
  private Integer id;

  @Column(name = "start_hour")
  private Date start;

  @Column(name = "end_hour")
  private Date end;

  @OneToOne private Procedure procedure;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private User beautyMaster;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private User client;
}
