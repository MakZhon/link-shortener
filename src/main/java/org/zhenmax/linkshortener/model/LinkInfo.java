package org.zhenmax.linkshortener.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LinkInfo {
    private UUID id;
    private String shortLink;
    private long openingCount;
    private String link;
    private ZonedDateTime endTime;
    private String description;
    private Boolean active;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LinkInfo linkInfo)) return false;
        return Objects.equals(id, linkInfo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "LinkInfo{" +
                "id=" + id +
                ", shortLink='" + shortLink + '\'' +
                ", openingCount=" + openingCount +
                ", link='" + link + '\'' +
                ", endTime=" + endTime +
                ", description='" + description + '\'' +
                ", active=" + active +
                '}';
    }
}
