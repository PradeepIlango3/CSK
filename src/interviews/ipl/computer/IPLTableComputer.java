package interviews.ipl.computer;

import interviews.ipl.model.MatchInfo;
import interviews.ipl.model.IPLMatchInfo;
import interviews.ipl.model.IPLTournamentTableRecord;
import interviews.ipl.model.TournamentTableRecord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IPLTableComputer implements TableComputer {
    @Override
    public List<TournamentTableRecord> compute(List<MatchInfo> matchInfos) {
        //Team Name | Matches Played | Win | Loss | Draw | Total Points
        Map<String, Integer> wins = new HashMap<>();
        Map<String, Integer> loss = new HashMap<>();
        Map<String, Integer> draw = new HashMap<>();
        Map<String, Integer> matchesPlayed = new HashMap<>();
        for (MatchInfo info: matchInfos) {
            String result = ((IPLMatchInfo) info).result;;
            String op1 = ((IPLMatchInfo) info).winnningTeam;
            String op2 = ((IPLMatchInfo) info).lossingTeam;
            matchesPlayed.putIfAbsent(op1, 0);
            matchesPlayed.putIfAbsent(op2, 0);
            wins.putIfAbsent(op1, 0);
            wins.putIfAbsent(op2, 0);
            loss.putIfAbsent(op1, 0);
            loss.putIfAbsent(op2, 0);
            draw.putIfAbsent(op1, 0);
            draw.putIfAbsent(op2, 0);
            matchesPlayed.put(op1, matchesPlayed.get(op1) + 1);
            matchesPlayed.put(op2, matchesPlayed.get(op2) + 1);
            if (result.equals("W")) {
                wins.put(op1, matchesPlayed.get(op1) + 1);
                loss.put(op2, matchesPlayed.get(op2) + 1);
            } else if (result.equals("L")) {
                wins.put(op1, matchesPlayed.get(op2) + 1);
                loss.put(op2, matchesPlayed.get(op1) + 1);
            } else {
                draw.put(op1, draw.get(op1) + 1);
                draw.put(op2, draw.get(op2) + 1);
            }
        }
        List<TournamentTableRecord> tables = new ArrayList<>();
        for (Map.Entry<String , Integer> match: matchesPlayed.entrySet()) {
            IPLTournamentTableRecord table = new IPLTournamentTableRecord();
            table.setTeamName(match.getKey());
            table.setWins(wins.get(match.getKey()));
            table.setLoss(loss.get(match.getKey()));
            table.setMatchesPlayed(match.getValue());
            table.setPoints(table.wins*3 + table.draw*1);
            tables.add(table);
        }
        return tables;
    }
}
