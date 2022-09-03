package ru.yandex.qa.tech_task_6.manager;

import ru.yandex.qa.tech_task_6.tassk.Task;

import java.util.List;

public interface TaskManager {

    int addNewTask(Task task);

    List<Task> getTasks();
}
