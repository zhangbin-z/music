package com.zl.music;

import com.zl.music.pojo.Music;
import com.zl.music.service.MusicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MusicServiceTest {
   @Autowired
    private MusicService ms;

    public void setMs(MusicService ms) {
        this.ms = ms;
    }
    @Test
    public void getTest(){
        Music music = new Music();
        music.setmId(1);
        Music music1 = ms.get(music);
        System.out.println(music1.getmName());
    }
    @Test
    public void musicsByPageTest(){
        Music music = new Music();
        music.setmLanguage("伤感");
        music.setmMood("伤感");
        music.setmStyle("伤感");
        List<Music> list = ms.musicsByPage(music,1,"歌单");
        for (Music music1:list){
            System.out.println(music1.getmName());
        }
    }
    @Test
    public void addTest(){
        Music music = new Music();
        music.setIssueDate("2018-12-11");
        music.setmDuration("03:56");
        music.setmLanguage("华语");
        music.setmMood("深情");
        music.setmName("往后余生");
        music.setmPicture("music03.jpg");
        music.setmScanNum(0);
        music.setmStyle("舒缓");
        music.setmURL("dsadsad");
        music.setSinId(5);
        boolean flag = ms.add(music);
        System.out.println(flag);

    }
    @Test
    public void deleteTest(){
        Integer[] list ={1,2};
        boolean flag = ms.delete(list);
        System.out.println(flag);
    }
    @Test
    public void getMusicTotalTest(){
        Music music =new Music();
//        music.setmStyle("好听");
        int musicTotal = ms.getMusicTotal(music,"歌单");
        System.out.println(musicTotal);
    }

    @Test
    public void oldMusicListTest(){
        List<Music> list = ms.oldMusicList();
        for (Music music:list) {
            System.out.println(music.getmName());
        }
    }
    @Test
    public void hotSingerTest(){
        List<Music> list = ms.hotSinger(1,4);
        for (Music music:list) {
            System.out.println(music.getmName());
        }
    }
    @Test
    public void updateSanNumTest(){
        boolean flag = ms.updateSanNum(1);
        System.out.println(flag);
    }




}
