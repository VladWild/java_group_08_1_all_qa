package ru.yandex.qa.tech_task_8.task;

public class SubTask extends Task {

    public SubTask(int id) {
        super(id);
    }

    public TaskType getTaskType() {
        return TaskType.SUB_TASK;
    }
}
