package us.liushuang.webmagic;

import us.liushuang.webmagic.model.HttpRequestBody;

import java.io.Serializable;

public class Request implements Serializable {

	private static final long serialVersionUID = 2062192774891352043L;

	public static final String CYCLE_TRIED_TIMES = "_cycle_tried_times";

	private String url;

	private String method;

	private HttpRequestBody requestBody;


}
