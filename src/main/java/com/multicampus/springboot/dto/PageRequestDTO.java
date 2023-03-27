package com.multicampus.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageRequestDTO {

    @Builder.Default
    @Min(value=1)
    @Positive
    private int page = 1;

    @Builder.Default
    @Min(value=10)
    @Max(value=100)
    @Positive
    private int size = 10;

    private String link;
    private String[] types;
    private String searchContent;
    private boolean finished;
    private String startDate;
    private String endDate;

    public int getSkip() {
        return (page-1)*10;
    }
    public String getLink() {
        if(link == null) {
            StringBuilder builder = new StringBuilder();

            builder.append("page="+this.page);
            builder.append("&size="+this.size);
            link=builder.toString();
        }
        return link;
    }

}
