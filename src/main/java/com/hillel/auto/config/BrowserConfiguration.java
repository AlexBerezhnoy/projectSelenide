package com.hillel.auto.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env"})
public interface BrowserConfiguration extends Config {

    @DefaultValue("com.hillel.auto.providers.ChromeWebDriverProvider")
    @Key("remote.browser")
    String remoteChrome();
    @DefaultValue("com.hillel.auto.providers.FirefoxWebDriverProvider")
    @Key("remote.firefox")
    String remoteFirefox();

    @Key("browser.version")
    String browserVersion();
}
