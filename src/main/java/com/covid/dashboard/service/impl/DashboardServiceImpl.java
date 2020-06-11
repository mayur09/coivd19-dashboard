package com.covid.dashboard.service.impl;

import com.covid.dashboard.model.CaseReport;
import com.covid.dashboard.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class DashboardServiceImpl implements DashboardService {

    private static final String BASE_URL = "http://covid19-india-adhikansh.herokuapp.com";
    @Autowired
    RestTemplate restTemplate;


    @Override
    public CaseReport getDataForIndia() {
        Map<String, Integer> map = (Map<String, Integer>) restTemplate.exchange(BASE_URL + "/summary", HttpMethod.GET, null, Object.class).getBody();
        CaseReport caseCounts = new CaseReport();
        caseCounts.setActive(map.get("Active cases"));
        caseCounts.setDeath(map.get("Death"));
        caseCounts.setCured(map.get("Cured/Discharged/Migrated"));
        caseCounts.setTotal(map.get("Total Cases"));
        return caseCounts;
    }

    @Override
    public List<CaseReport> getAllStatesData() {
        return ((Map<String, List<CaseReport>>) restTemplate.exchange(BASE_URL + "/states", HttpMethod.GET, null, Object.class).getBody()).get("state");
    }


}
