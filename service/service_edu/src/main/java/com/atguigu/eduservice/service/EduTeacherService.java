package com.atguigu.eduservice.service;

import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.entity.vo.TeacherQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author chenpeiyu
 * @since 2022-12-01
 */


public interface EduTeacherService extends IService<EduTeacher> {
    void pageQuery(Page<EduTeacher> pagePram, TeacherQuery teacherQuery);
}
