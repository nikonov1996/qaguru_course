package org.example.generics.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Team<T extends Participant> {

    public String getTitle() {
        return title;
    }

    private String title;

    public Team(String title) {
        this.title = title;
    }

    List<T> participants = new ArrayList<>();

    public void addParticipant(T participant) {
        participants.add(participant);
        System.out.println(
                "Added participant: "
                        + participant.getName()
                        + " in team \""
                        + this.getTitle()
        );
    }

    public void teamPlayWith(Team<T> team) {
        String winner = (new Random().nextInt(2) == 0) ? this.getTitle() : team.getTitle();
        System.out.println("Team \"" + winner + "\" wins!!!");
    }

}
