

import model.SlackMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import services.SlackServices;

@SpringBootApplication
public class MainClass {

  @Autowired
  private static SlackServices slackServices;

  public static void main(String[] args) {
    SpringApplication.run(MainClass.class, args);
    String message = "Hey! I am sending a sample message on slack";
    SlackMessage slackMessage = new SlackMessage();
    slackMessage.setText(message);
    slackServices.sendMessage(slackMessage.toString());
  }

}
