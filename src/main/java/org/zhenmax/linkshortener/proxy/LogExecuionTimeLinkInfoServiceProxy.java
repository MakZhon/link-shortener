package org.zhenmax.linkshortener.proxy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhenmax.linkshortener.dto.CreateShortLinkRequest;
import org.zhenmax.linkshortener.model.LinkInfo;
import org.zhenmax.linkshortener.service.LinkInfoService;

@Slf4j
@Service(value = "linkInfoServiceProxy")
public class LogExecuionTimeLinkInfoServiceProxy implements LinkInfoService{
    private final LinkInfoService linkInfoService;

    @Autowired
    public LogExecuionTimeLinkInfoServiceProxy(LinkInfoService linkInfoService) {
        this.linkInfoService = linkInfoService;
    }

    @Override
    public LinkInfo createLinkInfo(CreateShortLinkRequest request) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        try {
            return linkInfoService.createLinkInfo(request);
        } finally {
            stopWatch.stop();
            log.info("Time execution createLinkInfo: {} мс", stopWatch.getTotalTimeMillis());
        }
    }

    @Override
    public LinkInfo getByShortLink(String shortLink) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        try {
            return linkInfoService.getByShortLink(shortLink);
        } finally {
            stopWatch.stop();
            log.info("Time execution getByShortLink: {} мс", stopWatch.getTotalTimeMillis());
        }
    }
}
