package plugins;

import java.util.Objects;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import play.Application;
import play.Play;
import play.api.Plugin;

public abstract class SpringPlugin implements Plugin {

	protected final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	protected final Application app;

	public static <T extends SpringPlugin> T plugin(Class<T> pluginType) {
		return Objects.requireNonNull(Play.application().plugin(pluginType), 
			String.format("You forgot to configure the '%s' plugin in conf/plugins", pluginType));				
	}

	public SpringPlugin(Application app) {
		this.app = app;
	}

	@Override
	public boolean enabled() {
		return true;
	}

	@Override
	public void onStart() {
		config();
		context.refresh();
	}

	@Override
	public void onStop() {
		context.close();
	}

	public ApplicationContext context() {
		return context;
	}
	
	public <T> T get(Class<T> type) {
		return context.getBean(type);
	}

	public <T> T get(String name, Class<T> type) {
		return context.getBean(name, type);
	}

	protected abstract void config();
}
