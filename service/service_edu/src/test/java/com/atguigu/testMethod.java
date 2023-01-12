package com.atguigu;

import com.atguigu.eduservice.service.EduTeacherService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class testMethod {
    @Autowired
    private EduTeacherService eduTeacherService;

}
