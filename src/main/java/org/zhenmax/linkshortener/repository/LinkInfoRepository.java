package org.zhenmax.linkshortener.repository;

import org.zhenmax.linkshortener.model.LinkInfo;

import java.util.Optional;

public interface LinkInfoRepository {

    Optional<LinkInfo> findByShortLink(String shortLink);

    LinkInfo save(LinkInfo linkInfo);
}
