package com.socin.dto.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.socin.dto.DeveloperDto;
import com.socin.dto.DeveloperPageDto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DeveloperPageDeserializer  extends StdDeserializer<DeveloperPageDto> {

    public DeveloperPageDeserializer() {
        this(null);
    }

    public DeveloperPageDeserializer(Class<?> developerPage) {
        super(developerPage);
    }

    @Override
    public DeveloperPageDto deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {

        JsonNode node = jp.getCodec().readTree(jp);
        JsonNode items = node.get("items");

        DeveloperPageDto developerPageDto = new DeveloperPageDto();
        List<DeveloperDto> developerDtoList = new ArrayList<>();

        developerPageDto.setIncompleteResults(node.get("incomplete_results").asText());
        developerPageDto.setTotalCount(node.get("total_count").asText());
        developerPageDto.setItems(developerDtoList);

        if (items.isArray()) {
            for (final JsonNode item : items) {
                DeveloperDto developerDto = new DeveloperDto();

                developerDto.setLogin(item.get("login").asText());
                developerDto.setId(item.get("id").asText());
                developerDto.setNodeId(item.get("node_id").asText());
                developerDto.setAvatarUrl(item.get("avatar_url").asText());
                developerDto.setGravatarId(item.get("gravatar_id").asText());
                developerDto.setUrl(item.get("url").asText());
                developerDto.setHtmlUrl(item.get("html_url").asText());
                developerDto.setFollowersUrl(item.get("followers_url").asText());
                developerDto.setFollowingUrl(item.get("following_url").asText());
                developerDto.setGistsUrl(item.get("gists_url").asText());
                developerDto.setStarredUrl(item.get("starred_url").asText());
                developerDto.setSubscriptionsUrl(item.get("subscriptions_url").asText());
                developerDto.setOrganizationsUrl(item.get("organizations_url").asText());
                developerDto.setReposUrl(item.get("repos_url").asText());
                developerDto.setEventsUrl(item.get("events_url").asText());
                developerDto.setReceivedEventsUrl(item.get("received_events_url").asText());
                developerDto.setType(item.get("type").asText());
                developerDto.setSiteAdmin(item.get("site_admin").asText());
                developerDto.setScore(item.get("score").asText());

                developerDtoList.add(developerDto);
            }
        }

        return developerPageDto;
    }
}
