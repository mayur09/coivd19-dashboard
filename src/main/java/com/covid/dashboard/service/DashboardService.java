package com.covid.dashboard.service;

import com.covid.dashboard.model.CaseReport;

import java.util.List;

public interface DashboardService {

    CaseReport getDataForIndia();

    List<CaseReport> getAllStatesData();
}
