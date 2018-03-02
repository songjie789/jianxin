package com.ecanal_mail.interceptor;

import java.util.HashSet;
import java.util.Set;

public class MCURL {

	public static String[] getNURL() {
		 String[] NURL={"/toadmin_login","/checkphone","/adminlogin","/admin_register","/app_getcarousel",
					"/app_getnewstype","/app_getnewsbytype","/app_getnewsbyid","/app_getweixinnews","/app_getnewnews",
					"/app_getaboutusandsumary","/app_getservicetitle","/app_getweixinnewsbytypeid","/app_getweixinnewsbyid",
					"/app_newslikes","/totestlogin","/testlogin","/app_getNewsComment","/app_commentreply","/app_getcommentbyid",
					"/app_commentlikes","/app_commentnews","/app_commentreply","/app_newscollection","/app_userlogin",
					"/app_getnewscommentnumber","/app_comment_reply","/app_getnewnews","/app_newcomment","/app_getnewweixinnews",
					"/app_getsearchtype","/app_search","/sendMessage","/checkCode","/app_getrsapublickey","/app_getnewcommentreply",
					"/checkloginname","/app_registerUser","/app_checkphone","/app_delectcomment","/getpublickey","/app_weixinuserlogin",
					"/app_checke_mail","/sendE_MailCode","/change_password","/app_wechatregisterUser","/app_loginout","/app_userfeedback",
					"/app_getfeedbacktype","/app_mycollectiontype","/app_mycollection","/uploadfile","/touploadfile","/getnewsbyid2",
					"/app_weixingetnewsbyid","/browser_login","/getrsapublickey","/gettotlepage","/heshangweixiu",
					"/browser_login","/getResumeById","/getGoodsById","/getShipById","/getPortByCityId","/getcarousel","/totest",
					"/getPreviousOrNextNews","/app_ShipHelp","/poush","/getUserInfo","/ifc_getHelpMoney",
					"/getprovice","/getleader","/getcity","/ifc_updateUserPhoto","/ifc_updateUserPhone","/ifc_getUserPhone",
					"/ifc_updateUserNickname","/web_feedback","/ifc_hsDetails","/ifc_individualInformation",
					"/ifc_getIndividualInformation","/ifc_checkid_number","/ifc_userMessage","/Ifc_changeMessageStatus",
					"/ifc_updateIndividualInformation","/ifc_getIdentify","/webuploadfile","/ifc_getNewVersion",
					"/ifc_updateCorporateInformation","/ifc_addCorporateInformation","/ifc_getCorporateInformation",
					"/adminGetCode","/admin_checkCode","/admin_changePasswordByPhone","/ios_getrsapublickey",
					"/ifc_getNewsTitle_Summary_ThumbnailById","/ifc_SECanal","/getBowerUUID","/searchSECanal","/getportprovice",
					"/getportleader","/getportcity","/websendMessage","/ifc_deleteMyCollection","/ifc_checkUserIsReceivingPush",
					"/ifc_updateUserIsReceivingPush","/ifc_advertisement","/ifc_advertisementSummary","/ifc_showADTDetilsById",
					"/getttt","/weChatTip","/ifc_checkUsePhone","/ifc_userFillInPhone","/ifc_userFillInPhone",
					"/createQRcode","/wPayReturn","/ifc_checkPayState","/ifc_APPCreateWXOrder","/ifc_chackLoginState",
					"/ifc_getWeflare","/test123","/idc_deleteUserMessage","/app_iosGetRSAPublickey",
					"/app_IOSUserLogin","/WXPayRefundReturn","/testlogintest","/testlogin2","/ios_newslikes","/iosJieMiTest",
					"/iosUserLogin","/iosRegisterUser","/iosChangePassword","/web_ifc_showADTDetilsById"};
		return NURL;
	}
	
	public static String[] union(String[] strArray1, String[] strArray2,String[] strArray3,String[] strArray4,
			String[] strArray5) {
		Set<String> setString = new HashSet<String>();
		for (String str : strArray1) {
			setString.add(str);
		}
		for (String str : strArray2) {
			setString.add(str);
		}
		for (String str : strArray3) {
			setString.add(str);
		}
		for (String str : strArray4) {
			setString.add(str);
		}
		for (String str : strArray5) {
			setString.add(str);
		}
		String[] result = new String[0];
		return setString.toArray(result);
	}

}
