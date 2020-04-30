package space.redoak.am;

// import java.awt.Desktop;
// import java.io.IOException;
// import java.net.URI;
// import java.net.URISyntaxException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AmApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmApplication.class, args);
//        openHomePage();
    }

    // private static void openHomePage() {
    //     try {
    //         URI homepage = new URI("http://localhost:8080/");
    //         Desktop.getDesktop().browse(homepage);
    //     } catch (URISyntaxException | IOException e) {
    //         e.printStackTrace();
    //     }
    // }

}
