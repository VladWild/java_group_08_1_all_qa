package manager;

import ru.yandex.qa.tech_task_8.manager.TaskManager;
import ru.yandex.qa.tech_task_8.task.Task;

public abstract class TaskManagerTest<T extends TaskManager> {

    protected T taskManager;

    protected void initTasks() {
        taskManager.addNewTask(new Task(1));
        taskManager.addNewTask(new Task(2));
    }
}