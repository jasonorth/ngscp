package injector;

import play.Application;
import play.api.Plugin;

public abstract class InjectorPlugin implements Plugin {

	protected final Application app;

	public InjectorPlugin(Application app) {		
		this.app = app;
	}

	public abstract InjectorApi api();
	
	@Override
	public boolean enabled() {
		return true;
	}
	
}
