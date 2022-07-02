package ru.yandex.qa.tz3.service;

import ru.yandex.qa.tz3.task.Epic;
import ru.yandex.qa.tz3.task.Task;

import java.util.List;

public interface PrintService {

    void printTasks(List<Task> tasks);

    void printEpics(List<Epic> epics);
}
