import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import play.Application;
import play.GlobalSettings;
import configs.AppConfig;
import configs.DataConfig;

public class Global extends GlobalSettings {

	public AnnotationConfigApplicationContext ctx;

    @Override
    public void onStart(Application app) {
        ctx = new AnnotationConfigApplicationContext(AppConfig.class, DataConfig.class);        
    }

    @Override
   	public void onStop(Application app) {
   		ctx.close();
   	}
   	
    @Override
    public <A> A getControllerInstance(Class<A> clazz) {
        return ctx.getBean(clazz);
    }

}