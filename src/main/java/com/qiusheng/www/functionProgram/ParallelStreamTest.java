package com.qiusheng.www.functionProgram;

import com.qiusheng.www.exampleData.SampleData;
import com.qiusheng.www.Entity.Album;
import com.qiusheng.www.Entity.Track;

import java.util.List;
import java.util.Map;

public class ParallelStreamTest {
    public static void main(String[] args){

        //测试for，stream以及parallelStream的运行速度
        System.out.println("测试for，stream以及parallelStream的运行速度");
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

        System.out.println("蒙特卡洛模拟法");
        ParallelStream stream = new ParallelStream();
        double begin =System.currentTimeMillis();
        Map<Integer,Double> serialResult=stream.serialDiceRolls();
        double and =System.currentTimeMillis();
        Map<Integer,Double> result = stream.parallelDiceRolls();
        double end= System.currentTimeMillis();
        System.out.println("串行时间"+(and-begin)+"并行时间"+(end-begin));
        //这是什么情况，谁在前面执行，时间就短，这特么可怪异了
        System.out.println(serialResult);
        System.out.println(result);

        //这是什么情况，执行的结果跟我想的一点也不一样,为什么没有12点的出现呢，因为ThreadLocalRandom实例的方法nextInt(origin,bound)bound是不包括在内的
        //还有就是串行的速度居然比并行快
    }
}
