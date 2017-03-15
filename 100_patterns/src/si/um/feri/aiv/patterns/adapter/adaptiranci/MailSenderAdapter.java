package si.um.feri.aiv.patterns.adapter.adaptiranci;

import si.um.feri.aiv.patterns.adapter.Obvescevalec;

public class MailSenderAdapter extends Obvescevalec {

	MailSender ms=new MailSender();
	
	@Override
	public String obvestilo(String text) {
		ms.posljiPosto("jaz@podjetje.si", "Sporo�ilo iz po�te", text);
		return "jaz@podjetje.si; Sporo�ilo iz po�te: "+text;
	}
	
}
