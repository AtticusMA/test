package com.qiusheng.www.functionProgram;

import com.qiusheng.www.exampleData.SampleData;
import com.qiusheng.www.Entity.Album;
import com.qiusheng.www.Entity.Track;

import java.util.List;

public class ParallelStreamTest {
    public static void main(String[] args){
        System.out.println(System.currentTimeMillis());
        int sum=0;
        for(Album album:SampleData.getAlbumList()){
            List<Track> tracks=album.getTrackList();
            for(Track track:tracks){
                sum+=track.getLength();
            }
        }
        System.out.println(sum);
        System.out.println(System.currentTimeMillis());
        int intList=SampleData.getAlbumList().stream().flatMap(album -> album.getTracks()).mapToInt(track -> track.getLength()).sum();
        System.out.println(System.currentTimeMillis());
        SampleData.getAlbumList().parallelStream().flatMap(album -> album.getTracks()).mapToInt(track -> track.getLength()).sum();
        System.out.println(System.currentTimeMillis());
        System.out.println(intList);
    }
}
