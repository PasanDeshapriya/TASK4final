package com.example.task4final;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.FileReader;
import java.util.Scanner;

public class HelloController {
    @FXML
    private TextArea ViewText;

    @FXML
    private TextArea SearchResult;

    @FXML
    private TextField search;

    @FXML
    void view(){
        String details="";
        String[] Temparray=new String[30];

        try {
            FileReader load = new FileReader("Data.txt");

            int count=0;
            int data = load.read();
            while (data != -1) {


                ViewText.appendText(String.valueOf((char) data));
                data = load.read();

            }

            load.close();
        }catch(Exception e){

        }
    }

    @FXML
    void find(){

        String[][][] store = new String[5][6][4];
        try{
            FileReader reader = new FileReader("Data.txt");
            Scanner scanner = new Scanner(reader);
            for(int out=0;out<5;out++){
                for (int in=0;in<6;in++){
                    store[out][in][0]=scanner.nextLine();
                    store[out][in][1]=scanner.nextLine();
                    store[out][in][2]=scanner.nextLine();
                    store[out][in][3]=scanner.nextLine();

                }
            }
            reader.close();
            for(int out =0;out< store.length;out++){
                for(int in=0;in<6;in++) {
                    if (store[out][in][0].equals(search.getText())) {
                        SearchResult.appendText(store[out][in][0]+"\n");
                        SearchResult.appendText(store[out][in][1]+"\n");
                        SearchResult.appendText(store[out][in][2]+"\n");
                        SearchResult.appendText(store[out][in][3]+"\n");
                        System.out.println(store[out][in][0]);
                    }
                }

            }

        }catch(Exception e){
            System.out.println("Error!!!");
        }
    }
}