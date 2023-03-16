package it.develhope.Redis1.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author Drumstyle92
 * Configuration class for Redis that will be used to
 * configure beans within the context of the application
 */
@Configuration
public class RedisConfiguration {

    /**
     * variable specifying the host
     */
    @Value("${redis.host}")
    private String redisHost;

    /**
     * variable that specifies the port
     */
    @Value("${redis.port}")
    private int redisPort;

    /**
     * variable specifying the password
     */
    @Value("${redis.password}")
    private String redisPassword;

    /**
     * variable specifying the name of the Redis database
     */
    @Value("${redis.database}")
    private String redisDatabase;

    /**
     * @return Returns the instance of RedisStandaloneConfiguration,
     * which specifies the configuration of the standalone Redis server
     * method annotated with @Bean, which is used to instantiate
     * JedisConnectionFactory, a class provided by Spring Data Redis
     * that provides a connection to the Redis server
     */
    @Bean
    JedisConnectionFactory jedisConnectionFactory() {

        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(redisHost, redisPort);

        redisStandaloneConfiguration.setPassword(RedisPassword.of(redisPassword));

        redisStandaloneConfiguration.setDatabase(0);

        return new JedisConnectionFactory(redisStandaloneConfiguration);

    }

    /**
     * @return Returns the RedisTemplate instance
     * Method used to perform CRUD (Create, Read, Update, Delete)
     * operations on the Redis database and that the correct connection
     * is used to access the Redis database
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate() {

        RedisTemplate<String, Object> template = new RedisTemplate<>();

        template.setConnectionFactory(jedisConnectionFactory());

        return template;

    }


}

