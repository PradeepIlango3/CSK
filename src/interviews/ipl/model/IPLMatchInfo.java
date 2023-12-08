package interviews.ipl.model;

public class IPLMatchInfo extends MatchInfo {
    public String winnningTeam;
    public String lossingTeam;

    public String result;
    public IPLMatchInfo(String winnningTeam, String lossingTeam, String result) {
        this.winnningTeam = winnningTeam;
        this.lossingTeam = lossingTeam;
        this.result = result;
    }
}
