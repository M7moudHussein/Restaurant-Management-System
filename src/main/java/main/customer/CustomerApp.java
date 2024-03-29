package main.customer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import view.customer.MenuController;

import java.util.HashMap;

@SpringBootApplication
@ComponentScan(value = {"controller", "view.customer"})
@EnableJpaRepositories(value = "model.repository")
@EntityScan(value = "model.entity")
public class CustomerApp extends Application {
    private ConfigurableApplicationContext springContext;
    private FXMLLoader fxmlLoader;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        fxmlLoader.setLocation(getClass().getResource("/fxml/CustomerMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add("/css/menu.css");
        MenuController controller = fxmlLoader.getController();
        controller.setMap(new HashMap<>(), primaryStage);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void init() {
        springContext = SpringApplication.run(CustomerApp.class);
        fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(springContext::getBean);
    }

    @Override
    public void stop() {
        springContext.stop();
    }
}