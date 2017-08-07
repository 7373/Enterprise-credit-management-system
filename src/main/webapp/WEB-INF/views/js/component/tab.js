(function (factory) {
    if (typeof define == 'function' && define.amd) {
        define(['jquery'], function () {
            factory($, window, document);
        })
    } else {
        factory($, window, document);
    }
}(function ($, window, document) {
    var defaultOptions = {
        trigger: "click",
        autoChange: false,
        timeout: 3000,
        context: null,
        contain:'',
        onInit: function () {
        },
        onBeforeSwitch: function (prevItem, currItem) {
            return true;
        },
        onShowTab: function (prevItem, currItem) {
        }
    };

    var $doc = $(document);

    var Tab = function (el, options) {
        this.options = $.extend({}, defaultOptions, options || {});
        this.el = el;
        this.init();
        this.bind();
    }
    var fn = Tab.prototype;
    fn.init = function () {
        var children = this.el.children();
        var tabHeader = children.closest(".tab-header");
        var tabContent = children.closest(".tab-content");
        this.tabItems = tabHeader.find(".tab-item");
        var tabPanels = tabContent.children();
        var tabs = [];
        for (var i = 0, l = this.tabItems.length; i < l; i++) {
            var tabItem = this.tabItems.eq(i);
            var tabPanel = tabPanels.eq(i);
            var item = {
                tab: tabItem,
                panel: tabPanel,
                index: i
            };
            if (tabItem.parent().hasClass("tab-selected")) {
                this.currentTab = item;
                tabPanel.addClass("tab-panel-show");
            }
            tabs[i] = item;
            tabItem.data("data-index", i);
        }
        this.tabs = tabs;
        if (!this.currentTab && this.tabs.length) {
            var item = tabs[0];
            item.tab.parent().addClass("tab-selected");
            item.panel.addClass("tab-panel-show");
            this.currentTab = item;
        }
        if (this.tabs.length) {
            var options = this.options;
            options.onInit.call(this);
        }
    }
    fn.bind = function (type) {
        //需要修改成委托的方式
        type = type || "on";
        var options = this.options;
        var me = this;
        this.tabItems[type](options.trigger, function (event) {
            if(options.contain === 'input'){
                event.target.nodeName.toLocaleLowerCase() === 'input' && me.setTab(event);
                return;
            }
            me.setTab(event);
        });
        if (options.autoChange && this.tabs.length > 1) {
            this.el[type]("mouseover", function (event) {
                me.stopChangeTab();
            });
            this.el[type]("mouseout", function (event) {
                me.playTab();
            });
            if (type == "on") this.playTab();
        }
    }
    fn.playTab = function () {
        var options = this.options;
        var me = this;
        var l = this.tabs.length;
        this.changeId = setInterval(function () {
            var index = me.currentTab.index;
            index++;
            if (index > (l - 1)) {
                index = 0;
            }
            me.showTab(index);
        }, options.timeout);
    }
    fn.stopChangeTab = function () {
        clearInterval(this.changeId);
    }
    fn.setTab = function (event) {
        var target = event.target;
        var reg = new RegExp("tab-item","g");
        while (!reg.test(target.className))
            target = target.parentNode;
        var tab = $(target);
        var index = tab.data("data-index");
        this.showTab(index);
    }
    fn.showTab = function (index) {
        if (this.currentTab.index == index) return;
        var options = this.options;
        var context = options.context || this;
        var item = this.tabs[index];
        if (!options.onBeforeSwitch.call(context, this.currentTab, item)) {
            return;
        }
        this.hideCurrentTab();
        item.tab.parent().addClass("tab-selected");
        item.panel.addClass("tab-panel-show");
        var prevItem = this.tabs[this.currentTab.index];
        options.onShowTab.call(context, this.currentTab, item);
        this.currentTab = item;
    }
    fn.hideCurrentTab = function () {
        var item = this.currentTab;
        item.tab.parent().removeClass("tab-selected");
        item.panel.removeClass("tab-panel-show");
    }
    fn.dispose = function () {
        delete this.tabItems;
        delete this.tabs;
        this.bind("off");
    }

    function getCallback(func) {
        if ($.type(func) == 'string') {
            if (func.indexOf('.') == -1)
                return func = w[func];
            var ns = func.split('.');
            var name = w[ns.shift()];
            while (ns.length) {
                name = name[ns.shift()];
            }
            return name;
        }
        return func;
    }

    function readOptions(el) {
        var options = {};
        var config = [];
        for (var n in defaultOptions) {
            n = n.replace(/([A-Z])/g, "-$1").toLowerCase();
            config.push(n);
        }
        for (var i = 0, l = config.length; i < l; i++) {
            var n = config[i];
            var an = "data-" + n;
            if (n.indexOf('-') != -1) {
                n = (n.split('-')).map(function (v, i) {
                    if (i == 0) return v;
                    return v.charAt(0).toUpperCase() + v.substring(1, v.length);
                }).join('');
            }
            var val = el.attr(an);
            if (val) {
                if (val == "false") {
                    val = false;
                }
                else if (n.substr(0, 2) == "on") {
                    val = getCallback(val);
                }
                options[n] = val;
            }
        }
        return options;
    }

    if (!Array.prototype.map) {
        Array.prototype.map = function (f, oThis) {
            if (!f || f.constructor != Function.toString()) return;
            oThis = oThis || window;
            var a = [];
            for (var i = 0, len = this.length; i < len; i++) {
                a.push(f.call(oThis, this[i], i, this));
            }
            return a;
        }
    }

    function init(context) {
        var selector = '[data-component="tab"]';
        context.find(selector).each(function () {
            var el = $(this);
            var options = readOptions(el);
            el.data("tab", new Tab(el, options));
        });
    }

    Tab.init = init;
    $(function () {
        $doc = $(document);
        init($doc);
    });
    window.Tab = Tab;
}));