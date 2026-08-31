/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.maintenanceai.service;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/** 企业维修工单就绪门禁，安全条件不满足时禁止派工。 */
@Service
public class MaintenanceWorkOrderGovernanceService {
    public Decision assess(Request request) {
        List<String> blockers = new ArrayList<>();
        if (!request.sparePartsReady()) blockers.add("备件未齐套");
        if (request.qualifiedTechnicianCount() < 1) blockers.add("缺少具备资质的维修人员");
        if (!request.lotoPlanApproved()) blockers.add("LOTO 能量隔离方案未批准");
        if (!request.workPermitApproved()) blockers.add("高风险作业许可未批准");
        if (request.downtimeWindowMinutes() < request.requiredDurationMinutes()) blockers.add("停机窗口时长不足");
        if (request.vendorRequired() && !request.vendorConfirmed()) blockers.add("外协服务商未确认到场");
        boolean releaseAllowed = blockers.isEmpty();
        String priority = "CRITICAL".equals(request.riskLevel()) ? "P1"
                : "WATCH".equals(request.riskLevel()) ? "P2" : "P3";
        String route = releaseAllowed ? ("P1".equals(priority) ? "EXPEDITE_RELEASE" : "READY_TO_RELEASE")
                : "SAFETY_OR_RESOURCE_BLOCKED";
        List<String> controls = new ArrayList<>(blockers);
        controls.add("保存设备状态、风险预测、审批、人员和备件快照");
        if (releaseAllowed) controls.add("完工后执行复测、故障编码和根因闭环");
        return new Decision(request.workOrderNo(), priority, route, releaseAllowed,
                List.copyOf(blockers), List.copyOf(controls));
    }

    public record Request(@NotBlank String workOrderNo,
                          @Pattern(regexp = "CRITICAL|WATCH|STABLE") String riskLevel,
                          boolean sparePartsReady, @Min(0) int qualifiedTechnicianCount,
                          boolean lotoPlanApproved, boolean workPermitApproved,
                          @Min(0) int downtimeWindowMinutes,
                          @Min(1) int requiredDurationMinutes,
                          boolean vendorRequired, boolean vendorConfirmed) {}

    public record Decision(String workOrderNo, String priority, String route,
                           boolean releaseAllowed, List<String> blockers,
                           List<String> controls) {}
}
