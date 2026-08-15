/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.maintenanceai.service;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class PredictiveMaintenanceService {
    public Result predict(Request request) {
        int score = 0;
        if (request.vibrationMmPerSecond().compareTo(new BigDecimal("7.1")) >= 0) score += 35;
        else if (request.vibrationMmPerSecond().compareTo(new BigDecimal("4.5")) >= 0) score += 18;
        if (request.temperatureCelsius().compareTo(new BigDecimal("85")) >= 0) score += 25;
        else if (request.temperatureCelsius().compareTo(new BigDecimal("70")) >= 0) score += 12;
        if (request.failureEvents30Days() >= 3) score += 20;
        if (request.healthIndex() < 55) score += 25;
        else if (request.healthIndex() < 75) score += 12;
        if (request.runtimeHoursSinceService() >= 3000) score += 15;
        score = Math.min(100, score);
        String risk = score >= 65 ? "CRITICAL" : score >= 35 ? "WATCH" : "STABLE";
        int maintenanceWithinHours = "CRITICAL".equals(risk) ? 8 : "WATCH".equals(risk) ? 72 : 720;
        BigDecimal confidence = BigDecimal.valueOf(0.62 + Math.min(0.33, request.sensorCoveragePercent() / 300.0))
            .setScale(2, RoundingMode.HALF_UP);
        List<String> evidence = new ArrayList<>();
        if (request.vibrationMmPerSecond().compareTo(new BigDecimal("4.5")) >= 0) evidence.add("振动速度超过关注阈值");
        if (request.temperatureCelsius().compareTo(new BigDecimal("70")) >= 0) evidence.add("轴承温度持续偏高");
        if (request.failureEvents30Days() >= 3) evidence.add("近三十天重复故障次数偏高");
        if (evidence.isEmpty()) evidence.add("关键状态量保持稳定");
        return new Result(request.assetCode(), score, risk, maintenanceWithinHours, confidence,
            risk.equals("STABLE") ? "维持点检计划" : "安排停机窗口并检查轴承、润滑与对中", evidence);
    }

    public record Request(@NotBlank String assetCode,
                          @DecimalMin("0") BigDecimal vibrationMmPerSecond,
                          @DecimalMin("-50") BigDecimal temperatureCelsius,
                          @Min(0) int failureEvents30Days,
                          @Min(0) @Max(100) int healthIndex,
                          @Min(0) int runtimeHoursSinceService,
                          @Min(0) @Max(100) int sensorCoveragePercent) {}
    public record Result(String assetCode, int riskScore, String riskLevel,
                         int maintenanceWithinHours, BigDecimal confidence,
                         String recommendation, List<String> evidence) {}
}
