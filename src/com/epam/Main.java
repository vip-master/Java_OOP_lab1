package com.epam;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    enum Action {ADD, GIVE, DEL, SORT, TRANSP, GIVEALL, END}

    public static void main(String[] args) {

        ArrayList<Stone> necklace = new ArrayList<Stone>();

        /*for(int i=0;i<10;i++) necklace.add(Randomizator());

        System.out.println("Sum of weight:");
        System.out.println(sumWeight(necklace));
        System.out.println("Sum of Cost");
        System.out.println(sumCost(necklace));

        giveTr(necklace,3,7);
        System.out.println();

        viewWorth(necklace);
        necklace.sort(new StoneComparator());
        System.out.println();
        viewWorth(necklace);*/

        running(necklace);


    }

    private static Stone Randomizator() {
        int typyzator = (int) (Math.random() * 4);

        switch (typyzator) {
            case 0:
                return new Briliant((float) Math.random() * 1000 + 1, (float) Math.random() * 50 + 1, (int) (Math.random() * 10));
            case 1:
                return new Sapphire((float) Math.random() * 1000 + 1, (float) Math.random() * 50 + 1, (int) (Math.random() * 10));
            case 2:
                return new Emerald((float) Math.random() * 1000 + 1, (float) Math.random() * 50 + 1, (int) (Math.random() * 10));
            case 3:
                return new Ruby((float) Math.random() * 1000 + 1, (float) Math.random() * 50 + 1, (int) (Math.random() * 10));
            default:
                throw new IllegalStateException();
        }
    }

    private static Float sumCost(ArrayList<Stone> array) {
        float result = 0;
        for (Stone stone : array) result += stone.getCost();
        return result;
    }

    private static Float sumWeight(ArrayList<Stone> array) {
        float result = 0;
        for (Stone stone : array) result += stone.getWeight();
        return result;
    }

    private static void giveTr(ArrayList<Stone> array, int min, int max) {
        if (min > max) throw new IllegalArgumentException();
        for (Stone stone : array)
            if (stone.isOk(min, max)) {
                stone.name();
                System.out.println("my transparency=" + stone.getTransparency());
            }
    }

    private static void viewWorth(ArrayList<Stone> array) {
        for (Stone stone : array) {
            stone.name();
            System.out.println("my price=" + stone.getWorth());
        }
    }

    private static void running(ArrayList<Stone> array) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Action action = Action.valueOf(scanner.next());
            int index, index1;

            switch (action) {
                case ADD:
                    array.add(Randomizator());
                    System.out.println("NEXT COMM");
                    break;
                case GIVE:
                    try {
                        index = scanner.nextInt();
                        array.get(index).name();
                        System.out.println("Transparency: " + array.get(index).getTransparency());
                        System.out.println("Weight: " + array.get(index).getWeight());
                        System.out.println("Price per karate: " + array.get(index).getWorth());
                        System.out.println("COst: " + array.get(index).getCost());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("NEXT COMM");
                    break;
                case DEL:
                    index = scanner.nextInt();
                    array.remove(index);
                    System.out.println("NEXT COMM");
                    break;
                case SORT:
                    viewWorth(array);
                    array.sort(new StoneComparator());
                    System.out.println();
                    viewWorth(array);
                    System.out.println("NEXT COMM");
                    break;
                case TRANSP:
                    index = scanner.nextInt();
                    index1 = scanner.nextInt();
                    giveTr(array, index, index1);
                    System.out.println();
                    System.out.println("NEXT COMM");
                    break;
                case END:
                    System.out.println("goodbuy");
                    break;
                case GIVEALL:
                    viewWorth(array);
                    System.out.println("NEXT COMM");
                    break;

                default:
                    System.out.println("illegal command");
            }

            if (action == Action.END) break;
        }


    }
}