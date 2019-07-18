package teem11.repository;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import teem11.domain.Summoner;

import java.util.List;

@Repository
public class CurrentSummonerRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Summoner insertOrUpdatedCurrentSummonerInfo(Summoner summoner) {
        return mongoTemplate.save(summoner);
    }

    public List<Summoner> findCurrentSummonerInfosBySummonerId(String summonerId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("summonerId").is(summonerId));
        return mongoTemplate.find(query, Summoner.class);
    }
}
