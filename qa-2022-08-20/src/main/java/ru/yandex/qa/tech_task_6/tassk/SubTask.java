package ru.yandex.qa.tech_task_6.tassk;

public class SubTask extends Task {

    public SubTask(int id) {
        super(id);
    }

    public TaskType getTaskType() {
        return TaskType.SUB_TASK;
    }
}
