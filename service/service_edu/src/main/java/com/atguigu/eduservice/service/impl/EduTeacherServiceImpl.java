package com.atguigu.eduservice.service.impl;

import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.entity.vo.TeacherQuery;
import com.atguigu.eduservice.mapper.EduTeacherMapper;
import com.atguigu.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author chenpeiyu
 * @since 2022-12-01
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {
    @Override
    public void pageQuery(Page<EduTeacher> pagePram, TeacherQuery teacherQuery) {

        LambdaQueryWrapper<EduTeacher> teacherLambdaQueryWrapper = new LambdaQueryWrapper<>();
        teacherLambdaQueryWrapper.orderByAsc(EduTeacher::getSort);
        //如果没有传入的参数
        if (teacherQuery == null) {
            this.page(pagePram);
            return;
        }
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
        teacherLambdaQueryWrapper.like(!StringUtils.isEmpty(name),EduTeacher::getName,name);
        teacherLambdaQueryWrapper.eq(level!=null,EduTeacher::getLevel,level);
        teacherLambdaQueryWrapper.ge(!StringUtils.isEmpty(begin),EduTeacher::getGmtCreate,begin);
        teacherLambdaQueryWrapper.le(!StringUtils.isEmpty(end),EduTeacher::getGmtCreate,end);

        this.page(pagePram,teacherLambdaQueryWrapper);

    }
}
