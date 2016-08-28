<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=360,user-scalable=no">
<title>appstore</title>
<style>
body,
ul,
h1,
h2,
h3,
p,
dl,
dd,
dt,
button {
  margin: 0;
  padding: 0;
  list-style: none;
}
body {
  font: 14px/1.5 "Hiragino Sans GB", "Microsoft YaHei", "WenQuanYi Micro Hei", sans-serif;
  color: #4a4a4a;
  background: #f8f8f8;
  -webkit-user-select: none;
}
h1 {
  font-size: 18px;
}
h2 {
  font-size: 16px;
}
h3 {
  font-size: 14px;
}
ul,
li {
  list-style: none;
}
input,
button {
  -webkit-tap-highlight-color: rgba(0, 0, 0, 0);
  -webkit-touch-callout: none;
  outline: none;
}
html,
body {
  -webkit-text-size-adjust: 100%;
}
a {
  color: #3f6eb1;
  text-decoration: none;
  -webkit-tap-highlight-color: rgba(0, 0, 0, 0);
}
.cf {
  *zoom: 1;
}
.cf:before,
.cf:after {
  display: table;
  content: "";
}
.cf:after {
  clear: both;
}
.hide {
  display: none;
}
.show{
  display: block;
}
.fl {
  float: left;
}
.fr {
  float: right;
}
.orange {
  color: #fb7c16;
}
.warn {
  color: #d70014;
}
.gray9 {
  color: #999;
}
.gray6 {
  color: #666;
}
.cen {
  text-align: center;
}
.side-blur{
  position: relative;
}
.side-blur:after {
  position: absolute;
  top: 0;
  right: 0;
  content: "";
  display: block;
  width: 12px;
  height: 100%;
  box-shadow: inset -5px 0 20px white;
}
.ellipsis{
  overflow: hidden; 
  text-overflow: ellipsis;
  white-space: nowrap;
}

.lazyload{
  opacity: 0;
  transition:opacity 1s ease;
}
.lazyload-show{
  opacity: 1;
}
.applist{
  background: #f8f8f8;
}

.applist li {
  position: relative;
  z-index: 0;
}

.applist-img{
  display: inline-block;
  background: url(app-list-placeholder.png);
  background-size: contain;
}
.applist-img img {
  border-radius: 8px;
  display: inline-block;
  vertical-align: middle;
}

.applist-wrap {
  margin: 0 12px;
  padding: 7px 60px 7px 0;
  background-image:linear-gradient(180deg, #f8f8f8, #f8f8f8 67%, #d3d3d3 67%);
  background-size: 100% 1px;
  background-repeat: no-repeat;
  background-position: bottom;
}

.applist-wrap-des {
  display: inline-block;
  width: 206px;
  vertical-align: middle;
  min-height: 56px;
  margin-left: 14px;
}
.applist h3 {
  color: #333333;
  font-weight: 400;
  font-size: 14px;
  padding: 2px 0;
  width: 100%;
}

.applist p {
  color: #8c8c8c;
  font-size: 12px;
  margin-top: 3px;
}

.applist-btn {
  position: absolute;
  z-index: 0;
  top: 50%;
  margin-top: -15.5px;
  right: 12px;
  font-size: 11px;
  line-height: 2.6;
  width: 50px;
  text-align: center;
  vertical-align: middle;
  color: #4b8d0e;
  background: none;
  border: none;
}
.applist-btn:before{
  content: "";
  display: block;
  position: absolute;
  z-index: -1;
  left: 0;
  top: 0;
  border-radius: 12px;
  border: 2px solid #E0E0E0;
  width: calc(300% - 4px);
  height: calc(300% - 4px);
  -webkit-transform: scale(0.33);
  -webkit-transform-origin:0 0;
  transform: scale(0.33);
  transform-origin:0 0;
}
.applist-btn:active:before {
  background-color: #ececec;
}
.applist-btn[disabled]:active:before {
  background: none;
}

.applist-btn[disabled], .applist-btn[disabled]:before {
  border: none;
  color: #b1b1b1;
}

.applist-ad{
  position: relative;
  padding: 1px 3px;
  font-size: 9px;
  vertical-align: middle;
}
.applist-ad:before{
  content: "";
  display: block;
  position: absolute;
  z-index: -1;
  left: 0;
  top: 0;
  border-radius: 9px;
  border: 2px solid #E0E0E0;
  width: calc(300% - 4px);
  height: calc(300% - 4px);
  -webkit-transform: scale(0.33);
  -webkit-transform-origin:0 0;
  transform: scale(0.33);
  transform-origin:0 0;
}

.icon-star, .icon-star-light{
  background-image: url(img/star.combine.png);
}
.icon-star {
  background-repeat: repeat-x;
  background-size: auto 20px;
  width: 70px;
  height: 10px;
  background-position: 0 -10px;
}
.icon-star-light {
  background-position: 0 0;
}
.icon-star0 .icon-star-light {
  width: 0;
}
.icon-star1 .icon-star-light {
  width: 5px;
}
.icon-star2 .icon-star-light {
  width: 10px;
}
.icon-star3 .icon-star-light {
  width: 20px;
}
.icon-star4 .icon-star-light {
  width: 28px;
}
.icon-star5 .icon-star-light {
  width: 35px;
}
.icon-star6 .icon-star-light {
  width: 42px;
}
.icon-star7 .icon-star-light {
  width: 50px;
}
.icon-star8 .icon-star-light {
  width: 56px;
}
.icon-star9 .icon-star-light {
  width: 65px;
}
.icon-star10 .icon-star-light {
  width: 100%;
}
</style>
<style>
.article-header, .article-banner, .article-context {
    margin: 0 12px;
  background-image:linear-gradient(180deg, #f8f8f8, #f8f8f8 70%, #d3d3d3 70%);
  background-size: 100% 1px;
  background-repeat: no-repeat;
  background-position: bottom;
}
.article-header {
    margin-top: 12px;
    padding-bottom: 10px;
}
.article-title {
    color: #4a4a4a;
    font-size: 14px;
}
.article-info {
    position: relative;
    color: #8c8c8c;
    font-size: 10px;
    height: 15px;
}
.article-info img {
    vertical-align: middle;
}
.article-info .article-type {
    position: relative;
    top: 1px;
    display: inline-block;
    vertical-align: middle;
    margin-left: 4px;
}
.article-info .article-time {
    position: absolute;
    top: 1px;
    right: 0;
}
.article-banner {
    padding: 13px 0;
}
.article-banner img {
    border-radius: 8px;
    vertical-align: middle;
}
.article-context {
    padding: 9px 0;
}
.article-context img {
    max-width: 336px;
}
.article-author {
    margin: 9px 12px;
    font-size: 12px;
}
</style>
</head>
<body>
<header class="article-header">
    <h3 class="article-title">${article.title}</h3>
    <div class="article-info"><img src="<#if media.name??>${media.phoneIcon}</#if>" width="15" height="15"><span class="article-type"><#if media.name??>${media.name}</#if></span><span class="article-time"><#if articleTime??>${articleTime}</#if></span></div>
</header>
<#if article.banner?? && article.banner !=''>
<div class="article-banner">
    <img src="${article.banner}" width="336" height="128">
</div>
</#if>
<#if appInfo.icon??>
<ul class="applist">
    <li>
      <div class="applist-wrap">
        <div class="applist-img"><img src="${appInfo.icon}" width="56" height="56"></div><div class="applist-wrap-des">
          <h3 class="ellipsis">${appInfo.displayName}</h3>
          <div class="icon-star icon-star4.5">
            <div class="icon-star icon-star-light"></div>
          </div>
          <p>生活 11M 
          </p>
        </div>
      </div>
      <div class="touch" data-index="{{0}}" data-pname="${article.packageName}"  data-digest="${apkInfo.apkHash}"><div class="touch-active"></div></div>
      <button type="button" class="applist-btn"  data-pname="${article.packageName}" data-appid="${appInfo.appId}" data-disabled="{{false}}" data-installed="" data-index="{{0}}" data-digest="{{digest}}">安装</button>
    </li>
</ul>
</#if>
<div class="article-context">${article.content}</div>
<#if article.author??>
<div class="article-author">${article.author}</div>
</#if>
</body>
</html>