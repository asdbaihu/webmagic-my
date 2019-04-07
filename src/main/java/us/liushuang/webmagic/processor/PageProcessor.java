package us.liushuang.webmagic.processor;

import us.liushuang.webmagic.Page;
import us.liushuang.webmagic.Site;

public interface PageProcessor {

	void process(Page page);

	Site getSite();
}
