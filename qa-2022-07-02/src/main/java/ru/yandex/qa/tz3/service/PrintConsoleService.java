package ru.yandex.qa.tz3.service;

import ru.yandex.qa.tz3.tasks.Epic;
import ru.yandex.qa.tz3.tasks.SubTask;
import ru.yandex.qa.tz3.tasks.Task;

import java.util.List;

public class PrintConsoleService {

    public void printTasks(List<Task> tasks) {
        System.out.println("Таски:");
        System.out.println(tasks);
    }

    public void printEpics(List<Epic> epics) {
        System.out.println("Эпики:");
        for (Epic epic : epics) {
            System.out.println("У эпика " + epic + " есть подзадачи: " + epic.getSubtaskIds());
        }
    }

    public void printSubTasks(List<SubTask> subTasks) {
        System.out.println("Подзадачи:");
        System.out.println(subTasks);
    }
}
