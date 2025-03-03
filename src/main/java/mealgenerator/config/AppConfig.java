package mealgenerator.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {


    @Bean
    public MongoClient mongoClient(@Value("${mongo.uri}") String mongoUri) {
        return MongoClients.create(mongoUri);
    }

    @Bean
    public MongoTemplate mongoTemplate(MongoClient mongoClient) {
        return new MongoTemplate(mongoClient, "mealdb");
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
