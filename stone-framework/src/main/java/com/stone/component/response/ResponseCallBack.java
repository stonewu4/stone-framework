package com.stone.component.response;

import com.stone.component.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.util.Map;
import java.util.concurrent.Callable;


public abstract class ResponseCallBack {

    private static final Logger logger = LoggerFactory.getLogger(ResponseCallBack.class);

    public ResponseInfo sendRequest(Object... obj) {

        String message = "成功";
        int code = 200;
        Object infoList = null;
        ResponseCriteria criteria = new ResponseCriteria();
        try {
            execute(criteria, obj);

            Object result = criteria.getResult();
            Map<String, Object> reslutMap = criteria.getResultMap();
            if (result != null && reslutMap != null) {
                throw new BusinessException(BusinessException.CODE_CRITERIA_DUPLICATE);
            }
            infoList = (result != null ? result : reslutMap);
        } catch (BusinessException e) {
            code = e.getCode();
            if (e.isCustomMsg()) {
                message = e.getMessage();
            } else {
                //message = Contexts.getInstance().getSystemConfig("SYSTEM",String.valueOf(code));
                if (message != null) message = e.getMessage();
            }
            logger.error(e.getMessage());
        } catch (Exception e) {
        	/**
			 * 捕获非业务异常
			 * @auther: ws
			 * @data: 2020-4-7
			 * */
            code = BusinessException.CODE_GLOCBAL_EXCEPTION;
            message = e.getMessage();
        }
        return new ResponseInfo(code, message, infoList);
    }


    /**
     * 添加异步调用方法
     *
     * @param obj
     * @return
     */
    public WebAsyncTask<ResponseInfo> sendAsyncRequest(final Object... obj) {

        Callable<ResponseInfo> callable = new Callable<ResponseInfo>() {
            public ResponseInfo call() throws Exception {
                ResponseInfo responseInfo = sendRequest(obj);
                return responseInfo;
            }
        };
        return new WebAsyncTask<ResponseInfo>(callable);
    }


    public abstract void execute(ResponseCriteria criteria, Object... obj) throws Exception;

}