package demoqa.config;

import org.aeonbits.owner.Config;

public class ConfigFactory {
    public static OwnerConfig useConfig(){
        String env = System.getProperty("env","prod");
        OwnerConfig config = null;
        switch (env){
            case "prod":
                config = org.aeonbits.owner.ConfigFactory.create(ProdConfig.class);
                break;
            case "dev":
                config = org.aeonbits.owner.ConfigFactory.create(DevConfig.class);
                break;
        }
        return config;

    }
}
