package demoqa.config;

import org.aeonbits.owner.Config;

public interface OwnerConfig extends Config {
    String login();
    String password();
    String baseUrl();
    String textBoxEndpoint();
}
