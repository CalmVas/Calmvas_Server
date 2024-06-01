package org.momo.Exception.handler;


import org.momo.Common.BaseErrorCode;
import org.momo.Exception.GeneralException;

public class MassageHandler extends GeneralException {
    public MassageHandler(BaseErrorCode errorCode){
        super(errorCode);
    }
}
