package game;

import game.travelStrategy.*;

import java.util.Scanner;

public class Game {
    private Hero hero = new Hero();
    private final String startGameStr = "Want to start the game?\n" +
            "If you want to start, answer 'yes', otherwise - 'no'.";
    private final String choiceCityStr = """
            You can go to 1 of 6 locations. To select a seat, enter a number from 1 to 6.
            1. St. Petersburg
            2. Moscow
            3. Kazan
            4. New York
            5. Kaliningrad
            6. Paris
            To exit the game, press 0.""";
    private final String choiceStrategyStr = """
            You can get there in 5 ways. To select a method, enter a number from 1 to 5.
            1. Run
            2. Walk
            3. Ride on horseback
            4. Fly
            5. Teleport
            Press 0 to quit the game.""";
    private final String errorStr = "This is not a number! Try again.";
    private final String repeatChoiceStr = "You are already in this place! Choose a different location.";

    static private final Point[] points = new Point[6];

    static {
        points[0] = new Point("St. Petersburg", 67, 65);
        points[1] = new Point("Moscow", -47, 6.7);
        points[2] = new Point("Kazan", 98, 23);
        points[3] = new Point("New York", 8.5, -55);
        points[4] = new Point("Kaliningrad", -1, 99.8);
        points[5] = new Point("Paris", -11, -108);
    }

    public Game(final Hero hero) {
        this.hero = hero;
    }

    public void start() {
        System.out.println(startGameStr);
        Scanner input = new Scanner(System.in);

        boolean gameIsOver = false;
        while (!gameIsOver) {
            String answer = input.nextLine();
            if (answer.equalsIgnoreCase("yes")) {
                while (!gameIsOver) {
                    System.out.println(choiceCityStr);
                    if (input.hasNextInt()) {
                        int answerCity = input.nextInt();
                        if (answerCity < 0 || answerCity > 6) {
                            System.out.println("Incorrect number! Try again.");
                        } else {
                            if (answerCity == 0) {
                                gameIsOver = true;
                                finish();
                                break;
                            } else if (hero.getPlace().getName().equals(points[answerCity - 1].getName())) {
                                System.out.println(repeatChoiceStr);
                            } else {
                                System.out.println(choiceStrategyStr);
                                if (input.hasNextInt()) {
                                    int answerTravelingStrategy = input.nextInt();
                                    if (answerTravelingStrategy < 0 || answerTravelingStrategy > 5) {
                                        System.out.println("Incorrect number! Try again.");
                                    } else {
                                        if (answerTravelingStrategy == 0) {
                                            gameIsOver = true;
                                            finish();
                                        }
                                        setStrategy(answerTravelingStrategy);
                                        hero.move(points[answerCity - 1]);
                                    }
                                } else {
                                    System.out.println(errorStr);
                                    input.nextLine();
                                }
                            }
                        }
                    } else {
                        System.out.println(errorStr);
                        input.nextLine();
                    }
                }
            } else if (answer.equalsIgnoreCase("no")) {
                gameIsOver = true;
                finish();
            } else {
                System.out.println("Incorrect answer, please try again");
            }
        }
        input.close();
    }

    private void finish() {
        double averageSpeed;
        if (hero.getSumOfSpeeds() == 0.0 || hero.getCountOfPointsVisited() == 0) {
            averageSpeed = 0.0;
        } else {
            averageSpeed = hero.getSumOfSpeeds() / hero.getCountOfPointsVisited();
        }
        System.out.print("The game is over!\n" +
                "The traversed path of the player is ");
        System.out.printf("%.2f", hero.getWay());
        System.out.print("\nThe player's average speed on the way is ");
        System.out.printf("%.2f", averageSpeed);
    }

    private void setStrategy(final int answerTravelingStrategy) {
        switch (answerTravelingStrategy) {
            case 1 -> {
                hero.setActualTravelStrategy(new RunStrategy());
            }
            case 2 -> {
                hero.setActualTravelStrategy(new WalkingStrategy());
            }
            case 3 -> {
                hero.setActualTravelStrategy(new HorseRidingStrategy());
            }
            case 4 -> {
                hero.setActualTravelStrategy(new FlightStrategy());
            }
            case 5 -> {
                hero.setActualTravelStrategy(new TeleportStrategy());
            }
        }
    }
}
