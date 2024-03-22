package com.example.aoptest.exam;

import com.example.aoptest.annotation.Retry;
import com.example.aoptest.annotation.Trace;
import org.springframework.stereotype.Repository;

@Repository
public class ExamRepository {

    private static int seq = 0;
    /*
    * 5번에 1번 실패하는 요청
    * */
    @Trace
    //retry 꼭 횟수 넣기 무한 retry로 셀프 디도스 걸지않기, value 생략가능
    @Retry(value = 4)
    public String save(String itemId){
        seq++;
        if(seq % 5==0){
            throw new IllegalArgumentException("예외 발생");
        }
        return "ok";
    }

}
