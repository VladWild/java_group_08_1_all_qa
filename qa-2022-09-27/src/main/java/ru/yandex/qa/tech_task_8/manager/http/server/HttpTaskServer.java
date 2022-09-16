package ru.yandex.qa.tech_task_8.manager.http.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class HttpTaskServer {
    public static final int PORT = 8080;
    public static final String HOST = "localhost";

    private static final String GENERAL_PATH = "/tasks";

    private final HttpServer server;

    public HttpTaskServer() throws IOException {
        server = HttpServer.create(new InetSocketAddress(HOST, PORT), 0);
        server.createContext("/tasks", this::handler);
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
}
