package com.example.mybatis.jta.biz.datasource1;

import com.example.mybatis.jta.mapper.datasource1.SequenceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SequenceService {

    @Autowired
    SequenceMapper sequenceMapper;

    @Transactional
    public void increase(){
        sequenceMapper.increase("test");
    }
}
