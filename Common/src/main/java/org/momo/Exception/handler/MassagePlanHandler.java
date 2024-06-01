package org.momo.Exception.handler;


import org.momo.Common.BaseErrorCode;
import org.momo.Exception.GeneralException;

public class MassagePlanHandler extends GeneralException {
    public MassagePlanHandler(BaseErrorCode errorCode){
        super(errorCode);
    }
}
