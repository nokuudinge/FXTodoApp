package nl.inholland.fxtodoapp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TodoItemService {

    private static final String STORAGE_FILE_NAME = "todo-items.dat";

    private final List<TodoItem> items;
    private final Path storagePath;

    public TodoItemService() {
        this(Path.of(System.getProperty("user.home"), ".fxtodoapp", STORAGE_FILE_NAME));
    }

    TodoItemService(Path storagePath) {
        this.storagePath = storagePath;
        items = new ArrayList<>();
        items.add(new TodoItem("Test this app", false));
        items.add(new TodoItem("Just make sure it works", false));
    }

    public void save() {
        try {
            if (storagePath.getParent() != null) {
                Files.createDirectories(storagePath.getParent());
            }

            try (ObjectOutputStream outputStream =
                         new ObjectOutputStream(Files.newOutputStream(storagePath))) {
                outputStream.writeObject(new ArrayList<>(items));
            }
        } catch (IOException e) {
            throw new RuntimeException("Unable to save todo items", e);
        }
    }

    public void load() {
        if (!Files.exists(storagePath)) {
            return;
        }

        try (ObjectInputStream inputStream =
                     new ObjectInputStream(Files.newInputStream(storagePath))) {
            Object data = inputStream.readObject();
            if (data instanceof List<?> list) {
                items.clear();
                for (Object object : list) {
                    if (object instanceof TodoItem todoItem) {
                        items.add(todoItem);
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Unable to load todo items", e);
        }
    }

    public List<TodoItem> getItems() {
        return items;
    }
}
