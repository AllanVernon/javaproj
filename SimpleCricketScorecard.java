import java.util.Scanner;

class Player {
    String name;
    int runs;
    int balls;
    int fours;
    int sixes;
    double strikeRate;
    
    void calculateStats() {
        runs = (1 * ones) + (2 * twos) + (3 * threes) + (4 * fours) + (6 * sixes);
        strikeRate = (balls > 0) ? (runs * 100.0) / balls : 0;
    }
}

class Bowler {
    String name;
    int runsGiven;
    int overs;
    int wickets;
    double economyRate;
    
    void calculateEconomy() {
        economyRate = (overs > 0) ? (runsGiven * 1.0) / overs : 0;
    }
}

public class SimpleCricketScorecard {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player[] batsmen = new Player[100];
        Bowler[] bowlers = new Bowler[100];
        int batsmanCount = 0, bowlerCount = 0;

        while (true) {
            System.out.println("1. Add Batsman");
            System.out.println("2. Add Bowler");
            System.out.println("3. View Batsman");
            System.out.println("4. View Bowler");
            System.out.println("5. Match Summary");
            System.out.println("6. Exit");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Add Batsman
                    if (batsmanCount >= 100) System.out.println("Limit reached.");
                    else {
                        Player batsman = new Player();
                        System.out.print("Enter name: ");
                        batsman.name = scanner.nextLine();
                        System.out.print("Runs: ");
                        batsman.runs = scanner.nextInt();
                        System.out.print("Balls: ");
                        batsman.balls = scanner.nextInt();
                        System.out.print("Fours: ");
                        batsman.fours = scanner.nextInt();
                        System.out.print("Sixes: ");
                        batsman.sixes = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        batsman.calculateStats();
                        batsmen[batsmanCount++] = batsman;
                    }
                    break;
                case 2: // Add Bowler
                    if (bowlerCount >= 100) System.out.println("Limit reached.");
                    else {
                        Bowler bowler = new Bowler();
                        System.out.print("Enter name: ");
                        bowler.name = scanner.nextLine();
                        System.out.print("Runs given: ");
                        bowler.runsGiven = scanner.nextInt();
                        System.out.print("Overs: ");
                        bowler.overs = scanner.nextInt();
                        System.out.print("Wickets: ");
                        bowler.wickets = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        bowler.calculateEconomy();
                        bowlers[bowlerCount++] = bowler;
                    }
                    break;
                case 3: // View Batsman
                    System.out.print("Enter batsman number (1 to " + batsmanCount + "): ");
                    int bIndex = scanner.nextInt() - 1;
                    if (bIndex >= 0 && bIndex < batsmanCount) {
                        Player b = batsmen[bIndex];
                        System.out.println("Name: " + b.name);
                        System.out.println("Runs: " + b.runs);
                        System.out.println("Balls: " + b.balls);
                        System.out.println("Fours: " + b.fours);
                        System.out.println("Sixes: " + b.sixes);
                        System.out.println("Strike Rate: " + b.strikeRate);
                    } else System.out.println("Invalid number.");
                    break;
                case 4: // View Bowler
                    System.out.print("Enter bowler number (1 to " + bowlerCount + "): ");
                    int bwIndex = scanner.nextInt() - 1;
                    if (bwIndex >= 0 && bwIndex < bowlerCount) {
                        Bowler b = bowlers[bwIndex];
                        System.out.println("Name: " + b.name);
                        System.out.println("Runs Given: " + b.runsGiven);
                        System.out.println("Overs: " + b.overs);
                        System.out.println("Wickets: " + b.wickets);
                        System.out.println("Economy Rate: " + b.economyRate);
                    } else System.out.println("Invalid number.");
                    break;
                case 5: // Match Summary
                    System.out.println("Batsmen:");
                    for (int i = 0; i < batsmanCount; i++) {
                        Player b = batsmen[i];
                        System.out.println(b.name + ": Runs=" + b.runs + ", Balls=" + b.balls + ", Fours=" + b.fours + ", Sixes=" + b.sixes + ", SR=" + b.strikeRate);
                    }
                    System.out.println("Bowlers:");
                    for (int i = 0; i < bowlerCount; i++) {
                        Bowler b = bowlers[i];
                        System.out.println(b.name + ": Runs Given=" + b.runsGiven + ", Overs=" + b.overs + ", Wickets=" + b.wickets + ", Economy Rate=" + b.economyRate);
                    }
                    break;
                case 6: // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
