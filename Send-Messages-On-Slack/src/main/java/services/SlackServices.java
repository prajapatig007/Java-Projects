package services;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.SlackMessage;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Utility class for sending message to slack
 *
 * @author Ganesh
 */
@Component
public class SlackServices {

  public final Logger LOGGER = LoggerFactory.getLogger(SlackServices.class);
  private static String slackWebhookUrl = "slackWebhookURL";


  /**
   * sending message on slack
   *
   * @param messageToSendOnSlack
   */
  public void sendMessage(String messageToSendOnSlack) {

    CloseableHttpClient client = HttpClients.createDefault();
    HttpPost httpPost = new HttpPost(slackWebhookUrl);
    try {
      SlackMessage alertMessage = new SlackMessage();
      alertMessage.setText(messageToSendOnSlack);
      LOGGER.info("Sending alertMessage to slack with data {}", alertMessage.toString());
      ObjectMapper objectMapper = new ObjectMapper();
      String json = objectMapper.writeValueAsString(alertMessage);
      StringEntity entity = new StringEntity(json);
      httpPost.setEntity(entity);
      httpPost.setHeader("Content-type", "application/json");
      client.execute(httpPost);
      client.close();
    } catch (IOException e) {
      LOGGER.error("Server was unable to process the request, due to invalid syntax", e);
    }
  }
}
