package interviews.ipl;

import interviews.ipl.computer.IPLTableComputer;
import interviews.ipl.computer.TableComputer;
import interviews.ipl.computer.TableComputerFactory;
import interviews.ipl.model.MatchInfo;
import interviews.ipl.model.TournamentTableRecord;
import interviews.ipl.model.TournamentType;
import interviews.ipl.parser.IPLParser;
import interviews.ipl.parser.Parser;
import interviews.ipl.parser.ParserFactory;

import java.io.File;
import java.util.List;

public class TournamentService {

    public static void main(String[] args) {
        File file = new File("filePath");
        handleTournamentData(file, TournamentType.IPL);
    }

    private static void handleTournamentData(File file, TournamentType type) {
        ParserFactory parserFactory = new ParserFactory(new IPLParser());
        Parser parser = parserFactory.getParserByParserType(type);
        List<MatchInfo> matchInfos = parser.parse(file);
        TableComputerFactory tableComputerFactory = new TableComputerFactory(new IPLTableComputer());
        TableComputer tableComputer = tableComputerFactory.getTableComputerByType(type);
        List<TournamentTableRecord> table = tableComputer.compute(matchInfos);
    }
}

