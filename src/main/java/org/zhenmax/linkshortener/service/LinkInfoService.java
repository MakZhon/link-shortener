package org.zhenmax.linkshortener.service;


import org.apache.commons.lang3.RandomStringUtils;
import org.zhenmax.linkshortener.dto.CreateShortLinkRequest;
import org.zhenmax.linkshortener.exceptions.NotFoundException;
import org.zhenmax.linkshortener.model.LinkInfo;
import org.zhenmax.linkshortener.repository.LinkInfoRepository;
import org.zhenmax.linkshortener.repository.impl.LinkInfoRepositoryImpl;

import static org.zhenmax.linkshortener.util.Constants.SHORT_LINK_LENGTH;

public class LinkInfoService {
    private LinkInfoRepository linkInfoRepository = new LinkInfoRepositoryImpl();

    public LinkInfo createLinkInfo(CreateShortLinkRequest request) {
        LinkInfo linkInfo = new LinkInfo();
        linkInfo.setLink(request.getLink());
        linkInfo.setEndTime(request.getEndTime());
        linkInfo.setDescription(request.getDescription());
        linkInfo.setActive(request.getActive());
        linkInfo.setShortLink(RandomStringUtils.randomAlphanumeric(SHORT_LINK_LENGTH));
        return linkInfoRepository.save(linkInfo);
    }

    public LinkInfo getByShortLink(String shortLink) {
        return linkInfoRepository.findByShortLink(shortLink)
                .orElseThrow(() -> new NotFoundException(
                        String.format("LinkInfo with current shortLink(%s) was not found", shortLink)));
    }

}
