package com.work.logs.service;

import com.work.logs.entity.WorkLogsInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Mr.ZhaoNan
 * @since 2025-04-11
 */
public interface IWorkLogsInfoService extends IService<WorkLogsInfo> {

    List<WorkLogsInfo> getAllWorkLogsInfo();

    int addWorkLogsInfo(WorkLogsInfo workLogsInfo);

    int updateWorkLogsInfo(WorkLogsInfo workLogsInfo);

    WorkLogsInfo getWorkLogsInfoById(String logId, int seq);
}
