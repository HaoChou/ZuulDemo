/*
 * Copyright 2013 Netflix, Inc.
 *
 *      Licensed under the Apache License, Version 2.0 (the "License");
 *      you may not use this file except in compliance with the License.
 *      You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 *      Unless required by applicable law or agreed to in writing, software
 *      distributed under the License is distributed on an "AS IS" BASIS,
 *      WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *      See the License for the specific language governing permissions and
 *      limitations under the License.
 */
package com.zhou.test.filter.post

import com.netflix.config.DynamicBooleanProperty
import com.netflix.config.DynamicIntProperty
import com.netflix.config.DynamicPropertyFactory
import com.netflix.util.Pair
import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.constants.ZuulConstants
import com.netflix.zuul.constants.ZuulHeaders
import com.netflix.zuul.context.Debug
import com.netflix.zuul.context.RequestContext
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import javax.servlet.http.HttpServletResponse
import java.nio.charset.Charset
import java.util.zip.GZIPInputStream
import java.util.zip.ZipException

class SendResponseFilter extends ZuulFilter {

    @Override
    String filterType() {
        return 'post'
    }

    @Override
    int filterOrder() {
        return 1000
    }

    boolean shouldFilter() {
        return true;
    }


    Object run() {
        println "post 1000"

        RequestContext requestContext = RequestContext.getCurrentContext()
        String responseBody = requestContext.getResponseBody()
        HttpServletResponse servletResponse = requestContext.getResponse()
        servletResponse.setCharacterEncoding("UTF-8")

        OutputStream outStream = servletResponse.getOutputStream();
        try{
            outStream?.write(responseBody.getBytes())
        }finally {
            outStream?.flush()
            outStream?.close()
        }

    }
}
