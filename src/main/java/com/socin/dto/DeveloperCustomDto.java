package com.socin.dto;

import java.util.List;

public class DeveloperCustomDto {
    private String draw;
    private String recordsTotal;
    private String recordsFiltered;
    private List<DeveloperDto> data;

    public String getDraw() {
        return draw;
    }

    public void setDraw(String draw) {
        this.draw = draw;
    }

    public String getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(String recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public String getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(String recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<DeveloperDto> getData() {
        return data;
    }

    public void setData(List<DeveloperDto> data) {
        this.data = data;
    }
}
