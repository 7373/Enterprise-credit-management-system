require([ 'component/iframeLayer', 'component/dataTable', 'common/util',
		'common/http', 'common/busUtil', 'handlebars', 'jquery',
		'jquery.serialize', 'laydate' ], function(layer, dataTable, util, http,
		busUtil, handlebars) {
	var qySafeProduceLicenceTable, qyCommendRewardInfoTable, qyGtjRedListTable;
	var searchParams = $("#hxForm").serializeObject();// 查询参数申明!
	var searchParamsR = $("#redForm").serializeObject();// 查询红名单!
	var searchParamsB = $("#blackForm").serializeObject();// 查询黑名单!

	init();
	/**
	 * 初始化函数集合
	 */
	function init() {
		initQySafeProduceLicenceTable();
		initWgjlxxTableInfoTable();
		initSczmTableInfoTable();
		initDjpgTableInfoTable();
		initDjpdTableInfoTable();
		initCcbhgTableInfoTable();
		initSbcpTableInfoTable();
		
		initAqscTableInfoTable();
		initLmzzscTableInfoTable();
		initXfaqTableInfoTable();
		
		initXzqzTableInfoTable();
		initZdhzTableInfoTable();
		initQyqsTableInfoTable();

		bind();
	}

	/**
	 * 初始化企业许可资质信息表
	 */
	function initQySafeProduceLicenceTable() {
		qySafeProduceLicenceTable = dataTable.load({
			// 需要初始化dataTable的dom元素
			el : '#qySafeProduceLicenceTable',
			scrollX : true, // 支持滚动
			showIndex : false,
			lengthMenu : [ 5, 10, 20, 50, 100 ],
			ajax : {
				url : '/credit/ndSafeProduceLicence/list',
				type : 'post',
				data : function(d) {
					d.params = searchParams;
				}
			},
			// 需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
			// className不要写成class
			columns : [ {
				data : "entName",
				className : 'center'
			},{
				data : "unicode",
				className : 'center'
			},{
				data : "isNeedLicence",
				className : 'center'
			}, {
				data : "licenceNO",
				className : 'center'
			}, {
				data : "licenceRange",
				className : 'center'
			}, {
				data : "licenceEndTime",
				className : 'center'
			} ],
			columnDefs : [ {
				targets : 2,
				render : function(data, type, row, meta) {
					if (row.isNeedLicence == '0')
						return "需要";
					if (row.isNeedLicence == '1')
						return "不需要";
					else
						return "";
				}
			} ],
			"fnDrawCallback" : function(data) {
				$("#scxk").html(data._iRecordsTotal);
			}
		})
	}
	/**
	 * 初始化奖励信息文广新局。
	 */
	function initWgjlxxTableInfoTable() {
		qySafeProduceLicenceTable = dataTable.load({
			el : '#wgjlxxTable',
			scrollX : true, // 支持滚动
			showIndex : false,
			lengthMenu : [ 5, 10, 20, 50, 100 ],
			ajax : {
				url : '/credit/ndRewardInfo/data.json',
				type : 'post',
				data : function(d) {
					d.params = searchParams;
				}
			},
			columns : [ {
				data : 'rewardUnitName',
				className : 'center'
			}, {
				data : 'unitType',
				className : 'center'
			}, {
				data : 'address',
				className : 'center'
			}, {
				data : 'theArea',
				className : 'center'
			}, {
				data : 'rewardName',
				className : 'center'
			}, {
				data : 'rewardClass',
				className : 'center'
			}, {
				data : 'rewardTime',
				className : 'center'
			}, {
				data : 'awardUnit',
				className : 'center'
			} ],
			"fnDrawCallback" : function(data) {
				$("#wgjlxx").text(data._iRecordsTotal);
				if (data._iRecordsTotal == 0) {
					$('.wgjl').hide();
				}
			}
		})
	}
	/**
	 * 省知名商号信息 市场监管局
	 */
	function initSczmTableInfoTable() {
		qySafeProduceLicenceTable = dataTable.load({
			el : '#sczmTable',
			scrollX : true, // 支持滚动
			showIndex : false,
			lengthMenu : [ 5, 10, 20, 50, 100 ],
			ajax : {
				url : '/credit/ndFamousFirmInfo/data.json',
				type : 'post',
				data : function(d) {
					d.params = searchParams;
				}
			},
			columns : [ {
				data : 'entName',
				className : 'center'
			}, {
				data : 'unicode',
				className : 'center'
			}, {
				data : 'wordNO',
				className : 'center'
			},

			{
				data : 'affirmTime',
				className : 'center'
			}, {
				data : 'validTerm',
				className : 'center'
			},

			],
			"fnDrawCallback" : function(data) {
				$("#sczmxx").text(data._iRecordsTotal);
				if (data._iRecordsTotal == 0) {
					$('.sczm').hide();
				}
			}
		})
	}
	/**
	 * 驰名商标信息、省著名商标信息、省名牌产品信息
	 */

	function initSbcpTableInfoTable() {
		qySafeProduceLicenceTable = dataTable.load({
			el : '#sbcpTable',
			scrollX : true, // 支持滚动
			showIndex : false,
			lengthMenu : [ 5, 10, 20, 50, 100 ],
			ajax : {
				url : '/credit/ndFamousTradeMarkInfo/data.json',
				type : 'post',
				data : function(d) {
					d.params = searchParams;
				}
			},
			columns : [ {
				data : 'entName',
				className : 'center'
			}, {
				data : 'unicode',
				className : 'center'
			}, {
				data : 'tradeMarkRegistNO',
				className : 'center'
			}, {
				data : 'affirmTitle',
				className : 'center'
			} ],
			"fnDrawCallback" : function(data) {
				$("#sbcpxx").text(data._iRecordsTotal);
				if (data._iRecordsTotal == 0) {
					$('.sbcp').hide();
				}
			}
		})
	}

	/**
	 * 产品质量监督抽查不合格记录信息
	 */
	function initCcbhgTableInfoTable() {
		qySafeProduceLicenceTable = dataTable.load({
			el : '#ccbhgTable',
			scrollX : true, // 支持滚动
			showIndex : false,
			lengthMenu : [ 5, 10, 20, 50, 100 ],
			ajax : {
				url : '/credit/ndProductUnqualifiedInfo/data.json',
				type : 'post',
				data : function(d) {
					d.params = searchParams;
				}
			},
			columns : [ {
				data : 'entName',
				className : 'center'
			}, {
				data : 'unicode',
				className : 'center'
			}, {
				data : 'productName',
				className : 'center'
			}, {
				data : 'tradeMark',
				className : 'center'
			}, {
				data : 'standardModel',
				className : 'center'
			}, {
				data : 'manufactureDate',
				className : 'center'
			}, {
				data : 'productClassify',
				className : 'center'
			}, {
				data : 'testUnit',
				className : 'center'
			}, {
				data : 'checkDate',
				className : 'center'
			}, {
				data : 'checkLevel',
				className : 'center'
			}, {
				data : 'checkResult',
				className : 'center'
			} ],
			"fnDrawCallback" : function(data) {
				$("#ccbhgxx").text(data._iRecordsTotal);
				if (data._iRecordsTotal == 0) {
					$('.ccbhg').hide();
				}
			}
		})
	}

	/**
	 * 环境等级评定信息 环保局
	 */
	function initDjpdTableInfoTable() {
		qySafeProduceLicenceTable = dataTable.load({
			el : '#djpdTable',
			scrollX : true, // 支持滚动
			showIndex : false,
			lengthMenu : [ 5, 10, 20, 50, 100 ],
			ajax : {
				url : '/credit/ndEnvironmentEvaluateInfo/data.json',
				type : 'post',
				data : function(d) {
					d.params = searchParams;
				}
			},
			columns : [ {
				data : 'entName',
				className : 'center'
			}, {
				data : 'unicode',
				className : 'center'
			}, {
				data : 'evaluateClass',
				className : 'center'
			}, {
				data : 'fileNO',
				className : 'center'
			} ],
			"fnDrawCallback" : function(data) {
				$("#djpdxx").text(data._iRecordsTotal);
				if (data._iRecordsTotal == 0) {
					$('.djpd').hide();
				}
			}
		})
	}

	/**
	 * 社会组织等级评估信息 民政局
	 */

	function initDjpgTableInfoTable() {
		qySafeProduceLicenceTable = dataTable.load({
			el : '#djpgTable',
			scrollX : true, // 支持滚动
			showIndex : false,
			lengthMenu : [ 5, 10, 20, 50, 100 ],
			ajax : {
				url : '/credit/ndSocietyClassEvaluateInfo/data.json',
				type : 'post',
				data : function(d) {
					d.params = searchParams;
				}
			},
			columns : [ {
				data : 'evaluateClass',
				className : 'center'
			}, {
				data : 'unicode',
				className : 'center'
			}, {
				data : 'evaluateValidTerm',
				className : 'center'
			} ],
			"fnDrawCallback" : function(data) {
				$("#djpgxx").text(data._iRecordsTotal);
				if (data._iRecordsTotal == 0) {
					$('.djpg').hide();
				}
			}
		})
	}

	/**
	 * 初始化企业国土局黑名单（不良信息）表
	 */
	function initQyGtjBlackListTable() {
		qyGtjBlackListTable = dataTable.load({
			el : '#qyGtjBlackListTable',
			scrollX : true, // 支持滚动
			showIndex : false,
			lengthMenu : [ 5, 10, 20, 50, 100 ],
			ajax : {
				url : '/credit/redBlackList/qygrredblacklist.json',
				type : 'post',
				data : function(d) {
					d.params = searchParamsB;
				}
			},
			columns : [],
			"fnDrawCallback" : function(data) {
				$("#gtjblxx").html(data._iRecordsTotal);
			}
		})
	}

	/**
	 * 安全生产许可证 安监局
	 * 
	 * 
	 */
	function initAqscTableInfoTable() {
		qySafeProduceLicenceTable = dataTable.load({
			el : '#aqscTable',
			scrollX : true, // 支持滚动
			showIndex : false,
			lengthMenu : [ 5, 10, 20, 50, 100 ],
			ajax : {
				url : '/credit/ndSafeProduceLicence/data.json',
				type : 'post',
				data : function(d) {
					d.params = searchParams;
				}
			},
			columns : [ {
				data : 'entName',
				className : 'center'
			}, {
				data : 'unicode',
				className : 'center'
			}, {
				data : 'isNeedLicence',
				className : 'center'
			}, {
				data : 'licenceNO',
				className : 'center'
			}, {
				data : 'licenceRange',
				className : 'center'
			}, {
				data : 'licenceEndTime',
				className : 'center'
			} ],
			"fnDrawCallback" : function(data) {
				$("#aqscxx").text(data._iRecordsTotal);
				if (data._iRecordsTotal == 0) {
					$('.aqsc').hide();
				}
			}
		})
	}

	/**
	 * 林木种子生产经营种类许可 林业局（农业局）
	 * 
	 * 
	 */

	function initLmzzscTableInfoTable() {
		qySafeProduceLicenceTable = dataTable.load({
			el : '#lmzzscTable',
			scrollX : true, // 支持滚动
			showIndex : false,
			lengthMenu : [ 5, 10, 20, 50, 100 ],
			ajax : {
				url : '/credit/ndSeedManagePermit/data.json',
				type : 'post',
				data : function(d) {
					d.params = searchParams;
				}
			},
			columns : [ {
				data : 'entName',
				className : 'center'
			}, {
				data : 'unicode',
				className : 'center'
			}, {
				data : 'licenceNO',
				className : 'center'
			}, {
				data : 'issueTime',
				className : 'center'
			}, {
				data : 'termEnd',
				className : 'center'
			}, {
				data : 'produceLoc',
				className : 'center'
			}, {
				data : 'manageType',
				className : 'center'
			} ],
			"fnDrawCallback" : function(data) {
				$("#lmzzscxx").text(data._iRecordsTotal);
				if (data._iRecordsTotal == 0) {
					$('.lmzzsc').hide();
				}
			}
		})
	}

	/**
	 * 消防安全许可信息（建设工程消防设计审核、建设工程消防验收） 公安局
	 * 
	 * 
	 */
	function initXfaqTableInfoTable() {
		qySafeProduceLicenceTable = dataTable.load({
			el : '#xfaqTable',
			scrollX : true, // 支持滚动
			showIndex : false,
			lengthMenu : [ 5, 10, 20, 50, 100 ],
			ajax : {
				url : '/credit/ndFireControlLicenceInfo/data.json',
				type : 'post',
				data : function(d) {
					d.params = searchParams;
				}
			},
			columns : [ {
				data : 'projectName',
				className : 'center'
			}, {
				data : 'unicode',
				className : 'center'
			}, {
				data : 'unitName',
				className : 'center'
			}, {
				data : 'checkCategory',
				className : 'center'
			}, {
				data : 'checkDocNO',
				className : 'center'
			}, {
				data : 'checkDate',
				className : 'center'
			} ],
			"fnDrawCallback" : function(data) {
				$("#xfaqxx").text(data._iRecordsTotal);
				if (data._iRecordsTotal == 0) {
					$('.xfaq').hide();
				}
			}
		})
	}

	/**
	 * 行政强制信息 公安局
	 * 
	 * 
	 */
	function initXzqzTableInfoTable() {
		qySafeProduceLicenceTable = dataTable.load({
			el : '#xzqzTable',
			scrollX : true, // 支持滚动
			showIndex : false,
			lengthMenu : [ 5, 10, 20, 50, 100 ],
			ajax : {
				url : '/credit/ndGaAdminForceInfo/data.json',
				type : 'post',
				data : function(d) {
					d.params = searchParams;
				}
			},
			columns : [ {
				data : 'unitName',
				className : 'center'
			}, {
				data : 'unicode',
				className : 'center'
			}, {
				data : 'interimCloseDate',
				className : 'center'
			}, {
				data : 'removeCloseDate',
				className : 'center'
			}, {
				data : 'interimRemoveCloseDate',
				className : 'center'
			}, {
				data : 'forceExecuteDocNo',
				className : 'center'
			}, {
				data : 'forceExecuteContent',
				className : 'center'
			}, {
				data : 'forceExecuteDate',
				className : 'center'
			} ],
			"fnDrawCallback" : function(data) {
				$("#xzqzxx").text(data._iRecordsTotal);
				if (data._iRecordsTotal == 0) {
					$('.xzqz').hide();
				}
			}
		})
	}

	/**
	 * 重大火灾隐患信息 公安局
	 * 
	 * 
	 */

	function initZdhzTableInfoTable() {
		qySafeProduceLicenceTable = dataTable.load({
			el : '#zdhzTable',
			scrollX : true, // 支持滚动
			showIndex : false,
			lengthMenu : [ 5, 10, 20, 50, 100 ],
			ajax : {
				url : '/credit/ndMajorFireInfo/data.json',
				type : 'post',
				data : function(d) {
					d.params = searchParams;
				}
			},
			columns : [ {
				data : 'unitName',
				className : 'center'
			}, {
				data : 'unicode',
				className : 'center'
			}, {
				data : 'fireHiddenContent',
				className : 'center'
			}, {
				data : 'affirmDate',
				className : 'center'
			}, {
				data : 'affirmBasis',
				className : 'center'
			}, {
				data : 'closeCaseDate',
				className : 'center'
			} ],
			"fnDrawCallback" : function(data) {
				$("#zdhzxx").text(data._iRecordsTotal);
				if (data._iRecordsTotal == 0) {
					$('.zdhz').hide();
				}
			}
		})
	}

	/**
	 * 企业（个体工商户）欠税信息 财政（地税）局
	 * 
	 * 
	 */

	function initQyqsTableInfoTable() {
		qySafeProduceLicenceTable = dataTable.load({
			el : '#qyqsTable',
			scrollX : true, // 支持滚动
			showIndex : false,
			lengthMenu : [ 5, 10, 20, 50, 100 ],
			ajax : {
				url : '/credit/ndEntOweTaxInfo/data.json',
				type : 'post',
				data : function(d) {
					d.params = searchParams;
				}
			},
			columns : [ {
				data : 'taxerName',
				className : 'center'
			}, {
				data : 'unicode',
				className : 'center'
			}, {
				data : 'legalPerson',
				className : 'center'
			}, {
				data : 'registAddr',
				className : 'center'
			}, {
				data : 'oweTaxType',
				className : 'center'
			}, {
				data : 'oweTaxAmount',
				className : 'center'
			} ],
			"fnDrawCallback" : function(data) {
				$("#qyqsxx").text(data._iRecordsTotal);
				if (data._iRecordsTotal == 0) {
					$('.qyqs').hide();
				}
			}
		})
	}

	function bind() {
		util.bindEvents([ {
			el : '#privacy',
			event : 'click',
			handler : function() {
				window.open('/credit/qybase/qyprivacy?uid='
						+ $(this).attr('uid'));
			}
		} ])
	}
	;
});
