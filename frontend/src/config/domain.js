/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
export const domain={
 code:'MAINTENANCEAI',systemName:'知华预测性维护 AI 平台',englishName:'PREDICTIVE MAINTENANCE AI',theme:{primary:'#275d57',dark:'#173b39',accent:'#c78a42'},
 workspace:'制造中心 / 设备智能运维组',fieldWorkspace:'华东工厂 / 设备保障组',period:'2026-08-15 · 实时监测',liveText:'状态数据于 10:36 更新',fieldContextLabel:'当前班次',fieldContext:'早班 08:00—16:00',fieldUser:'周衡',fieldRole:'设备工程师',adminUser:'韩序',adminRole:'可靠性负责人',
 adminTitle:'设备健康运营中心',adminBreadcrumb:'预测性维护 / 全厂态势',adminSubtitle:'用振动、温度、停机和维保记录识别退化设备，安排可执行的检修窗口。',exportAction:'导出健康报告',createAction:'新建诊断任务',
 chartTitle:'预测任务闭环趋势',chartSubtitle:'本月完成率 / 计划目标',chartLabels:['01日','05日','09日','13日','17日','21日','25日','29日','31日'],loadTitle:'产线风险负荷',loadSubtitle:'高风险设备占当前监测资产比例',recordsTitle:'重点设备诊断任务',recordsSubtitle:'按故障概率、生产影响和检修窗口排序',issueTitle:'需要处理的设备风险',issueSubtitle:'来自模型信号、点检异常和重复停机',
 recordName:'诊断任务',itemName:'设备资产',unitName:'责任班组',batchName:'信号来源',planName:'检查项',doneName:'已确认',exceptionName:'异常',unitLabel:'项',
 listBreadcrumb:'设备健康 / 诊断任务',listSubtitle:'将设备状态信号、历史故障和工单记录汇总为可解释的维护优先级。',listSummary:[['受监测设备','126'],['本周诊断','34'],['高风险','7',true],['已闭环','21']],tabs:['全部','待处理','进行中','待确认','已归档'],
 fieldBreadcrumb:'现场工作台 / 设备工程师',fieldTitle:'设备诊断工作台',fieldSubtitle:'负责设备 18 台 · 今日点检 12 项 · 待处理预警 3 条',fieldSecondary:'查看点检路线',reportAction:'提交诊断结论',fieldNoticeTitle:'传感器采集正常',fieldNotice:'关键点位覆盖率 92.6%',
 steps:['状态采集','异常检测','退化评估','人工诊断','检修闭环'],documentAction:'查看设备档案',printAction:'导出检修工单',resourceCardTitle:'监测资源状态',resourceValueLabel:'在线点位',resourceHealthLabel:'采集健康度',quickSubtitle:'常用诊断入口',
 quickActions:[['状态诊断','/shopfloor/report','振动、温度与趋势证据'],['设备台账','/shopfloor/material','资产、部件和维保履历'],['监测资源','/shopfloor/resources','传感器、网关和模型版本'],['风险升级','/shopfloor/andon','停机风险与跨部门协同']],
 reportDefaults:[6,1],reportTitle:'设备诊断反馈',reportSubtitle:'记录检查结果、故障模式与建议检修时间。',reportSuccess:'设备诊断反馈已提交',reportPlaceholder:'填写现场现象、测量结果、判断依据和处理建议',reportFootnote:'提交后进入可靠性工程师复核队列',ruleTitle:'预测维护安全门禁',ruleSubtitle:'MAINT-AI · V1.0',rules:[['关键报警','必须人工确认'],['停机建议','生产共同批准'],['模型证据','保留原始信号'],['效果复盘','检修后执行',true]],fieldTotals:[['18','负责设备'],['3','待处理预警'],['12','今日点检'],['92.6%','信号覆盖率']],
 adminMenus:[['/admin','home','设备健康中心'],['/admin/work-orders','order','诊断任务'],['/admin/samples','box','设备资产'],['/admin/schedule','calendar','检修计划'],['/admin/methods','process','诊断规则'],['/admin/reviews','quality','结论复核'],['/admin/resources','machine','监测资源'],['/admin/report','chart','可靠性分析']],
 fieldMenus:[['/shopfloor','home','诊断工作台'],['/shopfloor/report','report','诊断反馈'],['/shopfloor/tasks','order','我的任务'],['/shopfloor/material','box','设备档案'],['/shopfloor/resources','machine','监测状态'],['/shopfloor/andon','risk','风险升级',3]],
 moduleTitles:{tasks:['我的诊断任务','查看优先级、窗口和处理状态'],material:['设备资产台账','查看关键部件、故障和维护履历'],resources:['监测资源中心','管理传感器、网关和诊断模型'],andon:['设备风险升级','提交停机风险和资源阻塞'],samples:['设备资产台账','统一管理设备、部件与生产影响'],schedule:['检修窗口','协调生产计划、备件与维修人员'],methods:['诊断规则','维护阈值、故障模式和处置模板'],reviews:['结论复核','记录确认、驳回和补充检查'],report:['可靠性分析','分析故障、停机和维护效果']},
 tagline:'让设备在故障发生前，给出可解释的信号',storyTitle:'把设备异常信号，<br/>变成可执行的检修计划',storyText:'融合状态监测、故障履历和生产影响，帮助维修团队提前识别退化并保留人工决策。',pattern:[2,5,8,11,14,17,20,23,26,29,31],loginStats:[['126','受监测设备'],['92.6%','信号覆盖率'],['7','高风险设备']],loginTitle:'设备健康运营中心',adminDemo:'健康 / 风险 / 计划',fieldDemo:'点检 / 诊断 / 反馈',upgrade:{eyebrow:'V1.1 维护协同',title:'生产负荷感知的检修窗口规划',summary:'综合停机时长、产线负荷、维修人员与备件齐套度，给出首选窗口、备选窗口和阻塞原因。',api:'POST /api/ai/maintenance/plan-window',metrics:[['13:00','推荐开工'],['20%','窗口负荷'],['READY','资源状态']]}
}
export const records=[
 {no:'PM-260815-018',name:'五轴加工中心主轴',code:'CNC-5X-07',unit:'机加维修组',group:'一号车间',plan:12,done:8,exception:3,due:'08-15',batch:'振动+温度',status:'诊断中',progress:68,priority:'加急'},
 {no:'PM-260815-021',name:'涂装循环泵 P-02',code:'PUMP-02',unit:'公用工程组',group:'涂装车间',plan:9,done:5,exception:1,due:'08-16',batch:'电流趋势',status:'待确认',progress:56,priority:'关注'},
 {no:'PM-260815-026',name:'空压机三号机组',code:'AC-03',unit:'动力保障组',group:'能源中心',plan:10,done:2,exception:2,due:'08-16',batch:'多传感器',status:'待处理',progress:20,priority:'加急'},
 {no:'PM-260814-015',name:'总装输送线驱动电机',code:'MOTOR-A12',unit:'总装维修组',group:'总装车间',plan:8,done:8,exception:0,due:'08-14',batch:'振动监测',status:'已归档',progress:100,priority:'正常'},
 {no:'PM-260815-031',name:'激光切割机冷却单元',code:'CHILLER-06',unit:'钣金维修组',group:'钣金车间',plan:11,done:7,exception:1,due:'08-17',batch:'温压流量',status:'诊断中',progress:64,priority:'关注'}
]
export const resources=[{code:'EDGE-01',name:'车间状态采集网关',unit:'设备智能组',status:'运行中',health:98,value:'286',valueUnit:'点',note:'最近十五分钟数据完整率 99.4%'},{code:'MODEL-02',name:'旋转设备退化模型',unit:'可靠性中心',status:'复核中',health:93,value:'v3.4',valueUnit:'',note:'7 台设备进入观察队列'},{code:'CMMS-03',name:'维修工单连接器',unit:'设备管理组',status:'预警',health:86,value:'42',valueUnit:'单',note:'2 条工单回写等待重试'}]
export const reviews=[{no:'RV-260815-032',title:'CNC-07 主轴退化结论',type:'停机建议',detail:'风险 82 · 韩序',result:'待确认'},{no:'RV-260815-011',title:'PUMP-02 轴承温升复核',type:'现场验证',detail:'3 个测点 · 周衡',result:'通过'},{no:'RV-260814-018',title:'AC-03 排气压力异常',type:'证据补充',detail:'缺少油样报告',result:'异常'}]
export const adminMetrics=[['受监测设备','126','在线率 98.4%','blue'],['高风险设备','7','其中 3 台影响主线','red'],['本周闭环','21','平均提前 4.6 天','green'],['待批检修','4','需要生产确认','orange']]
export const fieldMetrics=[['我的任务','6','3 项高优先级','blue'],['今日已诊断','8','全部保留证据','green'],['待处理预警','3','1 项建议停机','orange'],['信号覆盖率','92.6%','较上周提升 1.8%','slate']]
export const chartActual=[16,25,35,46,57,66,75,83,90],chartTarget=[18,28,39,50,60,70,80,90,96]
export const loads=[['机加设备',86,'高风险 3 台'],['涂装公用设备',72,'高风险 1 台'],['总装输送设备',64,'高风险 2 台'],['能源动力设备',58,'高风险 1 台']]
export const issues=[['停机','CNC-07 主轴退化概率持续上升','建议八小时内安排检查','待批准'],['数据','AC-03 二级振动点位连续丢包','已切换备用采集通道','处理中'],['备件','PUMP-02 轴承库存低于安全量','采购交期预计五天','需协调']].map(x=>({type:x[0],title:x[1],detail:x[2],status:x[3]}))
