package configs;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import play.db.DB;

@Configuration
@EnableTransactionManagement
public class DataConfig {

    @Bean
    public DataSource dataSource() {
        return DB.getDataSource();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
    	DataSourceTransactionManager tm = new DataSourceTransactionManager(dataSource());
    	tm.setGlobalRollbackOnParticipationFailure(false);
    	return tm;
    }
}