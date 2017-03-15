package si.um.feri.aiv.patterns.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import si.um.feri.aiv.patterns.adapter.adaptiranci.MailSender;

public class Obvescevalec {
	
	Logger log=LoggerFactory.getLogger(MailSender.class);

	public String obvestilo(String text) {
		String ret="Obve��am: "+text;
		log.info(ret);
		return ret;
	}
}
