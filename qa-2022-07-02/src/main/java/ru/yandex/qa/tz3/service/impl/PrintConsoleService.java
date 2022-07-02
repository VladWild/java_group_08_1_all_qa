package ru.yandex.qa.tz3.service.impl;

import ru.yandex.qa.tz3.service.PrintService;
import ru.yandex.qa.tz3.task.Epic;
import ru.yandex.qa.tz3.task.Task;

import java.util.List;

public class PrintConsoleService implements PrintService {

    public void printTasks(List<Task> tasks) {
        System.out.println("Таски: ");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void printEpics(List<Epic> epics) {
        System.out.println("Эпики: ");
        for (Epic epic : epics) {
            System.out.println("У эпика " + epic + " есть подзадачи " + epic.getSubTaskIds());
        }
    }
}
