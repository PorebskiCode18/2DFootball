package com.example.generaltemplate;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class HelloController {

    public ListView lstTeamSelect;
    public ListView lstTeamSelectRatings;
    public TextField txtFirstName;
    public TextField txtLastName;

    public Tab tabHomePage;
    public Tab tabGame;
    public Tab tabOffice;
    public Tab tabRoster;
    public Tab tabPreGame;
    public TabPane tabPane;
    public ListView lstSchedule;
    public ListView lstStandings;
    public Label lstTeamName;
    public ListView lstDTChart;
    public ListView lstCBChart;
    public ListView lstLBChart;
    public ListView lstSSChart;
    public ListView lstOLChart;
    public ListView lstQBChart;
    public ListView lstWRChart;
    public ListView lstTEChart;
    public ListView lstRBChart;
    public ListView lstSelectedPlayerStats;
    public Label lblUpgradeTokens;
    public ListView lstSelectedPlayerUpgrades;
    public Button btnManualReorder;
    public Label lblWeek;
    public Label lblOpName;
    public Label lblOpOffRating;
    public Label lblOpDefRating;
    public Label lblOpWinLossStreak;
    public Label lblOffRating;
    public Label lblDefRating;
    public ListView lstDraftProspects;
    public ListView lstDraftPositions;
    public ListView lstProspectGrades;
    public ProgressBar barXP;
    public ListView lstRosterTeamSelectDef;
    public ListView lstRosterTeamSelectOff;
    public Label lblRosterTeamSelectOff;
    public Label lblRosterTeamSelectedDef;
    public Button btnUpgradePlayer;
    public Button btnAutoReorder;
    public Label lblPlayerName;
    public ListView lstDraftPrioritiesSelected;
    public ListView lstDraftPriorities;
    public GridPane gpane;
    public Label lblGameTitle;
    public Button btnStartGame;
    public Label lblTeam1Game;
    public Label lblTeam2Game;
    public RadioButton timeOut11;
    public RadioButton timeout21;
    public RadioButton timeout31;
    public RadioButton timeout12;
    public RadioButton timeout22;
    public RadioButton timeout32;
    public Label lblTeam1Score;
    public Label lblTeam2Score;
    public Label lblPeriod;
    public Label lblTime;
    public ListView lstGameEvents;
    public ListView lstPlays;
    public ImageView imgPlays;
    public Label lblShotClock;
    public Label lblDown;
    public ListView lstPlayerAudible;
    public ListView lstRouteAudible;
    public Label lblPlayerAudible;
    public Button btnKickBall;
    public Button btnPlayGame;
    public Label lblWinLossStreak;
    public ListView lstProjectedDraftBoard;
    public Label lblOnClockRound;
    public Label lblOnClockPick;
    public Label lblOnClockTeam;
    public Label lblLastTeam;
    public Label lblLastPlayer;
    public Label lblLastPick;
    public ListView lstPickPlayerList;
    public ListView lstPickPositions;
    public ListView lstDraftPicks;
    public ListView lstDraftTeams;
    public Tab tabDraft;
    private ArrayList<Teams> allTeams= new ArrayList<>();
    private Teams playersTeam;
    private String playerFirstName;
    private String playerLastName;
    private boolean reorderingDepthChart=false;
    private int week=1;
    private ArrayList<Players> draftProspects=new ArrayList<>();
    private Button[][] field;
    private int[][] fieldData;
    private int offOrDef=1; //1=playing offense  2=playing defense
    private Players[] playersOn;
    private Players[] opponentsOn;
    private boolean runClock=false;
    private boolean hike=false;
    private boolean ballInAir=false;
    private int footballSize=1;
    private double ballX;
    private double ballY;
    private Players playerThrowTo;
    private double aim;
    private boolean ballCaught;
    private long startTime;
    private long draftTime;
    private int ballPlace;
    private Teams opponent;
    private int cameraLocation=80;
    private int playclock=20;
    private boolean runPlayClock=false;
    private int period=1;
    private int gameClock=120;
    private int team1Score=0;
    private int team2Score=0;
    private int timeoutsUsed1=0;
    private int timeoutsUsed2=0;
    private double xdir;
    private double ydir;
    private boolean doneTraveling=false;
    private int runned=0;
    private Players playerCarryingBall=null;
    private int down=1;
    private int downPlace;
    private Image back,whiteback,blueback,redPlayer,bluePlayer,football,bench,deep,inside,outside,drag,redGrass,redW,redA,redS,redD,redF,footballS,footballB,blackGrass;
    private FileInputStream backk,whitebackk,bluebackk,redPlayerr,bluePlayerr,footballl,benchh,deepp,insidee,outsidee,dragg,redGrasss,rredW,rredA,rredS,rredD,rredF,footballSS,footballBB,blackGrasss;


    public HelloController(){
        int i=110;
        int j=26;
        field=new Button[i][j];
        fieldData= new int[i][j];
        try{
            backk = new FileInputStream("src/main/resources/Pictures/grass.png");
            back=new Image(backk);
            whitebackk = new FileInputStream("src/main/resources/Pictures/whiteGrass.png");
            whiteback=new Image(whitebackk);
            bluebackk = new FileInputStream("src/main/resources/Pictures/blueGrass.png");
            blueback=new Image(bluebackk);
            bluePlayerr = new FileInputStream("src/main/resources/Pictures/bluePlayer.png");
            bluePlayer=new Image(bluePlayerr);
            redPlayerr = new FileInputStream("src/main/resources/Pictures/redPlayer.jpg");
            redPlayer=new Image(redPlayerr);
            footballl = new FileInputStream("src/main/resources/Pictures/football.png");
            football=new Image(footballl);
            benchh = new FileInputStream("src/main/resources/Pictures/benchPlay.png");
            bench=new Image(benchh);
            deepp = new FileInputStream("src/main/resources/Pictures/deepPlay.png");
            deep=new Image(deepp);
            insidee = new FileInputStream("src/main/resources/Pictures/insideRunPlay.png");
            inside=new Image(insidee);
            outsidee = new FileInputStream("src/main/resources/Pictures/outsideRunPlay.png");
            outside=new Image(outsidee);
            dragg = new FileInputStream("src/main/resources/Pictures/dragcrossPlay.png");
            drag=new Image(dragg);
            redGrasss = new FileInputStream("src/main/resources/Pictures/redGrass.jpg");
            redGrass=new Image(redGrasss);
            rredW = new FileInputStream("src/main/resources/Pictures/redW.png");
            redW=new Image(rredW);
            rredA = new FileInputStream("src/main/resources/Pictures/redA.png");
            redA=new Image(rredA);
            rredS = new FileInputStream("src/main/resources/Pictures/redS.png");
            redS=new Image(rredS);
            rredD = new FileInputStream("src/main/resources/Pictures/redD.png");
            redD=new Image(rredD);
            rredF = new FileInputStream("src/main/resources/Pictures/redF.png");
            redF=new Image(rredF);
            footballBB = new FileInputStream("src/main/resources/Pictures/footballB.png");
            footballB=new Image(footballBB);
            footballSS = new FileInputStream("src/main/resources/Pictures/footballS.png");
            footballS=new Image(footballSS);
            blackGrasss = new FileInputStream("src/main/resources/Pictures/blackGrass.jpg");
            blackGrass=new Image(blackGrasss);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
    public void updateGame(){
        if (playerCarryingBall!=null){
            if (playerCarryingBall.getYcord()>30){
                cameraLocation=playerCarryingBall.getYcord()-10;
            }else{
                cameraLocation=20;
            }
            for (int i=0;i<fieldData.length;i++){
                for (int j=0;j<fieldData[i].length;j++){
                    if (fieldData[i][j]==4){
                        fieldData[i][j]=0;
                    }
                }
            }
        }else {
            if (ballPlace>90){
                cameraLocation=90;
            }else if (ballPlace<20){
                cameraLocation=20;
            }else{
                if (offOrDef==1) {
                    if (ballPlace>30){
                        cameraLocation = ballPlace - 10;
                    }else{
                        cameraLocation=20;
                    }
                }else{
                    if (ballPlace<80){
                        cameraLocation=ballPlace+10;
                    }else{
                        cameraLocation=90;
                    }
                }
            }
        }

        if (playerCarryingBall!=null) {
            if (playerCarryingBall.getYcord() <= 5) {
                lstGameEvents.getItems().add("TOUCHDOWN: " + allTeams.get(playerCarryingBall.getTeam()).getTeamName());
                team1Score += 7;
                runClock=false;
                runPlayClock=false;
                playclock=20;
                offOrDef = 2;
                kickoff(2);
                resetPlay();
            }
        }
        gpane.getChildren().clear();
        lblTeam1Score.setText(team1Score + "");
        lblTeam2Score.setText(team2Score + "");
        lblTime.setText("Time: " + gameClock/60 + " min " + gameClock%60 + " secs");
        lblShotClock.setText("Shot Clock: " + playclock + " secs");
        if (playclock<5){
            lblShotClock.setTextFill(Color.RED);
        }else {
            lblShotClock.setTextFill(Color.BLACK);
        }
        lblPeriod.setText("Period: "+ period);
        lblDown.setText("Down: "+ down);
        for (int i = cameraLocation-20; i < cameraLocation+20; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (fieldData[i][j] == 0) {
                    ImageView dummy;
                    if (i <= 5 || i >= 105) {
                        dummy = new ImageView(blueback);
                    } else if (i % 10 == 5 && (j < 4 || j > 21)) {
                        dummy = new ImageView(whiteback);
                    } else {
                        dummy = new ImageView(back);
                    }
                    dummy.setFitHeight(15);
                    dummy.setPreserveRatio(true);
                    field[i][j].setGraphic(dummy);
                    if (i % 10 == 5 && j == 4) {
                        int x = i;
                        if (i >= 55) {
                            x = 110 - i;
                        }
                        if ((x - 5) / 10 > 0) {
                            field[i][j].setGraphic(null);
                            field[i][j].setText(String.valueOf((x - 5) / 10));
                            field[i][j].setStyle("-fx-font-size:8");
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            ImageView dummy = new ImageView(blackGrass);
            dummy.setFitHeight(15);
            dummy.setPreserveRatio(true);
            field[ballPlace][i].setGraphic(dummy);
        }
        if (offOrDef==1) {
            if (downPlace > 15) {
                for (int i = 0; i < 26; i++) {
                    ImageView dummy = new ImageView(blackGrass);
                    dummy.setFitHeight(15);
                    dummy.setPreserveRatio(true);
                    field[downPlace - 10][i].setGraphic(dummy);
                }
            }
        }else{
            if (downPlace<95){
                for (int i = 0; i < 26; i++) {
                    ImageView dummy = new ImageView(blackGrass);
                    dummy.setFitHeight(15);
                    dummy.setPreserveRatio(true);
                    field[downPlace + 10][i].setGraphic(dummy);
                }
            }
        }
        for (int i = cameraLocation-20; i < cameraLocation+20; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (fieldData[i][j]==3 && !ballInAir){
                    ImageView dummy = new ImageView(football);
                    dummy.setFitHeight(15);
                    dummy.setPreserveRatio(true);
                    field[i][j].setGraphic(dummy);
                }else if (fieldData[i][j]==4 && playerCarryingBall==null){
                    ImageView dummy = new ImageView(redGrass);
                    dummy.setFitHeight(15);
                    dummy.setPreserveRatio(true);
                    field[i][j].setGraphic(dummy);
                }else if (fieldData[i][j]==5){
                    ImageView dummy = new ImageView(redW);
                    dummy.setFitHeight(15);
                    dummy.setPreserveRatio(true);
                    field[i][j].setGraphic(dummy);
                }else if (fieldData[i][j]==6){
                    ImageView dummy = new ImageView(redA);
                    dummy.setFitHeight(15);
                    dummy.setPreserveRatio(true);
                    field[i][j].setGraphic(dummy);
                }else if (fieldData[i][j]==7){
                    ImageView dummy = new ImageView(redD);
                    dummy.setFitHeight(15);
                    dummy.setPreserveRatio(true);
                    field[i][j].setGraphic(dummy);
                }else if (fieldData[i][j]==8){
                    ImageView dummy = new ImageView(redS);
                    dummy.setFitHeight(15);
                    dummy.setPreserveRatio(true);
                    field[i][j].setGraphic(dummy);
                } else if (fieldData[i][j]==9){
                    ImageView dummy = new ImageView(redF);
                    dummy.setFitHeight(15);
                    dummy.setPreserveRatio(true);
                    field[i][j].setGraphic(dummy);
                }

                //W=5;
                //A=6;
                //D=7;
                //S=8;
                //F=9;
            }
        }

        if (opponentsOn!=null) {
            for (int i = 0; i < opponentsOn.length; i++) {
                if (allTeams.get(opponentsOn[i].getTeam()).getTeamName().equals(playersTeam.getYearSchedule().get(week-1).getTeamName())) {
                    ImageView dummy = new ImageView(redPlayer);
                    dummy.setFitHeight(15);
                    dummy.setPreserveRatio(true);
                    field[opponentsOn[i].getYcord()][opponentsOn[i].getXcord()].setGraphic(dummy);
                }
            }
        }
        if (playersOn!=null) {
            for (int i = 0; i < playersOn.length; i++) {
                if (allTeams.get(playersOn[i].getTeam()).getTeamName().equals(playersTeam.getTeamName())) {
                    ImageView dummy;
                    if (playersOn[i].isCarryingBall()){
                        dummy = new ImageView(footballB);
                    }else{
                        dummy=new ImageView(bluePlayer);
                    }

                    dummy.setFitHeight(15);
                    dummy.setPreserveRatio(true);
                    field[playersOn[i].getYcord()][playersOn[i].getXcord()].setGraphic(dummy);
                }
            }
        }
        if (ballInAir){
            ImageView dummy= new ImageView(football);
            if(footballSize==1){
                dummy= new ImageView(footballS);
            }else if(footballSize==2){
                dummy= new ImageView(football);
            }else if (footballSize==3){
                dummy= new ImageView(footballB);
            }

            dummy.setFitHeight(15);
            dummy.setPreserveRatio(true);
            field[(int)(ballY)][(int)(ballX)].setGraphic(dummy);
        }
        for (int i = cameraLocation-20; i < cameraLocation+20; i++) {
            for (int j = 0; j < field[0].length; j++) {
                gpane.add(field[i][j], j, i);
            }
        }
        gpane.setGridLinesVisible(true);
        if (timeoutsUsed1==1){
            timeout31.setSelected(false);
        }else if (timeoutsUsed1==2){
            timeout21.setSelected(false);
        }else if (timeoutsUsed1==3){
            timeOut11.setSelected(false);
        }
        if (timeoutsUsed2==1){
            timeout32.setSelected(false);
        }else if (timeoutsUsed2==2){
            timeout22.setSelected(false);
        }else if (timeoutsUsed2==3){
            timeout12.setSelected(false);
        }
    }
    private int row,col;
    public void handlePlayGame(ActionEvent actionEvent) {
        if (week<9) {
            tabPane.getSelectionModel().select(tabGame);
            tabHomePage.setDisable(true);
            tabRoster.setDisable(true);
            tabOffice.setDisable(true);
            tabGame.setDisable(false);
            tabPane.setPrefHeight(700);
            lblGameTitle.setText(playersTeam.getTeamName() + " vs " + playersTeam.getYearSchedule().get(week - 1).getTeamName());
            lblTeam1Game.setText(playersTeam.getTeamName());
            lblTeam2Game.setText(playersTeam.getYearSchedule().get(week - 1).getTeamName());

            timeout31.setSelected(true);
            timeout21.setSelected(true);
            timeOut11.setSelected(true);

            timeout32.setSelected(true);
            timeout22.setSelected(true);
            timeout12.setSelected(true);
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[0].length; j++) {
                    field[i][j] = new Button();
                    field[i][j].setMinHeight(15);
                    field[i][j].setMinWidth(15);
                    field[i][j].setMaxHeight(15);
                    field[i][j].setMaxWidth(15);
                    ImageView dummy;
                    if (i <= 5 || i >= 95) {
                        dummy = new ImageView(blueback);
                    } else if (i % 10 == 5 && (j < 4 || j > 21)) {
                        dummy = new ImageView(whiteback);
                    } else {
                        dummy = new ImageView(back);
                    }
                    dummy.setFitHeight(15);
                    dummy.setPreserveRatio(true);
                    field[i][j].setGraphic(dummy);
                    fieldData[i][j] = 0;
                }
            }
            gpane.setGridLinesVisible(true);
            opponent = playersTeam.getYearSchedule().get(week - 1);
        }else if (week==9){
            setUpNewYear();
            tabPane.getSelectionModel().select(tabDraft);
            tabHomePage.setDisable(true);
            tabRoster.setDisable(true);
            tabOffice.setDisable(true);
            tabDraft.setDisable(false);
        }
    }
    public void handleStartGame(){
        kickoff(1);
        for (Players x: playersTeam.getRoster()){
            x.setRunDirection(1);
        }
        runClock=false;
        runPlayClock=false;
        playclock=20;
        gameClock=120;
        timeoutsUsed1=0;
        timeoutsUsed2=0;
        period=1;
        offOrDef=1;
        down=1;
        startTime = System.nanoTime();
        btnStartGame.setVisible(false);
        lstPlays.getItems().clear();
        lstPlays.getItems().add("Inside Run");
        lstPlays.getItems().add("Outside Run");
        lstPlays.getItems().add("Bench");
        lstPlays.getItems().add("Hail Mary");
        lstPlays.getItems().add("Drag Cross");
        start();
    }
    public void kickoff(int team){
        if (team==1) {
            runPlayClock=false;
            runClock=false;
            if (Math.random() > .7) {
                int distance;
                if (playersTeam.getStartRosterRating()>opponent.getStartRosterRating()){
                    distance = (int) (Math.random() * 30 + playersTeam.getStartRosterRating()-opponent.getStartRosterRating());
                }else{
                    distance = (int) (Math.random() * 30 + (opponent.getStartRosterRating()-playersTeam.getStartRosterRating())/2);
                }
                lstGameEvents.getItems().add(opponent.getTeamName() + " kickoff");
                lstGameEvents.getItems().add("Kick Returned to " + distance + " yardLine");
                ballPlace=105-distance;
                downPlace=ballPlace;
                fieldData[ballPlace][13]=3;
            } else {
                lstGameEvents.getItems().add("Touch Back- Ball at 25 yard line");
                ballPlace=80;
                downPlace=ballPlace;
                fieldData[ballPlace][13]=3;
            }
            updateGame();
        }else{
            if (Math.random() > .7) {
                int distance;
                if (playersTeam.getStartRosterRating()<opponent.getStartRosterRating()){
                    distance = (int) (Math.random() * 30 + opponent.getStartRosterRating()-playersTeam.getStartRosterRating());
                }else{
                    distance = (int) (Math.random() * 30 + (playersTeam.getStartRosterRating()-opponent.getStartRosterRating())/2);
                }
                lstGameEvents.getItems().add(playersTeam.getTeamName() + " kickoff");
                lstGameEvents.getItems().add("Kick Returned to " + distance + " yardLine");
                ballPlace=5+distance;
                downPlace=ballPlace;
                fieldData[ballPlace][13]=3;
            } else {
                lstGameEvents.getItems().add("Touch Back- Ball at 25 yard line");
                ballPlace=30;
                downPlace=ballPlace;
                fieldData[ballPlace][13]=3;
            }
        }

    }
    private int draftNum=0;
    public void start(){
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (draftOn && !playerOn&& now - draftTime>1000000000){
                    draftNum++;
                    if (draftNum>2){
                        draftNum=0;
                        simDraftPick();
                    }
                    draftTime=System.nanoTime();
                }
                if (!draftOn) {
                    if (now - startTime > 1000000000) {
                        if (runClock) {
                            gameClock--;
                            if (gameClock < 0) {
                                gameClock = 120;
                                playclock = 20;
                                runPlayClock = false;
                                period += 1;
                                if (period > 4) {
                                    gameOver();
                                } else if (period == 2) {
                                    offOrDef = 2;
                                    kickoff(2);
                                    down = 1;
                                    resetPlay();
                                }
                            }
                        }
                        if (runPlayClock && offOrDef == 1) {
                            playclock--;
                            if (playclock < 0) {
                                runPlayClock = false;
                                playclock = 20;
                                if (ballPlace < 100) {
                                    fieldData[ballPlace][13]=0;
                                    ballPlace += 5;
                                    lstGameEvents.getItems().add("Delay of Game: 5 yard penalty");
                                    resetPlay();
                                } else {
                                    int amt = (105 - ballPlace) / 2;
                                    ballPlace += amt;
                                    lstGameEvents.getItems().add("Delay of Game: " + amt + " yard penalty");
                                    resetPlay();
                                }

                            }
                        }
                        if (offOrDef == 2) {
                            boolean cpuSack = false;
                            int yardsGainedOpp = 0;
                            boolean interceptionOff = false;
                            if (Math.random() < (.2 - (double) (opponent.getOlRating() - playersTeam.getDtRating()) / 100)) {
                                cpuSack = true;
                            }
                            if (!cpuSack) {
                                if (Math.random() < .7) {
                                    //pass play
                                    if (Math.random() < (.75 - (double) (opponent.getRecieverQBRating() - playersTeam.getDbRating()) / 100)) {
                                        //add completion
                                        yardsGainedOpp = (int) (Math.random() * 15 + opponent.getRecieverQBRating() - playersTeam.getDbRating());
                                        Players ranPlayer;
                                        if (Math.random() < .65) {
                                            ranPlayer = opponent.getWRchart().get((int) (Math.random() * 3));
                                        } else {
                                            if (Math.random() < .65) {
                                                ranPlayer = opponent.getTEchart().get(0);
                                            } else {
                                                ranPlayer = opponent.getRBchart().get(0);
                                            }
                                        }
                                        lstGameEvents.getItems().add("Reception: " + ranPlayer.getFirstName() + " " + ranPlayer.getLastName() + " caught ball for " + yardsGainedOpp + " yards. ");
                                    } else {
                                        if (Math.random() * playersTeam.getDbRating() > 80) {
                                            offOrDef = 1;
                                            ballPlace = ballPlace + (int) (Math.random() * 15);
                                            downPlace = ballPlace;
                                            runPlayClock = false;
                                            down = 1;
                                            Players ranPlayer;
                                            if (Math.random() > .65) {
                                                ranPlayer = playersTeam.getCBchart().get((int) (Math.random() * 3));
                                            } else {
                                                if (Math.random() > .5) {
                                                    ranPlayer = playersTeam.getLBchart().get((int) (Math.random() * 2));
                                                } else {
                                                    ranPlayer = playersTeam.getSSchart().get((int) (Math.random() * 2));
                                                }
                                            }
                                            fieldData[ballPlace][13] = 0;
                                            lstGameEvents.getItems().add("Interception: " + ranPlayer.getFirstName() + " " + ranPlayer.getLastName() + " intercepted the ball at " + (105 - ballPlace));
                                            resetPlay();
                                            runClock = false;
                                            interceptionOff = true;
                                        } else {
                                            lstGameEvents.getItems().add("Incompletion: " + opponent.getTeamName());
                                        }
                                    }
                                } else {
                                    //runPlay
                                    yardsGainedOpp = (int) (Math.random() * 10 + opponent.getOffensiveRating() - playersTeam.getDefensiveRating());
                                    lstGameEvents.getItems().add("Run: " + opponent.getRBchart().get(0).getFirstName() + " " + opponent.getRBchart().get(0).getLastName() + " ran ball for " + yardsGainedOpp + " yards. ");
                                }
                            } else {
                                //add sack
                                yardsGainedOpp = (int) (Math.random() * 5) * -1;
                                Players ranPlayer = playersTeam.getDTchart().get((int) (Math.random() * 4));
                                lstGameEvents.getItems().add("Sack: " + ranPlayer.getFirstName() + " " + ranPlayer.getLastName() + " sacked " + opponent.getQBchart().get(0).getFirstName() + " " + opponent.getQBchart().get(0).getLastName() + " for " + yardsGainedOpp + " yards");
                            }
                            if (!interceptionOff) {
                                down++;
                                fieldData[ballPlace][13] = 0;
                                ballPlace += yardsGainedOpp;
                                fieldData[ballPlace][13] = 3;
                                if (ballPlace - downPlace >= 10) {
                                    down = 1;
                                    downPlace = ballPlace;
                                }
                                if (ballPlace >= 100) {
                                    lstGameEvents.getItems().add("TOUCHDOWN " + opponent.getTeamName());
                                    team2Score += 7;
                                    runClock = false;
                                    runPlayClock = false;
                                    playclock = 20;
                                    offOrDef = 1;
                                    fieldData[ballPlace][13] = 0;
                                    kickoff(1);
                                    resetPlay();
                                }
                                if (down == 4) {
                                    runClock = false;
                                    runPlayClock = false;
                                    playclock = 20;
                                    fieldData[ballPlace][13] = 0;
                                    offOrDef = 1;
                                    kickoff(1);
                                    resetPlay();
                                }
                            }
                        }
                        startTime = System.nanoTime();
                    }

                    if (hike) {
                        if (playersOn != null) {
                            for (int i = 0; playersOn != null && i < playersOn.length; i++) {
                                if (now - playersOn[i].getPlayerStartTime() > playersOn[i].getCurrentSpeed()) {
                                    playersOn[i].changeLocation(fieldData, opponentsOn, playersOn[i], ballX, ballY, ballCaught, footballSize);
                                    if (!playersOn[i].isBallInAir()) {
                                        playerCarryingBall = playersOn[i];
                                        ballInAir = false;
                                        ballCaught = true;
                                        fieldData[playersOn[i].getYcord() + 1][playersOn[i].getXcord()] = 0;
                                    }
                                    playersOn[i].resetPlayerStartTime();
                                    playersOn[i].updateSpeed();
                                    updateGame();
                                }
                                if (playersOn != null) {
                                    if (playersOn[i].getPosition().equals("OL") && playersOn[i].isStunned()) {
                                        if (now - playersOn[i].getPlayerBlockTime() > playersOn[i].getBlockAbility()) {
                                            playersOn[i].setStunned(false);
                                        }
                                    }
                                }

                            }
                        }
                        if (opponentsOn != null) {
                            for (int i = 0; i < opponentsOn.length; i++) {
                                if (now - opponentsOn[i].getPlayerStartTime() > opponentsOn[i].getCurrentSpeed()) {
                                    opponentsOn[i].changeLocation(fieldData, playersOn, playersOn[5], playerCarryingBall, ballX, ballY, footballSize);
                                    opponentsOn[i].resetPlayerStartTime();
                                    opponentsOn[i].updateSpeed();
                                    if (opponentsOn[i].isBallPlayerTackled()) {
                                        int yardsGained = ballPlace;
                                        ballPlace = playerCarryingBall.getYcord();
                                        yardsGained = yardsGained - ballPlace;
                                        if (downPlace - ballPlace >= 10) {
                                            downPlace = ballPlace;
                                            down = 1;
                                        }
                                        if (playerCarryingBall.getPosition().equals("QB") || (playerCarryingBall.getPosition().equals("RB") && (playSelected.equals("[Outside Run]") || playSelected.equals("[Inside Run]")))) {
                                            lstGameEvents.getItems().add("Run: " + playerCarryingBall.getFirstName() + " " + playerCarryingBall.getLastName() + " ran ball for " + yardsGained + " yards. ");
                                        } else {
                                            lstGameEvents.getItems().add("Reception: " + playerCarryingBall.getFirstName() + " " + playerCarryingBall.getLastName() + " caught ball for " + yardsGained + " yards. ");
                                        }
                                        if (ballPlace>=105){
                                            offOrDef=2;
                                            kickoff(2);
                                            team2Score+=2;
                                        }
                                        lstGameEvents.getItems().add("Ball at " + (105 - ballPlace) + " yard line");
                                        resetPlay();
                                        runClock = true;
                                        break;
                                    } else if (opponentsOn[i].isSackedQB() && !ballInAir && !ballCaught) {
                                        down++;
                                        int yardsLost = ballPlace;
                                        ballPlace = playersOn[5].getYcord();
                                        yardsLost = Math.abs(yardsLost - ballPlace);
                                        lstGameEvents.getItems().add("Sack: " + opponentsOn[i].getFirstName() + " " + opponentsOn[i].getLastName() + " sacked " + playersOn[5].getFirstName() + " " + playersOn[5].getLastName() + " for " + yardsLost + " yards");
                                        lstGameEvents.getItems().add("Ball at " + (105 - ballPlace) + " yard line");
                                        if (ballPlace>=105){
                                            offOrDef=2;
                                            kickoff(2);
                                            team2Score+=2;
                                        }
                                        resetPlay();
                                        runClock = true;
                                        break;
                                    }
                                    updateGame();
                                }
                            }
                        }
                        if (ballInAir) {
                            if (Math.abs(ballY - playersOn[5].getYcord()) < 3 || Math.abs(ballY - playerThrowTo.getYcord()) < 3) {
                                footballSize = 1;
                            } else if (Math.abs(ballY - playersOn[5].getYcord()) < 7 || Math.abs(ballY - playerThrowTo.getYcord()) < 7) {
                                footballSize = 2;
                            } else {
                                footballSize = 3;
                            }
                            if (now - ballStartTime > 50000000) {
                                if (doneTraveling || (runned > 0 && playerThrowTo.getXcord() + aim > ballX && playerThrowTo.getXcord() - aim < ballX && playerThrowTo.getYcord() + aim > ballY && playerThrowTo.getYcord() - aim < ballY)) {
                                    doneTraveling = true;
                                    ballX = ballX + xdir;
                                    boolean over = false;
                                    if (ballX < 0 || ballX > 25) {
                                        ballInAir = false;
                                        over = true;
                                        down++;
                                        lstGameEvents.getItems().add("Out Of Bounds: Incomplete Throw");
                                        resetPlay();
                                        runClock = false;
                                    }
                                    ballY = ballY + ydir;
                                    if (ballY < 0 || ballY > 109) {
                                        if (!over) {
                                            ballInAir = false;
                                            down++;
                                            lstGameEvents.getItems().add("Out Of Bounds: Incomplete Throw");
                                            resetPlay();
                                            runClock = false;
                                        }

                                    }
                                } else {
                                    if (!doneTraveling) {
                                        runned++;
                                        double ychange = (playerThrowTo.getYcord() - ballY) / 5;
                                        double xchange = (playerThrowTo.getXcord() - ballX) / 5;
                                        ballX += xchange;
                                        ballY += ychange;
                                        xdir = xchange;
                                        ydir = ychange;
                                    }
                                }
                                ballStartTime = System.nanoTime();
                            }
                            if (playersOn != null) {
                                for (Players x : playersOn) {
                                    if (!((x.getPosition().equals("OL") || x.getPosition().equals("QB")) || x.getRoute().equals("block"))) {
                                        if (x.getXcord() + ((double) x.getAwarenessRating() / 10) - 4 > ballX && x.getXcord() - ((double) x.getAwarenessRating() / 10) - 4 < ballX && x.getYcord() + ((double) x.getAwarenessRating() / 10) - 4 > ballY && x.getYcord() - ((double) x.getAwarenessRating() / 10) - 4 < ballY) {
                                            x.setGoTowardBall(true);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (playersOn != null) {
                        for (Players x : playersOn) {
                            if (x.getResetPlay()) {
                                lstGameEvents.getItems().add("Incompletion: " + x.getFirstName() + " " + x.getLastName() + " dropped the ball");
                                x.setResetPlay(false);
                                down++;
                                resetPlay();
                                runClock = false;
                            }
                            if (!ballCaught && fieldData[x.getYcord() + 1][x.getXcord()] == 0 || fieldData[x.getYcord() + 1][x.getXcord()] == 4) {
                                fieldData[x.getYcord() + 1][x.getXcord()] = x.getKey();
                                updateGame();
                            }
                        }
                    }
                    if (opponentsOn != null) {
                        for (Players x : opponentsOn) {
                            if (x.getResetPlay()) {
                                lstGameEvents.getItems().add("Incompletion: Ball Defended");
                                x.setResetPlay(false);
                                down++;
                                resetPlay();
                                runClock = false;
                            }
                            if (x.isInterception()) {
                                offOrDef = 2;
                                ballPlace = x.getYcord();
                                downPlace = ballPlace;
                                down = 1;
                                lstGameEvents.getItems().add("Interception: " + x.getFirstName() + " " + x.getLastName() + " intercepted the ball at " + (105 - ballPlace));
                                resetPlay();
                                runClock = false;
                            }
                        }
                    }
                    updateGame();
                }
            }
        }.start();
    }
    private long ballStartTime;
    public void initialize(){
        String[] teamNames={"Arizona Cardinals","Atlanta Falcons","Carolina Panthers","Chicago Bears","Dallas Cowboys","Detroit Lions","Green Bay Packers","Los Angeles Rams","Minnesota Vikings","New Orleans Saints","New York Giants","Philidelphia Eagles","San Francisco 49ers","Seattle Seahawks","Tampa Bay Buccaneers","Washington Commanders"};
        String[] firstNames={"Cameron","Alex","Jonathan","Andre","Tony","Sean","Jeremy","Ben","Will","Jason","Tyler","Corey","Zach","Andrew","Kyle","Joe","Anthony","Robert","Kevin","John","Brian","Nick","James","Eric","Marcus","Justin","David","Michael","Jordan","Matt","Mike","Ryan","Josh","Brandon","Chris"};
        String[] lastNames={"Smith","Johnson","Williams","Brown","Jones","Davis","Miller","Wilson","Jackson","Moore"};
        for (int i=0;i< teamNames.length;i++){
            ArrayList<Players> tempRoster=new ArrayList<>();
            for (int j=0;j<6;j++){
                tempRoster.add(new Players(i,"DT",(int)(Math.random()*48+52),(int)(Math.random()*32+68),(int)(Math.random()*28+72),(int)(Math.random()*55+45),(int)(Math.random()*10+25),(int)(Math.random()*20+10),firstNames[(int)(Math.random()* firstNames.length)],lastNames[(int)(Math.random()* lastNames.length)],(int)(Math.random()*15+21),true));
            }
            for (int j=0;j<4;j++){
                tempRoster.add(new Players(i,"LB",(int)(Math.random()*25+75),(int)(Math.random()*21+79),(int)(Math.random()*36+64),(int)(Math.random()*53+47),(int)(Math.random()*45+55),(int)(Math.random()*20+10),firstNames[(int)(Math.random()* firstNames.length)],lastNames[(int)(Math.random()* lastNames.length)],(int)(Math.random()*15+21),true));
            }
            for (int j=0;j<4;j++){
                tempRoster.add(new Players(i,"CB",(int)(Math.random()*18+82),(int)(Math.random()*18+82),(int)(Math.random()*55+45),(int)(Math.random()*54+46),(int)(Math.random()*55+45),(int)(Math.random()*20+10),firstNames[(int)(Math.random()* firstNames.length)],lastNames[(int)(Math.random()* lastNames.length)],(int)(Math.random()*15+21),true));
            }
            for (int j=0;j<3;j++){
                tempRoster.add(new Players(i,"S",(int)(Math.random()*22+78),(int)(Math.random()*21+79),(int)(Math.random()*49+51),(int)(Math.random()*55+45),(int)(Math.random()*54+46),(int)(Math.random()*20+10),firstNames[(int)(Math.random()* firstNames.length)],lastNames[(int)(Math.random()* lastNames.length)],(int)(Math.random()*15+21),true));
            }
            for (int j=0;j<7;j++){
                tempRoster.add(new Players(i,"OL",(int)(Math.random()*50+50),(int)(Math.random()*41+59),(int)(Math.random()*25+75),(int)(Math.random()*54+46),(int)(Math.random()*20+10),(int)(Math.random()*20+10),firstNames[(int)(Math.random()* firstNames.length)],lastNames[(int)(Math.random()* lastNames.length)],(int)(Math.random()*15+21),true));
            }
            for (int j=0;j<2;j++){
                tempRoster.add(new Players(i,"QB",(int)(Math.random()*32+68),(int)(Math.random()*24+76),(int)(Math.random()*25+75),(int)(Math.random()*47+53),(int)(Math.random()*20+30),(int)(Math.random()*43+57),firstNames[(int)(Math.random()* firstNames.length)],lastNames[(int)(Math.random()* lastNames.length)],(int)(Math.random()*15+21),true));
            }
            for (int j=0;j<4;j++){
                tempRoster.add(new Players(i,"WR",(int)(Math.random()*21+79),(int)(Math.random()*19+81),(int)(Math.random()*56+44),(int)(Math.random()*50+50),(int)(Math.random()*31+69),(int)(Math.random()*20+20),firstNames[(int)(Math.random()* firstNames.length)],lastNames[(int)(Math.random()* lastNames.length)],(int)(Math.random()*15+21),true));
            }
            for (int j=0;j<2;j++){
                tempRoster.add(new Players(i,"TE",(int)(Math.random()*38+62),(int)(Math.random()*22+78),(int)(Math.random()*40+60),(int)(Math.random()*54+46),(int)(Math.random()*40+60),(int)(Math.random()*20+25),firstNames[(int)(Math.random()* firstNames.length)],lastNames[(int)(Math.random()* lastNames.length)],(int)(Math.random()*15+21),true));
            }
            for (int j=0;j<2;j++){
                tempRoster.add(new Players(i,"RB",(int)(Math.random()*20+80),(int)(Math.random()*18+82),(int)(Math.random()*46+64),(int)(Math.random()*56+44),(int)(Math.random()*46+54),(int)(Math.random()*20+15),firstNames[(int)(Math.random()* firstNames.length)],lastNames[(int)(Math.random()* lastNames.length)],(int)(Math.random()*15+21),true));
            }
            allTeams.add(new Teams(teamNames[i],tempRoster));
            lstTeamSelect.getItems().add(teamNames[i]);
        }
        for (String x: prioritiesList){
            prioritiesAvailable.add(x);
        }
        lstDraftPositions.getItems().add("ALL");
        lstDraftPositions.getItems().add("DT");
        lstDraftPositions.getItems().add("CB");
        lstDraftPositions.getItems().add("S");
        lstDraftPositions.getItems().add("LB");
        lstDraftPositions.getItems().add("QB");
        lstDraftPositions.getItems().add("OL");
        lstDraftPositions.getItems().add("WR");
        lstDraftPositions.getItems().add("TE");
        lstDraftPositions.getItems().add("RB");

        lstDraftPriorities.getItems().add("DT");
        lstDraftPriorities.getItems().add("CB");
        lstDraftPriorities.getItems().add("S");
        lstDraftPriorities.getItems().add("LB");
        lstDraftPriorities.getItems().add("QB");
        lstDraftPriorities.getItems().add("OL");
        lstDraftPriorities.getItems().add("WR");
        lstDraftPriorities.getItems().add("TE");
        lstDraftPriorities.getItems().add("RB");

        lstRouteAudible.getItems().add("In Route");
        lstRouteAudible.getItems().add("Out Route");
        lstRouteAudible.getItems().add("Streak Route");
        lstRouteAudible.getItems().add("Curl Route");
        lstRouteAudible.getItems().add("Cross Route");
        lstRouteAudible.getItems().add("Block Route");

        lstPickPositions.getItems().add("ALL");
        lstPickPositions.getItems().add("DT");
        lstPickPositions.getItems().add("CB");
        lstPickPositions.getItems().add("S");
        lstPickPositions.getItems().add("LB");
        lstPickPositions.getItems().add("QB");
        lstPickPositions.getItems().add("OL");
        lstPickPositions.getItems().add("WR");
        lstPickPositions.getItems().add("TE");
        lstPickPositions.getItems().add("RB");

//        lstPositionsGame.getItems().add("DT");
//        lstPositionsGame.getItems().add("CB");
//        lstPositionsGame.getItems().add("S");
//        lstPositionsGame.getItems().add("LB");
//        lstPositionsGame.getItems().add("QB");
//        lstPositionsGame.getItems().add("OL");
//        lstPositionsGame.getItems().add("WR");
//        lstPositionsGame.getItems().add("TE");
//        lstPositionsGame.getItems().add("RB");
        for (Teams x: allTeams){
            lstDraftTeams.getItems().add(x.getTeamName());
        }
        generateDraft();
        makeSchedule();
    }

    public void handleSubmitSetUp(ActionEvent actionEvent) {
        if (lstTeamSelect.getSelectionModel().getSelectedIndex()>-1&&!txtFirstName.getText().isEmpty()&&!txtLastName.getText().isEmpty()){
           for (Teams x: allTeams){
               if (x.getTeamName().equals(lstTeamSelect.getSelectionModel().getSelectedItem().toString())){
                   playersTeam=x;
               }
           }
           playerFirstName= txtFirstName.getText();
           playerLastName= txtLastName.getText();
           lblPlayerName.setText("Coach: "+playerFirstName+ " " + playerLastName);
           tabPreGame.setDisable(true);
           tabHomePage.setDisable(false);
           tabOffice.setDisable(false);
           tabRoster.setDisable(false);
           tabGame.setDisable(true);
           tabPane.getSelectionModel().select(tabHomePage);
        }
    }
    public void generateDraft(){
        String[] firstNames={"Cameron","Alex","Jonathan","Andre","Tony","Sean","Jeremy","Ben","Will","Jason","Tyler","Corey","Zach","Andrew","Kyle","Joe","Anthony","Robert","Kevin","John","Brian","Nick","James","Eric","Marcus","Justin","David","Michael","Jordan","Matt","Mike","Ryan","Josh","Brandon","Chris"};
        String[] lastNames={"Smith","Johnson","Williams","Brown","Jones","Davis","Miller","Wilson","Jackson","Moore"};
        for (int j=0;j<14;j++){
            draftProspects.add(new Players("DT",(int)(Math.random()*48+47),(int)(Math.random()*32+63),(int)(Math.random()*28+67),(int)(Math.random()*55+40),(int)(Math.random()*10+25),(int)(Math.random()*20+10),firstNames[(int)(Math.random()* firstNames.length)],lastNames[(int)(Math.random()* lastNames.length)],21,false));
        }
        for (int j=0;j<8;j++){
            draftProspects.add(new Players("LB",(int)(Math.random()*25+70),(int)(Math.random()*21+74),(int)(Math.random()*36+59),(int)(Math.random()*53+42),(int)(Math.random()*45+50),(int)(Math.random()*20+10),firstNames[(int)(Math.random()* firstNames.length)],lastNames[(int)(Math.random()* lastNames.length)],21,false));
        }
        for (int j=0;j<12;j++){
            draftProspects.add(new Players("CB",(int)(Math.random()*18+77),(int)(Math.random()*18+77),(int)(Math.random()*55+40),(int)(Math.random()*54+41),(int)(Math.random()*55+40),(int)(Math.random()*20+10),firstNames[(int)(Math.random()* firstNames.length)],lastNames[(int)(Math.random()* lastNames.length)],21,false));
        }
        for (int j=0;j<10;j++){
            draftProspects.add(new Players("S",(int)(Math.random()*22+73),(int)(Math.random()*21+74),(int)(Math.random()*49+46),(int)(Math.random()*55+40),(int)(Math.random()*54+41),(int)(Math.random()*20+10),firstNames[(int)(Math.random()* firstNames.length)],lastNames[(int)(Math.random()* lastNames.length)],21,false));
        }
        for (int j=0;j<16;j++){
            draftProspects.add(new Players("OL",(int)(Math.random()*50+45),(int)(Math.random()*41+54),(int)(Math.random()*25+70),(int)(Math.random()*54+41),(int)(Math.random()*20+10),(int)(Math.random()*20+10),firstNames[(int)(Math.random()* firstNames.length)],lastNames[(int)(Math.random()* lastNames.length)],21,false));
        }
        for (int j=0;j<6;j++){
            draftProspects.add(new Players("QB",(int)(Math.random()*32+63),(int)(Math.random()*24+71),(int)(Math.random()*25+70),(int)(Math.random()*47+48),(int)(Math.random()*20+30),(int)(Math.random()*43+52),firstNames[(int)(Math.random()* firstNames.length)],lastNames[(int)(Math.random()* lastNames.length)],21,false));
        }
        for (int j=0;j<14;j++){
            draftProspects.add(new Players("WR",(int)(Math.random()*21+74),(int)(Math.random()*19+76),(int)(Math.random()*56+39),(int)(Math.random()*50+45),(int)(Math.random()*31+64),(int)(Math.random()*20+20),firstNames[(int)(Math.random()* firstNames.length)],lastNames[(int)(Math.random()* lastNames.length)],21,false));
        }
        for (int j=0;j<8;j++){
            draftProspects.add(new Players("TE",(int)(Math.random()*38+57),(int)(Math.random()*22+73),(int)(Math.random()*40+55),(int)(Math.random()*54+41),(int)(Math.random()*40+55),(int)(Math.random()*20+25),firstNames[(int)(Math.random()* firstNames.length)],lastNames[(int)(Math.random()* lastNames.length)],21,false));
        }
        for (int j=0;j<8;j++){
            draftProspects.add(new Players("RB",(int)(Math.random()*20+75),(int)(Math.random()*18+77),(int)(Math.random()*46+59),(int)(Math.random()*56+39),(int)(Math.random()*46+49),(int)(Math.random()*20+15),firstNames[(int)(Math.random()* firstNames.length)],lastNames[(int)(Math.random()* lastNames.length)],21,false));
        }
        for (int i=0;i<draftProspects.size();i++){
            for (int j=0;j<draftProspects.size();j++){
                if (draftProspects.get(i).getOverallRating()>draftProspects.get(j).getOverallRating()){
                    Players temp = draftProspects.get(i);
                    draftProspects.set(i,draftProspects.get(j));
                    draftProspects.set(j,temp);
                }
            }
        }

        for (Players prospectSelected: draftProspects) {
            String speedGrade="";
            String accelerationGrade="";
            String strengthGrade="";
            String awarenessGrade="";
            String catchGrade="";
            String throwGrade="";
            if (prospectSelected.getPosition().equals("DT")) {
                speedGrade = determineGrade(47, prospectSelected.getSpeedRating());
                accelerationGrade = determineGrade(63, prospectSelected.getAccelerationRating());
                strengthGrade = determineGrade(67, prospectSelected.getStrengthRating());
                awarenessGrade = determineGrade(40, prospectSelected.getAwarenessRating());
            } else if (prospectSelected.getPosition().equals("LB")) {
                speedGrade = determineGrade(70, prospectSelected.getSpeedRating());
                accelerationGrade = determineGrade(74, prospectSelected.getAccelerationRating());
                strengthGrade = determineGrade(59, prospectSelected.getStrengthRating());
                awarenessGrade = determineGrade(42, prospectSelected.getAwarenessRating());
                catchGrade = determineGrade(50, prospectSelected.getCatchRating());
            } else if (prospectSelected.getPosition().equals("CB")) {
                speedGrade = determineGrade(77, prospectSelected.getSpeedRating());
                accelerationGrade = determineGrade(77, prospectSelected.getAccelerationRating());
                strengthGrade = determineGrade(40, prospectSelected.getStrengthRating());
                awarenessGrade = determineGrade(41, prospectSelected.getAwarenessRating());
                catchGrade = determineGrade(40, prospectSelected.getCatchRating());
            } else if (prospectSelected.getPosition().equals("S")) {
                speedGrade = determineGrade(73, prospectSelected.getSpeedRating());
                accelerationGrade = determineGrade(74, prospectSelected.getAccelerationRating());
                strengthGrade = determineGrade(46, prospectSelected.getStrengthRating());
                awarenessGrade = determineGrade(40, prospectSelected.getAwarenessRating());
                catchGrade = determineGrade(41, prospectSelected.getCatchRating());
            } else if (prospectSelected.getPosition().equals("OL")) {
                speedGrade = determineGrade(45, prospectSelected.getSpeedRating());
                accelerationGrade = determineGrade(54, prospectSelected.getAccelerationRating());
                strengthGrade = determineGrade(70, prospectSelected.getStrengthRating());
                awarenessGrade = determineGrade(41, prospectSelected.getAwarenessRating());
            } else if (prospectSelected.getPosition().equals("QB")) {
                speedGrade = determineGrade(63, prospectSelected.getSpeedRating());
                accelerationGrade = determineGrade(71, prospectSelected.getAccelerationRating());
                strengthGrade = determineGrade(70, prospectSelected.getStrengthRating());
                awarenessGrade = determineGrade(48, prospectSelected.getAwarenessRating());
                throwGrade = determineGrade(52, prospectSelected.getThrowRating());
            } else if (prospectSelected.getPosition().equals("WR")) {
                speedGrade = determineGrade(74, prospectSelected.getSpeedRating());
                accelerationGrade = determineGrade(76, prospectSelected.getAccelerationRating());
                strengthGrade = determineGrade(39, prospectSelected.getStrengthRating());
                awarenessGrade = determineGrade(45, prospectSelected.getAwarenessRating());
                catchGrade = determineGrade(64, prospectSelected.getCatchRating());
            } else if (prospectSelected.getPosition().equals("TE")) {
                speedGrade = determineGrade(57, prospectSelected.getSpeedRating());
                accelerationGrade = determineGrade(73, prospectSelected.getAccelerationRating());
                strengthGrade = determineGrade(55, prospectSelected.getStrengthRating());
                awarenessGrade = determineGrade(41, prospectSelected.getAwarenessRating());
                catchGrade = determineGrade(55, prospectSelected.getCatchRating());
            } else if (prospectSelected.getPosition().equals("RB")) {
                speedGrade = determineGrade(75, prospectSelected.getSpeedRating());
                accelerationGrade = determineGrade(77, prospectSelected.getAccelerationRating());
                strengthGrade = determineGrade(59, prospectSelected.getStrengthRating());
                awarenessGrade = determineGrade(39, prospectSelected.getAwarenessRating());
                catchGrade = determineGrade(49, prospectSelected.getCatchRating());
            }
            setGradeBrackets(speedGrade,prospectSelected,"Speed");
            setGradeBrackets(accelerationGrade,prospectSelected,"Acceleration");
            setGradeBrackets(strengthGrade,prospectSelected,"Strength");
            setGradeBrackets(awarenessGrade,prospectSelected,"Awareness");
            if (prospectSelected.getPosition().equals("CB")||prospectSelected.getPosition().equals("S")||prospectSelected.getPosition().equals("LB")||prospectSelected.getPosition().equals("WR")||prospectSelected.getPosition().equals("TE")||prospectSelected.getPosition().equals("RB")){
                setGradeBrackets(catchGrade,prospectSelected,"Catch");
            }
            if (prospectSelected.getPosition().equals("QB")){
                setGradeBrackets(throwGrade,prospectSelected,"Throw");
            }
        }

    }
    public void updateDepthChartsDisplay(Teams selectedTeam){
        depths(lstDTChart,selectedTeam.getDTchart(),4);
        depths(lstCBChart,selectedTeam.getCBchart(),3);
        depths(lstSSChart,selectedTeam.getSSchart(),2);
        depths(lstLBChart,selectedTeam.getLBchart(),2);
        depths(lstQBChart,selectedTeam.getQBchart(),1);
        depths(lstOLChart,selectedTeam.getOLchart(),5);
        depths(lstRBChart,selectedTeam.getRBchart(),1);
        depths(lstWRChart,selectedTeam.getWRchart(),3);
        depths(lstTEChart,selectedTeam.getTEchart(),1);
    }
    public void depths(ListView list,ArrayList<Players> chart,int numStarters){
        list.getItems().clear();
        int num=0;
        for (Players x: chart) {
            if (num < numStarters) {
                num++;
                list.getItems().add("X "+x.getFirstName() + " " + x.getLastName() + " (" + x.getOverallRating() + ")");
            }else {
                list.getItems().add(x.getFirstName() + " " + x.getLastName() + " (" + x.getOverallRating() + ")");
            }
        }
    }

    public void handleSelectedTeamRatings(MouseEvent mouseEvent) {
        int selectedIndex=lstTeamSelect.getSelectionModel().getSelectedIndex();
        lstTeamSelectRatings.getItems().clear();
        lstTeamSelectRatings.getItems().add("Overall Rating: "+allTeams.get(selectedIndex).getTeamOverallRating());
        lstTeamSelectRatings.getItems().add("Offense Rating (Starters): "+allTeams.get(selectedIndex).getOffensiveRating());
        lstTeamSelectRatings.getItems().add("Defensive Rating (Starters): "+allTeams.get(selectedIndex).getDefensiveRating());
    }

    public void handleSelectedTeamRatings2(KeyEvent keyEvent) {
        int selectedIndex=lstTeamSelect.getSelectionModel().getSelectedIndex();
        lstTeamSelectRatings.getItems().clear();
        lstTeamSelectRatings.getItems().add("Overall Rating: "+allTeams.get(selectedIndex).getTeamOverallRating());
        lstTeamSelectRatings.getItems().add("Offense Rating (Starters): "+allTeams.get(selectedIndex).getOffensiveRating());
        lstTeamSelectRatings.getItems().add("Defensive Rating (Starters): "+allTeams.get(selectedIndex).getDefensiveRating());
    }


    public void makeSchedule(){
        for (int i=0;i<8;i++){
            ArrayList<Teams>teamsLeftToAssign=new ArrayList<>();
            for (Teams x:allTeams){
                teamsLeftToAssign.add(x);
            }
            while (!teamsLeftToAssign.isEmpty()){
                int ranTeamOne=(int)(Math.random()*teamsLeftToAssign.size());
                int ranTeamTwo;
                if (teamsLeftToAssign.size()>2 && ranTeamOne<teamsLeftToAssign.size()-1&& ranTeamOne>0) {
                    double topBottom = Math.random();
                    if (topBottom <= .5) {
                        ranTeamTwo = (int) (Math.random() * ranTeamOne);
                    } else {
                        ranTeamTwo = (int) (Math.random() * (teamsLeftToAssign.size() -1- ranTeamOne) + ranTeamOne+1);
                    }
                }else{
                    if (ranTeamOne==0){
                        ranTeamTwo=(int) (Math.random() * teamsLeftToAssign.size()-1)+1;
                    }else{
                        ranTeamTwo=(int)(Math.random()*teamsLeftToAssign.size()-1);
                    }
                }
                teamsLeftToAssign.get(ranTeamOne).addTeamToSchedule(teamsLeftToAssign.get(ranTeamTwo));
                teamsLeftToAssign.get(ranTeamTwo).addTeamToSchedule(teamsLeftToAssign.get(ranTeamOne));
                teamsLeftToAssign.remove(ranTeamOne);
                if (ranTeamTwo>ranTeamOne){
                    teamsLeftToAssign.remove(ranTeamTwo-1);
                }else{
                    teamsLeftToAssign.remove(ranTeamTwo);
                }
            }

        }
    }

    public void handleManualUpdate(ActionEvent actionEvent) {
        if (reorderingDepthChart){
            reorderingDepthChart=false;
            btnManualReorder.setTextFill(Color.BLACK);
            reorder1=null;
            reorder2=null;
        }else{
            reorderingDepthChart=true;
            btnManualReorder.setTextFill(Color.RED);
        }
    }

    public void handleUpgradePlayer(ActionEvent actionEvent) {
        if (lstSelectedPlayerUpgrades.getSelectionModel().getSelectedIndex()>-1&&playerSelected.getUpgradeTokens()>0){
            playerSelected.dcrUpgradeTokens();
            if (lstSelectedPlayerUpgrades.getSelectionModel().getSelectedItems().toString().equals("[Speed Upgrade]")){
                playerSelected.incSpeed();
            }else if (lstSelectedPlayerUpgrades.getSelectionModel().getSelectedItems().toString().equals("[Acceleration Upgrade]")){
                playerSelected.incAcceleration();
            }else if (lstSelectedPlayerUpgrades.getSelectionModel().getSelectedItems().toString().equals("[Awareness Upgrade]")){
                playerSelected.incAwareness();
            }else if (lstSelectedPlayerUpgrades.getSelectionModel().getSelectedItems().toString().equals("[Strength Upgrade]")||lstSelectedPlayerUpgrades.getSelectionModel().getSelectedItems().toString().equals("[Arm Strength Upgrade]")){
                playerSelected.incStrength();
            }else if (lstSelectedPlayerUpgrades.getSelectionModel().getSelectedItems().toString().equals("[Catch Upgrade]")){
                playerSelected.incCatch();
            }else if (lstSelectedPlayerUpgrades.getSelectionModel().getSelectedItems().toString().equals("[Throw Accuracy Upgrade]")){
                playerSelected.incThrow();
            }
            playerStatsUpgradesDisplay();
            lblUpgradeTokens.setText("Upgrade Tokens: "+playerSelected.getUpgradeTokens());
            playerSelected.setOverall();
            playersTeam.findOverall();
            updateDepthChartsDisplay(playersTeam);
        }
    }

    public void handleAutoUpdate(ActionEvent actionEvent) {
        playersTeam.sortTeamDepthChart();
        updateDepthChartsDisplay(playersTeam);
    }
    Players playerSelected=null;
    Players reorder1=null;
    Players reorder2=null;
    public void handleDisplayPlayerStats(MouseEvent mouseEvent) {
        ArrayList<Players> usedChart=null;
        if (mouseEvent.getSource().equals(lstDTChart)) {
            usedChart=rosterSelectedTeamDef.getDTchart();
            playerSelected = rosterSelectedTeamDef.getDTchart().get(lstDTChart.getSelectionModel().getSelectedIndex());
        } else if (mouseEvent.getSource().equals(lstCBChart)) {
            usedChart=rosterSelectedTeamDef.getCBchart();
            playerSelected = rosterSelectedTeamDef.getCBchart().get(lstCBChart.getSelectionModel().getSelectedIndex());
        } else if (mouseEvent.getSource().equals(lstLBChart)) {
            usedChart=rosterSelectedTeamDef.getLBchart();
            playerSelected = rosterSelectedTeamDef.getLBchart().get(lstLBChart.getSelectionModel().getSelectedIndex());
        } else if (mouseEvent.getSource().equals(lstSSChart)) {
            usedChart=rosterSelectedTeamDef.getSSchart();
            playerSelected = rosterSelectedTeamDef.getSSchart().get(lstSSChart.getSelectionModel().getSelectedIndex());
        } else if (mouseEvent.getSource().equals(lstQBChart)) {
            usedChart=rosterSelectedTeamOff.getQBchart();
            playerSelected = rosterSelectedTeamOff.getQBchart().get(lstQBChart.getSelectionModel().getSelectedIndex());
        } else if (mouseEvent.getSource().equals(lstWRChart)) {
            usedChart=rosterSelectedTeamOff.getWRchart();
            playerSelected = rosterSelectedTeamOff.getWRchart().get(lstWRChart.getSelectionModel().getSelectedIndex());
        } else if (mouseEvent.getSource().equals(lstTEChart)) {
            usedChart=rosterSelectedTeamOff.getTEchart();
            playerSelected = rosterSelectedTeamOff.getTEchart().get(lstTEChart.getSelectionModel().getSelectedIndex());
        } else if (mouseEvent.getSource().equals(lstRBChart)) {
            usedChart=rosterSelectedTeamOff.getRBchart();
            playerSelected = rosterSelectedTeamOff.getRBchart().get(lstRBChart.getSelectionModel().getSelectedIndex());
        } else if (mouseEvent.getSource().equals(lstOLChart)) {
            usedChart=rosterSelectedTeamOff.getOLchart();
            playerSelected = rosterSelectedTeamOff.getOLchart().get(lstOLChart.getSelectionModel().getSelectedIndex());
        }
        playerStatsUpgradesDisplay();
        if (reorderingDepthChart){
            if (reorder1==null){
                reorder1=playerSelected;
            }else if (reorder2==null){
                reorder2=playerSelected;
            }
            if (reorder1!=null&&reorder2!=null&& usedChart!=null){
                int index1=-1;
                int index2=-1;
                for (int i=0;i<usedChart.size();i++){
                    if (usedChart.get(i)==reorder1){
                        index1=i;
                    }else if (usedChart.get(i)==reorder2){
                        index2=i;
                    }
                }
                Players temp=reorder1;
                usedChart.set(index1,reorder2);
                usedChart.set(index2,temp);
                reorder1=null;
                reorder2=null;
                updateDepthChartsDisplay(playersTeam);
                playersTeam.findOverall();
            }
        }
    }
    public void playerStatsUpgradesDisplay(){
        if (playerSelected!=null) {
            barXP.setProgress((double) playerSelected.getXp() /(1000+playerSelected.getYearsOfExperience()*200));
            lstSelectedPlayerStats.getItems().clear();
            lstSelectedPlayerStats.getItems().add("Name: "+playerSelected.getFirstName()+" "+ playerSelected.getLastName());
            lstSelectedPlayerStats.getItems().add("Position: "+playerSelected.getPosition());
            if (playerSelected.getAge()==21){
                lstSelectedPlayerStats.getItems().add("Age: "+ playerSelected.getAge() + " (Rookie)");
            }else if (playerSelected.getAge()==35){
                lstSelectedPlayerStats.getItems().add("Age: "+ playerSelected.getAge() + " (Retiring)");
            }else{
                lstSelectedPlayerStats.getItems().add("Age: "+ playerSelected.getAge());
            }
            lstSelectedPlayerStats.getItems().add("Level: "+ playerSelected.getLevel() + "-"+ playerSelected.getXp()+"/"+(1000+playerSelected.getYearsOfExperience()*200));
            lstSelectedPlayerStats.getItems().add("Experience: "+playerSelected.getYearsOfExperience() + " years");
            lstSelectedPlayerStats.getItems().add("Overall: "+playerSelected.getOverallRating());
            lstSelectedPlayerStats.getItems().add("Speed: " + playerSelected.getSpeedRating());
            lstSelectedPlayerStats.getItems().add("Acceleration: "+ playerSelected.getAccelerationRating());
            lstSelectedPlayerStats.getItems().add("Strength: "+ playerSelected.getStrengthRating());
            lstSelectedPlayerStats.getItems().add("Awareness: "+playerSelected.getAwarenessRating());
            lstSelectedPlayerStats.getItems().add("Catch: "+playerSelected.getCatchRating());
            lstSelectedPlayerStats.getItems().add("Throw Accuracy: "+ playerSelected.getThrowRating());
            lstSelectedPlayerUpgrades.getItems().clear();
            if (playerSelected.getSpeedRating()<99) {
                lstSelectedPlayerUpgrades.getItems().add("Speed Upgrade");
            }
            if (playerSelected.getAccelerationRating()<99) {
                lstSelectedPlayerUpgrades.getItems().add("Acceleration Upgrade");
            }
            if (playerSelected.getStrengthRating()<99) {
                if (playerSelected.getPosition().equals("QB")) {
                    lstSelectedPlayerUpgrades.getItems().add("Arm Strength Upgrade");
                } else {
                    lstSelectedPlayerUpgrades.getItems().add("Strength Upgrade");
                }
            }
            if (playerSelected.getAwarenessRating()<99) {
                lstSelectedPlayerUpgrades.getItems().add("Awareness Upgrade");
            }
            if (playerSelected.getCatchRating()<99) {
                if (playerSelected.getPosition().equals("RB") || playerSelected.getPosition().equals("WR") || playerSelected.getPosition().equals("TE") || playerSelected.getPosition().equals("LB") || playerSelected.getPosition().equals("CB") || playerSelected.getPosition().equals("S")) {
                    lstSelectedPlayerUpgrades.getItems().add("Catch Upgrade");
                }
            }
            if (playerSelected.getThrowRating()<99) {
                if (playerSelected.getPosition().equals("QB")) {
                    lstSelectedPlayerUpgrades.getItems().add("Throw Accuracy Upgrade");
                }
            }
            lblUpgradeTokens.setText("Upgrade Tokens: "+playerSelected.getUpgradeTokens());
        }
    }
    private Teams rosterSelectedTeamOff;
    private Teams rosterSelectedTeamDef;
    public void handleRosterDisplays(Event event) {
        lstRosterTeamSelectDef.getItems().clear();
        lstRosterTeamSelectOff.getItems().clear();
        for (Teams x: allTeams){
            if (playersTeam==x) {
                lstRosterTeamSelectDef.getItems().add(x.getTeamName() + "(Your Team)");
                lstRosterTeamSelectOff.getItems().add(x.getTeamName() + "(Your Team)");
            }else{
                lstRosterTeamSelectDef.getItems().add(x.getTeamName());
                lstRosterTeamSelectOff.getItems().add(x.getTeamName());
            }
        }
        playerSelected=null;
        lblUpgradeTokens.setText("Upgrade Tokens: --");
        rosterSelectedTeamOff=playersTeam;
        rosterSelectedTeamDef=playersTeam;
        updateDepthChartsDisplay(playersTeam);
        btnUpgradePlayer.setDisable(false);
        btnAutoReorder.setDisable(false);
        btnManualReorder.setDisable(false);
        lblRosterTeamSelectedDef.setText(playersTeam.getTeamName());
        lblRosterTeamSelectOff.setText(playersTeam.getTeamName());
    }

    public void handleHomeDisplays(Event event) {
        if (week<9){
            lblWeek.setText("Week "+week);
            Teams opponents=playersTeam.getYearSchedule().get(week-1);;
            lblOpName.setText("Name: "+opponents.getTeamName());
            lblOpOffRating.setText("Offense: " + opponents.getOffensiveRating());
            lblOpDefRating.setText("Defense: "+ opponents.getDefensiveRating());
            if (opponents.getWinStreak()>0){
                lblOpWinLossStreak.setText("Streak: +"+opponents.getWinStreak());
            }else if (opponents.getLossStreak()>0){
                lblOpWinLossStreak.setText("Streak: -"+opponents.getLossStreak());
            }else{
                lblOpWinLossStreak.setText("Streak: "+opponents.getLossStreak());
            }
            lblOffRating.setText("Offense: "+playersTeam.getOffensiveRating());
            lblDefRating.setText("Defense: "+playersTeam.getDefensiveRating());
            btnPlayGame.setText("Play Next Game");
        }else if (week==9){
            btnPlayGame.setText("Start Draft");
            lblWeek.setText("Draft Week");
            lblOpName.setText("Name: ");
            lblOpOffRating.setText("Offense: ");
            lblOpDefRating.setText("Defense: ");
            lblOpWinLossStreak.setText("Streak: ");
        }


        lstSchedule.getItems().clear();
        if (playersTeam.getWinStreak()>0){
            lblWinLossStreak.setText("Streak: +"+playersTeam.getWinStreak());
        }else if (playersTeam.getLossStreak()>0){
            lblWinLossStreak.setText("Streak: -"+playersTeam.getLossStreak());
        }else{
            lblWinLossStreak.setText("Streak: "+playersTeam.getLossStreak());
        }
        for (int i=0;i<playersTeam.getYearSchedule().size();i++){
            lstSchedule.getItems().add("Week "+(i+1)+": " + playersTeam.getYearSchedule().get(i).getTeamName());
        }
        lstStandings.getItems().clear();
        for (int i=0;i<allTeams.size();i++){
            for (int j=0;j<allTeams.size();j++){
                if (i>j && allTeams.get(i).getWins()>allTeams.get(j).getWins()){
                    Teams temp=allTeams.get(j);
                    allTeams.set(j,allTeams.get(i));
                    allTeams.set(i,temp);
                }else if (i>j && allTeams.get(i).getWins()==allTeams.get(j).getWins() && allTeams.get(i).getTies()>allTeams.get(j).getTies()){
                    Teams temp=allTeams.get(j);
                    allTeams.set(j,allTeams.get(i));
                    allTeams.set(i,temp);
                }
            }
        }
        lstStandings.getItems().add("NAME: WINS-TIES-LOSES");
        for (Teams x: allTeams){
            lstStandings.getItems().add(x.getTeamName()+": "+x.getWins()+"-"+x.getTies()+"-"+x.getLoses());
        }
        lstTeamName.setText(playersTeam.getTeamName());

    }

    public void handleOfficeDisplays(Event event) {
        lstDraftProspects.getItems().clear();
        int roundCount=16;
        for (Players draftPl:draftProspects){
            draftPl.setRoundProjected(roundCount/16);
            draftPl.setPickProjected(roundCount-15);
            lstDraftProspects.getItems().add(draftPl.getPosition() + " "+draftPl.getFirstName() +" "+ draftPl.getLastName() + " R"+ draftPl.getRoundProjected()+ " pick "+draftPl.getPickProjected());
            roundCount++;
        }
    }

    public void handleRosterSelectedTeamDef(MouseEvent mouseEvent) {
        rosterSelectedTeamDef=allTeams.get(lstRosterTeamSelectDef.getSelectionModel().getSelectedIndex());
        lblRosterTeamSelectedDef.setText(rosterSelectedTeamDef.getTeamName());
        if (rosterSelectedTeamDef==playersTeam){
            btnUpgradePlayer.setDisable(false);
            btnAutoReorder.setDisable(false);
            btnManualReorder.setDisable(false);
        }else{
            btnUpgradePlayer.setDisable(true);
            btnAutoReorder.setDisable(true);
            btnManualReorder.setDisable(true);
        }
        updateDepthChartsDisplay(rosterSelectedTeamDef);
    }

    public void handleRosterSelectedTeamOff(MouseEvent mouseEvent) {
        rosterSelectedTeamOff=allTeams.get(lstRosterTeamSelectOff.getSelectionModel().getSelectedIndex());
        lblRosterTeamSelectOff.setText(rosterSelectedTeamOff.getTeamName());
        if (rosterSelectedTeamOff==playersTeam){
            btnUpgradePlayer.setDisable(false);
            btnAutoReorder.setDisable(false);
            btnManualReorder.setDisable(false);
        }else{
            btnUpgradePlayer.setDisable(true);
            btnAutoReorder.setDisable(true);
            btnManualReorder.setDisable(true);
        }
        updateDepthChartsDisplay(rosterSelectedTeamOff);
    }

    public void handleDraftPositionsSelect(MouseEvent mouseEvent) {
        String positionSelected=lstDraftPositions.getSelectionModel().getSelectedItems().toString();
        lstDraftProspects.getItems().clear();
        for (Players draftPl:draftProspects) {
            if (positionSelected.equals("[ALL]")) {
                lstDraftProspects.getItems().add(draftPl.getPosition() + " " + draftPl.getFirstName() + " " + draftPl.getLastName() + " R" + draftPl.getRoundProjected() + " pick " + draftPl.getPickProjected());
            }else if (positionSelected.equals("["+draftPl.getPosition()+"]")){
                lstDraftProspects.getItems().add(draftPl.getPosition() + " " + draftPl.getFirstName() + " " + draftPl.getLastName() + " R" + draftPl.getRoundProjected() + " pick " + draftPl.getPickProjected());
            }
        }
    }

    public void handleDraftProspectSelect(MouseEvent mouseEvent) {
        Players prospectSelected=draftProspects.get(Integer.parseInt(lstDraftProspects.getSelectionModel().getSelectedItems().toString().substring(lstDraftProspects.getSelectionModel().getSelectedItems().toString().indexOf("pick ")+5,lstDraftProspects.getSelectionModel().getSelectedItems().toString().length()-1))-1);
        lstProspectGrades.getItems().clear();
        lstProspectGrades.getItems().add("Name: "+prospectSelected.getFirstName()+ " " + prospectSelected.getLastName());
        lstProspectGrades.getItems().add("Position: "+ prospectSelected.getPosition());
        for (int i=0;i<3;i++){
            if (prospectSelected.getSpeedDraftLevel()==i){
                lstProspectGrades.getItems().add("Speed Grade: "+prospectSelected.getSpeedGradeBrackets(i));
            }
            if (prospectSelected.getAccelerationDraftLevel()==i){
                lstProspectGrades.getItems().add("Acceleration Grade: "+prospectSelected.getAccelerationGradeBrackets(i));
            }
            if (prospectSelected.getStengthDraftLevel()==i){
                lstProspectGrades.getItems().add("Strength Grade: "+prospectSelected.getStrengthGradeBrackets(i));
            }
            if (prospectSelected.getAwarenessDraftLevel()==i){
                lstProspectGrades.getItems().add("Awareness Grade: "+prospectSelected.getAwarenessGradeBrackets(i));
            }
            if ((prospectSelected.getPosition().equals("CB")||prospectSelected.getPosition().equals("S")||prospectSelected.getPosition().equals("LB")||prospectSelected.getPosition().equals("WR")||prospectSelected.getPosition().equals("TE")||prospectSelected.getPosition().equals("RB"))&&prospectSelected.getCatchDraftLevel()==i){
                lstProspectGrades.getItems().add("Catch Grade: "+prospectSelected.getCatchGradeBrackets(i));
            }
            if (prospectSelected.getPosition().equals("QB")&&prospectSelected.getThrowDraftLevel()==i){
                lstProspectGrades.getItems().add("Throw Grade: "+prospectSelected.getThrowGradeBrackets(i));
            }
        }

    }
    public void setGradeBrackets(String grade,Players prospect,String bracketType){
        if (grade.equals("F")){
            prospect.setBrackets("F-C",0,bracketType);
        }else if (grade.equals("D")){
            if (Math.random()<.5){
                prospect.setBrackets("F-C",0,bracketType);
            }else{
                prospect.setBrackets("D-B",0,bracketType);
            }
        }else if (grade.equals("C")){
            if (Math.random()<.33){
                prospect.setBrackets("F-C",0,bracketType);
            }else{
                if (Math.random()>.5){
                    prospect.setBrackets("C-A",0,bracketType);
                }else{
                    prospect.setBrackets("D-B",0,bracketType);
                }
            }
        }else if (grade.equals("B")){
            if (Math.random()<.5){
                prospect.setBrackets("D-B",0,bracketType);
            }else{
                prospect.setBrackets("C-A",0,bracketType);
            }
        }else{
            prospect.setBrackets("C-A",0,bracketType);
        }
        if (grade.equals("F")){
            prospect.setBrackets("F-D",1,bracketType);
        }else if (grade.equals("D")){
            if (Math.random()>.5){
                prospect.setBrackets("F-D",1,bracketType);
            }else{
                prospect.setBrackets("D-C",1,bracketType);
            }
        }else if (grade.equals("C")){
            if (Math.random()>.5) {
                prospect.setBrackets("D-C",1,bracketType);
            }else{
                prospect.setBrackets("C-B",1,bracketType);
            }
        }else if (grade.equals("B")){
            if (Math.random()>.5){
                prospect.setBrackets("C-B",1,bracketType);
            }else{
                prospect.setBrackets("B-A",1,bracketType);
            }
        }else{
            prospect.setBrackets("B-A",1,bracketType);
        }
        prospect.setBrackets(grade,2,bracketType);
    }
    public String determineGrade(int min,int prospectXRating){
        int change = (95-min)/5;
        if (prospectXRating>=95-change){
            return "A";
        }else if (prospectXRating>=95-change*2){
            return "B";
        }else if (prospectXRating>=95-change*3){
            return "C";
        }else if (prospectXRating>=95-change*4){
            return "D";
        }else{
            return "F";
        }
    }
    private ArrayList<String> prioritiesAvailable=new ArrayList<>();
    private String[] prioritiesList={"DT","CB","S","LB","QB","OL","WR","TE","RB"};
    private ArrayList<String> prioritiesSelected=new ArrayList<>();
    public void handleSelectDraftPriorities(ActionEvent actionEvent) {
        if (prioritiesSelected.size()<3){
            prioritiesSelected.add(prioritiesAvailable.get(lstDraftPriorities.getSelectionModel().getSelectedIndex()));
            prioritiesAvailable.remove(lstDraftPriorities.getSelectionModel().getSelectedIndex());
            lstDraftPrioritiesSelected.getItems().add(prioritiesSelected.get(prioritiesSelected.size()-1));
            lstDraftPriorities.getItems().clear();
            for (String x:prioritiesAvailable){
                lstDraftPriorities.getItems().add(x);
            }
        }
    }

    public void handleDeselectDraftPriorities(ActionEvent actionEvent) {
        prioritiesAvailable.add(prioritiesSelected.get(lstDraftPrioritiesSelected.getSelectionModel().getSelectedIndex()));
        prioritiesSelected.remove(lstDraftPrioritiesSelected.getSelectionModel().getSelectedIndex());
        lstDraftPriorities.getItems().add(prioritiesAvailable.get(prioritiesAvailable.size()-1));
        lstDraftPrioritiesSelected.getItems().clear();
        for (String x:prioritiesSelected){
            lstDraftPrioritiesSelected.getItems().add(x);
        }
    }

    public void handleCallTimeout(ActionEvent actionEvent) {
        if (timeoutsUsed1<3){
            runClock=false;
            playclock=20;
            runPlayClock=false;
            timeoutsUsed1++;
        }
        updateGame();
    }

    public void handleSelectPlays(MouseEvent mouseEvent) {
        if (offOrDef==1) {
            String selectedPlay = lstPlays.getSelectionModel().getSelectedItems().toString();
            if (selectedPlay.equals("[Inside Run]")) {
                imgPlays.setImage(inside);
            } else if (selectedPlay.equals("[Outside Run]")) {
                imgPlays.setImage(outside);
            } else if (selectedPlay.equals("[Bench]")) {
                imgPlays.setImage(bench);
            } else if (selectedPlay.equals("[Hail Mary]")) {
                imgPlays.setImage(deep);
            } else if (selectedPlay.equals("[Drag Cross]")) {
                imgPlays.setImage(drag);
            }
            playSelected = lstPlays.getSelectionModel().getSelectedItems().toString();
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
                    if (fieldData[i][j] == 4) {
                        fieldData[i][j] = 0;
                    }
                }
            }
            if (playersOn != null) {
                for (int i = 0; i < playersOn.length; i++) {
                    if (allTeams.get(playersOn[i].getTeam()).getTeamName().equals(playersTeam.getTeamName())) {
                        ImageView dummy = new ImageView(back);
                        dummy.setFitHeight(15);
                        dummy.setPreserveRatio(true);
                        field[playersOn[i].getYcord()][playersOn[i].getXcord()].setGraphic(dummy);
                        fieldData[playersOn[i].getYcord() + 1][playersOn[i].getXcord()] = 0;
                    }
                }
            }
            if (opponentsOn != null) {
                for (int i = 0; i < opponentsOn.length; i++) {
                    if (allTeams.get(opponentsOn[i].getTeam()).getTeamName().equals(playersTeam.getYearSchedule().get(week - 1).getTeamName())) {
                        ImageView dummy = new ImageView(back);
                        dummy.setFitHeight(15);
                        dummy.setPreserveRatio(true);
                        field[opponentsOn[i].getYcord()][opponentsOn[i].getXcord()].setGraphic(dummy);
                    }
                }
            }
            playersOn = null;
            if (playSelected.equals("[Inside Run]")) {
                playersTeam.getWRchart().get(0).setCord(8, ballPlace, fieldData);
                playersTeam.getTEchart().get(0).setCord(10, ballPlace, fieldData);
                playersTeam.getWRchart().get(1).setCord(16, ballPlace, fieldData);
                playersTeam.getWRchart().get(2).setCord(18, ballPlace, fieldData);
                playersTeam.getRBchart().get(0).setCord(14, ballPlace + 3, fieldData);
                playersTeam.getQBchart().get(0).setCord(13, ballPlace + 2, fieldData);
                playersTeam.getOLchart().get(0).setCord(13, ballPlace, fieldData);
                playersTeam.getOLchart().get(1).setCord(14, ballPlace, fieldData);
                playersTeam.getOLchart().get(2).setCord(12, ballPlace, fieldData);
                playersTeam.getOLchart().get(3).setCord(11, ballPlace, fieldData);
                playersTeam.getOLchart().get(4).setCord(15, ballPlace, fieldData);

                playersOn = new Players[]{playersTeam.getWRchart().get(0), playersTeam.getWRchart().get(1), playersTeam.getWRchart().get(2), playersTeam.getTEchart().get(0), playersTeam.getRBchart().get(0), playersTeam.getQBchart().get(0), playersTeam.getOLchart().get(0), playersTeam.getOLchart().get(1), playersTeam.getOLchart().get(2), playersTeam.getOLchart().get(3), playersTeam.getOLchart().get(4)};
                blockRoute(playersTeam.getWRchart().get(0));
                blockRoute(playersTeam.getTEchart().get(0));
                blockRoute(playersTeam.getWRchart().get(2));
                blockRoute(playersTeam.getWRchart().get(1));
                insideRun(playersTeam.getRBchart().get(0));
            } else if (playSelected.equals("[Outside Run]")) {
                playersTeam.getWRchart().get(0).setCord(4, ballPlace, fieldData);
                playersTeam.getTEchart().get(0).setCord(10, ballPlace, fieldData);
                playersTeam.getWRchart().get(1).setCord(18, ballPlace, fieldData);
                playersTeam.getWRchart().get(2).setCord(8, ballPlace, fieldData);
                playersTeam.getRBchart().get(0).setCord(14, ballPlace + 3, fieldData);
                playersTeam.getQBchart().get(0).setCord(13, ballPlace + 2, fieldData);
                playersTeam.getOLchart().get(0).setCord(13, ballPlace, fieldData);
                playersTeam.getOLchart().get(1).setCord(12, ballPlace, fieldData);
                playersTeam.getOLchart().get(2).setCord(11, ballPlace, fieldData);
                playersTeam.getOLchart().get(3).setCord(14, ballPlace, fieldData);
                playersTeam.getOLchart().get(4).setCord(15, ballPlace, fieldData);

                playersOn = new Players[]{playersTeam.getWRchart().get(0), playersTeam.getWRchart().get(1), playersTeam.getWRchart().get(2), playersTeam.getTEchart().get(0), playersTeam.getRBchart().get(0), playersTeam.getQBchart().get(0), playersTeam.getOLchart().get(0), playersTeam.getOLchart().get(1), playersTeam.getOLchart().get(2), playersTeam.getOLchart().get(3), playersTeam.getOLchart().get(4)};
                blockRoute(playersTeam.getWRchart().get(0));
                blockRoute(playersTeam.getTEchart().get(0));
                blockRoute(playersTeam.getWRchart().get(2));
                blockRoute(playersTeam.getWRchart().get(1));
                outsideRun(playersTeam.getRBchart().get(0));
            } else if (playSelected.equals("[Bench]")) {
                playersTeam.getWRchart().get(0).setCord(7, ballPlace, fieldData);
                playersTeam.getTEchart().get(0).setCord(17, ballPlace, fieldData);
                playersTeam.getWRchart().get(1).setCord(19, ballPlace, fieldData);
                playersTeam.getWRchart().get(2).setCord(9, ballPlace, fieldData);
                playersTeam.getRBchart().get(0).setCord(12, ballPlace + 3, fieldData);
                playersTeam.getQBchart().get(0).setCord(13, ballPlace + 2, fieldData);
                playersTeam.getOLchart().get(0).setCord(13, ballPlace, fieldData);
                playersTeam.getOLchart().get(1).setCord(12, ballPlace, fieldData);
                playersTeam.getOLchart().get(2).setCord(14, ballPlace, fieldData);
                playersTeam.getOLchart().get(3).setCord(11, ballPlace, fieldData);
                playersTeam.getOLchart().get(4).setCord(15, ballPlace, fieldData);

                //W=5;
                //A=6;
                //D=7;
                //S=8;
                //F=9;

                playersOn = new Players[]{playersTeam.getWRchart().get(0), playersTeam.getWRchart().get(1), playersTeam.getWRchart().get(2), playersTeam.getTEchart().get(0), playersTeam.getRBchart().get(0), playersTeam.getQBchart().get(0), playersTeam.getOLchart().get(0), playersTeam.getOLchart().get(1), playersTeam.getOLchart().get(2), playersTeam.getOLchart().get(3), playersTeam.getOLchart().get(4)};
                crossRoute(playersTeam.getWRchart().get(0), -1, 6, 5);
                outInRoute(playersTeam.getTEchart().get(0), 1, 4, 6);
                outInRoute(playersTeam.getWRchart().get(2), -1, 4, 7);
                crossRoute(playersTeam.getWRchart().get(1), 1, 6, 8);
                streakRoute(playersTeam.getRBchart().get(0), 9, 9);
            } else if (playSelected.equals("[Hail Mary]")) {
                playersTeam.getWRchart().get(0).setCord(3, ballPlace, fieldData);
                playersTeam.getTEchart().get(0).setCord(18, ballPlace, fieldData);
                playersTeam.getWRchart().get(1).setCord(22, ballPlace, fieldData);
                playersTeam.getWRchart().get(2).setCord(7, ballPlace, fieldData);
                playersTeam.getRBchart().get(0).setCord(14, ballPlace + 3, fieldData);
                playersTeam.getQBchart().get(0).setCord(13, ballPlace + 2, fieldData);
                playersTeam.getOLchart().get(0).setCord(13, ballPlace, fieldData);
                playersTeam.getOLchart().get(1).setCord(12, ballPlace, fieldData);
                playersTeam.getOLchart().get(2).setCord(14, ballPlace, fieldData);
                playersTeam.getOLchart().get(3).setCord(11, ballPlace, fieldData);
                playersTeam.getOLchart().get(4).setCord(15, ballPlace, fieldData);

                playersOn = new Players[]{playersTeam.getWRchart().get(0), playersTeam.getWRchart().get(1), playersTeam.getWRchart().get(2), playersTeam.getTEchart().get(0), playersTeam.getRBchart().get(0), playersTeam.getQBchart().get(0), playersTeam.getOLchart().get(0), playersTeam.getOLchart().get(1), playersTeam.getOLchart().get(2), playersTeam.getOLchart().get(3), playersTeam.getOLchart().get(4)};
                streakRoute(playersTeam.getWRchart().get(0), 30, 5);
                crossRoute(playersTeam.getTEchart().get(0), -1, 5, 6);
                crossRoute(playersTeam.getWRchart().get(2), 1, 15, 7);
                streakRoute(playersTeam.getWRchart().get(1), 30, 8);
                blockRoute(playersTeam.getRBchart().get(0));
            } else if (playSelected.equals("[Drag Cross]")) {
                playersTeam.getWRchart().get(0).setCord(3, ballPlace, fieldData);
                playersTeam.getTEchart().get(0).setCord(16, ballPlace, fieldData);
                playersTeam.getWRchart().get(1).setCord(22, ballPlace, fieldData);
                playersTeam.getWRchart().get(2).setCord(9, ballPlace, fieldData);
                playersTeam.getRBchart().get(0).setCord(14, ballPlace + 3, fieldData);
                playersTeam.getQBchart().get(0).setCord(13, ballPlace + 2, fieldData);
                playersTeam.getOLchart().get(0).setCord(13, ballPlace, fieldData);
                playersTeam.getOLchart().get(1).setCord(12, ballPlace, fieldData);
                playersTeam.getOLchart().get(2).setCord(14, ballPlace, fieldData);
                playersTeam.getOLchart().get(3).setCord(11, ballPlace, fieldData);
                playersTeam.getOLchart().get(4).setCord(15, ballPlace, fieldData);

                playersOn = new Players[]{playersTeam.getWRchart().get(0), playersTeam.getWRchart().get(1), playersTeam.getWRchart().get(2), playersTeam.getTEchart().get(0), playersTeam.getRBchart().get(0), playersTeam.getQBchart().get(0), playersTeam.getOLchart().get(0), playersTeam.getOLchart().get(1), playersTeam.getOLchart().get(2), playersTeam.getOLchart().get(3), playersTeam.getOLchart().get(4)};

                crossRoute(playersTeam.getWRchart().get(0), 1, 10, 5);
                streakRoute(playersTeam.getTEchart().get(0), 6, 6);
                outInRoute(playersTeam.getWRchart().get(2), 1, 4, 7);
                outInRoute(playersTeam.getWRchart().get(1), -1, 9, 8);
                outInRoute(playersTeam.getRBchart().get(0), 1, 3, 9);
            }
            opponent.getCBchart().get(0).setCord(playersTeam.getWRchart().get(0).getXcord(), playersTeam.getWRchart().get(0).getYcord() - 2, fieldData);
            opponent.getCBchart().get(1).setCord(playersTeam.getWRchart().get(1).getXcord(), playersTeam.getWRchart().get(1).getYcord() - 2, fieldData);
            opponent.getCBchart().get(2).setCord(playersTeam.getWRchart().get(2).getXcord(), playersTeam.getWRchart().get(2).getYcord() - 2, fieldData);
            opponent.getLBchart().get(0).setCord(playersTeam.getTEchart().get(0).getXcord(), playersTeam.getTEchart().get(0).getYcord() - 2, fieldData);
            opponent.getLBchart().get(1).setCord(playersTeam.getRBchart().get(0).getXcord(), playersTeam.getRBchart().get(0).getYcord() - 6, fieldData);
            opponent.getDTchart().get(0).setCord(playersTeam.getOLchart().get(1).getXcord(), playersTeam.getOLchart().get(1).getYcord() - 1, fieldData);
            opponent.getDTchart().get(1).setCord(playersTeam.getOLchart().get(2).getXcord(), playersTeam.getOLchart().get(2).getYcord() - 1, fieldData);
            opponent.getDTchart().get(2).setCord(playersTeam.getOLchart().get(3).getXcord(), playersTeam.getOLchart().get(3).getYcord() - 1, fieldData);
            opponent.getDTchart().get(3).setCord(playersTeam.getOLchart().get(4).getXcord(), playersTeam.getOLchart().get(4).getYcord() - 1, fieldData);
            if (ballPlace>=8){
                opponent.getSSchart().get(0).setCord(7, ballPlace - 8, fieldData);
                opponent.getSSchart().get(1).setCord(19, ballPlace - 8, fieldData);
            }else{
                opponent.getSSchart().get(0).setCord(7, 0, fieldData);
                opponent.getSSchart().get(1).setCord(19, 0, fieldData);
            }

            opponent.getCBchart().get(0).setOpponent(playersTeam.getWRchart().get(0));
            opponent.getCBchart().get(1).setOpponent(playersTeam.getWRchart().get(1));
            opponent.getCBchart().get(2).setOpponent(playersTeam.getWRchart().get(2));
            opponent.getLBchart().get(0).setOpponent(playersTeam.getTEchart().get(0));
            opponent.getLBchart().get(1).setOpponent(playersTeam.getRBchart().get(0));
            opponentsOn = null;
            opponentsOn = new Players[]{opponent.getDTchart().get(0), opponent.getDTchart().get(1), opponent.getDTchart().get(2), opponent.getDTchart().get(3), opponent.getCBchart().get(0), opponent.getCBchart().get(1), opponent.getCBchart().get(2), opponent.getLBchart().get(0), opponent.getLBchart().get(1), opponent.getSSchart().get(0), opponent.getSSchart().get(1)};
            lstPlayerAudible.getItems().clear();
            for (Players x : playersOn) {
                if (x.getPosition().equals("WR") || x.getPosition().equals("TE") || x.getPosition().equals("RB")) {
                    lstPlayerAudible.getItems().add(x.getPosition() + " " + x.getFirstName() + " " + x.getLastName());
                }
            }
            selectedAudiblePlayer = null;
            lblPlayerAudible.setText("Player Selected: None");
            updateGame();
        }
    }
    private String playSelected;
    public void outInRoute(Players player, int direction,int distance,int key){
        player.setRoute("outIn");
        player.setDirection(direction);
        player.setRouteDistance(distance);
        player.setKey(key);
        for (int i=player.getYcord()-1;i>player.getYcord()-distance && i>=0;i--){
            fieldData[i][player.getXcord()]=4;
        }
        int y=player.getYcord()-distance+1;
        if (direction==-1){
            for (int i=player.getXcord();i>=0;i--){
                fieldData[y][i]=4;
            }
        }else{
            for (int i=player.getXcord();i<=25;i++){
                fieldData[y][i]=4;
            }
        }
    }
    public void streakRoute(Players player,int distance,int key){
        player.setRoute("streak");
        player.setRouteDistance(distance);
        player.setKey(key);
        for (int i=player.getYcord()-1;i>player.getYcord()-distance && i>=0;i--){
            fieldData[i][player.getXcord()]=4;
        }
    }
    public void crossRoute(Players players,int direction,int distance,int key){
        players.setRoute("cross");
        players.setDirection(direction);
        players.setRouteDistance(distance);
        players.setKey(key);
        for (int i=players.getYcord()-1;i>players.getYcord()-distance && i>=0;i--){
            fieldData[i][players.getXcord()]=4;
        }
        int y=players.getYcord()-distance+1;
        if (y<0){
            y=0;
        }
        if (direction==-1){
            for (int i=players.getXcord();i>=0;i--){
                if (y>0){
                    y--;
                }
                fieldData[y][i]=4;
            }
        }else{
            for (int i=players.getXcord();i<=25;i++){
                if (y>0){
                    y--;
                }
                fieldData[y][i]=4;
            }
        }
    }
    public void blockRoute(Players players){
        players.setRoute("block");
        for (int i=players.getYcord()-1;i>players.getYcord()-3;i--){
            fieldData[i][players.getXcord()]=4;
        }
    }
    public void outsideRun(Players players){
        players.setRunDirection(4);
        for (int i=players.getXcord();i>players.getXcord()-6;i--){
            fieldData[players.getYcord()-1][i]=4;
        }
    }
    public void insideRun(Players players){
        players.setRunDirection(1);
        for (int i=players.getYcord()-1;i>players.getYcord()-6;i--){
            fieldData[i][players.getXcord()]=4;
        }
    }
    public void resetPlay(){
        if (playersOn!=null) {
            if (down>4 && offOrDef==1){
                offOrDef=2;
            }
            playerCarryingBall=null;
            doneTraveling = false;
            playclock=20;
            runned = 0;
            hike = false;
            runPlayClock=true;
            ballY = 0;
            ballX = 0;
            ballCaught=false;
            ballInAir=false;
            selectedAudiblePlayer=null;
            lblPlayerAudible.setText("Player Selected: None");
            for (Players x : playersOn) {
                x.resetPlayer();
            }
            for (Players x : opponentsOn) {
                x.resetPlayer();
            }
            playersOn = null;
            opponentsOn = null;
            for (int i = 0; i < fieldData.length; i++) {
                for (int j = 0; j < fieldData[i].length; j++) {
                    fieldData[i][j] = 0;
                }
            }
            fieldData[ballPlace][13] = 3;
            updateGame();
            lstPlayerAudible.getItems().clear();
        }
    }
    public void handleKeyPressed(KeyEvent keyEvent) {
        if (keyEvent.getText().equals("e") && playersOn!=null){
            runClock=true;
            runPlayClock=false;
            hike=true;
            if (Math.random()<.5){
                aim=Math.abs((Math.random()*(.1*(100-playersOn[5].getThrowRating()))-(100-playersOn[5].getThrowRating())*.05)+ (-1 * (double) (ballY - playersOn[5].getYcord()) /((double) playersOn[5].getStrengthRating() /10+7)));
            }else{
                aim=Math.abs((Math.random()*(.1*(100-playersOn[5].getThrowRating()))-(100-playersOn[5].getThrowRating())*.05)+ ((double) (ballY - playersOn[5].getYcord()) /((double) playersOn[5].getStrengthRating() /10+7)));
            }
            if (playSelected.equals("[Outside Run]")|| playSelected.equals("[Inside Run]")){
                playerCarryingBall=playersOn[4];
                playerCarryingBall.setCarryingBall(true);
            }
        }else if (keyEvent.getText().equals("w")&&hike){
            if (playerCarryingBall!=null){
                playerCarryingBall.setRunDirection(1);
            }else {
                ballInAir = true;
                for (Players x : playersOn) {
                    x.setBallInAir(true);
                    if (x.getKey() == 5) {
                        playerThrowTo = x;
                    }
                }
                footballSize = 1;
                ballX = playersOn[5].getXcord();
                ballY = playersOn[5].getYcord();
                ballStartTime = System.nanoTime();
            }
        }else if (keyEvent.getText().equals("a")&&hike){
            if (playerCarryingBall!=null){
                playerCarryingBall.setRunDirection(4);
            }else {
                ballInAir = true;
                for (Players x : playersOn) {
                    x.setBallInAir(true);
                    if (x.getKey() == 6) {
                        playerThrowTo = x;
                    }
                }
                footballSize = 1;
                ballX = playersOn[5].getXcord();
                ballY = playersOn[5].getYcord();
                ballStartTime = System.nanoTime();
            }
        }else if (keyEvent.getText().equals("s")&&hike){
            if (playerCarryingBall!=null){
                playerCarryingBall.setRunDirection(2);
            }else {
                ballInAir = true;
                for (Players x : playersOn) {
                    x.setBallInAir(true);
                    if (x.getKey() == 8) {
                        playerThrowTo = x;
                    }
                }
                footballSize = 1;
                ballX = playersOn[5].getXcord();
                ballY = playersOn[5].getYcord();
                ballStartTime = System.nanoTime();
            }
        }else if (keyEvent.getText().equals("d")&&hike){
            if (playerCarryingBall!=null){
                playerCarryingBall.setRunDirection(3);
            }else {
                ballInAir = true;
                for (Players x : playersOn) {
                    x.setBallInAir(true);
                    if (x.getKey() == 7) {
                        playerThrowTo = x;
                    }
                }
                footballSize = 1;
                ballX = playersOn[5].getXcord();
                ballY = playersOn[5].getYcord();
                ballStartTime = System.nanoTime();
            }
        }else if (keyEvent.getText().equals("f")&&hike){
            ballInAir=true;
            for (Players x: playersOn){
                x.setBallInAir(true);
                if (x.getKey()==9){
                    playerThrowTo=x;
                }
            }
            footballSize=1;
            ballX=playersOn[5].getXcord();
            ballY=playersOn[5].getYcord();
            ballStartTime=System.nanoTime();
        }else if (keyEvent.getText().equals("q") && hike && playerCarryingBall==null && !ballInAir){
            playerCarryingBall=playersOn[5];
            playersOn[5].setCarryingBall(true);
            for (Players x: playersOn){
                if (!x.getPosition().equals("QB")){
                    x.setRoute("block");
                }
            }
        }else if (keyEvent.getText().equals("r") && selectedAudiblePlayer!=null){
            if (selectedAudiblePlayer.getRoute().equals("cross")){
                for (int i=selectedAudiblePlayer.getYcord()-1;i>selectedAudiblePlayer.getYcord()-selectedAudiblePlayer.getRouteDistance() && i>=0;i--){
                    fieldData[i][selectedAudiblePlayer.getXcord()]=0;
                }
                int y=selectedAudiblePlayer.getYcord()-selectedAudiblePlayer.getRouteDistance()+1;
                if (y<0){
                    y=0;
                }
                if (selectedAudiblePlayer.getDirection()==-1){
                    for (int i=selectedAudiblePlayer.getXcord();i>=0;i--){
                        if (y>0){
                            y--;
                        }
                        fieldData[y][i]=0;
                    }
                }else{
                    for (int i=selectedAudiblePlayer.getXcord();i<=25;i++){
                        if (y>0){
                            y--;
                        }
                        fieldData[y][i]=0;
                    }
                }
                crossRoute(selectedAudiblePlayer,selectedAudiblePlayer.getDirection()*-1,selectedAudiblePlayer.getRouteDistance(),selectedAudiblePlayer.getKey());
            }else if (selectedAudiblePlayer.getRoute().equals("outIn")){
                for (int i=selectedAudiblePlayer.getYcord()-1;i>selectedAudiblePlayer.getYcord()-selectedAudiblePlayer.getRouteDistance();i--){
                    fieldData[i][selectedAudiblePlayer.getXcord()]=0;
                }
                int y=selectedAudiblePlayer.getYcord()-selectedAudiblePlayer.getRouteDistance()+1;
                if (selectedAudiblePlayer.getDirection()==-1){
                    for (int i=selectedAudiblePlayer.getXcord();i>=0;i--){
                        fieldData[y][i]=0;
                    }
                }else{
                    for (int i=selectedAudiblePlayer.getXcord();i<=25;i++){
                        fieldData[y][i]=0;
                    }
                }
                outInRoute(selectedAudiblePlayer,selectedAudiblePlayer.getDirection()*-1,selectedAudiblePlayer.getRouteDistance(),selectedAudiblePlayer.getKey());
            }
        }else if (keyEvent.getText().equals("t") && selectedAudiblePlayer!=null){
            if (selectedAudiblePlayer.getRoute().equals("cross")){
                for (int i=selectedAudiblePlayer.getYcord()-1;i>selectedAudiblePlayer.getYcord()-selectedAudiblePlayer.getRouteDistance() && i>=0;i--){
                    fieldData[i][selectedAudiblePlayer.getXcord()]=0;
                }
                int y=selectedAudiblePlayer.getYcord()-selectedAudiblePlayer.getRouteDistance()+1;
                if (y<0){
                    y=0;
                }
                if (selectedAudiblePlayer.getDirection()==-1){
                    for (int i=selectedAudiblePlayer.getXcord();i>=0;i--){
                        if (y>0){
                            y--;
                        }
                        fieldData[y][i]=0;
                    }
                }else{
                    for (int i=selectedAudiblePlayer.getXcord();i<=25;i++){
                        if (y>0){
                            y--;
                        }
                        fieldData[y][i]=0;
                    }
                }
                crossRoute(selectedAudiblePlayer,selectedAudiblePlayer.getDirection(),10-(downPlace-ballPlace),selectedAudiblePlayer.getKey());
            }else if (selectedAudiblePlayer.getRoute().equals("streak")){
                for (int i=selectedAudiblePlayer.getYcord()-1;i>selectedAudiblePlayer.getYcord()-selectedAudiblePlayer.getRouteDistance() && i>=0;i--){
                    fieldData[i][selectedAudiblePlayer.getXcord()]=0;
                }
                streakRoute(selectedAudiblePlayer,10-(downPlace-ballPlace),selectedAudiblePlayer.getKey());
            }else if (selectedAudiblePlayer.getRoute().equals("outIn")){
                for (int i=selectedAudiblePlayer.getYcord()-1;i>selectedAudiblePlayer.getYcord()-selectedAudiblePlayer.getRouteDistance();i--){
                    fieldData[i][selectedAudiblePlayer.getXcord()]=0;
                }
                int y=selectedAudiblePlayer.getYcord()-selectedAudiblePlayer.getRouteDistance()+1;
                if (selectedAudiblePlayer.getDirection()==-1){
                    for (int i=selectedAudiblePlayer.getXcord();i>=0;i--){
                        fieldData[y][i]=0;
                    }
                }else{
                    for (int i=selectedAudiblePlayer.getXcord();i<=25;i++){
                        fieldData[y][i]=0;
                    }
                }
                outInRoute(selectedAudiblePlayer,selectedAudiblePlayer.getDirection(),10-(downPlace-ballPlace),selectedAudiblePlayer.getKey());
            }
        }
    }
    public void gameOver(){
        resetPlay();
        if (team1Score>team2Score){
            playersTeam.incWins();
            opponent.incLoses();
        }else if (team2Score>team1Score){
            opponent.incWins();
            playersTeam.incLoses();
        }else{
            opponent.incTies();
            playersTeam.incTies();
        }
        for (Teams x: allTeams){
            x.setCpuTeamScores((int)(Math.random()*(x.getOffensiveRating()+x.getDefensiveRating())));
            x.setGameCalculated(false);
            for (Players y: x.getStartingRoster()){
                y.incXP((int)(Math.random()*500)+200);
                if (y.getXp()>=(1000+y.getYearsOfExperience()*200)){
                    y.incLevel();
                    y.incXP((1000+y.getYearsOfExperience()*200)*-1);
                    if (x==playersTeam) {
                        y.incUpdateTokens();
                    }else{
                        autoUpgrade(y);
                    }
                }
            }
        }
        for (Teams x: allTeams){
            if (!x.isGameCalculated() && x!=playersTeam && x!=opponent){
                if (x.getCpuTeamScores()>x.getYearSchedule().get(week-1).getCpuTeamScores()){
                    x.incWins();
                    x.getYearSchedule().get(week-1).incLoses();
                }else if (x.getCpuTeamScores()<x.getYearSchedule().get(week-1).getCpuTeamScores()){
                    x.incLoses();
                    x.getYearSchedule().get(week-1).incWins();
                }else if (x.getCpuTeamScores()==x.getYearSchedule().get(week-1).getCpuTeamScores()){
                    x.incTies();
                    x.getYearSchedule().get(week-1).incTies();
                }
                x.setGameCalculated(true);
                x.getYearSchedule().get(week-1).setGameCalculated(true);
            }
        }
        for (Players x: draftProspects){
            boolean priority=false;
            for (String y: prioritiesSelected){
                if (x.getPosition().equals(y)){
                    priority=true;
                }
            }
            if (priority){
                incGrades(x,.3);
            }else{
                incGrades(x,.1);
            }
        }
        week++;
        tabPane.getSelectionModel().select(tabHomePage);
        tabGame.setDisable(true);
        tabOffice.setDisable(false);
        tabRoster.setDisable(false);
        tabHomePage.setDisable(false);
    }
    public void incGrades(Players x,double chance){
        if (Math.random()<chance){
            if (x.getSpeedDraftLevel()<2){
                x.incSpeedDraftLevel();
            }
        }
        if (Math.random()<chance){
            if (x.getAccelerationDraftLevel()<2){
                x.incAccelerationDraftLevel();
            }
        }
        if (Math.random()<chance){
            if (x.getStengthDraftLevel()<2){
                x.incStrengthDraftLevel();
            }
        }
        if (Math.random()<chance){
            if (x.getAwarenessDraftLevel()<2){
                x.incAwarenessDraftLevel();
            }
        }
        if (Math.random()<chance) {
            if ((x.getPosition().equals("CB") || x.getPosition().equals("S") || x.getPosition().equals("LB") || x.getPosition().equals("WR") || x.getPosition().equals("TE") || x.getPosition().equals("RB")) && x.getCatchDraftLevel() < 2) {
                x.incCatchDraftLevel();
            }
        }
        if (Math.random()<chance){
            if (x.getPosition().equals("QB")&&x.getThrowDraftLevel()<2){
                x.incThrowDraftLevel();
            }
        }

    }
    public void autoUpgrade(Players y){
        if (y.getPosition().equals("DT")|| y.getPosition().equals("OL")){
            if (y.getStrengthRating()<99){
                y.incStrength();
            }else if (y.getAwarenessRating()<99){
                y.incAwareness();
            }else if (y.getAccelerationRating()<99){
                y.incAcceleration();
            }else if (y.getSpeedRating()<99){
                y.incSpeed();
            }
        }else if (y.getPosition().equals("CB")||y.getPosition().equals("S")||y.getPosition().equals("LB")){
            if (y.getStrengthRating()<99){
                y.incStrength();
            }else if (y.getAwarenessRating()<99){
                y.incAwareness();
            }else if (y.getCatchRating()<99){
                y.incCatch();
            }else if (y.getAccelerationRating()<99){
                y.incAcceleration();
            }else if (y.getSpeedRating()<99){
                y.incSpeed();
            }
        }else if (y.getPosition().equals("WR")||y.getPosition().equals("TE")){
            if (y.getSpeedRating()<99){
                y.incSpeed();
            }else if (y.getAccelerationRating()<99){
                y.incAcceleration();
            }else if (y.getAwarenessRating()<99){
                y.incAwareness();
            }else if (y.getCatchRating()<99){
                y.incCatch();
            }else if (y.getStrengthRating()<99){
                y.incStrength();
            }
        }else if (y.getPosition().equals("RB")){
            if (y.getStrengthRating()<99){
                y.incStrength();
            }else if (y.getSpeedRating()<99){
                y.incSpeed();
            }else if (y.getAccelerationRating()<99){
                y.incAcceleration();
            }else if (y.getAwarenessRating()<99){
                y.incAwareness();
            }else if (y.getCatchRating()<99){
                y.incCatch();
            }
        }else if (y.getPosition().equals("QB")){
            if (y.getThrowRating()<99){
                y.incThrow();
            }else if (y.getStrengthRating()<99){
                y.incStrength();
            }else if (y.getAwarenessRating()<99){
                y.incAwareness();
            } else if (y.getSpeedRating()<99){
                y.incSpeed();
            }else if (y.getAccelerationRating()<99){
                y.incAcceleration();
            }
        }
    }
    public void handleAudibleRoute(MouseEvent mouseEvent) {
        if (selectedAudiblePlayer!=null) {
            String route = lstRouteAudible.getSelectionModel().getSelectedItems().toString();
            if (selectedAudiblePlayer.getRoute().equals("cross")){
                for (int i=selectedAudiblePlayer.getYcord()-1;i>selectedAudiblePlayer.getYcord()-selectedAudiblePlayer.getRouteDistance() && i>=0;i--){
                    fieldData[i][selectedAudiblePlayer.getXcord()]=0;
                }
                int y=selectedAudiblePlayer.getYcord()-selectedAudiblePlayer.getRouteDistance()+1;
                if (y<0){
                    y=0;
                }
                if (selectedAudiblePlayer.getDirection()==-1){
                    for (int i=selectedAudiblePlayer.getXcord();i>=0;i--){
                        if (y>0){
                            y--;
                        }
                        fieldData[y][i]=0;
                    }
                }else{
                    for (int i=selectedAudiblePlayer.getXcord();i<=25;i++){
                        if (y>0){
                            y--;
                        }
                        fieldData[y][i]=0;
                    }
                }
            }else if (selectedAudiblePlayer.getRoute().equals("streak")){
                for (int i=selectedAudiblePlayer.getYcord()-1;i>selectedAudiblePlayer.getYcord()-selectedAudiblePlayer.getRouteDistance() && i>=0;i--){
                    fieldData[i][selectedAudiblePlayer.getXcord()]=0;
                }
            }else if (selectedAudiblePlayer.getRoute().equals("outIn")){
                for (int i=selectedAudiblePlayer.getYcord()-1;i>selectedAudiblePlayer.getYcord()-selectedAudiblePlayer.getRouteDistance();i--){
                    fieldData[i][selectedAudiblePlayer.getXcord()]=0;
                }
                int y=selectedAudiblePlayer.getYcord()-selectedAudiblePlayer.getRouteDistance()+1;
                if (selectedAudiblePlayer.getDirection()==-1){
                    for (int i=selectedAudiblePlayer.getXcord();i>=0;i--){
                        fieldData[y][i]=0;
                    }
                }else{
                    for (int i=selectedAudiblePlayer.getXcord();i<=25;i++){
                        fieldData[y][i]=0;
                    }
                }
            }else if (selectedAudiblePlayer.getRoute().equals("block")){
                for (int i=selectedAudiblePlayer.getYcord()-1;i>selectedAudiblePlayer.getYcord()-3;i--){
                    fieldData[i][selectedAudiblePlayer.getXcord()]=0;
                }
            }
            if (route.equals("[In Route]")) {
                if (selectedAudiblePlayer.getXcord()<13){
                    outInRoute(selectedAudiblePlayer,1,5,selectedAudiblePlayer.getKey());
                }else {
                    outInRoute(selectedAudiblePlayer,-1,5,selectedAudiblePlayer.getKey());
                }
            } else if (route.equals("[Out Route]")) {
                if (selectedAudiblePlayer.getXcord()<13){
                    outInRoute(selectedAudiblePlayer,-1,5,selectedAudiblePlayer.getKey());
                }else {
                    outInRoute(selectedAudiblePlayer,1,5,selectedAudiblePlayer.getKey());
                }
            } else if (route.equals("[Streak Route]")) {
                streakRoute(selectedAudiblePlayer,30,selectedAudiblePlayer.getKey());
            } else if (route.equals("[Curl Route]")) {
                streakRoute(selectedAudiblePlayer,6,selectedAudiblePlayer.getKey());
            }else if (route.equals("[Cross Route]")) {
                if (selectedAudiblePlayer.getXcord()<13){
                    crossRoute(selectedAudiblePlayer,1,5,selectedAudiblePlayer.getKey());
                }else {
                    crossRoute(selectedAudiblePlayer,-1,5,selectedAudiblePlayer.getKey());
                }
            } else if (route.equals("[Block Route]")) {
                blockRoute(selectedAudiblePlayer);
            }
        }
    }
    private Players selectedAudiblePlayer;
    public void handleSelectAudiblePlayer(MouseEvent mouseEvent) {
        if (playersOn!=null){
            for (Players x: playersOn){
                if (lstPlayerAudible.getSelectionModel().getSelectedItems().toString().equals("["+ x.getPosition() + " " + x.getFirstName() + " " + x.getLastName() + "]")){
                    selectedAudiblePlayer=x;
                }
            }
        }
        String audiblePlayerKey="";
        if (selectedAudiblePlayer.getKey()==5){
            audiblePlayerKey="W";
        }else if (selectedAudiblePlayer.getKey()==6){
            audiblePlayerKey="A";
        }else if (selectedAudiblePlayer.getKey()==7){
            audiblePlayerKey="D";
        }else if (selectedAudiblePlayer.getKey()==8){
            audiblePlayerKey="S";
        }else if (selectedAudiblePlayer.getKey()==9){
            audiblePlayerKey="F";
        }
        lblPlayerAudible.setText("Player Selected: " + selectedAudiblePlayer.getFirstName()+ " "+ selectedAudiblePlayer.getLastName() + " " + audiblePlayerKey);
    }

    public void handleForceGameOver(ActionEvent actionEvent) {
        gameOver();
    }

    public void handleKickBall(ActionEvent actionEvent) {
        if (offOrDef==1 && down==4 && !hike){
            runClock = false;
            runPlayClock = false;
            playclock = 20;
            fieldData[ballPlace][13]=0;
            offOrDef=2;
            kickoff(2);
            resetPlay();
        }
    }
    private int pick=1;
    private int round=1;
    private String positionPicked="";
    public void handleDraftTeams(MouseEvent mouseEvent) {
        lstDraftPicks.getItems().clear();
        System.out.println(lstDraftTeams.getSelectionModel().getSelectedItems().toString().substring(1,lstDraftTeams.getSelectionModel().getSelectedItems().toString().length()-1));
        for (int j=0;j<allTeams.size();j++){
            if (allTeams.get(j).getTeamName().equals(lstDraftTeams.getSelectionModel().getSelectedItems().toString().substring(1,lstDraftTeams.getSelectionModel().getSelectedItems().toString().length()-1))){
                lstDraftPicks.getItems().add(allTeams.get(j).getTeamName());
                for (int i=1;i<7;i++) {
                    lstDraftPicks.getItems().add("R" + i + " Pick "+((allTeams.size()-j-1)+16*(i-1)+1));
                }
            }
        }
    }

    public void handleDraftPlayer(ActionEvent actionEvent) {
        if (lstPickPlayerList.getSelectionModel().getSelectedIndex()>-1){
            Players draftPlayer = draftProspectsAvailable.get(lstPickPlayerList.getSelectionModel().getSelectedIndex());
            playersTeam.addToRoster(draftPlayer);
            lblLastPlayer.setText("Player Choosen: "+ draftPlayer.getPosition() + " " + draftPlayer.getFirstName() + " " + draftPlayer.getLastName());
            draftProspectsAvailable.remove(lstPickPlayerList.getSelectionModel().getSelectedIndex());
            updateProspectsAvailable();
            lstProjectedDraftBoard.getItems().clear();
            for (Players n: draftProspects){
                boolean found=false;
                for (Players m:draftProspectsAvailable){
                    if (m==n){
                        found=true;
                    }
                }
                if (!found){
                    lstProjectedDraftBoard.getItems().add("Picked " + n.getPosition() + " "+n.getFirstName() +" "+ n.getLastName() + " R"+ n.getRoundProjected()+ " pick "+n.getPickProjected());
                }
                if (found){
                    lstProjectedDraftBoard.getItems().add(n.getPosition() + " "+n.getFirstName() +" "+ n.getLastName() + " R"+ n.getRoundProjected()+ " pick "+n.getPickProjected());
                }
            }
            lblLastPick.setText("Pick: " +pick);
            lblLastTeam.setText("Team: "+playersTeam.getTeamName());
            pick++;
            if (pick/17!=0){
                pick=1;
                round++;
            }
            lblOnClockRound.setText("Round: " + round);
            lblOnClockTeam.setText("Team: " + allTeams.get(allTeams.size()-pick).getTeamName());
            lblOnClockPick.setText("Pick: "+pick);
            playerOn=false;
        }
    }

    public void handleSkipToNext(ActionEvent actionEvent) {
        draftNum=0;
        simDraftPick();
    }

    public void handlePickPositions(MouseEvent mouseEvent) {
        positionPicked=lstPickPositions.getSelectionModel().getSelectedItems().toString();
        updateProspectsAvailable();
    }
    public void updateProjectedDraftBoard(){
        lstProjectedDraftBoard.getItems().clear();
        int roundCount=16;
        for (Players draftPl:draftProspects){
            draftPl.setRoundProjected(roundCount/16);
            draftPl.setPickProjected(roundCount-15);
            lstProjectedDraftBoard.getItems().add(draftPl.getPosition() + " "+draftPl.getFirstName() +" "+ draftPl.getLastName() + " R"+ draftPl.getRoundProjected()+ " pick "+draftPl.getPickProjected());
            roundCount++;
        }
    }
    private boolean draftOn=false;
    public void simDraftPick(){
        Teams draftTeamUp=allTeams.get(allTeams.size()-pick);
        int[]temp={0,0,0,0,0,0,0,0,0};
        int[]plyAmt={0,0,0,0,0,0,0,0,0};
        for (Players x: draftProspectsAvailable){
            if (x.getPosition().equals("QB")){
                temp[0]=temp[0]+x.getRoundProjected();
                plyAmt[0]++;
            }else if (x.getPosition().equals("RB")){
                temp[1]=temp[1]+x.getRoundProjected();
                plyAmt[1]++;
            }else if (x.getPosition().equals("TE")){
                temp[2]=temp[2]+x.getRoundProjected();
                plyAmt[2]++;
            }else if (x.getPosition().equals("WR")){
                temp[3]=temp[3]+x.getRoundProjected();
                plyAmt[3]++;
            }else if (x.getPosition().equals("OL")){
                temp[4]=temp[4]+x.getRoundProjected();
                plyAmt[4]++;
            }else if (x.getPosition().equals("DT")){
                temp[5]=temp[5]+x.getRoundProjected();
                plyAmt[5]++;
            }else if (x.getPosition().equals("CB")){
                temp[6]=temp[6]+x.getRoundProjected();
                plyAmt[6]++;
            }else if (x.getPosition().equals("S")){
                temp[7]=temp[7]+x.getRoundProjected();
                plyAmt[7]++;
            }else if (x.getPosition().equals("LB")){
                temp[8]=temp[8]+x.getRoundProjected();
                plyAmt[8]++;
            }
        }
        for (int i=0;i<temp.length;i++){
            if (plyAmt[i]>0){
                temp[i]/=plyAmt[i];
            }
            temp[i]*=10;
        }
        draftTeamUp.calculateDraftNeeds(temp);
        boolean end=false;
        for (String y: draftTeamUp.getPositionOrder()){
            for (int i=0;i< draftProspectsAvailable.size();i++){
                if (draftProspectsAvailable.get(i).getPosition().equals(y)){
                    draftTeamUp.addToRoster(draftProspectsAvailable.get(i));
                    lblLastPlayer.setText("Player Choosen: "+ draftProspectsAvailable.get(i).getPosition() + " " + draftProspectsAvailable.get(i).getFirstName() + " " + draftProspectsAvailable.get(i).getLastName());
                    draftProspectsAvailable.remove(i);
                    updateProspectsAvailable();
                    lstProjectedDraftBoard.getItems().clear();
                    for (Players n: draftProspects){
                        boolean found=false;
                        for (Players m:draftProspectsAvailable){
                            if (m==n){
                                found=true;
                            }
                        }
                        if (!found){
                            lstProjectedDraftBoard.getItems().add("Picked " + n.getPosition() + " "+n.getFirstName() +" "+ n.getLastName() + " R"+ n.getRoundProjected()+ " pick "+n.getPickProjected());
                        }
                        if (found){
                            lstProjectedDraftBoard.getItems().add(n.getPosition() + " "+n.getFirstName() +" "+ n.getLastName() + " R"+ n.getRoundProjected()+ " pick "+n.getPickProjected());
                        }
                    }
                    lblLastPick.setText("Pick: " +pick);
                    lblLastTeam.setText("Team: "+draftTeamUp.getTeamName());
                    pick++;
                    if (pick/17!=0){
                        pick=1;
                        round++;
                    }
                    if (allTeams.get(allTeams.size()-pick)==playersTeam){
                        playerOn=true;
                    }
                    lblOnClockRound.setText("Round: " + round);
                    lblOnClockTeam.setText("Team: " + allTeams.get(allTeams.size()-pick).getTeamName());
                    lblOnClockPick.setText("Pick: "+pick);
                    end=true;
                    if (round==7){
                        draftOn=false;
                        tabPane.getSelectionModel().select(tabHomePage);
                        tabDraft.setDisable(true);
                        tabHomePage.setDisable(false);
                        tabRoster.setDisable(false);
                        tabOffice.setDisable(false);
                    }
                    break;
                }
            }
            if (end){
                break;
            }
        }
    }
    public void setUpNewYear(){
        week=1;
        draftProspects.clear();
        draftProspectsAvailable.clear();
        for (Teams x: allTeams){
            for (int i=0;i<x.getRoster().size();i++){
                x.getRoster().get(i).incAge();
                if (x.getRoster().get(i).getAge()>35){
                    x.getRoster().remove(i);
                    x.redoRoster();
                }
            }
            x.clearSchedule();
            x.resetStandings();
        }
        generateDraft();
        makeSchedule();
    }
    public void updateProspectsAvailable(){
        lstPickPlayerList.getItems().clear();
        for (Players x: draftProspectsAvailable) {
            if (positionPicked.equals("[ALL]") || positionPicked.isEmpty()) {
                lstPickPlayerList.getItems().add(x.getPosition() + " " + x.getFirstName() + " " + x.getLastName());
            }else if (positionPicked.equals("[QB]") && x.getPosition().equals("QB")){
                lstPickPlayerList.getItems().add(x.getPosition() + " " + x.getFirstName() + " " + x.getLastName());
            } else if (positionPicked.equals("[WR]") && x.getPosition().equals("WR")){
                lstPickPlayerList.getItems().add(x.getPosition() + " " + x.getFirstName() + " " + x.getLastName());
            }else if (positionPicked.equals("[TE]") && x.getPosition().equals("TE")){
                lstPickPlayerList.getItems().add(x.getPosition() + " " + x.getFirstName() + " " + x.getLastName());
            }else if (positionPicked.equals("[RB]") && x.getPosition().equals("RB")){
                lstPickPlayerList.getItems().add(x.getPosition() + " " + x.getFirstName() + " " + x.getLastName());
            }else if (positionPicked.equals("[CB]") && x.getPosition().equals("CB")){
                lstPickPlayerList.getItems().add(x.getPosition() + " " + x.getFirstName() + " " + x.getLastName());
            }else if (positionPicked.equals("[LB]") && x.getPosition().equals("LB")){
                lstPickPlayerList.getItems().add(x.getPosition() + " " + x.getFirstName() + " " + x.getLastName());
            }else if (positionPicked.equals("[S]") && x.getPosition().equals("S")){
                lstPickPlayerList.getItems().add(x.getPosition() + " " + x.getFirstName() + " " + x.getLastName());
            }else if (positionPicked.equals("[OL]") && x.getPosition().equals("OL")){
                lstPickPlayerList.getItems().add(x.getPosition() + " " + x.getFirstName() + " " + x.getLastName());
            }else if (positionPicked.equals("[DT]") && x.getPosition().equals("DT")){
                lstPickPlayerList.getItems().add(x.getPosition() + " " + x.getFirstName() + " " + x.getLastName());
            }
        }
    }
    private ArrayList<Players>draftProspectsAvailable=new ArrayList<>();
    private boolean playerOn=false;
    public void handleDraftDisplays(Event event) {
        positionPicked="";
        draftProspectsAvailable=new ArrayList<>(draftProspects);
        updateProjectedDraftBoard();
        pick=1;
        round=1;
        lblOnClockPick.setText("Pick: " + pick);
        lblOnClockRound.setText("Round: " + (pick/16+1));
        lblOnClockTeam.setText(allTeams.get(allTeams.size()-pick).getTeamName());
        if (allTeams.get(allTeams.size()-pick)==playersTeam){
            playerOn=true;
        }else{
            playerOn=false;
        }
        draftOn=true;
        draftTime=System.nanoTime();
        lstPickPlayerList.getItems().clear();
        for (Players x: draftProspectsAvailable){
            lstPickPlayerList.getItems().add(x.getPosition() + " " + x.getFirstName() + " " + x.getLastName());
        }
        start();
    }

    public void handleJumpToEnd(ActionEvent actionEvent) {
        week=9;
    }
}