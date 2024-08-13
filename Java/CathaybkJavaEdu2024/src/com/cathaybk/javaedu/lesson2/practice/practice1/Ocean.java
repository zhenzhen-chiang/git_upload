package com.cathaybk.javaedu.lesson2.practice.practice1;

public class Ocean {

    public static void main(String[] args) {
        Swimmer swimPlayer = new SwimPlayer("菲爾普斯");
        Seaplane seaplane = new Seaplane("海空一號");
        Flyer helicopter = new Helicopter("阿帕契");
        doSwim(swimPlayer); // swimPlayer.swim()000
        doSwim(seaplane);// seaplane.swim()
        
        doFly(seaplane);
        doFly(helicopter);
    }

    public static void doSwim(Swimmer a) {
        a.swim();
    }

    public static void doFly(Flyer flyer) {
        flyer.fly();
    }

}
