package org.zhenmax.linkshortener.service.impl;


import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.zhenmax.linkshortener.dto.CreateShortLinkRequest;
import org.zhenmax.linkshortener.exceptions.NotFoundException;
import org.zhenmax.linkshortener.model.LinkInfo;
import org.zhenmax.linkshortener.repository.LinkInfoRepository;
import org.zhenmax.linkshortener.service.LinkInfoService;

@Component
@Qualifier("linkInfoService")
public class LinkInfoServiceImpl implements LinkInfoService {
    private final LinkInfoRepository linkInfoRepository;
    @Value("${link-shortener.short-link-length}")
    private int shortLinkLength;

    @Autowired
    public LinkInfoServiceImpl(LinkInfoRepository linkInfoRepository) {
        this.linkInfoRepository = linkInfoRepository;
    }

    @Override
    public LinkInfo createLinkInfo(CreateShortLinkRequest request) {
        LinkInfo linkInfo = new LinkInfo();
        linkInfo.setLink(request.getLink());
        linkInfo.setEndTime(request.getEndTime());
        linkInfo.setDescription(request.getDescription());
        linkInfo.setActive(request.getActive());
        linkInfo.setShortLink(RandomStringUtils.randomAlphanumeric(shortLinkLength));
        return linkInfoRepository.save(linkInfo);
    }

    @Override
    public LinkInfo getByShortLink(String shortLink) {
        return linkInfoRepository.findByShortLink(shortLink)
                .orElseThrow(() -> new NotFoundException(
                        "LinkInfo with current shortLink(%s) was not found".formatted(shortLink)));
    }

}
