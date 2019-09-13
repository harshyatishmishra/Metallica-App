package com.metallica.tradingService.controllers;

import com.metallica.tradingService.entities.TradingEntity;
import com.metallica.tradingService.etc.TradeStatus;
import com.metallica.tradingService.service.RabbitMQSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
public class TradingRESTController {

    @Autowired
    RabbitMQSender rabbitMQSender;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    DiscoveryClient discoveryClient;
    List<TradingEntity> tradeEntityList = new ArrayList<TradingEntity>();

    /**
     * adds new Trading Entity to trading data table.
     *
     * @param newTrade
     */
    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> addTrade(@RequestBody TradingEntity newTrade) {
        newTrade.setStatus(TradeStatus.OPEN);
        String commodity = newTrade.getCommodity();
        String url = discoveryClient.getInstances("netflix-zuul-api-gateway-service").get(0).getUri().toString();
        url += "/marketing-service/getPrice/";
        double price = restTemplate.getForObject(url + commodity, Double.class);
        System.out.println("Price " + price);
        tradeEntityList.add(newTrade);
       // rabbitMQSender.send(newTrade);
        return new ResponseEntity<>("Successfully added new trade", HttpStatus.ACCEPTED);
    }

    /**
     * delete the trade order that corresponds to the id input if and
     * only if the trade status is open.
     *
     * @param id
     */
    @RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteTrade(@PathVariable("id") int id) {

        boolean deleted = tradeEntityList.removeIf(trade -> trade.getId() == id && trade.getStatus() == TradeStatus.OPEN);
        if (deleted)
            return new ResponseEntity<String>(HttpStatus.OK);
        return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
    }

    /**
     * finds all the entries in the data table "trading_data"
     * and returns them as a list.
     *
     * @return list of trading entities
     */
    @RequestMapping(path = "/findAll", method = RequestMethod.GET)
    public List<TradingEntity> getAllTrades() {
        return tradeEntityList;
    }

}
