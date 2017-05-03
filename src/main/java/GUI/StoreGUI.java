package GUI;

import Constractor.FileIO;
import Constractor.Record;
import Controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.LinkedList;

/**
 * Created by mash4 on 5/2/2017.
 */
public class StoreGUI extends JFrame {
    private JPanel rootPanel;
    private JTextField consgrNAmetextField;
    private JTextField itemstextField;
    private JTextField artisttextFied1;
    private JTextField titletextField;
    private JTextField salePrxtextField;
    private JList <Record> consignmentlist;
    private JList<Record>soldlist;
    private JButton addConsignmentButton;
    private JButton saleItemButton;
    private JLabel datetxtField;
    private JButton displayDateButton;
    private JButton quitAndSaveButton;
    private JButton consignorRecordsButton;

    static DefaultListModel<Record> allconsgnmntListModel;
    static DefaultListModel<Record>allSoldItemsModel;
    protected static LinkedList<Record> consgnmtQue = FileIO.getRecords();



    private Controller ctrl;



    public StoreGUI(Controller controller){
        this.ctrl = controller;
        //ArrayList<Record> allConsgnmtRecords = new ArrayList<>();
        allconsgnmntListModel = new DefaultListModel<>();
        consignmentlist.setModel(allconsgnmntListModel);
        allSoldItemsModel = new DefaultListModel<>();
        soldlist.setModel(allSoldItemsModel);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(rootPanel);
        pack();
        setVisible(true);
        //allconsgnmntListModel = new DefaultListModel<>();
       // consignmentlist.setModel(allconsgnmntListModel);






        addConsignmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = consgrNAmetextField.getText();
                if(name.isEmpty()){
                    JOptionPane.showMessageDialog(StoreGUI.this, "Please, enter consignor name!!");
                    return;
                }
                int items ;
                try{
                    items = Integer.parseInt(itemstextField.getText());
                }catch (NumberFormatException nfe){
                    JOptionPane.showMessageDialog(StoreGUI.this, "Please enter number of items !!");
                    return;
                }
                String artist = artisttextFied1.getText();
                if(artist.isEmpty()){
                    JOptionPane.showMessageDialog(StoreGUI.this, "Please enter artist name ");
                    return;
                }
                String title = titletextField.getText();
                if(title.isEmpty()){
                    JOptionPane.showMessageDialog(StoreGUI.this, "Please enter song's title ");
                    return;
                }
                double salePrx;
                try{
                    salePrx = Double.parseDouble(salePrxtextField.getText());

                }catch (NumberFormatException nfe){
                    JOptionPane.showMessageDialog(StoreGUI.this, "Enter  sale's price ");
                    return;
                }

                Date date = new Date();


                Record r = new Record(name, items, artist, title, salePrx, date);

                allconsgnmntListModel.addElement(r);
                consgnmtQue.add(r);

                /*


                }

                 */

            }
        });
        saleItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(consignmentlist.isSelectionEmpty()){
                    JOptionPane.showMessageDialog(StoreGUI.this, "Please select an item to sale ");
                    return;
                }
                else{
                    Record r = (Record) consignmentlist.getSelectedValue();
                    int id = r.getConsgrID();
                    String name = r.getName();
                    int item = r.getNumberOFitems();
                    int saleID = r.getSaleID();
                    String artist = r.getArtist();
                    String title = r.getTitle();
                    double sale = r.getSalePrx();
                    Date date = r.getDate();

                    Record record = new Record(name,id, saleID, item, artist, title, sale, date);
                    allSoldItemsModel.addElement(record);
                    //consgnmtQue.add(record);
                    allconsgnmntListModel.removeElement(r);



                }
            }
        });
        displayDateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Record r = (Record) consignmentlist.getSelectedValue();
                if(consignmentlist.isSelectionEmpty()){
                    /*

                     */
                    JOptionPane.showMessageDialog(StoreGUI.this, "Please select a record !!");



                }
                else {

                    Date date = r.getDate();

                    datetxtField.setText(date.toString());

                }


            }
        });
        quitAndSaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(StoreGUI.this,
                        "Are you sure you want to save and exit ",
                        "Exit?", JOptionPane.OK_CANCEL_OPTION)){
                    FileIO.saveRecords(consgnmtQue);
                    System.exit(-0);
                }
            }
        });
    }



}
