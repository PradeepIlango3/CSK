package interviews.ipl.computer;

import interviews.ipl.model.MatchInfo;
import interviews.ipl.model.TournamentTableRecord;

import java.util.List;

public interface TableComputer {
    public List<TournamentTableRecord> compute(List<MatchInfo> matchInfos);
}
