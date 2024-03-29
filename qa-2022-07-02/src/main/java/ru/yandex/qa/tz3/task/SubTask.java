package ru.yandex.qa.tz3.task;

public class SubTask extends Task {
    private int epicId;


    public SubTask(String name, TaskStatus status, String discription, int epicId) {
        super(name, status, discription);
        this.epicId = epicId;
    }

    public int getEpicId() {
        return epicId;
    }

    public void setEpicId(int epicId) {
        this.epicId = epicId;
    }

    @Override
    public String toString() {
        return "SubTask{" +
                "epicId=" + epicId +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", discription='" + discription + '\'' +
                '}';
    }
}
