package us.liushuang.webmagic;

import us.liushuang.webmagic.utils.HttpConstant;

import java.util.*;

public class Site {

	private String domain;

	private String userAgent;

	private Map<String, String> defaultCookies = new LinkedHashMap<>();

	private Map<String, Map<String, String>> cookies = new HashMap<>();

	private static final Set<Integer> DEFAULT_STATUS_CODE_SET = new HashSet<>();

	private Set<Integer> acceptStatCode = DEFAULT_STATUS_CODE_SET;

	private Map<String,String> headers = new HashMap<>();

	private String charset;

	private int sleepTime = 5000;

	private int retryTimes = 0;

	private int cycleRetryTimes = 0;

	private int retrySleepTime = 1000;

	private int timeOut = 5000;

	private boolean useGzip = true;

	private boolean disableCookieManagement = true;

	static {
		DEFAULT_STATUS_CODE_SET.add(HttpConstant.StatusCode.CODE_200);
	}

	public static Site me(){
		return new Site();
	}

	public Site SetDomain(String domain){
		this.domain = domain;
		return this;
	}

	public String getDomain(){
		return domain;
	}

	public Site setUserAgent(String userAgent){
		this.userAgent = userAgent;
		return this;
	}

	public String getUserAgent(){
		return userAgent;
	}

	public Site addCookie(String name, String value){
		defaultCookies.put(name, value);
		return this;
	}

	public Site addCookie(String domain, String name, String value){
		if(!cookies.containsKey(domain)){
			cookies.put(domain, new HashMap<String, String>());
		}
		cookies.get(domain).put(name, value);
		return this;
	}

	public Site setCharset(String charset){
		this.charset = charset;
		return this;
	}

	public String getCharset(){
		return charset;
	}

	public Site setAcceptStatCode(Set<Integer> acceptStatCode){
		this.acceptStatCode = acceptStatCode;
		return this;
	}

	public Set<Integer> getAcceptStatCode(){
		return acceptStatCode;
	}

	public Site addHeaders(String key, String value){
		headers.put(key, value);
		return this;
	}

	public Map<String, String> getHeaders(){
		return headers;
	}

	public int getTimeOut() {
		return timeOut;
	}

	public Site setTimeOut(int timeOut) {
		this.timeOut = timeOut;
		return this;
	}

	public Site setSleepTime(int sleepTime) {
		this.sleepTime = sleepTime;
		return this;
	}

	public int getSleepTime() {
		return sleepTime;
	}

	public int getRetryTimes() {
		return retryTimes;
	}

	public Site setRetryTimes(int retryTimes) {
		this.retryTimes = retryTimes;
		return this;
	}

	public int getCycleRetryTimes() {
		return cycleRetryTimes;
	}


	public Site setCycleRetryTimes(int cycleRetryTimes) {
		this.cycleRetryTimes = cycleRetryTimes;
		return this;
	}

	public int getRetrySleepTime() {
		return retrySleepTime;
	}

	public Site setRetrySleepTime(int retrySleepTime) {
		this.retrySleepTime = retrySleepTime;
		return this;
	}

	public boolean isUseGzip(){
		return useGzip;
	}

	public Site setUseGzpit(boolean useGzip){
		this.useGzip = useGzip;
		return this;
	}

	public boolean isDisableCookieManagement() {
		return disableCookieManagement;
	}

	public Site setDisableCookieManagement(boolean disableCookieManagement) {
		this.disableCookieManagement = disableCookieManagement;
		return this;
	}

	public Task toTask(){
		return new Task(){

			@Override
			public String getUUID() {
				String uuid = Site.this.domain;
				if (uuid == null) {
					uuid = UUID.randomUUID().toString();
				}
				return uuid;
			}

			@Override
			public Site getSite() {
				return Site.this;
			}
		};
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Site)) return false;
		Site site = (Site) o;
		return getSleepTime() == site.getSleepTime() &&
				getRetryTimes() == site.getRetryTimes() &&
				getCycleRetryTimes() == site.getCycleRetryTimes() &&
				getRetrySleepTime() == site.getRetrySleepTime() &&
				getTimeOut() == site.getTimeOut() &&
				isUseGzip() == site.isUseGzip() &&
				isDisableCookieManagement() == site.isDisableCookieManagement() &&
				Objects.equals(getDomain(), site.getDomain()) &&
				Objects.equals(getUserAgent(), site.getUserAgent()) &&
				Objects.equals(defaultCookies, site.defaultCookies) &&
				Objects.equals(cookies, site.cookies) &&
				Objects.equals(getAcceptStatCode(), site.getAcceptStatCode()) &&
				Objects.equals(getHeaders(), site.getHeaders()) &&
				Objects.equals(getCharset(), site.getCharset());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getDomain(), getUserAgent(), defaultCookies, cookies, getAcceptStatCode(), getHeaders(), getCharset(), getSleepTime(), getRetryTimes(), getCycleRetryTimes(), getRetrySleepTime(), getTimeOut(), isUseGzip(), isDisableCookieManagement());
	}

	@Override
	public String toString() {
		return "Site{" +
				"domain='" + domain + '\'' +
				", userAgent='" + userAgent + '\'' +
				", defaultCookies=" + defaultCookies +
				", cookies=" + cookies +
				", acceptStatCode=" + acceptStatCode +
				", headers=" + headers +
				", charset='" + charset + '\'' +
				", sleepTime=" + sleepTime +
				", retryTimes=" + retryTimes +
				", cycleRetryTimes=" + cycleRetryTimes +
				", retrySleepTime=" + retrySleepTime +
				", timeOut=" + timeOut +
				", useGzip=" + useGzip +
				", disableCookieManagement=" + disableCookieManagement +
				'}';
	}
}
