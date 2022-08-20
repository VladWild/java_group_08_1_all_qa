package ru.yandex.qa.tech_task_6;

import ru.yandex.qa.tech_task_6.manager.Managers;
import ru.yandex.qa.tech_task_6.manager.TaskManager;
import ru.yandex.qa.tech_task_6.tassk.Task;

public class Main {

    public static void main(String[] args) {
        TaskManager aDefault = Managers.getDefault();
        aDefault.addNewTask(new Task(55767));
    }
}
