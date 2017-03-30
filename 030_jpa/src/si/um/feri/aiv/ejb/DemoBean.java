package si.um.feri.aiv.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DemoBean implements Demo {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public void narediNekaj() {
		
		
		
	}
}
