package ru.yandex.qa.tz3.task;

import java.util.ArrayList;
import java.util.List;

public class Epic extends Task {
    private List<Integer> subTaskIds = new ArrayList<>();

    public Epic(String name, TaskStatus status, String discription) {
        super(name, status, discription);
        this.subTaskIds = subTaskIds;
    }

    public void addSubTask(int subTaskId) {
        subTaskIds.add(subTaskId);
    }

    public List<Integer> getSubTaskIds() {
        return subTaskIds;
    }
}
