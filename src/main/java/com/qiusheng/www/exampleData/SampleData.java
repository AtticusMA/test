package com.qiusheng.www.exampleData;

import com.qiusheng.www.Entity.Album;
import com.qiusheng.www.Entity.Artist;
import com.qiusheng.www.Entity.Track;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class SampleData {

    public static final Artist johnColtrane = new Artist("John Coltrane", "US");

    public static final Artist johnLennon = new Artist("John Lennon", "UK");
    public static final Artist paulMcCartney = new Artist("Paul McCartney", "UK");
    public static final Artist georgeHarrison = new Artist("George Harrison", "UK");
    public static final Artist ringoStarr = new Artist("Ringo Starr", "UK");

    public static final List<Artist> membersOfTheBeatles = Arrays.asList(johnLennon, paulMcCartney, georgeHarrison, ringoStarr);

    public static final Artist theBeatles = new Artist("The Beatles", membersOfTheBeatles, "UK");

    public static final Album aLoveSupreme1 = new Album("A Love Supreme1", asList(new Track("Acknowledgement1", 467), new Track("Resolution1", 442)), asList(johnColtrane));
    public static final Album aLoveSupreme2 = new Album("A Love Supreme2", asList(new Track("Acknowledgement2", 467), new Track("Resolution2", 442)), asList(johnColtrane));
    public static final Album aLoveSupreme3 = new Album("A Love Supreme3", asList(new Track("Acknowledgement3", 467), new Track("Resolution3", 442)), asList(johnColtrane));
    public static final Album aLoveSupreme4 = new Album("A Love Supreme4", asList(new Track("Acknowledgement4", 467), new Track("Resolution4", 442)), asList(johnColtrane));
    public static final Album aLoveSupreme5 = new Album("A Love Supreme5", asList(new Track("Acknowledgement5", 467), new Track("Resolution5", 442)), asList(johnColtrane));

    public static final Album sampleShortAlbum = new Album("sample Short Album", asList(new Track("short track", 30)), asList(johnColtrane));

    public static final Album manyTrackAlbum = new Album("sample Short Album", asList(new Track("short track", 30), new Track("short track 2", 30), new Track("short track 3", 30), new Track("short track 4", 30), new Track("short track 5", 30)), asList(johnColtrane));


    public static Stream<Album> albums = Stream.of(aLoveSupreme1);

    public static Stream<Artist> threeArtists() {
        return Stream.of(johnColtrane, johnLennon, theBeatles);
    }

    public static List<Artist> getThreeArtists() {
        return Arrays.asList(johnColtrane, johnLennon, theBeatles);
    }

    public static List<Album> getAlbumList(){
        return Arrays.asList(aLoveSupreme1,aLoveSupreme2,aLoveSupreme3,aLoveSupreme4,aLoveSupreme5,sampleShortAlbum,manyTrackAlbum);
    }

}
