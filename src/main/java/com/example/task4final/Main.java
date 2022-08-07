package com.example.task4final;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<String> waitingListFirstName = new ArrayList<String>();
    public static ArrayList<String> waitingListSecondName = new ArrayList<String>();
    public static ArrayList<String> waitingListVehicleNo = new ArrayList<String>();
    public static ArrayList<Integer> waitingListNumOfLiters = new ArrayList<Integer>();

    public static boolean loop = true;

    public static void main(String[] args) {
        FuelQueue queue1 = new FuelQueue();
        FuelQueue queue2 = new FuelQueue();
        FuelQueue queue3 = new FuelQueue();
        FuelQueue queue4 = new FuelQueue();
        FuelQueue queue5 = new FuelQueue();
        FuelQueue[] queue = {queue1, queue2, queue3, queue4, queue5};

        LOOP(queue);
    }

    public static void LOOP(FuelQueue[] queue) {
        menu();
        System.out.println("\n pls choose an option ");
        String choice = scanner.next();
//each options relative  function  is called via a case loop
        switch (valid(choice)) {
            case 0 -> VFQ(queue);
            case 1 -> VEQ(queue);
            case 2 -> ACQ(queue);
            case 3 -> RCQ(queue);
            case 4 -> PCQ(queue);
            case 5 -> VCS(queue);
            case 6 -> SPD(queue);
            case 7 -> LPD(queue);
            case 8 -> STK(queue);
            case 9 -> AFS(queue);
            case 10-> IFQ(queue);
            case 11-> EXT(queue);


//if the user input something other than the given options a message will pop up informing about it
            case 100 -> System.out.println("\nYou have selected a wrong option !\n");
        }
//this is used to exit the loop
        if (loop) {
            //infinite times of repetition unit loop is false (it means when 999 or EXT is entered)
            LOOP(queue);
        } else {
            System.out.println("\nThank you for using this program ");
        }

    }

    public static void menu() {
        System.out.println("---------------MENU--------------\n" +
                "   100 or VFQ: View all Fuel Queues.\n" +
                "   101 or VEQ: View all Empty Queues.\n" +
                "   102 or ACQ: Add customer to a Queue.\n" +
                "   103 or RCQ: Remove a customer from a Queue. (From a specific location)\n" +
                "   104 or PCQ: Remove a served customer.\n" +
                "   105 or VCS: View Customers Sorted in alphabetical order\n" +
                "   106 or SPD: Store Program Data into file. 107 or LPD: Load Program Data from file.\n" +
                "   107 or LPD: Load Program Data from file\n" +
                "   108 or STK: View Remaining Fuel Stock.\n" +
                "   109 or AFS: Add Fuel Stock.\n" +
                "   110 or IFQ: View the income per line in each queue.\n" +
                "   999 or EXT: Exit the Program.\n" +
                "-------------------------------------------");

    }

    public static Integer valid(String choice) {
        String[][] choice1 = {{"100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "999"}, {"VFQ", "VEQ", "ACQ", "RCQ", "PCQ", "VCS", "SPD", "LPD", "STK", "AFS", "IFQ", "EXT"}};
        int num = 100;
        for (int i = 0; i < 12; i++) {
            if ((Objects.equals(choice1[0][i], choice)) || (Objects.equals(choice1[1][i], choice))) {
                //value of i is saved in num, so we can use it later
                System.out.println("you choose " + choice1[0][i] + ", " + choice1[1][i]);
                num = i;
                break;
            }
        }
        return num;
    }


    public static void VFQ(FuelQueue[] queue) {

        int temp = 0;
        for (int out = 0; out < 5; out++) {
            System.out.println("\n--------------------------Queue "+out+"----------------------\n");
            for (int in = 0; in < 6; in++) {
                if (queue[out].passangers[in].getFirstName() == null) {
                    System.out.println(queue[out].passangers[in].getFirstName());
                    System.out.println( queue[out].passangers[in].getSecondName());
                    System.out.println(queue[out].passangers[in].getVehicleNum());
                    System.out.println(queue[out].passangers[in].getNumOfLiters()+ "\n");
                }else {
                    System.out.println(queue[out].passangers[in].getFirstName());
                    System.out.println( queue[out].passangers[in].getSecondName());
                    System.out.println(queue[out].passangers[in].getVehicleNum());
                    System.out.println(queue[out].passangers[in].getNumOfLiters()+ "\n");
                }
            }

        }
    }

    public static void VEQ(FuelQueue[] queue) {
        for (int out = 0; out < 5; out++) {
            System.out.println("\n--------------------------Queue "+out+"----------------------\n");
            for (int in = 0; in < 6; in++) {
                if (queue[out].passangers[in].getFirstName() == null) {
                    System.out.println(queue[out].passangers[in].getFirstName());
                    System.out.println( queue[out].passangers[in].getSecondName());
                    System.out.println(queue[out].passangers[in].getVehicleNum());
                    System.out.println(queue[out].passangers[in].getNumOfLiters()+ "\n");
                }

            }

        }
    }

    public static void ACQ(FuelQueue[] queue) {
        SortLow(queue);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter First name ");
        String FirstName;
        do{
            if(scanner.hasNext()){
                FirstName = scanner.next();
                break;
            }else{
                scanner.next();
            }
        }while(true);

        System.out.println("Enter Second name ");
        String SecondName;
        do{
            if(scanner.hasNext()){
                SecondName = scanner.next();
                break;
            }else{
                scanner.next();
            }
        }while(true);

        System.out.println("Enter Vehicle number ");
        String Vehicle;
        do{
            if(scanner.hasNext()){
                Vehicle = scanner.next();
                break;

            }else{
                scanner.next();

            }
        }while(true);

        System.out.println("Enter Number of liters");
        int liters;
        do{

            String num = scanner.next();
            try
            {
                liters=Integer.parseInt(num);

                break;
            }
            catch (NumberFormatException e)
            {
                scanner.next();
            }
        }while(true);


        if (queue[4].passangers[5].getFirstName() != null) {
            System.out.println("pump is full, adding to waiting list");
            waitingListFirstName.add(FirstName);
            waitingListSecondName.add(SecondName);
            waitingListVehicleNo.add(Vehicle);
            waitingListNumOfLiters.add(liters);

        } else if (count1 == low[0]) {
            for (int i = 0; i < 6; i++) {
                if (queue[0].passangers[i].getFirstName() == null) {
                    queue[0].passangers[i].setFirstName(FirstName);
                    queue[0].passangers[i].setSecondName(SecondName);
                    queue[0].passangers[i].setVehicleNum(Vehicle);
                    queue[0].passangers[i].setNumofLiters(liters);
                    count1++;
                    System.out.println("A customer has been added to Queue 0 ,row " + i);
                    //this is used to store data, so it can be later accessed in VSC view customer in alphabetical order
                    queue2[i][0] =  (queue[0].passangers[i].getFirstName());
                    queue2[i][1] =  (queue[0].passangers[i].getSecondName());
                    queue2[i][2] =  (queue[0].passangers[i].getVehicleNum());
                    queue2[i][3] = String.valueOf((queue[0].passangers[i].getNumOfLiters()));
                    break;
                }
            }
        } else if (count2 == low[0]) {
            for (int i = 0; i < 6; i++) {
                if (queue[1].passangers[i].getFirstName() == null) {
                    assert queue[1].passangers[i] != null;
                    queue[1].passangers[i].setFirstName(FirstName);
                    queue[1].passangers[i].setSecondName(SecondName);
                    queue[1].passangers[i].setVehicleNum(Vehicle);
                    queue[1].passangers[i].setNumofLiters(liters);
                    count2++;
                    System.out.println("A customer has been added to Queue 1 ,row " + i);
                    queue2[i][0] =  (queue[1].passangers[i].getFirstName());
                    queue2[i][1] =  (queue[1].passangers[i].getSecondName());
                    queue2[i][2] =  (queue[1].passangers[i].getVehicleNum());
                    queue2[i][3] = String.valueOf((queue[1].passangers[i].getNumOfLiters()));
                    break;
                }
            }

        } else if (count3 == low[0]) {
            for (int i = 0; i < 6; i++) {
                if (queue[2].passangers[i].getFirstName() == null) {
                    assert queue[2].passangers[i] != null;
                    queue[2].passangers[i].setFirstName(FirstName);
                    queue[2].passangers[i].setSecondName(SecondName);
                    queue[2].passangers[i].setVehicleNum(Vehicle);
                    queue[2].passangers[i].setNumofLiters(liters);
                    count3++;
                    System.out.println("A customer has been added to Queue 2 ,row " + i);
                    queue2[i][0] =  (queue[2].passangers[i].getFirstName());
                    queue2[i][1] =  (queue[2].passangers[i].getSecondName());
                    queue2[i][2] =  (queue[2].passangers[i].getVehicleNum());
                    queue2[i][3] = String.valueOf((queue[2].passangers[i].getNumOfLiters()));
                    break;
                }
            }

        } else if (count4 == low[0]) {
            for (int i = 0; i < 6; i++) {
                if (queue[3].passangers[i].getFirstName() == null) {
                    assert queue[3].passangers[i] != null;
                    queue[3].passangers[i].setFirstName(FirstName);
                    queue[3].passangers[i].setSecondName(SecondName);
                    queue[3].passangers[i].setVehicleNum(Vehicle);
                    queue[3].passangers[i].setNumofLiters(liters);
                    count4++;
                    System.out.println("A customer has been added to Queue 3 ,row " + i);
                    break;
                }
            }

        } else if (count5 == low[0]) {
            for (int i = 0; i < 6; i++) {
                if (queue[4].passangers[i].getFirstName() == null) {
                    assert queue[4].passangers[i] != null;
                    queue[4].passangers[i].setFirstName(FirstName);
                    queue[4].passangers[i].setSecondName(SecondName);
                    queue[4].passangers[i].setVehicleNum(Vehicle);
                    queue[4].passangers[i].setNumofLiters(liters);
                    count5++;
                    System.out.println("A customer has been added to Queue 4 ,row " + i);
                    queue2[i][0] =  (queue[4].passangers[i].getFirstName());
                    queue2[i][1] =  (queue[4].passangers[i].getSecondName());
                    queue2[i][2] =  (queue[4].passangers[i].getVehicleNum());
                    queue2[i][3] = String.valueOf((queue[4].passangers[i].getNumOfLiters()));
                    break;
                }
            }
        }
    }

    public static int count1 = 0;
    public static int count2 = 0;
    public static int count3 = 0;
    public static int count4 = 0;
    public static int count5 = 0;
    public static int low[] = new int[5];

    public static void SortLow(FuelQueue[] queue) {
        int count = 0;
        int temp = 0;
        low[0] = count1;
        low[1] = count2;
        low[2] = count3;
        low[3] = count4;
        low[4] = count5;

        boolean fo = true;
//then bubble sort is done to  arrange the array from the lowest count value to the largest
        while (fo) {
            if (low[0] > low[1]) {
                temp = low[0];
                low[0] = low[1];
                low[1] = temp;
            }
            if (low[1] > low[2]) {
                temp = low[2];
                low[2] = low[1];
                low[1] = temp;
            }
            if (low[2] > low[3]) {
                temp = low[2];
                low[2] = low[3];
                low[3] = temp;
            }
            if (low[3] > low[4]) {
                temp = low[3];
                low[3] = low[4];
                low[4] = temp;
            }
            count++;
            if (25 == count) {
                fo = false;
            }

        }
    }

    public static void RCQ(FuelQueue[] queue) {
        int out = 0;
        int in = 0;
        System.out.println("Pls enter from which row you want to remove(0,1,2,3,4)");
        out = scanner.nextInt();
        System.out.println("pls enter from which column you want to remove(0,1,2,3,4,5)");
        in = scanner.nextInt();
        if (Objects.equals(queue[out].passangers[in].getFirstName(), null)) {
            System.out.println("there is no customer at the given location");
        } else {

            System.out.println("Queue " + out + ",row " + in + " customer has been removed.");
            if(out==0){
                count1-=1;
            }else if(out==1){
                count2-=1;
            }else if(out==2){
                count3-=1;
            }else if(out==3){
                count4-=1;
            }else if(out==4){
                count5-=1;
            }
            queue[out].passangers[in].setFirstName(null);
            queue[out].passangers[in].setSecondName(null);
            queue[out].passangers[in].setVehicleNum(null);
            queue[out].passangers[in].setNumofLiters(0);
            for (int i = in; i < 5; i++) {
                queue[out].passangers[i].setFirstName(queue[out].passangers[i + 1].getFirstName());
                queue[out].passangers[i].setSecondName(queue[out].passangers[i + 1].getSecondName());
                queue[out].passangers[i].setVehicleNum(queue[out].passangers[i + 1].getVehicleNum());
                queue[out].passangers[i].setNumofLiters(queue[out].passangers[i + 1].getNumOfLiters());
            }
            queue[out].passangers[5].setFirstName(null);
            queue[out].passangers[5].setSecondName(null);
            queue[out].passangers[5].setVehicleNum(null);
            queue[out].passangers[5].setNumofLiters(0);
        }
    }
    public static int stock = 6600;
    public static void PCQ(FuelQueue[] queue) {
        int out = 0;
        int in = 0;
        if (stock == 0) {
            System.out.println("NO stocks remaining");
        } else {
            System.out.println("Pls enter from which row you want to remove(0,1,2,3,4)");
            out = scanner.nextInt();

            if (Objects.equals(queue[out].passangers[0].getFirstName(), null)) {
                System.out.println("there is no customer in  Queue " + out);
            } else {
                System.out.println("Queue " + out + ",row " + in + " customer has been removed.");
                if (out == 0) {
                    count1--;
                } else if (out == 1) {
                    count2 -= 1;
                } else if (out == 2) {
                    count3 -= 1;
                } else if (out == 3) {
                    count4 -= 1;
                } else if (out == 4) {
                    count5 -= 1;
                }


                if (out == 0 || out == 1 || out == 2 || out == 3 || out == 4) {
                    stock=stock-queue[out].passangers[0].getNumOfLiters();
                    queue[out].passangers[0].setFirstName(null);
                    queue[out].passangers[0].setSecondName(null);
                    queue[out].passangers[0].setVehicleNum(null);
                    queue[out].passangers[0].setNumofLiters(0);
                    for (int i = 0; i < 5; i++) {
                        queue[out].passangers[i].setFirstName(queue[out].passangers[i + 1].getFirstName());
                        queue[out].passangers[i].setSecondName(queue[out].passangers[i + 1].getSecondName());
                        queue[out].passangers[i].setVehicleNum(queue[out].passangers[i + 1].getVehicleNum());
                        queue[out].passangers[i].setNumofLiters(queue[out].passangers[i + 1].getNumOfLiters());
                    }
                    queue[out].passangers[5].setFirstName(null);
                    queue[out].passangers[5].setSecondName(null);
                    queue[out].passangers[5].setVehicleNum(null);
                    queue[out].passangers[5].setNumofLiters(0);
                }
                if(waitingListFirstName.size()!=0){
                    for(int i=0;i<6;i++) {
                        if (queue[out].passangers[i].getFirstName() == null) {
                            queue[out].passangers[i].setFirstName(waitingListFirstName.get(0));
                            queue[out].passangers[i].setSecondName(waitingListSecondName.get(0));
                            queue[out].passangers[i].setVehicleNum(waitingListVehicleNo.get(0));
                            queue[out].passangers[i].setNumofLiters(waitingListNumOfLiters.get(0));
                            waitingListFirstName.remove(0);
                            waitingListSecondName.remove(0);
                            waitingListVehicleNo.remove(0);
                            waitingListNumOfLiters.remove(0);
                            break;
                        }
                    }
                }




            }
        }
        if(stock<=500){
            System.out.println("Only "+stock+" liters stocks remaining");
        }
    }


    public static String[][] queue1 = new String[6][4];
    public static String[][] queue2 = new String[6][4];
    public static String[][] queue3 = new String[6][4];
    public static String[][] queue4 = new String[6][4];
    public static String[][] queue5 = new String[6][4];

    public static void VCS(FuelQueue[] queue) {
        String[] temp;
        System.out.println("\nQueues_0\n");
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                if(queue1[i][0] == null || queue1[j][0] ==null ) {

                }else{
                    if (Arrays.toString(queue1[i]).compareTo(Arrays.toString(queue1[j])) > 0) {
                        temp = queue1[i];
                        queue1[i] = queue1[j];
                        queue1[j] = temp;
                    }
                }
            }

        }
        for (int i=0; i<6; i++) {
            if(Arrays.toString(queue1[i])!=null) {
                System.out.println(Arrays.toString(queue1[i]));
            }
        }

        System.out.println("\nQueues_1\n");
        for (int i=0; i<6; i++){
            System.out.println(Arrays.toString(queue1[i]));
        }

        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                if(queue2[i][0] == null || queue2[j][0] ==null ) {

                }else{
                    if (Arrays.toString(queue2[i]).compareTo(Arrays.toString(queue2[j])) > 0) {
                        temp = queue2[i];
                        queue2[i] = queue2[j];
                        queue2[j] = temp;
                    }
                }
            }
        }
        for (int i=0; i<6; i++) {
            System.out.println(Arrays.toString(queue2[i]));
        }

        System.out.println("\nQueues_2\n");
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++){
                if(queue3[i][0] == null || queue3[j][0] ==null ) {

                }else{
                    if (Arrays.toString(queue3[i]).compareTo(Arrays.toString(queue3[j])) > 0) {
                        temp = queue3[i];
                        queue3[i] = queue3[j];
                        queue3[j] = temp;
                    }
                }
            }

        }
        for (int i=0; i<6; i++) {
            System.out.println(Arrays.toString(queue3[i]));
        }
        System.out.println("\nQueues_3\n");
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                if(queue4[i][0] == null || queue4[j][0] ==null ) {

                }else{
                    if (Arrays.toString(queue4[i]).compareTo(Arrays.toString(queue4[j])) > 0) {
                        temp = queue4[i];
                        queue4[i] = queue4[j];
                        queue4[j] = temp;
                    }
                }
            }
        }
        for (int i=0; i<6; i++) {
            System.out.println(Arrays.toString(queue4[i]));
        }

        System.out.println("\nQueues_4\n");
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                if(queue5[i][0] == null || queue5[j][0] ==null ) {

                }else{
                    if (Arrays.toString(queue5[i]).compareTo(Arrays.toString(queue5[j])) > 0) {
                        temp = queue5[i];
                        queue5[i] = queue5[j];
                        queue5[j] = temp;
                    }
                }
            }
        }

        for (int i = 0; i < 6; i++) {
            System.out.println(Arrays.toString(queue5[i]));
        }
    }




    public static void SPD(FuelQueue[] queue) {

        System.out.println("Store Program Data into file.");
        int out=0;
        int in=0;
        int size=0;


        try {
            File txt = new File("Data.txt");
            PrintWriter writeFile = new PrintWriter(txt);
            for (int i = 0; i < queue.length; i++) {
                for (int k = 0; k < queue[0].passangers.length; k++) {
                    writeFile .println(queue[i].passangers[k].getFirstName());
                    writeFile .println(queue[i].passangers[k].getSecondName());
                    writeFile .println(queue[i].passangers[k].getVehicleNum());
                    writeFile .println(queue[i].passangers[k].getNumOfLiters());


                }
            }writeFile .close();

        } catch (Exception e) {
            System.out.println("Error!!!");
        }
    }

    public static void LPD(FuelQueue[] queue) {
        System.out.println("Load Program Data from file.");

        try{
            FileReader load = new FileReader("Data.txt");
            int line = load.read();
            while(line != -1){
                System.out.print((char)line);
                line=load.read();
            }
            load.close();
        }catch(Exception e){
            System.out.println("couldn't find a file.");
        }

    }

    public static void STK(FuelQueue[] queue) {
        System.out.println("View Remaining Fuel Stock.");
        System.out.println(stock);
    }

    public static void AFS(FuelQueue[] queue) {
        System.out.println("Add Fuel Stock.");
        System.out.println("Enter the amount of stock to add.");
        int addStock= scanner.nextInt();
        stock+=addStock;

    }

    public static void IFQ(FuelQueue[] queue) {

        for( int out=0;out<5;out++){
            double tot=0;
            for (int in = 0; in < 6; in++) {
                if (queue[out].passangers[in].getNumOfLiters() != 0) {
                    tot+=queue[out].passangers[in].getNumOfLiters() * 430;
                }
            }
            System.out.println("the total income in queue "+out+" is  $"+tot);
        }
    }

    //exits the program
//the loop variable is turned false

    public static void EXT(FuelQueue[] queue) {
        System.out.println("Exit the Program.");
        loop = false;
    }




}
