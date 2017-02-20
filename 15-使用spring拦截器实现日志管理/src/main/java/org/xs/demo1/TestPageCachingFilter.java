package org.xs.demo1;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.constructs.web.filter.SimplePageCachingFilter;

public class TestPageCachingFilter extends SimplePageCachingFilter {
	
	@Override
	protected CacheManager getCacheManager() {
        return ((CacheManager)ContextUtils.getBean("ehcacheManager"));
    }
}