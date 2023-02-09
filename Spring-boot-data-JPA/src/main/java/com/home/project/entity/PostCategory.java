package com.home.project.entity;


import com.home.project.urlConstants.BaseModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class PostCategory extends BaseModel {


    private String postCategoryName;

    @OneToOne
    @JoinColumn(name = "post_entity_id")
    private PostEntity postEntity;

}
