package interviews.ipl.parser;

import interviews.ipl.model.IPLMatchInfo;
import interviews.ipl.model.MatchInfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IPLParser implements Parser {
    @Override
    public List<MatchInfo> parse(File file) {
        List<MatchInfo> matchInfos = new ArrayList<>();
        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] info = line.split(";");
                matchInfos.add(new IPLMatchInfo(info[0], info[1], info[2]));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return matchInfos;
    }
}
