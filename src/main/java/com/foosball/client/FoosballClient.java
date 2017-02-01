package com.foosball.client;

import java.util.Scanner;
import java.util.StringTokenizer;

import com.foosball.model.TeamMatch;
import com.foosball.service.FoosballReportingService;
import com.foosball.service.FoosballReportingServiceImpl;
import com.foosball.service.FoosballService;
import com.foosball.service.FoosballServiceImpl;

public class FoosballClient {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			FoosballService foosballService = new FoosballServiceImpl();
			FoosballReportingService foosballReportingService = new FoosballReportingServiceImpl();
			
			// Asking user to enter the participants.
			System.out.println("Please enter participant id. Press x when done.");
			while (true) {
				String id = scanner.nextLine();
				if (id.equalsIgnoreCase("X")) {
					break;
				}
				foosballService.addParticipant(id);
			}
			System.out.println(" You added following participants:"
					+ foosballService.getAllParticipants());

			// Asking user to enter matches held.
			while (true) {
				System.out
						.println("Please enter the matches held. example - for match between 1 and 2, enter 1-2. Press x when done");
				String matchTeam = scanner.nextLine();
				if (matchTeam.equalsIgnoreCase("X")) {
					break;
				}
				StringTokenizer stringTokenizer = new StringTokenizer(
						matchTeam, "-");
				if (stringTokenizer.countTokens() != 2) {
					System.out
							.println("Invalid entry. Please enter match in format 1-2");
					continue;
				}
				String team1 = stringTokenizer.nextToken();
				String team2 = stringTokenizer.nextToken();
				if (!foosballService.getAllParticipants().contains(team1)
						|| !foosballService.getAllParticipants()
								.contains(team2)) {
					System.out
							.println("Invalid entry. Please enter valid team ids.");
					continue;
				}
				TeamMatch teamMatch = new TeamMatch(team1, team2);

				while (true) {
					System.out.println("Please enter winning team id.");
					String winningTeam = scanner.nextLine();
					if (!winningTeam.equals(team1)
							&& !winningTeam.equals(team2)) {
						System.out.println("Invalid team id entered");
						continue;
					}
					teamMatch.setWinningTeam(winningTeam);
					foosballService.addTeamMatch(teamMatch);
					break;
				}
			}

			// Asking user about the kind of statistics they would like to see.
			while (true) {
				System.out.println("\nReporting Options:");
				System.out
						.println("Press 1 for overall win/loss ratio of a participant");
				System.out
						.println("Press 2 for win/loss ratio of a participant against another participant");
				System.out.println("Press x to exit");

				String option = scanner.nextLine();
				if (option.equalsIgnoreCase("x")) {
					break;
				} else if (option.equals("1")) {
					System.out
							.println("Please enter the participant id to report overall win/loss ratio");
					String id = scanner.nextLine();
					System.out.println("Participant "
							+ id
							+ " has a win/loss ratio of: "
							+ foosballReportingService
									.getWinLossRateOfParticipant(id) + "%");
					continue;
				} else if (option.equals("2")) {
					System.out
							.println("Please enter the participant id to report win ratio on another participant");
					String participant1 = scanner.nextLine();
					System.out
							.println("Please enter the opponent participant id:");
					String participant2 = scanner.nextLine();
					System.out.println("Participant "
							+ participant1
							+ " has a win ratio of: "
							+ foosballReportingService
									.getComparativeWinLossRateOfParticipants(
											participant1, participant2)
							+ "% over " + participant2);
					continue;
				} else {
					System.out.println("Invalid option entered");
					continue;
				}

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			scanner.close();
		}
	}
}
