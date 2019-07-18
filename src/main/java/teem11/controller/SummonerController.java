package teem11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import teem11.domain.Summoner;
import teem11.service.SummonerService;

import java.util.List;

@RestController
@RequestMapping("/lol-summoner")
public class SummonerController {

    @Autowired
    private SummonerService summonerService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/by-summonerName/{summonerName}")
    public List<Summoner> getCurrentSummonerInfo(@PathVariable String summonerName) {
        return summonerService.getCurrentSummonerInformationsBySummonerName(summonerName);
    }
}
