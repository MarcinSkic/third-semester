package com.defaultcompany;

public class TitleSlajd extends Slajd implements Image {

    @Override
    public void Show() {
        System.out.println("To j`est tytul");
    }
    @Override
    public void GenerateImage(){
        System.out.println("Obrazek: witamy");
    }
}
