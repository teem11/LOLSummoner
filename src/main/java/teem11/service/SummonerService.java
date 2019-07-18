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

    public List<Summoner> getCurrentSummonerInformationsBySummonerName(String summonerName) {//
        String summonerId;

        Summoner summonerForGetId = riotgamesApiClient.getSummonerId(summonerName);
        summonerId = summonerForGetId.getId();
        List<Summoner> summonerInformationsForEachQueueType = riotgamesApiClient.getSummonerInfo(summonerId);
        for (int i = 0; i < summonerInformationsForEachQueueType.size(); i++) {
            Summoner summonerInformationForOneQueueType = summonerInformationsForEachQueueType.get(i);
            summonerInformationForOneQueueType.setId(summonerForGetId.getId());
            summonerInformationForOneQueueType.setName(summonerForGetId.getName());
            summonerInformationForOneQueueType.setIdAndQueueType(summonerInformationForOneQueueType.getId()+summonerInformationForOneQueueType.getQueueType());
            currentSummonerRepository.insertOrUpdatedCurrentSummonerInfo(summonerInformationForOneQueueType);
        }
        return currentSummonerRepository.findCurrentSummonerInfosBySummonerId(summonerId);
    }
}
