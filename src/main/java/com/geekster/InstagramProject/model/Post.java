package com.geekster.InstagramProject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    @Column(nullable = false)
    private Timestamp createdDate;

    @Column(nullable = false)
    private Timestamp updatedDate;

    @Column(nullable = false)
    @NotEmpty
    private String postData;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false , name = "fk_user_ID")
    private User user;

}
