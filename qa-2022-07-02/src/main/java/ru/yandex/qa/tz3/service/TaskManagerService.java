package ru.yandex.qa.tz3.service;

import ru.yandex.qa.tz3.tasks.Epic;
import ru.yandex.qa.tz3.tasks.SubTask;
import ru.yandex.qa.tz3.tasks.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskManagerService {
    private Map<Integer, Task> tasks = new HashMap<>();
    private Map<Integer, Epic> epics = new HashMap<>();
    private Map<Integer, SubTask> subTasks = new HashMap<>();

    private int generateId = 0;

    public void addNewTask(Task task) {
        int taskId = generateId++;
        task.setId(taskId);
        tasks.put(taskId, task);
    }

    public void addNewEpic(Epic epic) {
        int epicId = generateId++;
        epic.setId(epicId);
        epics.put(epicId, epic);
    }

    public void addNewSubTask(SubTask subTask) {
        Epic epic = epics.get(subTask.getEpicId());
        if (epic == null) {
            return;
        }
        int subTaskId = generateId++;
        subTask.setId(subTaskId);
        subTasks.put(subTaskId, subTask);
        epic.addSubTaskId(subTaskId);
        updateEpicStatus(epic);
    }

    public List<Task> getTasks() {
        return new ArrayList<>(tasks.values());
    }

    public List<Epic> getEpics() {
        return new ArrayList<>(epics.values());
    }

    public List<SubTask> getSubTasks() {
        return new ArrayList<>(subTasks.values());
    }

    private void updateEpicStatus(Epic epic) {
        //TODO: логика обновления статуса эпика в случае добавления подзадачи в него
    }
}
