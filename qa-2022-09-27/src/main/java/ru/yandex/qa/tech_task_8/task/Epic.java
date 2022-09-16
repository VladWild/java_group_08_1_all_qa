package ru.yandex.qa.tech_task_8.task;

public class Epic extends Task {
    public Epic(int id) {
        super(id);
    }

    public TaskType getTaskType() {
        return TaskType.EPIC;
    }
}
