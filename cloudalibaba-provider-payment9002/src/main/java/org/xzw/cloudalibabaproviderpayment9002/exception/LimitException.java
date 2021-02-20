package org.xzw.cloudalibabaproviderpayment9002.exception;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.xzw.cloudalibabaproviderpayment9002.common.ApiResponse;

public class LimitException {
    public static ApiResponse<String> limitExceptionHandler(Integer id, String name, BlockException exception) {
        return ApiResponse.failure(4444, "自定义限流异常");
    }
}
