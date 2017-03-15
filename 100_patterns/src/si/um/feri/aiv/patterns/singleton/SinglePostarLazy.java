package si.um.feri.aiv.patterns.singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Edinec - implementacija s kreiranjem objekta neodvisno od uporabe
 * privaten konstruktor in pridobivanje objekta preko metode getInstance
 */
public class SinglePostarLazy {
	
	Logger log=LoggerFactory.getLogger(SinglePostarLazy.class);

	private static SinglePostarLazy instance= new SinglePostarLazy();
	public static SinglePostarLazy getInstance() {
		return instance;
	}
	
	private SinglePostarLazy() {
		log.info("Rojstvo poštarja: "+this);
	}
	
	public void prinesiPosto() {
		log.info("Zdravo, sem "+this+" in sem ti prinesel pošto.");
	}
	
}
