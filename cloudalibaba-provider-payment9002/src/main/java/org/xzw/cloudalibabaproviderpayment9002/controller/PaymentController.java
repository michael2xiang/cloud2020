package org.xzw.cloudalibabaproviderpayment9002.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${config.info:default}")
    private String configInfo;

    @GetMapping(value="/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id)
    {
        return "AA，nacos registry, serverPort: "+serverPort+"\tid"+id +"\t configInfo="+configInfo;
    }

    @GetMapping(value="/payment/nacos/b/{id}")
    public String getPaymentBB(@PathVariable("id") Integer id)
    {
        return "BB,nacos registry, serverPort: "+serverPort+"\tid"+id +"\t configInfo="+configInfo;
    }
}
