/**
 * @name: checkAll && downloadAll
 * @overview: 一键下载功能
 * @author: yangweixian
 */
var download = function() {
	function DownloadUrls(urls) {
		if (urls.length != 0) {
			for (var i=0; i < urls.length; i++) {
				var npXLPlugin = navigator.mimeTypes["application/np_xunlei_plugin"];
				if (npXLPlugin) {
					var xlPlugin = document.createElement("embed");
					xlPlugin.style.visibility = "hidden";
					xlPlugin.type = "application/np_xunlei_plugin";
					xlPlugin.width = 0;
					xlPlugin.height = 0;
					document.body.appendChild(xlPlugin);
					xlPlugin.DownLoadByThunderPlugin(urls[i]);
				}
				else {
					downloadDirect(urls);
				}
			}
		}
	}
	function downloadDirect(urls) {
		for(var i = 0, ii = urls.length; i < ii; i++) {
			window.open(urls[i]);
		}
	}
	return {
		checkAll: function(btn, checkboxStr) {
			//全选
			var checkboxes = $(checkboxStr);
			$(btn).on('click', function() {
				if (this.checked) {
					checkboxes.attr('checked', 'checked');
				} else {
					checkboxes.removeAttr('checked')
				}
			});
		},
		downloadAllByThunder: function(btn, checkbox) {
			//一键下载
			$(btn).click(function(e) {
				var urls = [];
				$(checkbox + ':checked').each(function(i, elem) {
					urls.push($(this).attr('data-url'));
				});
				DownloadUrls(urls);
			});
		},
		downloadAllDirect: function(btn, checkbox) {
			$(btn).click(function(e) {
				var urls = [];
				$(checkbox + ':checked').each(function(i, elem) {
					urls.push($(this).attr('data-url'));
				});
				downloadDirect(urls);
			});
		},
		/**
		 * 通过传给后端id返回下载地址
		 * @param {btn} 触发下载的按钮
		 * @param {checkbox} 要绑定的checkbox
		 * @param {attrStr} 需要取的属性值
		 * @param {url} 取下载地址的url
		 */
		downloadAllDirectById: function(btn, checkbox, attrStr, url) {
			$(btn).click(function(e) {
				var ids = [];
				$(checkbox + ':checked').each(function(i, elem) {
					ids.push($(this).attr(attrStr));
				});
				$.ajax({
					url: url,
					type: 'POST',
					data: {'ids': ids},
					dataType: 'json',
					success: function(msg) {
						downloadDirect(msg.urls);
					}
				});
			})
		}
	}
}()


