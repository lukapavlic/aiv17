package si.um.feri.aiv.patterns;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	si.um.feri.aiv.patterns.singleton.PostarTest.class, 
	si.um.feri.aiv.patterns.singleton.SinglePostarLazyTest.class,
	si.um.feri.aiv.patterns.singleton.SinglePostarTest.class,
	si.um.feri.aiv.patterns.adapter.PostarTest.class,
	si.um.feri.aiv.patterns.observer.StudentTest.class
})
public class AllTests {

}
