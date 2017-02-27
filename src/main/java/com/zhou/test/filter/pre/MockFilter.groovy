package com.zhou.test.filter.pre

import com.netflix.zuul.ZuulFilter;

/**
 * Created by Zhou on 2017/2/22.
 */
public class MockFilter  extends ZuulFilter {
    @Override
    String filterType() {
        return "pre"
    }

    @Override
    int filterOrder() {
        return 1
    }

    @Override
    boolean shouldFilter() {
        return true
    }

    @Override
    Object run() {
        println "pre: 1: Mock"
    }
}
