package ru.yandex.qa.tz3.tasks;

import ru.yandex.qa.tz3.consts.Status;

public class SubTask extends Task {
    private int epicId;

    public SubTask(String name, Status status, String description, int epicId) {
        super(name, status, description);
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
        return "Subtask{" +
                "epicId=" + epicId +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", description='" + description + '\'' +
                '}';
    }
}
