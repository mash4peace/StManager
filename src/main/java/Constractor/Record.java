package Constractor;

import java.util.Date;

/**
 * Created by mash4 on 5/2/2017.
 */
public class Record {
    String name;
    int numberOFitems;
    String artist;
    String title ;
    double salePrx;
    int consgrID;

    static int consgrIDCounter = 1;
    static int saleIDCount = 1;
    int saleID;

    public String getTodaysDate() {
        return todaysDate;
    }
//I am using all these variables in the file
    String todaysDate;
    String stringconsID;
    String stringitem;
    String stringartists;
    String stringtitles;
    String stringsalexPrx;
    String stringtodayDate;



    Date date = new Date();
    //SimpleDateFormat  smDate = new SimpleDateFormat(date);


    public String getName() {
        return name;
    }

    public int getNumberOFitems() {
        return numberOFitems;
    }

    public Date getDate() {
        return date;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public double getSalePrx() {
        return salePrx;
    }

    public int getConsgrID() {
        return consgrID;
    }

    public Record(String name, String consgrID, String items, String artist, String title, String  salePrx, String todaysDate){
        this.stringartists = artist;
        this.stringconsID = consgrID;
        this.stringitem = items;
        this.name = name;
        this.stringtitles = title;
        this.stringtodayDate = todaysDate;
        this.stringtitles = title;


    }


    public int getSaleID() {
        return saleID;
    }

    public Record(String name, int numberOFitems, String artist, String title, double salePrx, Date date) {

        this.name = name;
        this.consgrID = consgrIDCounter;

        consgrIDCounter ++;
        this.numberOFitems = numberOFitems;
        this.artist = artist;
        this.title = title;
        this.salePrx = salePrx;
        this.date = date;
    }
    public Record(String name, int id, int saleID, int numberOFitems, String artist, String title, double salePrx, Date date) {

        this.name = name;
        this.consgrID = id;
        this.numberOFitems = numberOFitems;
        this.artist = artist;
        this.title = title;
        this.salePrx = salePrx;
        this.date = date;
        this.saleID = saleIDCount;
        saleIDCount ++;

    }

    @Override
    public String toString() {

        return "Record{" +
                "name='" + name + '\'' +
                ",consgrID=" + consgrID +
                ",numberOFitems=" + numberOFitems +
                ",artist='" + artist + '\'' +
                ",title=' " + title + '\'' +
                ",salePrx=" + salePrx +
                ", date= " + date +
                '}';
    }





}
