## A Springboot Application to send a messsage on slack
---

This spring boot application can be used to send a notification or messages on slack.

### Create Slack Webhook URL

1. You will be require a slackWebhookURL, where you can send the notification/workspace.

  - Please follow [create slack webhook URL documentation](https://api.slack.com/messaging/webhooks)
 
### Send message on the created webhook URL

1. Create a POJO class to set message that you want to send on slack.
2. Create a service class where you can set your webhook URL and send the message on the webhook.
