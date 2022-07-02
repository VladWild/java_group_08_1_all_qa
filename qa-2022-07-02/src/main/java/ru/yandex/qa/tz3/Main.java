package ru.yandex.qa.tz3;

import ru.yandex.qa.tz3.constants.Status;
import ru.yandex.qa.tz3.service.PrintService;
import ru.yandex.qa.tz3.service.impl.PrintConsoleService;
import ru.yandex.qa.tz3.service.TaskManagerService;
import ru.yandex.qa.tz3.task.Epic;
import ru.yandex.qa.tz3.task.SubTask;
import ru.yandex.qa.tz3.task.Task;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        TaskManagerService taskManagerService = new TaskManagerService();

        Task task = new Task("Task 1", Status.NEW, "описание таски 1");
        Task tas2 = new Task("Task 2", Status.IN_PROGRESS, "описание таски 2");

        taskManagerService.addTask(task);
        taskManagerService.addTask(tas2);

        Epic epic = new Epic("Epic 1", Status.NEW, "описание 1-ого эпика");
        Epic epic2 = new Epic("Epic 2", Status.NEW, "описание 2-ого эпика");

        taskManagerService.addEpic(epic);
        taskManagerService.addEpic(epic2);

        SubTask subTask = new SubTask("SubTask 1", Status.IN_PROGRESS, "описание 1", epic.getId());
        SubTask subTask2 = new SubTask("SubTask 2", Status.IN_PROGRESS, "описание 2", epic2.getId());

        taskManagerService.addSubTask(subTask);
        taskManagerService.addSubTask(subTask2);

        //-----------------------------------------------------------------

        PrintService printConsoleService = new PrintConsoleService();

        List<Task> tasks = taskManagerService.getTasks();
        List<Epic> epics = taskManagerService.getEpics();

        printConsoleService.printTasks(tasks);
        printConsoleService.printEpics(epics);
    }
}
