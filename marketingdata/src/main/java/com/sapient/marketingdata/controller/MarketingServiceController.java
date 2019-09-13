package com.sapient.marketingdata.controller;

import com.sapient.marketingdata.entity.MarketingDataEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@CrossOrigin("*")
public class MarketingServiceController {

    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public int getPrice() {
        return 0;
    }

    @RequestMapping(path = "/getPrice/{commodity}", method = RequestMethod.GET)
    public double getPrice(@PathVariable("commodity") String commodity) {
        List<MarketingDataEntity> marketData = addMarketData();

        List<MarketingDataEntity> marketDataEntity = marketData.stream()
                .filter(data -> data.getIdentifier().equals(commodity))
                .collect(Collectors.toList());
//                .collect(toSingleton());
        return marketDataEntity.get(0).getPrice();
    }

    public List<MarketingDataEntity> addMarketData() {
        List<MarketingDataEntity> newMarketData = new ArrayList<MarketingDataEntity>();
        newMarketData.add(new MarketingDataEntity("Gold", "GO", 200, true));
        newMarketData.add(new MarketingDataEntity("Silver", "SL", 100, true));
        newMarketData.add(new MarketingDataEntity("Palladium", "PA", 600, true));
        newMarketData.add(new MarketingDataEntity("Aluminium", "AL", 700, true));
        newMarketData.add(new MarketingDataEntity("Adamantium", "AD", 500, true));
        newMarketData.add(new MarketingDataEntity("Uranium", "UR", 520, true));
        newMarketData.add(new MarketingDataEntity("Vibranium", "VB", 700, true));
        return newMarketData;
    }
}
