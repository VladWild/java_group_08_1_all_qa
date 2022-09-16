package ru.yandex.qa.tech_task_8;

import ru.yandex.qa.tech_task_8.manager.Managers;
import ru.yandex.qa.tech_task_8.manager.TaskManager;
import ru.yandex.qa.tech_task_8.task.Task;

public class Main {

    public static void main(String[] args) {
        TaskManager aDefault = Managers.getDefault();
        aDefault.addNewTask(new Task(55767));
    }
}
