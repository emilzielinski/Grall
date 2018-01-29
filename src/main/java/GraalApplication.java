import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableAutoConfiguration
@ComponentScan("infrastructure")
public class GraalApplication {
    public static void main(String[] args){
        new SpringApplicationBuilder(GraalApplication.class).run(args);
    }
}
