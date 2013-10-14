import static org.fest.assertions.Assertions.assertThat;
import models.Bar;

import org.junit.Test;

public class BarTest {
 
    @Test
    public void setBarName() {
        Bar bar = new Bar();
        bar.name = "foo";
        assertThat(bar.name).isEqualTo("foo");
    }

}
