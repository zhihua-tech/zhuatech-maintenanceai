/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.maintenanceai.controller;

import cn.zhuatech.maintenanceai.common.ApiResponse;
import cn.zhuatech.maintenanceai.service.PredictiveMaintenanceService;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController
@RequestMapping("/api/ai/maintenance")
@PreAuthorize("hasAnyRole('DOMAIN_USER','DOMAIN_OPERATOR','ADMIN')")
public class PredictiveMaintenanceController {
    private final PredictiveMaintenanceService service;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public PredictiveMaintenanceController(PredictiveMaintenanceService service) { this.service = service; }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping("/predict")
    public ApiResponse<PredictiveMaintenanceService.Result> predict(
        @Valid @RequestBody PredictiveMaintenanceService.Request request) {
        return ApiResponse.ok("设备健康预测完成", service.predict(request));
    }

    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping("/plan-window")
    public ApiResponse<PredictiveMaintenanceService.MaintenanceWindowResult> planWindow(
        @Valid @RequestBody PredictiveMaintenanceService.MaintenanceWindowRequest request) {
        return ApiResponse.ok("维护窗口规划完成", service.planWindow(request));
    }
}
