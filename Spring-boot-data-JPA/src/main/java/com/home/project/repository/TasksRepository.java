//package com.home.project.repository;
//
//import com.home.project.entity.Task;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//@Repository
//public interface TasksRepository extends JpaRepository<Task, Long>{
//
//
////	@Query(value = "SELECT * FROM core_approval_matrix am\n" +
////			"JOIN core_approving_process ap ON am.app_process_id=ap.id\n" +
////			"WHERE am.active=true and ap.name= :status ;", nativeQuery = true)
////	public List<Task> getTask(@Param("status") String status);
//}
