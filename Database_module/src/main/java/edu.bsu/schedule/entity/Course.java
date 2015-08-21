package edu.bsu.schedule.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Courses")
public class Course implements Serializable{
    private static final long serialVersionUID = 459328310181218305L;

    @Id
    @Column(name="COURSE_ID")
    private Long courseId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private List<Schedule> schedules;

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }
}
