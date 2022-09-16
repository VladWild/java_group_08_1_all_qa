package ru.yandex.qa.tech_task_8.manager.http.server;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import ru.yandex.qa.tech_task_8.manager.Managers;
import ru.yandex.qa.tech_task_8.manager.TaskManager;
import ru.yandex.qa.tech_task_8.task.Task;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class HttpTaskServer {
    public static final int PORT = 8080;
    public static final String HOST = "localhost";

    private static final String GENERAL_PATH = "/tasks";

    private final HttpServer server;
    private final TaskManager taskManager;
    private final Gson gson;

    public HttpTaskServer() throws IOException {
        server = HttpServer.create(new InetSocketAddress(HOST, PORT), 0);
        server.createContext("/tasks", this::handler);
        taskManager = Managers.getDefault();
        gson = Managers.getGson();
    }

    public static void main(String[] args) throws IOException {
        HttpTaskServer httpTaskServer = new HttpTaskServer();
        httpTaskServer.start();
    }

    public void start() {
        System.out.println("Started TaskServer: " + HOST + ":" + PORT);
        server.start();
    }

    public void stop() {
        server.stop(0);
        System.out.println("Stop TaskServer: "  + HOST + ":" + PORT);
    }

    private void handler(HttpExchange h) {
        try (h) {
            System.out.println("Путь урла: " + h.getRequestURI());
            final String path = h.getRequestURI().getPath().substring(GENERAL_PATH.length() + 1);
            switch (path) {
                case "task" -> handleTask(h);
                //case "epic" -> handleEpic(h);
                default -> {
                    System.out.println("Неизвестный запрос: " + h.getRequestURI());
                    h.sendResponseHeaders(405, 0);
                }
            }
        } catch (Exception e) {

        }
    }

    private void handleTask(HttpExchange h) throws IOException {

        String requestMethod = h.getRequestMethod();
        switch (requestMethod) {
            case "GET" -> {
                System.out.println("Получаем таски");
            }
            case "POST" -> {
                String json = readText(h);
                if (json.isEmpty()) {
                    System.out.println("Body c задачей  пустой. указывается в теле запроса");
                    h.sendResponseHeaders(400, 0);
                    return;
                }
                Task task = gson.fromJson(json, Task.class); //
                taskManager.addNewTask(task);
                h.sendResponseHeaders(200, 0);
                System.out.println("Сохраняем таску");
            }
            case "PUT" -> {
                System.out.println("Модифицируем таску");
            }
            case "DELETE" -> {
                System.out.println("Удаляем таску");
            }
            default -> {
                System.out.println("Неизвестный тип запроса: " + requestMethod);
                h.sendResponseHeaders(405, 0);
            }
        }
    }

    private String readText(HttpExchange h) throws IOException {
        return new String(h.getRequestBody().readAllBytes(), StandardCharsets.UTF_8);
    }
}
