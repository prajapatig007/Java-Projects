package model;

import java.io.Serializable;

/**
 * Model class for SlackMessage
 *
 * @author Ganesh
 */
public class SlackMessage implements Serializable {

  private String text;

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  @Override
  public String toString() {
    return "SlackMessage{" + "slackMessage='" + text + '\'' + '}';
  }

}
