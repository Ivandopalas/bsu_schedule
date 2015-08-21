package edu.bsu.schedule.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.Valid;
import java.io.Serializable;

@Entity
@Table(name = "Subjects")
public class Subject implements Serializable{
    private static final long serialVersionUID = 758395312354118305L;

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "subject_seq")
    @SequenceGenerator(name = "subject_seq", sequenceName = "seq_subjects_id")
    @Column(name="SUBJECT_ID")
    private Long subjectId;

    @Column(name="NAME")
    @NotBlank
    @Length(max=100)
    private String subjectName;

    @ManyToOne
    @JoinColumn(name = "CABINET_ID", nullable = false)
    @Valid
    private Cabinet cabinet;

    @ManyToOne
    @JoinColumn(name="TEACHER_ID",nullable = false)
    @Valid
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name="SCHEDULE_ID",nullable = false)
    @Valid
    private Schedule schedule;

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Cabinet getCabinet() {
        return cabinet;
    }

    public void setCabinet(Cabinet cabinet) {
        this.cabinet = cabinet;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
