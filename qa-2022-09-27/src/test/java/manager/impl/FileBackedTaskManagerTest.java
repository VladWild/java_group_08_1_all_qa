package manager.impl;

import manager.TaskManagerTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import ru.yandex.qa.tech_task_8.manager.impl.FileBackedTaskManager;
import ru.yandex.qa.tech_task_8.task.Task;

import java.io.File;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FileBackedTaskManagerTest extends TaskManagerTest<FileBackedTaskManager> {

    private File file;

    @BeforeEach
    void setUp() {
        file = new File("qa-2022-08-20/src/test/resources/tasks.csv");
    }

    @AfterEach
    void cleanUp() {
        file.delete();
    }

    @Test
    @Order(1)
    @DisplayName("Тест на чтение из файла")
    void loadFileTest() {
        FileBackedTaskManager fileBackedTaskManager = FileBackedTaskManager.loadFromFile(file);
        List<Task> tasks = fileBackedTaskManager.getTasks();

        //тут ассерты
    }
}