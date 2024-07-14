package org.zhenmax.linkshortener.service;

import org.zhenmax.linkshortener.dto.CreateShortLinkRequest;
import org.zhenmax.linkshortener.dto.CreateShortLinkResponse;
import org.zhenmax.linkshortener.model.LinkInfo;

public interface LinkInfoService {
    CreateShortLinkResponse createLinkInfo(CreateShortLinkRequest request);

    LinkInfo getByShortLink(String shortLink);
}
