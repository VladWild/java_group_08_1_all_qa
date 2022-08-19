package ru.yandex.qa.tech_task_6.tasks;

public class SubTask extends Task {

    public SubTask(int id) {
        super(id);
    }

    public TaskType getTaskType() {
        return TaskType.SUBTASK;
    }
}
