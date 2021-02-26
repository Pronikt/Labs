package com.example.demo.controller;
import com.example.demo.dao.MarkJdbc;
import com.example.demo.model.Mark;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarkController
{
    private final MarkJdbc markJdbc;

    public MarkController(MarkJdbc markJdbc)
    {
        this.markJdbc = markJdbc;
    }
    @GetMapping("/mark/{id_m}")
    public  Mark getMark(@PathVariable int id_m)
    {
        Mark mark = markJdbc.get(id_m);
        return mark;
    }
}
