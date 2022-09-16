package ru.yandex.qa.tech_task_8.manager.impl;

import com.google.gson.Gson;
import ru.yandex.qa.tech_task_8.manager.Managers;
import ru.yandex.qa.tech_task_8.manager.http.KVTaskClient;

import java.io.File;
import java.util.ArrayList;

public class HttpTaskManager extends FileBackedTaskManager {
    private final KVTaskClient client;
    private final Gson gson;

    public HttpTaskManager() {
        super(null);
        client = new KVTaskClient();
        gson = Managers.getGson();
    }

    private void load() {

    }

    @Override
    protected void save() {
        String jsonTasks = gson.toJson(new ArrayList<>(tasks.values()));
        client.put("tasks", jsonTasks);

        //subtasks
        //epics

        //history
    }
}
