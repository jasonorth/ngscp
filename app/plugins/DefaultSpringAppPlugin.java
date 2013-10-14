package plugins;

import configs.AppConfig;
import configs.DataConfig;
import play.Application;

public class DefaultSpringAppPlugin extends SpringPlugin {

	public DefaultSpringAppPlugin(Application app) {
		super(app);
	}

	@Override
	protected void config() {
		context.register(DataConfig.class);
		context.register(AppConfig.class);		
	}

}
