package com.example.demo.mapper;

import com.example.demo.entity.Question;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionMapper {
  List<Question> list();

  List<Question> listByPage(Page page);


}
