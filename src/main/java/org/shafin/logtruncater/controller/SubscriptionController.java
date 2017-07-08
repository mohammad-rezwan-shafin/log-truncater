/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shafin.logtruncater.controller;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

import org.shafin.logtruncater.core.service.OrderService;
import org.shafin.logtruncater.core.service.TruncateService;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author shafin
 */
@Slf4j
@Controller
public class SubscriptionController {
    
    @Autowired
    private OrderService orderService;

    @Autowired
    private TruncateService truncateService;
    
    @RequestMapping (value = "/subscribe", method = RequestMethod.GET)
    public String subscribe (HttpServletRequest request) {
        String orderDetails = getOrderDetails(request);
        String truncatedOrderDetails = truncate(orderDetails, 250);
        log(truncatedOrderDetails);
        return "Success";
    }
    
    private String getOrderDetails(HttpServletRequest request) {
        String responseText = orderService.testMethod("input in controller ");
        log.info(responseText);
        return "getOrderDetails";
    }
    
    private String truncate(String strData, int limitSize) {
        return truncateService.truncate(strData, limitSize);
    }
    
    private void log(String strValue) {
        log.info(strValue);
    }    
}
