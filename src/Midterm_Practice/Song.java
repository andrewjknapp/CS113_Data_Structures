package Midterm_Practice;

import java.util.Objects;

public class Song {
    private String mtitle;

    public Song(String mtitle) {
        this.mtitle = mtitle;
    }

    public Song(Song s) {
        mtitle = s.mtitle;
    }

    public String getMtitle() {
        return mtitle;
    }

    public void setMtitle(String mtitle) {
        this.mtitle = mtitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(mtitle, song.mtitle);
    }

    @Override
    public String toString() {
        return mtitle;
    }
}
