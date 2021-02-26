package com.example.demo.controller;

import com.example.demo.dao.JournalJdbc;
import com.example.demo.dao.StudJdbc;
import com.example.demo.model.Journal;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JournalController {

    private final JournalJdbc jourJdbc;
    public JournalController(JournalJdbc jourJdbc){
        this.jourJdbc = jourJdbc;
    }

    @GetMapping("/journal/")
    public List<Journal> journals(){
        List<Journal> journal = jourJdbc.getJournal();
        return  journal;
    }

    @GetMapping("/journal/student/{id_s}")
    public List<Journal> journalByStud(@PathVariable int id_s){
        List<Journal> journal = jourJdbc.getJournalByStud(id_s);
        return  journal;
    }

    @GetMapping("/journal/group/{id_s_gr}")
    public List<Journal> journalByGr(@PathVariable int id_s_gr){
        List<Journal> journal = jourJdbc.getJournalByGroup( id_s_gr);
        return  journal;
    }

    @PutMapping("journal/update/{id_j}")
    public int updateJourn(@PathVariable int id_j, @RequestBody RequestJ requestJ){
        int journal = jourJdbc.updJournal(id_j, requestJ.mark);
        return journal;
    }
}

class RequestJ{
    public int mark;
}
