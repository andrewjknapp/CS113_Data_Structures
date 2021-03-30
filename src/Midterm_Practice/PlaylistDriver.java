package Midterm_Practice;

public class PlaylistDriver {
    public static void main(String[] args) {
        Song hello = new Song("Hello");
        Playlist playlist = new Playlist("Playlist1");

        System.out.println("Add song 'Hello' and 'Let it Be' to playlist");
        playlist.addSong(new Song("Let it Be"));
        playlist.addSong(hello);
        System.out.println(playlist + "\n");

        System.out.println("Remove song Hello from playlist");
        playlist.removeSong(new Song("Let it Be"));
        System.out.println(playlist + "\n");


        System.out.println("Build second playlist");
        Playlist playlist2 = new Playlist("Playlist2");
        playlist2.addSong(new Song("The Outside"));
        playlist2.addSong(new Song("Little Bird"));
        playlist2.addSong(new Song("Hysteria"));
        System.out.println(playlist2 + "\n");

        System.out.println("Bulk add contents of Playlist2 to first playlist");
        playlist.bulkAddSongs(playlist2);
        System.out.println(playlist + "\n");

        playlist.myShuffle();
        System.out.println("Shuffle");
        System.out.println(playlist + "\n");

//        playlist.loopSelectedSong(hello);
//        System.out.println(playlist);

//        System.out.println("Get next song to play");
//        System.out.println(playlist.getNextSong() + "\n");
//        playlist.overwriteLastSong(new Song("Build it all"));
//        System.out.println(playlist);
//
//        playlist.bulkRemoveSongs(playlist2);
//        System.out.println(playlist);
    }
}
