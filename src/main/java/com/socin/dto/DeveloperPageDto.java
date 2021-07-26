package com.socin.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.socin.dto.deserializer.DeveloperPageDeserializer;

import java.util.List;

@JsonDeserialize(using = DeveloperPageDeserializer.class)
public class DeveloperPageDto {

    private String totalCount;
    private String incompleteResults;
    private List<DeveloperDto> items;

    public DeveloperPageDto() {
        super();
    }
    public DeveloperPageDto(String totalCount,
            String incompleteResults,
            List<DeveloperDto> items) {

        this.totalCount = totalCount;
        this.incompleteResults = incompleteResults;
        this.items = items;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    public String getIncompleteResults() {
        return incompleteResults;
    }

    public void setIncompleteResults(String incompleteResults) {
        this.incompleteResults = incompleteResults;
    }

    public List<DeveloperDto> getItems() {
        return items;
    }

    public void setItems(List<DeveloperDto> items) {
        this.items = items;
    }
}
