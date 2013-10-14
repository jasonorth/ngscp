import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.*;

import java.util.Arrays;

import models.Bar;

import org.junit.Test;

import plugins.SpringPlugin;
import services.BarService;

public class BarServiceTest {

    @Test
    public void createBar() {
    	running(fakeApplication(inMemoryDatabase(), Arrays.asList("plugins.DefaultSpringAppPlugin")), new Runnable() {
    		public void run() {
	    		Bar bar = new Bar();
	            bar.name = "foo";
	            BarService barService = SpringPlugin.plugin(SpringPlugin.class).get(BarService.class);
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