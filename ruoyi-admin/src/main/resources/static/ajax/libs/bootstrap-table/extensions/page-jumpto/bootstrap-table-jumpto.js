/**
 * @author Jay <jwang@dizsoft.com>
 */

(function ($) {
    'use strict';
    var sprintf = $.fn.bootstrapTable.utils.sprintf;

    $.extend($.fn.bootstrapTable.defaults, {
        showJumpto: false,
        exportOptions: {}
    });

    $.extend($.fn.bootstrapTable.locales, {
        formatJumpto: function () {
            return '跳转到';
        }
    });
    $.extend($.fn.bootstrapTable.defaults, $.fn.bootstrapTable.locales);

    var BootstrapTable = $.fn.bootstrapTable.Constructor,
        _initPagination = BootstrapTable.prototype.initPagination;

    BootstrapTable.prototype.initPagination = function () {
        _initPagination.apply(this, Array.prototype.slice.apply(arguments));

        if (this.options.showJumpto) {
            var that = this,
                $pageGroup = this.$pagination.find('ul.pagination'),
                $jumpto = $pageGroup.find('li.jumpto');

            if (!$jumpto.length) {
                $jumpto = $([
                    '<li class="jumpto">',
                        '<input type="text" class="form-control">',
                        '<button class="btn' +
                            sprintf(' btn-%s', this.options.buttonsClass) +
                            sprintf(' btn-%s', this.options.iconSize) +
                            '" title="' + this.options.formatJumpto() + '" ' +
                            ' type="button">'+this.options.formatJumpto(),
                        '</button>',
                    '</li>'].join('')).appendTo($pageGroup);

                $jumpto.find('button').click(function () {
                    var page=parseInt($jumpto.find('input').val())||1;
                    if(page<1||page>that.options.totalPages){
                        page=1;
                    }
                    that.selectPage(page);
                });
            }
        }
    };
})(jQuery);