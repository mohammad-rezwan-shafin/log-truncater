/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shafin.logtruncater.core.service;

/**
 *
 * @author shafin
 */
public interface TruncateService {
    String truncate(String strData, int limitSize);
}
