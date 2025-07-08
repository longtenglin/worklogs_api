package com.work.logs.service;

import com.work.logs.entity.WorkLogsInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WorkLogsInfoServiceImplTest {

    @Autowired
    IWorkLogsInfoService workLogsInfoService;

    @Test
    void testGetWorkLogsInfoById() {
        WorkLogsInfo workLogsInfo = workLogsInfoService.getWorkLogsInfoById("WL_LTL_00000", 0);
        System.out.println(workLogsInfo.toString());
    }
}
