function HdIconUpload(opts) {
    this.self = opts.self;
    this.url = opts.url || "";
    this.imgSize = opts.imgSize || 90;
    this.content = $("#" + opts.content);
    this.action = opts.action;
    this.failed = $("#" + opts.failed || "");
    this.formInput = $("#" + opts.formInput || "");
    this.userId = opts.userId || "";
    this.serviceToken = opts.serviceToken || "";
    this.delBtn = $('<a class="filedel" style="display:none" href="javascript:" >删除</a>');
    this.uploadBtnHtml = '<input onchange="' + this.self + '.upload()" type="file" name="pic" class="btn-file J-hdiconUploadBtn" size="1" accept="image/png" />';
    this.uploadBtn = $(this.uploadBtnHtml);
    if (!opts.removeMask) {
        this.iconBase = "http://i1.ml.mi-img.com/img/miui/appstore/dev/v2/icon_mast_" + this.imgSize.toString() + "_white.png";
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
        if (this.url) {
            this.addItem(this.url);
        }
        this.delBtn.click(function() {
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
        html.push('<input type="hidden" name="userId" value="' + this.userId + '" />');
        html.push('<input type="hidden" name="serviceToken" value="' + this.serviceToken + '" />');
        html.push("</form>");
        return html.join("");
    },
    addItem: function(imgUrl) {
        if (this.removeMask) {
            this.uploadImg.prop("src", imgUrl).show();
        } else {
            this.uploadImg.css({
                "background-image": "url(" + imgUrl + ")",
                "background-repeat": "no-repeat",
                display: "inline-block"
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

function browseUpgradeTip() {
    if (window.ActiveXObject) {
        var ua = navigator.userAgent.toLowerCase();
        var ie = ua.match(/msie ([5-9]+)/);
        if (ie) {
            var message = "<strong>抱歉！</strong> 本网站不支持IE10 以下的浏览器，为了获得更快、更安全的浏览体验，我们建议您使用 <a href='http://www.google.cn/intl/zh-CN/chrome/browser/' target='_blank'>chrome</a>！或者<a href='http://firefox.com.cn/' target='_blank'>火狐</a>浏览器";
            var div = document.createElement("div");
            div.innerHTML = message;
            div.style.color = "#474747";
            div.style.background = "#FCF8E3";
            div.style.border = "1px solid #FBEED5";
            div.style.padding = "8px 35px 8px 14px";
            div.style.lineHeight = "25px";
            div.style.textAlign = "center";
            var wrap = document.body;
            wrap.insertBefore(div, wrap.firstChild);
        }
    }
}

var dialog = function() {
    $.fn.modal.Constructor.prototype.enforceFocus = function() {};
    return {
        alert: function(options) {
            var _option = {
                title: "信息",
                content: "操作执行成功！",
                hiddenCallback: function() {},
                hideCallback: function() {},
                shownCallback: function() {},
                btn: "确定",
                isRemoveDom: true,
                closeBtn: false
            };
            $.extend(_option, options);
            if ($("#dialogAlert").length === 0) {
                var str = [];
                str.push('<div id="dialogAlert" class="modal hide fade" tabindex="-1"><div class="modal-header">');
                _option.closeBtn && str.push('<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>');
                str.push('<h3 id="alertTitle">');
                str.push(_option.title);
                str.push('</h3></div><div class="modal-body">');
                str.push(_option.content);
                str.push('</div><div class="modal-footer"><button class="btn-orange" id="dialogAlertConfirm" data-dismiss="modal" aria-hidden="true">');
                str.push(_option.btn);
                str.push("</button></div></div>");
                var domStr = str.join("");
                $("body").append(domStr);
            }
            var dialogDom = $("#dialogAlert");
            dialogDom.modal({
                keyboard: false,
                backdrop: "static"
            });
            dialogDom.on("hidden.dialogAlert", function() {
                dialogDom.off("hidden.dialogAlert");
                if (_option.isRemoveDom) {
                    dialogDom.remove();
                }
                _option.hiddenCallback();
            });
            dialogDom.on("hide.dialogAlert", function() {
                dialogDom.off("hide.dialogAlert");
                _option.hideCallback();
            });
            dialogDom.on("shown.dialogAlert", function() {
                dialogDom.off("shown.dialogAlert");
                _option.shownCallback();
            });
        },
        confirm: function(options) {
            console.log(options);
            var _option = {
                title: "信息",
                content: "确定执行操作？",
                hiddenCallback: function() {},
                hideCallback: function() {},
                confirmBtn: "确定",
                cancelBtn: "取消",
                confirmCb: function() {
                    return true;
                },
                cancelCb: function() {}
            };
            $.extend(_option, options);
            if ($("#dialogConfirm").length === 0) {
                var str = [];
                str.push('<div id="dialogConfirm" class="modal hide fade" tabindex="-1"><div class="modal-header"><h3 id="alertTitle">');
                str.push(_option.title);
                str.push('</h3></div><div class="modal-body">');
                str.push(_option.content);
                str.push('</div><div class="modal-footer"><button class="btn-orange" id="dialogConfirmBtn">');
                str.push(_option.confirmBtn);
                str.push('</button><button id="cancelBtn" class="btn-gray"  data-dismiss="modal" aria-hidden="true">');
                str.push(_option.cancelBtn);
                str.push("</button></div></div>");
                var domStr = str.join("");
                $("body").append(domStr);
            }
            var dialogDom = $("#dialogConfirm");
            dialogDom.modal({
                keyboard: false,
                backdrop: "static"
            });
            dialogDom.on("hidden.dialogConfirm", function() {
                _option.hiddenCallback();
                dialogDom.remove();
            });
            dialogDom.on("hide.dialogConfirm", function() {
                _option.hideCallback();
                dialogDom.off("hide.dialogConfirm");
                dialogDom.off("click");
            });
            dialogDom.on("click.dialogConfirm", "#dialogConfirmBtn", function() {
                if (_option.confirmCb()) {
                    dialogDom.modal("hide");
                }
            });
            dialogDom.on("click.cancel", "#cancelBtn", function() {
                dialogDom.off("click.cancel");
                _option.cancelCb();
            });
        },
        promptSuccess: function(options) {
            var _option = {
                content: "成功！",
                closeTime: 3e3,
                closeCallback: function() {}
            };
            $.extend(_option, options);
            if ($("#promptSuccess").length === 0) {
                var str = [];
                str.push('<div id="promptSuccess" class="prompt-success modal hide" tabindex="-1"><div class="modal-body"><p id="promptSuccessCon" class=" prompt-p">');
                str.push(_option.content);
                str.push("</p></div></div>");
                var domStr = str.join("");
                $("body").append(domStr);
            }
            var dialogDom = $("#promptSuccess");
            dialogDom.modal({
                keyboard: false,
                backdrop: false
            });
            setTimeout(function() {
                dialogDom.modal("hide");
            }, _option.closeTime);
            dialogDom.on("hidden.promptSuccess", function() {
                dialogDom.off("hidden.promptSuccess");
                _option.closeCallback();
                dialogDom.remove();
            });
        },
        promptFail: function(options) {
            var _option = {
                content: "失败！",
                closeTime: 3e3,
                closeCallback: function() {}
            };
            $.extend(_option, options);
            if ($("#promptFail").length === 0) {
                var str = [];
                str.push('<div id="promptFail" class="prompt-fail modal hide" tabindex="-1"><div class="modal-body"><p id="promptFailCon" class=" prompt-p">');
                str.push(_option.content);
                str.push("</p></div></div>");
                var domStr = str.join("");
                $("body").append(domStr);
            }
            var dialogDom = $("#promptFail");
            dialogDom.modal({
                keyboard: false,
                backdrop: false
            });
            setTimeout(function() {
                dialogDom.modal("hide");
            }, _option.closeTime);
            dialogDom.on("hidden.promptFail", function() {
                dialogDom.off("hidden.promptFail");
                dialogDom.remove();
                _option.closeCallback();
            });
        },
        promptText: function(options) {
            var _option = {
                content: "正在提交...",
                closeTime: 3e3,
                closeCallback: function() {}
            };
            $.extend(_option, options);
            if ($("#promptText").length === 0) {
                var str = [];
                str.push('<div id="promptText" class="prompt-text modal hide" tabindex="-1"><div class="modal-body"><p id="promptTextCon" class=" prompt-p">');
                str.push(_option.content);
                str.push("</p></div></div>");
                var domStr = str.join("");
                $("body").append(domStr);
            }
            var dialogDom = $("#promptText");
            dialogDom.modal({
                keyboard: false,
                backdrop: false
            });
            setTimeout(function() {
                dialogDom.modal("hide");
            }, _option.closeTime);
            dialogDom.on("hidden.promptText", function() {
                dialogDom.off("hidden.promptText");
                dialogDom.remove();
                _option.closeCallback();
            });
        }
    };
}();

$(function() {
    browseUpgradeTip();
});

var resumableUpload = function(opts) {
    this.container = opts.container || "";
    this.uploadTip = opts.uploadTip || "";
    this.uploadTarget = opts.uploadTarget || "";
    this.checkUploadStatusUrl = opts.checkUploadStatusUrl || "/checkFileUploadResult";
    this.uploadBtn = opts.uploadBtn || "";
    this.succeedCb = opts.succeedCb || function() {};
    this.query = opts.query || {};
    this.notSupportCb = opts.notSupportCb || function() {};
    this.isCancel;
    this.resumable;
    this.itv = false;
    this.init();
};

resumableUpload.prototype = {
    init: function() {
        var _self = this;
        var container = $(this.container);
        var uploadTip = $(this.uploadTip);
        var uploadBtn = $(this.uploadBtn);
        var uniqueIdentifier, fileName;
        var resumable = this.resumable = new Resumable({
            target: _self.uploadTarget,
            chunkSize: 1 * 1024 * 1024,
            simultaneousUploads: 4,
            testChunks: true,
            method: "octet",
            query: this.query
        });
        if (!resumable.support) {
            uploadTip.append('<p class="upload-error">抱歉，你的浏览器不支持大数据包上传，请使用最新的chrome浏览器</p>');
            this.notSupportCb();
            return false;
        }
        var uploadAction = $('<div style="display:inline-block;"></div>');
        var uploadName = $("<span></span>");
        var delBtn = $('<a href="javascript:;" class="delBtn" style="margin-left:6px;">删除</a>');
        uploadAction.append(uploadName, delBtn);
        var progressWrap = $('<div style="display:inline-block;"></div>');
        var progressBar = $('<div class="progress-bar"></div>');
        var progressBarInner = $('<div class="progress-bar-inner"></div>');
        var progressDesc = $('<div class="progress-desc"></div>');
        var cancelBtn = $('<a href="javascript:;">取消</a>');
        progressWrap.append(progressBar.append(progressBarInner), progressDesc, cancelBtn);
        container.append(uploadAction, progressWrap);
        resumable.assignBrowse(uploadBtn);
        var resetUi = function() {
            uploadBtn.show();
            uploadAction.hide();
            progressWrap.hide();
            progressBarInner.css({
                width: 0
            });
            uploadBtn.data("md5", "");
            uploadBtn.data("fileName", "");
        };
        resetUi();
        resumable.on("fileAdded", function(file, e) {
            console.log("add");
            uploadBtn.hide();
            uploadAction.hide();
            progressWrap.show();
            $(".resumbleUploadError").remove();
            _self.isCancel = false;
            var iptFile = file.file;
            var fileReader = new FileReader(), blobSlice = File.prototype.mozSlice || File.prototype.webkitSlice || File.prototype.slice, chunkSize = 2097152, chunks = Math.ceil(iptFile.size / chunkSize), currentChunk = 0, spark = new SparkMD5();
            var loadNext = function() {
                var start = currentChunk * chunkSize, end = start + chunkSize >= iptFile.size ? iptFile.size : start + chunkSize;
                fileReader.readAsBinaryString(blobSlice.call(iptFile, start, end));
            };
            fileReader.onload = function(e) {
                var analysis = Math.ceil((currentChunk + 1) / chunks * 100);
                console.log(analysis);
                progressDesc.empty().append("正在扫描文件" + analysis + "/100%");
                spark.appendBinary(e.target.result);
                currentChunk++;
                if (!_self.isCancel) {
                    cancelBtn.show();
                    if (currentChunk < chunks) {
                        loadNext();
                    } else {
                        uniqueIdentifier = file.uniqueIdentifier = spark.end();
                        progressDesc.empty().append("<div>正在上传</div>");
                        resumable.upload();
                    }
                }
            };
            loadNext();
        });
        resumable.on("complete", function() {
            console.log("complete");
        });
        resumable.on("fileSuccess", function(file, message) {
            console.log("success");
            fileName = file.fileName;
            _self.itv = setInterval(function() {
                $.ajax({
                    url: _self.checkUploadStatusUrl,
                    dataType: "json",
                    data: {
                        resumableIdentifier: uniqueIdentifier,
                        userId: _self.query.userId
                    },
                    success: function(msg) {
                        switch (msg.code) {
                          case -3:
                            progressDesc.html("MD5值为空");
                            break;

                          case -1:
                            progressDesc.html("上传失败");
                            progressBarInner.css({
                                width: 0
                            });
                            break;

                          case -4:
                            console.log("遗失文件片段:", msg);
                            $(_self.uploadBtn).after('<span class="error resumbleUploadError"> (服务器出现问题，请重新上传)</span>');
                            _self.cancelUpload();
                            resetUi();
                            break;

                          case 1:
                            console.log("处理完成");
                            uploadName.html(fileName);
                            progressWrap.hide();
                            progressBarInner.css({
                                width: 0
                            });
                            uploadAction.show();
                            _self.succeedCb(resumable, uniqueIdentifier);
                            $(_self.uploadBtn).data("md5", uniqueIdentifier);
                            $(_self.uploadBtn).data("fileName", fileName);
                            clearInterval(_self.itv);
                            break;

                          default:
                            console.log("正在处理文件");
                            console.log(msg.progressate);
                            progressDesc.html("正在处理文件：" + Math.floor(msg.progressate * 100) + "%");
                            break;
                        }
                    }
                });
            }, 1e3);
        });
        resumable.on("fileError", function(file, message) {
            progressDesc.html("( 上传失败: " + message + ")");
        });
        resumable.on("fileProgress", function(file) {
            progressDesc.html(Math.floor(file.progress() * 100) + "%");
            progressBarInner.css({
                width: Math.floor(resumable.progress() * 100) + "%"
            });
        });
        cancelBtn.on("click", function() {
            _self.cancelUpload();
            resetUi();
        });
        delBtn.on("click", function() {
            resetUi();
        });
    },
    cancelUpload: function() {
        this.isCancel = true;
        this.resumable.cancel();
        if (!!this.itv) {
            clearInterval(this.itv);
        }
    }
};

function ScreenshotUpload(opts) {
    this.urlArr = opts.urls || [];
    this.maxcount = opts.maxcount || 5;
    this.self = opts.self;
    this.content = $("#" + opts.content);
    this.index = this.urlArr.length;
    this.action = opts.action;
    this.userId = opts.userId || "";
    this.serviceToken = opts.serviceToken || "";
    this.preId = opts.preId || "";
    this.sortableId = this.preId + "sortable";
    this.addFileBtnId = this.preId + "addFileBtn";
    this.liId = this.preId + "li";
    this.screenName = opts.screenName || "screen";
    this.imgWidth = opts.imgWidth || 100;
    this.imgHeight = opts.imgHeight || "";
    this.init();
}

ScreenshotUpload.prototype = {
    init: function() {
        var html = [];
        for (var i = 0; i < this.urlArr.length; i++) {
            html.push(this.itemTemplete(i, this.urlArr[i]));
        }
        this.content.append('<ul id="' + this.sortableId + '" class="screenshot-sortable"></ul>');
        var sortable = this.sortable = $("#" + this.sortableId);
        sortable.append('<div id="' + this.addFileBtnId + '" class="fileadd"></div>');
        this.content.append('<iframe name="ifr" src="" style="display:none" width="1" height="1"></iframe>');
        this.addFileBtn = $("#" + this.addFileBtnId);
        if (this.urlArr.length > this.maxcount - 1) {
            this.addFileBtn.hide();
        }
        sortable.append(html.join(""));
        sortable.sortable();
        sortable.disableSelection();
        $("#" + this.preId + "sortable li").removeClass("current");
        this.addItem();
    },
    upload: function(obj, n) {
        var screeninp = $("#li" + n).find("[name=" + this.screenName + "]");
        if (screeninp.val()) {
            screeninp.val("");
            $("#" + this.liId + n).find(".filethumb").remove();
        }
        $("#" + this.liId + n).find(".filename").html("载入中...");
        $("#" + this.liId + n).find("form").trigger("submit");
        var uploadStatus = $(obj).parent().parent();
        if (uploadStatus.hasClass("current")) {
            uploadStatus.removeClass("current");
            this.addItem();
        }
    },
    setScreenshot: function(n, src, uploadInfo) {
        if (src) {
            $("#" + this.liId + n).find(".filethumb-con").html('<img class="filethumb" src="' + src + '" width=' + this.imgWidth + ' height="' + this.imgHeight + '">');
            $("#" + this.liId + n).find("[name=" + this.screenName + "]").val(src);
        } else {
            $("#" + this.liId + n).find(".filename").html(uploadInfo);
        }
    },
    itemTemplete: function(i, imgsrc) {
        var html = [];
        html.push('<li id="' + this.preId + "li" + i + '" class="current">');
        html.push('<div class="filename"></div>');
        html.push('<div class="filethumb-con">');
        if (imgsrc) {
            html.push('<img class="filethumb" src="' + imgsrc + '" width="' + this.imgWidth + '" height="' + this.imgHeight + '">');
        }
        html.push("</div>");
        html.push('<input type="hidden" name="' + this.screenName + '" value="' + (imgsrc || "") + '">');
        html.push('<form action="' + this.action + '" target="ifr" method="post" enctype="multipart/form-data">');
        html.push('<input type="file" accept="image/*" name="' + this.preId + "screenshot" + i + '" class="file" size="28" onchange="' + this.self + ".upload(this," + i + ')">');
        html.push('<input type="hidden" name="index" value="' + i + '">');
        html.push('<input type="hidden" name="preId" value="' + this.preId + '">');
        html.push('<input type="hidden" name="instance" value="' + this.self + '">');
        html.push('<input type="hidden" name="method" value="setScreenshot">');
        html.push('<input type="hidden" name="userId" value="' + this.userId + '" />');
        html.push('<input type="hidden" name="serviceToken" value="' + this.serviceToken + '" />');
        html.push("</form>");
        html.push('<a class="filedel" href="#" onclick="' + this.self + ".delItem(" + i + ');return false;">删除</a>');
        html.push("</li>");
        return html.join("");
    },
    getItemCount: function() {
        return $("#" + this.preId + "sortable li").length;
    },
    updateAddBtnStatus: function() {
        if (this.getItemCount() >= this.maxcount) {
            this.addFileBtn.hide();
        } else {
            this.addFileBtn.show();
        }
    },
    addItem: function() {
        this.updateAddBtnStatus();
        if (this.getItemCount() < this.maxcount) {
            this.sortable.append(this.itemTemplete(this.index++));
        }
    },
    delItem: function(n) {
        $("#" + this.preId + "li" + n).remove();
        this.updateAddBtnStatus();
        if (!$("#" + this.preId + "sortable li").hasClass("current")) {
            this.addItem();
        }
    }
};