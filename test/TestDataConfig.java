import configs.DataConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import play.Logger;
import play.db.*;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class TestDataConfig extends DataConfig {
    
    @Bean
    @Override
    public DataSource dataSource() {
        return DB.getDataSource("test");
    }
    
}
