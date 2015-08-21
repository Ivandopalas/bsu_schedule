package edu.bsu.schedule.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;



/*create table Groups (
        GROUP_ID number(20) NOT NULL,
        GROUP_INDEX nvarchar2(10) NOT NULL,
        GROUP_NAME nvarchar2(40),
        PRIMARY KEY (GROUP_ID)
        );*/

@Entity
@Table(name = "Groups")
public class Group implements Serializable{
    private static final long serialVersionUID = 159328312381218305L;

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "group_seq")
    @SequenceGenerator(name = "group_seq", sequenceName = "seq_groups_id")
    @Column(name="GROUP_ID")
    private Long groupId;

    @Column(name="GROUP_INDEX")
    @NotBlank
    @Length(max = 10)
    private String groupIndex;

    @Column(name="GROUP_NAME")
    @Length(max = 40)
    private String groupName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    private List<Schedule> schedules;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupIndex() {
        return groupIndex;
    }

    public void setGroupIndex(String groupIndex) {
        this.groupIndex = groupIndex;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }
}
