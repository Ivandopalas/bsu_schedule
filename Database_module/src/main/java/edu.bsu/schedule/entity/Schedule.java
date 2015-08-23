package edu.bsu.schedule.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Schedules")
public class Schedule implements Serializable{
    private static final long serialVersionUID = 532328312381218412L;

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "schedule_seq")
    @SequenceGenerator(name = "schedule_seq", sequenceName = "seq_schedules_id")
    @Column(name="SCHEDULE_ID")
    private Long scheduleId;

    /**
     * Weekday index. From 1 to 7. Start with sunday (1 - sunday, 2 - monday ...)
     */
    @Column(name="WEEKDAY")
    @NotBlank
    @Min(1)
    @Max(7)
    private Long weekday;

    @ManyToOne
    @JoinColumn(name = "COURSE_ID", nullable = false)
    @Valid
    private Course course;

    @ManyToOne
    @JoinColumn(name = "GROUP_ID", nullable = false)
    @Valid
    private Group group;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "schedule")
    @OrderBy(value = "subjectTime ASC")
    private List<Subject> subjects;

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Long getWeekday() {
        return weekday;
    }

    public void setWeekday(Long weekday) {
        this.weekday = weekday;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
