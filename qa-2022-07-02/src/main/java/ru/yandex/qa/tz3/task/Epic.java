package ru.yandex.qa.tz3.task;

import ru.yandex.qa.tz3.constants.Status;

import java.util.ArrayList;
import java.util.List;

public class Epic extends Task {
    private List<Integer> subTaskIds = new ArrayList<>();

    public Epic(String name, Status status, String discription) {
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
