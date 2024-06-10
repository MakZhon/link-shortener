package org.zhenmax.linkshortener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.zhenmax.LoggingConfiguration;
import org.zhenmax.LoggingConfigurationGradle;
import org.zhenmax.linkshortener.dto.CreateShortLinkRequest;
import org.zhenmax.linkshortener.service.LinkInfoService;

import java.time.ZonedDateTime;


@SpringBootApplication
public class LinkShortenerApp {
    public static void main(String[] args) {
        LoggingConfiguration.testLog("Import from Maven Local");
        LoggingConfigurationGradle.testLog("Import from Gradle");
        LinkInfoService service = new LinkInfoService();
        var link = new CreateShortLinkRequest(
                "lolkek.com",
                ZonedDateTime.now(),
                "Some description",
                true);
        var linkInfo = service.createLinkInfo(link);
        System.out.println(service.getByShortLink(
                linkInfo.getShortLink()));
        SpringApplication.run(LinkShortenerApp.class);
    }
}