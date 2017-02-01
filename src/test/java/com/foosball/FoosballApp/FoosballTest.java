package com.foosball.FoosballApp;

import junit.framework.TestCase;

import com.foosball.dao.FoosballDAO;
import com.foosball.dao.FoosballDAOImpl;
import com.foosball.model.TeamMatch;
import com.foosball.service.FoosballReportingService;
import com.foosball.service.FoosballReportingServiceImpl;
import com.foosball.service.FoosballService;
import com.foosball.service.FoosballServiceImpl;

public class FoosballTest extends TestCase {
	FoosballDAO foosballDAO = FoosballDAOImpl.getInstance();
	FoosballReportingService report = new FoosballReportingServiceImpl();
	FoosballService foosballService = new FoosballServiceImpl();

	public FoosballTest(String testName) {
		super(testName);
	}

	public void testApp() {
		
		for(int i=1; i<=5; i++) {
			addParticipant(String.valueOf(i));
		}
		
		createTeamMatch("1", "2", "1");
		createTeamMatch("1", "3", "1");
		createTeamMatch("1", "2", "2");
		createTeamMatch("1", "2", "1");
		createTeamMatch("3", "2", "2");

		assertNotNull(foosballService.getAllParticipants().size());
		assertNotNull(foosballService.getAllMatches().size());
		assertEquals(75, report.getWinLossRateOfParticipant("1").intValue());
		assertEquals(67, report.getComparativeWinLossRateOfParticipants("1", "2").intValue());
	}

	private TeamMatch createTeamMatch(String team1, String team2, String winningTeam) {
		TeamMatch teamMatch = new TeamMatch(team1, team2);
		teamMatch.setWinningTeam(winningTeam);
		foosballDAO.addTeamMatch(teamMatch);
		return teamMatch;
	}
	
	private void addParticipant(String participant) {
		foosballDAO.addParticipant(participant);
	}
}
