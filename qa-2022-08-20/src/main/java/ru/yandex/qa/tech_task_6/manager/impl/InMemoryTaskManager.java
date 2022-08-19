package ru.yandex.qa.tech_task_6.manager.impl;

import ru.yandex.qa.tech_task_6.manager.TaskManager;
import ru.yandex.qa.tech_task_6.tasks.Epic;
import ru.yandex.qa.tech_task_6.tasks.SubTask;
import ru.yandex.qa.tech_task_6.tasks.Task;

import java.util.Map;

public class InMemoryTaskManager implements TaskManager {
    protected final Map<Integer, Task> tasks = Map.of(1, new Task(1), 2, new Task(2));
    protected final Map<Integer, Epic> epics = Map.of(3, new Epic(3), 4, new Epic(4));
    protected final Map<Integer, SubTask> subTasks = Map.of(5, new SubTask(5), 6, new SubTask(6));

    @Override
    public int addNewTask(Task task) {
        return 0;
    }
}
