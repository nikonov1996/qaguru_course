package demoqa.config;

import org.aeonbits.owner.Config;
@Config.Sources("classpath:demoqa/config/prod.properties")
public interface ProdConfig extends OwnerConfig {}
