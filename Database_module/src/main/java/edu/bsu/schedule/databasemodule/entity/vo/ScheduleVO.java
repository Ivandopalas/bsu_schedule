package edu.bsu.schedule.databasemodule.entity.vo;

import java.io.Serializable;
import java.util.List;

public class ScheduleVO implements Serializable{
    private static final long serialVersionUID = 259328312354228305L;


    private Long weekday;
    private List<SubjectVO> subjectVO;

    public Long getWeekday() {
        return weekday;
    }

    public void setWeekday(Long weekday) {
        this.weekday = weekday;
    }

    public List<SubjectVO> getSubjectVO() {
        return subjectVO;
    }

    public void setSubjectVO(List<SubjectVO> subjectVO) {
        this.subjectVO = subjectVO;
    }
}
