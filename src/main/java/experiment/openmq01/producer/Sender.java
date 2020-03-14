package experiment.openmq01.producer;


import java.util.Random;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

public class Sender {

    public static void main(String[] args) {
        try {
            ConnectionFactory cf = new com.sun.messaging.ConnectionFactory();
            ((com.sun.messaging.ConnectionFactory) cf).setProperty(com.sun.messaging.ConnectionConfiguration.imqAddressList, "localhost:7676");
            Connection connection = cf.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Destination destination = session.createQueue("AQueue");
            MessageProducer messageProducer = session.createProducer(destination);
            TextMessage textMessage = session.createTextMessage();
            Random r = new Random();
            textMessage.setText("A test message - " + r.nextInt(1000));
            messageProducer.send(textMessage);
            System.out.println("Message sent:" + textMessage.getText());

            session.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
