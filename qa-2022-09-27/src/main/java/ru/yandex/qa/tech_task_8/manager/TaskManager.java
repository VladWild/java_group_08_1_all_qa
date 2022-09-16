package ru.yandex.qa.tech_task_8.manager;

import ru.yandex.qa.tech_task_8.task.Task;

import java.util.List;

public interface TaskManager {

    int addNewTask(Task task);

    List<Task> getTasks();

    void method();
}
