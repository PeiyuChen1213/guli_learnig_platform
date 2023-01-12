package com.atguigu.eduservice.mapper;

import com.atguigu.eduservice.entity.EduTeacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 讲师 Mapper 接口
 * </p>
 *
 * @author chenpeiyu
 * @since 2022-12-01
 */

@Mapper
@Repository
public interface EduTeacherMapper extends BaseMapper<EduTeacher> {

}
