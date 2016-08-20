/*
 * MiuiMarket
 * Copyright xiaomi.com
 * path: categorySelect.js
 * author: jiaguang
 * version: 1.1.0
 * date: 2012/6/13
 */
/**
 * 市场应用级联下拉列表
 * @param {jsonObject} level1Category
 * @param {jsonObject} level2Category
 * @param {string} 容器
 */
function CategorySelect(){
  var args = Array.prototype.slice.call( arguments );
  this.l0json = args[0],this.l1json = args[1],this.con = $('#'+args[2]);
  this.init.apply(this,arguments);
}
CategorySelect.prototype = {
  init:function(){
    var s0 = document.createElement('select');
    s0.id='s0';
    s0.name='level1CategoryId';
    s0.className = 'span2';
    var len = this.l0json.length;
    s0.add(new Option('请选择应用分类',-1));
    for(var i =0; i <len; i++ ){
     s0.add(new Option(this.l0json[i]['name'],this.l0json[i]['id']));
    };
    this.con.append(s0);
    this.s0 = $(s0);
    var me = this;
    $(s0).on('change',function(){
      me.createNextSel($(this).val());
    });
    this.createNextSel(this.l0json[0]['id']);
  },
  createNextSel:function(num){
    if($('#s1').length) {$('#s1').remove();};
    var s1 = document.createElement('select');
    s1.id = 's1';
    s1.name='level2CategoryId';
    s1.className = 'span2';
    var id = 'cat-'+num;
    var child = this.l1json[id];
    if (!child || !child.length){ return; };
    for(var i=0;i<child.length;i++){
       s1.add( new Option(child[i]['name'],child[i]['id']));
    };
    this.con.append(s1);
    this.s1 = $(s1);
  },
  setValue:function(m,n){
    m && this.s0.val(m);
    this.createNextSel(m);
    n && this.s1.val(n);
  },
  setValueText:function(m,n){
    this.setValue(m,n);
    var str = this.s0.find("option:selected").text();
    if(n) {
      str +=','+this.s1.find("option:selected").text();
    }
    this.con.html(str);
  }
}