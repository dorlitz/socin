package com.socin.developer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.socin.dto.DeveloperPageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

@Service
public class DeveloperServelet {

    private static final Logger logger = LoggerFactory.getLogger(DeveloperServelet.class);

    private final String messageLogFail = "Failed to get developers | Details: {}";

    @Autowired
    protected RestTemplateBuilder restTemplateBuilder;

    public DeveloperPageDto getDevelopers(Integer page, Integer perPage) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Accept", "application/vnd.github.v3+json");

        HttpEntity<Object> request = new HttpEntity<>(headers);
        byte[] response;
        ObjectMapper mapper = new ObjectMapper();

        try {
            String url = DeveloperUrlEnum.URL_SEARCH_DEVS.getUrlValue().
                    concat("?q=followers:>0+repos:>1&page=").concat(page.toString())
                    .concat("&per_page=").concat(perPage.toString());

            ResponseEntity<byte[]> responseEntity = restTemplateBuilder.build().exchange(url,
                    HttpMethod.GET, request, byte[].class);

            response = responseEntity.getBody();

            InputStream inputStream = new ByteArrayInputStream(response);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            DeveloperPageDto developerPageDto = mapper.readValue(bufferedReader, DeveloperPageDto.class);

            return developerPageDto;

        } catch (HttpClientErrorException e) {
            e.printStackTrace();
            String message = messageLogFail.concat(" - {}");
            logger.error(messageLogFail, e.getMessage(), e.getResponseBodyAsString());
            return null;
        } catch (HttpStatusCodeException e) {
            e.printStackTrace();
            logger.error(messageLogFail, e.getResponseBodyAsString());
            throw e;
        }
        catch (ClassCastException e) {
            e.printStackTrace();
            throw  e;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(messageLogFail, e.getMessage());
            return null;
        }
    }
}
