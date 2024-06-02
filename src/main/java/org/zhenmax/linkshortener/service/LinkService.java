package org.zhenmax.linkshortener.service;


import org.apache.commons.lang3.RandomStringUtils;
import org.zhenmax.linkshortener.dto.CreateShortLinkRequest;

import static org.zhenmax.linkshortener.util.Constants.SHORT_LINK_LENGTH;

public class LinkService {

    public String generateShortLink(CreateShortLinkRequest request) {

        return RandomStringUtils.randomAlphanumeric(SHORT_LINK_LENGTH);
    }

}
