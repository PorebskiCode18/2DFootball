package com.example.generaltemplate;

import javafx.scene.chart.Chart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Teams {
    private String teamName;
    private ArrayList<Players> roster = new ArrayList<>();
    private ArrayList<Players> DTchart = new ArrayList<>();
    private ArrayList<Players> LBchart = new ArrayList();
    private ArrayList<Players> CBchart = new ArrayList<>();
    private ArrayList<Players> SSchart=new ArrayList<>();
    private ArrayList<Players> OLchart= new ArrayList<>();
    private ArrayList<Players> QBchart = new ArrayList<>();
    private ArrayList<Players> WRchart = new ArrayList<>();
    private ArrayList<Players> TEchart = new ArrayList<>();
    private ArrayList<Players> RBchart = new ArrayList<>();
    private ArrayList<Teams> yearSchedule = new ArrayList<>();
    private ArrayList<Players> startingRoster = new ArrayList<>();
    private int teamOverallRating;
    private int startRosterRating;
    private int defensiveRating;
    private int offensiveRating;
    private int dbRating;
    private int recieverQBRating;
    private int dtRating;
    private int olRating;
    private int wins=0;
    private int loses=0;
    private int winStreak=0;
    private int lossStreak=0;
    private int ties=0;
    private int cpuTeamScores;
    private boolean gameCalculated;
    //QB,RB,TE,WR,OL,DT,CB,S,LB;
    private int[] draftNeeds={0,0,0,0,0,0,0,0,0};

    public Teams(String teamName,ArrayList<Players> rst){
        roster=rst;
        this.teamName=teamName;
        for (Players x:roster){
            if (x.getPosition().equals("DT")){
                DTchart.add(x);
            }else if (x.getPosition().equals("LB")){
                LBchart.add(x);
            }else if (x.getPosition().equals("CB")){
                CBchart.add(x);
            }else if (x.getPosition().equals("S")){
                SSchart.add(x);
            }else if (x.getPosition().equals("OL")){
                OLchart.add(x);
            } else if (x.getPosition().equals("QB")){
                QBchart.add(x);
            }else if (x.getPosition().equals("WR")){
                WRchart.add(x);
            }else if (x.getPosition().equals("TE")){
                TEchart.add(x);
            }else if (x.getPosition().equals("RB")){
                RBchart.add(x);
            }
        }
        sortTeamDepthChart();
        findOverall();
    }
    public void sortTeamDepthChart(){
        sortListByOverall(DTchart);
        sortListByOverall(LBchart);
        sortListByOverall(CBchart);
        sortListByOverall(SSchart);
        sortListByOverall(OLchart);
        sortListByOverall(QBchart);
        sortListByOverall(WRchart);
        sortListByOverall(TEchart);
        sortListByOverall(RBchart);
        sortListByOverall(roster);
    }
    public void sortListByOverall(ArrayList<Players> chart){
        for (int i=0;i<chart.size();i++){
            for (int j=0;j<chart.size();j++){
                if (chart.get(i).getOverallRating()>chart.get(j).getOverallRating()){
                    Players temp = chart.get(i);
                    chart.set(i,chart.get(j));
                    chart.set(j,temp);
                }
            }
        }
    }
    public void findOverall(){
        offensiveRating=0;
        defensiveRating=0;
        teamOverallRating=0;
        olRating=0;
        recieverQBRating=0;
        dbRating=0;
        dtRating=0;
        startingRoster.clear();
        for (Players x:roster){
            teamOverallRating+=x.getOverallRating();
        }
        for (int i=0;i<5;i++){
            startingRoster.add(OLchart.get(i));
            offensiveRating+=OLchart.get(i).getOverallRating();
            olRating+=OLchart.get(i).getOverallRating();
        }
        for (int i=0;i<4;i++){
            startingRoster.add(DTchart.get(i));
            defensiveRating+=DTchart.get(i).getOverallRating();
            dtRating+=DTchart.get(i).getOverallRating();
        }
        for (int i=0;i<3;i++){
            startingRoster.add(CBchart.get(i));
            startingRoster.add(WRchart.get(i));
            defensiveRating+=CBchart.get(i).getOverallRating();
            offensiveRating+=WRchart.get(i).getOverallRating();
            recieverQBRating+=WRchart.get(i).getOverallRating();
            dbRating+=CBchart.get(i).getOverallRating();
        }
        for (int i=0;i<2;i++){
            startingRoster.add(LBchart.get(i));
            startingRoster.add(SSchart.get(i));
            defensiveRating+=LBchart.get(i).getOverallRating();
            defensiveRating+=SSchart.get(i).getOverallRating();
            dbRating+=SSchart.get(i).getOverallRating();
            dbRating+=LBchart.get(i).getOverallRating();
        }
        startingRoster.add(QBchart.get(0));
        startingRoster.add(TEchart.get(0));
        startingRoster.add(RBchart.get(0));
        offensiveRating+=QBchart.get(0).getOverallRating();
        offensiveRating+=TEchart.get(0).getOverallRating();
        offensiveRating+=RBchart.get(0).getOverallRating();
        recieverQBRating+=QBchart.get(0).getOverallRating();
        recieverQBRating+=TEchart.get(0).getOverallRating();
        recieverQBRating+=RBchart.get(0).getOverallRating();
        recieverQBRating/=6;
        dbRating/=7;
        olRating/=5;;
        dtRating/=4;
        defensiveRating/=11;
        offensiveRating/=11;
        teamOverallRating/=34;
        startRosterRating=(offensiveRating+defensiveRating)/2;
    }

    public int getTeamOverallRating() {
        return teamOverallRating;
    }

    public int getDefensiveRating() {
        return defensiveRating;
    }

    public int getStartRosterRating() {
        return startRosterRating;
    }

    public int getOffensiveRating() {
        return offensiveRating;
    }

    public String getTeamName() {
        return teamName;
    }
    public void addTeamToSchedule(Teams tm){
        yearSchedule.add(tm);
    }

    public ArrayList<Teams> getYearSchedule() {
        return yearSchedule;
    }

    public int getLoses() {
        return loses;
    }

    public int getWins() {
        return wins;
    }

    public int getTies() {
        return ties;
    }

    public ArrayList<Players> getCBchart() {
        return CBchart;
    }

    public ArrayList<Players> getDTchart() {
        return DTchart;
    }

    public ArrayList<Players> getLBchart() {
        return LBchart;
    }

    public ArrayList<Players> getOLchart() {
        return OLchart;
    }

    public ArrayList<Players> getQBchart() {
        return QBchart;
    }

    public ArrayList<Players> getRBchart() {
        return RBchart;
    }

    public ArrayList<Players> getSSchart() {
        return SSchart;
    }

    public ArrayList<Players> getRoster() {
        return roster;
    }

    public ArrayList<Players> getTEchart() {
        return TEchart;
    }

    public ArrayList<Players> getWRchart() {
        return WRchart;
    }

    public int getLossStreak() {
        return lossStreak;
    }

    public int getWinStreak() {
        return winStreak;
    }

    public int getDbRating() {
        return dbRating;
    }

    public int getDtRating() {
        return dtRating;
    }

    public int getOlRating() {
        return olRating;
    }

    public int getRecieverQBRating() {
        return recieverQBRating;
    }
    public void incWins(){
        wins++;
        winStreak++;
        lossStreak=0;
    }
    public void incLoses(){
        loses++;
        winStreak=0;
        lossStreak++;
    }
    public void incTies(){
        ties++;
        winStreak=0;
        lossStreak=0;
    }

    public int getCpuTeamScores() {
        return cpuTeamScores;
    }

    public void setCpuTeamScores(int cpuTeamScores) {
        this.cpuTeamScores = cpuTeamScores;
    }

    public boolean isGameCalculated() {
        return gameCalculated;
    }

    public void setGameCalculated(boolean gameCalculated) {
        this.gameCalculated = gameCalculated;
    }

    public ArrayList<Players> getStartingRoster() {
        return startingRoster;
    }
    public int getChartAverageRating(ArrayList<Players> chart){
        int temp=0;
        for (Players x: chart){
            temp+=x.getOverallRating();
        }
        temp/=chart.size();
        return temp;
    }
    private String[] positionOrder={"QB","RB","TE","WR","OL","DT","CB","S","LB"};
    //QB,RB,TE,WR,OL,DT,CB,S,LB;
    public void calculateDraftNeeds(int[] prospectRatings){
        positionOrder= new String[]{"QB", "RB", "TE", "WR", "OL", "DT", "CB", "S", "LB"};
        int qbRating=getChartAverageRating(QBchart);
        int rbRating=getChartAverageRating(RBchart);
        int teRating=getChartAverageRating(TEchart);
        int wrRating=getChartAverageRating(WRchart);
        int olRating=getChartAverageRating(OLchart);
        int dtRating=getChartAverageRating(DTchart);
        int cbRating=getChartAverageRating(CBchart);
        int ssRating=getChartAverageRating(SSchart);
        int lbRating=getChartAverageRating(LBchart);
        draftNeeds[0]=qbRating-(QBchart.size()-2)*20+prospectRatings[0];
        draftNeeds[1]=rbRating-(RBchart.size()-2)*20+prospectRatings[1];
        draftNeeds[2]=teRating-(TEchart.size()-2)*20+prospectRatings[2];
        draftNeeds[3]=wrRating-(WRchart.size()-4)*20+prospectRatings[3];
        draftNeeds[4]=olRating-(OLchart.size()-7)*20+prospectRatings[4];
        draftNeeds[5]=dtRating-(DTchart.size()-6)*20+prospectRatings[5];
        draftNeeds[6]=cbRating-(CBchart.size()-4)*20+prospectRatings[6];
        draftNeeds[7]=ssRating-(SSchart.size()-3)*20+prospectRatings[7];
        draftNeeds[8]=lbRating-(LBchart.size()-4)*20+prospectRatings[8];
        for (int i=0;i<draftNeeds.length;i++){
            for (int j=0;j<draftNeeds.length;j++){
                if (i<j && draftNeeds[i]>draftNeeds[j]){
                    int temp = draftNeeds[i];
                    draftNeeds[i]=draftNeeds[j];
                    draftNeeds[j]=temp;
                    String temp2=positionOrder[i];
                    positionOrder[i]=positionOrder[j];
                    positionOrder[j]=temp2;
                }
            }
        }
    }

    public int[] getDraftNeeds() {
        return draftNeeds;
    }

    public String[] getPositionOrder() {
        return positionOrder;
    }
    public void addToRoster(Players player){
        roster.add(player);
        redoRoster();
    }
    public void redoRoster(){
        DTchart.clear();
        LBchart.clear();
        CBchart.clear();
        SSchart.clear();
        OLchart.clear();
        QBchart.clear();
        WRchart.clear();
        TEchart.clear();
        RBchart.clear();
        for (Players x:roster){
            if (x.getPosition().equals("DT")){
                DTchart.add(x);
            }else if (x.getPosition().equals("LB")){
                LBchart.add(x);
            }else if (x.getPosition().equals("CB")){
                CBchart.add(x);
            }else if (x.getPosition().equals("S")){
                SSchart.add(x);
            }else if (x.getPosition().equals("OL")){
                OLchart.add(x);
            } else if (x.getPosition().equals("QB")){
                QBchart.add(x);
            }else if (x.getPosition().equals("WR")){
                WRchart.add(x);
            }else if (x.getPosition().equals("TE")){
                TEchart.add(x);
            }else if (x.getPosition().equals("RB")){
                RBchart.add(x);
            }
        }
        sortTeamDepthChart();
        findOverall();
    }
    public void clearSchedule(){
        yearSchedule.clear();
    }
    public void resetStandings(){
        wins=0;
        ties=0;
        loses=0;
    }
}
