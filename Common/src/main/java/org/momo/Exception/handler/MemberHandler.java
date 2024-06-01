package org.momo.Exception.handler;


import org.momo.Common.BaseErrorCode;
import org.momo.Exception.GeneralException;

public class MemberHandler extends GeneralException {
    public MemberHandler(BaseErrorCode errorCode){
        super(errorCode);
    }
}
