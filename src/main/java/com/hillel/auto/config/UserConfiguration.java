package com.hillel.auto.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:test.properties",
        "system:properties",
        "system:env"})
public interface UserConfiguration extends Config {

    @DefaultValue("default_Name")
    @Key("user.name")
    String name();
    @Key("user.email")
    String email();
    @Key("user.password")
    String password();
    @DefaultValue("ADMIN")
    @Key("user.role")
    String role();
}
