package ru.yandex.qa.tz3.service;

import ru.yandex.qa.tz3.task.Epic;
import ru.yandex.qa.tz3.task.SubTask;
import ru.yandex.qa.tz3.task.Task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskManagerService {
    private Map<Integer, Task> tasks = new HashMap<>();
    private Map<Integer, SubTask> subTasks = new HashMap<>();
    private Map<Integer, Epic> epics = new HashMap<>();

    private int generator = 0;

    public void addTask(Task task) {
        task.setId(generator++);
        tasks.put(task.getId(), task);
    }

    public void addEpic(Epic epic) {
        int epicId = generator++;
        epic.setId(epicId);
        epics.put(epicId, epic);
    }

    public void addSubTask(SubTask subTask) {
        int epicId = subTask.getEpicId();
        Epic epic = epics.get(epicId);
        if (epic == null) {
            return;
        }
        //сохраняем подзадачу
        int subTaskId = generator++;
        subTask.setId(subTaskId);
        subTasks.put(subTaskId, subTask);
        //добавляем в эпик подзадачу
        epic.addSubTask(subTaskId);
        updateEpicStatus(epic); //ВАЖНО!!!!
    }

    public Task getTask(int taskId) {
        return tasks.get(taskId);
    }

    public List<Task> getTasks() {
        Collection<Task> values = tasks.values();
        return new ArrayList<>(values);
    }

    public List<Epic> getEpics() {
        Collection<Epic> values = epics.values();
        return new ArrayList<>(values);
    }

    private void updateEpicStatus(Epic epic) {
        //логика определения статуса эпика
    }
}
