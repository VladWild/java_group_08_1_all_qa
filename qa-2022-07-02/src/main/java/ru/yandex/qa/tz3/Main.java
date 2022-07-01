package ru.yandex.qa.tz3;

import ru.yandex.qa.tz3.consts.Status;
import ru.yandex.qa.tz3.service.PrintConsoleService;
import ru.yandex.qa.tz3.service.TaskManagerService;
import ru.yandex.qa.tz3.tasks.Epic;
import ru.yandex.qa.tz3.tasks.SubTask;
import ru.yandex.qa.tz3.tasks.Task;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        TaskManagerService taskManagerService = new TaskManagerService();

        Task task = new Task("Таска 1", Status.NEW, "описание 1");
        Task task2 = new Task("Таска 2", Status.IN_PROGRESS, "описание 2");

        taskManagerService.addNewTask(task);
        taskManagerService.addNewTask(task2);

        Epic epic = new Epic("Эпик 1", Status.NEW, "описание эпика 1");
        Epic epic2 = new Epic("Эпик 1", Status.DONE, "описание эпика 2");

        taskManagerService.addNewEpic(epic);
        taskManagerService.addNewEpic(epic2);

        SubTask subTask = new SubTask("Таска 1", Status.NEW, "описание 1", epic.getId());
        SubTask subTask2 = new SubTask("Таска 2", Status.NEW, "описание 2", epic2.getId());

        taskManagerService.addNewSubTask(subTask);
        taskManagerService.addNewSubTask(subTask2);
        
        //-----------------------------------------------------

        PrintConsoleService printConsoleService = new PrintConsoleService();

        List<Task> tasks = taskManagerService.getTasks();
        List<Epic> epics = taskManagerService.getEpics();
        List<SubTask> subTasks = taskManagerService.getSubTasks();

        printConsoleService.printTasks(tasks);
        printConsoleService.printEpics(epics);
        printConsoleService.printSubTasks(subTasks);
    }
}
