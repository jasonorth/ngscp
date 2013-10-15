import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.running;
import injector.Injector;

import java.util.Arrays;

import models.Bar;

import org.junit.Test;

import services.BarService;
import configs.AppInjectorPlugin;

public class BarServiceTest {
	
    @Test
    public void createBar() {
    	running(fakeApplication(inMemoryDatabase(), Arrays.asList(AppInjectorPlugin.class.getName())), new Runnable() {
    		public void run() {
	    		Bar bar = new Bar();
	            bar.name = "foo";
	            BarService barService = Injector.get(BarService.class);
	            barService.addBar(bar);
	            assertThat(bar.id).isNotNull();
    		}
    	});        
    }

   /* @Test
    public void getBars() {
        createBar();
        List<Bar> bars = barService.getAllBars();
        assertThat(bars.size()).isEqualTo(1);
    }*/

}