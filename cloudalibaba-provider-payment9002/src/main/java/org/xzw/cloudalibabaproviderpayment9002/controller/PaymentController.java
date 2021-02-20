package org.xzw.cloudalibabaproviderpayment9002.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xzw.cloudalibabaproviderpayment9002.common.ApiResponse;
import  org.xzw.cloudalibabaproviderpayment9002.exception.LimitException;

@RestController
@RefreshScope
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${config.info:default}")
    private String configInfo;

    @GetMapping(value = "/payment/nacos")
    @SentinelResource(value = "getPayment", blockHandler = "deal_getPayment")
    public ApiResponse<String> getPayment(@RequestParam(value = "id", required = false) Integer id, @RequestParam(value = "name", required = false) String name) {
        return ApiResponse.success("AA，nacos registry, serverPort: " + serverPort + "\tid=" + id + "\t name=" + name + " configInfo=" + configInfo);
    }

    @GetMapping(value = "/payment/nacos/b/{id}")
    public ApiResponse<String> getPaymentBB(@PathVariable("id") Integer id) {
        return ApiResponse.success("BB,nacos registry, serverPort: " + serverPort + "\tid" + id + "\t configInfo=" + configInfo);
    }

    //兜底方法
    public ApiResponse<String> deal_getPayment(Integer id, String name, BlockException exception) {
        return ApiResponse.success("id=" + id + "name=" + name + "------deal_testHotKey,o(╥﹏╥)o");
    }


    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public ApiResponse<String> testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        //int age = 10/0;
        return ApiResponse.success("------ok");
    }

    //兜底方法
    public ApiResponse<String> deal_testHotKey(String p1, String p2, BlockException exception) {
        return ApiResponse.success("*********************,o(╥﹏╥)o");
    }


}
