package com.jwt.secqurity.relationExample.controller;


import com.jwt.secqurity.relationExample.entity.Department;
import com.jwt.secqurity.relationExample.entity.Employee;
import com.jwt.secqurity.relationExample.entity.TestEntity4;
import com.jwt.secqurity.relationExample.repository.TestRepo;
import com.jwt.secqurity.relationExample.repository.TestRepo2;
import com.jwt.secqurity.relationExample.repository.TestRepo3;
import com.jwt.secqurity.relationExample.repository.TestRepo4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/testController")
public class TestController22 {
    @Autowired
    TestRepo testRepo;
    @Autowired
    TestRepo2 testRepo2;
    @Autowired
    TestRepo3 testRepo3;

    @Autowired
    TestRepo4 testRepo4;
    @PostMapping("/emp")
    public String create(@RequestBody Employee eMPLOYEE) {
        testRepo.save(eMPLOYEE);
        return "";
    }

    @GetMapping("/emp/{id}")
    public Employee get(@PathVariable Long id) {
        Optional<Employee> emp = testRepo.findById(id);
        return emp.get();
    }

    @PostMapping("/dep")
    public String createDep(@RequestBody Department department) {
        testRepo2.save(department);
        return "Success";
    }

    @PostMapping("/test4")
    public String createTest4(@RequestBody TestEntity4 testEntity4) {
        testRepo4.save(testEntity4);
        return "Success";
    }

    @GetMapping("/dep/{id}")
    public Department getDep(@PathVariable Long id) {
        Optional<Department> dep = testRepo2.findById(id);
        List<Employee> emps = testRepo.findByDepartmentId(id);
        for (Employee e:emps
             ) {
            e.setDepartment(null);
        }
        dep.get().setEmployees(emps);
        return dep.get();
    }
//
//    @GetMapping(UrlConstants.KanbanSlip.GET_ALL)
//    public Response getAll() {
//        return kanbanSlipService.getAll();
//    }
//
//    @GetMapping(UrlConstants.KanbanSlip.GET)
//    public Response get(@PathVariable(value = "id") Long id) {
//        return kanbanSlipService.get(id);
//    }
//
//
//    @DeleteMapping(UrlConstants.KanbanSlip.GET)
//    public Response delete(@PathVariable(value = "id") Long id) {
//        return kanbanSlipService.delete(id);
//    }
//
//    @PutMapping(UrlConstants.KanbanSlip.GET)
//    public Response update(@PathVariable(value = "id") Long id,
//                           @RequestBody KanbanSlipDto kanbanSlipDto) {
//        return kanbanSlipService.update(id, kanbanSlipDto);
//    }

}
