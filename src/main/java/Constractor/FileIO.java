package Constractor;

import java.io.*;
import java.util.LinkedList;

/**
 * Created by mash4 on 5/2/2017.
 */
public class FileIO {
    static LinkedList<Record> getDAte = new LinkedList<>();
    private static String fileName = "StoreRecords.Text";

    private static String seperator = ",";

    public static LinkedList<Record> getRecords() {
        LinkedList<Record> allrecords= new LinkedList<>();
        try(BufferedReader reader = new  BufferedReader(new FileReader(fileName)) ){
            String recordData = reader.readLine();
            while ( recordData != null){
                Record r = parseRecordData(recordData);
                allrecords.add(r);
                recordData = reader.readLine();

            }
            reader.close();
            return allrecords;



        } catch (IOException io){
            System.out.println("Error reading file");
            return new LinkedList<>();
        }
    }

    private static Record parseRecordData(String recordData) {
        String [] records = recordData.split(seperator);
        if(records.length == 0){
            return null;
        }
        else{
            String name = records[0];
            String id = records[1];
            String  item = (records[2]);
            String artist = records[3];
            String title = records[4];
            String  salePrx =( records[5]);
            String stringDate = records[6];
            //long temdate = Long.parseLong(stringDate);
            String date = stringDate;

           // int consgrID = Integer.parseInt(id);
           // int items = Integer.parseInt(item);
            //double salePrice = Double.parseDouble(salePrx);


            Record r = new Record(name, id, item, artist, title, salePrx, date);
            return r;




        }
        //return t;
    }

    public static void saveRecords(LinkedList<Record> consgnmtQue) {
        try (BufferedWriter writer = new BufferedWriter
                (new FileWriter(fileName, true))){
            for(Record r : consgnmtQue){
                writer.append(String.valueOf(r ));
                writer.write("\n");


            }
            writer.close();

        }catch (IOException io){
            System.out.println("Error writing data ");
        }
    }
}
