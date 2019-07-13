package teem11.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teem11.api.RiotgamesApiClient;
import teem11.domain.Summoner;

@Service
@Slf4j
public class SummonerService {

    @Autowired
    private RiotgamesApiClient riotgamesApiClient;

    public Summoner getCurrentSummonerIdBySummonerName(String summonerName) {//
        String summonerId;

        Summoner summoner = riotgamesApiClient.getSummonerId(summonerName);
        summonerId = summoner.getId();
        return summoner;
    }
}
