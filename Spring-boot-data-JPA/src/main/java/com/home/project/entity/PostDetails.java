package com.home.project.entity;


import com.home.project.urlConstants.BaseModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class PostDetails extends BaseModel {

    private String postDetailName;

    @ManyToOne
    @JoinColumn(name="post_detail_id")
    private PostEntity postEntity;
}
