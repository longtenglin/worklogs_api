package com.work.logs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.work.logs.entity.WorkLogsInfo;
import com.work.logs.mapper.WorkLogsInfoMapper;
import com.work.logs.service.IWorkLogsInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Mr.ZhaoNan
 * @since 2025-04-11
 */
@Service
public class WorkLogsInfoServiceImpl extends ServiceImpl<WorkLogsInfoMapper, WorkLogsInfo> implements IWorkLogsInfoService {

    @Autowired
    private WorkLogsInfoMapper workLogsInfoMapper;

    @Override
    public List<WorkLogsInfo> getAllWorkLogsInfo() {
        return workLogsInfoMapper.selectList(null);
    }

    @Override
    public int addWorkLogsInfo(WorkLogsInfo workLogsInfo) {
        return workLogsInfoMapper.insert(workLogsInfo);
    }

    @Override
    public int updateWorkLogsInfo(WorkLogsInfo workLogsInfo) {
        UpdateWrapper<WorkLogsInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("logId", workLogsInfo.getLogId());
        updateWrapper.eq("seq", workLogsInfo.getSeq());
        return workLogsInfoMapper.update(workLogsInfo, updateWrapper);
    }

    @Override
    public WorkLogsInfo getWorkLogsInfoById(String logId, int seq) {
        return workLogsInfoMapper.selectOne(new QueryWrapper<WorkLogsInfo>().eq("logId", logId).eq("seq", seq));
    }
}
