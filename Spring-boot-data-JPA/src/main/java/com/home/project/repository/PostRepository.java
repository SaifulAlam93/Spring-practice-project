package com.home.project.repository;


import com.home.project.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {

    @Query(value = "SELECT * FROM post_entity t WHERE t.title =:title5", nativeQuery = true)
    List<PostEntity> findPostEntitiesByTitle(@Param("title5") String title);


    @Query(value = "SELECT * FROM post_entity t " +
            " WHERE (t.user_name =:title1 or t.phone =:title1) and t.password = :password_ limit 1", nativeQuery = true)
    PostEntity login(@Param("title1") String username, @Param("password_") String password);



    @Query(value = " SELECT t.body FROM post_entity t WHERE t.title =:title5", nativeQuery = true)
    List<String> findPostEntityBodyByTitle(@Param("title5") String title);



    @Query(value = " SELECT * FROM post_entity t WHERE t.status =:statusParam", nativeQuery = true)
    List<PostEntity> getByStatus(@Param("statusParam") Integer title);


    List<PostEntity> findAllByStatus(String status);


    List<PostEntity> findAllByTitle(String title);

//    @Query(value = " Select a.name, b.name, c.address from tableOne a\n" +
//            "left join TableB b on b.id = a.b_id " +
//            "left join TableC c on c.id = b.c_id ", nativeQuery = true)
//    public List<Object[]> getCivilOfficerAndStaffDataByYear(@Param("year") String year);

}









