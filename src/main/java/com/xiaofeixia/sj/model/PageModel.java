package com.xiaofeixia.sj.model;

import javax.servlet.http.HttpServletRequest;

public class PageModel {
	private int pageSize;		//每页显示条数
	private int page;			//当前第几页
	private int totlePage;		//总页数
	private int isSize;			//当前期数记录数
	private int totleSize;		//记录总数
	private String pageBody;	//分页设置
	private int state;			//状态
	private String url;			//链接地址
	
	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public int getState() {
		return state;
	}


	public void setState(int state) {
		this.state = state;
	}


	public static PageModel getpageModel(int pageSize, int page,int totleSize,int state,HttpServletRequest request){
		String url = request.getRequestURI();
		String p = request.getContextPath();
		url  = url.replace(p+"/", "");
		int totlePage = 0;
		if(pageSize==-1){
			totlePage=1;
		}else{
			totlePage = (totleSize + (pageSize - 1)) / pageSize;
		}
		int isSize = (page - 1) * pageSize;
		String pageBody = null;
		pageBody="<div style='left;display: inline;'>";
		if(pageSize==-1){
			pageBody +="显示"+(isSize+1)+"-"+(totleSize)+"条数据，共"+totleSize+"条数据";
		}else{
			if((page*pageSize)>totleSize){
				pageBody +="显示"+(isSize+1)+"-"+(totleSize)+"条数据，共"+totleSize+"条数据";
			}else{
				pageBody +="显示"+(isSize+1)+"-"+(page*pageSize)+"条数据，共"+totleSize+"条数据";
			}
		}
		pageBody +="</div>"+
				"<div style='float:right;display: inline;'>"+
				"<div class='btn-group' role='group'>";
		if(page==1){
			pageBody +="<a  class='btn disabled btn-default' href='#' role='button'>";
		}else{
			pageBody +="<a  class='btn btn-default' href='"+url+"?pageSize="+pageSize+"&page="+(page-1)+"&state="+state+"' role='button'>";
		}
				
		pageBody +="<span aria-hidden='true'>&laquo;</span>"+
				"</a>";
				if((page>=3)&&((page+2)<=totlePage)){
					for(int i=(page-2);i<=(page+2);i++){
						if(page==i){
							pageBody +="<a class='btn btn-default active' href='"+url+"?pageSize="+pageSize+"&page="+i+"&state="+state+"' role='button'>"+i+"</a>";
						}else{
							pageBody +="<a class='btn btn-default' href='"+url+"?pageSize="+pageSize+"&page="+i+"&state="+state+"' role='button'>"+i+"</a>";
						}
					}
				}else if(page<3&&totlePage>=5){
					for(int i=1;i<=5;i++){
						if(page==i){
							pageBody +="<a class='btn btn-default active' href='"+url+"?pageSize="+pageSize+"&page="+i+"&state="+state+"' role='button'>"+i+"</a>";
						}else{
							pageBody +="<a class='btn btn-default' href='"+url+"?pageSize="+pageSize+"&page="+i+"&state="+state+"' role='button'>"+i+"</a>";
						}
					}
				}else if(totlePage<5){
					for(int i=1;i<=totlePage;i++){
						if(page==i){
							pageBody +="<a class='btn btn-default active' href='"+url+"?pageSize="+pageSize+"&page="+i+"&state="+state+"' role='button'>"+i+"</a>";
						}else{
							pageBody +="<a class='btn btn-default' href='"+url+"?pageSize="+pageSize+"&page="+i+"&state="+state+"' role='button'>"+i+"</a>";
						}
					}
				}else if((page>=3)&&((page+2)>totlePage)){
					for(int i=(totlePage-4);i<=totlePage;i++){
						if(page==i){
							pageBody +="<a class='btn btn-default active' href='"+url+"?pageSize="+pageSize+"&page="+i+"&state="+state+"' role='button'>"+i+"</a>";
						}else{
							pageBody +="<a class='btn btn-default' href='"+url+"?pageSize="+pageSize+"&page="+i+"&state="+state+"' role='button'>"+i+"</a>";
						}
					}
				}
				if(page==totlePage){
					pageBody +="<a  class='btn disabled btn-default' href='#' role='button'>";
				}else{
					pageBody +="<a  class='btn btn-default' href='"+url+"?pageSize="+pageSize+"&page="+(page+1)+"&state="+state+"' role='button'>";
				}
				pageBody +="<span aria-hidden='true'>&raquo;</span>"+
				"</a></div></div>";
		PageModel pagemodel = new PageModel(pageSize, page, totlePage, isSize, totleSize,pageBody,state,url);
		return pagemodel;
	}
	
	
	public String getPageBody() {
		return pageBody;
	}


	public void setPageBody(String pageBody) {
		this.pageBody = pageBody;
	}





	public PageModel(int pageSize, int page, int totlePage, int isSize, int totleSize, String pageBody, int state,
			String url) {
		super();
		this.pageSize = pageSize;
		this.page = page;
		this.totlePage = totlePage;
		this.isSize = isSize;
		this.totleSize = totleSize;
		this.pageBody = pageBody;
		this.state = state;
		this.url = url;
	}


	public int getIsSize() {
		return isSize;
	}
	public void setIsSize(int isSize) {
		this.isSize = isSize;
	}
	public int getTotleSize() {
		return totleSize;
	}
	public void setTotleSize(int totleSize) {
		this.totleSize = totleSize;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotlePage() {
		return totlePage;
	}
	public void setTotlePage(int totlePage) {
		this.totlePage = totlePage;
	}
	@Override
	public String toString() {
		return "PageModel [pageSize=" + pageSize + ", page=" + page + ", totlePage=" + totlePage + ", isSize=" + isSize
				+ ", totleSize=" + totleSize + ", pageBody=" + pageBody + ", state=" + state + ", url=" + url + "]";
	}
	
}
