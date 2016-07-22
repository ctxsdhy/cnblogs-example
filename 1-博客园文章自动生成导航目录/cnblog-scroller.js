jQuery(function($) {
	$(function() {
		//延迟1秒加载, 等博客园的侧栏加载完毕, 不然导航目录距离顶部的高度会不对
		setTimeout(function () {loadScroller();}, 1000);
	});
	
	//加载导航目录
	function loadScroller() {
		//先获取第一个h标签, 之后循环时作为上一个h标签
		var $ph = $('#cnblogs_post_body :header:eq(0)');
		if($ph.length > 0) {
			//设置初始层级为1
			$ph.attr('offset', '1');
			//添加导航目录的内容
			$('#blog-sidecolumn').append('<div id="sidebar_scroller" class="catListPostArchive sidebar-block"><h3 class="catListTitle">导航目录</h3><ul class="nav"></ul></div>');
			//取当前边栏的宽度
			$('#sidebar_scroller').css('width', $('#blog-sidecolumn').width());
			//让导航目录可以停留在页面顶端
			$('#sidebar_scroller').stickUp();
			
			//遍历文章里每个h标签
			$('#cnblogs_post_body :header').each(function() {
				var $h = $(this);
				//设置h标签的id, 编号从0开始
				$h.attr('id', 'scroller-' + $h.index());
				//比上一个h标签层级小, 级数加1
				if($h[0].tagName > $ph[0].tagName) {
					$h.attr('offset', parseInt($ph.attr('offset')) + 1);
				} //比上一个h标签层级大, 级数减1
				else if($h[0].tagName < $ph[0].tagName) {
					var offset = parseInt($ph.attr('offset')) - 1;
					$h.attr('offset', offset < 1 ? 1 : offset);
				} //和上一个h标签层级相等时, 级数不变
				else {
					$h.attr('offset', $ph.attr('offset'));
				}
				//添加h标签的目录内容
				$('#sidebar_scroller ul').append('<li class="scroller-offset' + $h.attr('offset') + '"><a href="#scroller-' + $h.index() + '">' + $h.text() + '</a></li>');
				//最后设置自己为上一个h标签
				$ph = $h;
			});
			
			//开启滚动监听, 监听所有在.nav类下的li
			$('body').scrollspy();
			
			//让页面的滚动更平滑
			$('#sidebar_scroller a').on('click', function() {
				var targetOffset = $(this.hash).offset().top;
				$('html, body').animate({scrollTop: targetOffset}, 800);
				return false;
			});
		}
	}
});