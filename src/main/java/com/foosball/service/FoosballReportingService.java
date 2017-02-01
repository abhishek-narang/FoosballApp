package com.foosball.service;

public interface FoosballReportingService {
	
	public Integer getWinLossRateOfParticipant(String participant);
	
	public Integer getComparativeWinLossRateOfParticipants(String participant1, String participant2);
}
