package teem11.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teem11.api.RiotgamesApiClient;
import teem11.domain.Summoner;
import teem11.repository.CurrentSummonerRepository;

import java.util.List;

@Service
@Slf4j
public class SummonerService {

    @Autowired
    private RiotgamesApiClient riotgamesApiClient;
    @Autowired
    private CurrentSummonerRepository currentSummonerRepository;

    public Summoner getCurrentSummonerIdBySummonerName(String summonerName) {//
        String summonerId;

        Summoner summoner = riotgamesApiClient.getSummonerId(summonerName);
        summonerId = summoner.getId();
        List<Summoner> summoner1 = riotgamesApiClient.getSummonerInfo(summonerId);
        for (int i = 0; i < summoner1.size(); i++) {
            log.info("{}", i);
            Summoner target = summoner1.get(i);
            target.setId(summoner.getId());
            target.setName(summoner.getName());
            currentSummonerRepository.insertOrUpdatedCurrentSummonerInfo(target);
        }
        return currentSummonerRepository.findCurrentSummonerBySummonerName(summonerId);
    }

}
