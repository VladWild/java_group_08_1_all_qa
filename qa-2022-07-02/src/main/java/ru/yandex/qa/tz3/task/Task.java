package ru.yandex.qa.tz3.task;

import ru.yandex.qa.tz3.constants.Status;

public class Task {
    protected int id;
    protected String name;
    protected Status status;
    protected String discription;

    public Task(String name, Status status, String discription) {
        this.name = name;
        this.status = status;
        this.discription = discription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", discription='" + discription + '\'' +
                '}';
    }
}
