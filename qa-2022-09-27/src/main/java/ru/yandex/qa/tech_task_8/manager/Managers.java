package ru.yandex.qa.tech_task_8.manager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.yandex.qa.tech_task_8.manager.impl.FileBackedTaskManager;
import ru.yandex.qa.tech_task_8.manager.impl.HttpTaskManager;

import java.io.File;

public class Managers {

    public static TaskManager getDefault() {
        return new HttpTaskManager();
    }

    public static Gson getGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }
}
