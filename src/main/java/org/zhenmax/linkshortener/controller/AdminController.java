package org.zhenmax.linkshortener.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zhenmax.linkshortener.dto.CreateShortLinkRequest;
import org.zhenmax.linkshortener.dto.CreateShortLinkResponse;
import org.zhenmax.linkshortener.dto.common.CommonRequest;
import org.zhenmax.linkshortener.dto.common.CommonResponse;
import org.zhenmax.linkshortener.service.LinkInfoService;

@Slf4j
@RestController
@RequestMapping("/api/v1/link-infos")
@RequiredArgsConstructor
public class AdminController {
    private final LinkInfoService linkInfoService;

    @PostMapping()
    public CommonResponse<CreateShortLinkResponse> postCreateShortLink(@RequestBody CommonRequest<CreateShortLinkRequest> request) {
        log.info("Поступил запрос на создание короткой ссылки: {}", request);

        CreateShortLinkResponse createShortLinkResponse = linkInfoService.createLinkInfo(request.getBody());

        return CommonResponse.<CreateShortLinkResponse>builder()
                .body(createShortLinkResponse)
                .build();
    }
}
