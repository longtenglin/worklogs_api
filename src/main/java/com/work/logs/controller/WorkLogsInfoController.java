package com.work.logs.controller;

import com.alibaba.fastjson.JSONObject;
import com.work.logs.entity.WorkLogsInfo;
import com.work.logs.exception.LtlJsonToEntityException;
import com.work.logs.service.IWorkLogsInfoService;

import com.work.logs.util.RequestUtils;
import com.work.logs.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Mr.ZhaoNan
 * @since 2025-07-02
 */
@RestController
@RequestMapping("workLogsInfo")
public class WorkLogsInfoController {

    @Autowired
    IWorkLogsInfoService workLogsInfoService;

    @GetMapping("list")
    public JSONObject list() {
        List<WorkLogsInfo> workLogsInfoList = workLogsInfoService.getAllWorkLogsInfo();
        return ResponseUtil.success(workLogsInfoList);
    }

    @PutMapping("add")
    public JSONObject add(@RequestBody JSONObject params) throws LtlJsonToEntityException {
        WorkLogsInfo workLogsInfo = RequestUtils.toEntity(params, WorkLogsInfo.class);
        int workLogsInfoList = workLogsInfoService.addWorkLogsInfo(workLogsInfo);
        return ResponseUtil.success(workLogsInfoList);
    }

    @PostMapping("update")
    public JSONObject update(@RequestBody WorkLogsInfo params) {
        int workLogsInfoList = workLogsInfoService.updateWorkLogsInfo(params);
        return ResponseUtil.success(workLogsInfoList);
    }
}
