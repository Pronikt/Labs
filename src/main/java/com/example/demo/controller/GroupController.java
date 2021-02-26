package com.example.demo.controller;
import com.example.demo.dao.GroupJdbc;
import com.example.demo.dao.StudJdbc;
import com.example.demo.model.Group;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class GroupController {
    private final GroupJdbc groupJdbc;
    public GroupController(GroupJdbc groupJdbc){
        this.groupJdbc = groupJdbc;
    }

    //Просмотр группы
    @GetMapping("/group/{id}")
    public Group group(@PathVariable int id_s_gr){
        Group group =groupJdbc.getGroup(id_s_gr);
        return  group;
    }

    //Просмотр всех групп
    @GetMapping("/group")
    public List<Group> groups(){
        List<Group> group = groupJdbc.getAllGroup();
        return  group;
    }

    //Создание группы
    @PostMapping("/study_group/insert/")
    public int insGroup(@RequestBody RequestG request){
        int group = groupJdbc.insGroup(request.id_s_gr, request.name);
        return  group;
    }

    //Обновление группы с id
    @PutMapping("/group/update/{id_s_gr}")
    public int updGroupById(@PathVariable int id_s_gr, @RequestBody RequestG request) {
        int group = groupJdbc.updGroup(id_s_gr,request.name);
        return group;
    }

    //Удалить группу
    @DeleteMapping("/group/delete/{id_s_gr}")
    public int delGroupById(@PathVariable int id_s_gr){
        int group = groupJdbc.delGroup(id_s_gr);
        return group;
    }
}

class RequestG{
    public int id_s_gr;
    public String name;
}
