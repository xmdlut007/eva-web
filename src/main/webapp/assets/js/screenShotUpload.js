/*
 * MiuiMarket
 * Copyright xiaomi.com
 * path: screenShotUpload.js
 * author: yangweixian
 * version: 1.1.1
 * date: 2013/11/27
 */
/**
 * 上传截图
 * @param {array} opts.urls 图片地址数组
 * @param {int} opts.maxcount 最大上传图片数
 * @param {int} opts.maxcount 最大上传图片数
 * @param {string} opts.content 容器
 * @param {string} opts.preId id前缀
 * @param {string} opts.screenName 上传后提交到服务器的input name
 */
function ScreenshotUpload(opts){
  this.urlArr = opts.urls || [];
  this.maxcount = opts.maxcount || 5;
  this.self = opts.self;
  this.content = $('#'+opts.content);
  this.index = this.urlArr.length;
  this.action = opts.action;
  this.userId = opts.userId || '';
  this.serviceToken = opts.serviceToken || '';
  this.preId = opts.preId || '';
  this.sortableId  = this.preId + 'sortable';
  this.addFileBtnId  = this.preId + 'addFileBtn';
  this.liId  = this.preId + 'li';
  this.screenName  = opts.screenName || 'screen';
  this.imgWidth = opts.imgWidth || 100;
  this.imgHeight = opts.imgHeight || "";
  this.init();
}
ScreenshotUpload.prototype = {
  init:function(){
    var html = [];
    for(var i=0;i<this.urlArr.length;i++){
      html.push(this.itemTemplete(i,this.urlArr[i]));
    }
    this.content.append('<ul id="' + this.sortableId + '" class="screenshot-sortable"></ul>');
    var sortable = this.sortable = $("#" + this.sortableId);
    sortable.append('<div id="' + this.addFileBtnId + '" class="fileadd"></div>');
    this.content.append('<iframe name="ifr" src="" style="display:none" width="1" height="1"></iframe>');
    this.addFileBtn = $('#' + this.addFileBtnId);
    if(this.urlArr.length>this.maxcount-1){
      this.addFileBtn.hide();
    }
    sortable.append(html.join(''));
    sortable.sortable();
    sortable.disableSelection();
    $('#' + this.preId + 'sortable li').removeClass("current");
    this.addItem();
  },
  upload:function(obj,n){
    var screeninp = $('#li'+n).find('[name=' + this.screenName + ']'); 
    if(screeninp.val()){
      screeninp.val('');
       $('#' + this.liId + n).find('.filethumb').remove();
    }
    $('#' + this.liId + n).find('.filename').html('载入中...');
    $('#' + this.liId + n).find('form').trigger('submit');
    var uploadStatus = $(obj).parent().parent();
    if(uploadStatus.hasClass("current")){
      uploadStatus.removeClass("current");
      this.addItem();
    }
  },
  setScreenshot:function(n,src,uploadInfo){
    if(src) {
      $('#' + this.liId + n).find('.filethumb-con').html('<img class="filethumb" src="'+src+'" width=' + this.imgWidth + ' height="' + this.imgHeight + '">');
      $('#' + this.liId + n).find('[name=' + this.screenName + ']').val(src);
    } else {
      $('#' + this.liId + n).find('.filename').html(uploadInfo);
    }
  },
  itemTemplete:function(i,imgsrc){
    var html = [];
    html.push('<li id="' + this.preId + 'li'+i+'" class="current">');
    html.push('<div class="filename"></div>');
    html.push('<div class="filethumb-con">');
    if(imgsrc) {html.push('<img class="filethumb" src="'+imgsrc+'" width="' + this.imgWidth + '" height="' + this.imgHeight + '">');}
    html.push('</div>');
    html.push('<input type="hidden" name="' + this.screenName + '" value="'+(imgsrc||'')+'">');
    html.push('<form action="'+this.action+'" target="ifr" method="post" enctype="multipart/form-data">');
    html.push('<input type="file" accept="image/*" name="'+this.preId+'screenshot'+i+'" class="file" size="28" onchange="'+this.self+'.upload(this,'+i+')">');
    html.push('<input type="hidden" name="index" value="'+i+'">');
    html.push('<input type="hidden" name="preId" value="'+this.preId+'">');
    html.push('<input type="hidden" name="instance" value="'+this.self+'">');
    html.push('<input type="hidden" name="method" value="setScreenshot">');
    html.push('<input type="hidden" name="userId" value="'+ this.userId +'" />');
    html.push('<input type="hidden" name="serviceToken" value="'+ this.serviceToken +'" />');
    html.push('</form>');
    html.push('<a class="filedel" href="#" onclick="'+this.self+'.delItem('+i+');return false;">删除</a>');
    html.push('</li>');
    return html.join('');
  },
  getItemCount:function(){
    return $('#' + this.preId + 'sortable li').length;
  },
  updateAddBtnStatus:function(){
    if(this.getItemCount()>=this.maxcount){
       this.addFileBtn.hide();
    } else {
       this.addFileBtn.show();
    }
  },
  addItem:function(){
    this.updateAddBtnStatus();
    if(this.getItemCount()<this.maxcount){
      this.sortable.append(this.itemTemplete(this.index++));
    }
  },
  delItem:function(n){
    $( "#" + this.preId + "li" +n ).remove();
    this.updateAddBtnStatus();
    if(!$('#' + this.preId + 'sortable li').hasClass("current")){
      this.addItem();
    }
  }
};