package com.salon.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "comments")
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "comment_id", unique = true, nullable = false)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "master_id")
  private User master;

  @ManyToOne
  @JoinColumn(name = "commentator_id")
  private User commentator;

  @Column(name = "comment_text", columnDefinition = "TEXT")
  @Length(min = 5, max = 1000)
  private String commentText;

  @Column(name = "service_mark")
  @Min(0)
  @Max(5)
  private int serviceMark;

  @Column(name = "comment_date")
  private Date date;
}
