package com.ecanal_mail.jpush;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;

import cn.jiguang.common.resp.BaseResult;

public class CIDResult extends BaseResult {

    @Expose public List<String> cidlist = new ArrayList<String>();
}
