package org.zhenmax.linkshortener.dto.common;

import lombok.Data;

@Data
public class CommonRequest<T> {

    private T body;
}
