import java.util.Arrays;

public class Problem2_Playlist {
    static class Playlist {
        private final String[] songs;
        private int count;

        Playlist(int maxSize) { songs = new String[maxSize]; }

        void addSong(String song) {
            if (count < songs.length) songs[count++] = song;
        }

        String[] getSongs() { return Arrays.copyOf(songs, count); }
        int getSongCount() { return count; }
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A"); p.addSong("Song B");
        String[] copy = p.getSongs();
        copy[0] = "Hacked";
        System.out.println("First song: " + p.getSongs()[0]);
        System.out.println("Song count: " + p.getSongCount());
    }
}