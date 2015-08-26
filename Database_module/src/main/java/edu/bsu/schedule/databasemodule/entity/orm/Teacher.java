package edu.bsu.schedule.databasemodule.entity.orm;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Teachers")
public class Teacher implements Serializable{
    private static final long serialVersionUID = 959328312354118305L;

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "teacher_seq")
    @SequenceGenerator(name = "teacher_seq", sequenceName = "seq_teachers_id")
    @Column(name="TEACHER_ID")
    private Long teacherId;


    @Column(name="NAME")
    @NotBlank
    @Length(max = 40)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private List<Subject> subjects;

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
