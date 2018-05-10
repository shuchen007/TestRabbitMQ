import java.io.IOException;
import java.io.Serializable;
import org.apache.commons.lang.SerializationUtils;

public class Sender extends BaseConnector {
    public Sender(String queueName) throws IOException {
        super(queueName);
    }

    public void sendMessage(Serializable object) throws IOException {
        channel.basicPublish("",queueName, null, SerializationUtils.serialize(object));
    }   
}