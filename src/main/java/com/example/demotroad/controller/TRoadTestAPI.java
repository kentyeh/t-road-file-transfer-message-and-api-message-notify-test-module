package com.example.demotroad.controller;

import com.example.demotroad.commons.utils.Base64Util;
import com.example.demotroad.commons.utils.msg.TRoadRequestDTO;
import com.example.demotroad.commons.utils.msg.TRoadResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Map;

@Slf4j
@RestController
@Api(tags = "Troad測試API")
@RequestMapping("/client")
public class TRoadTestAPI {

    /**
     * Troad API請求接收.
     *
     * @param headers
     * @param body
     * @return
     */
    @ApiOperation(value = "Troad-接受請求", notes = "提供API給介接單位發出請求。")
    @PostMapping(value = "/apiService")
    public TRoadResponseDTO apiService(
            @RequestHeader Map<String, String> headers,
            @RequestBody TRoadRequestDTO body,
            HttpServletRequest request,
            HttpServletResponse response
    ){

        String errorMsg ="";
        TRoadResponseDTO tRoadResponseDTO =new TRoadResponseDTO();

        //印出apikey供偵錯檢查
        log.info(headers.get("client_api_key"));
        //印出Content-type供偵錯檢查
        log.info(headers.get("Content-Type"));

        //檢核agreementId若null報錯 印出
        if(body.getAgreementId()==null||body.getAgreementId().length()==0){
            errorMsg = "agreementId異常";
        }
        log.info(body.getAgreementId());

        //檢核requestMethod若null或非get/post報錯 印出
        if(body.getRequestMethod()==null||body.getRequestMethod().length()==0){
            errorMsg = "requestMethod長度異常";
        }else if (body.getRequestMethod()!="POST"||body.getRequestMethod()!="GET"){
            errorMsg = "requestMethod非數發部所提供的使用方式";
        }
        log.info(body.getRequestMethod());

        //將requestBody Base64 decode 印出
        log.info(Base64Util.Decode(body.getRequestBody()).toString());

        //若上述無異常回傳成功物件,若異常則回覆異常部分
        if(errorMsg==null||errorMsg.length()==0){
            tRoadResponseDTO.setcode(500);
            tRoadResponseDTO.setmessage(errorMsg);
            tRoadResponseDTO.setresult("案件異常");
            tRoadResponseDTO.setticketNo("");
            return  tRoadResponseDTO;
        }else{
            tRoadResponseDTO.setcode(200);
            tRoadResponseDTO.setmessage("OK");
            //Base64的"案件呼叫成功" 模擬呼叫成功
            tRoadResponseDTO.setresult("5qGI5Lu25ZG85Y+r5oiQ5Yqf");
            tRoadResponseDTO.setticketNo("");
            return  tRoadResponseDTO;

        }

    }

    /**
     * Troad API 檔案傳輸請求接收.
     *
     * @param headers
     * @param body
     * @return
     */
    @ApiOperation(value = "Troad-檔案傳輸接受請求", notes = "提供API給介接單位發出檔案傳輸請求。")
    @PostMapping(value = "/createFileTransfer")
    public TRoadResponseDTO createFileTransfer(
            @RequestHeader Map<String, String> headers,
            @RequestBody TRoadRequestDTO body,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        String errorMsg = "";
        TRoadResponseDTO tRoadResponseDTO = new TRoadResponseDTO();

        //印出apikey供偵錯檢查
        log.info(headers.get("client_api_key"));
        //印出Content-type供偵錯檢查
        log.info(headers.get("Content-Type"));

        //檢核agreementId若null報錯 印出
        if (body.getAgreementId() == null || body.getAgreementId().length() == 0) {
            errorMsg = "agreementId異常";
        }
        log.info(body.getAgreementId());

        //檢核requestMethod若null或非get/post報錯 印出
        if (body.getRequestMethod() == null || body.getRequestMethod().length() == 0) {
            errorMsg = "requestMethod長度異常";
        } else if (body.getRequestMethod() != "POST" || body.getRequestMethod() != "GET") {
            errorMsg = "requestMethod非數發部所提供的使用方式";
        }
        log.info(body.getRequestMethod());

        //將requestBody Base64 decode印出
        log.info(Base64Util.Decode(body.getRequestBody()).toString());

        //若上述無異常 回傳成功物件 若異常則回傳異常部分
        if (errorMsg == null || errorMsg.length() == 0) {
            tRoadResponseDTO.setcode(500);
            tRoadResponseDTO.setmessage(errorMsg);
            tRoadResponseDTO.setresult("案件異常");
            tRoadResponseDTO.setticketNo("");
            return tRoadResponseDTO;
        } else {
            tRoadResponseDTO.setcode(200);
            tRoadResponseDTO.setmessage("OK");
            //Base64的"案件呼叫成功" 模擬呼叫成功
            tRoadResponseDTO.setresult("5qGI5Lu25ZG85Y+r5oiQ5Yqf");
            tRoadResponseDTO.setticketNo("A123456789-001-0001");
            return tRoadResponseDTO;

        }

    }

    /**
     * Troad API 檔案傳輸請求啟動.
     *
     * @param headers
     * @param body
     * @return
     */
    @ApiOperation(value = "Troad-檔案傳輸啟動請求", notes = "提供API給介接單位發出檔案傳輸啟動請求。")
    @PostMapping(value = "/startFileTransfer")
    public TRoadResponseDTO startFileTransfer(
            @RequestHeader Map<String, String> headers,
            @RequestBody TRoadRequestDTO body,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        String errorMsg = "";
        TRoadResponseDTO tRoadResponseDTO = new TRoadResponseDTO();

        //印出apikey供偵錯檢查
        log.info(headers.get("client_api_key"));
        //印出Content-type供偵錯檢查
        log.info(headers.get("Content-Type"));

        //檢核agreementId若null報錯
        if (body.getAgreementId() == null || body.getAgreementId().length() == 0) {
            errorMsg = "agreementId異常";
        }
        log.info(body.getAgreementId());


        //檢核ticketNo若null報錯
        if (body.getTicketNo() == null || body.getTicketNo().length() == 0) {
            errorMsg = "ticketNo異常";
        }
        log.info(body.getTicketNo());

        //檢核requestMethod若null或非get/post報錯
        if (body.getRequestMethod() == null || body.getRequestMethod().length() == 0) {
            errorMsg = "requestMethod長度異常";
        } else if (body.getRequestMethod() != "POST" || body.getRequestMethod() != "GET") {
            errorMsg = "requestMethod非數發部所提供的使用方式";
        }
        log.info(body.getRequestMethod());

        //將requestBody Base64 decode印出
        log.info(Base64Util.Decode(body.getRequestBody()).toString());

        //若上述無異常 回傳成功物件 若異常則回傳異常部分
        if (errorMsg == null || errorMsg.length() == 0) {
            tRoadResponseDTO.setcode(500);
            tRoadResponseDTO.setmessage(errorMsg);
            tRoadResponseDTO.setresult("案件異常");
            tRoadResponseDTO.setticketNo("");
            return tRoadResponseDTO;
        } else {
            tRoadResponseDTO.setcode(200);
            tRoadResponseDTO.setmessage("OK");
            //Base64的"案件呼叫成功" 模擬呼叫成功
            tRoadResponseDTO.setresult("5qGI5Lu25ZG85Y+r5oiQ5Yqf");
            tRoadResponseDTO.setticketNo("A123456789-001-0001");
            return tRoadResponseDTO;
        }
    }
}
