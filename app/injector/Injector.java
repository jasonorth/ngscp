package injector;

import java.util.Objects;

import play.Play;

public class Injector {

	private static InjectorApi api() {
		InjectorPlugin plugin = Play.application().plugin(InjectorPlugin.class);
		Objects.requireNonNull(plugin, String.format(
				"You forgot to configure the '%s' plugin in conf/plugins",
				InjectorPlugin.class));
		return plugin.api();
	}

	public static <T> T get(Class<T> type) {
		return api().get(type);
	}

	public static <T> T get(String name, Class<T> type) {
		return api().get(name, type);
	}
	
}
