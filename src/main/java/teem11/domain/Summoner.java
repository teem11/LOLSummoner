package teem11.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Summoner {

    @Id
    private String name;
    private String id;
    private String queueType;
    private String summonerName;
    private Boolean hotStreak;
    private int wins;
    private Boolean veteran;
    private int losses;
    private String rank;
    private String tier;
    private Boolean inactive;
    private Boolean freshBlood;
    private String leagueId;
    private String summonerId;
    private int leaguePoints;

}