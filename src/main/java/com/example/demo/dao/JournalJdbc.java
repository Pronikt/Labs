package com.example.demo.dao;
import com.example.demo.model.Group;
import com.example.demo.model.Journal;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JournalJdbc {

    private final JdbcTemplate jdbcTemplate;
    public JournalJdbc(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    public Journal mapJour(ResultSet rs, int i) throws SQLException {
        Journal jour = new Journal(
                rs.getInt("id_j"),
                rs.getInt("student_id"),
                rs.getInt("study_plan_id"),
                rs.getInt("in_time"),
                rs.getInt("count"),
                rs.getInt("mark_id")
        );
        return jour;
    }

    public List<Journal> getJournal(){
        return jdbcTemplate.query("SELECT * FROM journal", this::mapJour);
    }

    public List<Journal> getJournalByStud(int student_id){
        return jdbcTemplate.query("SELECT * FROM journal WHERE student_id = ?", this::mapJour, student_id);
    }

    public List<Journal> getJournalByGroup(int study_group_id){
        return jdbcTemplate.query( "select * from journal j left join student s on s.id_j = j.student_id where s.study_group_id = ?", this::mapJour, study_group_id);
    }

    public int updJournal(int id, int mark_id){
        return jdbcTemplate.update("UPDATE  journal SET  mark_id = ?   WHERE id_j = ?", mark_id, id);
    }

}
