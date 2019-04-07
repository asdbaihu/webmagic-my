package us.liushuang.webmagic;

import us.liushuang.webmagic.processor.PageProcessor;

public class Sipder implements Runnable,Task {

	protected PageProcessor pageProcessor;

	protected Site site;

	public static Sipder create(PageProcessor pageProcessor){
		return new Sipder(pageProcessor);
	}

	public Sipder(PageProcessor pageProcessor){
		this.pageProcessor = pageProcessor;
		this.site = pageProcessor.getSite();
	}

	@Override
	public void run() {

	}

	@Override
	public String getUUID() {
		return null;
	}

	@Override
	public Site getSite() {
		return null;
	}
}
