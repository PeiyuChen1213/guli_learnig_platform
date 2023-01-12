package com.atguigu.eduservice.controller;
import com.atguigu.commonutils.R;
import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.entity.vo.TeacherQuery;
import com.atguigu.eduservice.service.EduTeacherService;
import com.atguigu.servicebase.exceptionHandler.CustomerException;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author chenpeiyu
 * @since 2022-12-01
 */
@Api("讲师管理")
@RestController
@RequestMapping("/eduservice/teacher")
@CrossOrigin // 处理跨域问题
public class EduTeacherController {
    //编写后台管理api的接口

    @Autowired
    private EduTeacherService eduTeacherService;

    /**
     * 列出所有的讲师
     * @return
     */
    @ApiOperation(value = "所有讲师列表")
    @GetMapping("/list")
    public R list(){
        List<EduTeacher> list = eduTeacherService.list();
        return R.ok().data("items",list);
    }

    /**
     * 根据id删除讲师
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id删除讲师")
    @DeleteMapping("/{id}")
    public R removeById(@PathVariable String id){
        eduTeacherService.removeById(id);
        return R.ok();
    }

    /**
     * 分页查询可以进行条件查询
     * @param currentPage 当前页面
     * @param pageSize 每一个页面的记录数
     * @param teacherQuery 条件查询的参数
     * @return 返回统一封装的结果集
     */

    @ApiOperation(value = "根据条件来查询分页")
    @PostMapping("/pageList/{currentPage}/{pageSize}")
    public R pageListByCondition(@PathVariable Integer currentPage, @PathVariable Integer pageSize, @RequestBody(required = false) TeacherQuery teacherQuery){
        Page<EduTeacher> page = new Page<>(currentPage,pageSize);
        System.out.println(teacherQuery);
        eduTeacherService.pageQuery(page,teacherQuery);
        long total = page.getTotal();
        List<EduTeacher> records = page.getRecords();
        return R.ok().data("total",total).data("rows",records);
    }

    /**
     * 新增讲师
     * @param eduTeacher 讲师的参数
     * @return 结果集合
     */
    @ApiOperation(value = "新增讲师")
    @PostMapping
    public R save(@RequestBody EduTeacher eduTeacher){
        eduTeacherService.save(eduTeacher);
        return R.ok();
    }

    /**
     * 根据id查询讲师
     * @param id
     * @return
     */
    @ApiOperation("根据id查询讲师")
    @GetMapping("/{id}")
    public R getById(@PathVariable String id){
        EduTeacher eduTeacher = eduTeacherService.getById(id);
        return R.ok().data("item",eduTeacher);
    }


    @ApiOperation(value = "根据id修改")
    @PutMapping("/{id}")
    public R updateById(@PathVariable String id,@RequestBody EduTeacher eduTeacher){
        //设置id 然后用于查询
        eduTeacher.setId(id);
        eduTeacherService.updateById(eduTeacher);
        return R.ok();
    }


    @GetMapping("/exception")
    public R testException(){
        try {
            int x = 1/0;
        } catch (Exception e) {
            throw new CustomerException(20001,"出现自定义的异常");
        }
        return R.ok();
    }

}

