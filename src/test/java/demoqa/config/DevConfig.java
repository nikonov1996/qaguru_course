package demoqa.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:demoqa/config/dev.properties")
public interface DevConfig extends OwnerConfig {}
