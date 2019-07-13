package teem11.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import teem11.domain.Summoner;

@Service
public class RiotgamesApiClient {

    @Autowired
    private RestTemplate restTemplate;

    private final String apiKey = "RGAPI-f222eb69-a724-48bd-a18a-48ea4e8d7148";
    private final String currentSummonerUri = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{summonerName}?api_key={apiKey}";

    public Summoner getSummonerId(String summonerName) {
        Summoner summonerId = restTemplate.exchange(currentSummonerUri, HttpMethod.GET, null, Summoner.class, summonerName, apiKey).getBody();
        return summonerId;
    }

}
