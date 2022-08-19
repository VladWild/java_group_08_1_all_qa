package ru.yandex.qa.tech_task_6.manager;

import ru.yandex.qa.tech_task_6.tasks.Task;

public class CSVTaskFormat {

    public static String getHeader() {
        return "id,type";
    }

    public static String toString(Task task) {
        return task.getId() + "," + task.getTaskType();
    }
}
