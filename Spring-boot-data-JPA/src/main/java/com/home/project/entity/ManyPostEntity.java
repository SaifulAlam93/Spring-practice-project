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
public class ManyPostEntity extends BaseModel {

    private String manyPostEntityName;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "author_id",
                    referencedColumnName = "id"))
    private List<PostEntity> postEntities;

}
