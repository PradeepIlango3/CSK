package interviews.ipl.parser;

import interviews.ipl.model.TournamentType;

public class ParserFactory {

    IPLParser iplParser;
    public ParserFactory(final IPLParser iplParser) {
        this.iplParser = iplParser;
    }
    public Parser getParserByParserType(TournamentType type) {
        switch (type) {
            case IPL : return iplParser;
            default:throw new IllegalArgumentException("Tournament Type Not Supported");
        }
    }
}
