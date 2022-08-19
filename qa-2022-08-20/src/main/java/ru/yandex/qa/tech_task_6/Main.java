package ru.yandex.qa.tech_task_6;

import ru.yandex.qa.tech_task_6.manager.Managers;
import ru.yandex.qa.tech_task_6.manager.TaskManager;
import ru.yandex.qa.tech_task_6.tasks.Task;

public class Main {

    public static void main(String[] args) {
        TaskManager taskManager = Managers.getDefault();
        taskManager.addNewTask(new Task(4353));
    }
}
