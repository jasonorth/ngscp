package injector;

public interface InjectorApi {
	public <T> T get(Class<T> type);
	public <T> T get(String name, Class<T> type);
	 
}

