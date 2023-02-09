package com.home.project.entity;


import com.home.project.urlConstants.BaseModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class PostEntity extends BaseModel {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
    private String title;
    private String body;
    private Integer status;

    private String user;


    @OneToOne(mappedBy = "postEntity")
    private PostCategory postCategory;

    @OneToMany(mappedBy = "postEntity")
    private List<PostDetails> postDetails;


    @ManyToMany(mappedBy = "postEntities")
    private List<ManyPostEntity> manyPostEntities;

}
