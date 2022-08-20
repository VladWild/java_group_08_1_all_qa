package ru.yandex.qa.tech_task_6.manager;

import ru.yandex.qa.tech_task_6.manager.impl.FileBackedTaskManager;

import java.io.File;

public class Managers {

    public static TaskManager getDefault() {
        return new FileBackedTaskManager(new File("qa-2022-08-20/src/main/resources/tasks.csv"));
    }
}
