/*
 * 40.Create a class called CD whose attributes are Title and singer.  Arrange the CDs in ascending 
order based on the singer name.(Use Comparable)
 * 
 * 
 */

package javassignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class CD implements Comparable<CD> {
    String title;
    String artist;

    CD(String title, String singer) {
        this.title = title;
        this.artist = singer;
    }

    public int compareTo(CD other) {
        return this.artist.compareTo(other.artist);
    }

    public String toString() {
        return "CD Title: " + title + ", Artist -- " + artist;
    }

    public static void main(String[] args) {
        List<CD> cds = new ArrayList<>();
        cds.add(new CD("India's Got Latent", "Samay Raina"));
        cds.add(new CD("Bollywood-Hits", "Arijit Singh"));
        cds.add(new CD("Chill Beats", "Coldplay"));

        Collections.sort(cds);
        System.out.println("Artists names are sorted here-by :");

        for (CD cd : cds) {
            System.out.println(cd);
        }
    }
}
