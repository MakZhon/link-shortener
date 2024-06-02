package org.zhenmax.linkshortener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.zhenmax.linkshortener.dto.CreateShortLinkRequest;
import org.zhenmax.linkshortener.service.LinkService;

@SpringBootApplication
public class LinkShortenerApp {
    public static void main(String[] args) {
        SpringApplication.run(LinkShortenerApp.class);
        LinkService service = new LinkService();
        System.out.println(service.generateShortLink(new CreateShortLinkRequest()));
    }
}