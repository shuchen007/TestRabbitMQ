/**
 * @Author sunhao
 * @Description
 * @Date 14:19 2018/5/7
 * @Modified by
 */

import java.io.IOException;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class BaseConnector {
	protected Channel channel;
	protected Connection connection;
	protected String queueName;
	public BaseConnector(String queueName) throws IOException{
		this.queueName = queueName;
		//打开连接和创建频道
		ConnectionFactory factory = new ConnectionFactory();
		//设置MabbitMQ所在主机ip或者主机名  127.0.0.1即localhost
		factory.setHost("127.0.0.1");
		//创建连接
		connection = factory.newConnection();
		//创建频道
		channel = connection.createChannel();
		//声明创建队列
		channel.queueDeclare(queueName, false, false, false, null);
	}
}
