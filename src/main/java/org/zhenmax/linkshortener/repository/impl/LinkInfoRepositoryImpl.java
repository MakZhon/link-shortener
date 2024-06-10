package org.zhenmax.linkshortener.repository.impl;

import org.zhenmax.linkshortener.model.LinkInfo;
import org.zhenmax.linkshortener.repository.LinkInfoRepository;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class LinkInfoRepositoryImpl implements LinkInfoRepository {
    private ConcurrentHashMap<String, LinkInfo> linkInfoMap = new ConcurrentHashMap<>();

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