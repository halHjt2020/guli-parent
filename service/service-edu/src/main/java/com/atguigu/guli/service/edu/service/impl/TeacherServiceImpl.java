package com.atguigu.guli.service.edu.service.impl;

import com.atguigu.guli.service.edu.entity.Teacher;
import com.atguigu.guli.service.edu.entity.query.TeacherQuery;
import com.atguigu.guli.service.edu.mapper.TeacherMapper;
import com.atguigu.guli.service.edu.service.TeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author Helen
 * @since 2020-08-25
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

        @Override
        public IPage<Teacher> selectPage(Long page, Long limit, TeacherQuery teacherQuery) {
            //组装分页对象
            Page<Teacher> pageParam = new Page<>(page, limit);
            //租整查询条件
            QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
            queryWrapper.orderByAsc("sort");

            if (teacherQuery == null){
                return baseMapper.selectPage(pageParam, queryWrapper);
            }

            String name = teacherQuery.getName();
            Integer level = teacherQuery.getLevel();
            String begin = teacherQuery.getJoinDateBegin();
            String end = teacherQuery.getJoinDateEnd();

            if (!StringUtils.isEmpty(name)) {
                //左%会使索引失效
                queryWrapper.likeRight("name", name);
            }

            if (level != null) {
                queryWrapper.eq("level", level);
            }

            if (!StringUtils.isEmpty(begin)) {
                queryWrapper.ge("join_date", begin);
            }

            if (!StringUtils.isEmpty(end)) {
                queryWrapper.le("join_date", end);
            }
            //执行查询返回结果
            return baseMapper.selectPage(pageParam, queryWrapper);
        }
    }

