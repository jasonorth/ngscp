package injector;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import play.Application;

public abstract class SpringInjectorPlugin extends InjectorPlugin {

	protected static final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	private static final SpringInjectorApi api = new SpringInjectorApi(context);
	
	public SpringInjectorPlugin(Application app) {
		super(app);
	}

	@Override
	public void onStart() {
		context.getEnvironment().setActiveProfiles(activeProfiles());
		config();
		context.refresh();
	}

	@Override
	public void onStop() {
		context.close();
	}

	abstract protected void config();

	protected String[] activeProfiles() {
		String[] profile = new String[1];
		if (app.isDev())
			profile[0] = "dev";
		if (app.isTest())
			profile[0] = "test";
		if (app.isProd())
			profile[0] = "prod";
		return profile;
	}

	@Override
	public SpringInjectorApi api() {
		return api;
	}

	public static class SpringInjectorApi implements InjectorApi {

		private AnnotationConfigApplicationContext ctx;

		private SpringInjectorApi(AnnotationConfigApplicationContext ctx) {
			this.ctx = ctx;
		}

		public ApplicationContext context() {
			return ctx;
		}

		@Override
		public <T> T get(Class<T> type) {
			return ctx.getBean(type);
		}

		@Override
		public <T> T get(String name, Class<T> type) {
			return ctx.getBean(name, type);
		}

	}
}
