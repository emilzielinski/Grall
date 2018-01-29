package infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;


@Configuration
public class DataSourceConfiguration {

    @Bean
    public EmbeddedDatabase dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder
                .setType(EmbeddedDatabaseType.H2)
                .setName("ds")
                .addScript("classpath:db/create_table.sql")
                .addScript("classpath:db/insert_data.sql")
                .build();
    }

    @Bean
    public JdbcOperations jdbcOperations(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
