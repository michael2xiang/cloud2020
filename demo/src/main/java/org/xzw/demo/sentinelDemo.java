package org.xzw.demo;

import com.alibaba.csp.sentinel.SphO;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;

import java.util.ArrayList;
import java.util.List;

public class sentinelDemo {

    public static void main(String[] args) throws BlockException {
        initRule();
        while (true) {

            if (SphO.entry("myfunc")) {
                myFunc();
                System.out.println("ok````````````````");
            } else {
                System.out.println("BlockException");
            }

        }
    }

    private static void myFunc() {
        try {
            Thread.sleep(1500);
        } catch (Exception ex) {
        }

    }

    private static void initRule() {
        List<DegradeRule> rules = new ArrayList<>();
        DegradeRule rule = new DegradeRule();
        rule.setResource("myfunc");
        rule.setGrade(RuleConstant.DEGRADE_GRADE_RT);
        rule.setCount(1);
        rule.setTimeWindow(5);
        rules.add(rule);
        DegradeRuleManager.loadRules(rules);
    }
}
