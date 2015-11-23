package com.benjaminshockley;

import java.util.Random;

public class Joke {

    private String mTitle;
    private String mContent;

    public Joke(String title, String content) {
        mTitle = title;
        mContent = content;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getContent() {
        return mContent;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public void setContent(String content) {
        mContent = content;
    }

    public static Joke getRandomJoke() {

        Random random = new Random();
        Joke theJoke;

        int jokeNumber = random.nextInt(10);

        switch (jokeNumber) {
            case 0:
                theJoke = new Joke("Potassium","Want to head a Potassium joke?  K");
                break;
            case 1:
                theJoke = new Joke("Population","A recent worldwide survey showed that out of" +
                        "2,164,794,567 people, 94% were too lazy to actually read the number.");
                break;
            case 2:
                theJoke = new Joke("Engineer","Why was the civil engineer's relationship so unstable? " +
                        "Because there was no truss left!");
                break;
            case 3:
                theJoke = new Joke("Chicken","Why did the chicken cross the playground? " +
                        "To get to the other slide!!");
                break;
            case 4:
                theJoke = new Joke("Tomatoes","If tomatoes are a fruit, isn't ketchup a smoothie?");
                break;
            case 5:
                theJoke = new Joke("Frog","What happens to a frog's car when it breaks down? " +
                        "It get toad away.");
                break;
            case 6:
                theJoke = new Joke("Succeed","If at first you don't succeed, we have much in common.");
                break;
            case 7:
                theJoke = new Joke("Wi-Fi","I put so much more effort naming my first Wi-Fi than " +
                        "my first child.");
                break;
            case 8:
                theJoke = new Joke("Halloween","I don't know if there are real ghosts and goblins, " +
                        "but there are always more trick-or-treaters than neighborhood children.");
                break;
            case 9:
                theJoke = new Joke("Laundry","You know it's time to do laundry when you dry off " +
                        "with a sneaker.");
                break;
            default:
                theJoke = new Joke("Rootbeer","I put rootbeer in a square glass.  Now it's just beer.");
                break;
        }

        return theJoke;
    }

}
