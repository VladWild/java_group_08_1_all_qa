package ru.yandex.qa.tech_task_8.manager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.yandex.qa.tech_task_8.manager.impl.FileBackedTaskManager;

import java.io.File;

public class Managers {

    public static TaskManager getDefault() {
        return new FileBackedTaskManager(new File("qa-2022-08-20/src/main/resources/tasks.csv"));
    }

    public static Gson getGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }
}
