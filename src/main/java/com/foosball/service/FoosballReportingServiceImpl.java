package com.foosball.service;

import java.util.List;

import com.foosball.dao.FoosballDAO;
import com.foosball.dao.FoosballDAOImpl;
import com.foosball.model.MatchReport;
import com.foosball.model.ParticipantMatchReport;
import com.foosball.model.TeamMatch;

/**
 * The Service to generate reports based on participants and matches held among them.  
 */
public class FoosballReportingServiceImpl implements FoosballReportingService {

	FoosballDAO foosballDAO = FoosballDAOImpl.getInstance();

	/**
	 * Calculates the win/loss % of a particular participant  
	 *
	 * @param  participant The participant name in String format
	 * @return Integer win/loss %
	 */
	public Integer getWinLossRateOfParticipant(String participant) {
		if (participant == null) {
			System.out.println("Please enter a valid participant Id");
			return new Integer(0);
		}

		ParticipantMatchReport matchReport = new ParticipantMatchReport(
				participant);
		
		List<TeamMatch> allMatches = foosballDAO.getAllMatches();

		for (TeamMatch teamMatch : allMatches) {

			if (teamMatch.isParticipant(participant)) {
				matchReport.incrementMatchPlayed();
			}
			if (participant.equals(teamMatch.getWinningTeam())) {
				matchReport.incrementMatchWon();
			}
		}

		return matchReport.getWinLossPercentage();

	}

	/**
	 * Calculates the win/loss % of one participant against the other  
	 *
	 * @param  participant1 The first participant name in String format
	 * @param  participant2 The second participant name in String format
	 * @return Integer comparative win/loss %
	 */
	public Integer getComparativeWinLossRateOfParticipants(String participant1,
			String participant2) {
		if (participant1 == null || participant2 == null) {
			System.out.println("Please enter a valid participant Ids");
			return new Integer(0);
		}

		List<TeamMatch> allMatches = foosballDAO.getAllMatches();
		MatchReport matchReport = new MatchReport(participant1, participant2);
		for (TeamMatch teamMatch : allMatches) {
			if(teamMatch.isParticipant(participant1) 
					&& teamMatch.isParticipant(participant2)) {
				matchReport.incrementParticipantWonCount(teamMatch.getWinningTeam());
				
			}
		}
		return matchReport.getWinPercentageFor(participant1, participant2);
	}
}
