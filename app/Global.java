import injector.Injector;
import play.Application;
import play.GlobalSettings;

public class Global extends GlobalSettings {

    @Override
    public void onStart(Application app) {
    }

    @Override
   	public void onStop(Application app) {
   	}
   	
    @Override
    public <A> A getControllerInstance(Class<A> clazz) {
    	return Injector.get(clazz);
    }

}