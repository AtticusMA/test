package com.qiusheng.www.functionProgram;

import com.qiusheng.www.Entity.Artist;

import java.util.Comparator;

import static java.util.Comparator.comparing;

public class CollecterComparator
{
    public final static Comparator<Artist> artistComparator = comparing(artist1 -> artist1.getName().length());
}
