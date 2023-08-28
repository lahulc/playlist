package service;

import lombok.Data;

import java.util.*;

@Data
public class Song {

    public String name;

    public static HashMap<User, LinkedList<String>> playlist = new HashMap<>();

    public String readUser(Scanner read){
        System.out.println("Enter the user name");
        return read.next();
    }

    public void addSong(Scanner read) {
        User user = User.getUser(readUser(read));
        while(user!=null) {
            System.out.println("Enter the song");
            String s = read.next();
            LinkedList<String> cur = findPlaylistOfUser(user);
            if(cur!=null) {
                cur.add(s);
            }else{
                cur = new LinkedList<>();
                cur.add(s);
            }
            playlist.put(user, cur);
            System.out.println("Do you want add more songs (Y/N)");
            String input = read.next().toLowerCase();
            if(!input.equals("y"))
                break;
        }
    }

    public void playSong(Scanner read) {
        User user = User.getUser(readUser(read));
        if(user!=null) {
            System.out.println("Enter the song");
            String name = read.next();
            LinkedList<String> songs = findPlaylistOfUser(user);
            if(songs!=null && songs.size()>0 && checkIfSongPresentInPlaylist(songs, name)) {
                songs.remove(name);
                songs.add(name);
            }
        }
    }

    public boolean checkIfSongPresentInPlaylist(List<String> playlist, String song){
        for(String s: playlist){
            if(s.equals(song))
                return true;
        }
        return false;
    }

    public LinkedList<String> findPlaylistOfUser(User u){
        for (Map.Entry<User, LinkedList<String>> entry : playlist.entrySet()) {
            User key = entry.getKey();
            if(key.getName().equals(u.getName()))
                return entry.getValue();
        }
        return null;
    }

    public void displayPlaylist(Scanner read){
        User user = User.getUser(readUser(read));
        LinkedList<String> list = findPlaylistOfUser(user);
        if(user!=null) {
            for(int i=0;i<list.size();i++)
                System.out.println((i+1)+". "+list.get(i));
        }else{
            System.out.println("User is null");
        }
    }
}
