package interviews.ipl.parser;

import interviews.ipl.model.MatchInfo;

import java.io.File;
import java.util.List;

public interface Parser {

    //TODO change return type
    public List<MatchInfo> parse(File file);
}
