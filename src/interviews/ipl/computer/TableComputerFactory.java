package interviews.ipl.computer;

import interviews.ipl.model.TournamentType;

public class TableComputerFactory {

    public final IPLTableComputer iplTableComputer;

    public TableComputerFactory(final IPLTableComputer iplTableComputer) {
        this.iplTableComputer = iplTableComputer;
    }

    public TableComputer getTableComputerByType(TournamentType type) {
        switch (type) {
            case IPL : return iplTableComputer;
            default:throw new IllegalArgumentException("Tournament Type Not Supported");
        }
    }
}
