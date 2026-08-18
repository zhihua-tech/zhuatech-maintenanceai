# MAINTENANCEAI API 摘要

版权所有 © 2026 上海如静知华信息科技有限公司。

| 方法 | 路径 | 说明 |
| --- | --- | --- |
| POST | `/api/auth/login` | 登录并获取 JWT |
| GET | `/api/admin/dashboard` | 知华预测性维护 AI 平台运营控制台 |
| GET | `/api/admin/work-orders` | 维护预测任务列表 |
| GET | `/api/shopfloor/dashboard` | 设备健康分析运营台 |
| POST | `/api/shopfloor/work-orders/{id}/reports` | 提交处理反馈 |
| POST | `/api/ai/maintenance/predict` | 设备健康风险、检修时限和证据解释 |
| POST | `/api/ai/maintenance/plan-window` | 综合产线负荷、人员、备件与时长规划检修窗口 |
| POST | `/api/shopfloor/ai-risk-assessment` | AI 功能上线风险初筛 |

除登录外均需 `Authorization: Bearer <token>`。社区演示实现不调用外部模型，不需要 API Key。
