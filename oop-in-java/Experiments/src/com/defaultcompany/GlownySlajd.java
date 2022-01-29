package com.defaultcompany;

import java.util.Scanner;

public class GlownySlajd extends Slajd implements Video,Survey{
    int score;

    @Override
    public void Show() {
        super.Show();
        System.out.println("Slajdzik glowny");
    }

    @Override
    public void ShowScore() {
        System.out.println(score);
    }

    @Override
    public void GetScore() {

        System.out.println("Podaj wynik ankiety: ");
        Scanner read = new Scanner(System.in);
        score = read.nextInt();
    }

    @Override
    public void PlayVideo() {
        System.out.println("Haha video");
    }
}
