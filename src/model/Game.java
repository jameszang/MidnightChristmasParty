package model;

import java.util.Scanner;

public class Game {

    public static final int TZUYU = 0;
    public static final int NANCY = 1;
    public static final int CHOA = 2;
    public static final int TAYLOR = 3;
    public static final int MARY = 4;
    public static final int SEOLHYUN = 5;
    private static final String PASSCODE = "nicecuck";
    private static Scanner reader = new Scanner(System.in);
    private Girl crush;
    private String passcode;
    private String name;

    public void gameStart() {
        int choice;
        int team;
        int firstActivity;

        queryUserCodeAndName();
        printIntro();

        System.out.println("James, the MC of the event, calls everyone together to explain how the scavenger " +
                "hunt is going to go down. The girls will partner up and work together to find the 6 different " +
                "coloured candy canes hidden around the house. Since we have an odd number here, " + name +
                " can join up with one of the pairs and participate as part of that group.\n");
        System.out.println("You look around the room. Tzuyu is paired with Nancy, Seolhyun is paired with " +
                "Mary, and Taylor is paired with Choa.\n");
        System.out.println("You make up your mind and decide to join: (Enter the corresponding number)");
        System.out.println("1) Tzuyu and Nancy");
        System.out.println("2) Choa and Taylor");
        System.out.println("3) Mary and Seolhyun");
        choice = makeChoice(3);
        printLineBreak();
        do {
            if (choice == 1) {
                choice = tzuyuNancy();
            } else if (choice == 2) {
                choice = choaTaylor();
            } else if (choice == 3) {
                choice = marySeolhyun();
            }
        } while ((choice != -1) && (choice != -2) && (choice != -3)); //-1 = T&N, -2 = C&T, -3 = M&S
        printLineBreak();

        team = choice;
        choice = chooseFirstActivity(team);

        firstActivity = choice;
        choice = chooseGirl(firstActivity, team);

        if (choice == 1 && team == -1) {
            crush = new Girl(TZUYU);
            if (firstActivity == 1) {
                crush.bakeCookies = true;
                tzuyuBaking();
            } else if (firstActivity == 2) {
                crush.netflixAndChill = true;
                netflix();
            } else {
                crush.decorateTheHouse = true;
                tzuyuDecorating();
            }
        } else if (choice == 2 && team == -1) {
            crush = new Girl(NANCY);
            if (firstActivity == 1) {
                crush.bakeCookies = true;
                if (checkPasscode()) {
                    nancyBakingGood();
                } else {
                    nancyBakingBad();
                }
            } else if (firstActivity == 2) {
                crush.netflixAndChill = true;
                netflix();
            } else {
                crush.decorateTheHouse = true;
                if (checkPasscode()) {
                    nancyDecoratingGood();
                } else {
                    nancyDecoratingBad();
                }
            }
        } else if (choice == 1 && team == -2) {
            crush = new Girl(CHOA);
            if (firstActivity == 1) {
                crush.videoGames = true;
                choaVideoGames();
            } else if (firstActivity == 2) {
                crush.netflixAndChill = true;
                netflix();
            } else {
                crush.getFood = true;
                choaFood();
            }
        } else if (choice == 2 && team == -2) {
            crush = new Girl(TAYLOR);
            if (firstActivity == 1) {
                crush.videoGames = true;
                taylorVideoGames();
            } else if (firstActivity == 2) {
                crush.netflixAndChill = true;
                netflix();
            } else {
                crush.getFood = true;
                taylorFood();
            }
        } else if (choice == 1 && team == -3) {
            crush = new Girl(SEOLHYUN);
            if (firstActivity == 1) {
                crush.dinnerAndDrinking = true;
                seolhyunDinner();
            } else if (firstActivity == 2) {
                crush.netflixAndChill = true;
                netflix();
            } else {
                crush.pillowFights = true;
                seolhyunPillowFight();
            }
        } else {
            crush = new Girl(MARY);
            if (firstActivity == 1) {
                crush.dinnerAndDrinking = true;
                maryDrinking();
            } else if (firstActivity == 2) {
                crush.netflixAndChill = true;
                netflix();
            } else {
                crush.pillowFights = true;
                maryPillowFight();
            }
        }
        printLineBreak();

        while (((crush.getGirlNum() == TZUYU || crush.getGirlNum() == NANCY) && (!crush.bakeCookies || !crush.netflixAndChill || !crush.decorateTheHouse)) ||
                ((crush.getGirlNum() == CHOA || crush.getGirlNum() == TAYLOR) && (!crush.videoGames || !crush.netflixAndChill || !crush.getFood)) ||
                ((crush.getGirlNum() == MARY || crush.getGirlNum() == SEOLHYUN) && (!crush.dinnerAndDrinking || !crush.netflixAndChill || !crush.pillowFights))) {
            System.out.println("What else do you want to do?\n");
            System.out.println(name + ":");
            if (crush.getGirlNum() == TZUYU || crush.getGirlNum() == NANCY) {
                if (!crush.bakeCookies) {
                    System.out.println("1) Bake Christmas cookies");
                }
                if (!crush.netflixAndChill) {
                    System.out.println("2) Netflix and chill");
                }
                if (!crush.decorateTheHouse) {
                    System.out.println("3) Decorate the house");
                }
                choice = Integer.parseInt(reader.nextLine());
                while ((choice != 1 || (choice == 1 && crush.bakeCookies)) && (choice != 2 || (choice == 2 && crush.netflixAndChill)) && (choice != 3 || (choice == 3 && crush.decorateTheHouse))) {
                    printError();
                    choice = Integer.parseInt(reader.nextLine());
                }
                printLineBreak();

                if (crush.getGirlNum() == TZUYU && choice == 1) {
                    crush.bakeCookies = true;
                    tzuyuBaking();
                } else if (crush.getGirlNum() == TZUYU && choice == 2) {
                    crush.netflixAndChill = true;
                    netflix();
                } else if (crush.getGirlNum() == TZUYU && choice == 3) {
                    crush.decorateTheHouse = true;
                    tzuyuDecorating();
                } else if (crush.getGirlNum() == NANCY && choice == 1) {
                    crush.bakeCookies = true;
                    if (checkPasscode()) {
                        nancyBakingGood();
                    } else {
                        nancyBakingBad();
                    }
                } else if (crush.getGirlNum() == NANCY && choice == 2) {
                    crush.netflixAndChill = true;
                    netflix();
                } else if (crush.getGirlNum() == NANCY && choice == 3) {
                    crush.decorateTheHouse = true;
                    if (checkPasscode()) {
                        nancyDecoratingGood();
                    } else {
                        nancyDecoratingBad();
                    }
                }
                printLineBreak();
            } else if (crush.getGirlNum() == CHOA || crush.getGirlNum() == TAYLOR) {
                if (!crush.videoGames) {
                    System.out.println("1) Video games");
                }
                if (!crush.netflixAndChill) {
                    System.out.println("2) Netflix and chill");
                }
                if (!crush.getFood) {
                    System.out.println("3) Go get food");
                }
                choice = Integer.parseInt(reader.nextLine());
                while ((choice != 1 || (choice == 1 && crush.videoGames)) && (choice != 2 || (choice == 2 && crush.netflixAndChill)) && (choice != 3 || (choice == 3 && crush.getFood))) {
                    printError();
                    choice = Integer.parseInt(reader.nextLine());
                }
                printLineBreak();

                if (crush.getGirlNum() == CHOA && choice == 1) {
                    crush.videoGames = true;
                    choaVideoGames();
                } else if (crush.getGirlNum() == CHOA && choice == 2) {
                    crush.netflixAndChill = true;
                    netflix();
                } else if (crush.getGirlNum() == CHOA && choice == 3) {
                    crush.getFood = true;
                    choaFood();
                } else if (crush.getGirlNum() == TAYLOR && choice == 1) {
                    crush.videoGames = true;
                    taylorVideoGames();
                } else if (crush.getGirlNum() == TAYLOR && choice == 2) {
                    crush.netflixAndChill = true;
                    netflix();
                } else if (crush.getGirlNum() == TAYLOR && choice == 3) {
                    crush.getFood = true;
                    taylorFood();
                }
                printLineBreak();
            } else {
                if (!crush.dinnerAndDrinking) {
                    System.out.println("1) Dinner and drinking");
                }
                if (!crush.netflixAndChill) {
                    System.out.println("2) Netflix and chill");
                }
                if (!crush.getFood) {
                    System.out.println("3) Pillow fights");
                }
                choice = Integer.parseInt(reader.nextLine());
                while ((choice != 1 || (choice == 1 && crush.dinnerAndDrinking)) && (choice != 2 || (choice == 2 && crush.netflixAndChill)) && (choice != 3 || (choice == 3 && crush.pillowFights))) {
                    printError();
                    choice = Integer.parseInt(reader.nextLine());
                }
                printLineBreak();

                if (crush.getGirlNum() == MARY && choice == 1) {
                    crush.dinnerAndDrinking = true;
                    maryDrinking();
                } else if (crush.getGirlNum() == MARY && choice == 2) {
                    crush.netflixAndChill = true;
                    netflix();
                } else if (crush.getGirlNum() == MARY && choice == 3) {
                    crush.pillowFights = true;
                    maryPillowFight();
                } else if (crush.getGirlNum() == SEOLHYUN && choice == 1) {
                    crush.dinnerAndDrinking = true;
                    seolhyunDinner();
                } else if (crush.getGirlNum() == SEOLHYUN && choice == 2) {
                    crush.netflixAndChill = true;
                    netflix();
                } else if (crush.getGirlNum() == SEOLHYUN && choice == 3) {
                    crush.pillowFights = true;
                    seolhyunPillowFight();
                }
                printLineBreak();
            }
        }

        System.out.println("Press Enter to exit. ");
        reader.nextLine();
    }

    private void queryUserCodeAndName() {
        System.out.println("Do you have a code to enter? (Type code then Enter) (Press Enter if no code)");
        passcode = reader.nextLine();
        if (checkPasscode()) {
            System.out.println("Correct code.");
        } else {
            System.out.println("Incorrect code.");
        }
        printLineBreak();

        System.out.print("What is your name? ");
        name = reader.nextLine();
        printLineBreak();
    }

    //Prints the game intro
    private void printIntro() {
        System.out.println("You don't know how you were fortunate enough to be in this situation," +
                " to be situated between some of the most desirable girls you know of-- oh, and James. " +
                "You have been invited to an all girls end of year christmas party as the guest of " +
                "honor to give a speech on your experiences after getting a Masters degree in UBC " +
                "Engineering within only 4 years (because Engineering is easy anyways). You may " +
                "have somehow attained a master's degree in only 4 years but you have never attained " +
                "a girlfriend. This is your chance.\n");
        //System.out.println("");
        System.out.println("Sitting to your left is a girl named Seolhyun. She is a 4th year engineering" +
                " student at UBC and volunteers at your lab. From your experience, she is somewhat " +
                "cold to strangers but still responds well to jokes.\n");
        //System.out.println("");
        System.out.println("You hear a conversation at the nearby coffee table between Tzuyu, Nancy, " +
                "and Mary. They are discussing their New Year's plans, discussing if they should go " +
                "get sweets or chill by the fireworks.\n");
        //System.out.println("");
        System.out.println("Tzuyu sits on one half of the loveseat. She laughs and you find yourself" +
                " smiling; her happiness is contagious. Although your past interactions with her have" +
                " been few and far between, you recall that she has always been a caring and funny person.\n");
        //System.out.println("");
        System.out.println("Snuggled up next to Tzuyu is Nancy, the two are obviously very close. Nancy " +
                "is a part-time League of Legos (a popular computer game by publisher Rito Games) streamer " +
                "and has an adoring fan base of thousands. Because of this, she is very chill and responds " +
                "well to conversations initiated with her.\n");
        //System.out.println("");
        System.out.println("Mary appears to be very approachable, with her wide smile and jovial behaviour. " +
                "She is visibly excited for the party and ensuing New Year's Celebration.\n");
        //System.out.println("");
        System.out.println("Choa and Taylor quietly lounge by the beanbags playing Pokemon. Their silence is" +
                " occasionally interrupted with exasperated cries of victory and defeat.");
        printLineBreak();
    }

    //Prompts user for a (valid) choice and returns that choice
    private int makeChoice(int numChoices) {
        int choice = Integer.parseInt(reader.nextLine());
        while (choice <= 0 || choice > numChoices) {
            printError();
            choice = Integer.parseInt(reader.nextLine());
        }
        return choice;
    }

    //Prints a line break and separator
    private void printLineBreak() {
        System.out.println("\n========================================\n");
    }

    //Prints an error message
    private void printError() {
        System.out.print("Error: invalid choice. Try again: ");
    }

    //Checks to see if the passcode is correct
    private boolean checkPasscode() {
        return passcode.equals(PASSCODE);
    }

    //Tzuyu and Nancy Scavenger Hunt
    private int tzuyuNancy() {
        int choice;

        System.out.println("Tzuyu: Hey " + name + ", I'm Tzuyu. Nice to meet you...um...this is Nancy!\n");
        System.out.println("Nancy: Hey, I think it's pretty cool that you got your Master's Degree in only " +
                "4 years, I don't think I could ever do that.\n");
        System.out.println(name + ":");
        System.out.println("1) You know what they say, hard work pays off hehe xd");
        System.out.println("2) Well I believe that some people have an innate ability to do well in certain topics, me of course being one of the few.");
        System.out.println("3) Thanks! I really hope that one day my work pays off.");
        choice = makeChoice(3);
        printLineBreak();

        System.out.println("Tzuyu: Dude same! But still, you guys are such tryhards. *laughs*\n");
        System.out.println("Nancy: I work hard at playing league lmaokai.\n");
        System.out.println("Tzuyu: Ok buddyyy but you still got hella good grades. Oh wait, the " +
                "candy canes! I'm not gonna get beat by Seolhyun, LET'S GO!! *she grabs Nancy's arm*\n");
        System.out.println(name + ":");
        System.out.println("1) Sure");
        System.out.println("2) Alright");
        System.out.println("3) Yes");
        System.out.println("4) Absolutely");
        choice = makeChoice(4);
        printLineBreak();

        System.out.println("Nancy: This house is so big, how are we gonna find any of them?\n");
        System.out.println("Tzuyu: Just go by feeling.\n");
        System.out.println("Nancy: *laughs* wtf.\n");
        System.out.println("Nancy: Oh wait, hold up... I think I see something under the desk... it's...\n");
        System.out.println(name + ":");
        System.out.println("1) Diary");
        System.out.println("2) Limited Edition $500 Value Golden Pepe Figurine With Toggleable Tears");
        System.out.println("3) Panties");
        choice = makeChoice(3);
        printLineBreak();

        System.out.println("Nancy: *picks up item* Oh wut, how did that get there? *laughs* Is this yours, " + name + "?\n");
        System.out.println("Tzuyu: O wait yo lemme see too!! *she pouts and repeatedly taps on your shoulder*\n");
        System.out.println(name + ":");
        System.out.println("1) It's not a candy cane, not really important.");
        System.out.println("2) It seems private, we should probably leave it alone.");
        System.out.println("3) Shouldn't we focus on the scavenger hunt?");
        choice = makeChoice(3);
        printLineBreak();

        System.out.println("Nancy: Eh, I guess... kinda tempted tho. But I guess we should focus on the scavenger hunt yeah.\n");
        System.out.println("Tzuyu: Yeah I have to beat Seolhyun! Can't let her get too cocky...\n");
        System.out.println("Nancy: " + name + " do you wanna keep going then?\n");
        System.out.println(name + ":");
        System.out.println("1) Sure, I'll keep going with you guys.");
        System.out.println("2) I'll probably go join another group.");
        choice = makeChoice(2);
        printLineBreak();

        if (choice == 1) {
            System.out.println("Nancy: Alright cool, shouldn't take too long I think. Let's hurry and get this finished so we can" +
                    " go watch a movie or something.\n");
            System.out.println("Tzuyu: Yes! Hey watching a movie, it'll be like a date Nancy :)\n");
            System.out.println("Nancy: Lol pls\n");
            System.out.println("Tzuyu: :(");
            return -1;
        } else {
            System.out.println("Tzuyu: Well, whatever... it's not like I want you here with me and Nancy anyways... In fact it'd" +
                    " be better if you just joined another group and left Nancy and I alone.\n");
            System.out.println("Nancy: *laughs* I-it's not like I like you or anything Senpai.\n");
            System.out.println("*playfully hits Nancy on the arm* Hey shuttup.\n");
            System.out.println(name + ":");
            System.out.println("2) Join Choa and Taylor");
            System.out.println("3) Join Mary and Seolhyun");
            choice = Integer.parseInt(reader.nextLine());
            while ((choice != 2) && (choice != 3)) {
                printError();
                choice = Integer.parseInt(reader.nextLine());
            }
            printLineBreak();
            return choice;
        }
    }

    //Choa and Taylor scavenger hunt
    private int choaTaylor() {
        int choice;

        System.out.println("Choa: Hey, " + name + " I'm Choa. This is Taylor, my waifuuu. Nice to meet you!\n");
        System.out.println("Taylor: Haiii. How did you manage to get a Master's in 4 years? In engineering too...\n");
        System.out.println(name + ":");
        System.out.println("1) You know what they say, hard work pays off hehe xd");
        System.out.println("2) Well I believe that some people have an innate ability to do well in certain topics, me of course being one of the few.");
        System.out.println("3) Thanks! I really hope that one day my work pays off.");
        choice = makeChoice(3);
        printLineBreak();

        System.out.println("Choa: Dude same! But still, you're both more tryhard than me.\n");
        System.out.println("Taylor: I work hard at watching youtube and playing otome games LOL\n");
        System.out.println("Choa: And watching Yuri on Ice :^^^^) Oh wait, the candy canes! I'm not gonna lose to Tzuyu," +
                " let's get going. *she grabs Taylor and looks at you for your verdict*\n");
        System.out.println(name + ":");
        System.out.println("1) Sure");
        System.out.println("2) Alright");
        System.out.println("3) Yes");
        System.out.println("4) Absolutely");
        choice = makeChoice(4);
        printLineBreak();

        System.out.println("Taylor: This house is so big wtf how are we gonna find any of them?\n");
        System.out.println("Choa: Just do it!\n");
        System.out.println("Taylor: *laughs* wtf\n");
        System.out.println("Taylor: Wait yo, hold up... I think I see something under the desk... it's...\n");
        System.out.println(name + ":");
        System.out.println("1) Diary");
        System.out.println("2) Limited Edition $500 Value Golden Pepe Figurine With Toggleable Tears");
        System.out.println("3) Panties");
        choice = makeChoice(3);
        printLineBreak();

        System.out.println("Taylor: *picks up item* I wonder how that got there? *laughs*\n");
        System.out.println("Choa: Yo yo lemme see too!! *she tries to look over your shoulder*\n");
        System.out.println(name + ":");
        System.out.println("1) It's not a candy cane, not really important.");
        System.out.println("2) It seems private, we should probably leave it alone.");
        System.out.println("3) Shouldn't we focus on the scavenger hunt?");
        choice = makeChoice(3);
        printLineBreak();

        System.out.println("Choa: Eh I guess... kinda tempted tho. But I guess we should focus on the scavenger hunt yeah.\n");
        System.out.println("Taylor: Yeah I don't want to lose this game *laughs*\n");
        System.out.println("Choa: " + name + " do you want to keep going then?\n");
        System.out.println(name + ":");
        System.out.println("1) Sure, I'll keep going with you guys.");
        System.out.println("2) I'll probably go join another group.");
        choice = makeChoice(2);
        printLineBreak();

        if (choice == 1) {
            System.out.println("Choa: Ayy let's go boiis! Gotta get those candy canes~\n");
            System.out.println("Taylor: Ayy let's do it waifuu.");
            return -2;
        } else {
            System.out.println("Choa: Awwh alright then... have fun!\n");
            System.out.println("Taylor: Yeah we'll win anyway!\n");
            System.out.println(name + ":");
            System.out.println("1) Join Nancy and Tzuyu");
            System.out.println("3) Join Seolhyun and Mary");
            choice = Integer.parseInt(reader.nextLine());
            while ((choice != 1) && (choice != 3)) {
                printError();
                choice = Integer.parseInt(reader.nextLine());
            }
            printLineBreak();
            return choice;
        }
    }

    //Mary and Seolhyun scavenger hunt
    private int marySeolhyun() {
        int choice;

        System.out.println("Mary: Hey, " + name + " I'm Mary and this is Seolhyun. Pretty sure with you on our team, we'll win for sure!\n");
        System.out.println("Seolhyun: Good job on completing your Master's already. I'm in fourth year right now and I can't imagine how hard you must've worked to be done so quickly.\n");
        System.out.println(name + ":");
        System.out.println("1) You know what they say, hard work pays off hehe xd");
        System.out.println("2) Well I believe that some people have an innate ability to do well in certain topics, me of course being one of the few.");
        System.out.println("3) Thanks! I really hope that one day my work pays off.");
        choice = makeChoice(3);
        printLineBreak();

        System.out.println("Mary: What? You guys are such tryhards! Poor engineering kids.\n");
        System.out.println("Seolhyun: I put all my eggs in the final exam basket, how is that tryhard?" + name + " is the real tryhard here.\n");
        System.out.println("Mary: Yeah well you still do so well--wait, the candy canes! I'm not gonna lose when we have an extra person on our team. Let's start looking.\n");
        System.out.println(name + ":");
        System.out.println("1) Sure");
        System.out.println("2) Alright");
        System.out.println("3) Yes");
        System.out.println("4) Absolutely");
        choice = makeChoice(4);
        printLineBreak();

        System.out.println("Seolhyun: This house is so big. We're gonna have a hard time finding even one...\n");
        System.out.println("Mary: Yeah! Who's idea is this anyways? I'd rather go watch some Dr. Who or a movie or something.\n");
        System.out.println("Seolhyun: Well we're already participating so might as well finish it. Do you see any?\n");
        System.out.println("Seolhyun: Wait wait, hold up... I think I see something under the desk... it's...\n");
        System.out.println(name + ":");
        System.out.println("1) Diary");
        System.out.println("2) Limited Edition $500 Value Golden Pepe Figurine With Toggleable Tears");
        System.out.println("3) Panties");
        choice = makeChoice(3);
        printLineBreak();

        System.out.println("Seolhyun: *picks up item* Ew what the... how did that get there?\n");
        System.out.println("Mary: What is it? What is it? Show me too! *She stands on tiptoes in an attempt to see over your shoulder.*\n");
        System.out.println("Mary: Ooo is that yours, " + name + "?");
        System.out.println(name + ":");
        System.out.println("1) It's not a candy cane, not really important.");
        System.out.println("2) It seems private, we should probably leave it alone.");
        System.out.println("3) Shouldn't we focus on the scavenger hunt?");
        choice = makeChoice(3);
        printLineBreak();

        System.out.println("Seolhyun: Yeah he's right, we should get going...\n");
        System.out.println("Mary: Yeah we can't lose to the other teams!\n");
        System.out.println("Seolhyun " + name + " do you want to keep going then?\n");
        System.out.println(name + ":");
        System.out.println("1) Sure, I'll keep going with you guys.");
        System.out.println("2) I'll probably go join another group.");
        choice = makeChoice(2);
        printLineBreak();

        if (choice == 1) {
            System.out.println("Seolhyun: Alright cool, shouldn't take too long I think. Although I don't think" +
                    " I’d like to see what other hidden 'treasures' we might find...\n");
            System.out.println("Mary: Yes! One extra person. Let's go!");
            return -3;
        } else {
            System.out.println("Seolhyun: Yeah sure that's fine. Come on Mary let's go then.\n");
            System.out.println("Mary: Awwh I thought we'd have an extra person... This is fine too I guess.\n");
            System.out.println(name + ":");
            System.out.println("1) Join Nancy and Tzuyu");
            System.out.println("2) Join Choa and Taylor");
            choice = Integer.parseInt(reader.nextLine());
            while ((choice != 1) && (choice != 2)) {
                printError();
                choice = Integer.parseInt(reader.nextLine());
            }
            printLineBreak();
            return choice;
        }
    }

    //Choose first activity after scavenger hunt
    private int chooseFirstActivity(int team) {
        int choice;

        System.out.print("With ");
        if (team == -1) {
            System.out.print("Tzuyu and Nancy,");
        } else if (team == -2) {
            System.out.print("Choa and Taylor,");
        } else {
            System.out.print("Mary and Seolhyun,");
        }
        System.out.println(" the three of you finish up the scavenger hunt and go back to the meetup " +
                "area. Apparently your group finished first! The three of you hi-five each other and " +
                "wait for the others to finish. What would you suggest them do to pass the time?\n");

        if (team == -1) {
            System.out.println(name + ":");
            System.out.println("1) Bake Christmas cookies");
            System.out.println("2) Netflix and chill");
            System.out.println("3) Decorate the house");
            choice = makeChoice(3);
            printLineBreak();
            return choice;
        } else if (team == -2) {
            System.out.println(name + ":");
            System.out.println("1) Video games");
            System.out.println("2) Netflix and chill");
            System.out.println("3) Go get food");
            choice = makeChoice(3);
            printLineBreak();
            return choice;
        } else {
            System.out.println(name + ":");
            System.out.println("1) Dinner and drinking");
            System.out.println("2) Netflix and chill");
            System.out.println("3) Pillow fights");
            choice = makeChoice(3);
            printLineBreak();
            return choice;
        }
    }

    //Choose the girl to go for
    private int chooseGirl(int activity, int team) {
        int choice;

        if (team == -1) {
            if (activity == 1) { //bake cookies
                System.out.println("Nancy: Yeah sure! I think we have all the ingredients for making those too. " +
                        "I've done this a few times before so it shouldn't take too long.\n");
                System.out.println("Tzuyu: Oh! Um I'll help too! But I'm not too good at baking... *laughs*\n");
                System.out.println("Nancy: You'll make everything salty heh.\n");
                System.out.println("Tzuyu: Hey! *mumbles* nice meme\n");
                System.out.println(name + ":");
                System.out.println("1) Assist Tzuyu in baking the cookies");
                System.out.println("2) Assist Nancy in baking the cookies");
                choice = makeChoice(2);
                printLineBreak();
                return choice;
            } else if (activity == 2) { //netflix
                System.out.println("Tzuyu: Ehh sure, why not? Nancy and I have pretty different tastes though.\n");
                System.out.println("Nancy: I guess " + name + " can choose his preference.\n");
                System.out.println(name + ":");
                System.out.println("1) Netflix and chill with Tzuyu");
                System.out.println("2) Netflix and chill with Nancy");
                choice = makeChoice(2);
                printLineBreak();
                return choice;
            } else { //decorate house
                System.out.println("Tzuyu: The rooms are pretty plain for the holiday season, I think the host " +
                        "forgot to decorate it beforehand or something. Smh procrastinators hehe\n");
                System.out.println("Nancy: Yeah sure I'm down. I never really bothered to decorate my house before" +
                        " but I guess there's a first time for everything, might need some help though.\n");
                System.out.println(name + ":");
                System.out.println("1) Help Tzuyu decorate the house");
                System.out.println("2) Help Nancy decorate the house");
                choice = makeChoice(2);
                printLineBreak();
                return choice;
            }
        } else if (team == -2) {
            if (activity == 1) { //video games
                System.out.println("Choa: Ooooo yeah! Wanna play League of Legos?\n");
                System.out.println("Taylor: I kinda want to play Water Emblem though... Gotta get that bae.\n");
                System.out.println(name + ":");
                System.out.println("1) Play with Choa");
                System.out.println("2) Play with Taylor");
                choice = makeChoice(2);
                printLineBreak();
                return choice;
            } else if (activity == 2) { //netflix
                System.out.println("Choa: Sure, I haven't done that in a long time.\n");
                System.out.println("Taylor: We might not like the same things though, so " + name + " should probably go with what he wants more\n");
                System.out.println(name + ":");
                System.out.println("1) Netflix and chill with Choa");
                System.out.println("2) Netflix and chill with Taylor");
                choice = makeChoice(2);
                printLineBreak();
                return choice;
            } else { //food
                System.out.println("Choa: I'm gonna go see if there are any cakes left.\n");
                System.out.println("Taylor: I want ice cream heh.\n");
                System.out.println(name + ":");
                System.out.println("1) Choose to go with Choa to get some cake");
                System.out.println("2) Go with Taylor to get some ice cream");
                choice = makeChoice(2);
                printLineBreak();
                return choice;
            }
        } else {
            if (activity == 1) { //dinner and drinking
                System.out.println("Mary: Hehehe good choice! Let me introduce you to the world of DRINKING my friend.\n");
                System.out.println("Seolhyun: *sighs* I see you're still on the road to alcoholism. OK, I'll go get the takeout; Mary you get the drinks ready.\n");
                System.out.println(name + ":");
                System.out.println("1) Help Seolhyun");
                System.out.println("2) Help Mary");
                choice = makeChoice(2);
                printLineBreak();
                return choice;
            } else if (activity == 2) { //netflix
                System.out.println("Mary: That's one of my comfort picks, I'm down.\n");
                System.out.println("Seolhyun: We don't exactly like the same things though, Mary.\n");
                System.out.println("Mary: " + name + " can pick what he likes then :^)\n");
                System.out.println(name + ":");
                System.out.println("1) Netflix and chill with Seolhyun");
                System.out.println("2) Netflix and chill with Mary");
                choice = makeChoice(2);
                printLineBreak();
                return choice;
            } else { //pillow fight
                //TODO
                System.out.println(name + ":");
                System.out.println("1) Team up with Seolhyun");
                System.out.println("2) Team up with Mary");
                choice = makeChoice(2);
                printLineBreak();
                return choice;
            }
        }
    }

    //Tzuyu baking segment
    private void tzuyuBaking() {
        int choice;

        System.out.println("Tzuyu: Yee okay thanks! I think I have a KitchenAids mixer downstairs too! But um...\n");
        System.out.println(name + ":");
        System.out.println("1) Offer to go downstairs with her");
        System.out.println("2) Start preparing the cookies");
        choice = makeChoice(2);
        printLineBreak();

        if (choice == 1) {
            crush.addPoints(1);
            System.out.println("Tzuyu: Oh um sure! I mean if you want to then ok. We'll be right back!\n");
            System.out.println("Nancy: Yeah sure I'll just start on the icing first then. Might need the mixer for " +
                    "that too though but I'll make do for now.\n");
            System.out.println("You arrive at the door to the basement.\n");
            System.out.println(name + ":");
            System.out.println("1) Hold the door open for her while she goes down first");
            System.out.println("2) Wait for her to open the door before going down");
            choice = makeChoice(2);
            printLineBreak();

            if (choice == 1) {
                crush.removePoints(1);
                System.out.println("Tzuyu: Oh thanks! Um... can you go down and turn on the light first? " +
                        "I'm not scared or anything I... just can't see well in the dark, I don't wanna trip y'know *laughs*\n");
            } else if (choice == 2) {
                crush.addPoints(1);
                System.out.println("She pulls on the door handle before getting embarrassed. It says to push. " +
                        "You laugh before opening the door and walking down while gesturing for her to follow you.\n");
            }

            System.out.println("You walk down first and turn on the lights before waiting for her to come down and show you where the mixer is\n");
            System.out.println(name + ":");
            System.out.println("1) Insist on helping her carry the mixer");
            System.out.println("2) Joke about how she's not strong enough to carry it and watch her struggle");
            System.out.println("3) Say nothing and have her carry up the mixer");
            choice = makeChoice(3);
            printLineBreak();

            if (choice == 1) {
                crush.addPoints(0);
                System.out.println("Tzuyu: Thanks! It's-it's not too heavy, right?\n");
                System.out.println("You shake your head and say it's fine\n");
                System.out.println("Tzuyu: Okok let's go upstairs and start making the cookies!\n");
                System.out.println("Even though you helped her carry the mixer up, she looks somewhat disappointed and you can't imagine why...\n");
            } else if (choice == 2) {
                crush.addPoints(1);
                System.out.println("Tzuyu: Hey! *laughs* I'll have you know I benched all the time during high school!\n");
                System.out.println("She probably meant bench as in being benched on a sports team... you decide to point it out.\n");
                System.out.println("Tzuyu: Hehe true. But it's just a small mixer I can handle it!\n");
                System.out.println(name + ":");
                System.out.println("1) Listen to her and let her carry it up");
                System.out.println("2) Call her a tsun and insist on carrying it anyways");
                choice = makeChoice(2);
                printLineBreak();

                if (choice == 1) {
                    crush.removePoints(2);
                    System.out.println("You nod and watch as she struggles to carry up the mixer herself. " +
                            "She doesn't look back at you or speak much on the way back. Maybe she actually wanted help despite saying no...\n");
                } else if (choice == 2) {
                    crush.addPoints(2);
                    System.out.println("You watch her struggle with it for a good 5 seconds before placing your " +
                            "hands under it to lift it up instead.\n");
                    System.out.println("Tzuyu: *she nervously avoids eye contact before playfully hitting your arm* Hey! Shuttup... Um thanks though... Let's go on up then!\n");
                    System.out.println("The two of you walk up the stairs carrying the mixer while she fiddles with her fingers nervously.\n");
                }
            } else if (choice == 3) {
                crush.removePoints(1);
                System.out.println("Tzuyu: *struggles to carry up the mixer* I'll just carry it up then, *laughs* Chivalry is NOT dead.\n");
                System.out.println("As she climbs up the stairs she stumbles a bit and falls forward.\n");
                System.out.println(name + ":");
                System.out.println("1) Catch her then offer to carry it the rest of the way");
                System.out.println("2) Watch her fall then laugh before helping her up and asking if she's ok");
                choice = makeChoice(2);
                printLineBreak();

                if (choice == 1) {
                    crush.addPoints(2);
                    System.out.println("In your attempt at catching her your hands slip and you end up hovering over " +
                            "her instead, faces only inches away from each other. Her face gets visibly red as she " +
                            "avoids eye contact and tries to play it off.\n");
                    System.out.println("Tzuyu: Oh haha you tried I guess! Whoops sorry *laughs*\n");
                    System.out.println("On your way up you see that she often glances your way but looks away when " +
                            "you make eye contact. You think you made the right choice as she smiles at you occasionally.\n");
                } else if (choice == 2) {
                    crush.removePoints(1);
                    System.out.println("Tzuyu: *nervously laughs* Wow so meannn.\n");
                    System.out.println("She doesn't seem impressed by your actions--or lack thereof--and frowns the " +
                            "rest of the way while struggling to carry the package and make light of the fall. You're an ass.\n");
                }
            }
        } else if (choice == 2) {
            crush.removePoints(1);
            System.out.println("Tzuyu: *she glances away* Oh... well I mean I was gonna ask Nancy to come with me " +
                    "anyways... Just stay and finish the icing then ok?\n");
            System.out.println("You nod and begin preparing the icing, but as you turn to look at them, she seems " +
                    "somewhat distant and disappointed. Did she actually want you to go down with her instead?\n");
        }

        System.out.println("The mixer is brought upstairs and is used to make the batter. The three of you joke " +
                "around as you finish making the cookies and you can't help but notice the bright smile on " +
                "Tzuyu's face as it lights up the whole room. You did most of the baking though...\n");
        System.out.println(name + ":");
        System.out.println("1) Ha! Now we know who the real hard carry is");
        System.out.println("2) Remain quiet because it would be rude to insist they did nothing");
        choice = makeChoice(2);
        printLineBreak();

        if (choice == 1) {
            crush.addPoints(1);
            System.out.println("Tzuyu: *laughs* Oook there. You think you're good?? *She playfully pokes your " +
                    "stomach* Let's just hurry and finish the cookies!\n");
        } else if (choice == 2) {
            crush.addPoints(0);
            System.out.println("The three of you start placing the cookies onto the tray as Tzuyu begins joking" +
                    " around with Nancy about how great her baking skills are in a failed attempt to impress her. " +
                    "You feel somewhat left out from the conversation and sad that Tzuyu is no longer paying " +
                    "any attention to you. You try not to let it bother you.\n");
        }

        System.out.println("The three of you place the cookies into the oven and prepare to ice the cookies by placing" +
                " the icing into the piping bags.\n");
        System.out.println("Tzuyu: Hey we have a lot of icing leftover...\n");
        System.out.println("Nancy: Lmao just eat all of it.\n");
        System.out.println("Tzuyu: LOL freshman 15 more like freshman 150. You want me to kms??\n");
        System.out.println(name + ":");
        System.out.println("1) Tell her to eat it because she's already heavy anyways");
        System.out.println("2) Take some icing and wipe it on her face");
        System.out.println("3) Take the icing and dump it down the drain");
        choice = makeChoice(3);
        printLineBreak();

        if (choice == 1) {
            crush.removePoints(2);
            System.out.println("Nancy: Ha what kind of comment is that?\n");
            System.out.println("Tzuyu: ...stfu you're so mean :(\n");
            System.out.println("You slap yourself on the inside as she frowns and turns away to ignore you while talking to Nancy.\n");
        } else if (choice == 2) {
            crush.addPoints(1);
            System.out.println("Tzuyu: UAhh ew that's nasty *laughs* Hey close your eyes and hold still! *she stands " +
                    "on her tiptoes and places a blob of icing on your nose*\n");
            System.out.println("Tzuyu: Hehe\n");
            System.out.println("Nancy: *jokingly whispers* Hey don't pop off too hard!\n");
            System.out.println("Tzuyu: Hey! *she laughs while poking Nancy in the stomach* I'm not-- ... I don't... " +
                    "Let's-- let's just finish icing the cookies once they come out!\n");
        } else if (choice == 3) {
            crush.removePoints(1);
            System.out.println("Tzuyu: Wait yo that's food waste!\n");
            System.out.println("Nancy: Well you weren't gonna eat it anyways.\n");
            System.out.println("You wash your hands and prepare to take the cookies out of the oven.\n");
            System.out.println(name + ":");
            System.out.println("1) You jokingly wipe your wet hands on her shirt and play around by splashing water.");
            System.out.println("2) You dry your hands and try to find the oven mitts");
            choice = makeChoice(2);
            printLineBreak();

            if (choice == 1) {
                crush.addPoints(1);
                System.out.println("Tzuyu: Hey! *she laughs and splashes water back at you*\n");
                System.out.println("The two of you have fun for a while despite both now being drenched in water.\n");
            } else if (choice == 2) {
                crush.addPoints(0);
            }
        }

        if (crush.getCurrentPoints() > 3) { //good ending
            System.out.println("The rest of this baking session goes smoothly as the three of you finish up the cookies " +
                    "and made enough to share with everyone. While the cookies were a tad too sweet, you can't help but " +
                    "smile as the three of you jokingly argue over who's fault that was. Tzuyu is happily munching on " +
                    "a cookie despite insisting that the ones you three made were too sweet. As the three of you sit at " +
                    "the dinner table with everyone else, you notice that Tzuyu has drifted over to sit with you as " +
                    "opposed to sitting with Nancy.\n");
        } else {
            System.out.println("The three of you finish baking the cookies and hand them out to people at the party. " +
                    "Although the baking session turned out well, Tzuyu doesn't seem to be paying that much attention " +
                    "to you... Instead she goes back to talking with Nancy or joking around with Seolhyun, sparing occasional " +
                    "glances at you as you bite sadly on your cookie.\n");
        }
        crush.printCurrentPoints();
    }

    //Specialized netflix segment
    private void netflix() {
        int choice;
        System.out.println("The two of you make your way upstairs to the master bedroom.\n");
        System.out.println("The room seems almost perfectly set up for your purposes, with a King-sized bed dominating " +
                "the space and dim lights creating a romantic atmosphere.\n");
        System.out.println("You turn to " + crush.getName() + ".\n");
        System.out.println(name + ":");
        System.out.println("1) Are you ready?");
        choice = makeChoice(1);
        printLineBreak();

        System.out.print("The two of you settle down for a few episodes of ");
        if (crush.getGirlNum() == TZUYU) {
            System.out.println("Gravity Falls.\n");
        } else if (crush.getGirlNum() == NANCY) {
            System.out.println("True Detective.\n");
        } else if (crush.getGirlNum() == CHOA) {
            System.out.println("Hannibal.\n");
        } else if (crush.getGirlNum() == TAYLOR) {
            System.out.println("Gotham.\n");
        } else if (crush.getGirlNum() == MARY) {
            System.out.println("panda documentaries.");
        } else {
            System.out.println("Black Mirror.");
        }

        System.out.println("After a couple episodes you both decide to get up and stretch.\n");

        crush.printCurrentPoints();
    }

    //Tzuyu decorating segment
    private void tzuyuDecorating() {
        int choice;
        System.out.println("Tzuyu: Yes! Okok don't worry  I'll carry the decorating :) Mfw 3 years of arts courses" +
                " and the most use I get out of that is knowing how to decorate a house *laughs*. Hnn what do you want " +
                "to decorate first?\n");
        System.out.println(name + ":");
        System.out.println("1) The Christmas tree");
        System.out.println("2) The rooms");
        choice = makeChoice(2);
        printLineBreak();

        if (choice == 1) {
            tzuyuTree();
            tzuyuRooms();
        } else {
            tzuyuRooms();
            tzuyuTree();
        }

        crush.printCurrentPoints();
    }

    //Tzuyu tree segment helper
    private void tzuyuTree() {
        int choice;
        System.out.println("Tzuyu: Sure, let's do the tree now. I saw last year's tree in the garage on my way in. " +
                "The ornaments are probably in storage upstairs. Let's go get them quickly so we can decorate " +
                "before the others arrive!\n");
        System.out.println(name + ":");
        System.out.println("1) Split up to get the items faster as per her request");
        System.out.println("2) Offer to go get the tree with her as it's probably heavier than she can manage");
        choice = makeChoice(2);
        printLineBreak();

        if (choice == 1) {
            crush.removePoints(1);
            System.out.println("Tzuyu: Oh... sure that's good. Umm... can you go to the garage? I'll get the " +
                    "ornaments. I think it's better that way.\n");
            System.out.println(name + ":");
            System.out.println("1) Ask her why she can't go to the garage");
            System.out.println("2) Take her word for it and get the tree");
            System.out.println("3) Offer to go with her");
            choice = makeChoice(3);
            printLineBreak();

            if (choice == 1) {
                crush.removePoints(1);
                System.out.println("Tzuyu: Oh uhh... I can but... It's a little chilly out. And the garage is " +
                        "basically the same temperature as outside. And I'm wearing pretty thin clothes. But you're " +
                        "more bundled up so... you can go! *she smiles at you seductively*\n");
                System.out.println("You shrug and head out to the garage. You wonder what that was about, why Tzuyu " +
                        "was so apprehensive. It really isn't that cold out here.\n");
            } else if (choice == 2) {
                crush.addPoints(0);
                System.out.println("Tzuyu: Thanks " + name + "! I'll meet you back here with the ornaments.\n");
                System.out.println("As you head out to the garage, it occurs to you that if you had taken a risk. you " +
                        "could have been with Tzuyu right now instead of being alone. You wonder what the other " +
                        "partygoers think of you walking away from a beautiful girl like that, because that's certainly " +
                        "what it looks like.\n");
            } else if (choice == 3) {
                crush.addPoints(1);
                System.out.println("Tzuyu: Oh nawh it's ok, you said we should split up. That's pretty good, we can " +
                        "get everything faster. I'll meet you back here with the ornaments. Thanks though!\n");
                System.out.println("Tzuyu seems happy that you suggested going together. You wonder if she would have gone with you if you suggested it earlier.\n");
            }
        } else if (choice == 2) {
            crush.addPoints(1);
            System.out.println("Tzuyu: Hmm that might be slow though. Ehh whatever, I'm sure we'll have enough time." +
                    " Let's go *she grabs your arm and starts walking towards the garage*\n");
            System.out.println("Despite her apparent worries that you won't have enough time, Tzuyu is smiling and " +
                    "bubbly at your suggestion to go together. The two of you make your way to the garage and quickly " +
                    "locate the dusty Christmas tree sitting in the corner.\n");
            System.out.println(name + ":");
            System.out.println("1) Show off and lift the tree yourself");
            System.out.println("2) Lift the tree with Tzuyu");
            choice = makeChoice(2);
            printLineBreak();

            if (choice == 1) {
                crush.addPoints(1);
                System.out.println("Tzuyu: Whoa whoa careful! Can you really do it by yourself? Do you need help?\n");
            } else if (choice == 2) {
                crush.addPoints(0);
                System.out.println("Tzuyu: Yeah let's carry it together, it must be pretty heavy.\n");
            }

            System.out.println("As you crouch to pick up the tree, you feel a little lightheaded. You sneeze twice in " +
                    "rapid succession. Upon closer inspection, you realize that there is cat fur stuck in the Christmas " +
                    "tree along with dust! Your allergies to cat fur must be acting up.\n");
            System.out.println("Tzuyu: " + name + ", are you okay? You look pale. *she sounds worried*\n");
            System.out.println(name + ":");
            System.out.println("1) Lie and say it's nothing and carry it yourself to be done quicker");
            System.out.println("2) Admit your allergy and carry it with Tzuyu");
            System.out.println("3) Admit your allergy and ask Tzuyu to carry it");
            choice = makeChoice(3);
            printLineBreak();

            if (choice == 1) {
                crush.removePoints(1);
                System.out.println("Tzuyu: What, are you crazy? I don't want you to strain yourself doing it alone! " +
                        "Especially not if you're allergic to the cat fur.\n");
                System.out.println("She saw right through you.\n");
                System.out.println(name + ": Nono it's okay, just open the door for me so I can get this inside quickly.\n");
                System.out.println("Tzuyu: Oh uh okok *she rushes to open the door for you*\n");
                System.out.println("You strain to carry the full weight of the tree and as you slowly waddle to the " +
                        "living room, the lightheaded sensation gets worse and worse. Eventually, you make it to " +
                        "the corner of the living room you two had designated.\n");
                System.out.println("Tzuyu: Holy you did it. How are you holding up? *she puts a concerned hand " +
                        "on your shoulder*\n");
                System.out.println(name + ":");
                System.out.println("1) I'm fine.");
                System.out.println("2) Just a little dizzy.");
                choice = makeChoice(2);
                printLineBreak();

                System.out.println("Just as you are about to respond, your dizziness suddenly gets overwhelming." +
                        " You collapse onto the carpeted floor due to the allergic reaction and overexertion.\n");
                System.out.println("Tzuyu: " + name + "! Are you okay?! *she drops to her knees to check on you." +
                        " She sounds immensely anxious now.\n");
                System.out.println(name + ":");
                System.out.println("1) Wait for the dizziness to fade");
                System.out.println("2) Try to sit up");
                choice = makeChoice(2);
                printLineBreak();

                if (choice == 1) {
                    crush.addPoints(0);
                    System.out.println("You lay still until the uncomfortable sensation finally passes. Eventually " +
                            "you are able to sit up and reassure Tzuyu that you are fine.\n");
                } else if (choice == 2) {
                    crush.addPoints(1);
                    System.out.println("You try futilely to sit up until Tzuyu gently pushes you back down and " +
                            "looks at you with concern. She convinces you to stay still until " +
                            "the allergic reaction dies down. You lay still until the uncomfortable " +
                            "sensation finally passes. Eventually you are able to sit up and " +
                            "reassure Tzuyu that you are fine.\n");
                }

                System.out.println("Tzuyu: Oh thank god. You really scared me there " + name + ". *she pouts* You " +
                        "shouldn't have tried to lift it alone!\n");
                System.out.println("Although the allergic reaction sucked, you admit to yourself that it was kind of " +
                        "nice to have Tzuyu fuss over you like that.\n");
            } else if (choice == 2) {
                crush.addPoints(1);
                System.out.println("Tzuyu: Oh damn you're allergic to cat fur? I can carry it alone if you want. " +
                        "You probably shouldn't provoke your allergy anymore.\n");
                System.out.println(name + ": No it's okay, I don't want you to carry it all by yourself.\n");
                System.out.println("Tzuyu: *blushes* Ok, if you're sure. Grab that end, I'll get this end.\n");
                System.out.println("The two of you lift the tree up and manage to move it inside. As you walk " +
                        "towards the living room, you notice your lightheadedness getting worse. " +
                        "You opt not to tell Tzuyu so as not to worry her. Once you reach the " +
                        "designated corner of the room, you put the tree down and quickly find a " +
                        "loveseat to sit in. Tzuyu follows and sits beside you, looking concerned.\n");
                System.out.println("Tzuyu: " + name + " are you okay? You look a little pale...\n");
                System.out.println(name + ":");
                System.out.println("1) Tell her you feel dizzy and that the allergic reaction was worse than you thought.");
                System.out.println("2) Tell her you're just tired so she won't worry.");
                choice = makeChoice(2);
                printLineBreak();

                if (choice == 1) {
                    crush.addPoints(1);
                    System.out.println("Tzuyu: Oh noo... Will you be okay? I shouldn't have let you carry it with me.\n");
                    System.out.println("She looks at you with concern in her eyes. You can't help but notice how pretty she is, even when she's anxious.\n");
                    System.out.println("After a while the effects fade and you're able to stand again. Tzuyu almost " +
                            "jumps up in joy and relief.\n");
                    System.out.println("Tzuyu: You scared me for a bit there, " + name + ". Wanna decorate the tree now?\n");
                } else if (choice == 2) {
                    crush.removePoints(1);
                    System.out.println("Tzuyu: I can tell it's more than that dude. It's your allergies isn't it? " +
                            "Don't lie to me " + name + ".\n");
                    System.out.println("You curse yourself silently. You should have known that trying to act tough would " +
                            "only set you back with Tzuyu. Regardless, after a " +
                            "the effects fade and you’re able to stand again. Tzuyu smiles when " +
                            "she sees that you’re okay.\n");
                    System.out.println("You had me scared for a bit there. Wanna decorate the tree now?\n");
                }
            } else if (choice == 3) {
                crush.removePoints(1);
                System.out.println("Tzuyu: Oh I see. Yeah I'll carry it don't worry. You probably shouldn't be near " +
                        "it if you're allergic. Help me open the door.\n");
                System.out.println("You hold the door open for her and she picks up the tree. It is obviously much too " +
                        "heavy for her and she has to frequently put it down to rest on her way back to the living room. " +
                        "You feel terrible for making her do all the hard work.\n");
                System.out.println(name + ":");
                System.out.println("1) Offer to hang up all the ornaments so she can rest a bit");
                System.out.println("2) Go get the ornaments so you can hang them up together");
                choice = makeChoice(2);
                printLineBreak();

                if (choice == 1) {
                    crush.removePoints(1);
                    System.out.println("Tzuyu: Oh... if you want. I can hang ornaments, I'm not that tired...\n");
                    System.out.println("You realize that although your intentions were good, it may not have " +
                            "been a good idea to deprive Tzuyu of the chance to decorate the " +
                            "tree with you after carrying in the tree all by herself.\n");
                } else if (choice == 2) {
                    crush.addPoints(1);
                    System.out.println("Tzuyu: Yeyyy thanks! I'll wait here and rest up a bit hehe. Go make yourself" +
                            " useful *she jokingly pushes you*\n");
                    System.out.println("You go upstairs and bring the bag of ornaments downstairs.\n");
                }
            }
        }

        System.out.println("The two of you have a good time decorating the Christmas tree (after some thorough " +
                "cleaning by Tzuyu), sharing laughs and stories. You let Tzuyu put the star on top for the " +
                "finishing touch. The tree brightens the room, restoring a sense of Christmas magic to the party.\n");
        System.out.println("Tzuyu: Yay good job " + name + "! Wanna go do something else?");
        System.out.println(name + ":");
        System.out.println("1) Yes");
        choice = makeChoice(1);
        printLineBreak();
    }

    //Tzuyu rooms segment helper
    private void tzuyuRooms() {
        int choice;

        System.out.println("Tzuyu: Aight these rooms looks pretty bland. Yoyo we should hang lights and streamers! " +
                "It'll look so much nicer.\n");
        System.out.println("You agree that that is the best course of action.\n");
        System.out.println("Tzuyu: Where do you think they're kept?\n");
        System.out.println(name + ":");
        System.out.println("1) In the storage closet upstairs");
        System.out.println("2) In the garage with the Christmas tree");
        choice = makeChoice(2);
        printLineBreak();

        System.out.print("The two of you head for the ");
        if (choice == 1) {
            System.out.print("storage closet");
        } else {
            System.out.print("garage");
        }
        System.out.println(". After fruitless searching, you are forced to admit that you were wrong and that the " +
                "lights and streamers were nowhere to be found.\n");
        System.out.print("Tzuyu: You monkey! I knew they were in the ");
        if (choice == 1) {
            System.out.print("garage");
        } else {
            System.out.print("storage closet");
        }
        System.out.println("! *she pokes you playfully in the abs.* How could you lie to me?\n");

        System.out.println(name + ":");
        System.out.println("1) Defend yourself by saying you weren't lying, just misinformed");
        System.out.println("2) Poke her back in the stomach");
        System.out.println("3) Playfully pull her hair");
        choice = makeChoice(3);
        printLineBreak();

        if (choice == 1) {
            crush.addPoints(0);
            System.out.println("Tzuyu: Haha yeah I know, I'm just playing around with you.\n");
            System.out.println(name + ":");
            System.out.println("1) I'd play around with you anyday :^^^^)");
            System.out.println("2) Okay, thanks for understanding");
            choice = makeChoice(2);
            printLineBreak();

            if (choice == 1) {
                crush.addPoints(1);
                System.out.println("Tzuyu: OOOOOOOK THERE *she blushes and punches you in the arm* Fkn perv.\n");
                System.out.println("Despite the punch, she cannot stop herself from smiling and you feel warm inside " +
                        "knowing that your risky humor has gotten you a bit closer to Tzuyu.\n");
            } else if (choice == 2) {
                crush.addPoints(0);
                System.out.println("Tzuyu: Don't worry I know you aren't a liar.\n");
                System.out.println("Tzuyu smiles at you and you feel warm inside, although you don't feel like you " +
                        "have gotten very far in terms of courtship.\n");
            }
        } else if (choice == 2) {
            crush.addPoints(1);
            System.out.println("Tzuyu: Ahhh! *she recoils and grabs your hand* Stopstopstopstop!\n");
            System.out.println(name + ":");
            System.out.println("1) Stop because she asked");
            System.out.println("2) Keep going for a few more seconds because she deserves it");
            choice = makeChoice(2);
            printLineBreak();

            if (choice == 1) {
                crush.addPoints(0);
                System.out.println("Tzuyu: Phew. You're so nice. Too bad I can abuse that *mischievous smile*. " +
                        "*she pokes you again and blocks you from retaliating*\n");
                System.out.println("You both share a laugh and you joke that she shouldn't have listened when she " +
                        "asked you to stop.\n");
            } else if (choice == 2) {
                crush.addPoints(1);
                System.out.println("Tzuyu: Ahhh stopstopstop!! *she grabs your hand with both of hers*\n");
                System.out.println("When you finally stop, she continues to hold your hand until she catches her " +
                        "breath and playfully complains, \n");
                System.out.println("Tzuyu: You're so mean! I'll get you back someday.\n");
                System.out.println("Despite her threat you can tell that you both had a good time and feel that you " +
                        "are a bit closer to her. You think to yourself that her revenge might not be all that bad for " +
                        "you. The feel of her warm hands in yours lingers in your mind.\n");
            }
        } else if (choice == 3) {
            crush.removePoints(1);
            System.out.println("Tzuyu: Oww! Stop it, that actually hurts dude.\n");

            System.out.println(name + ":");
            System.out.println("1) Immediately stop and apologize");
            System.out.println("2) Keep going for a few more seconds because she deserves it");
            choice = makeChoice(2);
            printLineBreak();

            if (choice == 1) {
                crush.addPoints(0);
                System.out.println("Tzuyu: It's okay. For future, don't ever pull a girl's hair unless she lets you.\n");
                System.out.println("You are glad that you stopped before the situation got any worse.\n");
            } else if (choice == 2) {
                crush.removePoints(2);
                System.out.println("Tzuyu: Ow! Stop! *She pushes you away* That's not funny! It really hurts. " +
                        "You shouldn't pull a girl's hair, ever.\n");
                System.out.println("She turns away from you and starts walking away. You internally slap yourself for " +
                        "not listening and follow her.\n");
            }
        }

        printLineBreak();
        System.out.println("The two of you make your way to where the lights and streamers are being stored. After " +
                "gathering all the stuff and dusting off the lights, the two of you make your way back to the living " +
                "room. On the way back,\n");
        System.out.println(name + ":");
        System.out.println("1) Wrap the lights around Tzuyu so she is tangled in them");
        System.out.println("2) Wrap the lights around yourself to try and make her laugh");
        choice = makeChoice(2);
        printLineBreak();

        if (choice == 1) {
            crush.addPoints(1);
            System.out.println("Tzuyu: Hey what are you doing? *she wrestles the lights away from you and " +
                    "tries to wrap them around you*\n");
            System.out.println("The two of you snatch the lights back and forth and attempt to ensnare the other.\n");
            System.out.println("Eventually, you stumble and fall onto the carpeted floor. Tzuyu is dragged down with " +
                    "you and uses you to break her fall. You find yourself sprawled on the floor with Tzuyu pinning " +
                    "your legs underneath her. Craning your neck, you look up and see that Tzuyu is stifling her " +
                    "laughter. You burst out laughing.\n");
            System.out.println(name + ":");
            System.out.println("1) 'Get off me, you monkey!'");
            System.out.println("2) 'So, when's it my turn to be on top?'");
            System.out.println("3) 'Cmon why are you so heavy?'");
            choice = makeChoice(3);
            printLineBreak();

            if (choice == 1) {
                crush.addPoints(1);
                System.out.println("Tzuyu: It's your fault! *laughs* I don't know what you were expecting. *she " +
                        "scrambles to her feet and extends a hand to help you up*\n");
                System.out.println("When you take her hand, you notice her flush a little. She continues to hold your " +
                        "hand briefly after you stand up.\n");
            } else if (choice == 2) {
                crush.addPoints(1);
                System.out.println("Tzuyu blushes and hits you on the arm repeatedly.\n");
                System.out.println("Tzuyu: Ewww you perv! *she scrambles to her feet and extends a hand to help " +
                        "you up*\n");
                System.out.println("When you take her hand, you notice her flush a little. She continues to hold " +
                        "your hand briefly after you stand up.\n");
            } else if (choice == 3) {
                crush.removePoints(1);
                System.out.println("Tzuyu: Uh... sorry.\n");
                System.out.println("Tzuyu stands and you notice she has an upset expression. You realize your" +
                        " choice of words could've been much better.\n");
            }
        } else if (choice == 2) {
            crush.addPoints(0);
            System.out.println("Tzuyu: *laughs* What are you doing?\n");
            System.out.println("You awkwardly stop what you are doing and stand there, half-wrapped in lights. You " +
                    "succeeded in making her laugh, but you also made yourself look silly. You aren't sure " +
                    "if this helped or hurt your courting.\n");
        }

        printLineBreak();
        System.out.println("The two of you make your way back to the living room.\n");
        System.out.println("Tzuyu: Are you tall enough to reach?\n");
        System.out.println("After standing on tiptoe, you establish that you can't reach high enough to hang up the lights.\n");
        System.out.println("Tzuyu: Hmm... maybe we can get a ladder or a chair?\n");
        System.out.println(name + ":");
        System.out.println("1) Retrieve a chair to stand on");
        System.out.println("2) Offer to lift her up by the waist so she can hang them up.");
        choice = makeChoice(2);
        printLineBreak();

        if (choice == 1) {
            crush.addPoints(1);
            System.out.println("Tzuyu: Thanks " + name + "! Yo lemme do it, engineering kids can't decorate :^)\n");
            System.out.println(name + ":");
            System.out.println("1) Let her hang up the lights");
            System.out.println("2) Hang up the lights to prove you can");
            choice = makeChoice(2);
            printLineBreak();

            if (choice == 1) {
                crush.addPoints(1);
                System.out.println("Tzuyu: Yayy you can support me on the ground. Moral support :^). Also for if I fall.\n");
                System.out.println("Unforunately, Tzuyu doesn't fall and you don't get to be her knight in shining " +
                        "armour. You still made her happy though, so there's that.\n");
            } else if (choice == 2) {
                crush.removePoints(1);
                System.out.println("Tzuyu: Oh... ok. I'll hold the chair still for you I guess.\n");
                System.out.println("Tzuyu doesn't may much attention to you as you hang up the lights, instead looking" +
                        " around the room at other people. You feel a pang of jealousy and curse your fat sense of pride.\n");
            }
        } else if (choice == 2) {
            crush.removePoints(1);
            System.out.println("Tzuyu: Uhh... I think it's better to get something to stand on. You'll get tired" +
                    " and it's probably not as safe.\n");
            System.out.println(name + ":");
            System.out.println("1) Say nothing and go get a chair");
            System.out.println("2) Apologize and go get a chair");
            choice = makeChoice(2);
            printLineBreak();

            if (choice == 1) {
                crush.removePoints(1);
                System.out.println("After you come back, you notice an air of awkwardness after your failed suggestion" +
                        " and ensuing silence. Perhaps you should've said something earlier.\n");
            } else if (choice == 2) {
                crush.addPoints(1);
                System.out.println("Tzuyu: It's okay. I just don't think I'm ready for that yet. Thanks tho.\n");
                System.out.println("You probably shouldn't have offered to lift her up, but at least you remedied the situation in time.\n");
            }
        }

        printLineBreak();
        System.out.println("The two of you hang up the lights, then do the streamers in a similar fashion. Soon, " +
                "the rooms are looking vibrant and much more festive with the red and white colored decor on the" +
                " walls and ceiling.\n");
        System.out.println("Tzuyu: I think that's pretty good. Want to do something else now?\n");
        System.out.println(name + ":");
        System.out.println("1) Yes.");
        choice = makeChoice(1);
        printLineBreak();
    }

    //Nancy baking segment, bad end
    private void nancyBakingBad() {
        int choice;

        System.out.println("Nancy: Okie dokie, so Tzuyu and I will make the cookies, while you can help make the frosting.\n");
        System.out.println("Tzuyu: Hmmm I guess baking alongside Nancy will be fun too. I didn't really need that much help anyways I guess...\n");
        System.out.println(name + ":");
        System.out.println("1) Offer to help bake the cookies instead");
        System.out.println("2) Whip (frosting) vigorously");
        choice = makeChoice(2);
        printLineBreak();

        if (choice == 1) {
            System.out.println("Tzuyu: It's fine I think we have enough people making cookies already, you can just make the frosting instead.\n");
            System.out.println(name + ":");
            System.out.println("1) Whip (frosting) vigorously");
            choice = makeChoice(1);
            printLineBreak();
        }

        System.out.println("Nancy: Aish! You got some on me! You had one job, " + name + "\n");
        System.out.println("Tzuyu: Don't worry, I gotchu Nancy! Geez " + name + " try to be more careful... no need to show off those gains buddi\n");
        System.out.println("Nancy: I think I'll go change now... I have extra clothes upstairs\n");
        System.out.println(name + ":");
        System.out.println("1) Can I come?");
        System.out.println("2) Sorry... I'll finish the batter");
        choice = makeChoice(2);
        printLineBreak();

        if (choice == 1) {
            System.out.println("Tzuyu: OOOOKAY THER. What a dirty perv\n");
            System.out.println("Nancy: Nnn... We'll be right back, you just finish up the batter first.\n");
        } else if (choice == 2) {
            System.out.println("Nancy: Aight thanks mate\n");
            System.out.println("Tzuyu: Okkies, we'll be right back\n");
        }

        System.out.println("You sadly finish up the batter while reminiscing about Nancy's smile. At least the cookies" +
                " came out pretty well, though you can't help but think things would have turned out better if you " +
                "helped Nancy with the batter instead.");

        crush.printCurrentPoints();
    }

    //Nancy decorating segment, bad end
    private void nancyDecoratingBad() {
        int choice;
        boolean isTree = false;
        System.out.println("Nancy: Eh sure. I hope you have experience, I have no idea what I'm doing.\n");
        System.out.println("Tzuyu: Heyhey I have experience! I'll help too!\n");
        System.out.println(name + ":");
        System.out.println("1) Decorate the tree first");
        System.out.println("2) Decorate the rooms first");
        choice = makeChoice(2);
        if (choice == 1) {
            isTree = true;
        }
        printLineBreak();

        System.out.print("Nancy: We can split up. Tzuyu and I will do the ");
        if (isTree) {
            System.out.print("rooms");
        } else {
            System.out.print("tree");
        }
        System.out.print(", and you can do the ");
        if (isTree) {
            System.out.print("tree ");
        } else {
            System.out.print("rooms ");
        }
        System.out.println("since you wanted to.\n");
        System.out.println("Tzuyu: Yayy I get to be with Nancy!\n");
        System.out.println(name + ":");
        System.out.print("1) Offer to help with the ");
        if (isTree) {
            System.out.print("rooms ");
        } else {
            System.out.print("tree ");
        }
        System.out.println("too");
        System.out.print("2) Go decorate the ");
        if (isTree) {
            System.out.print("tree ");
        } else {
            System.out.print("rooms ");
        }
        System.out.println("alone");
        choice = makeChoice(2);
        printLineBreak();

        if (choice == 1) {
            System.out.print("Nancy: Nawh I think we have enough people working on the");
            if (isTree) {
                System.out.print("rooms ");
            } else {
                System.out.print("tree ");
            }
            System.out.print("already. You should get the ");
            if (isTree) {
                System.out.print("tree ");
            } else {
                System.out.print("rooms ");
            }
            System.out.println("done!\n");
            System.out.println(name + ":");
            System.out.print("1) Go decorate the ");
            if (isTree) {
                System.out.print("tree ");
            } else {
                System.out.print("rooms ");
            }
            System.out.println("alone");
            choice = makeChoice(1);
            printLineBreak();
        }

        System.out.println("Nancy: Okay have funn. Cya in a bit.\n");
        System.out.println("Tzuyu: Byee.\n");
        System.out.print("You sadly retrieve the ");
        if (isTree) {
            System.out.print("bag of ornaments ");
        } else {
            System.out.print("festive lights ");
        }
        System.out.print("and hang them up as you watch Tzuyu and Nancy have a great time ");
        if (isTree) {
            System.out.print("in the adjacent room. ");
        } else {
            System.out.print(" by the Christmas tree. ");
        }
        System.out.println("After half an hour you all reconvene, and although the" +
                " house is much more lively now, you feel pangs of regret that you were stuck by yourself instead " +
                "of helping Nancy. If only she--and Tzuyu--would give you a chance...\n");

        crush.printCurrentPoints();
    }

    //Nancy baking segment, good end
    private void nancyBakingGood() {
        int choice;

        System.out.println("Nancy: Okie dokie, so the two of us can make the cookies while Tzuyu makes the frosting.\n");
        System.out.println("Tzuyu: Nnn-- I wanted to make with Nancy instead...\n");
        System.out.println("Nancy: Tzuyu can you help me get the mixer? We'll need that later to make the dough.\n");
        System.out.println("Tzuyu: Alright I guess that's fine too... hehe as long as I can help out in some way.\n");
        System.out.println("You managed to be alone with Nancy (finally), what do you do?\n");
        System.out.println(name + ":");
        System.out.println("1) Brag about your baking skills");
        System.out.println("2) Start telling a joke");
        System.out.println("3) Try to find all the materials needed");
        choice = makeChoice(3);
        printLineBreak();

        if (choice == 1) {
            crush.removePoints(1);
            System.out.println("Nancy: Sooooo you'll carry us right? I'm not actually good at cooking.\n");
            System.out.println("You realize that you have no idea how to make the cookies and scared of the " +
                    "consequences, you admit that you aren't any good at baking either and feel regret as she " +
                    "rolls her eyes at your obnoxiousness.\n");
        } else if (choice == 2) {
            crush.addPoints(0);
            System.out.println("Nancy: Oh yeah haha I saw that one on the front page of reddit yesterday.\n");
            System.out.println("You scramble to think of a better joke but come up blank. Hey, you tried.\n");
        } else if (choice == 3) {
            crush.addPoints(1);
            System.out.println("You look through the cupboards to find all the measuring cups and bowls needed, but you" +
                    " can't find the oven mitts... Finally you turn around and spot them hanging by the oven. You reach" +
                    " over but brush against something small and cold. Nancy's hands were also about to grab the mitts." +
                    " She distractedly stares at you for a while then recoils, leaving you to grab them.\n");
            System.out.println(name + ":");
            System.out.println("1) Ask if she's cold and offer to warm up near the fireplace until Tzuyu returns");
            System.out.println("2) Praise and inquire about her experience as a professional gamer");
            System.out.println("3) Apologize for bumping into her");
            choice = makeChoice(3);
            printLineBreak();

            if (choice == 1) {
                crush.addPoints(1);
                System.out.println("Nancy: Mmmm okay. It is a bit chilly. I probably didn't get enough sleep. I" +
                        " was *yawn* waiting for the server maintenance to finish.\n");
                System.out.println(name + ":");
                System.out.println("1) Hum a Christmas song");
                System.out.println("2) Reach for her hands");
                choice = makeChoice(2);
                printLineBreak();

                if (choice == 1) {
                    crush.addPoints(1);
                    System.out.println("You decide to hum a christmas song to brighten up the mood, but after a while " +
                            "you feel a sudden weight on your shoulder. Nancy fell asleep from the warmth radiating " +
                            "from the fireplace and from your humming. You find it hard to take your eyes away from " +
                            "her resting face, and feel a warmth in your chest when you hear her sigh,\n");
                    System.out.println("Nancy: You have a pretty voice.\n");
                } else if (choice == 2) {
                    crush.addPoints(0);
                    System.out.println("You spend so much time hesitating before making the move that Nancy has fallen " +
                            "asleep from the comforting silence and warm glow of the fireplace. As her head gently " +
                            "rests on your shoulder, you can hear her soft breathing, making your heart race. You " +
                            "place your hand on top of hers anyways, wishing that time would stop.\n");
                }

                System.out.println("The two of you await in peace in front of the fireplace until Tzuyu's return.\n");
            } else if (choice == 2) {
                crush.addPoints(1);
                System.out.println("Nancy: Well, it wasn't easy getting there, but it was so worth it. I don't think I" +
                        " could ever work that 9 to 5 rat race. The whole hierarchy is so toxic.\n");
                System.out.println(name + ":");
                System.out.println("1) You just have to be yourself. People will like you for who you are.");
                System.out.println("2) I admire how you carve your own way in life");
                System.out.println("3) Have you tried working out? :^)");
                choice = makeChoice(3);
                printLineBreak();

                if (choice == 1) {
                    crush.removePoints(1);
                    System.out.println("Nancy: I guess you just don't get it. Hn. Sorry, I made the atmosphere bad.\n");
                } else if (choice == 2) {
                    crush.addPoints(1);
                    System.out.println("Nancy: Hey, if you ever want to setup your own stream hit me up.\n");
                    System.out.println(name + ":");
                    System.out.println("1) It's ok, I don't think streaming is a sustainable career");
                    System.out.println("2) Yeah definitely, I've always wanted to");
                    System.out.println("3) I'd hit that anyday :^)");
                    choice = makeChoice(3);
                    printLineBreak();

                    if (choice == 1) {
                        crush.removePoints(1);
                        System.out.println("Nancy: I guess I can respect that. Different strides for different people.\n");
                        System.out.println("Nancy shrugs and is noticeably quieter afterwards. You realize you could " +
                                "have been more receptive of her offer in order to build trust.\n");
                    } else if (choice == 2) {
                        crush.addPoints(1);
                        System.out.println("Nancy: It's definitely more fun than sitting in a lecture hall or office " +
                                "building all day. Maybe we can even stream together sometime.\n");
                        System.out.println("Nancy smiles at you and you feel warm and fuzzy inside.\n");
                    } else if (choice == 3) {
                        crush.addPoints(0);
                        System.out.println("Nancy: Oook buddy. How about you hit this parchment paper with some cookie batter?\n");
                    }
                } else if (choice == 3) {
                    crush.addPoints(0);
                    System.out.println("haHAA nice meme.\n");
                }
            } else if (choice == 3) {
                crush.addPoints(0);
                System.out.println("Nancy: Nah, it was my bad. Let's get back to work friendo.\n");
                System.out.println(name + ":");
                System.out.println("1) I'm not your friend, buddy.");
                System.out.println("2) Nono, it's okay");
                System.out.println("3) It was kind of nice, actually...");
                choice = makeChoice(3);
                printLineBreak();

                if (choice == 1) {
                    crush.addPoints(1);
                    System.out.println("Nancy: Ha, I'm not your buddy, pal.\n");
                    System.out.println(name + ": I'm not your pal, guy.\n");
                    System.out.println("This goes on for a while. Nancy is visibly pleased by your power level.\n");
                } else if (choice == 2) {
                    crush.addPoints(0);
                    System.out.println("Nancy: K. Whatever floats your boat.\n");
                    System.out.println("The two of you go back to preparing the tray. What did you expect?\n");
                } else if (choice == 3) {
                    crush.removePoints(1);
                    System.out.println("Nancy: Dude. How can you even face yourself in the mirror each morning?\n");
                    System.out.println("Nancy squints her eyes at you and you feel yourself turning beet red.\n");
                    System.out.println(name + ": Uhh... That wasn't supposed to be out loud?\n");
                    System.out.println("The two of you prep the baking tray in awkward silence.");
                }
            }
        }

        printLineBreak();
        System.out.println("Eventually Tzuyu returns with the mixer.\n");
        System.out.println("Tzuyu: Heyyo! I brought the mixer up! See who's the hard carry NOW!\n");
        System.out.println("Nancy: Good job. I guess you're not a total scrub, hehe. Let's hurry and finish making the" +
                " cookies--I'm getting hungry.\n");
        System.out.println("Nancy pouts. She's cute when she's making faces.\n");
        System.out.println("The rest of the baking goes along smoothly but when it's time for cleanup, you spot some" +
                " leftover icing on the ground. Nobody else seems to have noticed it. You...\n");
        System.out.println(name + ":");
        System.out.println("1) Clean up the icing yourself");
        System.out.println("2) Tell Nancy to clean it up");
        System.out.println("3) Leave it there to clean up later");
        choice = makeChoice(3);
        printLineBreak();

        if (choice == 1) {
            crush.addPoints(1);
            System.out.println("You grab a tissue paper and bend down to clean up the icing.\n");
            System.out.println("Nancy: Ayyy, my hero. Less work for me. Well, it's still going to be sticky and gross " +
                    "'cause of the sugar though.\n");
            System.out.println(name + ":");
            System.out.println("1) Point out that it was just a spot.");
            System.out.println("2) Offer to clean the whole kitchen floor.");
            choice = makeChoice(2);
            printLineBreak();

            if (choice == 1) {
                crush.addPoints(1);
                System.out.println("Nancy: Yeah I supposed that's true. Maybe I'll just go over it later.\n");
            } else if (choice == 2) {
                crush.removePoints(1);
                System.out.println("Nancy: Nooo, that's really okay... You shouldn't let people use you like that," +
                        " " + name + ". We should try the cookies while they're still fresh.\n");
            }
        } else if (choice == 2) {
            crush.removePoints(1);
            System.out.println("You put your hand on Nancy's shoulder to get her attention. SHe turns around " +
                    "and looks at you hopefully.\n");
            System.out.println(name + ": Hey, there's some icing that fell on the ground over there. Can you " +
                    "go wipe it up? I'll do these dishes.\n");
            System.out.println("Nancy: I mean I already started the dishes... Nnnn. Ok boss.\n");
            System.out.println("Nancy walks over and wipes up the icing on the ground. You swear you hear her grumble.\n");
        } else if (choice == 3) {
            crush.addPoints(2);
            System.out.println("You decide to clean it up later because you have your hands full with the dishes right" +
                    " now. It was only a few seconds later that you begin to think that your procrastinating nature" +
                    " might actually be beneficial.\n");
            System.out.println("As Nancy walks towards you after putting the measuring cups away, she steps in the " +
                    "icing and slips--only to fall on you and knock both of you onto the ground, faces only inches" +
                    " away from each other. Both of you nervously look away as embarrassment crawls onto your cheeks.\n");
            System.out.println("Nancy: Oh ahh sorry about that " + name + "... Let's just finish cleaning and serve " +
                    "everyone the cookies.\n");
            System.out.println("You nod as you stand up. Looking over at Nancy, you see that although she is red with" +
                    " embarrassment, she is barely concealing a smile. You reach out with your hand and she pulls herself up.\n");
        }

        //Good/bad ending TODO
        crush.printCurrentPoints();
    }

    //Nancy decorating segment, good end
    private void nancyDecoratingGood() {
        int choice;
        String bet = "";

        System.out.println("Nancy: Oh really? I hope you like carrying. I have no idea what I'm doing.\n");
        System.out.println("Tzuyu: I have experience! We're gonna need ornaments for the tree and lights and posters to stick on the walls.\n");
        System.out.println(name + ": Someone has to go get them from storage. I call not it.\n");
        System.out.println("Nancy: Not it!!!\n");
        System.out.println("Tzuyu: Wait what? Really guys?\n");
        System.out.println("Nancy: Git rekt. You can go get the stuff while " + name + " and I chill here. *smirks*\n");
        System.out.println("Tzuyu facepalms and walks out to find the decorations. Nancy plops down on the couch and you sit down beside her.\n");
        System.out.println(name + ":");
        System.out.println("1) Ask about her dating history");
        System.out.println("2) Ask about what she looks for in boys");
        System.out.println("3) Make a bet for the first thing Tzuyu says upon coming back");
        choice = makeChoice(3);
        printLineBreak();

        if (choice == 1) {
            crush.addPoints(0);
            System.out.println(name + ": Have you been with anyone before? Boys must be clamoring to go out with you.\n");
            System.out.println("Nancy: No, actually... I've gone on a few first dates before but they didn't really work out.\n");
            System.out.println(name + ":");
            System.out.println("1) You should go out with me, I work out");
            System.out.println("2) Offer your sympathy");
            System.out.println("3) Jokingly suggest that she is the common denominator");
            choice = makeChoice(3);
            printLineBreak();

            if (choice == 1) {
                crush.addPoints(2);
                System.out.println("Nancy laughs and hits you with a couch cushion.\n");
                System.out.println("Nancy: Pls. Everyone knows engineers are scrawny, nerdy kids.\n");
                System.out.println(name + ": Yea you're right. The only muscle I have to work out is my brain.\n");
                System.out.println("Nancy: *giggles* I think you have to work out more then. I'm 99% sure the brain isn't a muscle.\n");
                System.out.println("The two of you banter more and Nancy laughs at most of your jokes.\n");
            } else if (choice == 2) {
                crush.addPoints(0);
                System.out.println("Nancy: It's alright. I usually give it a go if I think there's a chance of it " +
                        "working out. I guess it's just been unlucky so far.\n");
                System.out.println("You don't really know what to say to that. \n");
            } else if (choice == 3) {
                crush.removePoints(1);
                System.out.println("Nancy: Wow ok. Maybe I'm the problem.\n");
                System.out.println("Nancy obviously didn't take your joke well. You internally slap yourself for not " +
                        "thinking before you speak.\n");
            }
        } else if (choice == 2) {
            crush.addPoints(1);
            System.out.println("Nancy: If I had to say, I think I like the cool, nerdy type. Y'know, someone kinda " +
                    "similar to me. Intelligence is great, obviously. It'd be nice if they could game with me " +
                    "or just chill instead of going to parties all the time.\n");
            System.out.println(name + ":");
            System.out.println("1) Jokingly remark that that sounds like you.");
            System.out.println("2) Seriously remark that that sounds like you.");
            choice = makeChoice(2);
            printLineBreak();

            if (choice == 1) {
                crush.addPoints(1);
                System.out.println("Nancy: Yeah, I guess you can't get much nerdier than engineering huh? Don't worry, " +
                        "you're pretty cool too.\n");
                System.out.println(name + ": Not only that, I could probably smash you in League too.\n");
                System.out.println("Nancy laughs at your ridiculous claim. You have no chance and she knows it.\n");
                System.out.println("Nancy: Ha, we can 1v1 sometime. I'll stream it so all my viewers can witness me smash you into the ground.\n");
            } else if (choice == 2) {
                crush.addPoints(0);
                System.out.println("Nancy: Uhh yeah... I guess it does.\n");
                System.out.println("The two of you sit quietly for a bit. What were you expecting?\n");
            }
        } else if (choice == 3) {
            crush.addPoints(1);
            System.out.println("Nancy: Ha, you're way out of your depth. I know Tzuyu better than she knows herself. " +
                    "But I'll take you up on that. What do you want to bet?\n");
            System.out.println(name + ":");
            System.out.println("1) Bragging rights");
            System.out.println("2) $1");
            System.out.println("3) A headpat");
            System.out.println("4) Your life's savings");
            choice = makeChoice(4);
            printLineBreak();

            if (choice == 1) {
                crush.removePoints(1);
                bet = "nobet";
                System.out.println("Nancy: Aw that's no fun. I gotta pay the bills with your defeat y'know.\n");
                System.out.println("You probably should have offered something of substance, you cheap bastard.\n");
            } else if (choice == 2) {
                crush.addPoints(1);
                bet = "dollar";
                System.out.println("Nancy: Ok you're on. I'll be rolling in dough after this kappa.\n");
                System.out.println(name + ": I'll be sure to let everyone know when you pay up.\n");
                System.out.println("Nancy: What do you think she's going to say?\n");
                System.out.println(name + ":");
                System.out.println("1) Hey guys I gottem");
                System.out.println("2) You guys suck");
                System.out.println("3) My job here is done");
                choice = makeChoice(3);
                printLineBreak();

                System.out.println("Nancy: Nawh, she's gonna come back and just be out of breath.\n");
                System.out.println(name + ": Lol wtf\n");
                System.out.println("Nancy: Trust me.\n");
            } else if (choice == 3) {
                crush.addPoints(1);
                bet = "headpat";
                System.out.println("Nancy: Ohh uhh... Sure. You into that kind of thing?\n");
                System.out.println(name + ": Who isn't? Headpats are the best.\n");
                System.out.println("Nancy: Can't argue with that. What do you think she's going to say?\n");
                System.out.println(name + ":");
                System.out.println("1) Hey guys I gottem");
                System.out.println("2) You guys suck");
                System.out.println("3) My job here is done");
                choice = makeChoice(3);
                printLineBreak();

                System.out.println("Nancy: Nawh, she's gonna come back and just be out of breath.\n");
                System.out.println(name + ": Lol wtf\n");
                System.out.println("Nancy: Trust me.\n");
            } else if (choice == 4) {
                crush.addPoints(0);
                bet = "nobet";
                System.out.println("Nancy: So what're we talking, like $1\n");
                System.out.println("You feel yourself turning as red as the flame you just got burned with.\n");
                System.out.println("Nancy: *laughs* It's ok, I don't want your $1 savings.\n");
            }
        }

        printLineBreak();
        System.out.println("After a while Tzuyu returns with bags in hand. She drops them on the ground and plops" +
                " down on the couch next to you, panting slightly.\n");

        if (bet.equals("dollar")) {
            System.out.println("You and Nancy exchange looks and burst into laughter. You hand Nancy a loonie.\n");
            System.out.println("Tzuyu: What?\n");
            System.out.println("Nancy: Nothing. Just won a bet. You look like you just ran a marathon.\n");
            System.out.println("Tzuyu: *huffing* There were a lot of stairs, jeez. James asked me for a favor on the way here, so I'll be right back.\n");
        } else if (bet.equals("headpat")) {
            System.out.println("You and Nancy exchange looks and burst into laughter.\n");
            System.out.println("Tzuyu: What?\n");
            System.out.println("Nancy: Nothing. Just won a bet. You look like you just ran a marathon.\n");
            System.out.println("Tzuyu: *huffing* There were a lot of stairs, jeez. James asked me for a favor on the way here, so I'll be right back.\n");
            System.out.println("Nancy: Get destroyed.\n");
            System.out.println(name + ": Yea yea lucky guess. How does this work?\n");
            System.out.println("Nancy: Normally I'd get to pat your head, but... if you want, you can pat mine. I like them too.\n");
            System.out.println("Nancy blushes slightly as you gingerly pat her head. You feel warm and fuzzy inside.\n");
        } else if (bet.equals("nobet")) {
            System.out.println("Nancy: See I would've won. I was going to say she'll just be a little out of breath.\n");
            System.out.println("Tzuyu: What?\n");
            System.out.println(name + ": Nothing.\n");
            System.out.println("Tzuyu: Ok... James asked me for a favor on the way here, so I'll be right back.\n");
        } else {
            System.out.println("Nancy: Hey welcome back.\n");
            System.out.println("Tzuyu: Ugh James asked me for a favor on the way here, so I'll be right back.\n");
            System.out.println(name + ": Haha, sucker.\n");
            System.out.println("Tzuyu grumbles as she walks off. You turn to Nancy.\n");
        }

        System.out.println("Nancy: Should we wait for Tzuyu to come back again?\n");
        System.out.println(name + ": Nah, she'll probably take a while. Let's just get a head start.\n");

        // Good/bad ending TODO

        crush.printCurrentPoints();
    }

    //Choa video games segment
    private void choaVideoGames() {
        int choice;

        System.out.println("Choa: Ay lmao. Lemme get my laptop, it's upstairs.\n");
        System.out.println(name + ":");
        System.out.println("1) Offer to go upstairs with Choa since a lot of people are gathered downstairs.");
        System.out.println("2) Offer to get it for her since you are going to get yours anyway.");
        choice = makeChoice(2);
        printLineBreak();

        if (choice == 1) {
            crush.addPoints(1);
            System.out.println("Choa: Alright let's go. We can just stay upstairs and play, it's too noisy here.\n");
            System.out.println("You both go upstairs to get your laptops while talking about your experiences with the game thus far.\n");
        } else if (choice == 2) {
            crush.removePoints(1);
            System.out.println("Choa: Oh okay, thanks... I was planning to go upstairs, but I guess here is fine too...\n");
            System.out.println("As you climb the stairs, you can't stop thinking about Choa's upset expression and you" +
                    " realize you probably should have picked a quieter place to play. After making your way back down," +
                    " you notice that Choa is less willing to talk to you now.\n");
        }

        System.out.println("Choa: You know, it's strange to see someone as smart and busy as you still hold interest " +
                "in playing League. Oh yeah, how good are you? I'm top tier diamond!\n");
        System.out.println(name + ":");
        System.out.println("1) Lie and tell her you're also diamond in hopes of impressing her.");
        System.out.println("2) Joke and say you're a trash tier rank (bronze)");
        System.out.println("3) Tell the truth about what rank you are (gold)");
        choice = makeChoice(3);
        printLineBreak();

        if (choice == 1) {
            crush.removePoints(1);
            System.out.println("Choa: Ohhh nice, lemme add you... Doesn't this say you're gold though? You don't have " +
                    "to lie just to look good...\n");
            System.out.println("You get the feeling the lie probably hurt you more than it helped.\n");
        } else if (choice == 2) {
            crush.addPoints(1);
            System.out.println("Choa: *laughs* Oh of course, I'm actually bronze too.\n");
        } else if (choice == 3) {
            crush.addPoints(0);
            System.out.println("Choa: Well that's not bad! Don't worry I'll carry you and you'll be diamond in no time.\n");
        }

        System.out.println("You start up a game and Choa becomes visibly more excited and bubbly.\n");
        System.out.println("Choa: But really " + name + ", how can you play League and still do so well in school? " +
                "Teach me your secret ehehe.\n");
        System.out.println(name + ":");
        System.out.println("1) Jokingly tell her it's because she's just bad.");
        System.out.println("2) Explain that you try to balance your time equally between playing and working.");
        choice = makeChoice(2);
        printLineBreak();

        if (choice == 1) {
            crush.removePoints(1);
            System.out.println("Choa: OOOOOK ther. *she laughs but her expression quickly sours* Maybe I am just bad." +
                    " I didn't do very well this term...\n");
            System.out.println(name + ":");
            System.out.println("1) Comfort her and tell her it's okay.");
            System.out.println("2) Jokingly tell her that she's even worse than you thought.");
            System.out.println("3) Persuade her that this term was an anomaly.");
            choice = makeChoice(3);
            printLineBreak();

            if (choice == 1) {
                crush.addPoints(0);
                System.out.println("That's easy for you to say. You're done with school already. And in just 4 years " +
                        "too... I'm not even close to done and I'm already stuck. I wish I could breeze through like you.\n");
                System.out.println(name + ":");
                System.out.println("1) Tell her it wasn't easy for you either.");
                System.out.println("2) Tell her you know she's smart and that things are bound to get better.");
                choice = makeChoice(2);
                printLineBreak();

                if (choice == 1) {
                    crush.addPoints(0);
                    System.out.println("Choa: I guess... Still... You got a Master's in 4 years. That's gotta mean something.\n");
                } else if (choice == 2) {
                    crush.addPoints(2);
                    System.out.println("Choa: *smiles and covers her face briefly* Thanks man. Come on, the game's starting!\n");
                }
            } else if (choice == 2) {
                crush.setPoints(0);
                System.out.println("Choa: That's really mean actually...\n");
                System.out.println("Choa is silent for the rest of your gaming session. You can sense you messed up, big time." +
                        " An eternity later, Choa seems like she's calmed down enough to talk to you again.\n");
                return;
            } else if (choice == 3) {
                crush.addPoints(0);
                System.out.println("Choa: Yeah I hope so... it just hurts my confidence to do poorly in something I used to be confident in.\n");
                System.out.println(name + ":");
                System.out.println("1) Tell her not to let it get her down.");
                System.out.println("2) Joke that since she's at rock-to-bottom, things can only get better from here.");
                choice = makeChoice(2);
                printLineBreak();

                if (choice == 1) {
                    crush.addPoints(0);
                    System.out.println("Choa: Yeah... you're right. I can still rebound from here. Thanks bro. Let's focus on the game now!\n");
                } else if (choice == 2) {
                    crush.addPoints(1);
                    System.out.println("Choa: *cracks a smile* Well I guess you're not wrong... Come on, game's starting!\n");
                }
            }
        } else if (choice == 2) {
            crush.addPoints(0);
            System.out.println("Choa: That's easier said than done though. I sometimes get carried away while playing " +
                    "with friends. I'm a massive procrastinator.\n");
            System.out.println(name + ":");
            System.out.println("1) Explain that you try to follow a set schedule everyday when it comes to studying and gaming.");
            System.out.println("2) Hi a massive procrastinator, I'm dad");
            choice = makeChoice(2);
            printLineBreak();

            if (choice == 1) {
                crush.removePoints(1);
                System.out.println("Choa: You don't think I've tried that already? It didn't work...\n");
                System.out.println(name + ":");
                System.out.println("1) Suggest hanging out with friends as a stress-reliever");
                System.out.println("2) Suggest going out together sometime as a stress-reliever");
                choice = makeChoice(2);
                printLineBreak();

                if (choice == 1) {
                    crush.addPoints(1);
                    System.out.println("Choa: Yeh I think that might be good for me. It's been awhile since I saw a lot of my old friends.\n");
                    System.out.println(name + ": You should invite them out to do something for the holidays!\n");
                    System.out.println("Choa: Good idea, I probably will. Thanks, " + name + " :)\n");
                    System.out.println("Choa seems happy with your suggestion. You feel that you have gained a little bit of trust.\n");
                } else if (choice == 2) {
                    crush.removePoints(1);
                    System.out.println("Choa: Oh... um... this is pretty sudden. I need to think about it first...\n");
                    System.out.println("Choa quickly averts her gaze and you internally curse yourself for advancing too quickly.\n");
                }
            } else if (choice == 2) {
                crush.addPoints(1);
                System.out.println("Choa: *laughs* Wowwwwwwwwww. Very punny, dad. I don't know you hehe\n");
                System.out.println(name + ":");
                System.out.println("1) Insist that she found it funny");
                System.out.println("2) Dismiss your lame joke and focus on the game");
                choice = makeChoice(2);
                printLineBreak();

                if (choice == 1) {
                    crush.addPoints(1);
                    System.out.println("Choa: No man, it was SO bad. *smiles*\n");
                    System.out.println("You feel satisfied that Choa accepted your terrible sense of humor.\n");
                } else if (choice == 2) {
                    crush.addPoints(0);
                    System.out.println("Choa: Maybe if you spent less time on your dad jokes, you would be better at League.\n");
                }
            }
        }

        System.out.println("The two of you play a few games and win the last game.\n");
        System.out.println("Choa: FeelsGoodMan. Let's finish on a good note. Want to go do something else?\n");

        crush.printCurrentPoints();
    }

    //Choa food segment
    private void choaFood() {
        int choice;
        System.out.println("Choa: I wanna try some chocolate mousse! I hope they have some...\n");
        System.out.println("The two of you make your way to the kitchen. Upon opening the fridge, you notice that there" +
                " is only one slice of chocolate mousse cake left.\n");
        System.out.println(name + ":");
        System.out.println("1) Insist that she have the cake and pretend you don't like sweets.");
        System.out.println("2) Offer to share the cake with her.");
        choice = makeChoice(2);
        printLineBreak();

        if (choice == 1) {
            crush.addPoints(0);
            System.out.println("Choa: That's so nice of you!\n");
            System.out.println("You grab the slice of chocolate mousse for Choa and a slice of cheesecake for yourself.\n");
            System.out.println("Choa: I thought you didn't like sweets?\n");
            System.out.println(name + ":");
            System.out.println("1) Continue to lie and say that cheesecake isn't as sweet as some of the other options");
            System.out.println("2) Confess that you do like sweets too but you wanted her to have the last slice of chocolate mousse");
            System.out.println("3) Joke that nothing is sweet compared to her, so it's fine");
            choice = makeChoice(3);
            printLineBreak();

            if (choice == 1) {
                crush.removePoints(1);
                System.out.println("Choa: Uhh are you sure? Cheesecake is pretty sweet bro. I hope you aren't digging yourself into a hole...\n");
            } else if (choice == 2) {
                crush.addPoints(0);
                System.out.println("Choa: Awwh... now I feel bad. You can try some if you want!\n");
                System.out.println("As you spoon a small bite of her cake, it strikes you that you ended up sharing the cake anyway, despite your original intention.\n");
            } else if (choice == 3) {
                crush.addPoints(1);
                System.out.println("Choa: OKKK there. How are you so smooth?\n");
                System.out.println(name + ": It just comes to me haha\n");
            }

            System.out.println("The two of you go into the den to enjoy your dessert.\n");
        } else if (choice == 2) {
            crush.addPoints(1);
            System.out.println("Choa: *laughs to cover up her embarrassment* Sure.\n");
            System.out.println("You take the piece of chocolate mousse and she tugs your arm.\n");
            System.out.println("Choa: Let's go find a place to sit.\n");
            System.out.println(name + ":");
            System.out.println("1) Suggest going back to the living room where everyone is.");
            System.out.println("2) Suggest finding a more private and quieter room to eat.");
            choice = makeChoice(2);
            printLineBreak();

            if (choice == 1) {
                crush.removePoints(1);
                System.out.println("Choa: Oh... sure. Don't you find it a little loud in there with everyone " +
                        "talking and partying?\n");
                System.out.println("You realize she probably wanted to go somewhere quieter.\n");
            } else if (choice == 2) {
                crush.addPoints(1);
                System.out.println("Choa: Okok good idea. It's pretty loud and crowded in the living room.\n");
                System.out.println("The two of you go into the den to enjoy your dessert.\n");
            }
        }

        System.out.println("As the two of you eat your cake in mostly silence, you decide it would probably be " +
                "in your best interest to try and make conversation.\n");
        System.out.println(name + ":");
        System.out.println("1) What are you majoring in? For your sake I hope it isn't Engineering *laughs*");
        System.out.println("2) This cake is so good it makes me kreygasm *imitates kreygasm*");
        choice = makeChoice(2);
        printLineBreak();

        if (choice == 1) {
            crush.addPoints(0);
            System.out.println("Choa: I'm in arts, chose the easy life hehe. But I'm majoring in Computer Science.\n");
            System.out.println(name + ": Oh what are you hoping to do with it after you graduate? That's a pretty applicable major.\n");
            System.out.println("Choa: Probably a web designer, I always thought their job was cool.\n");
            System.out.println(name + ":");
            System.out.println("1) Compliment her art and encourage her aspirations.");
            System.out.println("2) Ask her to show you some of her work.");
            System.out.println("3) Ask what a web designer does.");
            choice = makeChoice(3);
            printLineBreak();

            if (choice == 1) {
                crush.addPoints(1);
                System.out.println("Choa: Eyy thanks bro. Where've you seen my stuff before?\n");
                System.out.println(name + ":");
                System.out.println("1) Say you've seen her art online.");
                System.out.println("2) Say you've seen her doodling at school.");
                choice = makeChoice(2);
                printLineBreak();

                if (choice == 1) {
                    crush.removePoints(1);
                    System.out.println("Choa: Huh, that's strange. I don't remember telling you my online name?\n");
                    System.out.println("You decide to drop the topic before you come off as creepy.\n");
                } else if (choice == 2) {
                    crush.addPoints(0);
                    System.out.println("Choa: Oh really? You should have come and say hi! Although I guess we didn't really talk a lot.\n");
                }
            } else if (choice == 2) {
                crush.addPoints(0);
                System.out.println("Choa opens her phone and shows you some of her artwork. You remark that she is " +
                        "pretty good, and she says thanks. The conversation does not really lead anywhere though.\n");
            } else if (choice == 3) {
                crush.removePoints(1);
                System.out.println("Choa: Aren't you an engineer? I would've thought you would know what a web designer does.\n");
                System.out.println("Choa explains the basics of the job while you feel silly and embarrassed.\n");
            }
        } else if (choice == 2) {
            crush.addPoints(1);
            System.out.println("Choa: *giggles* ok dere.\n");
            System.out.println(name + ": No really, it's so good. It tastes almost as good as you look ;)\n");
            System.out.println("Choa: *laughs* haha nice joke, how are you so funny *she says sarcastically*\n");
            System.out.println(name + ":");
            System.out.println("1) Jokingly boast about how great your sense of humour is.");
            System.out.println("2) Dismiss your joke and try to change the topic.");
            choice = makeChoice(2);
            printLineBreak();

            if (choice == 1) {
                crush.addPoints(1);
                System.out.println(name + ": Haven't you heard? I'm one of the best comedians out there.\n");
                System.out.println("Choa: Are you sure? I bet I can do better.\n");
                System.out.println("The two of you exchange bad jokes and pick-up lines while enjoying your cakes. " +
                        "Choa appears to be pleased with your awkward sense of humour and laughed a lot. " +
                        "You feel that she is a bit closer to you now.\n");
            } else if (choice == 2) {
                crush.removePoints(1);
                System.out.println("You and Choa continue to have some small talk, but it eventually fades into silence. " +
                        "Coming up with spontaneous topics is harder than you thought.\n");
            }
        }

        printLineBreak();
        System.out.println("As you finish up your cake, Choa seems satisfied with her dessert.\n");
        System.out.println("Choa: That cake was good! Wanna come do something else with me?\n");
        System.out.println(name + ":");
        System.out.println("1) Sure");
        System.out.println("2) Yes");
        System.out.println("3) Ok");
        choice = makeChoice(3);
        printLineBreak();

        // Good/bad ending TODO

        crush.printCurrentPoints();
    }

    //Taylor video games segment TODO
    private void taylorVideoGames() {
        System.out.println("You played with Taylor! (WIP)" + crush.getCurrentPoints());
    }

    //Taylor food segment TODO
    private void taylorFood() {
        System.out.println("You ate with Taylor! (WIP)" + crush.getCurrentPoints());
    }

    //Seolhyun dinner segment
    private void seolhyunDinner() {
        int choice;

        System.out.println("Seolhyun: Oh thanks for helping dude. You probably don't want to stay with Mary anyways. " +
                "She'd get you drunk before I was even back with the food. Let me get my keys and then we can go.\n");
        System.out.println(name + ":");
        System.out.println("1) Wait for Seolhyun");
        System.out.println("2) Offer to drive instead since you've heard (horror) stories of Seolhyun's driving.");
        choice = makeChoice(2);
        printLineBreak();

        if (choice == 1) {
            crush.addPoints(0);
            System.out.println("She does not seem to particularly notice the fact that you waited for her before " +
                    "leaving... you're somewhat disappointed but at least she's not upset.\n");
            System.out.println("Seolhyun: OK let's go.\n");
            System.out.println("You and Seolhyun head outside and walk towards her car. After walking quite a while, " +
                    "you are cold and wonder how much further you will have to walk.\n");
        } else if (choice == 2) {
            crush.removePoints(1);
            System.out.println("She looks at you with an upset expression in response. You quickly realize that joking " +
                    "with Seolhyun at this stage is probably more offensive than humorous...\n");
            System.out.println("Seolhyun: Ehhh, no it's alright. I can drive.\n");
            System.out.println("As you and Seolhyun walk outside, you notice that she seems to be somewhat offended by " +
                    "your lack of trust. Seolhyun seems less inclined to converse with you now. You walk in silence and " +
                    "there seems to be no sign of her car. You are cold and wonder how much further you will have to walk.\n");
        }

        System.out.println(name + ":");
        System.out.println("1) Ask Seolhyun where she parked her car.");
        System.out.println("2) Trust Seolhyun to know where the car is and keep walking in the harsh cold Canadian winter.");
        System.out.println("3) Joke and ask her if she parked her car in another country.");
        choice = makeChoice(3);
        printLineBreak();

        if (choice == 1) {
            crush.addPoints(0);
            System.out.println("Seolhyun: Oh it's not that much further. It's just at the end of this block!\n");
            System.out.println("It... was further than you expected... The two of you get into her car and drive off.\n");
        } else if (choice == 2) {
            crush.addPoints(1);
            System.out.println("You eventually reach her car and as you both get in, Seolhyun smiles at you and turns " +
                    "the heating to the maximum.\n");
            System.out.println("Seolhyun: Thanks for walking with me bro. I know it was kinda far... but hey we're nice " +
                    "and warm again!\n");
            System.out.println("She seems hesitant in starting the car and casts occasional glances your way. It might" +
                    " just be the unwillingness to drive again in this cold weather, or it could be her wanting to " +
                    "spend more time with you... you hope it's the latter.\n");
            System.out.println("Seolhyun: OK, let's go pick up the food. Don't want to keep Mary waiting too long.\n");
            System.out.println("You nod in agreement. Seolhyun seems to be more friendly than before. It is the first time " +
                    "you've seen her smile and you look forward to having the privilege of seeing it again.\n");
        } else if (choice == 3) {
            crush.removePoints(1);
            System.out.println("You regret making the joke as soon as the words come out of your mouth. " +
                    "Seolhyun frowns at you and looks at you like you're a weirdo.\n");
            System.out.println("Seolhyun: Uhhh no it's actually right up ahead.\n");
            System.out.println("The two of you get into her car in silence and drive off.\n");
        }

        printLineBreak();
        System.out.println("Seolhyun tells you that it's your job to navigate. " +
                "She drives a few blocks and you notice that she has her radio tuned quietly to News 1130.\n");
        System.out.println(name + ":");
        System.out.println("1) Turn on some music to lighten the atmosphere and hope Seolhyun will compliment your music taste.");
        System.out.println("2) Ignore the radio and give her directions.");
        choice = makeChoice(2);
        printLineBreak();

        if (choice == 1) {
            crush.removePoints(1);
            System.out.println("Seolhyun: Hey dude, can you stop that? It's really distracting and you didn't even notice " +
                    "when I made a wrong turn and almost hit that old guy. Just change it back to what I had before. " +
                    "Your music choice is kinda meh anyways.\n");
            System.out.println("Chastised, you leave the radio alone and concentrate on making sure you get to" +
                    " your destination safely.\n");
        } else if (choice == 2) {
            crush.addPoints(1);
            System.out.println("You quickly notice when Seolhyun attemps to turn left instead of right and warn her " +
                    "when you see incoming pedestrians.\n");
            System.out.println("Seolhyun: Hey you're a pretty good copilot. I wouldn't mind driving you again.\n");
        }

        System.out.println("You finally arrive at your destination and when Seolhyun parks the car, you see that she doesn't put her hand brake down.\n");
        System.out.println(name + ":");
        System.out.println("1) Ask her about it.");
        System.out.println("2) Give her the benefit of the doubt and stay quiet.");
        System.out.println("3) Comment that she seems to have quite a few bad habits as a driver.");
        choice = makeChoice(3);
        printLineBreak();

        if (choice == 1) {
            crush.addPoints(1);
            System.out.println("Seolhyun: Oh yeah, that's just something my family does. *laughs* Sometimes we'd forget " +
                    "that we have it on and we'd wear down the brake pads. Wow, you're actually pretty attentive. " +
                    "I'm gonna head inside to get the food. I'll be right back.\n");
        } else if (choice == 2) {
            crush.addPoints(0);
            System.out.println("Seolhyun: OK we're here. I'm gonna head inside to get the food. I'll be right back.\n");
        } else if (choice == 3) {
            crush.removePoints(1);
            System.out.println("Seolhyun frowns. You suddenly feel the urge to go drown yourself in the ocean. Maybe the " +
                    "human sacrifice would appease the Goddess that is Seolhyun.\n");
            System.out.println("Seolhyun: Well there's actually a story behind it and a reason why I do it but I won't " +
                    "bore you with the details. You probably wouldn't appreciate it anyways. Well... I'm gonna head " +
                    "inside to get the food. I'll be right back.\n");
            System.out.println("The car suddenly got a lot colder--or maybe it was the atmosphere. You can't tell anymore.\n");
        }

        System.out.println(name + ":");
        System.out.println("1) Offer to help.");
        System.out.println("2) Stay in the warm car.");
        choice = makeChoice(2);
        printLineBreak();

        if (choice == 1) {
            crush.addPoints(1);
            System.out.println("Seolhyun: Thanks dude. We ordered quite a bit of food so I'd probably " +
                    "have trouble carrying it all by myself.\n");
            System.out.println("You and Seolhyun retrieve the food and head back to the car. After putting everything in " +
                    "the trunk, you and Seolhyun begin to head back to the house. She seems to be in a good mood since she" +
                    " begins to talk about her robotics team. You were on the same team when you were still doing your" +
                    " Master's degree.\n");
            System.out.println(name + ":");
            System.out.println("1) Ask if she wants to work on something together sometime.");
            System.out.println("2) Make no mention of your involvement with the team and focus on courting instead.");
            choice = makeChoice(2);
            printLineBreak();

            if (choice == 1) {
                crush.addPoints(1);
                System.out.println("Seolhyun: Oh hey that'd be cool! Un... why don't we talk about it a little after the" +
                        " party? If you don't mind staying behind a little that is.\n");
                System.out.println("As you continue your drive back to the host's house, you notice that Seolhyun seems to " +
                        "be happy at the prospect of collaborating on a project with you. She continues to make " +
                        "conversation with you and you feel enthused that you managed to become closer with Seolhyun.\n");
            } else if (choice == 2) {
                crush.removePoints(1);
                System.out.println("Seolhyun: Are you trying to... Nevermind.\n");
                System.out.println("The conversation slowly lulls as your drive continues. Seolhyun doesn't seem too keen " +
                        "to talk to you about her team since she doesn't know about your involvement.\n");
            }
        } else if (choice == 2) {
            crush.removePoints(1);
            System.out.println("Seolhyun comes back with dozens of bags. She does not seem happy that you opted to let her do all the work.\n");
            System.out.println("Seolhyun: Hey could you open the trunk for me? I could use a little help...\n");
            System.out.println("Seolhyun puts the food in the trunk and gets back into the car. You and Seolhyun begin to head " +
                    "back to the house, but she doesn't say much to you on the way back. Perhaps helping her would " +
                    "have been a better choice.\n");
        }

        if (crush.getCurrentPoints() > 3) {
            System.out.println("You and Seolhyun arrive back at the house and bring the food in. Mary already has the " +
                    "table set and the drinks ready so you both sit down and begin to eat. During the dinner, you all " +
                    "become tipsy and you notice that Seolhyun becomes even more friendly towards you while she is slightly " +
                    "inebriated. You finish eating and begin cleaning up. Afterwards, Seolhyun seems to drift towards you and" +
                    " you sit down on the couch and talk to her.\n");
        } else {
            System.out.println("You and Seolhyun arrive back at the house and bring the food in. Mary already has the table" +
                    " set and the drinks ready so you both sit down and begin to eat. During the dinner, you notice that" +
                    " Seolhyun tends to talk to Mary and at times you are left sitting confused, as you cannot keep up " +
                    "with their conversation. After the three of you finish eating and cleaning up, Seolhyun and Mary go " +
                    "upstairs to talk about Iron Man. You are left alone and sad, but what else would you have expected " +
                    "from the terrible choices you made?\n");
        }
        crush.printCurrentPoints();
    }

    //Seolhyun pillowfight segment TODO
    private void seolhyunPillowFight() {
        System.out.println("You fought with Seolhyun! (WIP)" + crush.getCurrentPoints());
    }

    //Mary drinking segment TODO
    private void maryDrinking() {
        System.out.println("You drank with Mary! (WIP)" + crush.getCurrentPoints());
    }

    //Mary pillowfight segment TODO
    private void maryPillowFight() {
        System.out.println("You fought with Mary! (WIP)" + crush.getCurrentPoints());
    }
}
