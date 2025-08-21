package com.work.logs.service;

import com.work.logs.entity.WorkLogsInfo;
import com.work.logs.util.ResponseUtil;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(RestDocumentationExtension.class)
public class WorkLogsInfoServiceImplTest {

    private MockMvc mockMvc;

    @MockitoBean
    private IWorkLogsInfoService workLogsInfoService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    void setUp(RestDocumentationContextProvider restDocumentationContextProvider) throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .apply(documentationConfiguration(restDocumentationContextProvider))
                .build();
    }


    @Test
    void listTest() throws Exception {
        List<WorkLogsInfo> workLogsInfoList = new ArrayList<>();
        WorkLogsInfo workLogsInfo = new WorkLogsInfo();
        workLogsInfo.setLogTitle("标题");
        workLogsInfo.setLogContent("详细内容");
        workLogsInfo.setLogId("id");
        workLogsInfo.setSeq(1);
        workLogsInfo.setLogType("BUG");
        workLogsInfo.setStatus("START");
        workLogsInfoList.add(workLogsInfo);
        Mockito.when(workLogsInfoService.getAllWorkLogsInfo()).thenReturn(workLogsInfoList);
        this.mockMvc.perform(get("/workLogsInfo/list").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(document("workLogsInfo/list", responseFields(
                        fieldWithPath(ResponseUtil.CUSTOM_CODE).description("自定义的响应Code，默认为 LTL0000"),
                        fieldWithPath(ResponseUtil.CUSTOM_MESSAGE).description("自定义的响应Message，默认为 SUCCESS"),
                        fieldWithPath("data[].logId").description("日志ID"),
                        fieldWithPath("data[].seq").description("排序字段"),
                        fieldWithPath("data[].logTitle").description("标题"),
                        fieldWithPath("data[].logType").description("日志类型"),
                        fieldWithPath("data[].logContent").description("日志的详细内容"),
                        fieldWithPath("data[].updateTime").description("更新时间"),
                        fieldWithPath("data[].updateUser").description("更新用户"),
                        fieldWithPath("data[].createTime").description("创建时间"),
                        fieldWithPath("data[].createUser").description("创建用户"),
                        fieldWithPath("data[].status").description("日志的状态"),
                        fieldWithPath("data[].deleteFlg").description("逻辑删除Flag")
                )));
    }

    @Test
    void addTest() throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("logId", "LTL_ID_0001");
        jsonObject.put("seq", 1);
        jsonObject.put("logTitle", "关于画面宽度的自适应问题");
        jsonObject.put("logType", "START");
        jsonObject.put("logContent", "展开日志详细内容后，画面标题栏被挤出屏幕");
        jsonObject.put("status", "START");
        Mockito.when(workLogsInfoService.addWorkLogsInfo(any())).thenReturn(1);
        this.mockMvc.perform(post("/workLogsInfo/update").contentType(MediaType.APPLICATION_JSON).content(jsonObject.toString()))
                .andExpect(status().isOk())
                .andDo(print())
                .andDo(document("workLogsInfo/add", requestFields(
                        fieldWithPath("logId").description("日志ID"),
                        fieldWithPath("seq").description("排序字段"),
                        fieldWithPath("logTitle").description("标题"),
                        fieldWithPath("logType").description("日志类型"),
                        fieldWithPath("logContent").description("日志的详细内容").optional(),
                        fieldWithPath("status").description("日志的状态")
                )));
    }

    @Test
    void updateTest() throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("logId", "LTL_ID_0001");
        jsonObject.put("seq", 1);
        jsonObject.put("logTitle", "关于画面宽度的自适应问题");
        jsonObject.put("logType", "START");
        jsonObject.put("logContent", "展开日志详细内容后，画面标题栏被挤出屏幕");
        jsonObject.put("status", "START");

        Mockito.when(workLogsInfoService.updateWorkLogsInfo(any())).thenReturn(1);
        this.mockMvc.perform(post("/workLogsInfo/update").contentType(MediaType.APPLICATION_JSON).content(jsonObject.toString()))
                .andExpect(status().isOk())
                .andDo(print())
                .andDo(document("workLogsInfo/update", requestFields(
                        fieldWithPath("logId").description("日志ID"),
                        fieldWithPath("seq").description("排序字段"),
                        fieldWithPath("logTitle").description("标题"),
                        fieldWithPath("logType").description("日志类型"),
                        fieldWithPath("logContent").description("日志的详细内容").optional(),
                        fieldWithPath("status").description("日志的状态")
                )));
    }
}
