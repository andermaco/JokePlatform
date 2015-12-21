package com.jokeplatform;

import java.util.Random;

public class Joke {
    private String[] mMyJokes = {
            "What is the longest word in the English language? SMILES:there is a mile between the " +
                    "first and last letters!",
            "Teacher: Maria please point to America on the map.\n" +
                    "Maria: This is it.\n" +
                    "Teacher: Well done. Now class, who found America?\n" +
                    "Class: Maria did. ",
            "A: Aren't you wearing your wedding ring on the wrong finger?\n" +
                    "B: Yes I am, I married the wrong woman. ",
            "A: Did you hear that a baby was fed on elephant's milk and gained twenty pounds in a " +
                    "week. " +
                    "B: That's impossible. Whose baby? "+
                    "A: An elephant's.",
            "Am I the first man you have ever loved? (he said)." +
                    "Of course, (she answered) Why do men always ask the same question?",
            "When I was young I didn't like going to weddings." +
                    "My grandmother would tell me, You're next. However, she stopped doing that after " +
                    "I started saying the same thing to her at funerals. "
    };

    public String getJoke() {
        return mMyJokes[new Random().nextInt(mMyJokes.length)];
    }

}
