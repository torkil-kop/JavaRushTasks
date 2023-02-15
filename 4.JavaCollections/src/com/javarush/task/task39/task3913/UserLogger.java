package com.javarush.task.task39.task3913;

import java.util.Date;

public class UserLogger {
    private String ip;
    private String userName;
    private Date date;
    private Event event;
    private Status status;
    private int taskNumber;

    public UserLogger(String ip, String userName, Date date, Event event, Status status, int taskNumber) {
        this.ip = ip;
        this.userName = userName;
        this.date = date;
        this.event = event;
        this.status = status;
        this.taskNumber = taskNumber;
    }

    public String getIp() {
        return ip;
    }

    public String getUserName() {
        return userName;
    }

    public Date getDate() {
        return date;
    }

    public Event getEvent() {
        return event;
    }

    public Status getStatus() {
        return status;
    }

    public int getTaskNumber() {
        return taskNumber;
    }

    @Override
    public String toString() {
        return "UserLogger{" +
                "ip='" + ip + '\'' +
                ", userName='" + userName + '\'' +
                ", date=" + date +
                ", event=" + event +
                ", status=" + status +
                ", taskNumber=" + taskNumber +
                '}';
    }
}
