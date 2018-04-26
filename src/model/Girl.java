package model;

public class Girl {
    private int numPoints;
    private int girlNum;
    private String name;
    //all paths
    public boolean netflixAndChill;
    //Tzuyu and Nancy
    public boolean bakeCookies;
    public boolean decorateTheHouse;
    //Choa and Taylor
    public boolean videoGames;
    public boolean getFood;
    //Mary and Seolhyun
    public boolean dinnerAndDrinking;
    public boolean pillowFights;

    // 0 points to start
    public Girl(int girlCode) {
        numPoints = 0;
        girlNum = girlCode;
        netflixAndChill = false;
        if ((girlCode == Game.TZUYU) || (girlCode == Game.NANCY)) {
            bakeCookies = false;
            decorateTheHouse = false;
            if (girlCode == Game.TZUYU) {
                name = "Tzuyu";
            } else {
                name = "Nancy";
            }
        } else if ((girlCode == Game.CHOA) || (girlCode == Game.TAYLOR)) {
            videoGames = false;
            getFood = false;
            if (girlCode == Game.CHOA) {
                name = "Choa";
            } else {
                name = "Taylor";
            }
        } else {
            dinnerAndDrinking = false;
            pillowFights = false;
            if (girlCode == Game.MARY) {
                name = "Mary";
            } else {
                name = "Seolhyun";
            }
        }
    }

    // add points to numPoints
    public void addPoints(int points) {
        numPoints += points;
    }

    // subtract points from numPoints
    public void removePoints(int points) {
        numPoints -= points;
    }

    public void setPoints(int points) {
        numPoints = points;
    }

    // returns numPoints
    public int getCurrentPoints() {
        return numPoints;
    }

    //Prints numPoints
    public void printCurrentPoints() {
        System.out.println("Current points: " + numPoints);
    }

    //returns girl's number
    public int getGirlNum() {
        return girlNum;
    }

    //returns girl's name
    public String getName() {
        return name;
    }
}
