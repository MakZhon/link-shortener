package org.zhenmax.linkshortener.repository.impl;

import org.springframework.stereotype.Repository;
import org.zhenmax.linkshortener.model.LinkInfo;
import org.zhenmax.linkshortener.repository.LinkInfoRepository;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class LinkInfoRepositoryImpl implements LinkInfoRepository {
    private final Map<String, LinkInfo> linkInfoMap = new ConcurrentHashMap<>();

    @Override
    public Optional<LinkInfo> findByShortLink(String shortLink) {
        LinkInfo linkInfo = linkInfoMap.get(shortLink);
        return Optional.ofNullable(linkInfo);
    }

    @Override
    public LinkInfo save(LinkInfo linkInfo) {
        linkInfo.setId(UUID.randomUUID());
        linkInfoMap.put(linkInfo.getShortLink(), linkInfo);
        return linkInfo;
    }
}
