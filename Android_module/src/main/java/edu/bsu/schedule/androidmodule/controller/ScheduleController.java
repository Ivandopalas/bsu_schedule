package edu.bsu.schedule.androidmodule.controller;

import edu.bsu.schedule.androidmodule.entity.WeekScheduleWrapper;
import edu.bsu.schedule.databasemodule.entity.vo.ScheduleVO;
import edu.bsu.schedule.databasemodule.service.IScheduleService;
import edu.bsu.schedule.databasemodule.service.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@Controller
@EnableWebMvc
public class ScheduleController {
    private final static Logger logger = LogManager.getLogger(ScheduleController.class);

    @Autowired
    private IScheduleService scheduleService;

    @RequestMapping(
            value="/getSchedule/{course}/{group}",
            produces = "application/json",
            method = RequestMethod.GET
    )
    public @ResponseBody ResponseEntity<WeekScheduleWrapper> getWeekSchedule(
            @PathVariable("course") Long course,
            @PathVariable("group") String group) {
        WeekScheduleWrapper weekSchedule = new WeekScheduleWrapper();
        try {
            List<ScheduleVO> scheduleVOList = scheduleService.getWeekScheduleVO(course, group);
            if(scheduleVOList != null){
                weekSchedule.setScheduleList(scheduleVOList);
            }
        } catch (ServiceException ex) {
            logger.error(ex);
            ResponseEntity<WeekScheduleWrapper> errorResponse =
                    new ResponseEntity<WeekScheduleWrapper>(HttpStatus.INTERNAL_SERVER_ERROR);
            return errorResponse;
        }
        ResponseEntity<WeekScheduleWrapper> response = new ResponseEntity<WeekScheduleWrapper>(weekSchedule,HttpStatus.OK);
        return response;
    }
    @RequestMapping(
            value="/getSchedule/{course}/{group}/{weekday}",
            produces = "application/json",
            method = RequestMethod.GET
    )
    public @ResponseBody ResponseEntity<ScheduleVO> getDaySchedule(
            @PathVariable("course") Long course,
            @PathVariable("group") String group,
            @PathVariable("weekday") Long weekDay) {
        try {
            ScheduleVO schedule = scheduleService.getDayScheduleVO(course, group, weekDay);
            ResponseEntity<ScheduleVO> response = new ResponseEntity<ScheduleVO>(schedule,HttpStatus.OK);
            return response;
        } catch (ServiceException ex) {
            logger.error(ex);
            ResponseEntity<ScheduleVO> errorResponse =
                    new ResponseEntity<ScheduleVO>(HttpStatus.INTERNAL_SERVER_ERROR);
            return errorResponse;
        }

    }
}
