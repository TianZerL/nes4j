package cn.navclub.nes4j.app.view;

import cn.navclub.nes4j.app.INes;
import cn.navclub.nes4j.app.assets.FXResource;
import cn.navclub.nes4j.app.concurrent.TaskService;
import cn.navclub.nes4j.app.control.GameTray;
import cn.navclub.nes4j.app.dialog.DNesHeader;
import cn.navclub.nes4j.bin.eventbus.Message;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

/**
 * 游戏大厅
 */
public class GameHall {
    public static final String INES_OPEN_GAME = "ines-open-game";

    @FXML
    private FlowPane flowPane;
    @FXML
    private ListView<String> listView;

    private final Stage stage;

    private final GameWorld gameWorld;

    private TaskService<List<File>> taskService;

    public GameHall(Stage stage) {
        this.gameWorld = new GameWorld();

        Scene scene = new Scene(FXResource.loadFXML(this));
        this.stage = stage;
        this.stage.setWidth(1200);
        this.stage.setHeight(900);
        this.stage.setTitle("ines");
        this.stage.setScene(scene);
        this.stage.initStyle(StageStyle.UNDECORATED);
        this.stage.show();

        this.loadAssort();

        this.listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (taskService != null)
                taskService.cancel();

            this.flowPane.getChildren().clear();

            taskService = TaskService.execute(this.loadGameList(newValue));
            taskService.setOnSucceeded(event -> {
                @SuppressWarnings("all")
                var files = (List<File>) event.getSource().getValue();
                var list = files.stream().map(GameTray::new).toList();
                this.flowPane.getChildren().addAll(list);
            });
        });

        if (!this.listView.getItems().isEmpty())
            this.listView.getSelectionModel().select(0);

        INes.eventBus.listener(INES_OPEN_GAME, this::requestRun);
    }

    private boolean requestRun(Message<File> message) {
        var file = message.body();
        var header = new DNesHeader(message.body(), this.stage);
        var execute = header.showAndWait().orElse(false);
        if (execute) {
            this.gameWorld.execute(file);
        }
        return execute;
    }

    private void loadAssort() {
        var file = new File("nes");
        var list = file.listFiles();
        if (list == null) {
            return;
        }
        for (File item : list) {
            if (item.isFile())
                continue;
            this.listView.getItems().add(item.getName());
        }
    }


    @SuppressWarnings("all")
    private Task<List<File>> loadGameList(String assort) {
        return new Task<>() {
            @Override
            protected List<File> call() {
                var path = Path.of("nes", assort);
                var file = path.toFile();
                if (!file.exists() || file.listFiles() == null) {
                    return List.of();
                }
                return Arrays.stream(file.listFiles()).filter(File::isFile).toList();
            }
        };
    }

    @FXML
    public void exit() {
        Platform.exit();
    }

    @FXML
    public void iconified() {
        this.stage.setIconified(true);
    }
}
