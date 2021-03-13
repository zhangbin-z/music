package com.zl.music;

import com.zl.music.dao.UserMusicsMapper;
import com.zl.music.pojo.Music;
import com.zl.music.pojo.User;
import com.zl.music.pojo.UserMusics;
import com.zl.music.service.UserMusicsService;
import com.zl.music.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMusicsServiceTest {
    @Autowired
    private UserMusicsService ums;
    @Autowired
    private UserService us;

    public void setUs(UserService us) {
        this.us = us;
    }
    public void setUmm(UserMusicsService ums) {
        this.ums = ums;
    }
    @Test
    public void listByIdTest(){
        List<UserMusics> list = ums.listById(1,1);
        for (UserMusics userMusics:list) {
            System.out.println(userMusics.getUser().getuName());
            List<Music> list1 = userMusics.getMusics();
            for (Music music:list1) {
                System.out.println(music.getSinger().getSinName());
            }

        }
    }
    @Test
    public void addTest(){
        UserMusics userMusics = new UserMusics();
        userMusics.setId(2);
        userMusics.setmId(2);
        boolean flag = ums.add(userMusics);
        System.out.println(flag);
    }
    @Test
    public void totalByIdTest(){
        int total = ums.totalById(1);
        System.out.println(total);
    }

    @Test
    public void loginTest(){
        User user1 = new User();
        user1.setuName("张斌");
        user1.setPassword("zb1234");
        User user = us.login(user1);
        System.out.println(user.getuBirthday());
    }


//    @Test
//    public void deleteTest(){
//        List<Integer> list = new ArrayList<Integer>();
//        list.add(3);
//        list.add(5);
//        boolean flag = ums.delete(list);
//        System.out.println(flag);
//    }
}
