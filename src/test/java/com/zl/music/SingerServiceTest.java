package com.zl.music;

import com.zl.music.pojo.Music;
import com.zl.music.pojo.Singer;
import com.zl.music.service.SingerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SingerServiceTest {
    @Autowired
    private SingerService ss;

    public void setSs(SingerService ss) {
        this.ss = ss;
    }
    @Test
    public void getTest(){
        Singer s = new Singer();
        s.setSinId(1);
        Singer singer = ss.get(s);
        System.out.println(singer.getSinName());
    }
    @Test
    public void singerListTest(){
        Singer singer = new Singer();
//        singer.setSinName("展展与罗罗");
        List<Singer> list = ss.singerList(singer,1);
        for (Singer singer1:list){
            System.out.println(singer1.getSinName());
            List<Music> list1 = singer1.getMusics();
            for (Music music:list1) {
                System.out.println(music.getmName());
            }
        }
    }
    @Test
    public void getSingerTotalTest(){
        Singer singer = new Singer();
//        singer.setSinSex("女");
//        singer.setSinRegion("中国");
        int SingerTotal = ss.getSingerTotal(singer);
        System.out.println(SingerTotal);
    }
    @Test
    public void getByNameTest(){
        Singer singer = ss.getByName("邓紫棋");
        System.out.println(singer.getSinId());
    }
    @Test
    public void getAllTest(){
        List<Singer> list = ss.getAll();
        for (Singer singer1:list){
            System.out.println(singer1.getSinName());
        }
    }
}
