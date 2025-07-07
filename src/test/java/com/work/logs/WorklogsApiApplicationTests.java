package com.work.logs;

import com.work.logs.entity.WorkLogsInfo;
import com.work.logs.service.IWorkLogsInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class WorkKLogsApiApplicationTests {

    @Autowired
    IWorkLogsInfoService workLogsInfoService;

    @Test
    void contextLoads() {
        List<WorkLogsInfo> workLogsInfos = workLogsInfoService.getAllWorkLogsInfo();
        WorkLogsInfo workLogsInfo = workLogsInfos.get(0);
        System.out.println(workLogsInfo.toString());
        System.out.println(workLogsInfo.getLogTitle());
    }
}
