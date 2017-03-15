package si.um.feri.aiv.patterns.adapter;

import si.um.feri.aiv.patterns.adapter.adaptiranci.MailSenderAdapter;
import si.um.feri.aiv.patterns.adapter.adaptiranci.SMSSenderAdapter;

public class Postar {

	//Po�tar dela z obve��evalcem
	//Novost sta SMSSender in MailSender - vklju�imo ju z adapterjema
	
	//1. mo�nost: pri definiciji reference dolo�imo, kateri adapter se uporablja
	Obvescevalec o;

	//2. mo�nost: �e vedno kreiramo adapter v kodi, vendar na podlagi parametra
	public Postar(String obvescanjePreko) {
		if (obvescanjePreko.equals("sms")) o=new SMSSenderAdapter();
		if (obvescanjePreko.equals("mail")) o=new MailSenderAdapter();
		if (o==null) o=new Obvescevalec();
		
		o.obvestilo("Rojstvo po�tarja: "+this);
	}
	
	//3. mo�nost: smo "odprti" za vse morebitne - morda �e neobstoje�e - adapterje
	public Postar(Class<? extends  Obvescevalec> adapter) {
		try {
			o=adapter.newInstance();
		} catch (Exception e) {
			o=new Obvescevalec();
		}
		o.obvestilo("Rojstvo po�tarja: "+this);
	}
	
	public Postar() {
		o=new Obvescevalec();
		o.obvestilo("Rojstvo po�tarja: "+this);
	}
	
	public String prinesiPosto() {
		return o.obvestilo("Zdravo, sem "+this+" in sem ti prinesel po�to.");
	}
	
}
