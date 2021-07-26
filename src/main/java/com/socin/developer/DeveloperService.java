package com.socin.developer;

import com.socin.dto.DeveloperCustomDto;
import com.socin.dto.DeveloperPageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeveloperService {

    private final DeveloperServelet developerServelet;

    private static final Integer DEFAULT_PER_PAGE = 100;

    @Autowired
    public DeveloperService(DeveloperServelet developerServelet) {
        this.developerServelet = developerServelet;
    }

    public DeveloperPageDto findDevelopers(Integer page) {
        if (page < 1) {
            page = 1;
        }

        return developerServelet.getDevelopers(page, DEFAULT_PER_PAGE);
    }

    public DeveloperCustomDto findCustomDevelopers(Integer draw, Integer startPage, Integer lengthPage) {
        Integer page = (startPage / lengthPage) + 1;

        DeveloperPageDto developerPageDto = developerServelet.getDevelopers(page, lengthPage);
        DeveloperCustomDto developerCustomDto = new DeveloperCustomDto();

        developerCustomDto.setDraw(draw.toString());
        developerCustomDto.setData(developerPageDto.getItems());
        developerCustomDto.setRecordsTotal(developerPageDto.getTotalCount());
        developerCustomDto.setRecordsFiltered(developerPageDto.getTotalCount());

        return developerCustomDto;
    }
}
