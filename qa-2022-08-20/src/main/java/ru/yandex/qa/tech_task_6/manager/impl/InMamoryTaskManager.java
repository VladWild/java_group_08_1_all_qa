package ru.yandex.qa.tech_task_6.manager.impl;

import ru.yandex.qa.tech_task_6.manager.TaskManager;
import ru.yandex.qa.tech_task_6.tassk.Epic;
import ru.yandex.qa.tech_task_6.tassk.SubTask;
import ru.yandex.qa.tech_task_6.tassk.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMamoryTaskManager implements TaskManager {
    protected Map<Integer, Task> tasks = new HashMap<>();
    protected Map<Integer, Epic> epics = Map.of(3, new Epic(3), 4, new Epic(4));
    protected Map<Integer, SubTask> subTasks = Map.of(5, new SubTask(5), 6, new SubTask(6));

    @Override
    public int addNewTask(Task task) {
        tasks.put(task.getId(), task);
        return task.getId();
    }

    @Override
    public List<Task> getTasks() {
        return new ArrayList<>(tasks.values());
    }

    @Override
    public void method() {
        throw new UnsupportedOperationException();
    }
}
