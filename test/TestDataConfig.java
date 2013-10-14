import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import play.db.DB;
import configs.DataConfig;

@Configuration
@EnableTransactionManagement
public class TestDataConfig extends DataConfig {
    
    @Bean
    @Override
    public DataSource dataSource() {
        return DB.getDataSource("test");
    }
    
}
