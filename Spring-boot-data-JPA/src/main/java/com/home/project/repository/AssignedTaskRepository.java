//package com.home.project.repository;
//
//
//import com.home.project.entity.AssignedTask;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface AssignedTaskRepository extends JpaRepository<AssignedTask, Long> {
//
//    @Query(value = " Select assigned_task.* from assigned_task " +
//            " inner join task on assigned_task.task_id = task.id " +
//            " where task.active = 1" +
//            " and assigned_task.active = 1 " +
//            " and assigned_task.schedule_id is not null", nativeQuery = true)
//    List<AssignedTask> findAllByActiveTrue();
//
//    List<AssignedTask> findAllByActiveTrueAndScheduleId(Long id);
//}
