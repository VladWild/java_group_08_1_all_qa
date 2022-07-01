package ru.yandex.qa.tz3.tasks;

import ru.yandex.qa.tz3.consts.Status;

import java.util.ArrayList;
import java.util.List;

public class Epic extends Task {
    private List<Integer> subtaskIds = new ArrayList<>();

    public Epic(String name, Status status, String description) {
        super(name, status, description);
        this.subtaskIds = subtaskIds;
    }

    public void addSubTaskId(int taskId) {
        subtaskIds.add(taskId);
    }

    public List<Integer> getSubtaskIds() {
        return subtaskIds;
    }

    @Override
    public String toString() {
        return "Epic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", description='" + description + '\'' +
                ", subtaskIds=" + subtaskIds +
                '}';
    }
}
