package com.beeplay.easylog.log4j2.util;

import com.beeplay.easylog.core.LogMessage;
import com.beeplay.easylog.core.TransId;
import com.beeplay.easylog.core.util.DateUtil;
import com.beeplay.easylog.core.util.IpGetter;
import org.apache.logging.log4j.core.LogEvent;

import java.sql.Timestamp;

/**
 * 组装日志数据
 */
public class LogMessageUtil {

    public static LogMessage getLogMessage(String appName,LogEvent logEvent){
        LogMessage logMessage = new LogMessage();
        String ip = IpGetter.getIp();
        logMessage.setServerName(ip);
        logMessage.setAppName(appName);
        logMessage.setContent(logEvent.getMessage().getFormattedMessage());
        logMessage.setTransId(TransId.logTranID.get());
        logMessage.setDtTime(DateUtil.parseTimestampToStr(new Timestamp(logEvent.getTimeMillis()),DateUtil.DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS));
        logMessage.setClassName(logEvent.getLoggerName());
        logMessage.setMethod(logEvent.getThreadName());
        logMessage.setLogLevel(logEvent.getLevel().toString());
        return logMessage;
    }
}