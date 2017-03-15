package si.um.feri.aiv.patterns.singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Edinec - implementacija s kreiranjem objekta ob prvi uporabi
 * privaten konstruktor in pridobivanje objekta preko metode getInstance
 */
public class SinglePostar {
	
	Logger log=LoggerFactory.getLogger(SinglePostar.class);

	private static SinglePostar instance=null;
	public static synchronized SinglePostar getInstance() {
		if (instance==null) instance=new SinglePostar();
		return instance;
	}
	
	private SinglePostar() {
		log.info("Rojstvo poštarja: "+this);
	}
	
	public void prinesiPosto() {
		log.info("Zdravo, sem "+this+" in sem ti prinesel pošto.");
	}
	
}
