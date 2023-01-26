package alex.klimchuk.di.assignment.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

/**
 * Copyright Alex Klimchuk (c) 15.01.2022.
 */
@ConstructorBinding
@ConfigurationProperties("spring.data")
public class SfgDiConstructorConfig {

    private String username;
    private String password;
    private String jdbcUrl;

    public SfgDiConstructorConfig(String username, String password, String jdbcUrl) {
        this.username = username;
        this.password = password;
        this.jdbcUrl = jdbcUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

}
