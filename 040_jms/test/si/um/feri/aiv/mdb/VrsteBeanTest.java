package si.um.feri.aiv.mdb;

import javax.jms.DeliveryMode;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.naming.InitialContext;

import org.junit.Test;

public class VrsteBeanTest {

	@Test
	public void testQueue() throws Exception {
		
		InitialContext ctx = new InitialContext();
		Queue queue = (Queue) ctx.lookup("jms/queue/test");
		QueueConnectionFactory factory = (QueueConnectionFactory) ctx.lookup("jms/RemoteConnectionFactory");
		QueueConnection cnn = factory.createQueueConnection("guest","guest");
		QueueSession session = cnn.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
		QueueSender sender = session.createSender(queue);

		sender.send(session.createTextMessage("Ojla!"));
		sender.send(session.createTextMessage("Pa spet."));
		sender.send(session.createTextMessage("Pa se enkrat :)."));
		
		//sender.send(session.createTextMessage("DAJMO!"));
		
		//sporo�ilo, ki ni trajno
		Message m=session.createTextMessage("NETRAJNO SPOROCILO");
		sender.send(m,DeliveryMode.NON_PERSISTENT,3,2000);

		//sporo�ilo, ki je trajno
		m=session.createTextMessage("TRAJNO SPOROCILO");
		sender.send(m,DeliveryMode.PERSISTENT,3,10000);

		session.close();
		
	}

}
