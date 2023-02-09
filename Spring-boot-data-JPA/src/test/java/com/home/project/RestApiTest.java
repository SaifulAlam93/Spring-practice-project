//package com.home.project;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//
//import com.home.project.entity.AssignedTask;
//import com.home.project.entity.Player;
//import com.home.project.entity.Schedule;
//import com.home.project.entity.Task;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class RestApiTest extends ProjectApplicationTests{
//
//
//    @Override
//    @Before
//    public void setUp() {
//        super.setUp();
//    }
//    @Test
//    public void getAssignedTaskList() throws Exception {
//        String uri = "/api/v1/assignedTask";
//        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
//                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
//
//        int status = mvcResult.getResponse().getStatus();
//        assertEquals(200, status);
////        String content = mvcResult.getResponse().getContentAsString();
////        AssignedTask[] assignedTask = super.mapFromJson(content, AssignedTask[].class);
////        assertTrue(assignedTask.length > 0);
//    }
//
//
//    @Test
//    public void getScheduleWiseTaskDetails() throws Exception {
//        String uri = "/api/v1/assignedTask/getScheduleWiseTaskDetails";
//        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
//                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
//
//        int status = mvcResult.getResponse().getStatus();
//        assertEquals(200, status);
//    }
//
//    @Test
//    public void createPlayers() throws Exception {
//        String uri = "/api/v1/players";
//        Player player = new Player();
//        player.setUserName("test");
//        player.setEmail("test@test.com");
//        player.setFullName("test test com");
//        player.setAddress("test address");
//        player.setMobile("01712922546");
//        String inputJson = super.mapToJson(player);
//        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
//                .content(inputJson)).andReturn();
//
//        int status = mvcResult.getResponse().getStatus();
//        assertEquals(200, status);
////        String content = mvcResult.getResponse().getContentAsString();
////        assertEquals(content, "Product is created successfully");
//    }
//
//    @Test
//    public void createTask() throws Exception {
//        String uri = "/api/v1/tasks";
//        Task task = new Task();
//        task.setId(1L);
//        task.setTaskTitle("Test task");
//        String inputJson = super.mapToJson(task);
//        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
//                .content(inputJson)).andReturn();
//
//        int status = mvcResult.getResponse().getStatus();
//        assertEquals(200, status);
//
//    }
//
//
//    @Test
//    public void createSchedule() throws Exception {
//        String uri = "/api/v1/schedule";
//
//        Schedule schedule = new Schedule();
//        schedule.setId(1L);
//        schedule.setScheduleName("Test schedule");
////        schedule.setScheduleStartTime(LocalDateTime.of(2022, 8, 30, 10, 34) );
////        schedule.setScheduleEndTime(LocalDateTime.of(2022, 8, 30, 12, 34) );
//        String inputJson = super.mapToJson(schedule);
//        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
//                .content(inputJson)).andReturn();
//
//        int status = mvcResult.getResponse().getStatus();
//        assertEquals(200, status);
//
//    }
//
//    @Test
//    public void assignedTask() throws Exception {
//        String uri = "/api/v1/assignedTask";
//
//        AssignedTask assignedTask = new AssignedTask();
//        assignedTask.setId(1L);
//        assignedTask.setTask(new Task(5L));
//        assignedTask.setSchedule(new Schedule(5L));
//        List<Player> playerList = new ArrayList<>();
//        assignedTask.setPlayerList(playerList);
//        String inputJson = super.mapToJson(assignedTask);
//        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
//                .content(inputJson)).andReturn();
//
//        int status = mvcResult.getResponse().getStatus();
//        assertEquals(200, status);
//
//    }
//
//}
