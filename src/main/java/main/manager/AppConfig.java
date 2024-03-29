package main.manager;

import controller.ManagerController;
import controller.UploadCareService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import view.manager.*;

@Configuration
public class AppConfig {

    @Bean
    public ViewController viewController() {
        return new ViewController();
    }

    @Bean
    public AddCookController addCookController() {
        return new AddCookController();
    }

    @Bean
    public AddDishController addDishController() {
        return new AddDishController();
    }

    @Bean
    public AnalysisController analysisController() {
        return new AnalysisController();
    }

    @Bean
    public CookViewController cookController() {
        return new CookViewController();
    }

    @Bean
    public MenuController menuController() {
        return new MenuController();
    }

    @Bean
    public ManagerController managerController() {
        return new ManagerController();
    }

    @Bean
    public UploadCareService uploadCareService() {
        return new UploadCareService();
    }
}
