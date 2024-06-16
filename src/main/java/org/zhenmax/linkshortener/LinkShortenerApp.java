package org.zhenmax.linkshortener;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.zhenmax.LoggingConfiguration;
import org.zhenmax.LoggingConfigurationGradle;
import org.zhenmax.linkshortener.dto.CreateShortLinkRequest;
import org.zhenmax.linkshortener.service.LinkInfoService;

import java.time.ZonedDateTime;


@SpringBootApplication
public class LinkShortenerApp {
    @Autowired
    @Qualifier("linkInfoServiceProxy")
    private LinkInfoService linkInfoServiceProxy;

    @PostConstruct
    public void create() {
        var link = new CreateShortLinkRequest(
                "lolkek.com",
                ZonedDateTime.now(),
                "Some description",
                true);

        System.out.println(linkInfoServiceProxy.getByShortLink(
                linkInfoServiceProxy.createLinkInfo(link).getShortLink()));
    }
    public static void main(String[] args) {
        LoggingConfiguration.testLog("Import from Maven Local");
        LoggingConfigurationGradle.testLog("Import from Gradle");
        SpringApplication.run(LinkShortenerApp.class);
    }
}