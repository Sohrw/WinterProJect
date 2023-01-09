package jpabook.jpashop.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter @Setter
@Table(name = "join_user")
public class Join {
    @Id @GeneratedValue
    @Column(name = "join_id")
    private Long id;

    @NotEmpty
    private String user_name;

    @NotEmpty
    private String pw;
}
