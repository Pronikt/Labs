package com.example.demo.controller;

import com.example.demo.dao.StudJdbc;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudController {

    private final StudJdbc studJdbc;
    public StudController(StudJdbc studJdbc){
        this.studJdbc = studJdbc;
    }

    //Просмотр студента по id
    @GetMapping("/student/{id}")
    public Student students(@PathVariable int id){
        Student student = studJdbc.getStud(id);
        return  student;
    }

    //Просмотр всех студентов
    @GetMapping("/student/")
    public List<Student> students(){
        List<Student> student = studJdbc.getallStud();
        return  student;
    }

    //Просмотр студентов в группе
    @GetMapping("/student/group/{study_group_id}")
    public Student studByGroup(@PathVariable int study_group_id){
        Student student = studJdbc.getStudByGroup(study_group_id);
        return  student;
    }

    //Создание студента
    @PostMapping("/student/insert/")
    public int studIns(@RequestBody Request request){
        int student = studJdbc.insStud(request.id_s, request.surname, request.name, request.second_name, request.study_group_id);
        return  student;
    }

    //Обновление студента с id
    @PutMapping("/student/update/{id_s}")
    public int updStudById(@PathVariable int id_s, @RequestBody Request request) {
        int student = studJdbc.updateStud(id_s, request.surname, request.name, request.second_name, request.study_group_id);
        return student;
    }
    @DeleteMapping("/student/delete/{id_s}")
    public int delStudById(@PathVariable int id_s){
        int student = studJdbc.delStud(id_s);
        return student;
    }
}

class Request{
    public int id_s;
    public String name;
    public String surname;
    public String second_name;
    public int study_group_id;
}
