package com.qiusheng.www.functionProgram;

import com.qiusheng.www.exampleData.SampleData;
import com.qiusheng.www.exampleData.StaticCollection;
import com.qiusheng.www.Entity.Artist;
import com.qiusheng.www.Entity.User;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;


public class Collectorstest {
    public static void main(String args[]){

        Set<Integer> integerSet = new HashSet<Integer>(asList(4,3,2,1));
        List<Integer> sortedList = integerSet.stream().sorted().collect(Collectors.toList());
        //System.out.println(sortedList.toString());
        Function<Artist,Long> getCount = artist -> artist.getMembers().count();
        //该死的maxBy，idea居然没有识别出来，再有getCount并不是每个artist都会有这个属性
        Optional<Artist> artistOptional= SampleData.threeArtists().collect(maxBy(comparing(getCount)));
        if(artistOptional.isPresent()){
            System.out.println(artistOptional.get());
        }
        double averageNumberOfTracks = SampleData.albums.collect(averagingInt(album->album.getTrackList().size()));
        System.out.println(averageNumberOfTracks);

        //替代if else
        Map<Boolean,List<User>> result = StaticCollection.getTUsers().stream().collect(partitioningBy(user->user.getAge()>25));
        Iterator iterator = result.entrySet().iterator();
        //map不能直接使用stream，需要转换成list
        //这是什么情况，只迭代false,而且iterator的size是两个啊
        while(iterator.hasNext()){
            Map.Entry<Boolean,List<User>> entry = (Map.Entry<Boolean,List<User>>)iterator.next();
            System.out.println(entry.getKey().toString());
            List<User> users = entry.getValue();
            users.stream().forEach(x-> System.out.println(x));
        }
        //日了够了，没有完全选对返回的类型，lambda表达式就能不对;如何排序呢，分组排序
        Map<Integer,List<User>> result1 =StaticCollection.getTUsers().stream().collect(groupingBy(user->user.getAge()));
        Iterator iterator1 = result1.entrySet().iterator();
        while(iterator1.hasNext()){
            Map.Entry<Integer,List<User>> entry = (Map.Entry<Integer, List<User>>)iterator1.next();
            System.out.println(entry.getKey().toString());
            List<User> users = entry.getValue();
            users.stream().forEach(x-> System.out.println(x));
        }
        //组成一个字符串 类似StringBuilder
        String names = StaticCollection.getTUsers().stream().map(user -> user.getName()).collect(Collectors.joining(",","{","}"));
        System.out.println(names);
        //组合使用收集器
        //counting的返回类型是long,将组合的方法加载groupby里面
        Map<Integer,Long> ageCount = StaticCollection.getTUsers().stream().collect(groupingBy(user->user.getAge(),counting()));
        System.out.println(ageCount.toString());
        //分组+映射列表
        Map<Integer,List<String>> ageName = StaticCollection.getTUsers().stream().collect(groupingBy(user->user.getAge(),mapping(User::getName,toList())));
        System.out.println(ageName);
        //使用reduce解决映射
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder=StaticCollection.getTUsers().stream().map(User::getName).reduce(new StringBuilder(),(builder,name)->
                {if(builder.length()>0)
                    builder.append(",");

                    builder.append(name);
                    return  builder;
                },(left,right)->left.append(right));
        stringBuilder.insert(0,"{");
        stringBuilder.append("}");
        System.out.println("reduce"+stringBuilder.toString());
        //重构上面的，使用StringCombiner,为什么出现StringCombiner::add 不是静态方法，放到这个main函数里就不行，单独放到一个方法中就可以。这是什么问题
        //SampleData.getThreeArtists()是静态变量，为StaticCollection.getTUsers()不是静态变量，不能动用静态方法
        StringCombiner combined= SampleData.getThreeArtists().stream().map(Artist::getName).reduce(new StringCombiner(",","{","}"), StringCombiner::add, StringCombiner::merge);
        StringCombiner combined1= StaticCollection.getTUsers().stream().map(User::getName).reduce(new StringCombiner(",","{","}"), StringCombiner::add, StringCombiner::merge);
        //StringCombinerTest combined2= SampleData.getThreeArtists().stream().map(Artist::getName).reduce(new StringCombinerTest(",","{","}"), StringCombinerTest::add, StringCombinerTest::meger);
        String combined3= StaticCollection.getTUsers().stream().map(User::getName).collect(new StringCollector(",","{","}"));
        //reduce的参数和collect参数不同
        System.out.println("字符串组合"+combined.toString());
        //使用Collectors.reducing归一
        String nameCombin=StaticCollection.getTUsers().stream().map(User::getName).collect(Collectors.reducing(new StringCombinerTest(",","{","}"),
                name->new StringCombinerTest(",","{","}").add(name),StringCombinerTest::meger)).toString();

        System.out.println("名字最长的艺术家");
        Artist artist1=SampleData.getThreeArtists().stream().max(CollecterComparator.artistComparator).orElseThrow(RuntimeException::new);
        Artist artist2=SampleData.getThreeArtists().stream().max(CollecterComparator.artistComparator).orElse(new Artist("lll","meiyou"));
        Optional<Artist> artist=SampleData.getThreeArtists().stream().max(CollecterComparator.artistComparator);
        if(artist.isPresent()){

            System.out.println(artist.get().toString());
        }

        Artist artist3 = SampleData.getThreeArtists().stream().reduce((acc,value)->{return CollecterComparator.artistComparator.compare(acc,value)>0? acc:value; }).orElseThrow(RuntimeException::new);
        Artist artist4 = SampleData.getThreeArtists().stream().collect(Collectors.maxBy(CollecterComparator.artistComparator)).orElseThrow(RuntimeException::new);

        System.out.println("计算单词出现的次数，固定的格式输出");
        Stream<String> stringStream =Stream.of("John", "Paul", "George", "John", "Paul", "John");
        Map<String,Long> wordCount= stringStream.collect(Collectors.groupingBy(string->string,counting()));

        System.out.println(wordCount.toString());

        //使用 Map 的 computeIfAbsent 方法高效计算斐波那契数列。 这里的“ 高效” 是指避免将那
        //些较小的序列重复计算多次。\
        //在缓存中经常用到computeIfAbsent，当map中不存在值的时候，设置新的值

    }

}
