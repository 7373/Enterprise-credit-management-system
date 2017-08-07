define(['jquery', 'jquery.validate'], function () {

    /**
     * 必填描述
     */
    $.extend($.validator.messages, {
        required: "请输入信息",
        url: "请输入正确的网站/网店的网址,如：http://www.baidu.com,</br>https://www.baidu.com",
        email:"请输入正确的邮箱格式",
        remote: "请修正此字段",
        date: "请输入有效的日期",
        dateISO: "请输入有效的日期 (YYYY-MM-DD)",
        number: "请输入有效的数字",
        digits: "必须输入整数",
        creditcard: "请输入有效的信用卡号码",
        equalTo: "你的输入不相同",
        extension: "请输入有效的后缀",
        maxlength: $.validator.format("最多可以输入 {0} 个字符"),
        minlength: $.validator.format("最少要输入 {0} 个字符"),
        rangelength: $.validator.format("请输入长度在 {0} 到 {1} 之间的字符串"),
        range: $.validator.format("请输入范围在 {0} 到 {1} 之间的数值"),
        max: $.validator.format("请输入不大于 {0} 的数值"),
        min: $.validator.format("请输入不小于 {0} 的数值")
    });


    /**
     * 身份证号验证规则
     */
    $.validator.addMethod('idCard', function (value, element) {
        var __idNo__ = function (idcard) {
            var area = {
                11: "北京", 12: "天津", 13: "河北", 14: "山西", 15: "内蒙古", 21: "辽宁", 22: "吉林", 23: "黑龙江", 31: "上海", 32: "江苏", 33: "浙江",
                34: "安徽", 35: "福建", 36: "江西", 37: "山东", 41: "河南", 42: "湖北", 43: "湖南", 44: "广东", 45: "广西", 46: "海南", 50: "重庆", 51: "四川",
                52: "贵州", 53: "云南", 54: "西藏", 61: "陕西", 62: "甘肃", 63: "青海", 64: "宁夏", 65: "新疆", 71: "台湾", 81: "香港", 82: "澳门", 91: "国外"
            };
            var Y, JYM, S, M, ereg,idcard_array =  idcard.split("");
            if (area[parseInt(idcard.substr(0, 2))] == null) {
                return { result: false, e: "身份证号码不正确!"};
            }
            switch (idcard.length) {
                case 15:
                    if ((parseInt(idcard.substr(6, 2)) + 1900) % 4 == 0 || ((parseInt(idcard.substr(6, 2)) + 1900) % 100 == 0 && (parseInt(idcard.substr(6, 2)) + 1900) % 4 == 0)) {
                        ereg = /^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}$/;
                    } else {
                        ereg = /^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}$/;
                    }
                    if (ereg.test(idcard)) {
                        return { result: true};
                    } else {
                        return { result: false, e: "身份证号码出生日期超出范围或含有非法字符!"};
                    }
                    break;
                case 18:
                    if (parseInt(idcard.substr(6, 4)) % 4 == 0 || (parseInt(idcard.substr(6, 4)) % 100 == 0 && parseInt(idcard.substr(6, 4)) % 4 == 0)) {
                        ereg = /^[1-9][0-9]{5}19[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}[0-9Xx]$/;
                    } else {
                        ereg = /^[1-9][0-9]{5}19[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}[0-9Xx]$/;
                    }
                    if (ereg.test(idcard)) {
                        S = (parseInt(idcard_array[0]) + parseInt(idcard_array[10])) * 7
                            + (parseInt(idcard_array[1]) + parseInt(idcard_array[11])) * 9
                            + (parseInt(idcard_array[2]) + parseInt(idcard_array[12])) * 10
                            + (parseInt(idcard_array[3]) + parseInt(idcard_array[13])) * 5
                            + (parseInt(idcard_array[4]) + parseInt(idcard_array[14])) * 8
                            + (parseInt(idcard_array[5]) + parseInt(idcard_array[15])) * 4
                            + (parseInt(idcard_array[6]) + parseInt(idcard_array[16])) * 2
                            + parseInt(idcard_array[7]) * 1
                            + parseInt(idcard_array[8]) * 6
                            + parseInt(idcard_array[9]) * 3;
                        Y = S % 11;
                        M = "F";
                        JYM = "10X98765432";
                        M = JYM.substr(Y, 1);
                        if (M == idcard_array[17]) {
                            return { result: true}
                        } else {
                            return { result: false, e: "身份证号码出生日期超出范围或含有非法字符!"};
                        }
                    } else {
                        return { result: false, e: "身份证号码出生日期超出范围或含有非法字符!"};
                    }
                    break;
                default:
                    return { result: false, e: "身份证号码位数不对!"};
            }
        };
        return __idNo__(value).result;
    }, '请输入正确的身份证号');

    /**
     * 手机号验证规则
     */
    $.validator.addMethod('checkMobile', function (value, element) {
        var length = value.length;
        var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
        return this.optional(element) || (length == 11 && mobile.test(value));
    }, '请输入正确的手机号');

    /**
     * 是否为汉字的验证规则
     */
    $.validator.addMethod('isChinese', function (value, element) {
        var reg = /[\u4e00-\u9fa5]/g;
        return reg.test(value);
    });

    /**
     * 字母和数字的验证
     */
    $.validator.addMethod("chrnum", function (value, element) {
        var chrnum = /^([a-zA-Z0-9]+)$/;
        return this.optional(element) || (chrnum.test(value));
    }, "只能输入数字和字母(字符A-Z, a-z, 0-9)");

    /**
     * 邮政编码验证规则
     */
    $.validator.addMethod("isZipCode", function(value, element) {
        var reg = /^[0-9]{6}$/;
        return this.optional(element) || (reg.test(value));
    }, "请正确填写您的邮政编码");

    /**
     * 电话号码验证规则
     */
    $.validator.addMethod("isPhone", function(value, element) {
        var reg = /^\d{3,4}-?\d{7,9}$/;
        return this.optional(element) || (reg.test(value));
    }, "请正确填写的电话号码");

    /**
     * 单位万元验证规则
     */
    $.validator.addMethod("millionUnits", function(value, element) {
        var reg = /^[\-\+]?(0|[1-9]\d*)(\.\d{1,4})?$/;
        return this.optional(element) || (reg.test(value));
    }, "请正确填写的金额");

    /**
     * 单位元验证规则
     */
    $.validator.addMethod("units", function(value, element) {
        var reg = /^[\-\+]?(0|[1-9]\d*)(\.\d{1,2})?$/;
        return this.optional(element) || (reg.test(value));
    }, "请正确填写的金额");

    /**
     * 面积验证规则
     */
    $.validator.addMethod("area", function(value, element) {
        var reg = /^(0|[1-9]\d*)(\.\d{1,4})?$/;
        return this.optional(element) || (reg.test(value));
    }, "请正确填写的面积");

    /**
     * 百分比验证规则
     */
    $.validator.addMethod("percent", function(value, element) {
        var reg = /^(100(\.0{1,2})?|[1-9]\d(\.\d{1,3})?|\d(\.\d{1,3})?)$/;
        return this.optional(element) || (reg.test(value));
    }, "请正确填写的百分比");

    /**
     * 字节数验证规则
     */
    $.validator.addMethod("byteRangeLength", function(value, element, param) {
        var length = value.length;
        for(var i = 0; i < value.length; i++){
            if(value.charCodeAt(i) > 127){
                length++;
            }
        }
        return this.optional(element) || ( length <= param[0] );
    }, $.validator.format("请确保输入的值在{0}个字节之间(一个中文字算2个字节)"));
});