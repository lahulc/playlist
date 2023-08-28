import service.Song;
import service.User;

import java.util.Scanner;

public class TestRunner{

    public static void main(String[] args){
        Scanner read = new Scanner(System.in);



        User u = new User();
        Song s = new Song();

        boolean flag = true;
        while(flag) {
            System.out.println("\t Menu");
            System.out.println("1. Add a new user");
            System.out.println("2. Add song to playlist For a user");
            System.out.println("3. Play a song for a user");
            System.out.println("4. Display a playlist for a user");
            System.out.println("5. Get All Users");
            System.out.println("6. Exit");
            int n = read.nextInt();

            switch (n) {
                case 1:
                    u.addUser(read);
                    break;
                case 2:
                    s.addSong(read);
                    break;
                case 3:
                    s.playSong(read);
                    break;
                case 4:
                    s.displayPlaylist(read);
                    break;
                case 5:
                    u.getAllUsers(read);
                    break;
                case 6:
                    flag = false;
                    break;

                default:
                    System.out.println("Enter the correct option");
            }
        }
    }
}