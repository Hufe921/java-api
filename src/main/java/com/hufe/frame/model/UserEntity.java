package com.hufe.frame.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;

import java.util.List;

@Node(labels = {"JA_USER"})
@Data
@Builder
public class UserEntity {

  @Id
  @GeneratedValue
  private Long id;

  @Property(name = "name")
  private String name;

  @Property(name = "gender")
  private Integer gender;

  @Relationship(type = "RELATION_IN", direction = Relationship.Direction.INCOMING)
  private List<UserEntity> stakeholders;

}
