package cn.celitea.zeus.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 * Created by julin on 2019/11/6
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Test
    public void testRedis() {
        String str = "1997-07";
        String[] result = str.split("-");
        System.out.println(Arrays.toString(result));
    }
}
