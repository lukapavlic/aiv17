package si.um.feri.aiv.patterns.strategija.konkretne;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import si.um.feri.aiv.patterns.strategija.PlacilnoSredstvo;

public class PayPal implements PlacilnoSredstvo {

	Logger log=LoggerFactory.getLogger(PayPal.class);
	
	@Override
	public String izvediPlacilo() {
		log.info("Pla�ujem s PayPal-om");
		return "Pla�ujem s PayPal-om";
	}
	
}
