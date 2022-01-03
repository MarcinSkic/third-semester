package com.defaultcompany;

public class Prezentacja {
    public void Play(){
        TitleSlajd titleSlajd = new TitleSlajd();
        titleSlajd.Show();
        titleSlajd.GenerateImage();

        GlownySlajd glownySlajd = new GlownySlajd();
        glownySlajd.Show();
        glownySlajd.GetScore();
        glownySlajd.ShowScore();
        glownySlajd.PlayVideo();
    }
}
