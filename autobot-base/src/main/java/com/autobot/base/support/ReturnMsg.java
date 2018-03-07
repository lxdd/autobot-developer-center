package com.autobot.base.support;

/**   
* ReturnMsg
* @author (li_xiaodong)
* @date 2015年10月13日 上午10:32:57
*/
public interface ReturnMsg
{
    String SUCCESS_MSG = "成功";
    
    String FAILURE_MSG = "失败";
    
    /**
     *  记入日志成功 
     */
    String SUCCESS_ADD_LOG_MSG = "记入日志成功";
   
    /**
     *  记入日志失败 
     */
    String ERROR_ADD_LOG_MSG = "记入日志失败";
    
    /**
     *  上传文件成功 
     */
    String SUCCESS_UPLOAD_FILE_MSG = "上传文件成功";
    
    /**
     *  上传文件失败 
     */
    String ERROR_UPLOAD_FILE_MSG = "上传文件失败";
    
    /**
     * 文件类型错误
     */
    String ERROR_FILE_FORMAT_MSG = "文件类型错误";
    
}
