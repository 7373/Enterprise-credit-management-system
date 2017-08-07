;(function ($, window, document, undefined) {

    var pluginName = "metisMenu",
        defaults = {
            toggle: true
        };

    function Plugin(element, options) {
        this.element = element;
        this.settings = $.extend({}, defaults, options);
        this.init();
    }

    Plugin.prototype = {
        init: function () {

            var $this = $(this.element),
                $toggle = this.settings.toggle;

            $this.find('li.active').has('ul').children('ul').toggleClass('metis-open');
            $this.find('li').not('.active').has('ul').children('ul').toggleClass('metis-close');

            $this.find('li').has('ul').children('a').on('click', function (e) {
                e.preventDefault();
                $(this).parent('li').toggleClass('active').children('ul').slideToggle('.swing',function(){$(".nano") &&  setTimeout(function(){
                    $(".nano").nanoScroller();
                },200);}).toggleClass('metis-close').toggleClass('metis-open');
                if ($toggle) {
                    $(this).parent('li').siblings().removeClass('active').children('ul.metis-open').slideUp().toggleClass('metis-open').toggleClass('metis-close');
                }
            });
        }
    };

    $.fn[ pluginName ] = function (options) {
        return this.each(function () {
            if (!$.data(this, "plugin_" + pluginName)) {
                $.data(this, "plugin_" + pluginName, new Plugin(this, options));
            }
        });
    };

})(jQuery, window, document);