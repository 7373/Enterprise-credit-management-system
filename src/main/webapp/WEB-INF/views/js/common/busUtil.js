/**
 * 业务相关-工具集
 */
define([ 'jquery' ],function($) {

			/**
			 * 格式化状态
			 * 
			 * @param state
			 * @returns
			 */
			function fmtState(state) {
				if (state == null || '' == state)
					return '';
				switch (state) {
				case '0':
					return '未提交';
					break;
				case '1':
					return '已提交';
					break;
				case '2':
					return '退回';
					break;
				case '3':
					return '已备案';
					break;
				case '4':
					return '已修改';
					break;
				case '5':
					return '未修改';
					break;
				default:
					return '';
					break;
				}
			}

			/**
			 * 格式化状态
			 * 
			 * @param state
			 * @returns
			 */
			function bizFmtState(state) {
				if (state == null || '' == state)
					return '';
				if(state == '4' || state == '5')
					return '条款需修改';
				return fmtState(state);
			}

			/**
			 * 格式化经办人证件类型
			 * 
			 * @param type
			 * @returns
			 */
			function fmtManagerCertType(type) {
				if (type == null || '' == type)
					return '';
				switch (type) {
				case '0':
					return '身份证';
					break;
				case '1':
					return '军官证';
					break;
				case '2':
					return '护照';
					break;
				case '3':
					return '港澳台胞证';
					break;
				default:
					return '';
					break;
				}
			}

			/**
			 * 初始化格式合同备案类别的父下拉框
			 * 
			 * @param 需要渲染的input
			 *            id
			 */
			function initFcfPreType(_id) {
				var id = '#' + _id;
				$(id)
						.append(
								'<option value="0">全部</option>'
							+ '<option value="1" >房屋买卖、租赁及其居间、委托合同</option>'
							+ '<option value="2" >物业管理、住宅装修装饰合同</option>'
							+ '<option value="3" >旅游合同</option>'
							+ '<option value="4" >供用电、水、热、气合同</option>'
							+ '<option value="5" >有线电视、邮政、电信合同</option>'
							+ '<option value="6" >消费贷款、人身财产保险合同</option>'
							+ '<option value="7" >旅客运输合同</option>'
							+ '<option value="8" >汽车销售、保养、维修合同</option>'
							+ '<option value="9" >省人民政府规定应当备案的其他含有格式条款的合同</option>');
			}
			
			/**
			 * 初始化格式合同备案类别的子下拉框
			 * 
			 * @param 需要渲染的input
			 *            id
			 */
			function initFcfSonType(_id, num) {
				var id = '#' + _id;
				$(id).append(getcontractType(num, '0'));
			}

			/**
			 * 获取级联下拉框的值
			 */
			function getcontractType(num1, num2) {
				var str0 = '<option ' + (num2 == "0" ? "selected" : "")
						+ ' value="">全部</option>';
				var str1 = '<option ' + (num2 == "" ? "selected" : "")
						+ ' value="">全部</option>' + '<option '
						+ (num2 == "1-1" ? "selected" : "")
						+ ' value="1-1">房屋买卖合同</option>' + '<option '
						+ (num2 == "1-2" ? "selected" : "")
						+ ' value="1-2">房屋租赁及其居间合同</option>' + '<option '
						+ (num2 == "1-3" ? "selected" : "")
						+ ' value="1-3">房屋买卖、租赁委托合同</option>';
				var str2 = '<option ' + (num2 == "" ? "selected" : "")
						+ ' value="">全部</option>' + '<option '
						+ (num2 == "2-1" ? "selected" : "")
						+ '  value="2-1">物业管理合同</option>' + '<option '
						+ (num2 == "2-2" ? "selected" : "")
						+ ' value="2-2">住宅装修装饰合同</option>';
				var str3 = '<option ' + (num2 == "" ? "selected" : "")
						+ ' value="">全部</option>' + '<option '
						+ (num2 == "3-1" ? "selected" : "")
						+ ' value="3-1">旅游合同</option>';
				var str4 = '<option ' + (num2 == "" ? "selected" : "")
						+ ' value="">全部</option>' + '<option '
						+ (num2 == "4-1" ? "selected" : "")
						+ ' value="4-1">供用合同</option>' + '<option '
						+ (num2 == "4-2" ? "selected" : "")
						+ ' value="4-2">供水合同</option>' + '<option '
						+ (num2 == "4-3" ? "selected" : "")
						+ ' value="4-3">供气合同</option>' + '<option '
						+ (num2 == "4-4" ? "selected" : "")
						+ ' value="4-4">供热合同</option>';
				var str5 = '<option ' + (num2 == "" ? "selected" : "")
						+ ' value="">全部</option>' + '<option '
						+ (num2 == "5-1" ? "selected" : "")
						+ ' value="5-1">有线电视合同</option>' + '<option '
						+ (num2 == "5-2" ? "selected" : "")
						+ ' value="5-2">邮政合同</option>' + '<option '
						+ (num2 == "5-3" ? "selected" : "")
						+ ' value="5-3">电信合同</option>';
				var str6 = '<option ' + (num2 == "" ? "selected" : "")
						+ ' value="">全部</option>' + '<option '
						+ (num2 == "6-1" ? "selected" : "")
						+ ' value="6-1">消费贷款合同</option>' + '<option '
						+ (num2 == "6-2" ? "selected" : "")
						+ ' value="6-2">人身财产保险合同</option>';
				var str7 = '<option ' + (num2 == "" ? "selected" : "")
						+ ' value="">全部</option>' + '<option '
						+ (num2 == "7-1" ? "selected" : "")
						+ ' value="7-1">旅客运输合同</option>';
				var str8 = '<option ' + (num2 == "" ? "selected" : "")
						+ ' value="">全部</option>' + '<option '
						+ (num2 == "8-1" ? "selected" : "")
						+ 'value="8-1">汽车销售合同</option>' + '<option '
						+ (num2 == "8-2" ? "selected" : "")
						+ ' value="8-2">汽车保养、维修合同</option>';
				var str9 = '<option ' + (num2 == "" ? "selected" : "")
						+ ' value="">全部</option>' + '<option '
						+ (num2 == "9-1" ? "selected" : "")
						+ ' value="9-1">其他合同</option>';

				if (num1 == null || '' == num1)
					return '';
				switch (num1) {
				case '0':
					return str0;
					break;
				case '1':
					return str1;
					break;
				case '2':
					return str2;
					break;
				case '3':
					return str3;
					break;
				case '4':
					return str4;
					break;
				case '5':
					return str5;
					break;
				case '6':
					return str6;
					break;
				case '7':
					return str7;
					break;
				case '8':
					return str8;
					break;
				case '9':
					return str9;
					break;
				default:
					return '';
					break;
				}

			}

			/**
			 * 初始化格式合同备案类别的父下拉框(搜索)
			 * 
			 * @param 需要渲染的input
			 *            id
			 */
			function initFcfPreTypeForSearch(_id) {
				var id = '#' + _id;
				$(id)
						.append(
								'<option value="0">全部</option>'
							+ '<option value="1" >房屋买卖、租赁及其居间、委托合同</option>'
							+ '<option value="2" >物业管理、住宅装修装饰合同</option>'
							+ '<option value="3" >旅游合同</option>'
							+ '<option value="4" >供用电、水、热、气合同</option>'
							+ '<option value="5" >有线电视、邮政、电信合同</option>'
							+ '<option value="6" >消费贷款、人身财产保险合同</option>'
							+ '<option value="7" >旅客运输合同</option>'
							+ '<option value="8" >汽车销售、保养、维修合同</option>'
							+ '<option value="9" >省人民政府规定应当备案的其他含有格式条款的合同</option>');
			}
			
			/**
			 * 初始化格式合同备案类别的子下拉框(搜索)
			 * 
			 * @param 需要渲染的input
			 *            id
			 */
			function initFcfSonTypeForSearch(_id, num) {
				var id = '#' + _id;
				$(id).append(getcontractTypeForSearch(num, '0'));
			}
			
			/**
			 * 获取级联下拉框的值(搜索)
			 */
			function getcontractTypeForSearch(num1, num2) {
				var str0 = '<option ' + (num2 == "0" ? "selected" : "")
						+ ' value="">全部</option>';
				var str1 = '<option '
						+ (num2 == "1-1" ? "selected" : "")
						+ ' value="1-1">房屋买卖合同</option>' + '<option '
						+ (num2 == "1-2" ? "selected" : "")
						+ ' value="1-2">房屋租赁及其居间合同</option>' + '<option '
						+ (num2 == "1-3" ? "selected" : "")
						+ ' value="1-3">房屋买卖、租赁委托合同</option>';
				var str2 =  '<option '
						+ (num2 == "2-1" ? "selected" : "")
						+ '  value="2-1">物业管理合同</option>' + '<option '
						+ (num2 == "2-2" ? "selected" : "")
						+ ' value="2-2">住宅装修装饰合同</option>';
				var str3 = '<option '
						+ (num2 == "3-1" ? "selected" : "")
						+ ' value="3-1">旅游合同</option>';
				var str4 = ' value="4-1">供用合同</option>' + '<option '
						+ (num2 == "4-2" ? "selected" : "")
						+ ' value="4-2">供水合同</option>' + '<option '
						+ (num2 == "4-3" ? "selected" : "")
						+ ' value="4-3">供气合同</option>' + '<option '
						+ (num2 == "4-4" ? "selected" : "")
						+ ' value="4-4">供热合同</option>';
				var str5 = '<option '
						+ (num2 == "5-1" ? "selected" : "")
						+ ' value="5-1">有线电视合同</option>' + '<option '
						+ (num2 == "5-2" ? "selected" : "")
						+ ' value="5-2">邮政合同</option>' + '<option '
						+ (num2 == "5-3" ? "selected" : "")
						+ ' value="5-3">电信合同</option>';
				var str6 =  '<option '
						+ (num2 == "6-1" ? "selected" : "")
						+ ' value="6-1">消费贷款合同</option>' + '<option '
						+ (num2 == "6-2" ? "selected" : "")
						+ ' value="6-2">人身财产保险合同</option>';
				var str7 = '<option '
						+ (num2 == "7-1" ? "selected" : "")
						+ ' value="7-1">旅客运输合同</option>';
				var str8 = '<option '
						+ (num2 == "8-1" ? "selected" : "")
						+ 'value="8-1">汽车销售合同</option>' + '<option '
						+ (num2 == "8-2" ? "selected" : "")
						+ ' value="8-2">汽车保养、维修合同</option>';
				var str9 =  '<option '
						+ (num2 == "9-1" ? "selected" : "")
						+ ' value="9-1">其他合同</option>';

				if (num1 == null || '' == num1)
					return '';
				switch (num1) {
				case '0':
					return str0;
					break;
				case '1':
					return str1;
					break;
				case '2':
					return str2;
					break;
				case '3':
					return str3;
					break;
				case '4':
					return str4;
					break;
				case '5':
					return str5;
					break;
				case '6':
					return str6;
					break;
				case '7':
					return str7;
					break;
				case '8':
					return str8;
					break;
				case '9':
					return str9;
					break;
				default:
					return '';
					break;
				}

			}
			/**
			 * 格式化格式合同备案类别显示
			 * 
			 * @param contractType
			 * @returns
			 */
			function fmtFcfType(contractType) {
				if (contractType == null || '' == contractType)
					return '';
				switch (contractType) {
				case '1-1':
					return "房屋买卖合同";
					break;
				case '1-2':
					return "房屋租赁及其居间合同";
					break;
				case '1-3':
					return "房屋买卖、租赁委托合同";
					break;
				case '2-1':
					return "物业管理合同";
					break;
				case '2-2':
					return "住宅装修装饰合同";
					break;
				case '3-1':
					return "旅游合同";
					break;
				case '4-1':
					return "供用合同";
					break;
				case '4-2':
					return "供水合同";
					break;
				case '4-3':
					return "供气合同";
					break;
				case '4-4':
					return "供热合同";
					break;
				case '5-1':
					return "有线电视合同";
					break;
				case '5-2':
					return "邮政合同";
					break;
				case '5-3':
					return "电信合同";
					break;
				case '6-1':
					return "消费贷款合同";
					break;
				case '6-2':
					return "人身财产保险合同";
					break;
				case '7-1':
					return "旅客运输合同";
					break;
				case '8-1':
					return "汽车销售合同";
					break;
				case '8-2':
					return "汽车保养、维修合同";
					break;
				case '9-1':
					return "其他合同";
					break;
				default:
					return '';
					break;
				}
			}

			/**
			 * 格式化格式合同备案类别父下拉框修改
			 * 
			 * @param contractType
			 * @returns
			 */
			function editPreFcfType(_id, contractType) {
				var id = '#' + _id;
				$(id)
						.append(
								'<option '
										+ (contractType == "1" ? "selected"
												: "")
										+ ' value="1">房屋买卖、租赁及其居间、委托合同</option>'
										+ '<option '
										+ (contractType == "2" ? "selected"
												: "")
										+ ' value="2">物业管理、住宅装修装饰合同</option>'
										+ '<option '
										+ (contractType == "3" ? "selected"
												: "")
										+ ' value="3">旅游合同</option>'
										+ '<option '
										+ (contractType == "4" ? "selected"
												: "")
										+ ' value="4">供用电、水、热、气合同</option>'
										+ '<option '
										+ (contractType == "5" ? "selected"
												: "")
										+ ' value="5">有线电视、邮政、电信合同</option>'
										+ '<option '
										+ (contractType == "6" ? "selected"
												: "")
										+ ' value="6">消费贷款、人身财产保险合同</option>'
										+ '<option '
										+ (contractType == "7" ? "selected"
												: "")
										+ ' value="7">旅客运输合同</option>'
										+ '<option '
										+ (contractType == "8" ? "selected"
												: "")
										+ ' value="8">汽车销售、保养、维修合同</option>'
										+ '<option '
										+ (contractType == "9" ? "selected"
												: "")
										+ ' value="9">省人民政府规定应当备案的其他含有格式条款的合同</option>');
			}

			/**
			 * 初始化格式合同备案类别的子下拉框修改
			 * 
			 * @param 需要渲染的input
			 *            id
			 */
			function editSonFcfType(_id, num1, num2) {
				var id = '#' + _id;
				$(id).append(getcontractType(num1, num2));
			}
			
			return {
				fmtState : fmtState,
				bizFmtState : bizFmtState,
				fmtManagerCertType : fmtManagerCertType,
				initFcfPreType : initFcfPreType,
				initFcfSonType : initFcfSonType,
				fmtFcfType : fmtFcfType,
				editPreFcfType : editPreFcfType,
				editSonFcfType : editSonFcfType,
				initFcfPreTypeForSearch:initFcfPreTypeForSearch,
				initFcfSonTypeForSearch:initFcfSonTypeForSearch
			};

		});
