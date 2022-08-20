package ru.yandex.qa.tech_task_6.tassk;

public class Epic extends Task {
    public Epic(int id) {
        super(id);
    }

    public TaskType getTaskType() {
        return TaskType.EPIC;
    }
}
