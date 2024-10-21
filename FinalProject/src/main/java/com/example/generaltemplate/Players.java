package com.example.generaltemplate;

import java.util.Objects;

public class Players {
    private String position;
    private String firstName;
    private String lastName;
    private int speedRating;
    private int accelerationRating;
    private int strengthRating;
    private int awarenessRating;
    private int catchRating;
    private int throwRating;
    private int overallRating;
    private int age;
    private int xp;
    private int level;
    private int upgradeTokens;
    private int yearsOfExperience;
    private int roundProjected;
    private int roundPicked;
    private int pickProjected;
    private int pickPicked;
    private int speedDraftLevel=0;
    private int accelerationDraftLevel=0;
    private int awarenessDraftLevel=0;
    private int stengthDraftLevel=0;
    private int throwDraftLevel=0;
    private int catchDraftLevel=0;
    private String[] speedGradeBrackets={"","",""};
    private String[] accelerationGradeBrackets={"","",""};
    private String[] strengthGradeBrackets={"","",""};
    private String[] awarenessGradeBrackets={"","",""};
    private String[] throwGradeBrackets={"","",""};
    private String[] catchGradeBrackets={"","",""};
    private int xcord;
    private int ycord;
    private String route="";
    private int direction;
    private int key;
    private int team;
    private long playerStartTime;
    private long playerBlockTime;
    private int blockAbility;
    private int currentSpeed=1700000000;
    private int routeDistance;
    private int maxSpeed;
    private int accelerationDecrease;
    private int numRouteForward=0;
    private boolean carryingBall=false;
    private boolean stunned;
    private int stunnedTimer=0;
    private boolean blocked;
    private Players playerBlocking;
    private boolean goTowardBall=false;
    private boolean ballInAir=true;
    private boolean ballPlayerTackled=false;
    private boolean sackedQB=false;
    private boolean interception=false;
    private int runDirection=1;
    public void resetPlayer(){
        stunned=false;
        blocked=false;
        playerBlocking=null;
        routeDistance=0;
        numRouteForward=0;
        route="";
        key=-1;
        direction=0;
        runDirection=1;
        ballInAir=true;
        carryingBall=false;
        goTowardBall=false;
        sackedQB=false;
        ballPlayerTackled=false;
        resetPlay=false;
        opponent=null;
        currentSpeed=1700000000;
        interception=false;
    }
    public Players(int team,String position,int speedRating,int accelerationRating, int strengthRating, int awarenessRating, int catchRating,int throwRating,String firstName,String lastName,int age,boolean geneateXP){
        this.position=position;
        this.team=team;
        this.accelerationRating=accelerationRating;
        accelerationDecrease=accelerationRating/10*40000000;
        this.strengthRating=strengthRating;
        this.speedRating=speedRating;
        maxSpeed=(99-speedRating)*25000000+70000000;
        this.awarenessRating=awarenessRating;
        if (position.equals("OL")){
            blockAbility=1000000000*(100-awarenessRating)+2000000000;
        }
        this.catchRating=catchRating;
        this.throwRating=throwRating;
        this.firstName=firstName;
        this.lastName=lastName;
        this.age=age;
        yearsOfExperience=age-21;
        if (geneateXP){
            xp=(int)(Math.random()*1000+200*yearsOfExperience);
            level=(int)(Math.random()*10+yearsOfExperience);
        }
        setOverall();
    }
    public Players(String position,int speedRating,int accelerationRating, int strengthRating, int awarenessRating, int catchRating,int throwRating,String firstName,String lastName,int age,boolean geneateXP){
        this.position=position;
        this.accelerationRating=accelerationRating;
        accelerationDecrease=accelerationRating/10*40000000;
        this.strengthRating=strengthRating;
        this.speedRating=speedRating;
        maxSpeed=(99-speedRating)*25000000+100000000;
        this.awarenessRating=awarenessRating;
        if (position.equals("OL")){
            blockAbility=1000000000*(100-awarenessRating)+2000000000;
        }
        this.catchRating=catchRating;
        this.throwRating=throwRating;
        this.firstName=firstName;
        this.lastName=lastName;
        this.age=age;
        yearsOfExperience=age-21;
        if (geneateXP){
            xp=(int)(Math.random()*1000+200*yearsOfExperience);
            level=(int)(Math.random()*10+yearsOfExperience);
        }
        setOverall();
    }

    public int getTeam() {
        return team;
    }
    public void updateSpeed(){
        currentSpeed-=accelerationDecrease;
        if (currentSpeed<maxSpeed){
            currentSpeed=maxSpeed;
        }
    }

    public void setRouteDistance(int dis){
        routeDistance=dis;
    }
    public void changeLocation(int[][] fieldData,Players[] opps,Players ownPlayer,double ballX,double ballY,boolean ballCaught,int footballSize){
        if(!goTowardBall && !ballCaught && !carryingBall) {
            if (route.equals("streak")) {
                if (numRouteForward < routeDistance - 1) {
                    numRouteForward++;
                    fieldData[ycord][xcord] = 0;
                    if (fieldData[ycord + 1][xcord] > 3 && fieldData[ycord + 1][xcord] < 10) {
                        fieldData[ycord + 1][xcord] = 0;
                    }
                    if (ycord>0) {
                        ycord--;
                    }
                }
            } else if (route.equals("cross")) {
                fieldData[ycord][xcord] = 0;
                if (fieldData[ycord + 1][xcord] > 3 && fieldData[ycord + 1][xcord] < 10) {
                    fieldData[ycord + 1][xcord] = 0;
                }
                if (numRouteForward < routeDistance) {
                    numRouteForward++;
                    if (ycord>0) {
                        ycord--;
                    }
                } else {
                    if (xcord > 0 && xcord < 25) {
                        if (ycord>0) {
                            ycord--;
                        }
                        xcord = xcord + direction;
                    }

                }
            } else if (route.equals("outIn")) {
                fieldData[ycord][xcord] = 0;
                if (fieldData[ycord + 1][xcord] > 3 && fieldData[ycord + 1][xcord] < 10) {
                    fieldData[ycord + 1][xcord] = 0;
                }
                if (numRouteForward < routeDistance - 1) {
                    numRouteForward++;
                    if (ycord>0) {
                        ycord--;
                    }
                } else {
                    if (xcord > 0 && xcord < 25) {
                        xcord = xcord + direction;
                    }

                }
            } else if (route.equals("block")) {
                fieldData[ycord][xcord] = 0;
                if (fieldData[ycord + 1][xcord] > 3 && fieldData[ycord + 1][xcord] < 10) {
                    fieldData[ycord + 1][xcord] = 0;
                }
                int shortestDistance = Integer.MAX_VALUE;
                int shortestInt = 0;
                Players shortestOpp = null;
                for (int i = 0; i < opps.length; i++) {
                    if (opps[i].getYcord() + 1 == ycord && opps[i].getXcord() == xcord) {
                        shortestOpp = opps[i];
                    }
                    int tempDistance = Math.max(Math.abs(xcord - opps[i].getXcord()), Math.abs(ycord - opps[i].getYcord()));
                    if (tempDistance < shortestDistance) {
                        shortestDistance = tempDistance;
                        shortestInt = i;
                    }
                }
                if (shortestOpp == null) {
                    shortestOpp = opps[shortestInt];
                }
                if (shortestOpp.getXcord() + 1 < xcord) {
                    if (xcord>0){
                        xcord--;
                    }
                } else if (shortestOpp.getXcord() - 1 > xcord) {
                    if (xcord<25){
                        xcord++;
                    }

                }
                if (shortestOpp.getYcord() + 1 < ycord) {
                    if (ycord>0) {
                        ycord--;
                    }
                }
                if (shortestOpp.getYcord() - 1 > ycord) {
                    if (ycord<110){
                        ycord++;
                    }

                }
                if (shortestOpp.getXcord() + 1 == xcord || shortestOpp.getXcord() - 1 == xcord || shortestOpp.getXcord() == xcord) {
                    if (shortestOpp.getYcord() + 1 == ycord || shortestOpp.getYcord() - 1 == ycord || shortestOpp.getYcord() == ycord) {
                        shortestOpp.setBlocked(true, ownPlayer);
                    }
                }
            } else {
                if (position.equals("OL") && !stunned) {
                    fieldData[ycord][xcord] = 0;
                    int shortestDistance = Integer.MAX_VALUE;
                    int shortestInt = 0;
                    Players shortestOpp = null;
                    for (int i = 0; i < opps.length; i++) {
                        if (opps[i].getYcord() + 1 == ycord && opps[i].getXcord() == xcord) {
                            shortestOpp = opps[i];
                        }
                        int tempDistance = Math.max(Math.abs(xcord - opps[i].getXcord()), Math.abs(ycord - opps[i].getYcord()));
                        if (tempDistance < shortestDistance) {
                            shortestDistance = tempDistance;
                            shortestInt = i;
                        }
                    }
                    if (shortestOpp == null) {
                        shortestOpp = opps[shortestInt];
                    }
                    if (shortestOpp.getXcord() + 1 < xcord) {
                        if (xcord>0){
                            xcord--;
                        }
                    } else if (shortestOpp.getXcord() - 1 > xcord) {
                        if (xcord<25){
                            xcord++;
                        }
                    }
                    if (shortestOpp.getYcord() + 1 < ycord) {
                        if (ycord>0) {
                            ycord--;
                        }
                    }
                    if (shortestOpp.getYcord() - 1 > ycord) {
                        if (ycord<110){
                            ycord++;
                        }

                    }
                    if (shortestOpp.getXcord() + 1 == xcord || shortestOpp.getXcord() - 1 == xcord || shortestOpp.getXcord() == xcord) {
                        if (shortestOpp.getYcord() + 1 == ycord || shortestOpp.getYcord() - 1 == ycord || shortestOpp.getYcord() == ycord) {
                            shortestOpp.setBlocked(true, ownPlayer);
                        }
                    }
                }
            }
        }else{
            if (!carryingBall) {
                if (footballSize==1&&!ballCaught&&Math.abs(ballX - xcord) < 1.75 && Math.abs(ballY - ycord) < 1.75) {
                    Players potentialOpp=null;
                    for (Players x:opps){
                        if (xcord+1>=x.getXcord()||xcord-1<=x.getXcord()){
                            if (ycord+1>=x.getYcord()||ycord-1<=x.getYcord()){
                                potentialOpp=x;
                            }
                        }
                    }
                    if (potentialOpp!=null){
                        if (Math.random() * (catchRating- (double) potentialOpp.getStrengthRating() /10) > 20) {
                            ballInAir = false;
                            carryingBall = true;
                            fieldData[(int) (ballY)][(int) (ballX)] = 0;
                        } else {
                            resetPlay = true;
                        }
                    }else {
                        if (Math.random() * catchRating > 15) {
                            ballInAir = false;
                            carryingBall = true;
                            fieldData[(int) (ballY)][(int) (ballX)] = 0;
                        } else {
                            resetPlay = true;
                        }
                    }
                } else {
                    fieldData[ycord][xcord] = 0;
                    if (fieldData[ycord + 1][xcord] > 3 && fieldData[ycord + 1][xcord] < 10) {
                        fieldData[ycord + 1][xcord] = 0;
                    }
                    if (ballX < xcord) {
                        if (xcord>0){
                            xcord--;
                        }
                    } else if (ballX > xcord) {
                        if (xcord<25){
                            xcord++;
                        }
                    }
                    if (ballY < ycord) {
                        if (ycord>0) {
                            ycord--;
                        }
                    } else if (ballY > ycord) {
                        if (ycord<110){
                            ycord++;
                        }

                    }
                }
            }else{
                if (carryingBall) {
                    fieldData[ycord][xcord] = 0;
                    if (fieldData[ycord + 1][xcord] > 3 && fieldData[ycord + 1][xcord] < 10) {
                        fieldData[ycord + 1][xcord] = 0;
                    }
                    if (runDirection == 1) {
                        if (ycord > 0) {
                            ycord--;
                        }
                    } else if (runDirection == 2) {
                        if (ycord<110){
                            ycord++;
                        }

                    } else if (runDirection == 3) {
                        if (xcord<25){
                            xcord++;
                        }

                    } else if (runDirection == 4) {
                        if (xcord>0){
                            xcord--;
                        }

                    }
                }
            }
        }
    }
    private boolean resetPlay;
    public boolean getResetPlay(){
        return resetPlay;
    }
    public void setResetPlay(boolean x){
        resetPlay=x;
    }

    public void changeLocation(int[][] fieldData,Players[] opps,Players oppQB,Players playerCarryingBall,double ballX,double ballY,int footballSize){
        if (playerCarryingBall!=null && stunnedTimer==0){
            if (playerCarryingBall.getXcord()>xcord){
                if (xcord<25){
                    xcord++;
                }
            }else if (playerCarryingBall.getXcord()<xcord){
                if (xcord>0){
                    xcord--;
                }

            }
            if (playerCarryingBall.getYcord()>ycord){
                if (ycord<110){
                    ycord++;
                }
            }else if (playerCarryingBall.getYcord()<ycord){
                if (ycord>0) {
                    ycord--;
                }
            }
            if (xcord+1==playerCarryingBall.getXcord()||xcord-1==playerCarryingBall.getXcord()|| xcord==playerCarryingBall.getXcord()){
                if (ycord+1==playerCarryingBall.getYcord()||ycord-1==playerCarryingBall.getYcord()|| ycord==playerCarryingBall.getYcord()){
                    double num1= Math.random()*(strengthRating);
                    double num2 = (double) (playerCarryingBall.getStrengthRating()) /10;
                    if (num1-num2 >25 && !blocked){
                        ballPlayerTackled=true;
                    }else{
                        stunnedTimer=750/awarenessRating;
                    }
                }
            }
        }else if (stunnedTimer>0){
            stunnedTimer--;
        }else {
            if (opponent != null) {
                fieldData[ycord][xcord] = 0;
                if (opponent.getXcord() + 1 < xcord) {
                    if (xcord>0){
                        xcord--;
                    }
                } else if (opponent.getXcord() - 1 > xcord) {
                    if (xcord<25){
                        xcord++;
                    }
                }
                if (opponent.getYcord() + 1 < ycord) {
                    if (ycord>0) {
                        ycord--;
                    }
                }
            } else {
                if (position.equals("S")) {
                    fieldData[ycord][xcord] = 0;
                    int shortestDistance = Integer.MAX_VALUE;
                    int shortestInt = 0;
                    for (int i = 0; i < opps.length; i++) {
                        int tempDistance = Math.max(Math.abs(xcord - opps[i].getXcord()), Math.abs(ycord - opps[i].getYcord()));
                        if (tempDistance < shortestDistance) {
                            shortestDistance = tempDistance;
                            shortestInt = i;
                        }
                    }
                    Players shortestOpp = opps[shortestInt];
                    if (shortestOpp.getXcord() + 1 < xcord) {
                        if (xcord>0){
                            xcord--;
                        }
                    } else if (shortestOpp.getXcord() - 1 > xcord) {
                        if (xcord<25){
                            xcord++;
                        }
                    }
                    if (shortestOpp.getYcord() + 1 < ycord) {
                        if (ycord>0) {
                            ycord--;
                        }
                    }
                }
                if (position.equals("DT") || (playerCarryingBall!=null && (playerCarryingBall.getPosition().equals("QB")||playerCarryingBall.getPosition().equals("RB")))) {
                    if (blocked) {
                        int ranStun = (int) (Math.random() * (100 - strengthRating + playerBlocking.getStrengthRating()));
                        if (ranStun < (awarenessRating / 8 + 5)) {
                            playerBlocking.setStunned(true);
                            blocked = false;
                            playerBlocking.resetBlockStartTime();
                        }
                    } else {
                        fieldData[ycord][xcord] = 0;
                        if (oppQB.getYcord() > ycord) {
                            ycord++;
                        } else if (oppQB.getYcord() < ycord) {
                            if (ycord>0) {
                                ycord--;
                            }
                        } else {
                            if (oppQB.getXcord() > xcord) {
                                if (xcord<25){
                                    xcord++;
                                }

                            } else if (oppQB.getXcord() < xcord) {
                                if (xcord>0){
                                    xcord--;
                                }

                            }
                        }
                        if (oppQB.getXcord() == xcord && oppQB.getYcord() == ycord) {
                            sackedQB=true;
                        }
                    }
                }
                if (ballInAir && footballSize==1&& (position.equals("CB")|| position.equals("S")|| position.equals("LB"))){
                    if (Math.abs(ballX-xcord)< (double) (awarenessRating /30)-.25 && Math.abs(ballY-ycord)<(double) (awarenessRating /30)-.25){
                        if (Math.random()*catchRating>40){
                            System.out.println("1");
                            if (Math.random()<.7){
                                resetPlay=true;
                            }else{
                                interception=true;
                            }
                        }
                    }
                }
            }
        }
    }
    public void setStunned(boolean stunned){
        this.stunned=stunned;
    }
    public void setBlocked(boolean blocked,Players playerBlocking) {
        this.blocked = blocked;
        this.playerBlocking=playerBlocking;
    }

    private Players opponent;

    public void setOpponent(Players opp){
        opponent=opp;
    }

    public void resetPlayerStartTime(){
        playerStartTime=System.nanoTime();
    }

    public long getPlayerStartTime() {
        return playerStartTime;
    }
    public void resetBlockStartTime(){
        playerBlockTime=System.nanoTime();
    }

    public long getPlayerBlockTime() {
        return playerBlockTime;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setOverall(){
        if (position.equals("DT")){
            overallRating=(int)(speedRating*.2+accelerationRating*.2+strengthRating*.4+awarenessRating*.2);
        }else if (position.equals("LB")){
            overallRating=(int)(speedRating*.2+accelerationRating*.2+strengthRating*.2+awarenessRating*.2+catchRating*.2);
        }else if (position.equals("CB")){
            overallRating=(int)(speedRating*.3+accelerationRating*.25+strengthRating*.05+awarenessRating*.15+catchRating*.25);
        }else if (position.equals("S")){
            overallRating=(int)(speedRating*.3+accelerationRating*.25+strengthRating*.05+awarenessRating*.15+catchRating*.25);
        }else if (position.equals("OL")){
            overallRating=(int)(speedRating*.15+accelerationRating*.15+strengthRating*.5+awarenessRating*.2);
        } else if (position.equals("QB")){
            overallRating=(int)(speedRating*.1+accelerationRating*.1+strengthRating*.3+awarenessRating*.1+throwRating*.4);
        }else if (position.equals("WR")){
            overallRating=(int)(speedRating*.2+accelerationRating*.2+strengthRating*.15+awarenessRating*.15+catchRating*.3);
        }else if (position.equals("TE")){
            overallRating=(int)(speedRating*.1+accelerationRating*.2+strengthRating*.3+awarenessRating*.15+catchRating*.25);
        }else if (position.equals("RB")){
            overallRating=(int)(speedRating*.25+accelerationRating*.3+strengthRating*.2+awarenessRating*.15+catchRating*.1);
        }
    }
    public int getAccelerationRating() {
        return accelerationRating;
    }

    public int getAwarenessRating() {
        return awarenessRating;
    }

    public int getCatchRating() {
        return catchRating;
    }

    public int getSpeedRating() {
        return speedRating;
    }

    public int getStrengthRating() {
        return strengthRating;
    }

    public int getThrowRating() {
        return throwRating;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPosition() {
        return position;
    }

    public int getOverallRating() {
        return overallRating;
    }
    public void incSpeed(){
        speedRating++;

    }
    public void incAcceleration(){
        accelerationRating++;
    }
    public void incAwareness(){
        awarenessRating++;
    }
    public void incStrength(){
        strengthRating++;
    }
    public void incCatch(){
        catchRating++;
    }
    public void incThrow(){
        throwRating++;
    }

    public int getAge() {
        return age;
    }

    public int getXp() {
        return xp;
    }

    public int getUpgradeTokens() {
        return upgradeTokens;
    }
    public void dcrUpgradeTokens(){
        upgradeTokens--;
    }

    public int getLevel() {
        return level;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public int getPickPicked() {
        return pickPicked;
    }

    public int getPickProjected() {
        return pickProjected;
    }

    public int getRoundPicked() {
        return roundPicked;
    }

    public int getRoundProjected() {
        return roundProjected;
    }

    public void setPickPicked(int pickPicked) {
        this.pickPicked = pickPicked;
    }

    public void setPickProjected(int pickProjected) {
        this.pickProjected = pickProjected;
    }

    public void setRoundProjected(int roundProjected) {
        this.roundProjected = roundProjected;
    }

    public void setRoundPicked(int roundPicked) {
        this.roundPicked = roundPicked;
    }

    public int getAccelerationDraftLevel() {
        return accelerationDraftLevel;
    }

    public int getAwarenessDraftLevel() {
        return awarenessDraftLevel;
    }

    public int getCatchDraftLevel() {
        return catchDraftLevel;
    }

    public int getSpeedDraftLevel() {
        return speedDraftLevel;
    }

    public int getStengthDraftLevel() {
        return stengthDraftLevel;
    }

    public int getThrowDraftLevel() {
        return throwDraftLevel;
    }
    public void incSpeedDraftLevel(){
        speedDraftLevel++;
    }
    public void incAccelerationDraftLevel(){
        accelerationRating++;
    }
    public void incStrengthDraftLevel(){
        stengthDraftLevel++;
    }
    public void incAwarenessDraftLevel(){
        awarenessDraftLevel++;
    }
    public void incThrowDraftLevel(){
        throwDraftLevel++;
    }
    public void incCatchDraftLevel(){
        speedDraftLevel++;
    }
    public void setBrackets(String range,int bracketIndex,String bracketType){
        if (bracketType.equals("Speed")){
            speedGradeBrackets[bracketIndex]=range;
        }else if (bracketType.equals("Acceleration")){
            accelerationGradeBrackets[bracketIndex]=range;
        }else if (bracketType.equals("Strength")){
            strengthGradeBrackets[bracketIndex]=range;
        }else if (bracketType.equals("Awareness")){
            awarenessGradeBrackets[bracketIndex]=range;
        }else if (bracketType.equals("Catch")){
            catchGradeBrackets[bracketIndex]=range;
        }else if (bracketType.equals("Throw")){
            throwGradeBrackets[bracketIndex]=range;
        }
    }

    public String getAccelerationGradeBrackets(int in) {
        return accelerationGradeBrackets[in];
    }

    public String getAwarenessGradeBrackets(int in) {
        return awarenessGradeBrackets[in];
    }

    public String getCatchGradeBrackets(int in) {
        return catchGradeBrackets[in];
    }

    public String getSpeedGradeBrackets(int in) {
        return speedGradeBrackets[in];
    }

    public String getStrengthGradeBrackets(int in) {
        return strengthGradeBrackets[in];
    }

    public String getThrowGradeBrackets(int in) {
        return throwGradeBrackets[in];
    }
    public void setCord(int x,int y,int[][]fieldData){
        xcord=x;
        ycord=y;
        fieldData[y][x]=1;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getXcord() {
        return xcord;
    }

    public int getYcord() {
        return ycord;
    }
    public void setKey(int k){
        key=k;
    }
    public int getKey(){
        return key;
    }

    public int getBlockAbility() {
        return blockAbility;
    }

    public boolean isStunned() {
        return stunned;
    }

    public String getRoute() {
        return route;
    }

    public void setGoTowardBall(boolean goTowardBall) {
        this.goTowardBall = goTowardBall;
    }

    public boolean isGoTowardBall() {
        return goTowardBall;
    }

    public boolean isBallInAir() {
        return ballInAir;
    }

    public void setBallInAir(boolean ballInAir) {
        this.ballInAir = ballInAir;
    }

    public boolean isCarryingBall() {
        return carryingBall;
    }
    public boolean isBallPlayerTackled(){
        return  ballPlayerTackled;
    }
    public void setBallPlayerTackled(boolean ballPlayerTackled) {
        this.ballPlayerTackled = ballPlayerTackled;
    }

    public boolean isSackedQB() {
        return sackedQB;
    }

    public void setSackedQB(boolean sackedQB) {
        this.sackedQB = sackedQB;
    }

    public boolean isInterception() {
        return interception;
    }
    public void setRunDirection(int dir){
        runDirection=dir;
    }

    public void setCarryingBall(boolean carryingBall) {
        this.carryingBall = carryingBall;
    }

    public int getRouteDistance() {
        return routeDistance;
    }

    public int getDirection() {
        return direction;
    }
    public void incXP(int amt){
        xp+=amt;
    }
    public void incLevel(){
        level++;
    }
    public void incUpdateTokens(){
        upgradeTokens++;
    }
    public void incAge(){
        age++;
        yearsOfExperience++;
    }
}
