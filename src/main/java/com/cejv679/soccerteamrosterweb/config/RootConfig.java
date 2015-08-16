package com.cejv679.soccerteamrosterweb.config;

import com.cejv679.soccerteamrosterweb.config.RootConfig.WebPackage;
import java.util.regex.Pattern;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.type.filter.RegexPatternTypeFilter;

@Configuration
//@Import(DataConfig.class)
@ComponentScan(basePackages={"com.cejv679.soccerteamrosterweb"}, 
    excludeFilters={
        @Filter(type=FilterType.CUSTOM, value=WebPackage.class)
    })
public class RootConfig {
  public static class WebPackage extends RegexPatternTypeFilter {
    public WebPackage() {
      super(Pattern.compile("footballapp\\.web"));
    }    
  }
}
