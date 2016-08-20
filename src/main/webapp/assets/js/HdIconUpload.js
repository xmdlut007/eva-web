/*
 * xiaomiMarket
 * Copyright xiaomi.com
 * path: screenShotUpload.js
 * author: yangweixian
 * version: 1.1.1
 * date: 2013/12/26
 */
/**
 * 高清图标上传控件
 * @param {url} opts.url 图片地址
 * @param {int} opts.imgSize 上传图片尺寸
 * @param {string} opts.content 容器
 * @param {string} opts.action post路径
 * @param {string} opts.failed 失败信息容器
 * @param {string} opts.formInput 返回的图片路径容器
 * @param {string} opts.removeMask 默认false，是否移除蒙板
 */
function HdIconUpload(opts){
  this.self = opts.self;
  this.url = opts.url || '';
  this.imgSize = opts.imgSize || 90;
  this.content = $('#'+opts.content);
  this.action = opts.action;
  this.failed = $('#' + opts.failed || '');
  this.formInput = $('#' + opts.formInput || '');
  this.userId = opts.userId || '';
  this.serviceToken = opts.serviceToken || '';
  this.delBtn = $('<a class="filedel" style="display:none" href="javascript:" >删除</a>');
  this.uploadBtnHtml = '<input onchange="' + this.self + '.upload()" type="file" name="pic" class="btn-file J-hdiconUploadBtn" size="1" accept="image/png" />';
  this.uploadBtn = $(this.uploadBtnHtml);
  if (!opts.removeMask) {
    this.iconBase = "http://i1.ml.mi-img.com/img/miui/appstore/dev/v2/icon_mast_" + this.imgSize.toString() +"_white.png";
  } else {
    this.iconBase = "http://resource.xiaomi.net/miuimarket/app/lazyload.gif";
  }
  this.init();
}
HdIconUpload.prototype = {
  init: function() {
    var _self = this;
    this.uploadForm = $(this.createUploadForm());
    this.uploadForm.append(this.uploadBtn);
    this.uploadImg = this.uploadForm.find("img");
    this.content.append(this.uploadForm);
    this.content.after(this.delBtn);
    if(this.url) {
      this.addItem(this.url);
    }
    this.delBtn.click(function() {
        //删除上传按钮再重新生成，避免不能触发onchange事件
        _self.uploadBtn = $(_self.uploadBtnHtml);
        _self.uploadForm.append(_self.uploadBtn);
        _self.delBtn.hide();
        _self.uploadBtn.show();
        _self.uploadImg.hide();
        _self.formInput.val("");
    });
  },
  upload: function() {
    this.uploadForm.submit();
    this.failed.empty();
  },
  createUploadForm: function() {
    var html = [];
    html.push('<form method="POST" target="ifr" enctype="multipart/form-data" action="');
    html.push(this.action);
    html.push('"><img src="' + this.iconBase + '" class="hide" />');
    html.push('<input type="hidden" name="instance" value="' + this.self + '" />');
    html.push('<input type="hidden" name="imgSize" value="' + this.imgSize + '" />');
    html.push('<input type="hidden" name="method" value="addItem" />');
    html.push('<input type="hidden" name="error" value="addItem" />');
    html.push('<input type="hidden" name="userId" value="'+ this.userId +'" />');
    html.push('<input type="hidden" name="serviceToken" value="'+ this.serviceToken +'" />');
    html.push('</form>');
    return html.join('');
  },
  addItem: function(imgUrl) {
    if (this.removeMask) {
      this.uploadImg.prop("src", imgUrl).show();
    } else {
      this.uploadImg.css({
        "background-image": "url(" + imgUrl +")",
        "background-repeat": "no-repeat",
        "display": "inline-block"
      });
    }
    this.formInput.val(imgUrl);
    this.delBtn.show();
    this.uploadBtn.remove();
  },
  renderError: function(msg) {
    this.failed.text(msg);
  }
};