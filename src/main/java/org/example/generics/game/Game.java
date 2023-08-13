package org.example.generics.game;

public class Game {

    public static void main(String[] args) {

        /**
         * В данной игре демонстрируется использование Generics, для того
         * чтобы реализовать типобезопасность - компилятор выдаст ошибку,
         * если будет попытка добавить в команду школьников с типом Schooler
         * игрока-студента типа Student. А также будет ошибка , если команда школьников
         * попытается сыграть с командой студентов.
         */

        Schooler schooler1 = new Schooler("Nikolas");
        Schooler schooler2 = new Schooler("Andrey");
        Schooler schooler3 = new Schooler("Tom");
        Schooler schooler4 = new Schooler("Bobby");

        Team <Schooler> schoolTeam = new Team("SchoolTeam");
        Team <Schooler> schoolTeam2 = new Team("SchoolTeam2");
        schoolTeam.addParticipant(schooler1);
        schoolTeam.addParticipant(schooler2);
        schoolTeam2.addParticipant(schooler3);
        schoolTeam2.addParticipant(schooler4);

        schoolTeam.teamPlayWith(schoolTeam2);

        Student student1 = new Student("Bill");
        Student student2 = new Student("Lue");
        Team <Student> studentTeam1 = new Team("StudentTeam1");
        Team <Student> studentTeam2 = new Team("StudentTeam2");
        studentTeam1.addParticipant(student1);
        studentTeam2.addParticipant(student2);


    }
}
