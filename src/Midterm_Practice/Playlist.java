package Midterm_Practice;

import java.util.*;

public class Playlist {

    // Circular linked list
    LinkedList<Song> playlist;
    ListIterator<Song> itr;
    boolean repeatPlaylist;
    boolean repeatSong;
    Song lastPlayedSong;
    String playlistName;
    int index;

    public Playlist(String name) {
        playlist = new LinkedList<>();
        itr = playlist.listIterator();
        repeatPlaylist = false;
        repeatSong = false;
        lastPlayedSong = null;
        playlistName = name;
        index = 0;
    }

    // play last selected (returned) song
        // get current song
    public Song getNextSong() {
        itr = playlist.listIterator(index);

        // If at the end of the playlist
        if (!itr.hasNext()) {
            index = 0;
            // If should repeat, then set iterator to
            // beginning of playlist
            if (repeatPlaylist) {
                itr = playlist.listIterator(index);
            } // else return null
            else {
                return null;
            }
          // If there is a next song and we want to
          // repeat, then play the lastPlayedSong
        } else if (repeatSong) {
            return lastPlayedSong;
        }
        // Get and return next song in playlist
        lastPlayedSong = itr.next();
        index++;
        return lastPlayedSong;
    }

    // Overwrite the last playing (returned) song
        // replace last retrieved song
    public boolean overwriteLastSong(Song s) {

        try {
            itr.set(s);
            System.out.println("Song successfully replaced");
            lastPlayedSong = null;
            return true;
        } catch (IllegalStateException e) {
            System.out.println("Cannot overwrite a song before selecting a song");
            return false;
        }
    }

    public boolean hasNextSong() {
        return itr.hasNext();
    }

    // Include a set of selected songs to the playlist
    public void bulkAddSongs(Playlist p) {
        ListIterator<Song> otherItr = p.getListIterator();
        while (otherItr.hasNext()) {
            playlist.add(new Song(otherItr.next()));
        }
    }

    // add a song
    public void addSong(Song s) {
        ListIterator<Song> tempItr = playlist.listIterator(playlist.size());
        tempItr.add(s);
    }

    // remove a set of songs
    public boolean bulkRemoveSongs(Playlist p) {
        ListIterator<Song> otherItr = p.getListIterator();
        boolean allPresent = true;
        boolean temp;
        while (otherItr.hasNext()) {
            temp = playlist.remove(otherItr.next());
            if (!temp) {
                allPresent = false;
            }
        }

        return allPresent;
    }

    // remove a song
    public boolean removeSong(Song s) {
        return playlist.remove(s);
    }

    // shuffle
        // shuffle list
    public void myShuffle() {
        ArrayList<Song> tempArr = new ArrayList<>();
        int front = 0, back = 0;
        ListIterator<Song> tempItr = playlist.listIterator();

        while (tempItr.hasNext()) {
            tempArr.add(tempItr.next());
        }
        back = tempArr.size() - 1;
        Playlist tempPlaylist = new Playlist("temp");

        double randomNum;

        while (front <= back) {

            randomNum = Math.random();

            if (randomNum < 0.5) {
                tempPlaylist.addSong(tempArr.get(front));
                front++;
            } else {
                tempPlaylist.addSong(tempArr.get(back));
                back--;
            }
        }

        playlist.clear();
        playlist.addAll(tempPlaylist.playlist);
        System.out.println(tempArr);
    }

    // loop last played song
        // toggle boolean for repeat current song
    public void toggleLoopLastPlayedSong() {
        repeatSong = !repeatSong;
    }

    // loop all songs
    public void toggleLoopPlaylist() {
        repeatPlaylist = !repeatPlaylist;
    }

    // loop selected song
    public Song loopSelectedSong(Song s) {
        int songIndex = playlist.indexOf(s);

        if (songIndex == -1) {
            throw new NoSuchElementException("Song does not exist in playlist");
        }

        itr = playlist.listIterator(songIndex);
        repeatSong = true;
        return itr.next();
    }

    public ListIterator<Song> getListIterator() {
        return playlist.listIterator();
    }

    public int length() {
        return playlist.size();
    }

    @Override
    public String toString() {
        return playlistName + "{" +
                "playlist=" + playlist +
                ", repeatPlaylist=" + repeatPlaylist +
                ", repeatSong=" + repeatSong +
                ", lastPlayedSong=" + lastPlayedSong +
                '}';
    }
}
