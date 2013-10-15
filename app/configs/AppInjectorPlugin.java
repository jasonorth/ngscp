package configs;

import injector.SpringInjectorPlugin;
import play.Application;

public class AppInjectorPlugin extends SpringInjectorPlugin {

	public AppInjectorPlugin(Application app) {
		super(app);
	}

	@Override
	protected void config() {
		context.register(DataConfig.class);
		context.register(AppConfig.class);	
	}

	
}

