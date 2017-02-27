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
package com.zhou.test.filter.pre
import com.netflix.zuul.ZuulFilter

class SignFilter extends ZuulFilter {


    @Override
    String filterType() {
        return 'pre'
    }

    @Override
    int filterOrder() {
        return 2
    }

    boolean shouldFilter() {
        return true;
    }

    Object run() {
        println "pre :2 :sign"
    }


}



