package com.ecanal_mail.interceptor;

public class LYBURL {
	public static String[] getNURL() {
		String[] NURL={
				"/print","/test","/file/upload","/file/down","/file/uploads","/jspdata",//test
				"/show/chuanzhu/huowu","/show/chuanzhu/jianli","/show/huozhu","/show/chuanyuan",//入口
				"/show/chuanzhu/screen/goods","/show/chuanzhu/screen/resume","/show/huozhu/screen",//入口筛选
				"/show/chuanyuan/screen",  //入口筛选
				"/show/details/goods","/show/details/ship","/show/details/recruit","/show/details/resume", //入口单条信息详情
				"/show/refresh/huowu","/show/refresh/chuanzhi","/show/refresh/jianli","/show/refresh/zhaopin",//入口刷新
				"/publish/chuanzhu/zhaopin","/publish/chuanzhu/ship","/publish/huozhu",//发布
				"/publish/chuanyuan","/publish/goodstype","/publish/chuanzhu/update/zhaopin",//发布
				"/publish/chuanzhu/update/ship","/publish/huozhu/update","/publish/chuanyuan/update",//发布
				"/publish/chuanzhu/delete/zhaopin","/publish/chuanzhu/delete/ship",     "/publish/prehuozhu", //发布
				"/publish/huozhu/delete","/publish/chuayuan/delete","/publish/chuanyuan/close",//发布
				
				"/order/create","/order/show/recokn","/order/agree","/order/payearnest","/order/prepayment","/order/payment",//订单
				"/order/cancel","/order/refund0","/order/refund","/order/findbyid","/order/find",//订单
				"/order/update","/order/delete","/order/presign","/order/sign","/order/checkcontract", //订单
				"/order/comment","/order/showcomment", "/order/agree", //订单

				"/orderforcommon/s_create","/orderforcommon/g_create","/orderforcommon/payearnest",  //订单
				"/orderforcommon/prepayment","/orderforcommon/payment","/orderforcommon/g_agree",//订单
				"/orderforcommon/cancel_g","/orderforcommon/cancel_s","/orderforcommon/refund0",  //订单
				"/orderforcommon/refund","/orderforcommon/findbyid","/orderforcommon/find", //订单
				"/orderforcommon/update","/orderforcommon/delete","/orderforcommon/presign",  //订单
				"/orderforcommon/sign","/orderforcommon/checkcontract", "/orderforcommon/s_agree",//订单
				"/orderforcommon/comment","/orderforcommon/showcomment",  //订单
				"/orderforcommon/notify", "/orderforcommon/test",
				"orderforcommon/yunhuo","orderforcommon/daohuo","orderforcommon/qianshou", //订单 暂时
				
				"/logistics/state","/logistics/append","/logistics/update","/logistics/look",  //物流
				"/feedback/obtaintype","feedback/upload", //意见反馈
				"/collection/obtiontype","/collection/save","/collection/find","/collection/delete", //我的收藏
				"/collection/saveordelete", "/collection/check",   //收藏
				"/edingcheng/hanglubao","/edingcheng/edingchuan","/edingcheng/yizhanshi", //e订程
				"/edingcheng/update/hanglubao","/edingcheng/update/edingchuan", //e订程
				"/edingcheng/update/yizhanshi", "/edingcheng/delete",   //e订程
				"/mypublish/show",    //我的发布
				"/contract/register","/contract/byid","/contract/byidapp",   //jsp 合同 
				"/export/goods","/export/resume","/export/warehouse",  //数据导出
				"/warehouse_admin_insert","/warehouse_admin_update","/warehouse_app_show", //仓库
				"/warehouse_app_search","/warehouse_admin_show","/warehouse_admin_search",  //仓库
				"/warehouse_admin_details","/warehouse_admin_delete","warehouse_admin_delete_true",

				"/weixiu_add","/weixiu_add2","/admin_doweixiu","/weixiu_look_datails","/weixiu_update", //河上维修
				"/weixiu_update_state","/weixiu_search", "/weixiu_request", //河上维修
				"/do_upload_file",
				"/contract/dopdf"  //pdf测试
				,"/alipay/confirm","/alipay/notify","/alipay/success" //支付测试
				,"/test_token","/test_tokenjsp","test_get_token",
				
				"/contract/shipuser_web","/contract/goodsuser_web","/contract/my_web",
				"/contract/shipuser_app","/contract/goodsuser_app","/contract/my_app"
				
		};

		return NURL;
	}

}
