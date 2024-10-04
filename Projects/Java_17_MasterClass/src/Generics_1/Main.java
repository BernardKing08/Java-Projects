package Generics_1;

record baseBallPlayer(String name, String position){}

public class Main {
    public static void main(String[] args) {
        BaseBallTeam phillies = new BaseBallTeam("Phillies");
        BaseBallTeam rockets = new BaseBallTeam("Rockers");
        scoreResult(phillies, 3, rockets, 5);

        var harper = new baseBallPlayer("B Harper", "Right Fielder");
        var marsh = new baseBallPlayer("B marsh", "Rigtht fielder");
        phillies.addTeamMember(harper);
        phillies.addTeamMember(marsh);
        phillies.listTeamMembers();
    }

    public static void scoreResult(BaseBallTeam team1, int t1_score,
                                    BaseBallTeam team2, int t2_score){
        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t1_score, t2_score);
        System.out.printf("%s %s %n", team1, message, team2);
    }
}
